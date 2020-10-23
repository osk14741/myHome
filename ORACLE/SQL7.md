#### Q1.

```SQL
CREATE TABLE tcons (no      NUMBER
                    CONSTRAINT tcons_no_pk      PRIMARY KEY,
                    name    VARCHAR2(20)
                    CONSTRAINT tcons_name_nn    NOT NULL,
                    jumin   VARCHAR2(13)
                    CONSTRAINT tcons_jumin_nn   NOT NULL
                    CONSTRAINT tcons_jumin_uk   UNIQUE,
                    area    NUMBER(1)
                    CONSTRAINT tcons_area_ck    CHECK(area BETWEEN 1 AND 4),
                    deptno  VARCHAR2(6)
                    CONSTRAINT tcons_deptno_fk  REFERENCES dept2(dcode)
                    );
```

- CHECK(area BETWEEN 1 AND 4)
- CHECK(area>=1 AND area<=4)
- 괄호 잘보자



#### Q2.

tcons 테이블의 name 컬럼이 emp2 테이블의 name 컬럼의 값을 참조하도록 참조키 제약 조건을 추가 설정하는 쿼리를 쓰세요.(tcons 테이블이 자식 테이블입니다.)

```sql
ALTER TABLE tcons
ADD CONSTRAINT tcons_name_fk FOREIGN KEY(name)
REFERENCES emp2(name);
--ORA-02270: 이 열목록에 대해 일치하는 고유 또는 기본 키가 없습니다.
--부모 테이블 쪽에 설정되는 칼럼이 primary key이거나 unique key가 설정되어 있어야 한다.
--따라서 아래 행이 선행되어야 함.
--ALTER TABLE emp2
--ADD CONSTRAINT emp2_name_uk UNIQUE(name);
```

- ADD CONSTRAINT 할 때는 얘가 어디에 들어있는지 모름.

- ```
  ADD CONSTRAINT 제약조건이름 옵션
  ```



#### Q3.

tcons 테이블의 jumin 컬럼에 만들어져 있는 unique 제약 조건을 "사용 안 함"으로 변경하되 해당 테이블의 데이터에 DML까지 안 되도록 변경하는 쿼리를 쓰세요.(제약 조건 이름은 tcons_jumin_uk 입니다.)

```sql
ALTER TABLE tcons
DISABLE VALIDATE CONSTRAINT tcons_jumin_uk;
```

- VALIDATE : ENABLE하는 시점까지 입력된 데이터, 이후 입력된 데이터 **모두 무결성 검사**.
- NOVALIDATE : ENABLE하는 시점까지 해당 테이블에 들어 있는 데이터는 검사하지 않고 **ENABLE 하는 시점부터 무결성 검사**.



#### Q4.

위 3번 문제에서 "사용 안 함"으로 설정한 제약 조건 tcons_jumin_uk을 사용함으로 변경하되 기존에 있던 내용과 새로 들어올 내용 모두를 체크하는 옵션으로 변경하세요. 그리고 문제가 되는 데이터들은 scott.exceptions 테이블에 저장하도록 설정하세요.

```sql
ALTER TABLE tcons
ENABLE VALIDATE CONSTRAINT tcons_jumin_uk
EXCEPTIONS INTO exceptions;
```



#### cf) EXCEPTIONS 테이블을 사용하여 ENABLE VALIDATE 하기 - scott 계정 사용

1. scott 사용자로 exceptions table을 생성합니다.

```sql
@?/rdbms/admin/utlexcpt.sql
```

2. 예제용 테이블을 생성한 후 데이터를 입력합니다.

```sql
CREATE TABLE tt551
(no NUMBER, name VARCHAR2(10) CONSTRAINT tt551_name_uk UNIQUE);
ALTER TABLE tt551 DISABLE CONSTRAINT tt551_name_uk;
--tt551_name_uk가 disable(NOVALIDATE) 되었으므로 중복해서 입력 가능.
INSERT INTO tt551 VALUES(1, 'AAA');
INSERT INTO tt551 VALUES(2, 'AAA');
INSERT INTO tt551 VALUES(3, 'AAA');
COMMIT;
```

```
        NO NAME
---------- ----------
         1 AAA
         2 AAA
         3 AAA
```

3. 제약 조건을 ENABLE 시도하여 에러를 확인.

```sql
ALTER TABLE tt551
ENABLE VALIDATE CONSTRAINT tt551_name_uk
EXCEPTIONS INTO exceptions;
--ORA-02299: 제약 (SCOTT.TT551_NAME_UK)을 사용 가능하게 할 수 없음 - 중복 키가 있습니다
```

- name 값에 중복되어 있는 값이 있기 때문에 변경 불가능(VALIDATE 이므로)
- ENABLE 의 기본값은 VALIDATE이다.

4. exceptions table에서 에러 내용을 확인한 후 원본 테이블을 수정합니다. 

```sql
SELECT rowid, name
FROM tt551
WHERE rowid IN (SELECT row_id FROM exceptions);
```

```
ROWID              NAME
------------------ ----------
AAASRyAAEAAABJGAAC AAA
AAASRyAAEAAABJGAAB AAA
AAASRyAAEAAABJGAAA AAA
```

```sql
UPDATE tt551
SET name = 'BBB'
WHERE rowid = 'AAASRyAAEAAABJGAAB';

UPDATE tt551
SET name = 'CCC'
WHERE rowid = 'AAASRyAAEAAABJGAAA';

TRUNCATE TABLE exceptions;
```

5. 다시 제약 조건을 enable 시도합니다.

```sql
ALTER TABLE tt551
ENABLE VALIDATE CONSTRAINT tt551_name_uk
EXCEPTIONS INTO exceptions;
```

- rowid : 데이터베이스에서 데이터마다의 주소를 의미하는 개념이 바로 ROWID다. ROWID는 각가의 데이터를 구분할 수 있는 유일한 ID이기도 하다. 데이터마다 유일하기 때문에 오라클 내부에서는 데이터를 가르키기 위한 주소로 쓰인다.


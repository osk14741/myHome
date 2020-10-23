#### SELECT

```sql
SELECT [컬럼명 또는 표현식] FROM [테이블명, 뷰 명]
```



#### WHERE

```sql
SELECT [Column or Expression] -3

FROM [table of view] -1

WHERE 원하는 조건 -2
```

```sql
SELECT ename,
       sal
FROM emp
WHERE sal < 1000
;
```

- 문자열 및 날짜의 경우 작은 따옴표 안에 넣어야 함.
- 문자열의 대소문자 구분한다.

```sql
SELECT ename,
       empno,
	   sal
FROM emp
WHERE ename = 'SMITH'
;
```

```sql
-- 날짜
-- windows date : 80/12/17
-- unix         : 17-DEC-80
SELECT empno,
       ename,
	   sal,
	   hiredate
FROM emp
WHERE hiredate = '80/12/17'
;
```



#### 연산자

```sql
SELECT empno,ename,sal
FROM emp
WHERE sal LIKE '1%'
;
```

```
     EMPNO ENAME             SAL
---------- ---------- ----------
      7499 ALLEN            1600
      7521 WARD             1250
      7654 MARTIN           1250
      7844 TURNER           1500
      7934 MILLER           1300
```

- 절대로 %나 _를 가장 먼저 쓰면 안된다.



#### 집합 연산자

| 연산자    | 내용                                              |
| --------- | ------------------------------------------------- |
| UNION     | 두 집합의 결과를 합쳐서 출력, 중복 제거, 정렬     |
| UNION ALL | 두 집합의 결과를 합쳐서 출력, 중복 제거 X, 정렬 X |
| INTERSECT | 두 집합의 교집합, 정렬                            |
| MINUS     | 두 집합의 차집합, 순서 중요                       |

- 두 집합에 SELECT절에 오는 컬럼의 개수가 동일.
- 두 집합에 SELECT절에 오는 컬럼의 데이터 형(타입)이 동일.
- 두 집합의 컬럼 명은 달라도 상관 없다.

```sql
SELECT profno,name,deptno,1(데이터 구분)
FROM professor
WHERE deptno=101
UNION
SELECT studno,name,deptno1,2(데이터 구분)
FROM student
WHERE deptno1=101
;
```

```sql
SELECT studno,name
FROM student
WHERE deptno1=101
UNION
SELECT studno,name
FROM student
WHERE deptno2=201
;
--> 중복 불가능. 같은 값이 겹칠 경우 하나만 나온다. ALL의 경우 중복 허용.
```

- UNION -> UNIONALL 많이 연결할수록 성능이 저하됨.(DECODE, CASE로 간결하게 처리.)

```sql
SELECT empno,ename,sal
FROM emp
MINUS
SELECT empno,ename,sal
FROM empp;
WHERE sal>2500
;
```



#### SQL 단일행 함수

1. LENGTH(컬럼 또는 문자열) / LENGTHB(컬럼 또는 문자열)

```sql
SELECT ename, LENGTH(ename) "LENGTH", LENGTHB(ename) "LENGTHB",
		LENGTH('코비드') "LENGTH_HANGUL", LENGTHB('코비드') "LENGTHB_HANGUL"
FROM emp
WHERE deptno=20
;
```

```sql
ENAME          LENGTH    LENGTHB LENGTH_HANGUL LENGTHB_HANGUL
---------- ---------- ---------- ------------- --------------
SMITH               5          5             3              6
JONES               5          5             3              6
FORD                4          4             3              6
```

2. SUBSTR(컬럼 또는 문자열,1,4) : 왼쪽에서 오른쪽으로 검색

```sql
SELECT SUBSTR('abcde',3,2) "3,2",
		SUBSTR('abcde',-3,2) "-3,2",
		SUBSTR('abcde',-3,4) "-3,4"
FROM dual
;

SELECT '오라클' "subject", 
		SUBSTRB('오라클',1,2) "SUBSTRB",
		SUBSTR('오라클',1,2) "SUBSTR"
FROM dual
;
```

```sql
3, -3 -3,
-- -- ---
cd cd cde

subjec SU SUBS
------ -- ----
오라클 오 오라
```

3. INSTR(문자열 또는 컬럼, 찾는 글자, 시작위치, 몇번째인지(기본은 1))

```sql
--Student 테이블에 tel컬럼을 사용하여 1전공번호(deptno1)가 201번인 학생의 이름과 전화번호 ')'가 나오는 위치를 출력하세요.
SELECT name, tel, INSTR(tel,')',1,1) ")의 위치",
		SUBSTR(tel,1,INSTR(tel,')',1)) "국번"
FROM student
WHERE deptno1=201
;
```

```sql
NAME                           TEL               )의 위치 국번
------------------------------ --------------- ---------- -----------------
Demi Moore                     02)6255-9875             3 02)
Macaulay Culkin                02)312-9838              3 02)
Wesley Snipes                  053)736-4981             4 053)
Steve Martin                   02)6175-3945             3 02)
Sean Connery                   02)381-5440              3 02)
Christian Slater               031)345-5677             4 031)
```

4. LPAD(컬럼 또는 문자열, 자리수, '채울 문자')

```sql
--student테이블에서 1전공이 201번인 학생들의 id를 총 10자리로 출력하되 왼쪽 빈자리는 '*' 기호로 채우세요.
SELECT name,id,LPAD(id,10,'*') "LPAD"
FROM student
WHERE deptno1=201
;

--emp 테이블을 사용하여 deptno가 10번인 사원들의 사원이름을 총 9Byte로 출력하되 빈자리는 해당 숫자로 채우세요.
SELECT ename, LPAD(ename,9,'123456789')
FROM emp
WHERE deptno=10
;
```

```sql
NAME                           ID                   LPAD
------------------------------ -------------------- --------------------
Demi Moore                     Moore                *****Moore
Macaulay Culkin                Culkin               ****Culkin
Wesley Snipes                  Snipes               ****Snipes
Steve Martin                   Martin               ****Martin
Sean Connery                   Connery              ***Connery
Christian Slater               Slater               ****Slater

ENAME      LPAD
---------- ------------------
CLARK      1234CLARK
KING       12345KING
MILLER     123MILLER
```

5. RPAD(컬럼 또는 문자열, 자리수, '채울 문자')

```sql
SELECT ename, RPAD(ename,9,SUBSTR('123456789',LENGTHB(ename)+1)) "RPAD"
FROM emp
WHERE deptno=10
;
```

```sql
ENAME      RPAD
---------- ------------------
CLARK      CLARK6789
KING       KING56789
MILLER     MILLER789
```


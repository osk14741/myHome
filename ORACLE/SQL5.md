#### Q1.

```sql
CREATE TABLE new_emp(no NUMBER(5),
                     name VARCHAR2(20),
                     hiredate DATE,
                     bonus NUMBER(6,2));
```

- CREATE TABLE



#### Q2.

```sql
CREATE TABLE new_emp2
AS
SELECT no, name, hiredate
FROM new_emp
;
```

- CREATE TABLE 테이블 명 AS



#### Q3.

```sql
CREATE TABLE new_emp3
AS SELECT * FROM new_emp2
WHERE 1 = 2;
```

- WHERE 조건을 다르게 줘서 헤더만 따오기



#### Q4.

```sql
ALTER TABLE new_emp2
add(birthday DATE DEFAULT SYSDATE);
```

- ALTER



#### Q5.

```sql
ALTER TABLE new_emp2 RENAME COLUMN birthday TO birth;
```



#### Q6.

```sql
ALTER TABLE new_emp2
MODIFY(no NUMBER(7))
;
```



#### Q7.

```sql
ALTER TABLE new_emp2 DROP COLUMN birth;
```



#### Q8.

```sql
TRUNCATE TABLE new_emp2;
```



#### Q9.

```sql
DROP TABLE new_emp2;
```


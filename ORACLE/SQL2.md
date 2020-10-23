#### CASE ... WHEN

```sql
SELECT name,
		jumin,
		CASE WHEN SUBSTR(jumin,3,2) BETWEEN '01' and '03' THEN '1/4'
			WHEN SUBSTR(jumin,3,2) BETWEEN '04' and '06' THEN '2/4'
			WHEN SUBSTR(jumin,3,2) BETWEEN '07' and '09' THEN '3/4'
			WHEN SUBSTR(jumin,3,2) BETWEEN '10' and '12' THEN '4/4'
		END "Quarter"
FROM student
```

```sql
SELECT name,
	CASE SUBSTR(tel,1,INSTR(tel,')')-1) WHEN '02' THEN 'SEOUL'
										WHEN '031' THEN 'GYEONGGI'
										WHEN '051' THEN 'BUSAN'
										WHEN '052' THEN 'ULSAN'
										WHEN '055' THEN 'GYEONGNAM'
										ELSE 'ETC'
	END "LOC02"
FROM student
WHERE deptno1 = 101
;
```

- CASE ***조건*** WHEN 결과1 THEN 출력1
- CASE WHEN ***조건 범위*** THEN 출력1
- CASE WHEN 문 내부에서는 줄 띄움 없이 씀.

```sql
SELECT empno,
		ename,
		sal,
		CASE WHEN sal BETWEEN 1 and 1000 THEN 'LEVEL 1'
		WHEN sal BETWEEN 1001 and 2000 THEN 'LEVEL 2'
		WHEN sal BETWEEN 2001 and 3000 THEN 'LEVEL 3'
		WHEN sal BETWEEN 3001 and 4000 THEN 'LEVEL 4'
		WHEN sal >= 4001 THEN 'LEVEL 5'
		
		<---- 이런 부분 없이 ----> 
		
		END "LEVEL"
FROM emp
ORDER BY sal DESC
;
```



#### REGULAR EXPRESSION(정규식)

| 사용  기호 | 의미                                               | 사용예         |
| ---------- | -------------------------------------------------- | -------------- |
| ^          | 해당 문자로 시작하는                               | '^pattern'     |
| $          | 해당 문자로 끝나는 Line                            | 'pattern$'     |
| .          | S로 시작하고 E로 끝나는 6글자 출력(.  -> one char) | 'S….E'         |
| *          | 모든 이라는 뜻, 0 포함                             | '[a-z]*'       |
| [ ]        | P 혹은 p로 시작하는 문장                           | '[Pp]attern'   |
| [^]        | 해당 문자에 해당하지 않는                          | '[^a-m]attern' |

1. REGEXP_LIKE

```sql
SELECT *
FROM t_reg
--WHERE REGEXP_LIKE(text,'[a-z]')
--WHERE REGEXP_LIKE(text,'[A-Z]')
--WHERE REGEXP_LIKE(text,'[A-Z]{2}')
WHERE REGEXP_LIKE(text,'[A-Za-z]')
;
```



2. REGEXP_REPLACE

- 주어진 문자열에서 특정 패턴을 찾아  다른 모양으로 치환

```sql
col "REGEXP_REPLACE" for a20
SELECT text,REGEXP_REPLACE(text,'[0-9]','*') "REGEXP_REPLACE"
FROM t_reg
;
```



#### SQL 복수행 함수

- 모든 그룹 함수에서 *를 사용하면 NULL 포함, 컬럼 이름을 쓰면 NULL을 포함하지 않는다.

  - count : 건수 출력

  - sum : 데이터의 합계를 구하는 함수
  - avg : 평균을 구하는 함수
  - NULL값이 포함 되어 있으므로 NULL 처리 필요.

```sql
SELECT COUNT(*),
		SUM(comm),
		AVG(NVL(comm,0))
FROM emp
;
```

```sql
SELECT STDDEV(sal),
		VARIANCE(sal),
		AVG(NVL(sal,0))
FROM emp
;
```
























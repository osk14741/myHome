#### Q1.

emp 테이블을 사용하여 사원 중에서 **급여(sal)와 보너스(comm)를 합친 금액**이 **가장 많은 경우**와 **가장 적은 경우**, **평균 금액**을 구하세요. 단, **보너스가 없을 경우는 보너스를 0**으로 계산하고 출력 금액은 모두 **소수점 첫째 자리까지만** 나오게 하세요.

```sql
SELECT MAX(c_data) "MAX",
	   MIN(c_data) "MIN",
	   ROUND(AVG(c_data),1) "AVG"
FROM (
	SELECT(NVL(sal,0) + NVL(comm,0)) c_data
	FROM emp
)
```

- MAX(), MIN(), AVG()
- ROUND(요소, 표시 할 자리) : 반올림 한다.
- NVL(요소,NULL 일 경우 표시할 값)



#### Q2.

student 테이블의 birthday 컬럼을 참조해서 아래와 같이 월별로 생일자 수를 출력하세요.

```
TOTAL JAN  FEB  MAR  APR  MAY  JUN  JUL  AUG  SEP  OCT  NOV  DEC
----- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----
20EA  3EA  3EA  2EA  2EA  0EA  1EA  0EA  2EA  2EA  2EA  1EA  2EA
```

```sql
SELECT  COUNT(*)||'EA' "TOTAL",
        COUNT(DECODE(birth,'01','JAN',NULL))||'EA' "JAN",
		COUNT(DECODE(birth,'02','FEB',NULL))||'EA' "FEB",
		COUNT(DECODE(birth,'03','MAR',NULL))||'EA' "MAR",
		COUNT(DECODE(birth,'04','APR',NULL))||'EA' "APR",
		COUNT(DECODE(birth,'05','MAY',NULL))||'EA' "MAY",
		COUNT(DECODE(birth,'06','JUN',NULL))||'EA' "JUN",
		COUNT(DECODE(birth,'07','JUL',NULL))||'EA' "JUL",
		COUNT(DECODE(birth,'08','AUG',NULL))||'EA' "AUG",
		COUNT(DECODE(birth,'09','SEP',NULL))||'EA' "SEP",
		COUNT(DECODE(birth,'10','OCT',NULL))||'EA' "OCT",
		COUNT(DECODE(birth,'11','NOV',NULL))||'EA' "NOV",
		COUNT(DECODE(birth,'12','DEC',NULL))||'EA' "DEC"
FROM (
	SELECT TO_CHAR(birthday,'MM') as birth
	FROM student
)
;
```

- DECODE(조건칼럼,값1,결과값,아닐때)
- || == +(in java)
- FROM()으로 특정 칼럼만 땡겨올 수 있다.



#### Q4.

emp 테이블을 사용하여 부서별로 직급별로 급여 합계를 출력하세요.

```sql
    DEPTNO      CLERK    MANAGER  PRESIDENT    ANALYST   SALESMAN   TOTAL
---------- ---------- ---------- ---------- ---------- ---------- -------
        10       1300       2450       5000          0          0    8750
        20        800       2975          0       3000          0    6775
        30        950       2850          0          0       5600    9400
(null)           3050       8275       5000       3000       5600   24925
```

```sql
col "TOTAL" for 999999
SELECT deptno,
       SUM(DECODE(job, 'CLERK'    , sal, 0))   "CLERK",
	   SUM(DECODE(job, 'MANAGER'  , sal, 0))   "MANAGER",
	   SUM(DECODE(job, 'PRESIDENT', sal, 0))   "PRESIDENT",
	   SUM(DECODE(job, 'ANALYST'  , sal, 0))   "ANALYST",
	   SUM(DECODE(job, 'SALESMAN' , sal, 0))   "SALESMAN",
	   SUM(NVL2(job,sal,0)) "TOTAL"
FROM emp
GROUP BY rollup(deptno)
;
```

- 각 합의 총 합이 필요할 때는 rollup()을 쓰자.
- GROUP BY 뒤에 오는 컬럼 값을 기준으로 먼저 모아놓고 SELECT 절에 적혀 있는 그룹 함수를 적용함.



#### Q5.

emp 테이블을 사용하여 직원들의 급여와 **전체 급여의 누적 급여금액**이 아래와 같도록 출력하세요. 단, 급여를 **오름차순으로 정렬**해서 출력하세요.

```
    DEPTNO ENAME             SAL   TOTAL
---------- ---------- ---------- -------
        20 SMITH             800     800
        30 JAMES             950    1750
        30 WARD             1250    4250
        30 MARTIN           1250    4250
        10 MILLER           1300    5550
        30 TURNER           1500    7050
        30 ALLEN            1600    8650
        10 CLARK            2450   11100
        30 BLAKE            2850   13950
        20 JONES            2975   16925
        10 Cat              3000   22925
        20 FORD             3000   22925
        10 Tiger            3600   26525
        10 KING             5000   31525
```

```sql
SELECT deptno,
       ename,
       sal,
       SUM(sal) OVER(ORDER BY sal) TOTAL
FROM emp
;
```

- OVER : PARTITION BY(GROUPING) 한 데이터를 정렬해서 뽑는다.
- PARTITION BY : 특정 컬럼 기준으로 데이터를 나눈다.
- 정렬의 기준값이 무엇인지 잘 보자.



#### Q8.

emp 테이블을 사용하여 아래와 같이 **부서별로 급여 누적 합계**가 나오도록 출력하세요. 단, **부서 번호는 오름차순**으로 출력하세요.

```
    DEPTNO ENAME             SAL   TOTAL
---------- ---------- ---------- -------
        10 MILLER           1300    1300
        10 CLARK            2450    3750
        10 Cat              3000    6750
        10 Tiger            3600   10350
        10 KING             5000   15350
        20 SMITH             800     800
        20 JONES            2975    3775
        20 FORD             3000    6775
        30 JAMES             950     950
        30 MARTIN           1250    3450
        30 WARD             1250    3450
        30 TURNER           1500    4950
        30 ALLEN            1600    6550
        30 BLAKE            2850    9400
```

```SQL
SELECT deptno,
       ename,
       sal,
       SUM(sal) OVER(PARTITION BY deptno ORDER BY sal) "TOTAL"
FROM emp
;
```

- PARTITION BY 뒤에 기준이 되는 칼럼이 온다.



#### Q9. 

emp 테이블을 사용하여 아래와 같이 각 사원의 급여액이 전체 **직원 급여 총액에서** **몇 %의 비율**을 차지하는지 출력하세요. 단, **급여 비중이 높은 사람이 먼저** 출력되도록 하세요.

```
    DEPTNO ENAME             SAL  TOTAL_SAL          %
---------- ---------- ---------- ---------- ----------
        10 KING             5000      31525      15.86
        10 Tiger            3600      31525      11.42
        10 Cat              3000      31525       9.52
        20 FORD             3000      31525       9.52
        20 JONES            2975      31525       9.44
        30 BLAKE            2850      31525       9.04
        10 CLARK            2450      31525       7.77
        30 ALLEN            1600      31525       5.08
        30 TURNER           1500      31525       4.76
        10 MILLER           1300      31525       4.12
        30 WARD             1250      31525       3.97
        30 MARTIN           1250      31525       3.97
        30 JAMES             950      31525       3.01
        20 SMITH             800      31525       2.54
```

```sql
SELECT deptno,
       ename,
       sal,
       SUM(sal) OVER() "TOTAL_SAL",
       ROUND(RATIO_TO_REPORT(sal) OVER()*100,2) "%"
FROM emp
ORDER BY "%" DESC
;
```

- RATIO_TO_REPORT(요소) OVER()



#### Q10.

emp 테이블을 조회하여 아래와 같이 각 직원들의 급여가 해당 **부서 합계금액에서** **몇 %의 비중**을 차지하는지를 출력하세요. 단, **부서 번호를 기준으로 오름차순**으로 출력하세요.

```
    DEPTNO ENAME             SAL   SUM_DEPT          %
---------- ---------- ---------- ---------- ----------
        10 CLARK            2450      15350      15.96
        10 Tiger            3600      15350      23.45
        10 MILLER           1300      15350       8.47
        10 KING             5000      15350      32.57
        10 Cat              3000      15350      19.54
        20 SMITH             800       6775      11.81
        20 FORD             3000       6775      44.28
        20 JONES            2975       6775      43.91
        30 WARD             1250       9400       13.3
        30 ALLEN            1600       9400      17.02
        30 TURNER           1500       9400      15.96
        30 JAMES             950       9400      10.11
        30 BLAKE            2850       9400      30.32
        30 MARTIN           1250       9400       13.3
```

```sql
SELECT deptno,
       ename,
       sal,
       SUM(SAL) OVER(PARTITION BY deptno ORDER BY deptno) "SUM_DEPT",
       ROUND(RATIO_TO_REPORT(sal) OVER(PARTITION BY deptno)*100,2) "%"
FROM emp
;
```

- RATIO_TO_REPORT 도 마찬가지로 OVER(PARTITION BY 특정 칼럼)을 쓴다.



#### Q12.

loan 테이블을 사용하여 전체 지점의 대출종목코드, 대출지점, 대출일자, 대출건수, 대출액을 **대출코드와 대출지점별로 누적 합계**를 구하시오.

```
대출종목코드    대출지점   대출일자  대출건수  대출액  누적대출금액
------------ -------- -------- -------- ------ ------------
         100 1000     20110101        3   2400         2400
         100 1000     20110103        2   1600         4000
         100 1001     20110103        3   2400         2400
         100 1002     20110104        2   1600         1600
         100 1003     20110104        4   3200         3200
         100 1004     20110103       10   8000         8000
         100 1004     20110104        5   4000        12000
         101 1001     20110101        5   4500         4500
         101 1001     20110104        3   2700         7200
         101 1002     20110104        4   3600         3600
         101 1003     20110103        4   3600         3600
         101 1003     20110104        3   2700         6300
         102 1000     20110102        2   2000         2000
         102 1001     20110104        4   4000         4000
         102 1002     20110104        2   2000         2000
         102 1003     20110101        2   2000         2000
         103 1002     20110102        5   4500         4500
         103 1003     20110104        2   1800         1800
         103 1004     20110101        6   5400         5400
         104 1002     20110102        3   2400         2400
         105 1000     20110102        2   3000         3000
```

```sql
SELECT l_code "...",
       l_store "...",
       l_date "...",
       l_qty "...",
       l_total "...",
       SUM(l_total) OVER(PARTITION BY l_code,l_store ORDER BY l_date) "..."
FROM loan
;
```

- 어떤 것을 기준으로 누적 합계가 잡히는지, 그리고 어떤 순서대로 정렬되는지.



#### Q14.

professor 테이블에서 각 교수들의 급여를 구하고 **각 교수의 급여액이 전체 교수의 급여 합계에서 차지하는 비율**을 출력하세요.

```
    DEPTNO NAME                        PAY  TOTAL PAY    RATIO %
---------- -------------------- ---------- ---------- ----------
       201 Meryl Streep                570       5920       9.63
       101 Audie Murphy                550       5920       9.29
       103 Emma Thompson               530       5920       8.95
       203 Meg Ryan                    500       5920       8.45
       102 Whoopi Goldberg             490       5920       8.28
       101 Angela Bassett              380       5920       6.42
       102 Michelle Pfeiffer           350       5920       5.91
       103 Julia Roberts               330       5920       5.57
       201 Susan Sarandon              330       5920       5.57
       202 Nicole Kidman               310       5920       5.24
       103 Sharon Stone                290       5920        4.9
       301 Jodie Foster                290       5920        4.9
       101 Jessica Lange               270       5920       4.56
       202 Holly Hunter                260       5920       4.39
       102 Winona Ryder                250       5920       4.22
       301 Andie Macdowell             220       5920       3.72
```

```SQL
SELECT deptno,
       name,
       pay,
       SUM(pay) OVER() "TOTAL PAY"
       ROUND(RATIO_TO_REPORT(pay) OVER()*100,2) "RATIO %"
FROM professor
ORDER BY "RATIO %" DESC
;
```



#### Q15.

professor 테이블을 조회하여 학과번호, 교수명, 급여, 학과별 급여 합계를 구하고 각 교수의 급여가 해당 **학과별 급여 합계에서 차지하는 비율**을 출력하세요.

```
    DEPTNO NAME                        PAY TOTAL_DEPTNO   RATIO(%)
---------- -------------------- ---------- ------------ ----------
       101 Angela Bassett              380          380      31.67
       101 Audie Murphy                550          930      45.83
       101 Jessica Lange               270         1200       22.5
       102 Michelle Pfeiffer           350          350      32.11
       102 Whoopi Goldberg             490          840      44.95
       102 Winona Ryder                250         1090      22.94
       103 Emma Thompson               530          530      46.09
       103 Julia Roberts               330          860       28.7
       103 Sharon Stone                290         1150      25.22
       201 Meryl Streep                570          570      63.33
       201 Susan Sarandon              330          900      36.67
       202 Holly Hunter                260          260      45.61
       202 Nicole Kidman               310          570      54.39
       203 Meg Ryan                    500          500        100
       301 Andie Macdowell             220          220      43.14
       301 Jodie Foster                290          510      56.86
```

```SQL
SELECT deptno,
       name,
       pay,
       SUM(pay) OVER(PARTITION BY deptno ORDER BY name),
       ROUND(RATIO_TO_REPORT(pay) OVER(PARTITION BY deptno)*100,2) "RATIO %"
FROM professor
;
```



#### ROLLUP()

- 각 기준별 소계를 요약해서 보여 줌.

```SQL
SELECT deptno, job, ROUND(AVG(sal),1) avg_sal, COUNT(*) cnt_emp
FROM emp
GROUP BY ROLLUP(deptno, job)
;
```

- GROUP BY 뒤에 오는 컬럼 값을 기준으로 먼저 모아놓고 SELECT 절에 적혀 있는 그룹 함수를 적용함.



#### DECODE()

- IF문

1. 유형 1 - A가 B일 경우 '1'을 출력하는 경우

```SQL
DECODE(A, B, '1', null) (단, 마지막 null은 생략 가능합니다.)
```

```SQL
SELECT deptno, name, DECODE(deptno, 101, 'COMPUTER ENGINEERING') "DNAME"
FROM professor
;
```

```
    DEPTNO NAME                 DNAME
---------- -------------------- --------------------
       101 Audie Murphy         COMPUTER ENGINEERING
       101 Angela Bassett       COMPUTER ENGINEERING
       101 Jessica Lange        COMPUTER ENGINEERING
       102 Winona Ryder         (null)
       102 Michelle Pfeiffer    (null)
       102 Whoopi Goldberg      (null)
       103 Emma Thompson        (null)
       103 Julia Roberts        (null)
       103 Sharon Stone         (null)
       201 Meryl Streep         (null)
       201 Susan Sarandon       (null)
       202 Nicole Kidman        (null)
       202 Holly Hunter         (null)
       203 Meg Ryan             (null)
       301 Andie Macdowell      (null)
       301 Jodie Foster         (null)
```

2. 유형 2 - A 가 B일 경우 '1'을 출력하고 아닐 경우 '2'를 출력하는 경우

```
DECODE(A, B, '1', '2')
```

3. 유형 3 - A가 B일 경우 '1'을 출력하고 A가 C일 경우 '2'를 출력하고 둘 다 아닐 경우 '3'을 출력하는 경우

```
DECODE(A, B, '1', C, '2', '3')
```

4. 유형 4 - A가 B일 경우 중에서 C가 D를 만족하면 '1'을 출력하고 C가 D가 아닐 경우 NULL을 출력하는 경우(DECODE 함수 안에 DECODE 함수가 중첩되는 경우)

```
DECODE(A, B, DECODE(C, D, '1', NULL))
```

```SQL
SELECT deptno,
       name,
       DECODE(deptno,101,DECODE(name,'Audie Murphy','BEST!')) "ETC"
FROM professor
;
SELECT DECODE(deptno,1,'a',2,'b',3,'c',101,'right')
```

5. 이런식으로 여러개 할 수도 있다. 

```
DECODE(A, B, '1', C, '2', D, '3', ... ,NULL)
```














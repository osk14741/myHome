#### Q1.

학생 테이블(student)과 학과 테이블(department)을 사용하여 학생 이름, 1전공 학과 번호(deptno1), 1전공 학과 이름을 출력하세요.

```
STU_NAME             DEPTNO1 DEPT_NAME
----------------- ---------- ---------------------------------------------
James Seo                101 Computer Engineering
Rene Russo               102 Multimedia Engineering
Sandra Bullock           103 Software Engineering
Demi Moore               201 Electronic Engineering
Danny Glover             202 Mechanical Engineering
Billy Crystal            101 Computer Engineering
Nicholas Cage            102 Multimedia Engineering
Micheal Keaton           202 Mechanical Engineering
Bill Murray              301 Library and Information science
Macaulay Culkin          201 Electronic Engineering
Richard Dreyfus          101 Computer Engineering
Tim Robbins              102 Multimedia Engineering
Wesley Snipes            201 Electronic Engineering
Steve Martin             201 Electronic Engineering
Daniel Day-Lewis         301 Library and Information science
Danny Devito             101 Computer Engineering
Sean Connery             201 Electronic Engineering
Christian Slater         201 Electronic Engineering
Charlie Sheen            102 Multimedia Engineering
Anthony Hopkins          103 Software Engineering
```

```SQL
SELECT s.name,
       s.deptno1,
       d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno;
```

- 조건절을 잘 쓰자



#### Q2.

emp2 테이블과 p_grade 테이블을 조회하여 현재 직급이 있는 사원의 이름과 직급, 현재 연봉, 해당 직급의 연봉의 하한 금액과 상한 금액을 아래 결과 화면과 같이 출력하세요.

```
NAME              POSITION                      PAY       Low Pay     High Pay
----------------- ------------------------- ----------- ----------- -----------
AL Pacino         Department head            72,000,000  60,010,000  75,000,000
Woody Harrelson   Section head               50,000,000  45,010,000  51,000,000
Tommy Lee Jones   Deputy department head     60,000,000  51,010,000  60,000,000
Gene Hackman      Section head               56,000,000  45,010,000  51,000,000
Kevin Bacon       Department head            75,000,000  60,010,000  75,000,000
Hugh Grant        Section head               51,000,000  45,010,000  51,000,000
Keanu Reeves      Deputy Section chief       35,000,000  30,000,000  45,000,000
Val Kilmer        Department head            68,000,000  60,010,000  75,000,000
Chris O'Donnell   Section head               49,000,000  45,010,000  51,000,000
```

```sql
SELECT e.name,
       e.position,
       TO_CHAR(e.pay,'FM999,999,999') "PAY",
       TO_CHAR(p.s_pay,'FM999,999,999') "Low Pay",
       TO_CHAR(p.e_pay,'FM999,999,999') "High Pay"
FROM emp2 e, p_grade p
WHERE e.position = p.position;
```

- 조건절을 잘 쓰자.
- TO_CHAR(요소,'형태')



#### Q3.

emp2 테이블과 p_grade 테이블을 조회하여 사원들의 이름과 나이, 현재 직급, 예상 직급을 출력하세요. 예상 직급은 나이로 계산하며 해당 나이가 받아야 하는 직급을 의미합니다. 나이는 오늘(SYSDATE)을 기준으로 하되 TRUNC로 소수점 이하는 절삭하여 계산하세요.

```
NAME                     AGE CURR_POSITION                  BE_POSITION
----------------- ---------- ------------------------------ ------------------------------
Jack Nicholson            35 (null)                         Deputy department head
Denzel Washington         37 (null)                         Department head
Richard Gere              38 (null)                         Department head
Harrison Ford             39 (null)                         Department head
Kevin Costner             39 (null)                         Department head
Tom Cruise                39 (null)                         Department head
Clint Eastwood            39 (null)                         Department head
Sly Stallone              40 (null)                         Department head
JohnTravolta              40 (null)                         Department head
Robert De Niro            40 (null)                         Department head
Val Kilmer                43 Department head                Director
Tommy Lee Jones           44 Deputy department head         Director
Woody Harrelson           45 Section head                   Director
Chris O'Donnell           47 Section head                   Director
AL Pacino                 47 Department head                Director
Gene Hackman              47 Section head                   Director
Keanu Reeves              48 Deputy Section chief           Director
Hugh Grant                48 Section head                   Director
Kevin Bacon               48 Department head                Director
Kurt Russell              56 Boss                           (null)
```

```sql
SELECT e.name,
       TRUNC((SYSDATE-e.birthday)/365,0) "AGE",
       e.position "CURR_POSITION",
       p.position "BE_POSITION"
FROM emp2 e, p_grade p
WHERE TRUNC((SYSDATE-e.birthday)/365,0) BETWEEN s_age(+) and e_age(+)
ORDER BY 2
;
```

- WHERE 기준 컬럼 BETWEEN A AND B
- OUTER JOIN을 할 땐, 영향이 가는 모든 기준에 (+)를 붙여야 한다. 하나라도 붙이지 않으면 일반 JOIN이 됨.



#### Q4.

customer 테이블과 gift 테이블을 Join 하여 고객이 자기 포인트보다 낮은 포인트의 상품 중 한 가지를 선택할 수 있다고 할 때, Notebook을 선택할 수 있는 고객명과 포인트, 상품명을 출력하세요.

```
CUST_NAME              POINT GIFT_NAME
----------------- ---------- --------------------
James Seo             980000 Notebook
Winona Ryder          625000 Notebook
Michelle Pfeiffer     670000 Notebook
```

```sql
SELECT c.gname,
       c.point,
       g.gname
FROM customer c, gift g
WHERE c.point >= g.g_start AND g.gname = 'Notebook'
;
```



#### Q5.

professor 테이블에서 교수의 번호, 교수 이름, 입사일, 자신보다 입사일 빠른 사람 인원수를 출력하세요. 단, 자신보다 입사일이 빠른 사람 수를 오름차순으로 출력하세요.

```
    PROFNO NAME              TO_CHAR(P1 COUNT(P2.HIREDATE)
---------- ----------------- ---------- ------------------
      1001 Audie Murphy      1980/06/23                  0
      3001 Emma Thompson     1981/10/23                  1
      4001 Meryl Streep      1981/10/23                  1
      2003 Whoopi Goldberg   1982/04/29                  3
      4005 Meg Ryan          1985/09/18                  4
      2002 Michelle Pfeiffer 1985/11/30                  5
      1002 Angela Bassett    1987/01/30                  6
      3002 Julia Roberts     1997/07/01                  7
      1003 Jessica Lange     1998/03/22                  8
      4003 Nicole Kidman     1999/12/01                  9
      4007 Jodie Foster      2001/05/23                 10
      2001 Winona Ryder      2001/09/01                 11
      3003 Sharon Stone      2002/02/24                 12
      4004 Holly Hunter      2009/01/28                 13
      4002 Susan Sarandon    2009/08/30                 14
      4006 Andie Macdowell   2010/06/28                 15
```

```sql
SELECT p1.profno,
       p1.name,
       TO_CHAR(p1.hiredate,'yyyy/mm/dd') "HIREDATE",
       COUNT(p2.hiredate) "COUNT"
FROM professor p1, professor p2
WHERE p1.hiredate > p2.hiredate(+)
GROUP BY p1.profno, p1.name, p1.hiredate
ORDER BY 3
;
```

- TO_CHAR(요소, '형태')
- COUNT는 그룹 함수다. 쓰려면 GROUP BY를 하자.
- 값이 NULL인 요소, 위 예제에서 Audie Murphy의 경우 WHERE 절에 의해 걸러졌으므로 OUTER JOIN을 이용하여 추가한 것.
- WHERE 절의 아우터 조인되는 컬럼들에 대해 **모두** 아우터 연산자(+)를 붙여야 함.
- **데이터가 없을 수도 있는 쪽** JOIN 컬럼에 (+)를 추가하여야 한다.
- ORDER BY 열 순서



#### Q6.

emp 테이블에서 사원번호, 사원이름, 입사일, 자신보다 먼저 입사한 사람 인원수를 출력하세요. 단, 자신보다 입사일이 빠른 사람수를 오름차순으로 출력하세요.

```
     EMPNO ENAME      HIREDATE      COUNT
---------- ---------- -------- ----------
      1000 Tiger      (null)            0
      2000 Cat        (null)            0
      7369 SMITH      80/12/17          0
      7499 ALLEN      81/02/20          1
      7521 WARD       81/02/22          2
      7566 JONES      81/04/02          3
      7698 BLAKE      81/05/01          4
      7782 CLARK      81/06/09          5
      7844 TURNER     81/09/08          6
      7654 MARTIN     81/09/28          7
      7839 KING       81/11/17          8
      7902 FORD       81/12/03          9
      7900 JAMES      81/12/03          9
      7934 MILLER     82/01/23         11
```

```SQL
SELECT e1.empno,
       e1.ename,
       e1.hiredate,
       COUNT(e2.hiredate) "COUNT"
FROM emp e1, emp e2
WHERE e1.hiredate > e2.hiredate(+)
GROUP BY e1.empno, e1.ename, e1.hiredate
ORDER BY 4
;
```

- 값이 NULL인 요소, 위 예제에서 Audie Murphy의 경우 WHERE 절에 의해 걸러졌으므로 OUTER JOIN을 이용하여 추가한 것.
- WHERE 절의 아우터 조인되는 컬럼들에 대해 **모두** 아우터 연산자(+)를 붙여야 함.
- **데이터가 없을 수도 있는 쪽** JOIN 컬럼에 (+)를 추가하여야 한다.
- ORDER BY 열 순서
- SELECT A FROM B WHERE C : C 조건으로 B에서 A를 SELECT한다. 
- GROUP BY 뒤에 오는 컬럼 값을 기준으로 먼저 모아놓고 SELECT 절에 적혀 있는 그룹 함수를 적용함.
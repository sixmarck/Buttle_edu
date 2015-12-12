/*2015/11/26 sql  10문제 과제*/

--1.  상사가 있는 경우, 사원의 이름과 상사의 사번을 출력하시오.
select ename, mgr from emp where mgr is not null;

--2. 업무가 clerk이고 80년도에 입사한 사원의 이름과 연봉을 출력하시오.
select ename, sal*12+nvl(comm,0) as 연봉 from emp where job = 'CLERK' and '80' = to_char(hiredate, 'YY');

--3. 부서번호가 20인 사원의 이름을 오름차순으로 출력하시오.
select ename from emp where deptno='20' order by ename;

--4. 연봉이 16000 이상 이고, 보너스가 존재하는 사원의 이름과 급여, 보너스 정보를 출력하시오.
select ename, sal, (sal*12), comm from emp where (sal*12) >= 16000 and comm is not null;

--5. 업무 이름에 A가 들어가는 사원의 이름과 업무를 출력하시오.
select ename, job from emp where job like '%A%';

--6. 부서 번호가 20 또는 30이고 부서위치에 L이 들어가는 부서명을 출력하시오.
select dname from dept where deptno in(20, 30) and loc like '%L%';

--7. 사원명에 M과 T가 들어가는 사원의 모든 정보를 출력하시오.
select * from emp where ename like '%M%' and ename like'%T%';

--8.보너스가 300에서 500 사이인 사원의 이름과 연봉을 출력하시오 (연봉을 기준으로 내림차순.)
select ename, (sal*12)+nvl(comm, 0) as 연봉 from emp where comm between 300 and 500 order by 연봉 desc;

--9. 입사일이 12월인 사람의 이름, 업무, 입사일을 출력하시오(입사일을 기준으로 오름차순.)
select ename, job, hiredate from emp where '12' = to_char(hiredate, 'mm') order by hiredate;

select ename, job, hiredate from emp where hiredate like '__/12/__' order by hiredate desc;

select ename, job, hiredate from emp where hiredate between '80/12/01' and '80/12/31' or hiredate between '81/12/01' and '81/12/31' order by hiredate;

--10.부서명이 S로 끝나는 부서명과 부서위치를 출력하시오.
select dname, loc from dept where dname like '%S';
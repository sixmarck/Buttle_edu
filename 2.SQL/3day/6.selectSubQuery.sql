-- 6.selectSubQuery.sql
/* 학습내용
1. subquery - main query 내부에 또다른 쿼리 
2. 용어
	- DQL[query], 질의 : select
	- DML : insert/update/delete
3. 고려사항
	- main 쿼리와 sub 쿼리 중 어떤 쿼리가 실행 우선권?
*/
-- 1. SMITH가 근무하는 부서명 검색
select dname
from dept
where deptno = (select deptno from emp where ename = 'SMITH');

-- 2. ? SMITH와 급여가 동일하거나 더 많은 사원의 이름, 급여 검색
	-- 힌트 : main와 sub쿼리 사이에 다양한 연산자 사용가능
select ename, sal
from emp
where sal >= (select sal from emp where ename='SMITH') and ename <> 'SMITH';

-- 3. ? DALLAS에 근무하는 사원의 이름, 부서번호 검색
select ename, deptno
from emp
where deptno = (select deptno from dept where loc='DALLAS');


-- 4. ? 평균급여(avg()) 보다 더 많이 받는 사원의 모든 정보 검색(emp tblae에서만 검색)
select * 
from emp
where sal > (select avg(sal) from emp);


-- 5. ? 급여가 3000이상인 사원이 소속된 부서(여러개)에 속한 사원명, 급여 검색
	-- 힌트 : in 연산자 활용
select ename, sal
from emp
where deptno in (select deptno from emp where sal >= 3000);

-- 6. ? in 연산자를 이용해서 부서별로 가장 급여를 많이 받는 사원의 정보(사번, 사원명, 급여, 부서번호) 검색
select empno, ename, sal, deptno
from emp
where sal in (select max(sal) from emp group by deptno);
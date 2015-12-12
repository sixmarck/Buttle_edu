-- 5.join.sql
/* 학습내용
1. 다중 table의 데이터들을 공통된 데이터를 기준으로 검색할때 사용하는 기법
2. 활용 table
	1. emp : 사원정보 table
	2. dept : 부서정보 table
	3. salgrade : 급여등급 table
3. 종류
	1. 동등조인
		- 사용빈도가 가장 높다
		- = 동등비교 연산자
	2. not-equi 조인
		- between ~ and
	3. self 조인
		- 동일한 table상에서의 조인
		- 권장사항 - 하나의 table의 다수의 table처럼 가상으로 분리
				이때 사용 기법 table에 별칭 적용
	4. outer 조인
		- null값을 보유한 데이터도 검색
		- self 또는 서로 다른 table상에서도 조인 작업 가능
		- * oracle DB는 검색 결과에서 null인 쪽에 (+) 기호 적용
			다른 DB일부는 데이터가 null이 아닌쪽에 붙이기도함
		*** 결론 - 어떤 db사용하느냐에 따라 test 필수
*/
-- ***[equi join]***
-- 1. SMITH가 소속된 부서의 부서번호와 위치(loc) 검색
select a.deptno, b.loc 
from emp a, dept b
where a.deptno = b.deptno and a.ename = 'SMITH';

-- 2. SMITH에 대한 모든 정보 검색(부서명, 부서위치)
-- * 로 검색시에 각 table에 존재하는 모든 컬럼 데이터 검색 따라서 중복 컬럼 검색 배재시 컬럼명 하나씩 명시 권장
select a.*, b.*
from emp a, dept b
where a.deptno = b.deptno and a.ename = 'SMITH';

-- 3. ? NEW YORK 에 근무하는 사원들 이름(ename)과 입사일(hiredate) 검색
select a.ename, a.hiredate
from emp a, dept b
where a.deptno = b.deptno and b.loc = 'NEW YORK';

-- 4. ? ACCOUNTING 부서에 소속된 사원의 이름과 급여 검색
select a.ename, a.sal
from emp a, dept b
where a.deptno = b.deptno and b.dname='ACCOUNTING';

-- 5. ? 직급이 MANAGER인 사원의 이름, 부서명 검색
select a.ename, b.dname
from emp a, dept b
where a.deptno = b.deptno and a.job = 'MANAGER';

-- ***[not-equi join]***
-- 6. ? 각 사원들의 급여와 급여 등급 검색
select a.ename, a.sal, b.grade
from emp a, salgrade b
where a.sal between b.losal and b.hisal;

-- 7. ? 등급이 3등급인 사원들의 이름과 급여 검색
select a.ename, a.sal
from emp a, salgrade b
where a.sal between b.losal and b.hisal and b.grade = 3;

-- ***[self join]***
-- 8. SMITH 사원의 상사이름 검색해보기
	/* 검색 tip : self join시에는 하나의 table 여러개로 간주
	단, 논리적으로 table에 별칠 적용
	가령 사원 table의 별칭 a, 상사 table의 별칭 b
	*/
select a.empno, a.ename, b.ename
from emp a, emp b
where a.mgr = b.empno;

-- 9. ? 상사가 KING인 사원들의 이름과 job 검색
select e.ename, e.job
from emp e, emp m
where m.empno = e.mgr and m.ename='KING';

-- 10. ? SMITH와 동일한 근무지에서 근무하는 사원의 이름 검색
select a.ename
from emp a, dept b
where a.deptno = b.deptno and b.loc = 'DALLAS';

select f.ename
from emp e, emp f
where e.ename='SMITH' and e.deptno = f.deptno
and f.ename != 'SMITH';

select a.ename
from emp a, dept b
where a.deptno = b.deptno and b.loc in
( select b.loc from emp a, dept b where a.deptno = b.deptno and a.ename = 'SMITH');

-- 11. ? CLARK 사원보다 늦게 입사한 사원들의 정보를 검색 (이름, 입사일 단, 입사일에 따라 오름차순 정렬)

select b.ename, b.hiredate
from emp a, emp b
where a.ename = 'CLARK' and b.hiredate > a.hiredate
order by hiredate asc;


-- 태경 ) 상사가 blake인 사원들의 평균 연봉을 구하시오.
select avg(e.sal*12)
from emp e, emp m
where m.ename = 'BLAKE' and e.mgr = m.empno;

-- ***[outer join : 외부조인]***
-- 12. +기호를 사용해서 null 데이터를 보유하고 있는 컬럼까지도 검색하고자 할 경우 권장
select ename, d.deptno, dname
from emp, dept
where emp.deptno(+) = dept.deptno;

-- 13.? 모든 사원명과 해당하는 사원의 상사명, 단 상사가 없는 사원이라도 검색
	-- KING은 상사가 없는 사원
select e.empno, e.ename, m.ename
from emp e, emp m
where m.empno(+) = e.mgr;

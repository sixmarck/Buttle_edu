-- 4.selectGroupFunction.sql
/* 학습내용
1. 그룹함수
	- 다수의 행 값을 처리해서 하나의 결과값만 반환해주는 함수
	- 복수행 함수, 다중행 함수
	- 장점  : null 값은 철저히 자동 배제후 처리
		가령 10번 부서에 com받는 사원 미존재일 경우 count() 결과는 0값으로 검색

2. 종류
	1. count()
	2. sum()
	3. avg()
3. 문법
	1. select 함수 ... from table;
	2. 복수행 함수 사용시 특정 컬럼 기준으로 그룹별 적용 기법
		select 절
		from 절
		[where 절]
		group by 절	- 그룹함수 사용을 위한 특정 조거의 집합
					(가령, 10번 부서끼리... 20번 부서 끼리...)
		[having 절]		- 그룹함수를 적용한 sql문장의 조건식
		[order by 절]
*/
-- 1. count() : 개수 확인 함수
	-- emp table에는 몇명의 직원이 존재?
select count(*) from emp;

-- 2. empno 라는 컬럼으로 count() 함수 실행
select count(empno) from emp;

-- 3. comm 즉 null을 보유한 컬럼으로 count() 함수 실행
	-- comm 받는 직원수는?
	-- null을 보유한 컬럼은 자동 배제되어 검색
select count(comm) from emp;

-- 4. null값을 자동 배제하는게 맞나? 확인을 sum() 함수로 test
select sum(sal) fromemp
	-- null 값 제외한 결과합이 검색
select sum(comm) from emp;

-- 5. ? 직원들의 연봉(sal)의 평균 계산해 보기
select avg(sal) from emp;

select (sum(sal)/12)*count(*) from emp;

-- 6. ? emp table에서 사원이 소속된 부서개수 단, 중복제거
select distinct deptno from emp;

-- 7. ? MANAGER 사원들만의 급여합 검색하기
select sum(sal) 
from emp
where job='MANAGER';

-- 8. ? comm받는 사원수, 총 커미션합, 커미션 평균 검색
select count(comm), sum(comm), avg(comm)
from emp;

-- 9. min(), max() 함수 적용해서 문제 만들어 보기
	-- 근무일수가 가장 오래된 직원, 적은 직원 검색

-- 10. ? 부서별 급여 평균 검색
select deptno, avg(sal) from emp group by deptno;

-- deptno 오름차순 정렬
select deptno, avg(sal) from emp group by deptno order by deptno;

-- 11. ? 소속 부서별 최대 급여, 최소 급여 검색, 오름차순 정렬
select deptno, max(sal), min(sal)
from emp
group by deptno
order by deptno;

-- 12. ? 부서별 사원수, 커미션 받는 사원수 검색
select deptno, count(*), count(comm)
from emp
group by deptno;

-- 13. ? 부서별 평균 급여가 2000이상인 부서의 부서 번호와 평균 급여 검색
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 2000;

-- deptno 기준으로 오름차순 정렬
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 2000
order by deptno;

-- 14. ? 부서별 급여 평균 검색 sal 급여 평균이 2000이상인 부서 단 10번 부서 직원들 제외
select deptno, avg(sal)
from emp
where deptno <> 10
group by deptno
having avg(sal) > 2000;

-- 15. ? 입사월별 인원수 검색, 단 인원수가 3명인 달에 한해서만 검색
select to_char(hiredate, 'mm'), count(*)
from emp
group by to_char(hiredate, 'mm')
having count(*) = 3;


select to_char(hiredate, 'mm'), count(*)
from emp
group by to_char(hiredate, 'mm')
having 2 = 3;
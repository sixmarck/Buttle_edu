-- 2.select.sql

/* emp table - 사원정보 테이블
	empno	: 사원
	ename	: 이름
	job		: 업무
	mgr		: 상사의 사번
	hiredate	: 입사일
	sal		: 월급여
	comm	: 보너스(*영업 사원만 존재만 알며, 지급 무, 영업사원 이외에는 null(blank)로 인식)
	deptno	: 부서번호

	dept table - 부서 정보 table
	deptno	: 부서번호
	dname	: 부서명
	loc		: 부서 위치

	select 문장
		[1] select 절
			from 절
		
		[2] 특정 컬럼 정렬하기
			(asc : 오름차순, desc : 내림차순)
			select 절
			from절
			order by절

		[3] 조건식 : where
			select 절
			from절
			where절

		[4] 조건식 & 정렬
			(asc : 오름차순, desc : 내림차순)
			select 절
			from절
			where절
			order by절

*/

-- set linesize 200
-- set pagesize 200

-- purge recyclebin;
-- 쓰레기통에 있는 파일을 제거(?)

-- 1. 존재하는 table 종류들 검색
select * from tab;

-- 2. emp table의 모든 정보 검색
select * from emp;

-- 3. emp table의 구조 확인
desc emp;

-- 4. dept table의 구조 확인
desc dept;

-- 5. emp와 dept table의 관계를 통한 검색
select ename, sal*12, (sal*12)+comm from emp;
select ename, sal*12, (sal*12) + NVL(comm, 0) from emp;

-- 6. emp table 사번(empno), 이름(ename), 연봉 (sal*12) 검색
select empno, ename, sal*12 form emp;

-- 7. 검색한 컬럼의 별칭 부여 : emp table 사번(empno), 이름(ename), 연봉 (sal*12) 검색
select empno, ename, (sal*12) as 연봉 form emp;
select empno, ename, (sal*12) 연봉 form emp;
select empno, ename, sal*12 as 연봉 form emp;

-- 8. emp에서 직원들이 소속된 부서번호 검색, 단, 중복 데이터 검색되면 안됨
select distinct deptno from emp;

-- 9. emp에서 직원들이 소속된 부서번호 검색, 단, 중복 데이터 검색되면 안됨
  -- 단, 내림차순 검색
  -- 추가 키워드 : asc - 오름차순, desc - 내림차순
select distinct deptno from emp;

-- 10. ? 사원명, 사번 검색 단 사번은 내림, 오름차순으로 두번 검색
	-- 검색된 컬럼의 별칭으로도 정렬 가능
select ename, empno
from emp
order by epno desc;

select ename, empno
from emp
order by empno asc;

select ename, empno as 사번
from emp
order by 사번 asc;

-- 11. 이름(알파벳) 내림차순 정렬
select ename from emp;
select ename from emp order by ename desc;

-- 12. hiredate(입사일=Date타입) 오름차순(asc), 내림차순(desc) 정렬
select hiredate from emp order by hiredate;
select hiredate from emp order by hiredate desc;

*** [조건식 & 연산] ***
-- 13. comm이 null인 사원 번호와 부서 번호 검색하기
select empno, deptno, comm from emp;

select empno, deptno, comm
from emp
where comm is null;

select empno, deptno
from emp
where comm is null;

-- 14. comm이 null이 아닌 사원번호와 부서번호 검색하기
	-- not 키워드
select empno, deptno from emp where comm is not null;

-- 15. ? comm이 null이 아닌 사원번호와 부서번호 검색, 단 사번은 내림차순
select empno, deptno 
from emp 
where comm is not null 
order by empno desc;

-- 16. ? emp table에서 부서번호(deptno)가 20번 부서에 속한 모든 사원의 이름과 부서번호 검색
  -- = : 동등비교 연산자
select ename, deptno from emp where deptno = 20;

-- 17. ? 스미스 사원의 모든 정보 검색(emp)

-- 18. ? sal가 900이상인 사원명과 급여 검색
	-- sql에서도 사칙 및 비교연산자 사용가능
select ename, sal from emp where sal >= 900;

-- 19.? deptno가 10 이고 job이 매니져인 사원이름 검색
   -- and
select ename from emp where deptno = 10 and job='MANAGER';

-- 20.? deptno가 10 이거나 job이 매니저인 사원이름 검색
   -- or
select ename from emp where deptno = 10 or job='MANAGER'; 

-- 21.? deptno가 10이 아닌 모든 사원명 검색
   --부정연산자 : !=,<> , not
select ename from emp deptno <> 10;

-- 22.? sal이 2000이하이거나 3000이상인 사원명, 급여 검색
   -- 대소비교 연산자 활용 가능
select ename, sal from emp where sal <= 2000 or 3000 >= sal;

-- 23.? comm이 300 or 500 or 1400 사원명, comm검색
select ename, comm from emp where comm in(300, 500, 1400);

-- 24.? 81년도에 입사한 사원이름, 입사일 검색
	-- data타입의 value도 ' ' 표현가능
select ename, hiredate from emp where '81' = to_char(hiredate, 'YY');


-- 25. 검색단어가 포함된 데이터들 검색용 연산자
	-- like : 단, _표기 = 음절수, %는 음절개수 제한이 업음
select ename from emp where ename like 'S';
select ename from emp where ename like 'S_';
select ename from emp where ename like 'S__';
select ename from emp where ename like 'S___';
select ename from emp where ename like 'S____';
select ename from emp where ename like 'S%';

-- 26.? 음절수와 무관하게 M 음절이 포함된 사원명 검색
select ename from emp where ename like '%M%';
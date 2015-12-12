/* 1.
    emp 테이블에서 이름, 급여, 수당, 총액을 구하여 총액이 많은 순서데로 출력하라.
    단, 수당이 널인 사람은 제외시키며, 총액은 급여에 수당을 합한 금액이다.
    총액 = 급여 + 수당
*/
select ename,
	sal,
	comm,
	sal+comm as 총액 
from emp 
where comm is not null
order by 총액 desc;

/* 2.
    10번 부서의 모든 사람들에게 급여의 13%를 특별상여금으로 지불하기로 하였다.
    이름, 급여, 특별상여금, 부서번호를 출력하라.
    특별상여금 = sal * 13%
    * 특별상여금이라는것을? sal + sal * 13%를 해야 되지 않을까요? 
*/
select ename, sal, sal* 0.13 as 특별상여금, deptno
from emp 
where deptno = 10;


/* 3.
    30번 부서원의 연봉을 계산하여 이름, 부서번호, 급여, 연봉 정보를 연봉이 큰순서데로 출력하라.
    단, 연말에 급여의 150%를 특별상여금으로 지급한다. 연봉은 천단위 미만 절삭처리한다.
    연봉 = (sal * 12) + (sal * 150%)
*/
select ename,
	deptno,
	sal,
	trunc((sal*12) + (sal * 1.50), -3) as 연봉 
from emp 
where deptno = 30
order by 연봉 desc; 


/* 4.
    부서번호가 20인 부서의 시간당 임금인 시급을 계산하여 출력하라.
    단, 1달의 근무일수는 12일이고, 1일 근무시간은 5시간이다.
    출력양식은 이름, 급여, 시간당 임금(소수이하 1번째 자리에서 반올림)을 출력하라.
    시급 = sal /일수 *시간
    round(m, n) m을 소수점 n자리에서 반올림
*/
select ename,
	sal,
	round(sal/12*5) as 시급 
from emp
where deptno = 20;

/* 5.
    급여가 1500부터 3000사이의 사람은 급여의 15%를 월회비로 지불하기로 하였다.
    출력양식은 이름, 급여, 회비(10원 단위는 반올림 처리) 정보를 출력하라.
	회비  = sal * 0.15
	정수 2번째 자리에서 반올림 : 100 단위로 계산
*/
select ename,
	sal,
	round(sal*0.15,-2) as 회비
from emp
where sal between 1500 and 3000;

/* 6.
    급여가 2000 이상인 모든 사람은 급여의 15%를 경조비로 내기로 하였다 .
    이름, 급여, 수당(소수점이하 절삭 처리) 정보를 출력하라.
	경조비 = sal * 0.15
	* 경조비를 설명 하고 있으나, 경조비를 출력하는곳이 없음.
*/
select ename, sal,  trunc(sal*0.15) as 경조비
from emp
where sal >= 2000;

/* 7.
    입사일부터 현재일 까지의 날짜수를 출력하라.
    부서번호, 이름, 입사일, 현재일, 근무일수,
    근무년수, 근무월수(30일 기준), 근무주수(7일 기준) 정보를 출력하라.
	단, 일수, 년수, 월수, 주수는 모둔  소수점 이하 절삭처리하라.

    -- 현재 날짜 : sysdate
	-- 근무 일수 : 현재날짜 - 입사일 = sysdate - hiredate  -> 날짜 - 날짜 : 일수 나옴
	-- 근무 년수 : to_char(sysdate,'YYYY') - to_char(hiredate,'YYYY')
	-- 근무 월수 : 근무일수 / 1달(30일)
	-- 근무 주수 : 근무 일수 /1주 (7일)
*/
select deptno,
	ename,
	hiredate,
	sysdate as 현재일,
	trunc(sysdate-hiredate) as 근무일수,
	to_char(sysdate, 'yyyy') - to_char(hiredate, 'yyyy') as 근무년수, 
	trunc((sysdate-hiredate)/30) as 근무월수,
	trunc((sysdate-hiredate)/ 7) as 근무주수
from emp;

/* 8.
    모든 사원의 급여에서 세금을 차감한 실수령액을 계산하여 출력하라.
    단, 급여가 많은 순으로 이름, 급여, 실수령액을 출력하라.
    세금 = 급여 * 10%
	실수령액 = 급여 - 세금
*/
select ename,
	sal,
	sal - (sal*0.1)as 실수령액
from emp
order by 실수령액 desc;

/* 9.
    입사일로 부터 100일이 지난 후의 사원이름, 입사일, 입사 100일후의 날짜, 급여 정보를 출력하라.
	90일후 = hiredate + 100  :  날짜 + 숫자(일) = 날짜
	* 90일후 ?
*/
select empno,
	hiredate,
	hiredate + 100 as "입사 100일후의 날짜",
	sal
from emp;

/* 10.
    입사일로부터 6개월이 지난 후의 입사일, 6개월 후의 날짜, 급여를 출력하라.
	6개월 후 입사일 : add_months(hiredate, 6);
	* 6개월 후의 날짜?
*/
select add_months(hiredate, 6),
	add_months(sysdate, 6),
	sal
from emp;

/* 11.
    입사한 달의 근무일수를 계산하여 부서번호, 이름, 입사월, 근무일수를 출력하라.
	-- 입사한달의 근무일수 :  last_day(hiredate) - hiredate
	* 입사한달의 근무일수 ?
*/
select deptno,
	ename,
	to_char(hiredate, 'mm') as 입사월,
	last_day(hiredate)- hiredate as 근무일수
from emp;

/* 12.
    모든 사원의 60일이 지나 후의 monday는 몇년, 몇월, 몇일인가를 구하여 이름, 입사일, monday를 출력하라.
	-- NEXT_DAY (DATE, CHAR)
	-- 오라클 시스템의 표현형식은 OS에 따라 Locale 설정
	-- CHAR은 한글 윈도우라 '월','화', 영문 윈도우 : MONDAY,...SUNDAY 설정
*/
select ename,
	hiredate,
	next_day(hiredate + 60, '월') as monday
from emp;

/* 13.
    입사일로부터 현재일까지의 일수를 구하여 이름, 입사일, 근무일수를 출력하라.
    단, 소수이하 반올림 처리
*/
select ename,
	hiredate,
	round(sysdate - hiredate) as 근무일수
from emp;

/* 14.
    입사일을 1996년 5월 14일의 형태로 이름, 입사일을 출력하라.
	-- 날짜 형시 앞에 fm 은 선행 '0'을 표현하지 않음, 1, 2, .. 9, 10, 11, 12
	-- 1990/04/02  'fmYYYY/MM/DD'  ==>  1990/4/2
*/
select ename,
	to_char(hiredate, 'fmyyyy') || '년 ' || to_char(hiredate, 'fmmm') || '월 ' || to_char(hiredate, 'fmdd') || '일 '
from emp;

/* 15.
    이름의 글자수가 6자리 이상인 사람의 이름을 앞에서 3자만 구하여 소문자로 이름만을 출력하라.
	-- substr(str, position, length)
	-- lower(str)  소문자 변환
	-- length(str)  str의 길이
*/
select lower(substr(ename, 0,3))
from emp
where length(ename) >= 6;

/*16.
    10번 부서원들의 월급의 평균,  최고, 최저, 부서 인원수를 구하여 출력하라.
    단, 평균급여는 소수이하 반올림 처리하라.
*/
select round(avg(sal)), max(sal), min(sal), count(*)
from emp
where deptno = 10
group by deptno;

/* 17.
    각 부서별 급여의 평균, 최고, 최저, 인원수를 구하여 부서인원수가 많은 순서데로 정렬 출력하라.
    단, 평균급여는 소수이하 반올림 처리하라.
*/
select round(avg(sal)), max(sal), min(sal), count(*)
from emp
group by deptno
order by 4 desc;

/* 18.
    각 부서별 같은 업무를 하는 사람의 인원수를 구하여 부서번호, 업무명, 직무 인원수를 출력하라.
    단, 직무별 올림차순 정렬 조회하라.
    * 직무별(?)
*/
select deptno, job, count(*)
from emp
group by deptno, job
order by 1, 2;

/**
    19. 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하라.
*/
select job, count(*)
from emp
group by job
having count(*) >= 4;


/* 20.
    각 부서별 평균월급, 전체월급, 최고월급, 최저월급,을 구하여 평균월급이 많은순으로 출력하라.
    단, 평균월급이 2000 이상인 부서의 정보만을 조회출력하라.
*/
select avg(sal), sum(sal), max(sal), min(sal)
from emp
group by deptno
having avg(sal) >= 2000
order by 1 desc;

/* 21.
    직원의 부서번호, 부서명, 사번, 이름, 직무 정보를 출력하라.
*/
select b.deptno, b.dname, a.empno, a.ename, a.job
from emp a, dept b
where a.deptno = b.deptno;

/* 22.
    10번 부서 직원의 부서번호, 부서명, 사번, 이름, 직무 정보를 출력하라.
*/
select b.deptno, b.dname, a.empno, a.ename, a.job
from emp a, dept b
where a.deptno = b.deptno and b.deptno = 10;

/* 23.
   직원의 사번, 사원명, 부서장사번, 부서장명 정보를 출력하라.
*/
select a.empno, a.ename, b.empno, b.ename
from emp a, emp b
where b.empno = a.mgr;

/* 24.
   직원의 사번, 사원명, 부서장사번, 부서장명 정보를 상사의 사번에 대하여 내림차순으로 정렬 출력하라.
   단, 상사가 없는 직원의 정보도 함께 조회 출력하라.
*/
select a.empno, a.ename, b.empno, b.ename
from emp a, emp b
where b.empno(+) = a.mgr
order by 3;

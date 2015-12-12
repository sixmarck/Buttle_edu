-- 17.PLSqlFunction.sql
/* 학습내용
1. PLSql 함수 개발 방법
	- 반환타입이 있는 구조
	- return 키워드 활용
	- 참고 : 프로시저와는 달리 return 키워드 및 select등의 일반 sql 문장에서도 사용 가능
2. 문법
create or replace function 함수
return 타입;
is
begin
end;
/

*/

-- 1. 사번으로 검색된 이름 반환하는 함수
create or replace function emp_info(
	v_empno IN emp.empno%type
)
return varchar2
is
	v_ename emp.ename%type;
begin
	select ename
		into v_ename
	from emp where empno = v_empno;
	return v_ename;
end;
/

select emp_info(7369) from dual;

-- 2.? %type 사용해서 사원명으로 해당 사원의 job 반환하는 함수개발
	-- emp_job
create or replace function emp_job(
	v_ename IN emp.ename%type
)
return varchar2
is
	v_job emp.job%type;
begin
	select job
		into v_job
	from emp
	where ename = v_ename;
	return v_job;
end;
/

select emp_job('SMITH') from dual;

-- 3.? 사번입력하면 특별 보너스 지급을 위한 인상분 계산해주는 함수 : 200%인상
   -- empUpSal

create or replace function empUpSal(
	v_empno IN emp.empno%type
)
return number
is
	v_sal emp.sal%type;
begin
	select sal*2
		into v_sal
	from emp
	where empno = v_empno;
	return v_sal;
end;
/

select empUpSal(7369) from dual;

-- 4.? 입력받은 부서 번호로 해당 부서에 속한 직원들의 최고 급여액만 반환하기
create or replace function empUpSal(
	v_deptno IN emp.deptno%type
)
return number
is
	v_sal emp.sal%type;
begin
	select max(sal)
		into v_sal
	from emp
	where deptno = v_deptno;
	return v_sal;
end;
/

select empUpSal(10) from dual;

--5.? 부서번호를 입력받아 해당 부서의 급여 평균 구하는 함수 개발하기
create or replace function empUpSal(
	v_deptno IN emp.deptno%type
)
return number
is
	v_sal emp.sal%type;
begin
	select avg(sal)
		into v_sal
	from emp
	where deptno = v_deptno;
	return v_sal;
end;
/

select empUpSal(10) from dual;



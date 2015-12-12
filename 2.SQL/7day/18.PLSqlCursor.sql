-- 18.PLSqlCursor.sql
/* 학습내용
1. 다중행 검색에 사용되는 기법
2. 용어
	cursor란?
		특정 위치에서 깜박거리는 표기... 등 특정 위치를 지정해주는 하나의 표기법
3. 기본문법
	1. 선언
		cursor 커서이름 is select 문장;
	2. 오픈
		open 커서이름;
	3. 패치(사용)
		fetch 커서이름 int 검색된 데이터를 대입받을 변수명
			소진(사용)
			주로 반복문으로 데이터를 한건씩 활용하는 코드가 대부분..
	4. 종료
		close 커서이름;
4. 커서 자체의 속성명
	1) %NOTFOUND
		- 데이터 존재 유무 확인용
	2) %rowcount
		- 현 커서 위치의 counting용
*/

-- 1. dept table의 loc 검색 로직
declare
	v_loc dept.loc%type;
	cursor
		dept_loc				-- 커서 선언
	is 
		select loc from dept;		-- 커서가 관리하게 되는 결과 제공하는 select 문
begin
	open dept_loc;				-- 커서 사용을 위한 오픈
	loop
		fetch dept_loc			-- 커서 실제
			into v_loc;			-- 커서가 지정하고 있는 현 row의 데이터값 대입받을 변수
		exit when dept_loc%NOTFOUND;
		
		dbms_output.put_line(v_loc || ' ' || dept_loc%rowcount);
	end loop;

	close dept_loc;
end;
/

-- 2.? emp table의 모든 사번, 이름 검색해서 출력
declare
	v_empno emp.empno%type;
	v_ename emp.ename%type;
	cursor
		c_emp
	is
		select empno, ename from emp;
begin
	open c_emp;
	loop
		fetch c_emp
			into v_empno, v_ename;
		exit when c_emp%NOTFOUND;
		dbms_output.put_line(v_empno || ' ' || v_ename || ' ' || c_emp%rowcount);
	end loop;

	close c_emp;
end;
/

-- 3.? 저장프로시저로 개발
	-- dept_info
create or replace procedure dept_info
is
	v_empno emp.empno%type;
	v_ename emp.ename%type;
	cursor
		c_emp
	is
		select empno, ename from emp;
begin
	open c_emp;
	loop
		fetch c_emp
			into v_empno, v_ename;
		exit when c_emp%NOTFOUND;
		dbms_output.put_line(v_empno || ' ' || v_ename || ' ' || c_emp%rowcount);
	end loop;

	close c_emp;
end;
/

exec dept_info;

-- 4.? 저장함수로 개발
	-- dept_infoFun
create or replace function dept_infoFun
return varchar2
is
	v_empno emp.empno%type;
	v_ename emp.ename%type;
	v_str varchar2(300);		-- is 키워드 뒤에 varchar2의 경우 size 필수
	cursor
		c_emp
	is
		select empno, ename from emp;
begin
	open c_emp;
	loop
		fetch c_emp
			into v_empno, v_ename;
		exit when c_emp%NOTFOUND;
		v_str := v_str || v_empno || ' ' || v_ename || ' ' || chr(10);
	end loop;

	close c_emp;

	return v_str;
end;
/

-- 5. if 조건식 추가(if~else)
-- 해당부서에 소속된 검색된 직원 수가 0이면 '직원이 없음' 출력, 0이 아니면 '몇명 입니다' 출력
-- 0값 기준으로 비교
	-- emp_infoCount 프로시저 개발
	-- 
create or replace procedure emp_infoCount(
	v_deptno IN dept.deptno%type
)
is
	v_empno emp.empno%type;
	v_ename emp.ename%type;
	cursor
		c_emp
	is
		select empno, ename from emp where deptno = v_deptno;
begin
	open c_emp;
	loop
		fetch c_emp
			into v_empno, v_ename;
		exit when c_emp%NOTFOUND;
		
	end loop;

	if c_emp%rowcount = 0 
	then
		dbms_output.put_line('직원이 없음');
	else
		dbms_output.put_line(c_emp%rowcount || '명 입니다.');
	end if;
	close c_emp;
end;
/

exec emp_infoCount(10);

-- 6. oracle db자체적인 기능을 활용해서 for & cursor 활용
	-- for문 사용시 open, fetch, close를 문법적으로만 생략 가능
declare
	v_emp emp%rowtype;
	cursor c_emp is select empno, ename from emp;
begin
	for v_emp in c_emp loop
		dbms_output.put_line(v_emp.empno || ' ' || v_emp.ename);
	end loop;

end;
/

-- 7.? 6번 로직을 저장 프로시저로 변환
create or replace procedure empAll
is
	v_emp emp%rowtype;
	cursor c_emp is select empno, ename from emp;
begin
	for v_emp in c_emp loop
		dbms_output.put_line(v_emp.empno || ' ' || v_emp.ename);
	end loop;

end;
/

exec empAll;

-- 8.? 6번 로직을 저장 함수로 변환 
create or replace function empAllFun
return varchar2
is
	v_emp emp%rowtype;
	cursor c_emp is select empno, ename from emp;
	v_str varchar2(3000);
begin
	for v_emp in c_emp loop
		v_str := v_str || v_emp.empno || ' ' || v_emp.ename || chr(10);
	end loop;
	return v_str;
end;
/

select empAllFun() from dual;

-- select * from user_objects where object_type = 'PROCEDURE';
-- select * from user_objects where object_type = 'FUNCTION'; 

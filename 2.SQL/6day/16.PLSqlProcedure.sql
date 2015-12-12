-- 16.PLSqlProcedure.sql
/* 학습내용
1. 이름이 있는 plsql중 저장프로시저에 대한 학습
2. IN/OUT/INOUT 모드
	1) in		: 데이터를 저장 프로시저에 반영하고자 할때 사용 [입력]
	2) out	: 실행한 직후, 반환하게 되는 개념 데이터 표현 [출력]
	3) inout	: 입출력 동시 가능한 표현
3. 
	1) 이름 부여해서 생성
		(1) 미존재시 생성만 : create procedure
		(2) 존재할 경우 치환 : create or replace procedure
	2) 생성시킨 프로시저 실행
		execute 프로시저명
		exec 프로시저명
	3) 삭제
		drop procedure
*/

-- 1. emp01 table에서 부서번호가 20번인 사원의 job을 player로 변경하는 프로시저 생성
	-- update_20
drop table emp01;
create table emp01 as select * from emp;

create or replace procedure update_20
is 
begin
	update emp01 set job='player' where deptno = 20;
	commit;
end;
/

execute update_20;
select deptno, job from emp01;

-- 2. emp01 table에서 부서번호를 입력 받아 요쳥된 부서번호의 job을 수정하기
	-- update_20
	-- show error 에러 확인
drop procedure update_20;
drop table emp01;
create table emp01 as select * from emp;

create or replace procedure update_20(
	v_deptno IN dept.deptno%type
)
is 
begin
	update emp01 set job='player' where deptno = v_deptno;
	commit;
end;
/

execute update_20(10);
select deptno, job from emp01;

-- 3.? dept01에서 요청시 주워진 deptno값으로 삭제하는 프로시저 개발
	-- delete_deptno
drop procedure delete_deptno;
drop table dept01;
create table dept01 as select * from dept;

create or replace procedure delete_deptno(
	v_deptno IN dept.deptno%type
)
is
begin
	delete dept01 where deptno = v_deptno;
	commit;
end;
/

execute delete_deptno(10);
select * from dept01;

-- 4.? 가변적인 사번을 입력받아서 해당 직원의 급여를 5000으로 변경하는 프로시저 개발
	-- up_sal

create or replace procedure up_sal(
	v_empno IN emp01.empno%type
)
is
begin
	update emp01 set sal = 5000 where empno=v_empno;
	commit;
end;
/

execute up_sal(7369);
select * from emp01;

-- 5. 사번 제공후 이름, 급여 검색하기
	-- 데이터 하나(in) 주고 두개의 데이터 획득(out)
	-- emp_info
drop table emp01;
create table emp01 as select * from emp;

create or replace procedure emp_info(
	v_empno IN emp01.empno%type,
	v_ename OUT emp01.ename%type,
	v_sal	OUT emp01.sal%type
)
is
begin
	select ename, sal
		into v_ename, v_sal
	from emp01 where empno = v_empno;
end;
/

variable name varchar2(10);
variable sal number;

execute emp_info(7369, :name, :sal)
print name;
print sal;

-- 6. 이미 존재하는 다른 procedure를 호출해서 사용하는 문법
	-- printINfo
create or replace procedure printInfo
is
	v_ename emp.ename%type;
	v_sal emp.sal%type;
begin
	emp_info(7369, v_ename, v_sal);
	dbms_output.put_line(v_ename || ' ' || v_sal);
end;
/

-- 7. INOUT 활용해보기
create or replace procedure emp_JobInfo(
	v_data IN OUT varchar2
)
is
begin
	select job
		into v_data
	from emp where ename=v_data;
end;
/


-- is하위의 변수타입을 varchar2 로 지정할 경우 되지 않으므로 꼭 byte의 값을 정해주어야 함.

create or replace procedure emp_JobInfoPrint
is
	v_data varchar2(20) := 'SMITH';
begin
	emp_JobInfo(v_data);
	dbms_output.put_line(v_data);

end;
/

-- 8. 
drop table dept01;
create table dept01 as select * from dept;

alter table dept01 add constraint dept01_pk primary key(deptno);

create or replace procedure insert_dept(
	v_deptno IN dept.deptno%type,
	v_dname IN dept.dname%type,
	v_loc dept.loc%type
)
is
begin
	insert into dept01 values(v_deptno, v_dname, v_loc);
exception
	when DUP_VAL_ON_INDEX 
	then
		dbms_output.put_line('저장불가입니다, +1 해서 재 저장합니다.');
		insert into dept01 values(v_deptno+1, v_dname, v_loc);
end;
/

exec insert_dept(10, '교육', '구로');
select * from dept01;
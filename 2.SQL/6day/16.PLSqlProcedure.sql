-- 16.PLSqlProcedure.sql
/* �н�����
1. �̸��� �ִ� plsql�� �������ν����� ���� �н�
2. IN/OUT/INOUT ���
	1) in		: �����͸� ���� ���ν����� �ݿ��ϰ��� �Ҷ� ��� [�Է�]
	2) out	: ������ ����, ��ȯ�ϰ� �Ǵ� ���� ������ ǥ�� [���]
	3) inout	: ����� ���� ������ ǥ��
3. 
	1) �̸� �ο��ؼ� ����
		(1) ������� ������ : create procedure
		(2) ������ ��� ġȯ : create or replace procedure
	2) ������Ų ���ν��� ����
		execute ���ν�����
		exec ���ν�����
	3) ����
		drop procedure
*/

-- 1. emp01 table���� �μ���ȣ�� 20���� ����� job�� player�� �����ϴ� ���ν��� ����
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

-- 2. emp01 table���� �μ���ȣ�� �Է� �޾� �䫊�� �μ���ȣ�� job�� �����ϱ�
	-- update_20
	-- show error ���� Ȯ��
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

-- 3.? dept01���� ��û�� �ֿ��� deptno������ �����ϴ� ���ν��� ����
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

-- 4.? �������� ����� �Է¹޾Ƽ� �ش� ������ �޿��� 5000���� �����ϴ� ���ν��� ����
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

-- 5. ��� ������ �̸�, �޿� �˻��ϱ�
	-- ������ �ϳ�(in) �ְ� �ΰ��� ������ ȹ��(out)
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

-- 6. �̹� �����ϴ� �ٸ� procedure�� ȣ���ؼ� ����ϴ� ����
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

-- 7. INOUT Ȱ���غ���
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


-- is������ ����Ÿ���� varchar2 �� ������ ��� ���� �����Ƿ� �� byte�� ���� �����־�� ��.

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
		dbms_output.put_line('����Ұ��Դϴ�, +1 �ؼ� �� �����մϴ�.');
		insert into dept01 values(v_deptno+1, v_dname, v_loc);
end;
/

exec insert_dept(10, '����', '����');
select * from dept01;
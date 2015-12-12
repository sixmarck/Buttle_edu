-- 18.PLSqlCursor.sql
/* �н�����
1. ������ �˻��� ���Ǵ� ���
2. ���
	cursor��?
		Ư�� ��ġ���� ���ڰŸ��� ǥ��... �� Ư�� ��ġ�� �������ִ� �ϳ��� ǥ���
3. �⺻����
	1. ����
		cursor Ŀ���̸� is select ����;
	2. ����
		open Ŀ���̸�;
	3. ��ġ(���)
		fetch Ŀ���̸� int �˻��� �����͸� ���Թ��� ������
			����(���)
			�ַ� �ݺ������� �����͸� �ѰǾ� Ȱ���ϴ� �ڵ尡 ��κ�..
	4. ����
		close Ŀ���̸�;
4. Ŀ�� ��ü�� �Ӽ���
	1) %NOTFOUND
		- ������ ���� ���� Ȯ�ο�
	2) %rowcount
		- �� Ŀ�� ��ġ�� counting��
*/

-- 1. dept table�� loc �˻� ����
declare
	v_loc dept.loc%type;
	cursor
		dept_loc				-- Ŀ�� ����
	is 
		select loc from dept;		-- Ŀ���� �����ϰ� �Ǵ� ��� �����ϴ� select ��
begin
	open dept_loc;				-- Ŀ�� ����� ���� ����
	loop
		fetch dept_loc			-- Ŀ�� ����
			into v_loc;			-- Ŀ���� �����ϰ� �ִ� �� row�� �����Ͱ� ���Թ��� ����
		exit when dept_loc%NOTFOUND;
		
		dbms_output.put_line(v_loc || ' ' || dept_loc%rowcount);
	end loop;

	close dept_loc;
end;
/

-- 2.? emp table�� ��� ���, �̸� �˻��ؼ� ���
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

-- 3.? �������ν����� ����
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

-- 4.? �����Լ��� ����
	-- dept_infoFun
create or replace function dept_infoFun
return varchar2
is
	v_empno emp.empno%type;
	v_ename emp.ename%type;
	v_str varchar2(300);		-- is Ű���� �ڿ� varchar2�� ��� size �ʼ�
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

-- 5. if ���ǽ� �߰�(if~else)
-- �ش�μ��� �Ҽӵ� �˻��� ���� ���� 0�̸� '������ ����' ���, 0�� �ƴϸ� '��� �Դϴ�' ���
-- 0�� �������� ��
	-- emp_infoCount ���ν��� ����
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
		dbms_output.put_line('������ ����');
	else
		dbms_output.put_line(c_emp%rowcount || '�� �Դϴ�.');
	end if;
	close c_emp;
end;
/

exec emp_infoCount(10);

-- 6. oracle db��ü���� ����� Ȱ���ؼ� for & cursor Ȱ��
	-- for�� ���� open, fetch, close�� ���������θ� ���� ����
declare
	v_emp emp%rowtype;
	cursor c_emp is select empno, ename from emp;
begin
	for v_emp in c_emp loop
		dbms_output.put_line(v_emp.empno || ' ' || v_emp.ename);
	end loop;

end;
/

-- 7.? 6�� ������ ���� ���ν����� ��ȯ
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

-- 8.? 6�� ������ ���� �Լ��� ��ȯ 
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

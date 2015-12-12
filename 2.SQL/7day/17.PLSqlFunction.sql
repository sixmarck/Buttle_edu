-- 17.PLSqlFunction.sql
/* �н�����
1. PLSql �Լ� ���� ���
	- ��ȯŸ���� �ִ� ����
	- return Ű���� Ȱ��
	- ���� : ���ν����ʹ� �޸� return Ű���� �� select���� �Ϲ� sql ���忡���� ��� ����
2. ����
create or replace function �Լ�
return Ÿ��;
is
begin
end;
/

*/

-- 1. ������� �˻��� �̸� ��ȯ�ϴ� �Լ�
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

-- 2.? %type ����ؼ� ��������� �ش� ����� job ��ȯ�ϴ� �Լ�����
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

-- 3.? ����Է��ϸ� Ư�� ���ʽ� ������ ���� �λ�� ������ִ� �Լ� : 200%�λ�
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

-- 4.? �Է¹��� �μ� ��ȣ�� �ش� �μ��� ���� �������� �ְ� �޿��׸� ��ȯ�ϱ�
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

--5.? �μ���ȣ�� �Է¹޾� �ش� �μ��� �޿� ��� ���ϴ� �Լ� �����ϱ�
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



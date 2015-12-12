-- 15.PLSqlSyntax.sql
/* �н�����
1. ����� ���� �Լ��� ���� oracle db���� sql����
2. sql : plsql 
	sql - db�� ��û�� db�������� �Ź� read -> �м� -> ��ȯ(������) -> ����
	plsql - ù ��û�� read -> �м� -> ��ȯ(������) -> ����
		�̹� ��ȯ�� �����ϵ� �ڵ带 db�� ����
		�ι�° ��û���ʹ� ����
3. ���� (***)
	1) �͸� ���
		- �̸� ����
		- ȣ�� �Ұ���, ���뼺 �̰��
	2) ���� ���ν���
		- �̸� ����
		- ȣ�� ����
		- parameter ����
	3) ���� �Լ�
		- �̸� ����
		- ȣ�� ����
		- parameter ����, ��ȯ ������ ����
4. ����
	declare			[�ɼ�]
		��������;
	begin				[�ʼ�]
		�������
	exception			[�ɼ�]
		when ��Ȳ�������̸��� then
			���ܹ߻��� ó�� ����
	end;				[�ʼ�]
	/				[�ʼ�]
5. ������ (***)
	1) �Ҵ翬���� - :=
	2) ���տ����� - ||


*/

-- 1. plsql ���� ��� ����� ���� �ʼ� ����
set serveroutput on

-- 2. �⺻ ���� ������ ���� �͸� ��� & ��� ��� �н�
declare
	name varchar2(10);
begin
	name := '����';
	dbms_output.put_line('��� ������ ' || name);
end;
/

/* ����
begin
	name varchar2(10); ���� �߻� ����
	name := '����';
	dbms_output.put_line('��� ������ ' || name);
end;
/
*/

begin
	dbms_output.put_line('��� ������ ');
end;
/

-- 3. �������� ������ �͸���(�������� �� Ȱ�� �ͼ�������)
declare
	counter integer;
begin
	counter := 10;
	counter := counter/2;
	dbms_output.put_line(counter);
end;
/

-- 4. ��ø �͸���
	-- inner block������ ����� ������ outer block���� ��� �Ұ�
declare
	a varchar2(10) := '���� A';	
begin
	declare
		b varchar2(10) := '���� B';
	begin
		dbms_output.put_line(a);
		dbms_output.put_line(b);
	end;
	dbms_output.put_line(a);
	--dbms_output.put_line(b); ����
end;
/

-- 5. emp table�� �÷� Ÿ�� Ȱ���غ��� (ename�� Ÿ��)
declare
	name  emp.ename%type;
begin
	name := 'master';
	dbms_output.put_line(name);
end;
/

-- 6.? emp�� sal�� �÷� Ÿ�� Ȱ��(sal���� ���� �� �����Ͱ� �����ؼ� ���)
declare
	sal emp.sal%type;
begin
	sal := 3333;
	dbms_output.put_line(sal);
end;
/

-- 7. select�� ������� ����� ����
	-- select�� �����Ͱ� plsql������ �����ؼ� ���
declare
	name emp.ename%type;
begin
	select ename into name
	from emp 
	where empno=7369;
	dbms_output.put_line(name);
end;
/

-- 8.? SMITH�� ���޿��� ��� �˻��ؼ� ���
declare 
	v_sal		emp.sal%type;
	v_empno	emp.empno%type;
begin
	select sal, empno into v_sal, v_empno
	from emp
	where ename = 'SMITH';
	dbms_output.put_line(v_sal || ' ' || v_empno);
end;
/

-- 9.? �����ϴ� emp table�� ��� �÷� Ÿ�� �� �÷����� Ȱ���Ҽ� �ִ� plsql Ÿ�� �н�
	-- %rowtype
declare
	v_all emp%rowType;
begin
	select *
		into v_all
	from emp where empno=7369;

	dbms_output.put_line(v_all.ename);
end;
/

-- 10. ���ǽ�
	-- comm�� null�� ������� 0���� �� ġȯ�Ŀ� ����(SMITH sal * 12 + comm)
declare
	v_emp emp%rowtype;
	allSal number(7, 2);
begin
	dbms_output.put_line('���/�̸�/����');
	select empno, ename, sal, comm
		into v_emp.empno, v_emp.ename, v_emp.sal, v_emp.comm
	from emp
	where ename = 'SMITH';

	if(v_emp.comm is null) then
		v_emp.comm := 0;
	end if;

	allSal := v_emp.sal * 12 + v_emp.comm;
	dbms_output.put_line(v_emp.empno || '/' || v_emp.ename || '/' || allSal);
end;
/

-- 11.? emp���� sal�� 3000�� �ʰ��ϴ� ����� ���ؼ� "KING" ���
	-- select sal, ename from emp where ename='KING'
declare
	v_ename emp.ename%type;
	v_sal emp.sal%type;
begin
	select sal, ename into v_sal, v_ename
	from emp
	where ename='KING';

	if(v_sal > 3000) then
		dbms_output.put_line('KING');
	end if;
end;
/

-- 12. ���� ���ǽ�
	-- SMITH�� �μ� ��ȣ�� 10 - ����, 20 - ����, 30 - ����
declare
	v_deptno dept.deptno%type;
	v_loc dept.loc%type;
begin
	select deptno
		into v_deptno
	from dept where deptno = (select deptno from emp where ename='KING');

	if(v_deptno = 10) then
		v_loc := '����';
	elsif(v_deptno = 20)  then
		v_loc := '����';
	elsif(v_deptno = 30) then
		v_loc := '����';
	else
		v_loc := '�ѱ�';
	end if;
	dbms_output.put_line('SMITH�� �ٹ����� ' || v_loc);
end;
/

-- 13.? [������]
	-- emp table���� �Ի����� 81�⵵�� ����� �� �޿��� 2000�̻��̰� 3000�Ʒ��� ����鸸 �˻��ϼ��� (�̸�, �Ի���, �޿�)
declare
	v_emp emp%rowtype;
	cursor c1 is select ename, hiredate, sal from emp where '81' = to_char(hiredate, 'yy');
begin
	for v_emp in c1 loop
		if(v_emp.sal >= 2000 and v_emp.sal <= 3000) then
			dbms_output.put_line(v_emp.ename || '/' || v_emp.hiredate || '/' || v_emp.sal);
		end if;
		
	end loop;
end;
/


-- 13. �ݺ���
declare
	num number(2) := 1;
begin
	loop
		dbms_output.put_line(num);
		num := num +1;
		exit when num > 5;
	end loop;
end;
/

-- 14. 
begin
	for i in 0..5 loop
		dbms_output.put_line(i);
	end loop;
end;
/

-- 15.
declare
	num number(2) := 1;
begin
	while num <= 5 loop
		dbms_output.put_line(num);
		num := num +1;
	end loop;
end;
/

-- 16. 5���� 1������ ����غ���
begin
	for i in reverse 1..5 loop
		dbms_output.put_line(i);
	end loop;
end;
/

-- 17. ���� ������ ���� ������ plsql ����
	-- ����ø��� ���ο� �����Ͱ� ���� ����
declare
	v_empno emp.empno%type := &v;
begin
	dbms_output.put_line(v_empno);
end;
/

-- 18.? ����� �������� �Է� �޾� �ش��ϴ� ����� �̸� ������ ��ŭ  * ���
	-- ���� : plsql������ oracle �Լ� ��밡��(length())
declare
	v_empno emp.empno%type := &v;
	v_length number(2);
	v_start varchar2(10);
begin
	select length(ename) into v_length
	from emp
	where empno = v_empno;
	
	for i in 1..v_length loop
		v_start := v_start || '*';
	end loop;

	dbms_output.put_line(v_start);
end;
/

-- 19.? �� �����ϴ� �����ͷ� �˻��õ��� �߻��ϴ� ���� ó�� ���� �н�
	-- exeception ó�� ������ NO_DATA_FOUND ��� �̹� �����ϴ� Ű���� Ȱ��
declare
	v_ename emp.ename%type := &v;
	v_empno emp.empno%type;
begin
	select empno
		into v_empno
	from emp where ename = v_ename;

	dbms_output.put_line(v_empno);
exception
	when NO_DATA_FOUND then
		dbms_output.put_line('�˻� �����Ͱ� �����ϴ�.');
end;
/


-- 11.view.sql
/* �н�����
1. ������ ������ table�� ���� �н�
	- ���� �� create table ��ɾ�� ������Ų table�� �־�߸� ��� ������ �̷�
2. �ʿ伺
	- ������ ����� table�̶�� Ư�� �÷��� �����ϰ� view��°����� �����ؼ� �����޾� ���ߵ� �ϰ� Ȱ��
	- view�� �˻��� �����ʹ� ���� table�� �����Ϳ��� ��
		: Ȥ ���� table�� ������ ����� view�� ����� ������ �ڵ� �ݿ�
3. ����
	1) ����
		create view view�̸� as select .... ���� table
	2) ����
		drop view view�̸�;
	3) view�� ���� ���� table���� crud ����
		��, select�� �����ϰ� �ϴ� ���� [DML ����]
		create view view�̸� as select ... with read only;
	4) view ������ Ȯ���ϴ� ��ɾ�
		select * from user_views;

*/
-- 1. comm�� ������ emp table ������� emp_v��� view ����
	-- comm ��ü�� ������ϴ� user���� emp_v�� tableó�� ����ϰ� �ϸ� ��
drop table emp01;
create table emp01 as select * from emp;

-- view ���� ������ ��� ����
-- create view emp_v as select * from emp01;
-- admin system/oracle�� �� ���� �� view�� ���� soctt ������ ���� �ο�

-- 2. admin���� ���� & view�� ���� ���� �ο� & scott �������� ������
connect system/oracle
grant create view to scott;
connect scott/tiger

-- 3. ���� �ο� �� view ����
create view emp_v as select * from emp01;
select * from emp_v;

drop view emp_v;
create view emp_v as select empno, ename, job, mgr, hiredate, sal, deptno from emp01;
select * from emp_v;

-- 4. �̹� ������ view�� �ִ� table�� ������ ������ view�� ������ �޳�?
	-- emp01 : ����, emp_v : view
delete from emp01 where ename = 'SMITH';
select * from emp01;
select * from emp_v;

-- 5. view�� DML(insert/delete/update) ������ ���� table���� ������ �޳�?
-- dept01�� ����, dept01_v�� view
drop table dept01;
create table dept01 as select * from dept;
create view dept01_v as select * from dept01;
select * from dept01;

update dept01_v set loc='����' where deptno = 10;
select * from dept01_v;
select * from dept01;

-- 6. �б⸸ ������ view ����� : ���� table ���� ����
drop table dept01;
drop view dept01_v;
create table dept01 as select * from dept;
create view dept01_v as select * from dept01 with read only;
select * from dept01;

update dept01_v set loc='����' where deptno = 10;

-- 7. view ���� Ȯ��
select * from user_views;
select view_name, text,  type_text, view_type_owner from user_views;

-- 8.? �ټ��� user�� ����� ��������� ��û
	-- view�� �̹� �����ؼ� view�� ���� �Ҽ��� ����
	-- view �̸� empAll_v
drop view empAll_v;
create view empAll_v as select a.empno, a.ename, a.job, a.mgr, a.hiredate, a.sal, a.deptno, b.dname, b.loc
from emp a, dept b
where a.deptno = b.deptno;

select * from empAll_v;


drop view empAll_v;
create view empAll_v as select empno, ename, hiredate, sal, mgr, emp.deptno, comm, dept.dname, dept.loc from emp, dept where emp.deptno = dept.deptno;
select * from empAll_v;
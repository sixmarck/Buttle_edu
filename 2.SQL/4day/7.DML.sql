-- 7.DML.sql
/* �н�����
1. DML - Data Manipulation Language
2. �ǹ� - �̹� �����ϴ� table�� ������ ���� ���
		(������ ����(insert), ����(update), ����(delete))
3. �ǽ� ȯ��
	- �ΰ� �̻��� sqlplus ����
	  ���ʿ��� DML ����, �ٸ� sqlplusâ���� select
4. DML�� �����Ŀ� �ݵ�� �������� ��ɾ� �ʼ�
	- �������� : commit
	- ���� : rollback
5. ����
	1. INSERT INTO table�� [(�÷���, ...)] VALUES (��1, ...) [WHERE��];
	2. UPDATE table�� SET �����÷��������� [WHERE��];
	3. DELETE FROM table�� [WHERE��];
*/

-- 1. dept table�� ���纻 table ����
	-- ���� ������ table : dept01
drop table dept01;
create table dept01 as select * from dept;
select * from dept01;

-- 2. dept table ���纻 �� �����͸� ������ table ������ �״�� �����ؼ� �����ϱ�
drop table dept01;
create table dept01 as select * from dept where 1=0;
select * from dept01;

-- 3. emp01 table �����ϵ� emp���� ename, empno, comm ������ ���� �� ������ ����
drop table emp01;
create table emp01 as select ename, empno, comm from emp;
select * from emp01;

-- ***[insert]***
-- 4. emp01�� ���ο� ������ �߰� ���� : �÷��� ���
	-- insert ���� �ӽ÷� ����� �����͸� commit������� �������� - �ٸ� Application �鵵 ��� �����ϰ� �����ϴ� ��ɾ�
insert into emp01(ename, empno, comm) values('�����', 1234, 500);
select * from emp01;
commit;

-- 5. emp01�� ���ο� ������ �߰� ���� : �÷��� ��þ��� ������ �߰�
	-- ���ǻ��� : table ������ �÷� ������ ������ ����
insert into emp01 values('��ÿ�', 3456, 700);
select * from emp01;
commit;

-- 6. ���Ǻ� ���� �����͸� �ѹ��� insert�������� �ټ��� table�� ����
drop table emp01;
drop table emp02;

create table emp01 as select ename, empno, deptno from emp where 1=0;
create table emp02 as select ename, empno, deptno from emp where 1=0;

select * from emp01;
select * from emp02;

insert all
	when deptno=10 then
		into emp01 (ename, empno, deptno) values(ename, empno, deptno)
	when deptno=20 then
		into emp02 (ename, empno, deptno) values(ename, empno, deptno)
select ename, empno, deptno from emp;

select * from emp01;
select * from emp02;

-- 7. ? deptno�� 10�� �������� emp01�� �����ϰ�, deptno 20, deptno 30�̶�� emp02�� ����
drop table emp01;
drop table emp02;

create table emp01 as select ename, empno, deptno from emp where 1=0;
create table emp02 as select ename, empno, deptno from emp where 1=0;

select * from emp01;
select * from emp02;

insert all
	when deptno=10 then
		into emp01 (ename, empno, deptno) values(ename, empno, deptno)
	when deptno=20 or deptno=30 then
		into emp02 (ename, empno, deptno) values(ename, empno, deptno)
select ename, empno, deptno from emp;

select * from emp01;
select * from emp02;

-- ***[update]***
-- 8. dept01 table�� �μ���ȣ�� ��� 50���� ����
drop table dept01;
create table dept01 as select * from dept;
select * from dept01;

update dept01 set deptno=50;
select * from dept01;

-- 9. update�� ������ ������ ����
rollback;

-- 10. deptno�� 10�� �μ��� loc�� ���η� �����ϱ�
update dept01 set loc='����' where deptno = 10;
select * from dept01;

-- 11. deptno�� 20�� �μ��� �μ��� ������, loc�� ������ �����ϱ�
update dept01 set dname='������', loc='����' where deptno=20;

-- 12.? emp01 table�� ��� ����� �޿��� 10%�λ�
drop table emp01;
create table emp01 as select * from emp;
update emp01 set sal = sal + sal * 0.1;
select * from emp01;

-- 13.? emp01�� ��� ����� �Ի����� ���÷� �����ϱ�
drop table emp01;
create table emp01 as select * from emp;
update emp01 set hiredate = sysdate;
select * from emp01;

-- 14.? emp01���� �޿��� 3000�̻��� ����� �޿��� 10% �λ��ϱ�
drop table emp01;
create table emp01 as select * from emp;
update emp01 set sal = sal + sal * 0.1 where sal >= 3000;
select * from emp01;

-- 15.? emp01 ������ DALLAS���� �ٹ��ϴ� ������� �޿��� 1000�λ��ϱ�(subquery)
drop table emp01;
create table emp01 as select * from emp;
update emp01 set sal = sal + 1000 where deptno = (select deptno from dept where loc='DALLAS');
select * from emp01;

-- 16.? emp01�� SMITH ����� �μ���ȣ�� 30���� job�� MANAGER�� �����ϱ�
drop table emp01;
create table emp01 as select * from emp;
update emp01 set deptno=30, job='MANAGER' where ename='SMITH';
select * from emp01;

-- ***[delete]***
-- 17. emp01 table ��� ������ ����
select * from emp01;
delete from emp01;
select * from emp01;

-- 18. dept01 table�� 10�� �μ��� ������ ����
drop table dept01;
create table dept01 as select * from dept;
select * from dept01;

delete from dept01 where deptno = 10;
select * from dept01;

-- 19.? comm�� null�� ����鸸 ��λ���
drop table emp01;
create table emp01 as select * from emp;
select * from emp01;

delete from emp01 where comm is null;
select * from emp01;

-- 20.? comm�� null�� �ƴ� ����鸸 ��� ����
delete from emp01 where comm is not null;
select * from emp01;

-- 21.? emp01���� RESEARCH �μ��� �Ҽӵ� ����鸸 ����
drop table emp01;
create table emp01 as select * from emp;
select * from emp01;

delete from emp01 where deptno = (select deptno from dept where dname='RESEARCH');
select * from emp01;




-- 8.DDL.sql
/* �н�����
1. DDL - Data Definition Language
2. ����
	- create/drop/alter
3. test table ���� ��ɾ�
	- create table table�� as select ~
4. commit�� rollback ��ɾ�� DML���� ����Ǵ� ��ī����
5. table�� �÷��� ������ Ÿ��
	1. ���ڿ�
		char(����byte) - ���� ���ڿ�
		varchar2(�ִ�byte) - �������� ���ڿ�
	2. ����[����, �Ǽ�]
		number(��ü�����ڸ���)
		number(��ü�ڸ���, �Ǽ��ڸ���)
	3. ��¥ Ÿ��
		date
6. ����
	1. ����
		CREATE table��(
			�̸� Ÿ�� ��������, 
			...
		);
	2. table���� ����
		�÷� �߰� - ALTER table�� add(�÷��� Ÿ��);
		�÷� ���� - ALTER table�� modify(�÷��� Ÿ��);
		�÷� ���� - ALTER table�� DROP COLUMN �÷���;
	3. �����ϴ� �����͸� ����
		- delete : commit/rollback�� ����
		- truncate : commit/rollback�� ����
*/

-- ***[table ���� �� ������ ���� ��ɾ�]***
-- 1. table ���� ����[�̸�, ����]
droptabl person;
create table person(
	name varchar2(10) not null,
	age number(3) not null
);

desc person;
select * from person;
insert into person values('�̿��', 27);
select * from person;
--insert into person(age) values(30); null�� ������ �ȵǴ� name�Ӽ��̶� ����

-- 2. insert������ �̿��ؼ� table������ ������ emp01�� ������ �ѹ��� insert�ϱ�
drop table emp01;
create table emp01 as select * from emp where 1=0;
select * from emp01;

insert into emp01 select * from emp;
select * from emp01;

-- ***[table ����]***
-- 3. emp01 table ����
drop table emp01;

-- ***[table ����]***
-- 4. job�̶�� �÷��� ���� �߰�
drop table emp01;
create table emp01 as select ename, empno, deptno from emp;
desc emp01;

alter table emp01 add(job varchar2(20));
desc emp01;

-- 5. job�� byte�� ���(10byte)
alter table emp01 modify(job varchar2(10));
desc emp01;

-- 4~5���� ���ؼ� ���ο� �÷� �߰� �� �����Ͱ� ���� �÷��� byte �� ���, Ȯ�뵵 ����

-- 6.? �����Ͱ� �����ϴ� �÷� �����õ�
	-- �̹� �����ϴ� �������� byte ������ ���� ������� ���� ���� ����
drop table dept01;
create table dept01 as select * from dept;
desc dept01;
-- ok
alter table dept01 modify(dname varchar2(10));
-- ���� alter table dept01 modify(dname varchar2(5));

-- 7. �̹� �����ϴ� �÷� ����
alter table dept01 drop column deptno;


-- ***[������ ����]***
-- 8. table�� �����͸� ����
-- commit/rollback�� ������ ��ɾ�
delete from dept01;
-- commit/rollback �Ұ��� �� ���� �Ұ���
truncate table dept01;
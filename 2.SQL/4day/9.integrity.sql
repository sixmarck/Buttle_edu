-- 9.integrity.sql
/* �н�����
- ������ ���Ἲ ������ ���� table�� �������� �����ϴ� �پ��� ���
1. ����
	1. not null - �ݵ�� �����Ͱ� �����ؾ� ���� �ǹ�
	2. unique - �ߺ� ���� ����
	3. primary key[pk=�⺻Ű=��Ű] 
		- not null + unique �ΰ��� ������ ������ ��������
		- �� �뵵 : ������ ���п� �ٽ� ������
	4. foreign key[fk=�ܷ�Ű=����Ű]
		- �̹� �����ϴ� pk�� �����ϴ� ��������
		- �ڽ� table�� �θ�table ���� ����
			: �θ� table - pk ������ table
			  �ڽ� table - fk ������ tbale
	5. check : ���α׷� ���� if ���ǽİ� ���
			Ư�� ���ǿ� �ش��ϴ� �����Ͱ��� ���� ����
	6. default : insert�ÿ� �����͸� �������� �ʾƵ� �⺻������ ����Ǵ� ������
2. �������� �������
	1. db�����ڰ� �̸��� ��������� �ο�
		1) �÷� ����� �̸��� �ο��� ���� ���� ����
			- �÷� ������ �������
		2) ��� �÷� ���� �� table ���� �������� �̸��� �ο��� �������� ����
			- table���� ������ ���� ���
	2. oracle db ��ü������ �ڵ�������Ű�� ���
		- name varchar2(10) primary key ó�� �÷� ����� �������� ���������� ���� ���� �̸� ���� ���� ������ ���
		- SYS_Xxx�� �ڵ� ������
	3. ����� table���� �������� �ڵ� ������ �Ұ�
		���� ���������� ��������� alter��ɾ�� ���� �ʼ�
		alter table table�� add constraint �������Ǹ� primary key(�÷���);
3. oracle db��ü�� ��ƿ table
	1. user_constraints : ���� ���� ���� ���� table

*/

-- 1. pk�� �����Ǿ� �ִ� dept�� deptno���� �̹� �����ϴ� �����ͷ� ���� �õ��� ����
--insert into dept values(10, '������', '����');

-- 2. DB���� scott������ ����ϴ� ��� table�� �������� ���� Ȯ��
desc user_constraints;
select table_name, constraint_name, constraint_type from user_constraints;

-- 3. �̸� �ο����� �ʴ� �������� ���� �� Ȯ��, ���� �߻� ����
drop table person;
create table person(
	name varchar2(10) not null,
	age number(3) not null
);

insert into person values('�缮', 26);
insert into person values(3);

select table_name, constraint_name, constraint_type from user_constraints
where table_name='PERSON';

-- 4. pk ���� �� �������� �̸� �̺ο�, �����޽��� Ȯ��
	-- table ������ �������� ���� ������ ����Ŭ ��ü table���� ���� �ڵ� ����
drop table person;
select table_name, constraint_name, constraint_type from user_constraints
where table_name='PERSON';

create table person(
	name varchar2(10) primary key,
	age number(3) not null
);

insert into person values('�缮', 26);
-- pk�� �ߺ� ����õ��� ���� insert into person values('�缮', 26);

-- 5. �÷����� ������ �̸��� �ο��ϴ� �������� ���� ���
	-- �ش� �������ǿ� ����Ǵ� ���� �߻��� �������Ǹ� ���� �޼��� �Ϻη� ǥ��

drop table person;
create table person(
	name varchar2(10) constraint person_pk primary key,
	age number(3) not null
);
insert into person values('�缮', 26);
select table_name, constraint_name, constraint_type from user_constraints
where table_name='PERSON';
insert into person values('�缮', 26);

-- 6. table ���� ������ �������� ���� ���

drop table person;
create table person(
	name varchar2(10),
	age number(3) not null,
	constraint person_pk primary key(name)
);
insert into person values('�缮', 26);
select table_name, constraint_name, constraint_type from user_constraints
where table_name='PERSON';

-- 7. ���纻 table�� alter��ɾ�� �������� �߰��ϱ�
drop table dept01;
create table dept01 as select * from dept;

insert into person values('�缮', 26);
select table_name, constraint_name, constraint_type from user_constraints
where table_name='DEPT01';

alter table dept01 add constraint dept01_pk primary key(deptno);
select table_name, constraint_name, constraint_type from user_constraints
where table_name='DEPT01';

-- 8. �ܷ�Ű [FK] ����
drop table emp01;
create table emp01(
	empno number(4) constraint emp01_pk primary key,
	deptno number(2) constraint emp01_fk references dept(deptno)
);
select table_name, constraint_name, constraint_type from user_constraints
where table_name='EMP01';

-- 9.? alter��ɾ�� dept�� deptno �÷��� emp01�� deptno�� �������� �����ϱ�
drop table emp01;
create table emp01(
	empno number(4) constraint emp01_pk primary key,
	deptno number(2)
);

select table_name, constraint_name, constraint_type from user_constraints
where table_name='EMP01';

alter table emp01 add constraint emp01_fk foreign key(deptno) references dept(deptno);

select table_name, constraint_name, constraint_type from user_constraints
where table_name='EMP01';

-- 10. emp01(�ڽ�)�� dept(�θ�)�� �������ϴ� deptno������ ����
-- ���� : insert into emp01 values(1234, 50); �θ� �������ϴ� ������ ��� �Ұ�
insert into emp01 values(1234, 40);

-- 11. check�� ���� ��������
	-- ���α׷� ���ó�� if����� ����� ���͸� ���, ���� �ش� ���ǿ� ����� oracle ��ü�� ���� �߻�
-- table ������ age�� 1~100������ �����͸� �����ϰڴٴ� �������� ����
drop table emp01;
create table emp01(
	name varchar2(10) primary key,
	age number(3) constraint emp01_ck check(age between 1 and 100)
);

insert into emp01 values('master', 10);
insert into emp01 values('master', 110);
select * from emp01;

-- 12. ? emp01 table�� gender��� ���� �÷� �����ؼ� ����, �� ����Ǵ� �����ʹ� F or M�� ����
	-- in ������
alter table emp01 add(gender char(1));
alter table emp01 add constraint emp01_ck2 check(gender in('F', 'M'));
insert into emp01 values('admin', 10, 'M');
-- insert into emp01 values('ddmin', 10, 'm'); m ���� �Ұ� ������

-- 13. default �������� : insert�ÿ� ������ �������� �ʾƵ� �⺻���� �ڵ� ����Ǵ� ���
drop table emp01;
create table emp01(
	name varchar2(10) primary key,
	age number(3) default '1'
);

insert into emp01 values('master', 20);
insert into emp01(name) values('tester');
select * from emp01;

-- 14.? �̹������ϴ� emp01�� dept table�� deptno�� emp01�� fk �߰� ����
alter table emp01 add(deptno number(2));
alter table emp01 add constraint emp01_fk foreign key(deptno) references dept(deptno);
insert into emp01 values('me', 10, 20);
select * from emp01;

-- 15. ���� ������ table ���� �õ�
	-- 1) �θ��� �����͸� �����ϴ� �����͸� ������ �ڽ� table�� ������ ��� �θ� table ���� �õ�
	drop table dept;
	-- 20�� �����͸� �����ؼ� ����ϴ� emp01�� ���翡 ���� �θ� ���� �Ұ�
	-- 2) ���� �����̱�� �ϳ� �����ϴ� �ڽ� table���� �����ϴ� �����Ͱ� ������ �θ���� �õ�
	delete table emp01;
	delete table emp;
	commit;
	drop table dept;

-- 16. �ڽ� table�� �����Ѵ� �ϴ��� �ε����ϰ� ���� table �����ؾ��� ��� ����ϴ� ��ɾ�
drop table dept cascade constraint;

-- �������뿡 ������ ���̺� �����
-- purge recyclebin;

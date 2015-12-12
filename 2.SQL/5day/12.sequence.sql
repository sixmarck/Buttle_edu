-- 12.sequence.sql
/* �н�����
1. �������� ������ ������ ���� �ڵ� ����ġ
2. Ư¡
	- �ϳ��� sequence�� ���� table���� �����ؼ� ��뵵 ����
	  ��, ����ġ ������ ����ڰ� ���� ����
	- oracle ��ü������ ������ index ǥ���ϰ��� �Ҷ� ����(�Խ��� �Խù�ȣ ��...)
3. ����
	1. ����
		1) 1�� �ڵ� ����
			create sequence ��������;
			���� : �������� ���� - table_�÷�_seq
		2) ����ġ, �ִ�ġ ����
			create sequenct �������� start with �ʱ�ġ
							increment by ����ġ
							maxvalue �ִ�ġ;
	2. ����
		drop sequence ��������;
	3. �������� ���� ���
		��������.nextval

*/

-- 1. table ����
drop table customer;
create table customer (
	no number(3),
	id varchar2(10) primary key,
	pw varchar2(4) not null
);

-- 2. 1�� �ڵ� �����ϴ� ����� sequence ����
drop sequence customer_no;
create sequence customer_no;

-- 3. sequence�� Ȱ���� ������ ���� �� ����
insert into customer values(customer_no.nextval, 'master', '7777');
insert into customer values(customer_no.nextval, 'maste', '7777');
insert into customer values(customer_no.nextval, 'mast', '7777');
insert into customer values(customer_no.nextval, 'mas', '7777');
-- insert into customer values(1, 'master', '7777');

-- 4. sequence ����
drop sequence customer_no;

-- 5. ���ο� table ���� �� sequence�� �����غ���
drop table customer2;
create table customer2 (
	no number(3),
	id varchar2(10) primary key,
	pw varchar2(4) not null
);

insert into customer2 values(customer_no.nextval, 'master', '7777');
select * from customer;
select * from customer2;

-- 6. 2�� �ڵ� ���� �� 10������.. ������ִ� sequence �����غ���
create sequence cust2_no_seq start with 2 increment by 2 maxvalue 10;
insert into customer2 values(cust2_no_seq.nextval, 'master', '7777');
insert into customer2 values(cust2_no_seq.nextval, 'maste', '7777');
insert into customer2 values(cust2_no_seq.nextval, 'mast', '7777');
insert into customer2 values(cust2_no_seq.nextval, 'mas', '7777');
insert into customer2 values(cust2_no_seq.nextval, 'ma', '7777');
insert into customer2 values(cust2_no_seq.nextval, 'm', '7777');
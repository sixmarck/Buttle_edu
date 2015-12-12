-- 10.merge.sql
/* �н�����
1. ���� ���õ� ���� �н�
2. ����
	- ��ȸ�� 2��
		Acompany - ���� ��ȣ�� �ִ� ���� ����
		Bcompany - ���� ��ȣ�� �ִ� ���� ����
	- ���� 
		TotalCompany - A+B�� ��� ��ǰ ���հ���
			insert : A �Ǵ� B�� ���ο� ��ǰ �������� ���
				- ������ ���� ���� Ȯ�� ���� ��쿡�� ����
			update : �̹� �����ϴ� ��ǰ�� �߰� �������� ���
				- ������ ���� ���� Ȯ�� �̹� ������ȣ ��ǰ�� ���� ��� ���� ����
			delete : ���̻� ���� ��ȹ�� ������ ��� �ٴ�...
	- table ������ �䱸 : �� ��ȸ�簡 �����ϴ� �ڷ���� ������ table�� ���� �� ����
				  ���� table���� �ΰ��� ��� ��ǰ ���� �� ��� ���� �ؾ��ϴ� ��Ȳ
3. ����
	merge
		into �����͹ݿ�����table ��Ī
		using ����������table ��Ī
		on (���ǽ�)
	when matched then
		true�� ��� ����Ǵ� sql ����
	when not matched then
		false�� ��� ����Ǵ� sql ����
*/

-- TotalCompany, Acompany, Bcompany ���̺� ����
-- ��ǰ��ȣ(no), ����(quantity), �ݾ�(money)
create table Acompany(
	no number(4) primary key,
	quantity number(5) not null,
	money number(5, 2) not null
);
create table Bcompany(
	no number(4) primary key,
	quantity number(5) not null,
	money number(5, 2) not null
);
create table TotalCompany(
	no number(4) primary key,
	quantity number(5) not null,
	money number(5, 2) not null
);

-- �� table�� ������ ����
insert all
	into Acompany values(1111, 120, 100)
	into Acompany values(1112, 500, 700)
	into Acompany values(1113, 200, 500)
	into Acompany values(1114, 5000, 600)
	into Bcompany values(2222, 120, 100)
	into Bcompany values(2223, 500, 700)
	into Bcompany values(2224, 200, 500)
	into Bcompany values(2225, 5000, 600)
select * from dual;

-- TotalCompany table�� ��ǰ ���� �����ϴ� sql
	-- �������� ��� insert/�̹� ������ ��� update
merge
	into totalcompany allt
	using acompany a
	on (allt.no = a.no)
when matched
	then update set allt.quantity = allt.quantity + a.quantity
when not matched
	then insert values(a.no, a.quantity, a.money);

select * from totalcompany;

merge
	into totalcompany allt
	using bcompany a
	on (allt.no = a.no)
when matched
	then update set allt.quantity = allt.quantity + a.quantity
when not matched
	then insert values(a.no, a.quantity, a.money);

select * from totalcompany;
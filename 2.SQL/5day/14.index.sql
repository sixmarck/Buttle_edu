-- 14.index.sql
/* �н�����
1. index��? DB�� ���� �˻������� ���
2. ���� : �˻� �ӵ� ���
3. ���ǻ��� : ������ �ǽð� ���������� �ټ� �����Ǵ� ��쿡�� ����
4. oracle db ����
	- table�� pk�� ���� ��, �˻��� ���� �����͵��� �ڵ����� index�� �����


*/

-- 1. index �˻� �ӵ� Ȯ�ο� test table ����
drop table emp01;
create table emp01 as select * fro emp;
insert into emp01 select * from emp01;

-- 2. sql���� �ð� �˼� �ִ� ���
show index in emp01;
set time on

-- 3. pk���� �ڵ����� index ����� ��������� ����� ���� ���ο� index�� �����ؼ� ����
create index idx_emp01_empno on on emp01(empno);

-- 4. index ����
drop index idx_emp01_empno;

-- 5. ����ð� �˻� ����
set time off
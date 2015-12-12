-- 2.select.sql

/* emp table - ������� ���̺�
	empno	: ���
	ename	: �̸�
	job		: ����
	mgr		: ����� ���
	hiredate	: �Ի���
	sal		: ���޿�
	comm	: ���ʽ�(*���� ����� ���縸 �˸�, ���� ��, ������� �̿ܿ��� null(blank)�� �ν�)
	deptno	: �μ���ȣ

	dept table - �μ� ���� table
	deptno	: �μ���ȣ
	dname	: �μ���
	loc		: �μ� ��ġ

	select ����
		[1] select ��
			from ��
		
		[2] Ư�� �÷� �����ϱ�
			(asc : ��������, desc : ��������)
			select ��
			from��
			order by��

		[3] ���ǽ� : where
			select ��
			from��
			where��

		[4] ���ǽ� & ����
			(asc : ��������, desc : ��������)
			select ��
			from��
			where��
			order by��

*/

-- set linesize 200
-- set pagesize 200

-- purge recyclebin;
-- �������뿡 �ִ� ������ ����(?)

-- 1. �����ϴ� table ������ �˻�
select * from tab;

-- 2. emp table�� ��� ���� �˻�
select * from emp;

-- 3. emp table�� ���� Ȯ��
desc emp;

-- 4. dept table�� ���� Ȯ��
desc dept;

-- 5. emp�� dept table�� ���踦 ���� �˻�
select ename, sal*12, (sal*12)+comm from emp;
select ename, sal*12, (sal*12) + NVL(comm, 0) from emp;

-- 6. emp table ���(empno), �̸�(ename), ���� (sal*12) �˻�
select empno, ename, sal*12 form emp;

-- 7. �˻��� �÷��� ��Ī �ο� : emp table ���(empno), �̸�(ename), ���� (sal*12) �˻�
select empno, ename, (sal*12) as ���� form emp;
select empno, ename, (sal*12) ���� form emp;
select empno, ename, sal*12 as ���� form emp;

-- 8. emp���� �������� �Ҽӵ� �μ���ȣ �˻�, ��, �ߺ� ������ �˻��Ǹ� �ȵ�
select distinct deptno from emp;

-- 9. emp���� �������� �Ҽӵ� �μ���ȣ �˻�, ��, �ߺ� ������ �˻��Ǹ� �ȵ�
  -- ��, �������� �˻�
  -- �߰� Ű���� : asc - ��������, desc - ��������
select distinct deptno from emp;

-- 10. ? �����, ��� �˻� �� ����� ����, ������������ �ι� �˻�
	-- �˻��� �÷��� ��Ī���ε� ���� ����
select ename, empno
from emp
order by epno desc;

select ename, empno
from emp
order by empno asc;

select ename, empno as ���
from emp
order by ��� asc;

-- 11. �̸�(���ĺ�) �������� ����
select ename from emp;
select ename from emp order by ename desc;

-- 12. hiredate(�Ի���=DateŸ��) ��������(asc), ��������(desc) ����
select hiredate from emp order by hiredate;
select hiredate from emp order by hiredate desc;

*** [���ǽ� & ����] ***
-- 13. comm�� null�� ��� ��ȣ�� �μ� ��ȣ �˻��ϱ�
select empno, deptno, comm from emp;

select empno, deptno, comm
from emp
where comm is null;

select empno, deptno
from emp
where comm is null;

-- 14. comm�� null�� �ƴ� �����ȣ�� �μ���ȣ �˻��ϱ�
	-- not Ű����
select empno, deptno from emp where comm is not null;

-- 15. ? comm�� null�� �ƴ� �����ȣ�� �μ���ȣ �˻�, �� ����� ��������
select empno, deptno 
from emp 
where comm is not null 
order by empno desc;

-- 16. ? emp table���� �μ���ȣ(deptno)�� 20�� �μ��� ���� ��� ����� �̸��� �μ���ȣ �˻�
  -- = : ����� ������
select ename, deptno from emp where deptno = 20;

-- 17. ? ���̽� ����� ��� ���� �˻�(emp)

-- 18. ? sal�� 900�̻��� ������ �޿� �˻�
	-- sql������ ��Ģ �� �񱳿����� ��밡��
select ename, sal from emp where sal >= 900;

-- 19.? deptno�� 10 �̰� job�� �Ŵ����� ����̸� �˻�
   -- and
select ename from emp where deptno = 10 and job='MANAGER';

-- 20.? deptno�� 10 �̰ų� job�� �Ŵ����� ����̸� �˻�
   -- or
select ename from emp where deptno = 10 or job='MANAGER'; 

-- 21.? deptno�� 10�� �ƴ� ��� ����� �˻�
   --���������� : !=,<> , not
select ename from emp deptno <> 10;

-- 22.? sal�� 2000�����̰ų� 3000�̻��� �����, �޿� �˻�
   -- ��Һ� ������ Ȱ�� ����
select ename, sal from emp where sal <= 2000 or 3000 >= sal;

-- 23.? comm�� 300 or 500 or 1400 �����, comm�˻�
select ename, comm from emp where comm in(300, 500, 1400);

-- 24.? 81�⵵�� �Ի��� ����̸�, �Ի��� �˻�
	-- dataŸ���� value�� ' ' ǥ������
select ename, hiredate from emp where '81' = to_char(hiredate, 'YY');


-- 25. �˻��ܾ ���Ե� �����͵� �˻��� ������
	-- like : ��, _ǥ�� = ������, %�� �������� ������ ����
select ename from emp where ename like 'S';
select ename from emp where ename like 'S_';
select ename from emp where ename like 'S__';
select ename from emp where ename like 'S___';
select ename from emp where ename like 'S____';
select ename from emp where ename like 'S%';

-- 26.? �������� �����ϰ� M ������ ���Ե� ����� �˻�
select ename from emp where ename like '%M%';
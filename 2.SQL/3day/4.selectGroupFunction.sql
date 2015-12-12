-- 4.selectGroupFunction.sql
/* �н�����
1. �׷��Լ�
	- �ټ��� �� ���� ó���ؼ� �ϳ��� ������� ��ȯ���ִ� �Լ�
	- ������ �Լ�, ������ �Լ�
	- ����  : null ���� ö���� �ڵ� ������ ó��
		���� 10�� �μ��� com�޴� ��� �������� ��� count() ����� 0������ �˻�

2. ����
	1. count()
	2. sum()
	3. avg()
3. ����
	1. select �Լ� ... from table;
	2. ������ �Լ� ���� Ư�� �÷� �������� �׷캰 ���� ���
		select ��
		from ��
		[where ��]
		group by ��	- �׷��Լ� ����� ���� Ư�� ������ ����
					(����, 10�� �μ�����... 20�� �μ� ����...)
		[having ��]		- �׷��Լ��� ������ sql������ ���ǽ�
		[order by ��]
*/
-- 1. count() : ���� Ȯ�� �Լ�
	-- emp table���� ����� ������ ����?
select count(*) from emp;

-- 2. empno ��� �÷����� count() �Լ� ����
select count(empno) from emp;

-- 3. comm �� null�� ������ �÷����� count() �Լ� ����
	-- comm �޴� ��������?
	-- null�� ������ �÷��� �ڵ� �����Ǿ� �˻�
select count(comm) from emp;

-- 4. null���� �ڵ� �����ϴ°� �³�? Ȯ���� sum() �Լ��� test
select sum(sal) fromemp
	-- null �� ������ ������� �˻�
select sum(comm) from emp;

-- 5. ? �������� ����(sal)�� ��� ����� ����
select avg(sal) from emp;

select (sum(sal)/12)*count(*) from emp;

-- 6. ? emp table���� ����� �Ҽӵ� �μ����� ��, �ߺ�����
select distinct deptno from emp;

-- 7. ? MANAGER ����鸸�� �޿��� �˻��ϱ�
select sum(sal) 
from emp
where job='MANAGER';

-- 8. ? comm�޴� �����, �� Ŀ�̼���, Ŀ�̼� ��� �˻�
select count(comm), sum(comm), avg(comm)
from emp;

-- 9. min(), max() �Լ� �����ؼ� ���� ����� ����
	-- �ٹ��ϼ��� ���� ������ ����, ���� ���� �˻�

-- 10. ? �μ��� �޿� ��� �˻�
select deptno, avg(sal) from emp group by deptno;

-- deptno �������� ����
select deptno, avg(sal) from emp group by deptno order by deptno;

-- 11. ? �Ҽ� �μ��� �ִ� �޿�, �ּ� �޿� �˻�, �������� ����
select deptno, max(sal), min(sal)
from emp
group by deptno
order by deptno;

-- 12. ? �μ��� �����, Ŀ�̼� �޴� ����� �˻�
select deptno, count(*), count(comm)
from emp
group by deptno;

-- 13. ? �μ��� ��� �޿��� 2000�̻��� �μ��� �μ� ��ȣ�� ��� �޿� �˻�
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 2000;

-- deptno �������� �������� ����
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 2000
order by deptno;

-- 14. ? �μ��� �޿� ��� �˻� sal �޿� ����� 2000�̻��� �μ� �� 10�� �μ� ������ ����
select deptno, avg(sal)
from emp
where deptno <> 10
group by deptno
having avg(sal) > 2000;

-- 15. ? �Ի���� �ο��� �˻�, �� �ο����� 3���� �޿� ���ؼ��� �˻�
select to_char(hiredate, 'mm'), count(*)
from emp
group by to_char(hiredate, 'mm')
having count(*) = 3;


select to_char(hiredate, 'mm'), count(*)
from emp
group by to_char(hiredate, 'mm')
having 2 = 3;
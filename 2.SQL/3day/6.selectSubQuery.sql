-- 6.selectSubQuery.sql
/* �н�����
1. subquery - main query ���ο� �Ǵٸ� ���� 
2. ���
	- DQL[query], ���� : select
	- DML : insert/update/delete
3. �������
	- main ������ sub ���� �� � ������ ���� �켱��?
*/
-- 1. SMITH�� �ٹ��ϴ� �μ��� �˻�
select dname
from dept
where deptno = (select deptno from emp where ename = 'SMITH');

-- 2. ? SMITH�� �޿��� �����ϰų� �� ���� ����� �̸�, �޿� �˻�
	-- ��Ʈ : main�� sub���� ���̿� �پ��� ������ ��밡��
select ename, sal
from emp
where sal >= (select sal from emp where ename='SMITH') and ename <> 'SMITH';

-- 3. ? DALLAS�� �ٹ��ϴ� ����� �̸�, �μ���ȣ �˻�
select ename, deptno
from emp
where deptno = (select deptno from dept where loc='DALLAS');


-- 4. ? ��ձ޿�(avg()) ���� �� ���� �޴� ����� ��� ���� �˻�(emp tblae������ �˻�)
select * 
from emp
where sal > (select avg(sal) from emp);


-- 5. ? �޿��� 3000�̻��� ����� �Ҽӵ� �μ�(������)�� ���� �����, �޿� �˻�
	-- ��Ʈ : in ������ Ȱ��
select ename, sal
from emp
where deptno in (select deptno from emp where sal >= 3000);

-- 6. ? in �����ڸ� �̿��ؼ� �μ����� ���� �޿��� ���� �޴� ����� ����(���, �����, �޿�, �μ���ȣ) �˻�
select empno, ename, sal, deptno
from emp
where sal in (select max(sal) from emp group by deptno);
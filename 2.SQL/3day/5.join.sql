-- 5.join.sql
/* �н�����
1. ���� table�� �����͵��� ����� �����͸� �������� �˻��Ҷ� ����ϴ� ���
2. Ȱ�� table
	1. emp : ������� table
	2. dept : �μ����� table
	3. salgrade : �޿���� table
3. ����
	1. ��������
		- ���󵵰� ���� ����
		- = ����� ������
	2. not-equi ����
		- between ~ and
	3. self ����
		- ������ table�󿡼��� ����
		- ������� - �ϳ��� table�� �ټ��� tableó�� �������� �и�
				�̶� ��� ��� table�� ��Ī ����
	4. outer ����
		- null���� ������ �����͵� �˻�
		- self �Ǵ� ���� �ٸ� table�󿡼��� ���� �۾� ����
		- * oracle DB�� �˻� ������� null�� �ʿ� (+) ��ȣ ����
			�ٸ� DB�Ϻδ� �����Ͱ� null�� �ƴ��ʿ� ���̱⵵��
		*** ��� - � db����ϴ��Ŀ� ���� test �ʼ�
*/
-- ***[equi join]***
-- 1. SMITH�� �Ҽӵ� �μ��� �μ���ȣ�� ��ġ(loc) �˻�
select a.deptno, b.loc 
from emp a, dept b
where a.deptno = b.deptno and a.ename = 'SMITH';

-- 2. SMITH�� ���� ��� ���� �˻�(�μ���, �μ���ġ)
-- * �� �˻��ÿ� �� table�� �����ϴ� ��� �÷� ������ �˻� ���� �ߺ� �÷� �˻� ����� �÷��� �ϳ��� ��� ����
select a.*, b.*
from emp a, dept b
where a.deptno = b.deptno and a.ename = 'SMITH';

-- 3. ? NEW YORK �� �ٹ��ϴ� ����� �̸�(ename)�� �Ի���(hiredate) �˻�
select a.ename, a.hiredate
from emp a, dept b
where a.deptno = b.deptno and b.loc = 'NEW YORK';

-- 4. ? ACCOUNTING �μ��� �Ҽӵ� ����� �̸��� �޿� �˻�
select a.ename, a.sal
from emp a, dept b
where a.deptno = b.deptno and b.dname='ACCOUNTING';

-- 5. ? ������ MANAGER�� ����� �̸�, �μ��� �˻�
select a.ename, b.dname
from emp a, dept b
where a.deptno = b.deptno and a.job = 'MANAGER';

-- ***[not-equi join]***
-- 6. ? �� ������� �޿��� �޿� ��� �˻�
select a.ename, a.sal, b.grade
from emp a, salgrade b
where a.sal between b.losal and b.hisal;

-- 7. ? ����� 3����� ������� �̸��� �޿� �˻�
select a.ename, a.sal
from emp a, salgrade b
where a.sal between b.losal and b.hisal and b.grade = 3;

-- ***[self join]***
-- 8. SMITH ����� ����̸� �˻��غ���
	/* �˻� tip : self join�ÿ��� �ϳ��� table �������� ����
	��, �������� table�� ��ĥ ����
	���� ��� table�� ��Ī a, ��� table�� ��Ī b
	*/
select a.empno, a.ename, b.ename
from emp a, emp b
where a.mgr = b.empno;

-- 9. ? ��簡 KING�� ������� �̸��� job �˻�
select e.ename, e.job
from emp e, emp m
where m.empno = e.mgr and m.ename='KING';

-- 10. ? SMITH�� ������ �ٹ������� �ٹ��ϴ� ����� �̸� �˻�
select a.ename
from emp a, dept b
where a.deptno = b.deptno and b.loc = 'DALLAS';

select f.ename
from emp e, emp f
where e.ename='SMITH' and e.deptno = f.deptno
and f.ename != 'SMITH';

select a.ename
from emp a, dept b
where a.deptno = b.deptno and b.loc in
( select b.loc from emp a, dept b where a.deptno = b.deptno and a.ename = 'SMITH');

-- 11. ? CLARK ������� �ʰ� �Ի��� ������� ������ �˻� (�̸�, �Ի��� ��, �Ի��Ͽ� ���� �������� ����)

select b.ename, b.hiredate
from emp a, emp b
where a.ename = 'CLARK' and b.hiredate > a.hiredate
order by hiredate asc;


-- �°� ) ��簡 blake�� ������� ��� ������ ���Ͻÿ�.
select avg(e.sal*12)
from emp e, emp m
where m.ename = 'BLAKE' and e.mgr = m.empno;

-- ***[outer join : �ܺ�����]***
-- 12. +��ȣ�� ����ؼ� null �����͸� �����ϰ� �ִ� �÷������� �˻��ϰ��� �� ��� ����
select ename, d.deptno, dname
from emp, dept
where emp.deptno(+) = dept.deptno;

-- 13.? ��� ������ �ش��ϴ� ����� ����, �� ��簡 ���� ����̶� �˻�
	-- KING�� ��簡 ���� ���
select e.empno, e.ename, m.ename
from emp e, emp m
where m.empno(+) = e.mgr;

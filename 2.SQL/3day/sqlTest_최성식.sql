/* 1.
    emp ���̺��� �̸�, �޿�, ����, �Ѿ��� ���Ͽ� �Ѿ��� ���� �������� ����϶�.
    ��, ������ ���� ����� ���ܽ�Ű��, �Ѿ��� �޿��� ������ ���� �ݾ��̴�.
    �Ѿ� = �޿� + ����
*/
select ename,
	sal,
	comm,
	sal+comm as �Ѿ� 
from emp 
where comm is not null
order by �Ѿ� desc;

/* 2.
    10�� �μ��� ��� ����鿡�� �޿��� 13%�� Ư���󿩱����� �����ϱ�� �Ͽ���.
    �̸�, �޿�, Ư���󿩱�, �μ���ȣ�� ����϶�.
    Ư���󿩱� = sal * 13%
    * Ư���󿩱��̶�°���? sal + sal * 13%�� �ؾ� ���� �������? 
*/
select ename, sal, sal* 0.13 as Ư���󿩱�, deptno
from emp 
where deptno = 10;


/* 3.
    30�� �μ����� ������ ����Ͽ� �̸�, �μ���ȣ, �޿�, ���� ������ ������ ū�������� ����϶�.
    ��, ������ �޿��� 150%�� Ư���󿩱����� �����Ѵ�. ������ õ���� �̸� ����ó���Ѵ�.
    ���� = (sal * 12) + (sal * 150%)
*/
select ename,
	deptno,
	sal,
	trunc((sal*12) + (sal * 1.50), -3) as ���� 
from emp 
where deptno = 30
order by ���� desc; 


/* 4.
    �μ���ȣ�� 20�� �μ��� �ð��� �ӱ��� �ñ��� ����Ͽ� ����϶�.
    ��, 1���� �ٹ��ϼ��� 12���̰�, 1�� �ٹ��ð��� 5�ð��̴�.
    ��¾���� �̸�, �޿�, �ð��� �ӱ�(�Ҽ����� 1��° �ڸ����� �ݿø�)�� ����϶�.
    �ñ� = sal /�ϼ� *�ð�
    round(m, n) m�� �Ҽ��� n�ڸ����� �ݿø�
*/
select ename,
	sal,
	round(sal/12*5) as �ñ� 
from emp
where deptno = 20;

/* 5.
    �޿��� 1500���� 3000������ ����� �޿��� 15%�� ��ȸ��� �����ϱ�� �Ͽ���.
    ��¾���� �̸�, �޿�, ȸ��(10�� ������ �ݿø� ó��) ������ ����϶�.
	ȸ��  = sal * 0.15
	���� 2��° �ڸ����� �ݿø� : 100 ������ ���
*/
select ename,
	sal,
	round(sal*0.15,-2) as ȸ��
from emp
where sal between 1500 and 3000;

/* 6.
    �޿��� 2000 �̻��� ��� ����� �޿��� 15%�� ������� ����� �Ͽ��� .
    �̸�, �޿�, ����(�Ҽ������� ���� ó��) ������ ����϶�.
	������ = sal * 0.15
	* ������ ���� �ϰ� ������, ������ ����ϴ°��� ����.
*/
select ename, sal,  trunc(sal*0.15) as ������
from emp
where sal >= 2000;

/* 7.
    �Ի��Ϻ��� ������ ������ ��¥���� ����϶�.
    �μ���ȣ, �̸�, �Ի���, ������, �ٹ��ϼ�,
    �ٹ����, �ٹ�����(30�� ����), �ٹ��ּ�(7�� ����) ������ ����϶�.
	��, �ϼ�, ���, ����, �ּ��� ���  �Ҽ��� ���� ����ó���϶�.

    -- ���� ��¥ : sysdate
	-- �ٹ� �ϼ� : ���糯¥ - �Ի��� = sysdate - hiredate  -> ��¥ - ��¥ : �ϼ� ����
	-- �ٹ� ��� : to_char(sysdate,'YYYY') - to_char(hiredate,'YYYY')
	-- �ٹ� ���� : �ٹ��ϼ� / 1��(30��)
	-- �ٹ� �ּ� : �ٹ� �ϼ� /1�� (7��)
*/
select deptno,
	ename,
	hiredate,
	sysdate as ������,
	trunc(sysdate-hiredate) as �ٹ��ϼ�,
	to_char(sysdate, 'yyyy') - to_char(hiredate, 'yyyy') as �ٹ����, 
	trunc((sysdate-hiredate)/30) as �ٹ�����,
	trunc((sysdate-hiredate)/ 7) as �ٹ��ּ�
from emp;

/* 8.
    ��� ����� �޿����� ������ ������ �Ǽ��ɾ��� ����Ͽ� ����϶�.
    ��, �޿��� ���� ������ �̸�, �޿�, �Ǽ��ɾ��� ����϶�.
    ���� = �޿� * 10%
	�Ǽ��ɾ� = �޿� - ����
*/
select ename,
	sal,
	sal - (sal*0.1)as �Ǽ��ɾ�
from emp
order by �Ǽ��ɾ� desc;

/* 9.
    �Ի��Ϸ� ���� 100���� ���� ���� ����̸�, �Ի���, �Ի� 100������ ��¥, �޿� ������ ����϶�.
	90���� = hiredate + 100  :  ��¥ + ����(��) = ��¥
	* 90���� ?
*/
select empno,
	hiredate,
	hiredate + 100 as "�Ի� 100������ ��¥",
	sal
from emp;

/* 10.
    �Ի��Ϸκ��� 6������ ���� ���� �Ի���, 6���� ���� ��¥, �޿��� ����϶�.
	6���� �� �Ի��� : add_months(hiredate, 6);
	* 6���� ���� ��¥?
*/
select add_months(hiredate, 6),
	add_months(sysdate, 6),
	sal
from emp;

/* 11.
    �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ, �̸�, �Ի��, �ٹ��ϼ��� ����϶�.
	-- �Ի��Ѵ��� �ٹ��ϼ� :  last_day(hiredate) - hiredate
	* �Ի��Ѵ��� �ٹ��ϼ� ?
*/
select deptno,
	ename,
	to_char(hiredate, 'mm') as �Ի��,
	last_day(hiredate)- hiredate as �ٹ��ϼ�
from emp;

/* 12.
    ��� ����� 60���� ���� ���� monday�� ���, ���, �����ΰ��� ���Ͽ� �̸�, �Ի���, monday�� ����϶�.
	-- NEXT_DAY (DATE, CHAR)
	-- ����Ŭ �ý����� ǥ�������� OS�� ���� Locale ����
	-- CHAR�� �ѱ� ������� '��','ȭ', ���� ������ : MONDAY,...SUNDAY ����
*/
select ename,
	hiredate,
	next_day(hiredate + 60, '��') as monday
from emp;

/* 13.
    �Ի��Ϸκ��� �����ϱ����� �ϼ��� ���Ͽ� �̸�, �Ի���, �ٹ��ϼ��� ����϶�.
    ��, �Ҽ����� �ݿø� ó��
*/
select ename,
	hiredate,
	round(sysdate - hiredate) as �ٹ��ϼ�
from emp;

/* 14.
    �Ի����� 1996�� 5�� 14���� ���·� �̸�, �Ի����� ����϶�.
	-- ��¥ ���� �տ� fm �� ���� '0'�� ǥ������ ����, 1, 2, .. 9, 10, 11, 12
	-- 1990/04/02  'fmYYYY/MM/DD'  ==>  1990/4/2
*/
select ename,
	to_char(hiredate, 'fmyyyy') || '�� ' || to_char(hiredate, 'fmmm') || '�� ' || to_char(hiredate, 'fmdd') || '�� '
from emp;

/* 15.
    �̸��� ���ڼ��� 6�ڸ� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.
	-- substr(str, position, length)
	-- lower(str)  �ҹ��� ��ȯ
	-- length(str)  str�� ����
*/
select lower(substr(ename, 0,3))
from emp
where length(ename) >= 6;

/*16.
    10�� �μ������� ������ ���,  �ְ�, ����, �μ� �ο����� ���Ͽ� ����϶�.
    ��, ��ձ޿��� �Ҽ����� �ݿø� ó���϶�.
*/
select round(avg(sal)), max(sal), min(sal), count(*)
from emp
where deptno = 10
group by deptno;

/* 17.
    �� �μ��� �޿��� ���, �ְ�, ����, �ο����� ���Ͽ� �μ��ο����� ���� �������� ���� ����϶�.
    ��, ��ձ޿��� �Ҽ����� �ݿø� ó���϶�.
*/
select round(avg(sal)), max(sal), min(sal), count(*)
from emp
group by deptno
order by 4 desc;

/* 18.
    �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ, ������, ���� �ο����� ����϶�.
    ��, ������ �ø����� ���� ��ȸ�϶�.
    * ������(?)
*/
select deptno, job, count(*)
from emp
group by deptno, job
order by 1, 2;

/**
    19. ���� ������ �ϴ� ����� ���� 4�� �̻��� ������ �ο����� ����϶�.
*/
select job, count(*)
from emp
group by job
having count(*) >= 4;


/* 20.
    �� �μ��� ��տ���, ��ü����, �ְ����, ��������,�� ���Ͽ� ��տ����� ���������� ����϶�.
    ��, ��տ����� 2000 �̻��� �μ��� �������� ��ȸ����϶�.
*/
select avg(sal), sum(sal), max(sal), min(sal)
from emp
group by deptno
having avg(sal) >= 2000
order by 1 desc;

/* 21.
    ������ �μ���ȣ, �μ���, ���, �̸�, ���� ������ ����϶�.
*/
select b.deptno, b.dname, a.empno, a.ename, a.job
from emp a, dept b
where a.deptno = b.deptno;

/* 22.
    10�� �μ� ������ �μ���ȣ, �μ���, ���, �̸�, ���� ������ ����϶�.
*/
select b.deptno, b.dname, a.empno, a.ename, a.job
from emp a, dept b
where a.deptno = b.deptno and b.deptno = 10;

/* 23.
   ������ ���, �����, �μ�����, �μ���� ������ ����϶�.
*/
select a.empno, a.ename, b.empno, b.ename
from emp a, emp b
where b.empno = a.mgr;

/* 24.
   ������ ���, �����, �μ�����, �μ���� ������ ����� ����� ���Ͽ� ������������ ���� ����϶�.
   ��, ��簡 ���� ������ ������ �Բ� ��ȸ ����϶�.
*/
select a.empno, a.ename, b.empno, b.ename
from emp a, emp b
where b.empno(+) = a.mgr
order by 3;

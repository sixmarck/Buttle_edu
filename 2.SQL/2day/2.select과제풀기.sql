/*2015/11/26 sql  10���� ����*/

--1.  ��簡 �ִ� ���, ����� �̸��� ����� ����� ����Ͻÿ�.
select ename, mgr from emp where mgr is not null;

--2. ������ clerk�̰� 80�⵵�� �Ի��� ����� �̸��� ������ ����Ͻÿ�.
select ename, sal*12+nvl(comm,0) as ���� from emp where job = 'CLERK' and '80' = to_char(hiredate, 'YY');

--3. �μ���ȣ�� 20�� ����� �̸��� ������������ ����Ͻÿ�.
select ename from emp where deptno='20' order by ename;

--4. ������ 16000 �̻� �̰�, ���ʽ��� �����ϴ� ����� �̸��� �޿�, ���ʽ� ������ ����Ͻÿ�.
select ename, sal, (sal*12), comm from emp where (sal*12) >= 16000 and comm is not null;

--5. ���� �̸��� A�� ���� ����� �̸��� ������ ����Ͻÿ�.
select ename, job from emp where job like '%A%';

--6. �μ� ��ȣ�� 20 �Ǵ� 30�̰� �μ���ġ�� L�� ���� �μ����� ����Ͻÿ�.
select dname from dept where deptno in(20, 30) and loc like '%L%';

--7. ����� M�� T�� ���� ����� ��� ������ ����Ͻÿ�.
select * from emp where ename like '%M%' and ename like'%T%';

--8.���ʽ��� 300���� 500 ������ ����� �̸��� ������ ����Ͻÿ� (������ �������� ��������.)
select ename, (sal*12)+nvl(comm, 0) as ���� from emp where comm between 300 and 500 order by ���� desc;

--9. �Ի����� 12���� ����� �̸�, ����, �Ի����� ����Ͻÿ�(�Ի����� �������� ��������.)
select ename, job, hiredate from emp where '12' = to_char(hiredate, 'mm') order by hiredate;

select ename, job, hiredate from emp where hiredate like '__/12/__' order by hiredate desc;

select ename, job, hiredate from emp where hiredate between '80/12/01' and '80/12/31' or hiredate between '81/12/01' and '81/12/31' order by hiredate;

--10.�μ����� S�� ������ �μ���� �μ���ġ�� ����Ͻÿ�.
select dname, loc from dept where dname like '%S';
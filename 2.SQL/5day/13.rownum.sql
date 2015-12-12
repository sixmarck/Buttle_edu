-- 13.rownum.sql
/* �н�����
1. rownum : �˻��� �����Ϳ� ��ȣ�� �ڵ� �����ϴ� �÷�
2. ���� : sql ��ü������ �ټ��� �Խñ� ���� paging ó���� ����
	�߼� - �������� ��� javascript(js)�ε� ó���ϱ⵵��
	���� - �ڹٿ� ���� ������ ó�� ���ε� paging ó������
3. �ζ��� �� �����̶�? from ���� table�� ��ſ� select �� �ݿ��� ����

*/

-- 1. emp table���� �Ի����� ���� ���� ����� 5������� �˻�
select * from (select hiredate, ename
from emp
order by hiredate desc)
where rownum <= 5;

-- 2.? emp table���� �޿��� ���� �޴� ������� 3�� �̸��� �޿� �˻�
select * from (select ename, sal
from emp
order by sal desc)
where rownum <= 3;


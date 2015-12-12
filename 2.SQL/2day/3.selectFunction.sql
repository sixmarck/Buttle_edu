--3.selectFunction.sql
/*�Լ�
1. �Լ� : oracle db���� �̹� �پ��� �������� ���ߵǾ� �����ϴ� �Լ���
2. ����
	2-1. ������ �Լ� : �� �ϳ��� �ϳ��� ������� ��ȯ
	2-2. ������ �Լ�(�׷��Լ�) : �ټ��� ����� �����ؼ� ó���� �ϳ��� ������� ��ȯ
*/

-- 1. oracle db���� �����ϴ� ������ �ӽ� table
	-- dummy table�̶�� �� : dual table
select 2+3 from dual;

-- 2. �� ��¥ �˻�
select sysdate from dual;

-- *** [���� �Լ�] ***
-- 3. round(������ [, �ݿø� �޴� ��ġ]) - �ݿø� �Լ�
	-- �ݿø� �޴� ��ġ : ��� - �Ҽ��� �����ڸ�, ���� - �����ڸ� �ǹ�
select 34.24, round(34.24), round(34.24, -1), round(34.24, 1) from dual;
select 36.28, round(36.28), round(36.28, -1), round(36.28, 1) from dual;

-- 4. abs(������) : ���밪 ���� �Լ�
select -10, abs(-10) from dual;

-- 5. trunc() : �߶󳻴� �Լ�
select 34.24, trunc(34.24), trunc(34.67) from dual;

select 34.24, trunc(34.24, 1), trunc(34.67, -1) from dual;

-- 6. mod() : ������ �� �������� ����
select mod(17,2) from dual;

-- 7.? emp table���� ����� Ȧ���� �����, ��� �˻�
select ename, empno from emp where mod(empno, 2) = 1;

-- 8. upper() : �빮�ڷ� ��ȯ
select upper('Buttle') from dual;

-- 9. lower() : �ҹ��ڷ� ��ȯ
select lower('Buttle') from dual;

-- 10. manager��� �ҹ����� �����ͷ� ���� ������ �������� job�� �̸� �˻�
select ename, job form emp where lower(job) = 'manager';

-- 11. length() : ���ڿ� ���� �˻�, lengthb() : byte ��� ��ȯ �Լ�	
	-- �ѱ� �� ���� : 2byte, ���� ���� 1byte�� ����ؼ� ���� ��ȯ
	-- ��, xe ������ �����󿡼� �ѱ� �� ������ 3byte�� ���
select length('��'), lengthb('��'), length('a'), lengthb('b') from dual;

-- 12. substr(������, ������ġ, ���ⰹ��) : ���ڿ� ����  �Լ�
select substr('abcde', 2, 3) from dual;

-- 13. ? emp table���� �Ի���鸸 �˻�
select substr(hiredate, 4,2) || '��' from emp;

-- 14. ? emp ���̺��� �⵵ ���о��� 2���� �Ի��� �����, �Ի��� �˻�
select ename, hiredate from emp where substr(hiredate, 4, 2) = '02';

-- 15. trim() : ���ڿ� �յ��� �׿� ���� ���� �Լ�
select length(trim(' a b ')), trim(' a b '), length(' a b '), ' a b' from dual;

-- 16. emp ���̺��� �̸� ������ 5�� ������ ����� �̸��� �˻�
select ename from emp where length(trim(ename)) = 5;

-- 17.? �޿��� 4�ڸ��� �ʰ��ϴ� ����� ���� �˻�
select * from emp where length(sal) < 4;

-- ***[ ��¥ �Լ� ]***
-- 18.? ����, ����, ���� ��¥ �˻�
select sysdate-1, sysdate, sysdate+1 from dual;

-- 19.? emp table ���� ����� �ٹ��Ⱓ�� �ϼ� ���
select sum(trunc(sysdate-hiredate)) from emp;

-- 20. add_months() : ������ ���ϴ� �Լ�
select add_months(sysdate, 2) from dual;

-- 21.? emp table�� SMITH ������ �Ի��� �Ϸκ��� 3���� ���� ��¥ �˻��ϱ�
select add_months(hiredate, 3) from emp where ename='SMITH';

-- 22. months_between() : �� ��¥ ������ ������ �˻�
select months_between(sysdate, '2014-11-10') from dual;

-- 23. next_day() : ������ �������� ���� ���Ͽ� �ش��ϴ� Ư�� ��¥ �˻�
	-- ���ǻ��� : db ��ġ �ý����� ���ڵ��� �켱, �Ӽ��� �����ؼ� Ÿ���� ��뵵 ����
select sysdate, next_day(sysdate, '������') from dual;
select sysdate, next_day(sysdate, '��') from dual;

-- 24. last_day() : ���õ� ��¥�� �������� �ش� ���� ������ ��¥ �˻�
select sysdate, last_day(sysdate) from dual;

-- ***[����ȯ �Լ�]***
/* 1. to_char()		: ����Ÿ������ ��ȯ
	* ��¥�� ����Ÿ�� : ��¥������ ���ϴ� �������� �����ؼ� �˻�
		-��� ǥ���
			hh:mi:ss		- 12�ð� ������ �ú���
			hh:mi:ss dy	- 12�ð� ������ ����
			hh24:mi:ss		- 24�ð� ������ �ú���
			hh:mi:ss am	- �ú��� ���� ����

	* ���ڸ� ����Ÿ��
		- �ڸ��� ǥ���� 9 or 0���� ǥ��
		- ȭ����� ǥ�� ���� : L or l or �� ���� ����
    
    2. to_date()		: ��¥Ÿ������ ��ȯ
    3. to_number()	: ����Ÿ������ ��ȯ

*/

-- 25. to_char() : ��¥�� ���������� ��ȯ
select sysdate, to_char(sysdate, 'yyyy-mm-dd'	) from dual;

-- 26.? SMITH�� �Ի��Ͽ� ���� 24�ð� ������ �˻�, ����? ����? ����?
select ename, to_char(hiredate, 'yyyy-mm-dd hh:mi:ss dy am') from emp where ename='SMITH';

-- 27.? �ù� ȸ��� ����, 12�� ������ �ֹ��� ���� �߼�, 12�� ������ �ֹ��� ���� �߼�
-- order�� ������ �ϴµ� ���ù߼�? ���Ϲ߼�? �� ���� �˻� sql ����
select substr(to_char(sysdate, 'hh24:'), 12, 2) as ���ù߼�,
substr(to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'), 12, 2) as ���Ϲ߼�
from dual;

--���� �ð��� �������� round() �ݿø�, �� 12�ð� ������ ���ϳ�¥�� �˻�
select sysdate, round(sysdate), trunc(sysdate) from dual;

select sysdate, to_char(round(sysdate), 'yyyy-mm-dd hh24:mi:ss') from dual;
select sysdate, to_char(trunc(sysdate), 'yyyy-mm-dd hh24:mi:ss') from dual;

-- 28. to_char()�� ���� �ڸ����� �ǹ��ϴ� 9 �Ǵ� 0�̶� ���ڷ� ������ ǥ��
	-- ���ڸ� ���ڷ� ��ȯ
	/* L or l - local�� ��� ���� �ش� os�� �⺻ ���ڵ��� ȭ����� ǥ��
		999,999 : ���ڸ����� �����͸� ǥ���ϵ� ',' ǥ�⵵ ���� ���� õ���� ���� ǥ���� ����
		0 : 0���� ä���� �ڸ�����ŭ �����͵� ǥ��, ��ȿ�� ������ �ʰ��ؼ� ǥ���� ��� 0���� �ڸ����� ä����

	*/
select 1234, to_char(1234, '99999.99') from dual;
select 1234, to_char(1234, '$99999.99') from dual;
select 1234, to_char(1234, '99999') from dual;
select 1234, to_char(1234, '999,99') from dual;
select 1234, to_char(1234, 'L99999.99') from dual;

select 1234, to_char(1234, '00000') from dual;
-- select 1234, to_char(1234, '999') from dual; ����

-- 29. ? ���� ��ĥ�� �������� �˻�
select trunc(sysdate-to_date('20150101', 'yyyymmdd')) || '�� ����' as "���� ��¥ ����" from dual;
select to_date(sysdate) - to_date('20150101', 'yyyy/mm/dd') from dual;

-- 30. to_number() : ���ڷ� ��ȯ��Ű�� �Լ�
--select '20,000' - '10,000' from dual; ���ڿ��� ���ֵǾ� ����Ұ�

select to_number('20,000', 99999) - to_number('10,000', 99999) from dual;

-- õ�ڸ� ǥ���ϴ� ��ǥ �����ϰ��� �Ѵٸ� ���?
select to_char(to_number('20,000', 99999) - to_number('10,000', 99999), '999,999') from dual;
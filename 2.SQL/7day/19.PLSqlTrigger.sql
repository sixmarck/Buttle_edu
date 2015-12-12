-- 19.PLSqlTrigger.sql
/* �н�����
1. trigger
	- sql ��ü������ �̺�Ʈ(Ư�� action�� ���� �ڵ� ����) ó�� ���
	- �� : ������ ���α׷��̶� ����
		��ǰ table(���� �Ǹ� ������ ��ǰ�� ���� ������) : ��� ���� table
		= ��ǰ table�� ���ο� ��ǰ insert
		   ��ǰ table�� �̹� �����ϴ� ��ǰ ���� �߰�
		   ��ǰ table�� �̹� �����ϴ� ��ǰ ���� ����
		   ��ǰ table�� �̹� �����ϴ� ��ǰ ���� ����
	- backup table �߰� ����
2. ����
	1) ����
		�������					- before or after
		����Ǵ� ���				- sql����
		trigger�� ����޴� table/view		- on �̺�Ʈ �߻� table��
		�������					- �̺�Ʈ ó�� ����
	2) ����
		create [or replace] trigger �̸�
		before �Ǵ� after
		on table�� / view��
		[for each row]
		�������	begin~end;
		/
3. �ֿ� Ű���� �� �Լ���
	1) raise_application_error(�����ѹ�, �����޼���)
		- ����ڰ� oracel db�� �����ѹ��� �޼����� ������ų�� �ִ� �Լ�
		- ���ǻ��� : �����ѹ��� - ǥ�� ���
	2) :old - �̹� table���� �����ϴ� ������
	3) :new - table���� ������ ���ο� ������
*/

-- 1. ȸ�����Ե� user�� ������ Ż���ϴ� ������ Ż��ȸ���� ������ �����ϰ� �Ǵ� table�� ������ �̰�
	-- user1������ delete, backup_user�� insert
drop table backup_user;
drop table user1;
create table user1(
	id varchar2(10) primary key,
	pw varchar2(4) not null
);
-- user1���� �����Ǵ� �����Ϳ� ���ؼ��� �����ϰ� �Ǵ� table
create table backup_user(
	id varchar2(10) not null,
	pw varchar2(4) not null,
	delete_time date
);

insert into user1 values('master', 7777);

-- user1���� �����Ͱ� �����ɶ� �ڵ����� backup_user�� insert�Ǵ� ��� ����
create or replace trigger delete_user1
after
	delete
on user1
for each row
begin
	insert into backup_user values(:old.id, :old.pw, sysdate);
end;
/

select * from backup_user;			-- ������ ������
delete from user1 where id='master';	-- delete�ÿ��� �̺�Ʈ �ڵ� �߻�
select * from user1;
select * from backup_user;			-- trigger�� ���� �ڵ� insert��

-- 2. ���� 10~����11�ñ����� �ֹ�����, �� ���Ŀ��� '�ֹ��ð� �ƴմϴ�.'�� ���� ���� �߻�
	-- raise_application_error(�����ѹ�, �����޼���) : 
-- select to_char(sysdate, 'hh:mi') from dual;
-- select to_char(sysdate, 'hh24:mi') from dual;
drop table order_table;
create table order_table(
	no number,
	order_code varchar2(10),
	order_date date
);

drop trigger timeover;
create or replace trigger timeover
before
	insert
on order_table
begin
	if(to_char(sysdate, 'hh24:mi') not between '11:00' and '12:00')
	then
		raise_application_error(-20100, '�ֹ��ð� �ƴմϴ�.');
	end if;
end;
/

insert into order_table values(1, 'kkk', sysdate);

-- 3. Ư�� table�� ����� �� �ܾ ����õ� �Ϸ� �Ҷ� '�� �ܾ�� ��� �Ұ��Դϴ�.' ��� �޼��� �߻���Ű�� trigger �����ϱ�
	-- 'master' ����õ� �ϸ� �ȵǴ� ��Ȳ...
drop table check_test;
create table check_test(
	msg varchar2(10)
);

create or replace trigger ck_word
before
	insert
on check_test
for each row
begin
	if(:new.msg in('master')) then
		raise_application_error(-20111, '�� �ܾ�� ��� �Ұ��Դϴ�.');
	end if;
end;
/

insert into check_test values('kkk');
insert into check_test values('master');
select * from check_test;
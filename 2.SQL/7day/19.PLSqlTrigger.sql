-- 19.PLSqlTrigger.sql
/* 학습내용
1. trigger
	- sql 자체적으로 이벤트(특정 action에 대한 자동 반응) 처리 기능
	- 예 : 재고관리 프로그램이라 가정
		제품 table(현재 판매 가능한 제품에 대한 정보만) : 재고 관리 table
		= 제품 table에 새로운 제품 insert
		   제품 table에 이미 존재하는 제품 수량 추가
		   제품 table에 이미 존재하는 제품 수량 감소
		   제품 table에 이미 존재하는 제품 수량 삭제
	- backup table 추가 설계
2. 구조
	1) 구성
		실행시점					- before or after
		실행되는 사건				- sql문장
		trigger가 영향받는 table/view		- on 이벤트 발생 table명
		실행로직					- 이벤트 처리 로직
	2) 문법
		create [or replace] trigger 이름
		before 또는 after
		on table명 / view명
		[for each row]
		실행로직	begin~end;
		/
3. 주요 키워드 및 함수명
	1) raise_application_error(에러넘버, 에러메세지)
		- 사용자가 oracel db에 에러넘버와 메세지를 생성시킬수 있는 함수
		- 주의사항 : 에러넘버에 - 표기 기술
	2) :old - 이미 table내에 존재하는 데이터
	3) :new - table내에 없었던 새로운 데이터
*/

-- 1. 회원가입된 user의 정보를 탈퇴하는 시점에 탈퇴회원들 정보만 보유하게 되는 table로 데이터 이관
	-- user1에서는 delete, backup_user는 insert
drop table backup_user;
drop table user1;
create table user1(
	id varchar2(10) primary key,
	pw varchar2(4) not null
);
-- user1에서 삭제되는 데이터에 한해서만 저장하게 되는 table
create table backup_user(
	id varchar2(10) not null,
	pw varchar2(4) not null,
	delete_time date
);

insert into user1 values('master', 7777);

-- user1에서 데이터가 삭제될때 자동으로 backup_user에 insert되는 기능 구현
create or replace trigger delete_user1
after
	delete
on user1
for each row
begin
	insert into backup_user values(:old.id, :old.pw, sysdate);
end;
/

select * from backup_user;			-- 데이터 미존재
delete from user1 where id='master';	-- delete시에만 이벤트 자동 발생
select * from user1;
select * from backup_user;			-- trigger로 인해 자동 insert됨

-- 2. 오전 10~오전11시까지만 주문받음, 그 이후에는 '주문시간 아닙니다.'에 대한 에러 발생
	-- raise_application_error(에러넘버, 에러메세지) : 
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
		raise_application_error(-20100, '주문시간 아닙니다.');
	end if;
end;
/

insert into order_table values(1, 'kkk', sysdate);

-- 3. 특정 table에 금지어가 된 단어를 저장시도 하려 할때 '이 단어는 사용 불가입니다.' 라는 메세지 발생시키는 trigger 개발하기
	-- 'master' 저장시도 하면 안되는 상황...
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
		raise_application_error(-20111, '이 단어는 사용 불가입니다.');
	end if;
end;
/

insert into check_test values('kkk');
insert into check_test values('master');
select * from check_test;
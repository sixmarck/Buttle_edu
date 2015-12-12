-- 12.sequence.sql
/* 학습내용
1. 데이터의 고유한 구분을 위한 자동 증가치
2. 특징
	- 하나의 sequence는 다중 table에서 공유해서 사용도 가능
	  단, 증가치 조절은 사용자가 하지 못함
	- oracle 자체적으로 고유한 index 표현하고자 할때 적합(게시판 게시번호 등...)
3. 문법
	1. 생성
		1) 1씩 자동 증가
			create sequence 시퀀스명;
			참고 : 시퀀스명 권장 - table_컬럼_seq
		2) 증가치, 최대치 설정
			create sequenct 시퀀스명 start with 초기치
							increment by 증가치
							maxvalue 최대치;
	2. 삭제
		drop sequence 시퀀스명;
	3. 시퀀스값 적용 방법
		시퀀스명.nextval

*/

-- 1. table 생성
drop table customer;
create table customer (
	no number(3),
	id varchar2(10) primary key,
	pw varchar2(4) not null
);

-- 2. 1씩 자동 증가하는 기능의 sequence 생성
drop sequence customer_no;
create sequence customer_no;

-- 3. sequence를 활용한 데이터 생성 및 저장
insert into customer values(customer_no.nextval, 'master', '7777');
insert into customer values(customer_no.nextval, 'maste', '7777');
insert into customer values(customer_no.nextval, 'mast', '7777');
insert into customer values(customer_no.nextval, 'mas', '7777');
-- insert into customer values(1, 'master', '7777');

-- 4. sequence 삭제
drop sequence customer_no;

-- 5. 새로운 table 생성 후 sequence를 공유해보기
drop table customer2;
create table customer2 (
	no number(3),
	id varchar2(10) primary key,
	pw varchar2(4) not null
);

insert into customer2 values(customer_no.nextval, 'master', '7777');
select * from customer;
select * from customer2;

-- 6. 2씩 자동 증가 단 10까지만.. 허용해주는 sequence 생성해보기
create sequence cust2_no_seq start with 2 increment by 2 maxvalue 10;
insert into customer2 values(cust2_no_seq.nextval, 'master', '7777');
insert into customer2 values(cust2_no_seq.nextval, 'maste', '7777');
insert into customer2 values(cust2_no_seq.nextval, 'mast', '7777');
insert into customer2 values(cust2_no_seq.nextval, 'mas', '7777');
insert into customer2 values(cust2_no_seq.nextval, 'ma', '7777');
insert into customer2 values(cust2_no_seq.nextval, 'm', '7777');
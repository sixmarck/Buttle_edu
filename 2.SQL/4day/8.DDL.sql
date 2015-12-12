-- 8.DDL.sql
/* 학습내용
1. DDL - Data Definition Language
2. 종류
	- create/drop/alter
3. test table 생성 명령어
	- create table table명 as select ~
4. commit와 rollback 명령어는 DML에만 적용되는 메카니즘
5. table의 컬러별 데이터 타입
	1. 문자열
		char(고정byte) - 고정 문자열
		varchar2(최대byte) - 가변적인 문자열
	2. 숫자[정수, 실수]
		number(전체정수자리수)
		number(전체자리수, 실수자리수)
	3. 날짜 타입
		date
6. 문법
	1. 생성
		CREATE table명(
			이름 타입 제약조건, 
			...
		);
	2. table구조 수정
		컬럼 추가 - ALTER table명 add(컬럼명 타입);
		컬럼 수정 - ALTER table명 modify(컬럼명 타입);
		컬럼 삭제 - ALTER table명 DROP COLUMN 컬럼명;
	3. 존재하는 데이터만 삭제
		- delete : commit/rollback과 연관
		- truncate : commit/rollback과 무관
*/

-- ***[table 생성 및 데이터 저장 명령어]***
-- 1. table 생성 문법[이름, 나이]
droptabl person;
create table person(
	name varchar2(10) not null,
	age number(3) not null
);

desc person;
select * from person;
insert into person values('이용기', 27);
select * from person;
--insert into person(age) values(30); null값 적용이 안되는 name속성이라 오류

-- 2. insert문장을 이용해서 table구조만 생성된 emp01에 데이터 한번에 insert하기
drop table emp01;
create table emp01 as select * from emp where 1=0;
select * from emp01;

insert into emp01 select * from emp;
select * from emp01;

-- ***[table 삭제]***
-- 3. emp01 table 삭제
drop table emp01;

-- ***[table 수정]***
-- 4. job이라는 컬럼을 새로 추가
drop table emp01;
create table emp01 as select ename, empno, deptno from emp;
desc emp01;

alter table emp01 add(job varchar2(20));
desc emp01;

-- 5. job의 byte를 축소(10byte)
alter table emp01 modify(job varchar2(10));
desc emp01;

-- 4~5번을 통해서 새로운 컬럼 추가 및 데이터가 없는 컬럼의 byte 수 축소, 확대도 가능

-- 6.? 데이터가 존재하는 컬럼 수정시도
	-- 이미 존재하는 데이터의 byte 수보다 적은 사이즈론 절대 수정 금지
drop table dept01;
create table dept01 as select * from dept;
desc dept01;
-- ok
alter table dept01 modify(dname varchar2(10));
-- 오류 alter table dept01 modify(dname varchar2(5));

-- 7. 이미 존재하는 컬럼 삭제
alter table dept01 drop column deptno;


-- ***[데이터 삭제]***
-- 8. table의 데이터만 삭제
-- commit/rollback이 가능한 명령어
delete from dept01;
-- commit/rollback 불가능 즉 복구 불가능
truncate table dept01;
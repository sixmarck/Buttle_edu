-- 9.integrity.sql
/* 학습내용
- 데이터 무결성 보장을 위해 table에 제약조건 설정하는 다양한 기법
1. 종류
	1. not null - 반드시 데이터가 존재해야 함을 의미
	2. unique - 중복 절대 불허
	3. primary key[pk=기본키=주키] 
		- not null + unique 두가지 기질을 보유한 제약조건
		- 주 용도 : 데이터 구분용 핵심 데이터
	4. foreign key[fk=외래키=참조키]
		- 이미 존재하는 pk를 참조하는 제약조건
		- 자식 table과 부모table 구조 형성
			: 부모 table - pk 보유한 table
			  자식 table - fk 보유한 tbale
	5. check : 프로그램 상의 if 조건식과 흡사
			특정 조건에 해당하는 데이터값만 저장 가능
	6. default : insert시에 데이터를 적용하지 않아도 기본적으로 저장되는 데이터
2. 제약조건 설정방법
	1. db설계자가 이름을 명시적으로 부여
		1) 컬럼 선언시 이름이 부여된 제약 조건 설정
			- 컬럼 레벨의 설정방법
		2) 모든 컬럼 선언 후 table 종류 마지막에 이름이 부여된 제약조건 설정
			- table레벨 단위의 설정 방법
	2. oracle db 자체적으로 자동생성시키는 방법
		- name varchar2(10) primary key 처럼 컬럼 선언과 제약조건 설정만으로 제약 조건 이름 설정 없이 선언한 경우
		- SYS_Xxx로 자동 생성됨
	3. 복사된 table에는 제약조건 자동 적용이 불가
		따라서 제약조건은 명시적으로 alter명령어로 적용 필수
		alter table table명 add constraint 제약조건명 primary key(컬럼명);
3. oracle db제체의 유틸 table
	1. user_constraints : 제약 조건 정보 보유 table

*/

-- 1. pk로 설정되어 있는 dept의 deptno값을 이미 존재하는 데이터로 저장 시도시 에러
--insert into dept values(10, '교육부', '구로');

-- 2. DB내의 scott계정이 사용하는 모든 table의 제약조건 정보 확인
desc user_constraints;
select table_name, constraint_name, constraint_type from user_constraints;

-- 3. 이름 부여하지 않는 제약조건 설정 및 확인, 에러 발생 유도
drop table person;
create table person(
	name varchar2(10) not null,
	age number(3) not null
);

insert into person values('재석', 26);
insert into person values(3);

select table_name, constraint_name, constraint_type from user_constraints
where table_name='PERSON';

-- 4. pk 설정 및 제약조건 이름 미부여, 에러메시지 확인
	-- table 삭제시 제약조건 정보 보유한 오라클 자체 table에도 정보 자동 삭제
drop table person;
select table_name, constraint_name, constraint_type from user_constraints
where table_name='PERSON';

create table person(
	name varchar2(10) primary key,
	age number(3) not null
);

insert into person values('재석', 26);
-- pk에 중복 저장시도시 에러 insert into person values('재석', 26);

-- 5. 컬럼레벨 단위의 이름을 부여하는 제약조건 설정 방법
	-- 해당 제약조건에 위배되는 에러 발생시 제약조건명도 에러 메세지 일부로 표현

drop table person;
create table person(
	name varchar2(10) constraint person_pk primary key,
	age number(3) not null
);
insert into person values('재석', 26);
select table_name, constraint_name, constraint_type from user_constraints
where table_name='PERSON';
insert into person values('재석', 26);

-- 6. table 레벨 단위의 제약조건 설정 방법

drop table person;
create table person(
	name varchar2(10),
	age number(3) not null,
	constraint person_pk primary key(name)
);
insert into person values('재석', 26);
select table_name, constraint_name, constraint_type from user_constraints
where table_name='PERSON';

-- 7. 복사본 table에 alter명령어로 제약조건 추가하기
drop table dept01;
create table dept01 as select * from dept;

insert into person values('재석', 26);
select table_name, constraint_name, constraint_type from user_constraints
where table_name='DEPT01';

alter table dept01 add constraint dept01_pk primary key(deptno);
select table_name, constraint_name, constraint_type from user_constraints
where table_name='DEPT01';

-- 8. 외래키 [FK] 설정
drop table emp01;
create table emp01(
	empno number(4) constraint emp01_pk primary key,
	deptno number(2) constraint emp01_fk references dept(deptno)
);
select table_name, constraint_name, constraint_type from user_constraints
where table_name='EMP01';

-- 9.? alter명령어로 dept의 deptno 컬럼을 emp01의 deptno에 제약조건 설정하기
drop table emp01;
create table emp01(
	empno number(4) constraint emp01_pk primary key,
	deptno number(2)
);

select table_name, constraint_name, constraint_type from user_constraints
where table_name='EMP01';

alter table emp01 add constraint emp01_fk foreign key(deptno) references dept(deptno);

select table_name, constraint_name, constraint_type from user_constraints
where table_name='EMP01';

-- 10. emp01(자식)에 dept(부모)에 미존재하는 deptno값으로 저장
-- 오류 : insert into emp01 values(1234, 50); 부모에 미존재하는 데이터 사용 불가
insert into emp01 values(1234, 40);

-- 11. check에 대한 제약조건
	-- 프로그램 언어처럼 if문장과 흡사한 필터링 기능, 단지 해당 조건에 위배시 oracle 자체의 예외 발생
-- table 생성시 age는 1~100까지의 데이터만 저장하겠다는 강제적인 설정
drop table emp01;
create table emp01(
	name varchar2(10) primary key,
	age number(3) constraint emp01_ck check(age between 1 and 100)
);

insert into emp01 values('master', 10);
insert into emp01 values('master', 110);
select * from emp01;

-- 12. ? emp01 table에 gender라는 성별 컬럼 적용해서 생성, 단 저장되는 데이터는 F or M만 가능
	-- in 연산자
alter table emp01 add(gender char(1));
alter table emp01 add constraint emp01_ck2 check(gender in('F', 'M'));
insert into emp01 values('admin', 10, 'M');
-- insert into emp01 values('ddmin', 10, 'm'); m 저장 불가 데이터

-- 13. default 제약조건 : insert시에 데이터 저장하지 않아도 기본값이 자동 저장되는 기법
drop table emp01;
create table emp01(
	name varchar2(10) primary key,
	age number(3) default '1'
);

insert into emp01 values('master', 20);
insert into emp01(name) values('tester');
select * from emp01;

-- 14.? 이미존재하는 emp01에 dept table의 deptno를 emp01에 fk 추가 적용
alter table emp01 add(deptno number(2));
alter table emp01 add constraint emp01_fk foreign key(deptno) references dept(deptno);
insert into emp01 values('me', 10, 20);
select * from emp01;

-- 15. 주종 관계의 table 삭제 시도
	-- 1) 부모의 데이터를 참조하는 데이터를 보유한 자식 table이 존재할 경우 부모 table 삭제 시도
	drop table dept;
	-- 20번 데이터를 참조해서 사용하는 emp01이 존재에 따라 부모만 삭제 불가
	-- 2) 주종 관계이기는 하나 참조하는 자식 table에서 참조하는 데이터가 없을때 부모삭제 시도
	delete table emp01;
	delete table emp;
	commit;
	drop table dept;

-- 16. 자식 table이 존재한다 하더라도 부득이하게 보무 table 삭제해야할 경우 사용하는 명령어
drop table dept cascade constraint;

-- 쓰레기통에 버려진 테이블 지우기
-- purge recyclebin;

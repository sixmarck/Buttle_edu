-- 11.view.sql
/* 학습내용
1. 가상의 논리적인 table에 대한 학습
	- 원본 즉 create table 명령어로 생성시킨 table이 있어야만 사용 가능한 이론
2. 필요성
	- 보안을 고려한 table이라면 특정 컬럼을 제외하고 view라는것으로 생성해서 제공받아 개발도 하고 활용
	- view로 검색된 데이터는 원본 table의 데이터여야 함
		: 혹 원본 table의 데이터 변경시 view도 변경된 데이터 자동 반영
3. 문법
	1) 생성
		create view view이름 as select .... 원본 table
	2) 삭제
		drop view view이름;
	3) view를 통한 원본 table에서 crud 가능
		단, select만 가능하게 하는 설정 [DML 금지]
		create view view이름 as select ... with read only;
	4) view 정보들 확인하는 명령어
		select * from user_views;

*/
-- 1. comm을 제외한 emp table 기반으로 emp_v라는 view 생성
	-- comm 자체를 몰라야하는 user들은 emp_v를 table처럼 사용하게 하면 됨
drop table emp01;
create table emp01 as select * from emp;

-- view 관리 권한이 업어서 실패
-- create view emp_v as select * from emp01;
-- admin system/oracle로 재 접속 후 view에 대한 soctt 계정의 권한 부여

-- 2. admin계정 접속 & view에 대한 권한 부여 & scott 계정으로 재접속
connect system/oracle
grant create view to scott;
connect scott/tiger

-- 3. 권한 부여 후 view 생성
create view emp_v as select * from emp01;
select * from emp_v;

drop view emp_v;
create view emp_v as select empno, ename, job, mgr, hiredate, sal, deptno from emp01;
select * from emp_v;

-- 4. 이미 생성된 view가 있는 table의 데이터 수정시 view도 영향을 받나?
	-- emp01 : 원본, emp_v : view
delete from emp01 where ename = 'SMITH';
select * from emp01;
select * from emp_v;

-- 5. view에 DML(insert/delete/update) 했을때 원본 table에도 영향을 받나?
-- dept01이 원본, dept01_v가 view
drop table dept01;
create table dept01 as select * from dept;
create view dept01_v as select * from dept01;
select * from dept01;

update dept01_v set loc='구로' where deptno = 10;
select * from dept01_v;
select * from dept01;

-- 6. 읽기만 가능한 view 만들기 : 원본 table 수정 금지
drop table dept01;
drop view dept01_v;
create table dept01 as select * from dept;
create view dept01_v as select * from dept01 with read only;
select * from dept01;

update dept01_v set loc='구로' where deptno = 10;

-- 7. view 정보 확인
select * from user_views;
select view_name, text,  type_text, view_type_owner from user_views;

-- 8.? 다수의 user가 사원의 모든정보를 요청
	-- view를 이미 생성해서 view로 서비스 할수도 있음
	-- view 이름 empAll_v
drop view empAll_v;
create view empAll_v as select a.empno, a.ename, a.job, a.mgr, a.hiredate, a.sal, a.deptno, b.dname, b.loc
from emp a, dept b
where a.deptno = b.deptno;

select * from empAll_v;


drop view empAll_v;
create view empAll_v as select empno, ename, hiredate, sal, mgr, emp.deptno, comm, dept.dname, dept.loc from emp, dept where emp.deptno = dept.deptno;
select * from empAll_v;
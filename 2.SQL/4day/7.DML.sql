-- 7.DML.sql
/* 학습내용
1. DML - Data Manipulation Language
2. 의미 - 이미 존재하는 table에 데이터 조작 언어
		(데이터 생성(insert), 수정(update), 삭제(delete))
3. 실습 환경
	- 두개 이상의 sqlplus 실행
	  한쪽에는 DML 문장, 다른 sqlplus창에서 select
4. DML은 실행후에 반드시 영구저장 명령어 필수
	- 영구저장 : commit
	- 복원 : rollback
5. 문법
	1. INSERT INTO table명 [(컬럼명, ...)] VALUES (값1, ...) [WHERE절];
	2. UPDATE table명 SET 수정컬럼과데이터 [WHERE절];
	3. DELETE FROM table명 [WHERE절];
*/

-- 1. dept table의 복사본 table 생성
	-- 전혀 별개의 table : dept01
drop table dept01;
create table dept01 as select * from dept;
select * from dept01;

-- 2. dept table 복사본 단 데이터를 제외한 table 구조만 그대로 복사해서 생성하기
drop table dept01;
create table dept01 as select * from dept where 1=0;
select * from dept01;

-- 3. emp01 table 생성하되 emp에서 ename, empno, comm 만으로 생성 및 데이터 복사
drop table emp01;
create table emp01 as select ename, empno, comm from emp;
select * from emp01;

-- ***[insert]***
-- 4. emp01에 새로운 데이터 추가 저장 : 컬럼명 명시
	-- insert 직후 임시로 저장된 데이터를 commit명령으로 영구저장 - 다른 Application 들도 사용 가능하게 설정하는 명령어
insert into emp01(ename, empno, comm) values('김규태', 1234, 500);
select * from emp01;
commit;

-- 5. emp01에 새로운 데이터 추가 저장 : 컬럼명 명시없이 데이터 추가
	-- 주의사항 : table 구조의 컬럼 순으로 데이터 적용
insert into emp01 values('노시영', 3456, 700);
select * from emp01;
commit;

-- 6. 조건별 다중 데이터를 한번의 insert문장으로 다수의 table에 저장
drop table emp01;
drop table emp02;

create table emp01 as select ename, empno, deptno from emp where 1=0;
create table emp02 as select ename, empno, deptno from emp where 1=0;

select * from emp01;
select * from emp02;

insert all
	when deptno=10 then
		into emp01 (ename, empno, deptno) values(ename, empno, deptno)
	when deptno=20 then
		into emp02 (ename, empno, deptno) values(ename, empno, deptno)
select ename, empno, deptno from emp;

select * from emp01;
select * from emp02;

-- 7. ? deptno가 10인 직원들은 emp01에 저장하고, deptno 20, deptno 30이라면 emp02에 저장
drop table emp01;
drop table emp02;

create table emp01 as select ename, empno, deptno from emp where 1=0;
create table emp02 as select ename, empno, deptno from emp where 1=0;

select * from emp01;
select * from emp02;

insert all
	when deptno=10 then
		into emp01 (ename, empno, deptno) values(ename, empno, deptno)
	when deptno=20 or deptno=30 then
		into emp02 (ename, empno, deptno) values(ename, empno, deptno)
select ename, empno, deptno from emp;

select * from emp01;
select * from emp02;

-- ***[update]***
-- 8. dept01 table의 부서번호를 모두 50으로 변경
drop table dept01;
create table dept01 as select * from dept;
select * from dept01;

update dept01 set deptno=50;
select * from dept01;

-- 9. update로 수정된 데이터 복원
rollback;

-- 10. deptno가 10인 부서의 loc를 구로로 변경하기
update dept01 set loc='구로' where deptno = 10;
select * from dept01;

-- 11. deptno가 20인 부서의 부서명 교육부, loc는 마포로 변경하기
update dept01 set dname='교육부', loc='마포' where deptno=20;

-- 12.? emp01 table의 모든 사원의 급여를 10%인상
drop table emp01;
create table emp01 as select * from emp;
update emp01 set sal = sal + sal * 0.1;
select * from emp01;

-- 13.? emp01의 모든 사원의 입사일을 오늘로 변경하기
drop table emp01;
create table emp01 as select * from emp;
update emp01 set hiredate = sysdate;
select * from emp01;

-- 14.? emp01에서 급여가 3000이상인 사원의 급여만 10% 인상하기
drop table emp01;
create table emp01 as select * from emp;
update emp01 set sal = sal + sal * 0.1 where sal >= 3000;
select * from emp01;

-- 15.? emp01 직원중 DALLAS에서 근무하는 사원들의 급여만 1000인상하기(subquery)
drop table emp01;
create table emp01 as select * from emp;
update emp01 set sal = sal + 1000 where deptno = (select deptno from dept where loc='DALLAS');
select * from emp01;

-- 16.? emp01의 SMITH 사원의 부서번호는 30으로 job은 MANAGER로 수정하기
drop table emp01;
create table emp01 as select * from emp;
update emp01 set deptno=30, job='MANAGER' where ename='SMITH';
select * from emp01;

-- ***[delete]***
-- 17. emp01 table 모든 데이터 삭제
select * from emp01;
delete from emp01;
select * from emp01;

-- 18. dept01 table의 10번 부서의 정보만 삭제
drop table dept01;
create table dept01 as select * from dept;
select * from dept01;

delete from dept01 where deptno = 10;
select * from dept01;

-- 19.? comm이 null인 사원들만 모두삭제
drop table emp01;
create table emp01 as select * from emp;
select * from emp01;

delete from emp01 where comm is null;
select * from emp01;

-- 20.? comm이 null이 아닌 사원들만 모두 삭제
delete from emp01 where comm is not null;
select * from emp01;

-- 21.? emp01에서 RESEARCH 부서에 소속된 사원들만 삭제
drop table emp01;
create table emp01 as select * from emp;
select * from emp01;

delete from emp01 where deptno = (select deptno from dept where dname='RESEARCH');
select * from emp01;




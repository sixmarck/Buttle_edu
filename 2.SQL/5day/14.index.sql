-- 14.index.sql
/* 학습내용
1. index란? DB의 색인 검색용으로 사용
2. 장점 : 검색 속도 향상
3. 주의사항 : 데이터 실시간 지속적으로 다수 수정되는 경우에는 비추
4. oracle db 관점
	- table의 pk로 설정 즉, 검색용 기준 데이터들은 자동으로 index가 적용됨


*/

-- 1. index 검색 속도 확인용 test table 생성
drop table emp01;
create table emp01 as select * fro emp;
insert into emp01 select * from emp01;

-- 2. sql실행 시간 알수 있는 명령
show index in emp01;
set time on

-- 3. pk들은 자동으로 index 기능이 적용되지만 사용자 정의 새로운 index를 생성해서 적용
create index idx_emp01_empno on on emp01(empno);

-- 4. index 삭제
drop index idx_emp01_empno;

-- 5. 실행시간 검색 종료
set time off
-- 13.rownum.sql
/* 학습내용
1. rownum : 검색된 데이터에 번호를 자동 적용하는 컬럼
2. 권장 : sql 자체적으로 다수의 게시글 등의 paging 처리시 권장
	추세 - 브라우저인 경우 javascript(js)로도 처리하기도함
	참고 - 자바와 같은 서버단 처리 언어로도 paging 처리가능
3. 인라인 뷰 형식이란? from 절에 table명 대신에 select 절 반영된 구조

*/

-- 1. emp table에서 입사일이 가장 늦은 사원들 5명까지만 검색
select * from (select hiredate, ename
from emp
order by hiredate desc)
where rownum <= 5;

-- 2.? emp table에서 급여를 많이 받는 순서대로 3명만 이름과 급여 검색
select * from (select ename, sal
from emp
order by sal desc)
where rownum <= 3;


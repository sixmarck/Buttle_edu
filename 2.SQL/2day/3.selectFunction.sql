--3.selectFunction.sql
/*함수
1. 함수 : oracle db내에 이미 다양한 로직으로 개발되어 제공하는 함수들
2. 종류
	2-1. 단일행 함수 : 행 하나당 하나의 결과값을 반환
	2-2. 복수행 함수(그룹함수) : 다수의 행수를 취합해서 처리후 하나의 결과값만 반환
*/

-- 1. oracle db에서 제공하는 유용한 임시 table
	-- dummy table이라고 함 : dual table
select 2+3 from dual;

-- 2. 현 날짜 검색
select sysdate from dual;

-- *** [숫자 함수] ***
-- 3. round(데이터 [, 반올림 받는 위치]) - 반올림 함수
	-- 반올림 받는 위치 : 양수 - 소수점 이하자리, 음수 - 정수자리 의미
select 34.24, round(34.24), round(34.24, -1), round(34.24, 1) from dual;
select 36.28, round(36.28), round(36.28, -1), round(36.28, 1) from dual;

-- 4. abs(데이터) : 절대값 산출 함수
select -10, abs(-10) from dual;

-- 5. trunc() : 잘라내는 함수
select 34.24, trunc(34.24), trunc(34.67) from dual;

select 34.24, trunc(34.24, 1), trunc(34.67, -1) from dual;

-- 6. mod() : 나누고 난 나머지값 산출
select mod(17,2) from dual;

-- 7.? emp table에서 사번이 홀수인 사원명, 사번 검색
select ename, empno from emp where mod(empno, 2) = 1;

-- 8. upper() : 대문자로 변환
select upper('Buttle') from dual;

-- 9. lower() : 소문자로 변환
select lower('Buttle') from dual;

-- 10. manager라는 소문자인 데이터로 뜻이 동일한 직원들의 job과 이름 검색
select ename, job form emp where lower(job) = 'manager';

-- 11. length() : 문자열 길이 검색, lengthb() : byte 계산 반환 함수	
	-- 한글 한 음절 : 2byte, 영어 숫자 1byte로 계산해서 길이 반환
	-- 단, xe 교육용 버전상에서 한글 한 음절은 3byte로 계산
select length('가'), lengthb('가'), length('a'), lengthb('b') from dual;

-- 12. substr(데이터, 시작위치, 추출갯수) : 문자열 추출  함수
select substr('abcde', 2, 3) from dual;

-- 13. ? emp table에서 입사월들만 검색
select substr(hiredate, 4,2) || '월' from emp;

-- 14. ? emp 테이블에서 년도 구분없이 2월에 입사한 사원명, 입사일 검색
select ename, hiredate from emp where substr(hiredate, 4, 2) = '02';

-- 15. trim() : 문자열 앞뒤의 잉여 여백 제거 함수
select length(trim(' a b ')), trim(' a b '), length(' a b '), ' a b' from dual;

-- 16. emp 테이블에서 이름 음절이 5개 음절인 사원의 이름만 검색
select ename from emp where length(trim(ename)) = 5;

-- 17.? 급여가 4자리수 초과하는 사원의 정보 검색
select * from emp where length(sal) < 4;

-- ***[ 날짜 함수 ]***
-- 18.? 어제, 오늘, 내일 날짜 검색
select sysdate-1, sysdate, sysdate+1 from dual;

-- 19.? emp table 에서 사원들 근무기간의 일수 계산
select sum(trunc(sysdate-hiredate)) from emp;

-- 20. add_months() : 개월수 더하는 함수
select add_months(sysdate, 2) from dual;

-- 21.? emp table의 SMITH 직원이 입사한 일로부터 3개월 후의 날짜 검색하기
select add_months(hiredate, 3) from emp where ename='SMITH';

-- 22. months_between() : 두 날짜 사이의 개월수 검색
select months_between(sysdate, '2014-11-10') from dual;

-- 23. next_day() : 요일을 기준으로 다음 요일에 해당하는 특정 날짜 검색
	-- 주의사항 : db 설치 시스템의 인코딩이 우선, 속성을 변경해서 타국어 사용도 가능
select sysdate, next_day(sysdate, '월요일') from dual;
select sysdate, next_day(sysdate, '월') from dual;

-- 24. last_day() : 제시된 날짜를 기준으로 해당 달의 마지막 날짜 검색
select sysdate, last_day(sysdate) from dual;

-- ***[형변환 함수]***
/* 1. to_char()		: 문자타입으로 변환
	* 날짜를 문자타입 : 날짜형식을 원하는 형식으로 가공해서 검색
		-사용 표기법
			hh:mi:ss		- 12시간 기준의 시분초
			hh:mi:ss dy	- 12시간 기준의 요일
			hh24:mi:ss		- 24시간 기준의 시분초
			hh:mi:ss am	- 시분초 오후 오전

	* 숫자를 문자타입
		- 자릿수 표현은 9 or 0으로 표현
		- 화폐단위 표현 가능 : L or l or 각 나라 단위
    
    2. to_date()		: 날짜타입으로 변환
    3. to_number()	: 숫자타입으로 변환

*/

-- 25. to_char() : 날짜를 문자형으로 변환
select sysdate, to_char(sysdate, 'yyyy-mm-dd'	) from dual;

-- 26.? SMITH의 입사일에 대한 24시간 기준의 검색, 오후? 오전? 요일?
select ename, to_char(hiredate, 'yyyy-mm-dd hh:mi:ss dy am') from emp where ename='SMITH';

-- 27.? 택배 회사라 가정, 12시 이전에 주문은 오늘 발송, 12시 이후의 주문은 내일 발송
-- order를 내려야 하는데 오늘발송? 내일발송? 에 대한 검색 sql 문장
select substr(to_char(sysdate, 'hh24:'), 12, 2) as 오늘발송,
substr(to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'), 12, 2) as 내일발송
from dual;

--정오 시간을 기준으로 round() 반올림, 즉 12시가 넘으면 내일날짜로 검색
select sysdate, round(sysdate), trunc(sysdate) from dual;

select sysdate, to_char(round(sysdate), 'yyyy-mm-dd hh24:mi:ss') from dual;
select sysdate, to_char(trunc(sysdate), 'yyyy-mm-dd hh24:mi:ss') from dual;

-- 28. to_char()와 숫자 자릿수를 의미하는 9 또는 0이란 숫자로 데이터 표현
	-- 숫자를 문자로 변환
	/* L or l - local의 약어 따라서 해당 os의 기본 인코딩의 화폐단위 표현
		999,999 : 뒷자리부터 데이터를 표현하되 ',' 표기도 가능 따라서 천단위 금전 표현에 적합
		0 : 0으로 채워진 자릿수만큼 데이터들 표현, 무효한 범위를 초과해서 표현될 경우 0으로 자릿수가 채워짐

	*/
select 1234, to_char(1234, '99999.99') from dual;
select 1234, to_char(1234, '$99999.99') from dual;
select 1234, to_char(1234, '99999') from dual;
select 1234, to_char(1234, '999,99') from dual;
select 1234, to_char(1234, 'L99999.99') from dual;

select 1234, to_char(1234, '00000') from dual;
-- select 1234, to_char(1234, '999') from dual; 오류

-- 29. ? 올해 며칠이 지났는지 검색
select trunc(sysdate-to_date('20150101', 'yyyymmdd')) || '일 지남' as "지난 날짜 세기" from dual;
select to_date(sysdate) - to_date('20150101', 'yyyy/mm/dd') from dual;

-- 30. to_number() : 숫자로 변환시키는 함수
--select '20,000' - '10,000' from dual; 문자열로 간주되어 연산불가

select to_number('20,000', 99999) - to_number('10,000', 99999) from dual;

-- 천자리 표현하는 쉼표 적용하고자 한다면 어떻게?
select to_char(to_number('20,000', 99999) - to_number('10,000', 99999), '999,999') from dual;
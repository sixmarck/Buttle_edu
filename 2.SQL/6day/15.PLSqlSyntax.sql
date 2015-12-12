-- 15.PLSqlSyntax.sql
/* 학습내용
1. 사용자 정의 함수와 같은 oracle db만의 sql문장
2. sql : plsql 
	sql - db에 요청시 db관점에서 매번 read -> 분석 -> 변환(컴파일) -> 실행
	plsql - 첫 요청시 read -> 분석 -> 변환(컴파일) -> 실행
		이미 변환된 컴파일된 코드를 db가 보유
		두번째 요청부터는 실행
3. 종류 (***)
	1) 익명 블록
		- 이름 없음
		- 호출 불가능, 재사용성 미고려
	2) 저장 프로시저
		- 이름 있음
		- 호출 가능
		- parameter 있음
	3) 저장 함수
		- 이름 있음
		- 호출 가능
		- parameter 있음, 반환 데이터 있음
4. 문법
	declare			[옵션]
		변수선언;
	begin				[필수]
		실행로직
	exception			[옵션]
		when 상황에따른이름들 then
			예외발생시 처리 로직
	end;				[필수]
	/				[필수]
5. 연산자 (***)
	1) 할당연산자 - :=
	2) 결합연산자 - ||


*/

-- 1. plsql 실행 결과 출력을 위한 필수 설정
set serveroutput on

-- 2. 기본 문법 습득을 위한 익명 블록 & 출력 기능 학습
declare
	name varchar2(10);
begin
	name := '희재';
	dbms_output.put_line('출력 데이터 ' || name);
end;
/

/* 오류
begin
	name varchar2(10); 오류 발생 라인
	name := '희재';
	dbms_output.put_line('출력 데이터 ' || name);
end;
/
*/

begin
	dbms_output.put_line('출력 데이터 ');
end;
/

-- 3. 나눗셈을 적용한 익명블록(변수선언 및 활용 익숙해지기)
declare
	counter integer;
begin
	counter := 10;
	counter := counter/2;
	dbms_output.put_line(counter);
end;
/

-- 4. 중첩 익명블록
	-- inner block에서만 선언된 변수는 outer block에선 사용 불가
declare
	a varchar2(10) := '변수 A';	
begin
	declare
		b varchar2(10) := '변수 B';
	begin
		dbms_output.put_line(a);
		dbms_output.put_line(b);
	end;
	dbms_output.put_line(a);
	--dbms_output.put_line(b); 오류
end;
/

-- 5. emp table의 컬럼 타입 활용해보기 (ename의 타입)
declare
	name  emp.ename%type;
begin
	name := 'master';
	dbms_output.put_line(name);
end;
/

-- 6.? emp의 sal의 컬럼 타입 활용(sal변수 선언 및 데이터값 대입해서 출력)
declare
	sal emp.sal%type;
begin
	sal := 3333;
	dbms_output.put_line(sal);
end;
/

-- 7. select한 결과값을 출력해 보기
	-- select한 데이터값 plsql변수에 대입해서 출력
declare
	name emp.ename%type;
begin
	select ename into name
	from emp 
	where empno=7369;
	dbms_output.put_line(name);
end;
/

-- 8.? SMITH의 월급여와 사번 검색해서 출력
declare 
	v_sal		emp.sal%type;
	v_empno	emp.empno%type;
begin
	select sal, empno into v_sal, v_empno
	from emp
	where ename = 'SMITH';
	dbms_output.put_line(v_sal || ' ' || v_empno);
end;
/

-- 9.? 존재하는 emp table의 모든 컬럼 타입 및 컬럼명을 활용할수 있는 plsql 타입 학습
	-- %rowtype
declare
	v_all emp%rowType;
begin
	select *
		into v_all
	from emp where empno=7369;

	dbms_output.put_line(v_all.ename);
end;
/

-- 10. 조건식
	-- comm이 null인 사원들은 0으로 값 치환후에 연산(SMITH sal * 12 + comm)
declare
	v_emp emp%rowtype;
	allSal number(7, 2);
begin
	dbms_output.put_line('사번/이름/연봉');
	select empno, ename, sal, comm
		into v_emp.empno, v_emp.ename, v_emp.sal, v_emp.comm
	from emp
	where ename = 'SMITH';

	if(v_emp.comm is null) then
		v_emp.comm := 0;
	end if;

	allSal := v_emp.sal * 12 + v_emp.comm;
	dbms_output.put_line(v_emp.empno || '/' || v_emp.ename || '/' || allSal);
end;
/

-- 11.? emp에서 sal에 3000을 초과하는 사람에 한해서 "KING" 출력
	-- select sal, ename from emp where ename='KING'
declare
	v_ename emp.ename%type;
	v_sal emp.sal%type;
begin
	select sal, ename into v_sal, v_ename
	from emp
	where ename='KING';

	if(v_sal > 3000) then
		dbms_output.put_line('KING');
	end if;
end;
/

-- 12. 다중 조건식
	-- SMITH의 부서 번호가 10 - 서울, 20 - 파주, 30 - 수원
declare
	v_deptno dept.deptno%type;
	v_loc dept.loc%type;
begin
	select deptno
		into v_deptno
	from dept where deptno = (select deptno from emp where ename='KING');

	if(v_deptno = 10) then
		v_loc := '서울';
	elsif(v_deptno = 20)  then
		v_loc := '파주';
	elsif(v_deptno = 30) then
		v_loc := '수원';
	else
		v_loc := '한국';
	end if;
	dbms_output.put_line('SMITH의 근무지는 ' || v_loc);
end;
/

-- 13.? [광욱문제]
	-- emp table에서 입사일이 81년도인 사원들 중 급여가 2000이상이고 3000아래인 사원들만 검색하세요 (이름, 입사일, 급여)
declare
	v_emp emp%rowtype;
	cursor c1 is select ename, hiredate, sal from emp where '81' = to_char(hiredate, 'yy');
begin
	for v_emp in c1 loop
		if(v_emp.sal >= 2000 and v_emp.sal <= 3000) then
			dbms_output.put_line(v_emp.ename || '/' || v_emp.hiredate || '/' || v_emp.sal);
		end if;
		
	end loop;
end;
/


-- 13. 반복문
declare
	num number(2) := 1;
begin
	loop
		dbms_output.put_line(num);
		num := num +1;
		exit when num > 5;
	end loop;
end;
/

-- 14. 
begin
	for i in 0..5 loop
		dbms_output.put_line(i);
	end loop;
end;
/

-- 15.
declare
	num number(2) := 1;
begin
	while num <= 5 loop
		dbms_output.put_line(num);
		num := num +1;
	end loop;
end;
/

-- 16. 5부터 1순으로 출력해보기
begin
	for i in reverse 1..5 loop
		dbms_output.put_line(i);
	end loop;
end;
/

-- 17. 동적 데이터 적용 가능한 plsql 문장
	-- 실행시마다 새로운 데이터값 적용 가능
declare
	v_empno emp.empno%type := &v;
begin
	dbms_output.put_line(v_empno);
end;
/

-- 18.? 사번을 동적으로 입력 받아 해당하는 사원의 이름 음절수 만큼  * 찍기
	-- 참고 : plsql에서도 oracle 함수 사용가능(length())
declare
	v_empno emp.empno%type := &v;
	v_length number(2);
	v_start varchar2(10);
begin
	select length(ename) into v_length
	from emp
	where empno = v_empno;
	
	for i in 1..v_length loop
		v_start := v_start || '*';
	end loop;

	dbms_output.put_line(v_start);
end;
/

-- 19.? 미 존재하는 데이터로 검색시도시 발생하는 예외 처리 문장 학습
	-- exeception 처리 문장중 NO_DATA_FOUND 라는 이미 존재하는 키워드 활용
declare
	v_ename emp.ename%type := &v;
	v_empno emp.empno%type;
begin
	select empno
		into v_empno
	from emp where ename = v_ename;

	dbms_output.put_line(v_empno);
exception
	when NO_DATA_FOUND then
		dbms_output.put_line('검색 데이터가 없습니다.');
end;
/


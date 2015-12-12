-- 10.merge.sql
/* 학습내용
1. 병합 관련된 내용 학습
2. 예시
	- 자회사 2곳
		Acompany - 고유 번호가 있는 물건 생산
		Bcompany - 고유 번호가 있는 물건 생산
	- 본사 
		TotalCompany - A+B의 모든 제품 통합관리
			insert : A 또는 B가 새로운 제품 생산했을 경우
				- 데이터 존재 유무 확인 없을 경우에만 저장
			update : 이미 존재하는 제품을 추가 생산했을 경우
				- 데이터 존재 유무 확인 이미 고유번호 제품이 있을 경우 수량 갱신
			delete : 더이상 생산 계획이 없을때 재고 바닥...
	- table 설계의 요구 : 각 자회사가 생산하는 자료들을 별도의 table로 개발 및 저장
				  본사 table에는 두곳의 모든 제품 통합 및 재고 관리 해야하는 상황
3. 문법
	merge
		into 데이터반영받을table 별칭
		using 데이터제공table 별칭
		on (조건식)
	when matched then
		true인 경우 실행되는 sql 문장
	when not matched then
		false인 경우 실행되는 sql 문장
*/

-- TotalCompany, Acompany, Bcompany 테이블 생성
-- 제품번호(no), 수량(quantity), 금액(money)
create table Acompany(
	no number(4) primary key,
	quantity number(5) not null,
	money number(5, 2) not null
);
create table Bcompany(
	no number(4) primary key,
	quantity number(5) not null,
	money number(5, 2) not null
);
create table TotalCompany(
	no number(4) primary key,
	quantity number(5) not null,
	money number(5, 2) not null
);

-- 각 table에 데이터 저장
insert all
	into Acompany values(1111, 120, 100)
	into Acompany values(1112, 500, 700)
	into Acompany values(1113, 200, 500)
	into Acompany values(1114, 5000, 600)
	into Bcompany values(2222, 120, 100)
	into Bcompany values(2223, 500, 700)
	into Bcompany values(2224, 200, 500)
	into Bcompany values(2225, 5000, 600)
select * from dual;

-- TotalCompany table에 제품 정보 저장하는 sql
	-- 미존재할 경우 insert/이미 존재할 경우 update
merge
	into totalcompany allt
	using acompany a
	on (allt.no = a.no)
when matched
	then update set allt.quantity = allt.quantity + a.quantity
when not matched
	then insert values(a.no, a.quantity, a.money);

select * from totalcompany;

merge
	into totalcompany allt
	using bcompany a
	on (allt.no = a.no)
when matched
	then update set allt.quantity = allt.quantity + a.quantity
when not matched
	then insert values(a.no, a.quantity, a.money);

select * from totalcompany;
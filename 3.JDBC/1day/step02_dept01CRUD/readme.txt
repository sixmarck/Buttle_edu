실습내용

1. dept01 table에 CRUD를 JDBC API를 통해서 진행
	CRUD = create/read/update/delete = insert/select/update/delete

2. 실습구조
	1) CRUD 로직을 개별 메소드로 개발
	2) sql문장 보유하고 있으면서 DB의 실제 통신을 담당하는 전문 클래스

3. design pattern
	1) DAO[Data Access Object] pattern
		- DB연동 전담 클래스
	2) DTO[Data Transfer Object] pattern
		- VO[Value Object] pattern
		- Java Bean
	3) MVC
		- Model : DAO + DTO
	4) Singleton
	
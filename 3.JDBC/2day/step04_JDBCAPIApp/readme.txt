학습내용

1. java.sql의 JDBC API중 sql문장 실행 API 학습
   - java.sql.Statement
         - 문장..다수의 sql문장 실행 가능한 객체
         - 동일한 sql문장 다수 실행시 PreparedStatement 객체보다 처리 속도가 느림
         Statement stmt = con.createStatement();
         stmt.executeUpdate("sql");
         
   - java.sql.PreparedStatement
         - 생성 시점에 고정된 sql문자만으로 생성, 
           하나의 PreparedStatement객체는 하나의 sql문장만 실행 가능
         - DB연동 Framework에서 사용하는 API
         - Statement 보다 처리 속도가 빠름(다수 실행시)
         - 데이터값 표현위치는 ? 로 표기
         - 데이터값 실제 sql에 적용시 index 1로 시작되는 위치 지정후 setXxx()로 처리
           PreparedStatement pstmt 
              = con.prepareStatement("insert into dept01 values(?, ?, ?)");
           
           pstmt.setInt(1, 50);
           pstmt.setString(2, 'eee');
           pstmt.setString(3, 'eeeee');
           
           pstmt.executeUpdate();
           
2. JDBC api를 이용한 트렌젝션 처리
	*** 트랜잭션을 사용자가 제어할수 있는 API ***
	1. 트랜잭션 무효화 메소드
		Connection의 setAutoCommit(false);
	2. 정상 실행 후 영구 저장
		Connection의 commit();
	3. 비정상 실행시 복원
		Connection rollback();
   - 실습 예시 
      : 데이터를 insert 후 update시도
        - 실행시 발생 가능한 경우의 수
        1. 다 정상 실행해서 성공            : 영구 저장
        2. insert는 성공, update는 실패   : 복원, 원점화
        3. insert 실패, update실패      : 원점화        
        ...
        
3. JDBC API 특징[트렌젝션 관점]
   1) commit 명령어가 필요한 sql문장 : DML[insert/update/delete]
   2) jdbc api중 DML명령어 실행 메소드 : int executeUpdate("dml")는 auotcommit
   3) 2번 예시 처럼 다중작업을 하나의 작업단위로 묶기 위해서는 autocommit 기능을 소멸해야 함
      - 트랜잭션은 개발자가 코드로 적용
   
   4) 코드 예시
      driver로딩
      Connection con = ...
      con.setAutoCommit(false);
      
      Statement stmt = con.createStatement();
      stmt.executeUpdate("DML");
      
      Statement stmt2 = con.createStatement();
      stmt2....
   
      con.commit();
      
      con.rollback();
 
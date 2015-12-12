/* 학습내용
 * 1. JDC API 학습
 * 2. JDBC = Java DataBase Connectivity
 * 		- 특정 DB에 종속적이지 않는 DB연동 표준 API
 * 3. 인스톨된 존재하는 DB에 접속하기 위한 필수 정보
 * 		- id/pw/ip
 * 		- 로컬 IP : 127.0.0.1 / localhost / ipconfig로 확인된 IP
 * 4. dept table의 데이터 검색을 위한 서술형 코딩
 * 		- DB에 접속 -> dept table 검색 쿼리 작성해서 실행 -> 검색값 획득해서 그 데이터를 출력 -> 종료
 * 5. 특정 기능이 있는 자바 API
 * 		- Class.forName("벤더사driver이름");
 * 		- DriverManager : 벤더사에서 제공받은 driver들을 관리하는 API
 * 		- Connection : DB접속 객체
 * 		- Statement : sql문장 실행 객체
 * 			- Result executeQuery("select~~"){}
 * 				int executeUpdate("DML..."){}
 * 				bolean execute("DDL..."){}
 * 		- ResultSet : select문장의 결과를 매핑한 객체
 * 		- close() : 자원반환 
 */

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class JDBC1 {

	public static void main(String[] args) {
		try {
			// 1단계 - driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// 2단계 - Connection 객체 생성
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
//			System.out.println(conn);
			
			// 3단계 - Statement 객체 생성
			Statement stmt = conn.createStatement();
			
			// 4단계 - select 후 결과 반환 및 활용
			ResultSet rs = null;
			String sql = "select dname, loc from dept where deptno = 10";
			rs = stmt.executeQuery(sql);			
			
			if(rs.next()) {
				//System.out.println(rs.getString(1) + " " + rs.getString(2));
				System.out.println(rs.getString("dname") + " " + rs.getString("loc"));
			}
			
			// 5단계 - 자원반환
			rs.close();
			stmt.close();
			conn.close();
			
			System.out.println(new Date("1999-02-02"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}

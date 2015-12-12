/*	실습로직
 * dept01 table에 데이터 insert/update 시도
 * 1단계 : 정상 실행		- 저장 및 수정 완료
 * 2단계 : insert만 정상	- update시에 exeception 발생했음에도 저장은 완료
 * 3단계 : update만 정상	- insert 실행시에 exception 발생해서 catch블록으로 이동 즉 update 실행도 안했음
 * 4단계 : tx를 개발자 코드로 제어하도록 설정 후 1~3단계 재확인
 * 
 */

package tx;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtil;

public class TxJDBC {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try{
			con = DBUtil.getConnection();
			//autocommit 기능 무효화
			con.setAutoCommit(false);

			stmt = con.createStatement();
			//insert
			stmt.executeQuery("insert into dept01 values(90, '교육부', '구로')");
			//update
			stmt.executeQuery("update dept01 set loc ='마포' where deptno=90");
			con.commit();				// 정상 실행시 영구 저장
			System.out.println("정상 실행");
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();		// 예외 발생시 복원
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DBUtil.close(con, stmt);
		}
	}

}

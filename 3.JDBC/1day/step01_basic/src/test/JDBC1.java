/* �н�����
 * 1. JDC API �н�
 * 2. JDBC = Java DataBase Connectivity
 * 		- Ư�� DB�� ���������� �ʴ� DB���� ǥ�� API
 * 3. �ν���� �����ϴ� DB�� �����ϱ� ���� �ʼ� ����
 * 		- id/pw/ip
 * 		- ���� IP : 127.0.0.1 / localhost / ipconfig�� Ȯ�ε� IP
 * 4. dept table�� ������ �˻��� ���� ������ �ڵ�
 * 		- DB�� ���� -> dept table �˻� ���� �ۼ��ؼ� ���� -> �˻��� ȹ���ؼ� �� �����͸� ��� -> ����
 * 5. Ư�� ����� �ִ� �ڹ� API
 * 		- Class.forName("������driver�̸�");
 * 		- DriverManager : �����翡�� �������� driver���� �����ϴ� API
 * 		- Connection : DB���� ��ü
 * 		- Statement : sql���� ���� ��ü
 * 			- Result executeQuery("select~~"){}
 * 				int executeUpdate("DML..."){}
 * 				bolean execute("DDL..."){}
 * 		- ResultSet : select������ ����� ������ ��ü
 * 		- close() : �ڿ���ȯ 
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
			// 1�ܰ� - driver loading
			Class.forName("oracle.jdbc.OracleDriver");
			// 2�ܰ� - Connection ��ü ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
//			System.out.println(conn);
			
			// 3�ܰ� - Statement ��ü ����
			Statement stmt = conn.createStatement();
			
			// 4�ܰ� - select �� ��� ��ȯ �� Ȱ��
			ResultSet rs = null;
			String sql = "select dname, loc from dept where deptno = 10";
			rs = stmt.executeQuery(sql);			
			
			if(rs.next()) {
				//System.out.println(rs.getString(1) + " " + rs.getString(2));
				System.out.println(rs.getString("dname") + " " + rs.getString("loc"));
			}
			
			// 5�ܰ� - �ڿ���ȯ
			rs.close();
			stmt.close();
			conn.close();
			
			System.out.println(new Date("1999-02-02"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}

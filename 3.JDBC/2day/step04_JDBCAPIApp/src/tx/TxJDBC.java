/*	�ǽ�����
 * dept01 table�� ������ insert/update �õ�
 * 1�ܰ� : ���� ����		- ���� �� ���� �Ϸ�
 * 2�ܰ� : insert�� ����	- update�ÿ� exeception �߻��������� ������ �Ϸ�
 * 3�ܰ� : update�� ����	- insert ����ÿ� exception �߻��ؼ� catch������� �̵� �� update ���൵ ������
 * 4�ܰ� : tx�� ������ �ڵ�� �����ϵ��� ���� �� 1~3�ܰ� ��Ȯ��
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
			//autocommit ��� ��ȿȭ
			con.setAutoCommit(false);

			stmt = con.createStatement();
			//insert
			stmt.executeQuery("insert into dept01 values(90, '������', '����')");
			//update
			stmt.executeQuery("update dept01 set loc ='����' where deptno=90");
			con.commit();				// ���� ����� ���� ����
			System.out.println("���� ����");
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();		// ���� �߻��� ����
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DBUtil.close(con, stmt);
		}
	}

}

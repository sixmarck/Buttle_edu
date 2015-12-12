package account.util;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBUtil {
	/*	MyBatis�� DB���� �� sql ���� ������ ��ü���� ��û�ø��� �����ؼ� �������ִ�
	 * MyBaits �ٽ� API
	 * ��, � DB ���? sql������ ���������� ���� ���� �ʼ�
	 */

	private static SqlSessionFactory factory = null;
	
	static {
		InputStream inputStream = null;
		try {
			// 1byte ������ db�� sql���� ������ xml�����κ��� read �� �� �ִ� ��ü
			inputStream = Resources.getResourceAsStream("conf/SqlMapConfig.xml");
			
			// SqlSEssionFactory ��ü ���������� ��ü ����
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			// builder�� xml���� ������ sqlSession��ü ���������� SqlSessionFactory ��ü ����
			factory = builder.build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/* JDBC�� Connection ������ �޼����� ����� ����� �޼ҵ�
	 * 	- DAO�� �� �޼ҵ忡�� SqlSession ��ü�� ����
	 * 
	 * 
	 */
	public static SqlSession getSqlSession() {
		return factory.openSession();
	}

	public static SqlSession getSqlSession(boolean autoCommit) {
		return factory.openSession(autoCommit);
	}

	// SqlSession ��ü �ڿ���ȯ
	public static void closeSqlSession(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}

	public static void closeSqlSession(boolean commit, SqlSession session) {
		if (session != null) {
			if (commit) {
				session.commit();
			} else {
				session.rollback();
			}
			session.close();
		}
	}
}

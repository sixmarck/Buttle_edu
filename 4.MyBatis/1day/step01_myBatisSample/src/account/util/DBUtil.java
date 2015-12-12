package account.util;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBUtil {
	/*	MyBatis로 DB접속 및 sql 실행 가능한 객체들을 요청시마다 생성해서 제공해주는
	 * MyBaits 핵심 API
	 * 단, 어떤 DB 사용? sql문장은 무엇인지에 대한 정보 필수
	 */

	private static SqlSessionFactory factory = null;
	
	static {
		InputStream inputStream = null;
		try {
			// 1byte 단위로 db와 sql설정 정보의 xml문서로부터 read 할 수 있는 객체
			inputStream = Resources.getResourceAsStream("conf/SqlMapConfig.xml");
			
			// SqlSEssionFactory 객체 생성가능한 객체 생성
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			// builder가 xml설정 정보로 sqlSession객체 생성가능한 SqlSessionFactory 객체 생성
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

	/* JDBC의 Connection 제공한 메소으와 흡사한 기능의 메소드
	 * 	- DAO의 각 메소드에는 SqlSession 객체만 제공
	 * 
	 * 
	 */
	public static SqlSession getSqlSession() {
		return factory.openSession();
	}

	public static SqlSession getSqlSession(boolean autoCommit) {
		return factory.openSession(autoCommit);
	}

	// SqlSession 객체 자원반환
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

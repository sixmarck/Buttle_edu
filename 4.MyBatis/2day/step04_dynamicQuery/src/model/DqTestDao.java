package model;

import java.util.List;

import model.domain.DqTestBean;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class DqTestDao {
	public static List<DqTestBean> ageCheck(int age) {
		SqlSession session = DBUtil.getSqlSession();
		List<DqTestBean> list = null;
		try {
			list = session.selectList("ageCheck", new DqTestBean(age));
		} finally {
			session.close();
		}
		return list;
	}
	
	public static List<DqTestBean> idCheck(List<String> idList) {
		SqlSession session = DBUtil.getSqlSession();
		List<DqTestBean> list = null;
		try {
			list = session.selectList("idCheck", idList);
		} finally {
			session.close();
		}
		return list;
	}
}

package test;

import java.util.ArrayList;
import java.util.List;

import model.DqTestDao;
import model.domain.DqTestBean;

public class Test {

	public static void main(String[] args) {
		List<DqTestBean> list = DqTestDao.ageCheck(20);
		for (DqTestBean dqTestBean : list) {
			System.out.println(dqTestBean);
		}
		
		List<String> idList = new ArrayList<String>();
		idList.add("master");
		idList.add("coffee");
		idList.add("doll");
		List<DqTestBean> list2 = DqTestDao.idCheck(idList);
		for (DqTestBean dqTestBean : list2) {
			System.out.println(dqTestBean);
		}
	}
}

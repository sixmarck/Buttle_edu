package controller;

import view.EndView;
import exception.IdCheckException;
import model.Service;
import model.domain.Person;

public class Controller {
	//all : 모든 Person 정보 검색 요청, one : 첫번째 Person 객체 반환, two : 두번째 Person 객체 반환
	public static void request(String	v) {
		if(v.equals("all")) {
			EndView.printAll(Service.getAll());
		}else if(v.equals("one")) {
			Person vp = Service.search("one");
			if(vp != null) {
				EndView.printOne(Service.getOne(v));
			} else {
				EndView.errorMsg("검색하는 데이터가 존재하지 않습니다.");
			}
		}else if(v.equals("two")) {
			EndView.printOne(Service.getOne(v));
		}else if(v.equals("three")) {
			EndView.printOne(Service.getOne(v));
		}else {
			
		}
	}
	
	public static void saveRequest(Person v) {
		try {
			Service.save(v);
			EndView.successMsg("가입이 성공되었습니다!");
		} catch (IdCheckException e) {
			//e.printStackTrace();
			EndView.errorMsg(e.getMessage());
		}
	}

}

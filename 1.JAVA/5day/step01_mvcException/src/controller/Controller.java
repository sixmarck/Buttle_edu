package controller;

import view.EndView;
import exception.IdCheckException;
import model.Service;
import model.domain.Person;

public class Controller {
	//all : ��� Person ���� �˻� ��û, one : ù��° Person ��ü ��ȯ, two : �ι�° Person ��ü ��ȯ
	public static void request(String	v) {
		if(v.equals("all")) {
			EndView.printAll(Service.getAll());
		}else if(v.equals("one")) {
			Person vp = Service.search("one");
			if(vp != null) {
				EndView.printOne(Service.getOne(v));
			} else {
				EndView.errorMsg("�˻��ϴ� �����Ͱ� �������� �ʽ��ϴ�.");
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
			EndView.successMsg("������ �����Ǿ����ϴ�!");
		} catch (IdCheckException e) {
			//e.printStackTrace();
			EndView.errorMsg(e.getMessage());
		}
	}

}

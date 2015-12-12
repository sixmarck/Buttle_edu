package data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import model.domain.Person;

public class CollectionData {
	static Map data = new HashMap();
	static {
		data.put("a", new Person("master", "����", 27));
		data.put("b", new Person("tester", "����", 26));		
	}
	//? id check���� : �̹� �����ϴ� id��� true, �������ϸ� false
	static boolean idCheck(String newId) {
		boolean result = false;
		Iterator it = data.keySet().iterator();
		while(it.hasNext()) {
			if(((Person)(data.get(it.next()))).getId().equals(newId)) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		boolean result = idCheck("master");
		if(result) {
			System.out.println("���̵� �ߺ��Ǿ����ϴ�.");
		}else {
			System.out.println("���̵� Ȱ���� �����մϴ�.");
		}
	}

}

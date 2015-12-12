package data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import model.domain.Person;

public class CollectionData {
	static Map data = new HashMap();
	static {
		data.put("a", new Person("master", "성식", 27));
		data.put("b", new Person("tester", "광욱", 26));		
	}
	//? id check로직 : 이미 존재하는 id라면 true, 미존재하면 false
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
			System.out.println("아이디가 중복되었습니다.");
		}else {
			System.out.println("아이디 활용이 가능합니다.");
		}
	}

}

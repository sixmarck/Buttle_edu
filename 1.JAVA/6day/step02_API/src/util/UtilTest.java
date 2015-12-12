package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UtilTest {
	
	//데이터를 HaspMap에 저장해서 제공
	public static Map getData() {
		Map map = new HashMap();
		//사번과 이름을 매핑
		map.put("01", "용선");
		map.put("02", "종일");
		map.put("03", "태경");
		return map;
	}
	
	//제공된 데이터 획득해서 활용
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//? key를 모른다면 어떻게 key들을 반환해서 key에 맞는 data 활용?
		Map all = UtilTest.getData();
		//? API로 key검색후에 key에 맞는 value 반환메소드 -> 출력
		
		Set allKey = all.keySet();
		Iterator it = allKey.iterator();
		String key = null;
		
		while(it.hasNext()) {
			key = (String)it.next();
			System.out.println("key = " + key + " value = " + all.get(key));
		}
		
		
		
		/*List list = new ArrayList();
		
		int count = 0;
		while(i.hasNext()) {
			list.add(i.next());
			System.out.println(list.get(count));
			count++;
		}
		
		for (int j = 0; j < list.size(); j++) {
			System.out.println(all.get(list.get(j)));
		}*/
	}

}

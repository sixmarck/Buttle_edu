/*	Map 구조 학습
 * 	1. key와 value 매핑해서 데이터 관리
 * 2. key는 절대 중복 불가, value 중복 가능
 * 		key는 value들 구분자
 * 
 */

package util;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map map = new HashMap();
		//사번과 이름을 매핑
		map.put("01", "용선");
		map.put("02", "종일");
		map.put("03", "태경");
		
		System.out.println(map.get("02"));
		map.remove("02");
		System.out.println(map.get("02"));
	}

}

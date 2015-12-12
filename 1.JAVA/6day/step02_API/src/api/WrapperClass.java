/*	Wrapper API
 * 1. wrapper 클래스란?
 * 		- 기본 타입과 1:1 매핑되는 객체타입의 클래스들
 * 	2. 종류
 * 		- 8가지
 * 	3. 필요성
 * 		- 자료구조 클래스들(list, map, set)에 활용되는 데이터 타입은 객체만 가능
 * 			숫자형식의 데이터 저장 및 활용을 가능하게 8가지의 클래스를 제공
 * 4. 클래스명
 * 		- boolean : Boolean, char : Character, int : Integer ...
 * 
 */
package api;

import java.util.ArrayList;
import java.util.List;

public class WrapperClass {

	public static void main(String[] args) {
		List a = new ArrayList();
		a.add(new Integer(3));
		a.add(new Boolean(false));
		
		Integer i = (Integer)a.get(0);
		int v = i.intValue();
		System.out.println(v);
		
		for (int j = 0; j < a.size(); j++) {
			System.out.println(a.get(j));
		}
	}
}

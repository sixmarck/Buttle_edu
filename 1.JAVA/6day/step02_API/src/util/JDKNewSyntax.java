/*	학습내용
 * 1. jdk1.5부터 추가된 문법 학습
 * 2. 종류
 * 		1) for
 * 		2) 제네릭 메카니즘
 * 		3) autoboxing & unboxing
 * 			- wrapper class에서만 적용되는 문법
 * 			- 객체타입과 기본타입간의 문법이 확장된것일뿐 내부적인 실행 구조는 
 * 				객체타입은 객체값으로, 기본타입은 기본데이터로 실행되는게 맞음
 * 
 */
package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDKNewSyntax {
	//for문 학습
	public static void forSyntax() {
		String[] all = {"a", "b", "c"};
		for(String v : all) {
			System.out.println(v);
		}
	}
	
	public static void genericSyntax() {
		// String 객체만 저장 가능한 ArrayList
		// 장점 : 형변환 문법 불필요 따라서 코드가 간결
		List<String> list = new ArrayList<String>();
		list.add("ee");
		list.add("an");
		
		for(String s : list) {
			System.out.println(s);
		}
		
	}
	
	public static void boxingSyntax() {
		// autoboxing
		Integer i = 3;		// 컴파일 직후 Integer i = new Integer(3);
		// unboxing
		int i2 = new Integer(3); // 컴파일 직후 int i2 = (new Integer(3)).intValue();
		
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("one", i);
		m.put("two", i2);
	}
	
	public static void main(String[] args) {
		forSyntax();
		genericSyntax();
	}

}

/* 1. 배열과 흡사한 구조
 * 2. index로 데이터 관리
 * 3. 객체들만 저장[예외 없음]
 * 4. 장점 : 배열과 달리 메모리 사이즈가 가변적
 * 		- 무수히 많은 데이터 저장시에 적합하기도 함
 * 	
 * tip
 * 	- jdk1.5 부터 추가된 표현식
 * 	Object = E = V = T = K
 * E : Element의 약어, 객체데이터 하나하나
 * V : Value
 * T : Type
 * K : Key 
 */
package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		//배열과 비교시 배열 객체 생성 : 메모리 개수 10개 우선생성
		// 10개의 데이터 이상 저장시 10개식 메모리 자동 생성
		java.util.ArrayList al = new java.util.ArrayList();
		
		al.add("김혜경");
		al.add(new Integer(24));
		
		/* 생성된 ArrayList에 데이터 저장
		 * 		- public 
		 * 
		 */
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		al.remove(0);
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		List al2 = new ArrayList();
		al2.add("1");
		al2.add("2");
		al2.add("3");
		al2.add("4");
		al2.add("5");
		
		//? Iterator를 활용해서 데이터 출력해보기
		Iterator it = al2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

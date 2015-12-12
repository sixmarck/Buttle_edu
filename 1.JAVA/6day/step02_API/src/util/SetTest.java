/*	Set * Iterator API 학습
 * 	1. Set : 데이터 중복없이 무결 및 고유하게 관리하는 구조
 * 				저장하는 순서에 대한 보장 불가, index로도 데이터 관리 불가
 * 	2. 데이터 관리
 * 		- java.util.Iterator API : 데이터(요소=element)를 내부적으로 나름의 정렬 방식으로 정렬해서 관리
 * 										: boolean hasNext() - 데이터 존재유무 확인
 * 										: Object next() - 데이터 반환
 * 	3. 깊이 있는 생각하기
 * 		1. java.util.Iterator interface
 *			- 스펙을 제시하는 껍데기, 미완성,
 *				Iterator i = new Iterator(); X
 *				Iterator i = 상속받아 완벽하게 구현한 자식객체생성();
 *
 *		2. 고려하기
 *		public Iterator iterator() {
 *			HashSet의 메소드.. 이 로직은 HashSet이 보유한 데이터들을 열거해서 관리하는 객체로 변환해서 반환
 *			Iterator 이미 완벽하게 구현하고 있는
 *			자식클래스 (java.util.HashMap$KeyIterator)가 존재해서
 *			그 클래스를 기반으로 객체 생성하고 다형성 원리로 인해
 *			부모타입에 자식객체 반환
 *		}
 */

package util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set s = new HashSet();
		s.add("대한");
		s.add("호성");
		s.add("대한");
		s.add("성식");
		System.out.println(s.toString());	// [호성, 성식, 대한]
		/*	다음처럼 이름하나 출력후 개행, 이름 출력 후 개행이 되도록 소스 수정하기
		 * 힌트 : API - Iterator
		 * 이름
		 * 이름
		 * 이름
		 * 
		 */
		/* 안되는이유는 객체를 새로 가져오기 때문에 변수를 선언해서 사용하는것이 좋다.
		 * while(s.iterator().hasNext()) {
				System.out.println(s.iterator().next());
		}*/
		
		Iterator all = s.iterator();
		while(all.hasNext()) {
			System.out.println(all.next());
		}
		
		
	}

}

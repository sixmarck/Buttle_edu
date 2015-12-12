/*	학습내용
 * 1. 문자열 API학습
 * 		* java.lang package
 * 		1. String
 * 			- "" 표기법 만으로 자동 객체로 생성
 *			- 한번 생성된 메모리의 데이터는 수정 불가
 * 		2. StringBuffer
 * 			- new 생성
 * 			- 한번 생성된 메모리의 데이터 갱신 가능
 * 			- 스레드에 안정적인 API[단 Performance는 저하]
 * 		3. StringBuilder
 * 			- new 생성
 * 			- 한번 생성된 메모리의 데이터 갱신 가능
 * 			- StringBuffer처럼 스레드에 안정적이진 않으나 개발자가 안정적으로 코드를 개발가능
 * 			  (* 실행 Performance는 StringBuffer보다 좋음)
 * 
 * 2. JDK 변천사에 따른 권장 API
 * 		- 불변 또는 개발의 편리성만 봤을때의 권장 - String
 * 		- 가변적인 문자열 & 스레드 안정적인 API - StringBuffer
 *		- 가변적인 문자열 & performance 향상 API - StringBuilder
 * 3. JRE 내부의 실행 Performance
 * 		- jdk 1.7부터는 String API실행 performance를 향상 시켰다고 함
 * 
 * 
 */

package api;

public class StringAPI {

	public static void main(String[] args) {
		String s = "부";	// 부 라는 문자열 객체 생성
		//s.concat("뜰");
		s = s.concat("뜰"); // 뜰이라는 문자열객체, 부뜰이라는 문자열 객체 생성
		System.out.println(s);
		
		StringBuilder sb = new StringBuilder("부");
		sb.append("뜰");
		System.out.println(sb);
		
		// == 연산자 주소값 비교하기 & new와 표기만으로 생성되는 객체의 차이점 보기
		String s1 = "문";
		String s2 = new String("문");
		String s3 = "문";
		String s4 = new String("문");
		System.out.println(s1 == s2);		// f
		System.out.println(s2 == s3);
		System.out.println(s3 == s4);
		System.out.println(s2 == s4);
		System.out.println(s1 == s3);		// t
	}

}

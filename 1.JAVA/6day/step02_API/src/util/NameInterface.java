/*	interface 학습
 * 1. 용도 : 사용하는 개발자, 제시하는 스펙 제시자, 제품 판매목적의 벤더사간의 강제적인 스펙
 * 2. 문법
 * 		1) 상수와 추상 메소드로만 구성
 * 		2) 상수인 경우
 * 			[public static final] 타입 상수명 = 값;
 * 		3) 추상 메소드인 경우
 * 			[public abstract] 반환 타입 메소드명(...) [throws ~ Exception];
 * 
 */

package util;

// alt + shift + R 사용하고 있는 모든 이름 변경
public interface NameInterface {
	public static final int NO = 3;
	int NO2 = 5;
	
	/*	반드시 개발자 이름 반환 */
	public abstract String getName();
	/* 내 짝궁 이름 반환 */
	String getName2();
}

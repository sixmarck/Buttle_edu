package iotest;

import java.io.IOException;
import java.io.InputStreamReader;

public class IO1 {

	public static void main(String[] args) {
		// 키보드로 부터 2byte씩 변환하면서 입력 가능한 자바 객체 생성
		InputStreamReader in = new InputStreamReader(System.in);
		try {
			// 32bit이나... 한 음절만 read가능한 메소드
			/*	데이터를 종료전까지 입력해서 출력하는 로직 추가 개발 필수
			 * 고려사항 : 종료 시점 파악
			 * *** 문자열 단위로 read : null로 데이터 유무 체크
			 * 		int값 반환하는 read() : -1이 데이터 유무 체크
			 */
			System.out.println((char) in.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//자원 반환 필수
				in.close();
				in = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}

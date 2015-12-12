package iotest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO2 {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			//in = new BufferedReader(new InputStreamReader(System.in));
			in = new BufferedReader(new FileReader("readme.txt"));
			out = new BufferedWriter(new FileWriter("buttle.txt"));
			//out = new BufferedWriter(new FileWriter("buttle.txt", true));
			
			// 좋은 코드
			String v = null;
			while((v = in.readLine()) != null) {
//				System.out.println(v);
				//out.write(v + "\r\n");	// \r 캐리지 리턴 \n 줄바꿈
				out.write(v);
				out.newLine();
			}
			out.flush();
			
			/*String v = in.readLine();
			//반복문 & 조건문 활용해서 모든 데이터 read해서 출력
			while(v != null) {
				System.out.println(v);
				v = in.readLine();
			}*/
			
		} catch (Exception e) {	// 다형성으로 모든 예외 처리 일괄적으로 진행
			e.printStackTrace();
		} finally {
			try {
				in.close();
				in = null;
				out.close();
				out = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

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
			
			// ���� �ڵ�
			String v = null;
			while((v = in.readLine()) != null) {
//				System.out.println(v);
				//out.write(v + "\r\n");	// \r ĳ���� ���� \n �ٹٲ�
				out.write(v);
				out.newLine();
			}
			out.flush();
			
			/*String v = in.readLine();
			//�ݺ��� & ���ǹ� Ȱ���ؼ� ��� ������ read�ؼ� ���
			while(v != null) {
				System.out.println(v);
				v = in.readLine();
			}*/
			
		} catch (Exception e) {	// ���������� ��� ���� ó�� �ϰ������� ����
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

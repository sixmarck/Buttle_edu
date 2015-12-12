package iotest;

import java.io.IOException;
import java.io.InputStreamReader;

public class IO1 {

	public static void main(String[] args) {
		// Ű����� ���� 2byte�� ��ȯ�ϸ鼭 �Է� ������ �ڹ� ��ü ����
		InputStreamReader in = new InputStreamReader(System.in);
		try {
			// 32bit�̳�... �� ������ read������ �޼ҵ�
			/*	�����͸� ���������� �Է��ؼ� ����ϴ� ���� �߰� ���� �ʼ�
			 * ������� : ���� ���� �ľ�
			 * *** ���ڿ� ������ read : null�� ������ ���� üũ
			 * 		int�� ��ȯ�ϴ� read() : -1�� ������ ���� üũ
			 */
			System.out.println((char) in.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//�ڿ� ��ȯ �ʼ�
				in.close();
				in = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}

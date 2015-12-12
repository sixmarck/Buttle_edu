/*	�н�����
 * 1. ���ڿ� API�н�
 * 		* java.lang package
 * 		1. String
 * 			- "" ǥ��� ������ �ڵ� ��ü�� ����
 *			- �ѹ� ������ �޸��� �����ʹ� ���� �Ұ�
 * 		2. StringBuffer
 * 			- new ����
 * 			- �ѹ� ������ �޸��� ������ ���� ����
 * 			- �����忡 �������� API[�� Performance�� ����]
 * 		3. StringBuilder
 * 			- new ����
 * 			- �ѹ� ������ �޸��� ������ ���� ����
 * 			- StringBufferó�� �����忡 ���������� ������ �����ڰ� ���������� �ڵ带 ���߰���
 * 			  (* ���� Performance�� StringBuffer���� ����)
 * 
 * 2. JDK ��õ�翡 ���� ���� API
 * 		- �Һ� �Ǵ� ������ ������ �������� ���� - String
 * 		- �������� ���ڿ� & ������ �������� API - StringBuffer
 *		- �������� ���ڿ� & performance ��� API - StringBuilder
 * 3. JRE ������ ���� Performance
 * 		- jdk 1.7���ʹ� String API���� performance�� ��� ���״ٰ� ��
 * 
 * 
 */

package api;

public class StringAPI {

	public static void main(String[] args) {
		String s = "��";	// �� ��� ���ڿ� ��ü ����
		//s.concat("��");
		s = s.concat("��"); // ���̶�� ���ڿ���ü, �ζ��̶�� ���ڿ� ��ü ����
		System.out.println(s);
		
		StringBuilder sb = new StringBuilder("��");
		sb.append("��");
		System.out.println(sb);
		
		// == ������ �ּҰ� ���ϱ� & new�� ǥ�⸸���� �����Ǵ� ��ü�� ������ ����
		String s1 = "��";
		String s2 = new String("��");
		String s3 = "��";
		String s4 = new String("��");
		System.out.println(s1 == s2);		// f
		System.out.println(s2 == s3);
		System.out.println(s3 == s4);
		System.out.println(s2 == s4);
		System.out.println(s1 == s3);		// t
	}

}

/*	Wrapper API
 * 1. wrapper Ŭ������?
 * 		- �⺻ Ÿ�԰� 1:1 ���εǴ� ��üŸ���� Ŭ������
 * 	2. ����
 * 		- 8����
 * 	3. �ʿ伺
 * 		- �ڷᱸ�� Ŭ������(list, map, set)�� Ȱ��Ǵ� ������ Ÿ���� ��ü�� ����
 * 			���������� ������ ���� �� Ȱ���� �����ϰ� 8������ Ŭ������ ����
 * 4. Ŭ������
 * 		- boolean : Boolean, char : Character, int : Integer ...
 * 
 */
package api;

import java.util.ArrayList;
import java.util.List;

public class WrapperClass {

	public static void main(String[] args) {
		List a = new ArrayList();
		a.add(new Integer(3));
		a.add(new Boolean(false));
		
		Integer i = (Integer)a.get(0);
		int v = i.intValue();
		System.out.println(v);
		
		for (int j = 0; j < a.size(); j++) {
			System.out.println(a.get(j));
		}
	}
}

/* 1. �迭�� ����� ����
 * 2. index�� ������ ����
 * 3. ��ü�鸸 ����[���� ����]
 * 4. ���� : �迭�� �޸� �޸� ����� ������
 * 		- ������ ���� ������ ����ÿ� �����ϱ⵵ ��
 * 	
 * tip
 * 	- jdk1.5 ���� �߰��� ǥ����
 * 	Object = E = V = T = K
 * E : Element�� ���, ��ü������ �ϳ��ϳ�
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
		//�迭�� �񱳽� �迭 ��ü ���� : �޸� ���� 10�� �켱����
		// 10���� ������ �̻� ����� 10���� �޸� �ڵ� ����
		java.util.ArrayList al = new java.util.ArrayList();
		
		al.add("������");
		al.add(new Integer(24));
		
		/* ������ ArrayList�� ������ ����
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
		
		//? Iterator�� Ȱ���ؼ� ������ ����غ���
		Iterator it = al2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

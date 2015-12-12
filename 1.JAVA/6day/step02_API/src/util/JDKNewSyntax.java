/*	�н�����
 * 1. jdk1.5���� �߰��� ���� �н�
 * 2. ����
 * 		1) for
 * 		2) ���׸� ��ī����
 * 		3) autoboxing & unboxing
 * 			- wrapper class������ ����Ǵ� ����
 * 			- ��üŸ�԰� �⺻Ÿ�԰��� ������ Ȯ��Ȱ��ϻ� �������� ���� ������ 
 * 				��üŸ���� ��ü������, �⺻Ÿ���� �⺻�����ͷ� ����Ǵ°� ����
 * 
 */
package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDKNewSyntax {
	//for�� �н�
	public static void forSyntax() {
		String[] all = {"a", "b", "c"};
		for(String v : all) {
			System.out.println(v);
		}
	}
	
	public static void genericSyntax() {
		// String ��ü�� ���� ������ ArrayList
		// ���� : ����ȯ ���� ���ʿ� ���� �ڵ尡 ����
		List<String> list = new ArrayList<String>();
		list.add("ee");
		list.add("an");
		
		for(String s : list) {
			System.out.println(s);
		}
		
	}
	
	public static void boxingSyntax() {
		// autoboxing
		Integer i = 3;		// ������ ���� Integer i = new Integer(3);
		// unboxing
		int i2 = new Integer(3); // ������ ���� int i2 = (new Integer(3)).intValue();
		
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("one", i);
		m.put("two", i2);
	}
	
	public static void main(String[] args) {
		forSyntax();
		genericSyntax();
	}

}

package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UtilTest {
	
	//�����͸� HaspMap�� �����ؼ� ����
	public static Map getData() {
		Map map = new HashMap();
		//����� �̸��� ����
		map.put("01", "�뼱");
		map.put("02", "����");
		map.put("03", "�°�");
		return map;
	}
	
	//������ ������ ȹ���ؼ� Ȱ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//? key�� �𸥴ٸ� ��� key���� ��ȯ�ؼ� key�� �´� data Ȱ��?
		Map all = UtilTest.getData();
		//? API�� key�˻��Ŀ� key�� �´� value ��ȯ�޼ҵ� -> ���
		
		Set allKey = all.keySet();
		Iterator it = allKey.iterator();
		String key = null;
		
		while(it.hasNext()) {
			key = (String)it.next();
			System.out.println("key = " + key + " value = " + all.get(key));
		}
		
		
		
		/*List list = new ArrayList();
		
		int count = 0;
		while(i.hasNext()) {
			list.add(i.next());
			System.out.println(list.get(count));
			count++;
		}
		
		for (int j = 0; j < list.size(); j++) {
			System.out.println(all.get(list.get(j)));
		}*/
	}

}

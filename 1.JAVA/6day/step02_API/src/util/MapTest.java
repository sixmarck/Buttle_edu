/*	Map ���� �н�
 * 	1. key�� value �����ؼ� ������ ����
 * 2. key�� ���� �ߺ� �Ұ�, value �ߺ� ����
 * 		key�� value�� ������
 * 
 */

package util;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map map = new HashMap();
		//����� �̸��� ����
		map.put("01", "�뼱");
		map.put("02", "����");
		map.put("03", "�°�");
		
		System.out.println(map.get("02"));
		map.remove("02");
		System.out.println(map.get("02"));
	}

}

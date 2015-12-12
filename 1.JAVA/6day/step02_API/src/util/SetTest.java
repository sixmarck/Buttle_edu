/*	Set * Iterator API �н�
 * 	1. Set : ������ �ߺ����� ���� �� �����ϰ� �����ϴ� ����
 * 				�����ϴ� ������ ���� ���� �Ұ�, index�ε� ������ ���� �Ұ�
 * 	2. ������ ����
 * 		- java.util.Iterator API : ������(���=element)�� ���������� ������ ���� ������� �����ؼ� ����
 * 										: boolean hasNext() - ������ �������� Ȯ��
 * 										: Object next() - ������ ��ȯ
 * 	3. ���� �ִ� �����ϱ�
 * 		1. java.util.Iterator interface
 *			- ������ �����ϴ� ������, �̿ϼ�,
 *				Iterator i = new Iterator(); X
 *				Iterator i = ��ӹ޾� �Ϻ��ϰ� ������ �ڽİ�ü����();
 *
 *		2. ����ϱ�
 *		public Iterator iterator() {
 *			HashSet�� �޼ҵ�.. �� ������ HashSet�� ������ �����͵��� �����ؼ� �����ϴ� ��ü�� ��ȯ�ؼ� ��ȯ
 *			Iterator �̹� �Ϻ��ϰ� �����ϰ� �ִ�
 *			�ڽ�Ŭ���� (java.util.HashMap$KeyIterator)�� �����ؼ�
 *			�� Ŭ������ ������� ��ü �����ϰ� ������ ������ ����
 *			�θ�Ÿ�Կ� �ڽİ�ü ��ȯ
 *		}
 */

package util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set s = new HashSet();
		s.add("����");
		s.add("ȣ��");
		s.add("����");
		s.add("����");
		System.out.println(s.toString());	// [ȣ��, ����, ����]
		/*	����ó�� �̸��ϳ� ����� ����, �̸� ��� �� ������ �ǵ��� �ҽ� �����ϱ�
		 * ��Ʈ : API - Iterator
		 * �̸�
		 * �̸�
		 * �̸�
		 * 
		 */
		/* �ȵǴ������� ��ü�� ���� �������� ������ ������ �����ؼ� ����ϴ°��� ����.
		 * while(s.iterator().hasNext()) {
				System.out.println(s.iterator().next());
		}*/
		
		Iterator all = s.iterator();
		while(all.hasNext()) {
			System.out.println(all.next());
		}
		
		
	}

}

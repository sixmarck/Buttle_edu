package model;

import exception.IdCheckException;
import model.domain.Person;

public class Service {
	//�˻� �޼ҵ�
	/* ���� ok
	 * ������ ���� �߻�
	 * 1. Ư�� Person ��ü �˻��� ������
	 *   ��? �� �޼ҵ�� ������ Person[]�� ������ ��ü�� ��ȯ
	 * 2. client�� ��û�ϴ� ������ ��ü�� ��ȯ�ϱ� ���� ����
	 *   - client ��û ���� ������ �ʿ� : parameter
	 *   - ��ȯ Ÿ�� : �˻��� Person
	 *     - ��û�ϴ� ���� ���� ���� ������ ���...
	 */
	public static Person search(String v) {
		Person []  all = Data.getAll();
		Person p = null;
		
		if(v.equals("one")) {
			p = all[0];
		}else if(v.equals("two")) {
			p = all[1];
		}
		return p;
	}
	
	//������ ���� ���� �� �ߺ� üũ ���� �����ؼ� �����ϱ�
	public static void save(Person v) throws IdCheckException {
		Person[] all = Data.getAll();
		String id = null;
		for (int i = 0; i < all.length; i++) {
			id = all[i].getId();
			if (id.equals(v.getId())) {
				throw new IdCheckException("id�� �ߺ��Ǿ����ϴ�.");
			}
		}
		Data.newSave(v);	//���� �迭�� ���� ����
	}

	public static Person[] getAll() {
		return Data.getAll();
	}

	public static Person getOne(String v) {
		// TODO Auto-generated method stub
		int idx = 0;
		switch (v) {
		case "one":
			idx = 0;
			break;
		case "two":
			idx = 1;
			break;
		case "three":
			idx = 2;
			break;
		default:
			break;
		}
		return Data.getOne(idx);
	}
}

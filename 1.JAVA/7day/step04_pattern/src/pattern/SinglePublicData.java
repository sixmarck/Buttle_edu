package pattern;

public class SinglePublicData {
	private static SinglePublicData instance = new SinglePublicData();
	
	/* �����ڿ��� ��� �͵��� ���� �� �������ִ� �ϳ��� ��ü�� ���� */
	private SinglePublicData() {}
	public static SinglePublicData getInstance() {
		return instance;
	}
	
	/*public static SinglePublicData getInstance() {
		if(instance == null) {
			instance = new SinglePublicData();
		}
		return instance;
	}*/
}

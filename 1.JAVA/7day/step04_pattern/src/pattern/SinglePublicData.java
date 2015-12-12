package pattern;

public class SinglePublicData {
	private static SinglePublicData instance = new SinglePublicData();
	
	/* 공유자원의 모든 것들을 관리 및 제공해주는 하나의 객체라 간주 */
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

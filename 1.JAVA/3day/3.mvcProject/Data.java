public class Data {
	public static Career[] getCareer() {
		Career[] careers = {new Career("1", "���", "010-"), new Career("2", "���")};
		return careers;
	}

	public static Newcomer[] getNewcomer() {
		Newcomer[] newcomer = {new Newcomer("1", "����", "111"), new Newcomer("2", "����", "222")};
		return newcomer;
	}

	public static CEO[] getCEO() {
		CEO[] ceo = {new CEO("1", "CEO", "111"), new CEO("2", "CEO", "222")};
		return ceo;
	}
}
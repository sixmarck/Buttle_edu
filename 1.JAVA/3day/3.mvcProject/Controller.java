public class Controller{
	public static void request(int index) {
		switch(index) {
			case 1:
				//EndView.careerPrint(Data.getCareer());
				EndView.comment(index);
				EndView.print(Data.getCareer());
				break;
			case 2:
				//EndView.newcomerPrint(Data.getNewcomer());
				EndView.comment(index);
				EndView.print(Data.getNewcomer());
				break;
			case 3:
				//EndView.ceoPrint(Data.getCEO());
				EndView.comment(index);
				EndView.print(Data.getCEO());
				break;
			case 4:
				EndView.comment(index);
				Object[][] allDate = {Data.getCareer(), Data.getNewcomer(), Data.getCEO()};
				EndView.print(allDate);
				break;
			default:
				break;
		}
	}
}
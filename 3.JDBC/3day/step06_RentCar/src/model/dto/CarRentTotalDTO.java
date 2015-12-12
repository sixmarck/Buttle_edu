package model.dto;

public class CarRentTotalDTO {
	private int carNo;
	private String carName;
	private int carPax;
	private int carPrice;
	private String carFuel;
	private int carOption;
	private int agtNo;
	private int day;
	private int memMilage;
	private double disValue;
	private int resTotal;
	
	public CarRentTotalDTO() {
		super();
	}

	public CarRentTotalDTO(int carNo, String carName, int carPax, int carPrice,
			String carFuel, int carOption, int agtNo, int day, int memMilage,
			double disValue, int resTotal) {
		super();
		this.carNo = carNo;
		this.carName = carName;
		this.carPax = carPax;
		this.carPrice = carPrice;
		this.carFuel = carFuel;
		this.carOption = carOption;
		this.agtNo = agtNo;
		this.day = day;
		this.memMilage = memMilage;
		this.disValue = disValue;
		this.resTotal = resTotal;
	}

	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarPax() {
		return carPax;
	}

	public void setCarPax(int carPax) {
		this.carPax = carPax;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getCarFuel() {
		return carFuel;
	}

	public void setCarFuel(String carFuel) {
		this.carFuel = carFuel;
	}

	public int getCarOption() {
		return carOption;
	}

	public void setCarOption(int carOption) {
		this.carOption = carOption;
	}

	public int getAgtNo() {
		return agtNo;
	}

	public void setAgtNo(int agtNo) {
		this.agtNo = agtNo;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMemMilage() {
		return memMilage;
	}

	public void setMemMilage(int memMilage) {
		this.memMilage = memMilage;
	}

	public double getDisValue() {
		return disValue;
	}

	public void setDisValue(double disValue) {
		this.disValue = disValue;
	}

	public int getResTotal() {
		return resTotal;
	}

	public void setResTotal(int resTotal) {
		this.resTotal = resTotal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarRentTotalDTO [carNo=");
		builder.append(carNo);
		builder.append(", carName=");
		builder.append(carName);
		builder.append(", carPax=");
		builder.append(carPax);
		builder.append(", carPrice=");
		builder.append(carPrice);
		builder.append(", carFuel=");
		builder.append(carFuel);
		builder.append(", carOption=");
		builder.append(carOption);
		builder.append(", agtNo=");
		builder.append(agtNo);
		builder.append(", day=");
		builder.append(day);
		builder.append(", memMilage=");
		builder.append(memMilage);
		builder.append(", disValue=");
		builder.append(disValue);
		builder.append(", resTotal=");
		builder.append(resTotal);
		builder.append("]");
		return builder.toString();
	}
}
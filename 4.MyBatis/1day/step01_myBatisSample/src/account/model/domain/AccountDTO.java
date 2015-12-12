package account.model.domain;

public class AccountDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;

	public AccountDTO() {
		System.out.println("난 기본");
	}

	public AccountDTO(int i, String f, String l, String e) {
		id = i;
		firstName = f;
		lastName = l;
		emailAddress = e;
		System.out.println("생성자");
	}

	public int getId() {
		System.out.println("getId");
		return id;
	}

	public void setId(int id) {
		System.out.println("setId");
		this.id = id;
	}

	public String getFirstName() {
		System.out.println("getFirstName");
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("setFirstName");
		this.firstName = firstName;
	}

	public String getLastName() {
		System.out.println("getLastName");
		return lastName;
	}

	public void setLastName(String lastName) {
		System.out.println("setLastName");
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		System.out.println("getEmailAddress");
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountDTO 객체 정보 [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append("]");
		return builder.toString();
	}
}

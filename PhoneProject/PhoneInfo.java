
public class PhoneInfo {
	String name;
	String phoneNumber;

	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void showInfo() {
		System.out.println("name : " + name);
		System.out.println("phoneNumber : " + phoneNumber);
	}
}

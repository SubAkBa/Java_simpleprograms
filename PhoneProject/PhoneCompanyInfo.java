
public class PhoneCompanyInfo extends PhoneInfo {
	String company;

	public PhoneCompanyInfo(String name, String phonenumber, String company) {
		super(name, phonenumber);
		this.company = company;
	}

	public void showInfo() {
		super.showInfo();
		System.out.println("major : " + company);
	}
}

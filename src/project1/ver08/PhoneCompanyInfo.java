package project1.ver08;

public class PhoneCompanyInfo extends PhoneInfo {
	
	String company;
	
	public PhoneCompanyInfo(String name, String phoneNumber, 
			 String company) {
		
		super(name,phoneNumber);
		this.company=company;
		
	}
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사명:"+ company);
	
		
	}

}

	












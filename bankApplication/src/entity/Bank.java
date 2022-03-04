package entity;

public class Bank {

	private static final String bankName = "Piggy Bank";
	
	private String bankIfscCode = "PB007";

	public String getBankIfscCode() {
		return bankIfscCode;
	}

//	public void setBankIfscCode(String bankIfscCode) {
//		this.bankIfscCode = bankIfscCode;
//	}

	public static String getBankname() {
		return bankName;
	}
	
}

package entity;

import java.time.LocalDate;
import java.util.Date;

public class Account extends Bank {

	private long accountId;
	private String accountName;
	private String accountAdhaar;
	private String accountType;
	private double accountBalance;
	private String password;
	private LocalDate accountCreationDate;

	public Account(){}

	public Account(long accountId, String accountName,String accountAdhaar,String accountType, double accountBalance,String password, LocalDate accountCreationDate) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountAdhaar = accountAdhaar;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.password = password;
		this.accountCreationDate = accountCreationDate;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getAccountAdhaar() {
		return accountAdhaar;
	}

	public void setAccountAdhaar(String accountAdhaar) {
		this.accountAdhaar = accountAdhaar;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(LocalDate accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", accountAdhaar=" + accountAdhaar
				+ ", accountBalance=" + accountBalance + ", accountCreationDate=" + accountCreationDate + "]";
	}

}

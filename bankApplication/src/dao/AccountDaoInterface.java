package dao;

import entity.Account;

public interface AccountDaoInterface {
	
	public void createAccount(Account acc);
//	public void login(int accountId, String password);
	public Account getAccountDetails(String adhaar);
	public Account getLoginAccountDetails(Long accountId, String password);
	public String addBalance(Account user, double balance);
	public String withdraw(Account user, double balance);
	public Account getRecipientAccountDetails(Long recipientId);
	public String transfer(Account user, Account recipient, double balance);
	public void removeAccount(Account user);
}

package service;

import entity.Account;

public interface AccountServiceInterface {

	public void createAccount(Account acc);
	public Account getLoginAccountDetails(Long accountId, String password);
	public String addBalance(Account user, double balance);
	public String withdraw(Account user, double balance);
	public Account getRecipientAccountDetails(Long recipientId);
	public String transfer(Account user, Account recipient, double balance);
	public void removeAccount(Account user);
}

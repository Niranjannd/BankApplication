package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import collection.AccountCollection;
import entity.Account;


public class AccountDaoImpl implements AccountDaoInterface  {
	
	Account acc;
	AccountCollection collection = new AccountCollection();
	
	public void createAccount(Account acc) {
			
		collection.createAccount(acc);
	}
	

	public Account getAccountDetails(String adhaar)
	{
		
		return collection.getAccountDetails(adhaar);
		
	}

	@Override
	public Account getLoginAccountDetails(Long accountId, String password) {
		
		return collection.getLoginAccountDetails(accountId, password);
	}


	@Override
	public String addBalance(Account user, double balance) {
		// TODO Auto-generated method stub
		return collection.addBalance(user,balance);
	}


	@Override
	public String withdraw(Account user, double balance) {
		// TODO Auto-generated method stub
		return collection.withdraw(user, balance);
	}


	@Override
	public Account getRecipientAccountDetails(Long recipientId) {
		// TODO Auto-generated method stub
		return collection.getRecipientAccountDetails(recipientId);
	}


	@Override
	public String transfer(Account user, Account recipient, double balance) {
		// TODO Auto-generated method stub
		return collection.transfer(user, recipient, balance);
	}


	@Override
	public void removeAccount(Account user) {
		// TODO Auto-generated method stub
			collection.removeAccount(user);
		
	}
	
}

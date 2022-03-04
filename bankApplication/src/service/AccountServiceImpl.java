package service;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import dao.AccountDaoImpl;
import dao.AccountDaoInterface;
import entity.Account;

public class AccountServiceImpl implements AccountServiceInterface{

	AccountDaoInterface daoI = new AccountDaoImpl();

	@Override
	public void createAccount(Account acc)
	{	
		Account checkAcc = daoI.getAccountDetails(acc.getAccountAdhaar());

		if(checkAcc == null)
		{
			LocalDate date =  LocalDate.now();
			acc.setAccountCreationDate(date);
		
			daoI.createAccount(acc);	
		}
		else
		{
		System.out.println("You already have an account registered to your Adhaar, try to login");
		}
	}
	
		@Override
	public Account getLoginAccountDetails(Long accountId, String password) {
			return daoI.getLoginAccountDetails(accountId, password);
		
	}

		@Override
		public String addBalance(Account user,double balance) {
			
			return daoI.addBalance(user, balance);
		}

		@Override
		public String withdraw(Account user, double balance) {
		
			return daoI.withdraw(user, balance);
		}

		@Override
		public Account getRecipientAccountDetails(Long recipientId) {
			// TODO Auto-generated method stub
			return daoI.getRecipientAccountDetails(recipientId);
		}

		@Override
		public String transfer(Account user, Account recipient, double balance) {
			// TODO Auto-generated method stub
			return daoI.transfer(user, recipient, balance);
		}

		@Override
		public void removeAccount(Account user) {
			// TODO Auto-generated method stub
			daoI.removeAccount(user);
			
		}
		
}

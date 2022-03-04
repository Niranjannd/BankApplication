package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import entity.Account;

public class AccountCollection {
	
	private static HashMap<Integer, Account> accountStorage = new HashMap<Integer, Account>();
	
	static {
		accountStorage.put(1001,new Account(1001,"Niranjan","123456","saving",2000,"Nd@123",null));
		accountStorage.put(1002,new Account(1002,"Rohit","654321","saving",4000,"Rohit@123",null));
		accountStorage.put(1003, new Account(1003,"Pari","65321","saving",1000,"Parilovend",null));
	}
	
	public Account getAccountDetails(String adhaar)
	{
		Iterator<Map.Entry<Integer, Account>> iterator = accountStorage.entrySet().iterator();
		
		while(iterator.hasNext())
		{
			Map.Entry<Integer, Account> entry = iterator.next();
			if(entry.getValue().getAccountAdhaar().equals(adhaar))
			{
				return entry.getValue();
			}
		}return null;
	}
	
	public void createAccount(Account acc)
	{	
		Integer accountNumber = 1001 + accountStorage.size();
		
		acc.setAccountId(accountNumber);
		accountStorage.put(accountNumber,acc);
		
		System.out.println("Congrats your account has been created successfully");
		System.out.println(acc.getAccountId()+ ":is your account number");
	}
	
	public Account getLoginAccountDetails(Long accountId, String password)
	{
		Iterator<Map.Entry<Integer, Account>> iterator = accountStorage.entrySet().iterator();
		
		while(iterator.hasNext())
		{
			Map.Entry<Integer, Account> entry = iterator.next();
			if(entry.getValue().getAccountId() == accountId && entry.getValue().getPassword().equals(password) )
			{
				return entry.getValue();
			}
		}return null;	
	}
	
	public String addBalance(Account user, double balance)
	{
		user.setAccountBalance(user.getAccountBalance()+balance);
		
		System.out.println("Balance has been added successfully, your updated balance :"+user.getAccountBalance());
		return null;
	}
	
	public String withdraw(Account user, double balance)
	{
		if(user.getAccountBalance() >= balance)
		{
			user.setAccountBalance(user.getAccountBalance()-balance);
			System.out.println("Transaction completed, your updated balance :"+user.getAccountBalance());
			return null;
		}else
		{
			System.out.println("You don't have enough balance in your account for this transaction");
			return null;
		}
}
	
	public Account getRecipientAccountDetails(Long recipientId)
	{
		Iterator<Map.Entry<Integer, Account>> itr = accountStorage.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry<Integer, Account> entry = itr.next();
			if(entry.getValue().getAccountId() == recipientId)
			{
				System.out.println("This account belongs to "+entry.getValue().getAccountName());
				return entry.getValue();
			}
			
		}return null;
	}
	
	public String transfer(Account user, Account recipient, double balance)
	{
		if(user.getAccountBalance() < balance)
		{
			System.out.println("There is not enough balance in your account for this transaction");
			return "There is not enough balance in your account for this transaction";
		}
		else
		{
			recipient.setAccountBalance(recipient.getAccountBalance()+balance);
			user.setAccountBalance(user.getAccountBalance()-balance);
			System.out.println("Paymnet completed successfully, your updated balance:"+user.getAccountBalance());
			return null;
		}
	}
	
	public void removeAccount(Account user)
	{
		Long key = user.getAccountId();
		int key1 = key.intValue(); 
		
		accountStorage.remove(key1);
		System.out.println("Account has been removed successfully");
		
		
	}
}


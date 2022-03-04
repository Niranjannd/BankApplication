package UserInterface;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import entity.Account;
import service.AccountServiceImpl;
import service.AccountServiceInterface;

public class FrontPage {

	AccountServiceInterface serviceI = new AccountServiceImpl();
		Account acc = new Account();
	
	
	Scanner scan = new Scanner(System.in);
	
	public void homePage()
	{
		FrontPage page = new FrontPage();	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("######################################");
		System.out.println("1. Create Account");	
		System.out.println("2. Login");	
			
		int input = scan.nextInt();
		
		switch(input) {
		
		
		case 1:
			page.createAccount();
			break;		
			
		case 2:
			page.login();
			break;
			
		default:
			System.out.println("Please chose from mentioned options.");
			page.homePage();
	}
		
}
	
	public void createAccount()
	{
		FrontPage page = new FrontPage();
		acc = new Account();
		
		System.out.println("Enter Account holder name's");
		String accountName1 = scan.nextLine();
		acc.setAccountName(accountName1);
		
		System.out.println("Enter Account holder Adhaar number");
		
		
		int flag1 = 0;
		
		while(flag1 == 0 )
		{
			String accountAdhaar = scan.nextLine();
			if(accountAdhaar.length() != 10)
			{
				System.out.println("Adhaar number should be having 10 digits");
				
			}else
			{
				acc.setAccountAdhaar(accountAdhaar);
				flag1 = 1;
			}
		}
		
		
		
		System.out.println("Chose Account Type 1 or 2");
		System.out.println("1. Student account");
		System.out.println("2. Saving account");
		
		String student = "Student account";
		String saving = "Saving account";
	
		int accType = scan.nextInt();
		if(accType == 1)
		{
		acc.setAccountType(student);
		}else if(accType == 2){
			acc.setAccountType(saving);
		}
	
		if(accType == 1)
		{
			System.out.println("Minimum deposit amount is 0 to create student account");
		
			double balance = scan.nextDouble();
			acc.setAccountBalance(balance);
		}else if(accType == 2)
		{
			System.out.println("Deposit minimum amount is 1000 for saving account");
			
			int flag = 0;
			
			while(flag == 0)
			{
				double balance = scan.nextDouble();
				if(balance< 1000)
				{
				System.out.println("Minimum deposit amount is 1000 for saving account");
				}
				else
				{
					acc.setAccountBalance(balance);
					flag = 1;
				}
			}
			
			
		}
		
		System.out.println("Please set your password for application access");
		String password = scan.next();
		acc.setPassword(password);
	
		serviceI.createAccount(acc);	
		page.homePage();
	}
	
	public void login()
	{
		FrontPage page = new FrontPage();
		
		System.out.println("Enter account number");
		Long accountId = scan.nextLong();
		
		System.out.println("Enter account password");
		String password = scan.next();
		
		System.out.println(password);
		Account checkAcc = serviceI.getLoginAccountDetails(accountId, password);
		
		if(checkAcc != null)
		{
			Account user = checkAcc;
			page.welcome(user);
		}
		else
		{
			System.out.println("Account Id or Password is wrong.");
			page.homePage();
		}

	
	}

	public void welcome(Account user)
	{
		FrontPage page = new FrontPage();
		
		System.out.println("************************");
		System.out.println("Welcome to the Home Page "+user.getAccountName());
		System.out.println("Please chose from below");
		System.out.println("1. Bank statement");
		System.out.println("2. Add balance to your account");
		System.out.println("3. Withdraw the balance from your account ");
		System.out.println("4. Transfer balance to other account");
		System.out.println("5. Check full account details");
		System.out.println("6. Delete your account from bank");
		System.out.println("7. Log out");

		int input = scan.nextInt();
		
		switch(input)
		{
		case 1:
			statement(user);
			break;
		
		case 2:
			addBalance(user);
			break;
			
		case 3:
			withdraw(user);
			break;
			
		case 4 :
			balanceTransfer(user);
			break;
			
		case 5: 
			checkAccountDetails(user);
			break;
			
			
		case 6:
			removeAccount(user);
			break;
			
		case 7 :
			logOut();
			break;
			

		default:
			System.out.println("Please chose from mentioned options.");
			page.welcome(user);
		}
	}
	
	public void statement(Account user)
	{
		FrontPage page1 = new FrontPage();

		System.out.println("Your balane is " +user.getAccountBalance());
		page1.welcome(user);
	}
	public void addBalance(Account user)
	{
		FrontPage page1 = new FrontPage();

		System.out.println("Enter the amount you want to add in your account");
		double balance = scan.nextDouble(); 
		
		serviceI.addBalance(user, balance);
		page1.welcome(user);
	}
	
	public void withdraw(Account user)
	{
		FrontPage page1 = new FrontPage();
		System.out.println("Enter the amount you want to withdraw");
		double balance = scan.nextDouble();
		
		serviceI.withdraw(user, balance);
		page1.welcome(user);
	}
	
	public void balanceTransfer(Account user)
	{
		FrontPage page1 = new FrontPage();
		
		System.out.println("Enter Recipient account number");
		Long recipientId = scan.nextLong();
		
		Account recipient = serviceI.getRecipientAccountDetails(recipientId);
		if(recipient != null)
		{
		System.out.println("Enter the amount");
		double balance = scan.nextDouble();
		
		 serviceI.transfer(user, recipient, balance);
		 page1.welcome(user);
		}
		else
		{
			System.out.println("Account doesn't exist");
		}
		 page1.welcome(user);
	}
	
	public void checkAccountDetails(Account user)
	{
		System.out.println(user +",Bank name:" +acc.getBankname() +", IFSC code:"+ acc.getBankIfscCode());
	}
	
	public void removeAccount(Account user)
	{
		FrontPage page1 = new FrontPage();
		
		System.out.println("If you still want to delete your account enter 1 else enter any other key to go back to menu ");
		int num = scan.nextInt();
		System.out.println(user.getAccountName());
		if(num == 1)
		{
			serviceI.removeAccount(user);
		}
		else
			System.out.println("ss");
			page1.welcome(user);
	}
	
	public void logOut()
	{
		FrontPage page = new FrontPage();
		page.homePage();
	}
	
	
	public static void main(String[] args) {
		
		FrontPage page = new FrontPage();	
		page.homePage();
		
		
	}

}

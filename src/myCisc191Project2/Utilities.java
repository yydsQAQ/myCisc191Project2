package myCisc191Project2;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Utilities
{

	public static Customer getCustomerInfo(Scanner scan)
	{
		Customer customer = new Customer();
		
		System.out.println("Please provide your name?");
		String name = scan.nextLine();
		customer.setName(name, scan);
		
		System.out.println("Please provide your address?");
		String address = scan.nextLine();
		customer.setAddress(address, scan);

		System.out.println("Please provide your phone number?");
		String phoneNumber = scan.nextLine();
		customer.setPhoneNumber(phoneNumber, scan);
	
		return customer;
	}
	
	public static void print(String str)
	{
		System.out.println(str);
	}
	
	public static CheckingAccount getChecking(Bank bank, Scanner scan)
	{
		System.out.println("Please provide your debit card number");
		int position = bank.findCard(scan.nextLine());
		DebitCard debit = (DebitCard) bank.getCard(position);
		System.out.println("Please enter your pin");
		if(debit.isPinValid(scan.nextLine()))
		{
			String acc = debit.getAccountNumber();
			CheckingAccount checking = (CheckingAccount) bank.getAccount(bank.findAccount(acc));
			return checking;
		}else
		{
			throw new InputMismatchException ("Please try again");
		}
	}
	
	public static SavingAccount getSaving(Bank bank, Scanner scan)
	{
		System.out.println("Please provide your debit card number");
		int position = bank.findCard(scan.nextLine());
		DebitCard debit = (DebitCard) bank.getCard(position);
		System.out.println("Please enter your pin");
		if(debit.isPinValid(scan.nextLine()))
		{
			String acc = debit.getSavingAccountNumber();
			SavingAccount saving = (SavingAccount) bank.getAccount(bank.findAccount(acc));
			return saving;
		}else
		{
			throw new InputMismatchException ("Please try again");
		}
	}
	
	public static RewardsAccount getRewards(Bank bank, Scanner scan)
	{
		System.out.println("Please provide your credit card number");
		int position = bank.findCard(scan.nextLine());
		CreditCard credit = (CreditCard) bank.getCard(position);
		System.out.println("Please enter your zip code");
		if(credit.isValidZipCode(scan.nextLine()))
		{
			String acc = credit.getAccountNumber();
			RewardsAccount rewards = (RewardsAccount) bank.getAccount(bank.findAccount(acc));
			return rewards;
		}else
		{
			throw new InputMismatchException ("Please try again");
		}
	}
}

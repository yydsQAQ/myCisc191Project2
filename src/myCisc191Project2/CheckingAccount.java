package myCisc191Project2;
import java.util.Scanner;

/**
 * Lead Author(s):
 * @author Shuyi Yu
 * @author Jing Xie
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors: 
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  
 * Version/date: 03/04/2023
 * 
 * Responsibilities of class: inherit from superclass Account, implements IAccount and implement the add on methods 
 * 
 */
public class CheckingAccount extends Account
{
	/**
	 * Purpose: No-Argument CheckingAccount constructor
	 */
	public CheckingAccount()
	{
	}
	/**
	 * Purpose: CheckingAccount constructor to pass in two parameter to constuct CheckingAccount objects
	 * @param: customer object of Customer type, balance of double type
	 */
	public CheckingAccount(Customer customer, double balance)
	{
		//inherit the constructor from superclass Account 
		super(customer, balance);
	}

	/**
	 * Purpose: method to deposit a amount to account balance
	 * @param the amount of double type
	 */
	@Override
	public void deposit(double amount, Scanner scan) //throws InvalidAmountException
	{
		//add amount to balance
		super.deposit(amount, scan);
		//create a new record of Transaction type each time the account deposits an amount
		Transaction record = new Transaction(super.getCustomer(), "Checking deposit", amount);
		//record each transaction to the arrayList record
		super.addTransaction(record);
	}
	/**
	 * Purpose: method to withdraw a amount to account balance
	 * @param the amount of double type
	 */
	@Override
	public void withdraw(double amount, Scanner scan)//throws InvalidAmountException, InsufficientFundsException
	{
		//minus amount from balance
		super.withdraw(amount, scan);
		//create a new record of Transaction type each time the account withdraw an amount
		Transaction record = new Transaction(super.getCustomer(), "Checking withdraw", amount); 
		//record each transaction to the array record
		super.addTransaction(record);


	}
	/**
	 * Purpose: toString method to write a string details of a account
	 * @return a string of account details
	 */	
	public String toString()
	{
		return "Checking Account Info: " + super.getCustomerName() + " | balance: " + getBalance() + 
				" | account number: " + getAccountNumber();
	}
	


}

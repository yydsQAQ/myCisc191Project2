package myCisc191Project2;
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
 * Responsibilities of class: 
 * 
 */


import java.util.Random;
import java.util.Scanner;

public class Account implements IAccount
{

	private Customer customer; //an Account has-a customer
	private String accountNumber;//an Account has-a accountNumber
	private double balance;//an Account has-a balance
	private Transaction[] transactions;//an Account has-a list that has-many transactions
	private int sizeTransaction = 0;//an Account has-a sizeTransaction to record how many transactions

	/**
	 * Purpose: No-Argument Account constructor
	 */
	public Account()
	{
		
	}
	
	/**
	 * HAS-A relationship: an Account has-a customer and a balance
	 * Purpose: constructor to assign attribute values to the Account
	 * @param: customer of Customer type, balance of double type
	 */
	public Account(Customer customer, double balance)
	{
		this.customer = customer; //assign a customer to the account
		//different account type has a unique account number even under same customerName or same bank
		//https://www.experian.com/blogs/ask-experian/what-is-the-difference-between-routing-and-account-numbers/#:~:text=For%20example%2C%20if%20you%20have,account%20numbers%20will%20be%20different.
		this.accountNumber = generateAccountNumber(); //assign an account number to the account		
		this.balance = balance; //assign a balance to the account
		this.transactions = new Transaction[200]; //create a new ArrayList to the account to store transactions
		
	}

	
	/**
	 * Purpose: setter method to set the balance of the Account equal to the balance passed in from the parameter
	 *@param a double instance variable of the balance
	 */
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	/**
	 * Purpose: getter method to return a double balance of the Account
	 * @return a double balance
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 * Purpose: getter method to return a ArrayList of Transaction type of transactions of the Account
	 * @return an ArrayList transactions
	 */
	public Transaction[] getTransactions()
	{
		return transactions; 
	}
	
	/**
	 * Purpose: add all transactions in ArrayList transactions of the Account
	 *@param a transaction object of Transaction type
	 */
	public void addTransaction(Transaction transaction)
	{
		transactions[sizeTransaction] = transaction;
		sizeTransaction++;
	}
	/**
	 * Purpose: setter method to set the customer of the Account equal to the customer passed in from the parameter
	 *@param a customer object of customer type
	 */
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	/**
	 * Purpose: getter method to return a customer of Customer type of the Account
	 * @return an customer object
	 */
	public Customer getCustomer()
	{
		return customer;
	}
	/**
	 * Purpose: getter method to get a customerName of the Account
	 * @return String customerName 
	 */
	public String getCustomerName()
	{
		return customer.getName();
	}
	/**
	 * Purpose: getter method to get a customerNumber of the Account
	 * @return String customerNumber
	 */
	public String getCustomerNumber()
	{
		return customer.getCustomerNumber();
	}
	/**
	 * Purpose: method to randomly generate a accountNumber for Account
	 * @return String accountNumber
	 */	
	public String generateAccountNumber()	
	{
		Random rand = new Random(); //empty random object
		
		int firstAccNum = rand.nextInt(10000, 99999); //generate the first 5 digit in accountNumber using rand
		int secondAccNum = rand.nextInt(10000, 99999);//generate the second 5 digit in accountNumber using rand

		String accountNumber = String.valueOf(firstAccNum).concat(String.valueOf(secondAccNum)); //concat first and second account number as a String 

		return accountNumber;
	}
		/**
		 * Purpose: getter method to get a accountNumber of the Account
		 * @return String customerNumber
		 */
	public String getAccountNumber()
	{
	
		return accountNumber;
	}
	@Override
	public void deposit(double amount, Scanner scan)
	{
		//check if the amount is negative
		while(amount < 0)
		{
			try
			{
			if(amount < 0)
				throw new Exception("Negative amount is not allowed.");
			
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				System.out.println("Please enter the deposit amount:");
				amount = scan.nextDouble();
			}
		}
		//deposit the amount to balance
		balance += amount;
		
	}
	public void withdraw(double amount, Scanner scan)
	{
		while(amount < 0 || balance < amount)
		{
			try
			{	//throw exception if amount is negative
				if(amount < 0)
					throw new Exception("Negative amount is not allowed.");
				//throw exception if balance is not enough
				else if(balance < amount)
					throw new Exception("Insufficient balance");
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				System.out.println("Please enter the withdraw amount:");
				amount = scan.nextDouble();	
			}
		}
		
		balance -= amount;
		
	}
	/**
	 * Purpose: 
	 *@param a String instance variable of the accountNumber
	 */
	public String toString()
	{
		return customer.toString() + "Account Number: " + accountNumber;
		
	}




	
	
	

}

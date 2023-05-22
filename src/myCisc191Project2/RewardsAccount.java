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
 * Responsibilities of class: rewarding account class that extend from superclass Account and implements from interface IAccount and implement all methods
 * 
 */

public class RewardsAccount extends Account implements IAccount
{
	private double balance;//a RewardsAccount has-a balance
	private double bonus;//a RewardsAccount has-a bonus
	private double LIMIT_TO_SPEND;//a RewardsAccount has-a limit
	private double BONUS_TO_CASH_RATE = 0.02; ////a RewardsAccount has-a BONUS_TO_CASH_RATE of 2% cash back 
	/**
	 * Purpose: RewardsAccount constructor to pass in two parameter to constuct a RewardsAccount objects
	 * @param: customer object of Customer type
	 * @param: DebitCard balance of double type
	 */	
	public RewardsAccount(Customer customer, double balance)
	{
		super(customer, balance);
		bonus = 0;
	}
	
	/**
	 * Purpose: method to redeem bonus for cashBack to make payment to creditCard
	 * @param bonus wishing to redeem
	 * @throws InsufficientFundsException 
	 * @throws InvalidAmountException 
	 */
	public void redeemBonus(double bonus)
	{
		try
		{
			if(this.bonus < bonus) 
			{
				throw new Exception("Insufficient bonus");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		//cashBack is the bonus multiply by 0.02 rate
		double cashBack = bonus * BONUS_TO_CASH_RATE; 
		minusBonus(bonus); //minus the redeeming bonus from the current bonus
		balance += cashBack; //make payment with the 2% cash back
		//create a new record of Transaction type each time the account redeems an amount
		Transaction record = new Transaction(super.getCustomer(), "Bonus makes payment", cashBack); 
		//record each transaction to the arrayList record
		super.addTransaction(record);

	}
	/**
	 * Purpose: method to add bonus to current bonus
	 * @param bonus wishing to add in double
	 */
	public void addBonus(double points)
	{
		bonus += points;
	}
	/**
	 * Purpose: getter method to get the current bonus
	 * @return bonus in double
	 */
	public double getBonus()
	{
		return bonus;
	}
	/**
	 * Purpose: getter method to get the current balance
	 * @return balance in double
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 * Purpose: method to subtract bonus from current bonus
	 * @param bonus wishing to subtract in double
	 */
	public void minusBonus(double points)
	{
		bonus -= points;
	}

	/**
	 * Purpose: method to withdraw and record outgoing money
	 * @param amount to withdraw of double type (making purchases with credit card)
	 */
	@Override
	public void withdraw(double amount, Scanner scan)
	{
		while(amount < 0 || amount > LIMIT_TO_SPEND - balance)
		{
			try
			{
				if(amount < 0)
				{
					throw new Exception("Negative amount is not allowed");
				}
				//if statement to test is the amount and current balance exceeds the total allowed spending limit
				if(amount > LIMIT_TO_SPEND - balance)
				{
					//throw exception if balance exceeds spending limit
					throw new Exception("Insufficient funds");
				}
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				System.out.println("Please enter the payment amount");
				amount = scan.nextDouble();
			}
		}
		
		//add amount spent to current balance
		balance += amount;
		//create a new record of Transaction type each time the account makes purchase
		Transaction record = new Transaction(super.getCustomer(), "Credit makes payment", amount);
		//record each transaction to the arrayList record
		super.addTransaction(record);
		//add amount spent to bonus
		System.out.println("You're current balance is: " + balance);

	}
	/**
	 * Purpose: method to deposit and record incoming money
	 * @param amount to deposit of double type (making payment to the credit card)
	 */
	@Override
	public void deposit(double amount, Scanner scan)
	{
		while(amount < 0)
		{
			try
			{
				if(amount < 0)
				{
					throw new Exception("Negative amount is not allowed");
				}
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				System.out.println("Please enter the purchase amount");
				amount = scan.nextDouble();
			}
		}
		
		//subtract amount repaid to current balance
		balance -= amount;
		//create a new record of Transaction type each time the account makes payment
		Transaction record = new Transaction(super.getCustomer(), "Credit makes purchase", amount); 
		//record each transaction to the arrayList record
		super.addTransaction(record);
		addBonus(amount);
		System.out.println("You're current balance is: " + balance);
	}

	/**
	 * Purpose: toString method to write a string details of the account
	 * @return a string of account details
	 */	
	public String toString()
	{
		return "Rewards Account Info: " + super.getCustomerName() + " | balance: " + balance
		+ " | account number: " + getAccountNumber();
	}




}
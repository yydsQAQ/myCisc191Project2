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
 * Responsibilities of class: implement the transaction constructor and implement all the methods of the Transaction class
 * 
 */
import java.time.*;

public class Transaction
{
	private Customer customer;//a transaction has-a customer
	private String transactionType;//a transaction has-a transaction 
	private double amount;//a transaction has-a amount 
	private LocalDate date;//a transaction has- a data
	private LocalTime time;//a transaction has- a time

	/**
	 * Purpose: Customer constructor to pass in three parameter to constuct a Customer objects
	 * @param: customer of Customer type
	 * @param: transactionType of String type
	 * @param: amount of double type
	 */	
	public Transaction(Customer customer, String transactionType, double amount)
	{
		this.customer = customer;
		this.transactionType = transactionType;
		this.amount = amount;
		this.date = LocalDate.now();
		this.setTime(LocalTime.now());
	}
	/**
	 * Purpose: getter method to get the date  
	 * @return date of LocalDate type
	 */
	public LocalDate getDate()
	{
		return date;
	}
	/**
	 * Purpose: getter method to get the time
	 * @return time of LocalTime type
	 */
	public LocalTime getTime()
	{
		return time;
	}
	/**
	 * Purpose: getter method to get the time
	 * @return time of LocalTime type
	 */
	public LocalTime setTime(LocalTime time)
	{
		return this.time = time;
	}
	/**
	 * Purpose: setter method to set customer
	 * @param customer name in Customer type
	 */
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	/**
	 * Purpose: getter method to get customer
	 * @return customer of Customer type
	 */
	public Customer getCustomer()
	{
		return customer;
	}
	/**
	 * Purpose: getter method to get the customerName  
	 * @return customerName of String type
	 */
	public String getCustomerName()
	{
		return customer.getName();
	}
	/**
	 * Purpose: getter method to get the customerNumber  
	 * @return customerNumber of String type
	 */
	public String getCustomerNumber()
	{
		return customer.getCustomerNumber();
	}
	/**
	 * Purpose: getter method to get the transactionType  
	 * @return transactionType of String type
	 */
	public String getTransactionType()
	{
		return transactionType;
	}
	/**
	 * Purpose: setter method to set transactionType
	 * @param transactionType in String type
	 */
	public void setTransactionType(String transactionType)
	{
		this.transactionType = transactionType;
	}
	/**
	 * Purpose: getter method to get the amount  
	 * @return amount of double type
	 */
	public double getAmount()
	{
		return amount;
	}
	/**
	 * Purpose: setter method to set amount
	 * @param amount in double type
	 */
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	/**
	 * Purpose: toString method to write a string details of a transaction
	 * @return a string of a transaction detail
	 */	
	public String toString()
	{
		return "Transaction: Sender: " + customer.getCustomerNumber() + " | transaction type: " + transactionType +  " | amount: " + amount + " | date: " + date;
	}

}

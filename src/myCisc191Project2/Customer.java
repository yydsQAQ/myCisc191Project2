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
 * Responsibilities of class: Customer class that has the Customer constructor and implement the mutators and accessors of the customer attributes
 * 
 */
public class Customer
{

	private String name;//a customer has-a name
	private String address;//a customer has-a address
	private String phoneNumber;//a customer has-a phone number 
	private String customerNumber; // a customer has-a customer number (same as routing number in the real world)
	private static int customerNum = 0;//customerNumber that start from 0
	
	/**
	 * Purpose: Customer constructor to pass in three parameter to constuct a Customer objects
	 * @param: customerName of String type
	 * @param: customer address of String type
	 * @param: customer phone number of String type
	 */	
	public Customer(String name, String address, String phoneNumber)
	{
		this.name = name; 
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.customerNumber = createNewCustomerNumber(); //assign a unique customer number to each customer
		
	}
	/**
	 * Purpose: No-Argument Card constructor
	 */
	public Customer()
	{
	}
	/**
	 * Purpose: getter method to get the customerNumber  
	 * @return customerNumber of String type
	 */
	public String getCustomerNumber()
	{
		return customerNumber;
	}
	/**
	 * Purpose: method to create a new customer number that add 1 to the previous customer numeber
	 * @return a new customerNum of String type
	 */
	public static String createNewCustomerNumber()
	
	{	
		return String.format("C%010d", customerNum++); //ex: 0000000001, 0000000002, ...
	}
	/**
	 * Purpose: getter method to get the customer name
	 * @return name of String type
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Purpose: setter method to set customer name
	 * @param customer name in String type
	 */
	public void setName(String name, Scanner scan)
	{
		while(name.isEmpty())
		{
			try
			{
				if(name.isEmpty())
				{
					throw new Exception("Cannot input an empty name");
				}
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				System.out.println("Please provide your name?");
				name = scan.nextLine();
			}
		}
		this.name = name;
	}
	/**
	 * Purpose: getter method to get the customer address
	 * @return address of String type
	 */
	public String getAddress()
	{
		return address;
	}
	/**
	 * Purpose: setter method to set customer address
	 * @param customer address in String type
	 */
	public void setAddress(String address, Scanner scan)
	{
		while(address.isEmpty())
		{
			try
			{
				if(address.isEmpty())
				{
					throw new Exception("Cannot input an empty address");
				}
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				System.out.println("Please provide your address?");
				address = scan.nextLine();
			}
		}
		this.address = address;
	}
	/**
	 * Purpose: getter method to get the customer phoneNumber
	 * @return phoneNumber of String type
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	/**
	 * Purpose: setter method to set customer phoneNumber
	 * @param customer phoneNumber in String type
	 */
	public void setPhoneNumber(String phoneNumber, Scanner scan)
	{
		while(phoneNumber.length() != 10)
		{
			//try block to try to change phoneNumber to integer
			try
			{
				//if statement to test if phone number does not have 10 digit
				if(phoneNumber.length() != 10)
				{
					//throw new exception handling
					throw new Exception("Invalid phone number format");
				}
			}
			//catch exception if phone number cannot change to integer number
			catch(Exception ex)
			{
				//print out error message if exception is catched
				System.out.println(ex.getMessage());
				System.out.println("Enter a valid 10-digit phone number");
				phoneNumber = scan.nextLine();
	
			}
		}
		//set param phoneNumber to this.phoneNumber
		this.phoneNumber = phoneNumber;

	}
	//method to print out a string of the customer info 
	public String toString() 
	{
		return "Customer: name: " + name + " | Address: " + address + 
				" | phone number: " + phoneNumber + " | Customer Number: " + customerNumber;
	}
}

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
 * Responsibilities of class: extending superclass Card and implement all methods 
 * 
 */
public class DebitCard extends Card 
{
	private String pin;//a debitCard has-a pin
	private String savingAccountNumber;//a debitCard has-a savingAccountNumber
	/**
	 * Purpose: No-Argument Card constructor
	 */
	public DebitCard()
	{
		
	}
	/**
	 * Purpose: DebitCard constructor to pass in three parameter to constuct a DebitCard objects
	 * @param: customerName of String type
	 * @param: DebitCard balance of double type
	 * @param: DebitCard pin number of String type
	 */	
	public DebitCard(String customerName, String checkingAccountNumber, String saving, String pin)
	{
		super(customerName, checkingAccountNumber);
		this.pin = pin;
		this.savingAccountNumber = saving;
	}
	/**
	 * Purpose: CreditCard copy constructor to pass in another CreditCard object and copy to new card.
	 * @param: CreditCard other
	 */
	public DebitCard(DebitCard other)
	{
		//inherit the constructor from superclass Account
		super(other.getCustomerName(), other.getAccountNumber());
		this.pin = other.getPin(); 
	}
	/**
	 * Purpose: getter method to get the savingAccountNumber  
	 * @return savingAccountNumber of String type
	 */
	public String getSavingAccountNumber()
	{
		return savingAccountNumber;
	}
	/**
	 * Purpose: setter method to set savingAccountNumber
	 * @param savingAccountNumber of String type
	 */
	public void setSavingAccountNumber(String savingAccountNumber)
	{
		this.savingAccountNumber = savingAccountNumber;
	}
	/**
	 * Purpose: getter method to get the pin  
	 * @return pin of String type
	 */
	public String getPin()
	{
		return pin;
	}
	/**
	 * Purpose: setter method to set pin
	 * @param pin of String type
	 */
	public void setPin(String pin, Scanner scan)
	{
		while(pin.length() != 4)
		{
			//try to set a valid pin
			try
			{
				if(pin.length() != 4)
				{
					throw new Exception("Invalid pin format");
				}
			}
			//if try block did not work, then catch exception to print out the error message
			catch(Exception ex)
			{
//				System.out.println(ex.getMessage());
				System.out.println("Enter a valid 4-digit pin");
				pin = scan.nextLine();
			}
		}
		//assign the passed in pin to this.pin
		this.pin = pin;
	}
	//method to check pin validation
	public boolean isPinValid(String pin)
	{
		try
		{
			//if pin matches the debitCard pin return true
			if (this.pin.equals(pin)) 
			{
				return true;
			}else
			{
				throw new Exception("Entered wrong pin!");
			}
		}
		catch(Exception ex)
		{

			System.out.println(ex.getMessage());
			return false;
		}
	}
	//method to print out a string of the debitCard info 
	public String toString()
	{
		return "Debitcard info: Name: " + super.getCustomerName() + 
				" | Debit Card number: " + super.getCardNum() + " | Expiration date: " + super.getExpDate()
				+ "|  CVV code: " + super.getCVV() + " | pin: " + pin;
	}

}

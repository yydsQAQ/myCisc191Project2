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
 * Responsibilities of class: inherit from superclass Card and implement its methods
 * 
 */
public class CreditCard extends Card
{	
	private String zipCode;//a CreditCard has-a zipCode

	/**
	 * Purpose: No-Argument Card constructor
	 */
	public CreditCard()
	{
		
	}
	/**
	 * Purpose: CreditCard constructor to pass in three parameter to constuct a CreditCard objects
	 * @param: customerName of String type, balance of double type, zipCode of String type
	 */
	public CreditCard(String customerName, String accountNumber, String zipCode)
	{
		//inherit the constructor from superclass Account
		super(customerName, accountNumber);
		this.zipCode = zipCode; 
	}
	/**
	 * Purpose: CreditCard copy constructor to pass in another CreditCard object and copy to new card.
	 * @param: CreditCard other
	 */
	public CreditCard(CreditCard other)
	{
		//inherit the constructor from superclass Account
		super(other.getCustomerName(), other.getAccountNumber());
		this.zipCode = other.getZipCode(); 
	}
	/**
	 * Purpose: getter method to get the zipCode  
	 * @return zipCode of String type
	 */
	public String getZipCode()
	{
		return zipCode;
	}
	/**
	 * Purpose: setter method to set zipCode
	 * @param zipCode of String type
	 * valid US zip code range: https://www.spotzi.com/en/data-catalog/categories/postal-codes/united-states/#:~:text=What's%20the%20current%20postal%20code,States%20range%20from%2000001%20%E2%80%93%2099950.
	 */
	
	public void setZipCode(String zipCode, Scanner scan) 
	{
		while(zipCode.length() != 5)
		{
			//try to set a zip code that is outside the range of a valid zip code
			try
			{
				//if statement to test invalid zip code range
				if(zipCode.length() != 5)
				{
					//throw new exception if zipcode outside that rage
					throw new Exception("Invalid zip code format");
				}
			}
			//catch Exception if zipCode is not integer
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				System.out.println("Enter a valid 5-digit zip code");
				zipCode = scan.nextLine();
			}
		}
		//assign the passed in zipCode to this.zipCode
		this.zipCode = zipCode;
	}
	//method to validate zipCode
	public boolean isValidZipCode(String zipCode)
	{
		try
		{
			//testing if entered zipCode mathches the zipCode of the CreditCard
			if (this.zipCode.equals(zipCode))
			{
				return true;
			}else
			{
				throw new Exception("Entered wrong zip code!");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}
	//method to print out a string of the creditCard info 
	public String toString()
	{
		return "Creditcard info: Name: " + super.getCustomerName() + 
				" | Credit Card number: " + super.getCardNum() + " | Expiration date: " + super.getExpDate()
				+ "|  CVV code: " + super.getCVV() + " | zip code: " + zipCode;
	}

	

}

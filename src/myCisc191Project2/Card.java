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
import java.time.*;

public class Card
{
	private String customerName;//a card has-a customerName
	private  String cardNum;//a card has-a cardNum
	private  String expDate;//a card has-a expDate
	private  String CVV;//a card has-a CVV
	private  double balance;//a card has-a balance
	private String accountNumber;

	/**
	 * Purpose: No-Argument Card constructor
	 */
	public Card()
	{
	}
	/**
	 * Purpose: Card constructor to pass in two parameter to constuct Card objects
	 * @param: customerName of String type, balance of double type
	 */
	public Card(String customerName, String accountNumber)
	{
		this.customerName = customerName;
		this.cardNum = generateCardNumber(); //a new cardNum is generated through gererateCardNum method whenever a new card is created
		this.expDate = generateExpDate();// an expDate is assigned when a new Card object is created
		this.CVV = generateCVV();// an CCV is generated when a new Card object is created 
		this.accountNumber  = accountNumber;
	}
	/**
	 * Purpose: method to randomly generate 16-digit card numbers
	 * @return cardNum of String type
	 */
	public String generateCardNumber()
	{
		//16-digit cardNum is divided into 4 part each with 4-digits
		int firstFour; //a cardNum has-a firstFour digit
		int secondFour;//a cardNum has-a secondFour digit
		int thirdFour;//a cardNum has-a thirdFour digit
		int fourthFour;//a cardNum has-a fourthFour digit
		
		//create a Random object rand to randomly generate numbers
		Random rand = new Random();
		
		//first digit always start with a 4 for all Visa, MasterCard, CapitalOne, Discover, and other major industry identifier
		// https://www.bankrate.com/finance/credit-cards/what-do-the-numbers-on-your-credit-card-mean/
		firstFour = rand.nextInt(4000, 4999);//assign the random number of 4-digit that start with a 4 to firstFour
		secondFour = rand.nextInt(1000, 9999);//assign random 4-digit number to secondFour
		thirdFour = rand.nextInt(1000, 9999);//assign random 4-digit number to thirdFour
		fourthFour = rand.nextInt(1000, 9999);//assign random 4-digit number to fourthFour
		
		//card numbers are normally four-set of four digits making 16-digit card 
		//convert the four-set of integers to String type and assign it to cardNum
		String cardNum = String.valueOf(firstFour)+String.valueOf(secondFour)+String.valueOf(thirdFour)+String.valueOf(fourthFour); 
		//return the cardNum of 16-digit of String type
		return cardNum;
		
	}
	/**
	 * Purpose: method to randomly generate 3-digit card CVV code
	 * @return cardNum of String type
	 */
	public String generateCVV()
	{
		int firstDigit;//a CVV has-a firstDigit
		int secondDigit;//a CVV has-a secondDigit
		int thirdDigit;//a CVV has-a thirdDigit
		//create a Random object rand to randomly generate numbers
		Random rand = new Random();
		
		firstDigit = rand.nextInt(0, 9);//assign a random digit from 0-9 to firstDigit
		secondDigit = rand.nextInt(0, 9);//repeat with secondDigit
		thirdDigit = rand.nextInt(0, 9);//repeat  with thirdDigit
		
		//random digit from 0-9 for all three digits in CVV code
		//convert the integer value to String type and concatenate the 3 digits
		String CVV = String.valueOf(firstDigit).concat(String.valueOf(secondDigit)).concat(String.valueOf(thirdDigit));
		//return CVV of String type
		return CVV;
	}
	/**
	 * Purpose: method to randomly generate 3-digit card CVV code
	 * @return expDate of String type
	 */
	public String generateExpDate()	
	{
		LocalDate month = LocalDate.now();//declaring month of LocalDate type of current time
		LocalDate year = LocalDate.now();//declaring year of LocalDate type of current time
	
		int monthInt = month.getMonthValue(); // getting the integer value of current month
		int yearInt = year.getYear()%100; //getting the last 2 digits of current year
		
		//convert the integer value to String type and add a forward-slash separate the month/year
		String expDate = String.valueOf(monthInt)+ "/" + String.valueOf(yearInt + 5); 
		//cards normally expire on the same month but five years after date card produced
		//returning expDate in String type
		return expDate;
	}
	/**
	 * Purpose: getter method to return accountNumber
	 * @return accountNumber of String type
	 */
	public String getAccountNumber()
	{
		return accountNumber;
	}
	/**
	 * Purpose: setter method to set accountNumber
	 * @param accountNumber of String type
	 */
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	/**
	 * Purpose: getter method to return cardNum
	 * @return cardNum of String type
	 */
	public String getCardNum()
	{
		return cardNum;
	}
	/**
	 * Purpose: getter method to return customerName
	 * @return customerName of String type
	 */
	public String getCustomerName()
	{
		return customerName;
	}
	/**
	 * Purpose: setter method to set customerName
	 * @param customerName of String type
	 */
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	/**
	 * Purpose: getter method to return expDate
	 * @return expDate of String type
	 */
	public String getExpDate()
	{
		return expDate;
	}
	/**
	 * Purpose: getter method to return CVV
	 * @return CVV of String type
	 */
	public String getCVV()
	{
		return CVV;
	}
	/**
	 * Purpose: setter method to set balance
	 * @param balance of double type
	 */
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	/**
	 * Purpose: getter method to return balance
	 * @return balance of double type
	 */
	public double getBalance()
	{
		return balance;
	}
	
//	//incoming money 
//	public void debited(double amount)
//	{
//		balance += amount;
//	}
//	
//	//outgoing money 
//	public void credited(double amount) throws Exception
//	{
//		//decrease the outgoing amount only when the card has sufficient balance
//		if(amount <= this.balance)
//		{
//			this.balance -= amount;
//		}
//		//if card balance is insufficient throw an exception handling
//		else
//		{
//			throw new Exception("Insufficient Funds");
//		}
//	}
//	


	
	

	
	
	
}

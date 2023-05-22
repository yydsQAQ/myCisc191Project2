package myCisc191Project2;
///**
// * Lead Author(s):
// * @author Shuyi Yu
// * @author Jing Xie
// * <<add additional lead authors here, with a full first and last name>>
// * 
// * Other contributors: 
// * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
// * 
// * References:
// * https://www.codejava.net/testing/junit-test-exception-examples-how-to-assert-an-exception-is-thrown
// * 
// * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
// * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
// * 
// * <<add more references here>>
// *  
// * Version/date: 03/04/2023
// * 
// * Responsibilities of class: test all classes and methods if they are working as expected
// * 
// */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.Scanner;

import org.junit.Test;



public class TestingCases
{
	@Test
	public void testNoArgConstructor()
	{
		Card card = new Card();
		assertEquals(null, card.getCardNum());
		assertEquals(null, card.getCVV());
		assertEquals(null, card.getExpDate());
		assertEquals(0, card.getBalance(), 0.001);
	}
	@Test
	public void testCustomer()
	{
		Customer newCustomer = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", "4509000432");

	    assertEquals("Alex Lee", newCustomer.getName());
	    assertEquals("4400 National Blvd., Santa Monica 90037", newCustomer.getAddress());
	    assertEquals("4509000432", newCustomer.getPhoneNumber());
	    
	}
	@Test
	public void testBank()
	{
		Bank bank = new Bank();
		Customer newCustomer1 = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", "4509000432");
		Customer newCustomer2 = new Customer("Tony Chan", "4412 Sawtel Blvd., Santa Monica 90037", "8589094959");
	    CheckingAccount account = new CheckingAccount(newCustomer1, 7995.0);
	    SavingAccount account2 = new SavingAccount(newCustomer2, 0.0);
	    SavingAccount account3 = new SavingAccount(newCustomer1, 100);
	    RewardsAccount account4 = new RewardsAccount(newCustomer1, 0.0);
		DebitCard debitCard = new DebitCard("Alex Lee", account.getAccountNumber(), account3.getAccountNumber(), "9003");
		CreditCard creditCard = new CreditCard("Tony Chan", account2.generateAccountNumber(), "90034");
		CreditCard newCreditCard = new CreditCard("Alex Lee", account4.getAccountNumber(), "90115");
	    
	    bank.addAccount(account);
	    bank.addAccount(account2);
	    assertEquals(account, bank.getAccount(0));
	    assertEquals(1, bank.findAccount(account2.getAccountNumber()));
	    
	    bank.addCard(debitCard);
	    bank.addCard(creditCard);
	    bank.addCard(newCreditCard);
	    assertEquals(0, bank.findCard(debitCard.getCardNum()));
	    assertEquals(creditCard, bank.getCard(1));
	    
	    bank.removeAccount(account.getAccountNumber());
	    assertEquals(null, bank.getAccount(0));
	    assertTrue(!(newCreditCard.getCardNum().equals(creditCard.getCardNum())));

	}
	
	@Test
	public void testToString()
	{
		Customer newCustomer1 = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", "4509000432");
		Customer newCustomer2 = new Customer("Tony Chan", "4412 Sawtel Blvd., Santa Monica 90037", "8589094959");
		Transaction transaction = new Transaction(newCustomer1, "Credit", 100.0);
	    CheckingAccount account = new CheckingAccount(newCustomer1, 7995.0);
	    SavingAccount account2 = new SavingAccount(newCustomer2, 0.0);
	    RewardsAccount account4 = new RewardsAccount(newCustomer1, 0.0);


		DebitCard debitCard = new DebitCard("David Chan", account.getAccountNumber(), account2.getAccountNumber(), "9003");
		CreditCard creditCard = new CreditCard("Tony Chan", account4.getAccountNumber(), "90034");




		assertEquals("Customer: name: Alex Lee | Address: 4400 National Blvd., Santa Monica 90037 | "
				+ "phone number: 4509000432 | Customer Number: " + newCustomer1.getCustomerNumber(), newCustomer1.toString());
		assertEquals("Transaction: Sender: " + newCustomer1.getCustomerNumber() + " | transaction type: Credit | amount: 100.0 | date: " + 
				transaction.getDate(), transaction.toString());
		assertEquals("Debitcard info: Name: David Chan | Debit Card number: " + debitCard.getCardNum() + " | Expiration date: " + debitCard.getExpDate() + "|  CVV code: " + debitCard.getCVV() + " | pin: 9003", debitCard.toString());
		assertEquals("Creditcard info: Name: Tony Chan | Credit Card number: " + creditCard.getCardNum() + " | Expiration date: " + creditCard.getExpDate() + "|  CVV code: " + creditCard.getCVV() + " | zip code: 90034", creditCard.toString());
		
		
	}
	@Test
	public void testCreateCustomerNumber()
	{
		Customer newCustomer1 = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", "4509000432");
		String customerNumber1 = newCustomer1.getCustomerNumber();
		assertEquals(customerNumber1, newCustomer1.getCustomerNumber());
		//newer created customerNumbers are greater than older customerNumbers
		Customer newCustomer2 = new Customer("Tony Chan", "4412 Sawtel Blvd., Santa Monica 90037", "8589094959");
		assertEquals(1, newCustomer2.getCustomerNumber().compareTo(newCustomer1.getCustomerNumber()));
		//customer numbers are increasing
		assertEquals(-1, Customer.createNewCustomerNumber().compareTo(Customer.createNewCustomerNumber()));
	}
	@Test
	public void testCheckingAccount() throws Exception
	{
		Customer newCustomer = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", "4509000432");
	    CheckingAccount account = new CheckingAccount(newCustomer, 7995.0);
	    SavingAccount account2 = new SavingAccount(newCustomer, 0.0);


	    DebitCard debitCard = new DebitCard("Alex Lee", account.getAccountNumber(), account2.getAccountNumber(), "8888");

	    assertEquals(newCustomer, account.getCustomer());
	    assertEquals("Alex Lee", newCustomer.getName());
	    assertEquals("8888", debitCard.getPin());
	    assertEquals(7995, account.getBalance(), 0.001);
	}
//	//https://www.codejava.net/testing/junit-test-exception-examples-how-to-assert-an-exception-is-thrown
	@Test
	public void exceptionTesting()
	{
		String input = "00\n"; //simulate a user input phone number
		Scanner scan = new Scanner(new StringReader(input));
		Throwable exception = assertThrows(Exception.class, () -> {
				Customer newCustomer = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", null);
			    newCustomer.setPhoneNumber("888999", scan);
		    });
		
		Throwable exception1 = assertThrows(Exception.class, () -> {
			Customer newCustomer = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", "4509000432");
		    CheckingAccount account = new CheckingAccount(newCustomer, 7995.0);
		    SavingAccount account2 = new SavingAccount(newCustomer, 0.0);


		    DebitCard debitCard = new DebitCard("Alex Lee", account.getAccountNumber(), account2.getAccountNumber(), null);			
		    debitCard.setPin("000", scan);
	    });

		assertEquals("No line found", exception.getMessage());
		assertEquals("No line found", exception1.getMessage());

	}
	
	@Test
	public void testSavingAccount()
	{
		Customer newCustomer = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", "4509000432");
		SavingAccount account = new SavingAccount(newCustomer, 0);

	    assertEquals(newCustomer, account.getCustomer());
	    assertEquals("Alex Lee", newCustomer.getName());
	    assertEquals(0, account.getBalance(), 0.001);
	  
	}
	@Test
	public void testRewardsAccount()
	{
		
		Customer newCustomer = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", "4509000432");
		RewardsAccount account = new RewardsAccount(newCustomer, 0);
		CreditCard creditCard = new CreditCard("Alex Lee", account.getAccountNumber(), null);
		
		creditCard.setZipCode("92117", null);
		
	    assertEquals(newCustomer, account.getCustomer());
	    assertEquals("Alex Lee", account.getCustomerName());
	    assertEquals(0, account.getBalance(), 0.001);
	    assertEquals("92117", creditCard.getZipCode());
	    
	    account.addBonus(50);
	    account.addBonus(50);
	    assertEquals(100, account.getBonus(), 0.001);
	

	}
	
	@Test
	public void testDebitCard()
	{
		Customer newCustomer = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", "4509000432");
		CheckingAccount account = new CheckingAccount(newCustomer, 100);
		SavingAccount account1 = new SavingAccount(newCustomer, 0);

		DebitCard debitCard = new DebitCard("Alex Lee", account.getAccountNumber(), account1.getAccountNumber(), "0022");
	    assertEquals("Alex Lee", debitCard.getCustomerName());
	    assertEquals(0, debitCard.getBalance(), 0.001);
	    assertEquals("0022", debitCard.getPin());
	}
	
	@Test
	public void testCreditCard()
	{
		Customer newCustomer = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", "4509000432");
		RewardsAccount account = new RewardsAccount(newCustomer, 0.0);
		CreditCard creditCard = new CreditCard("Alex Lee", account.getAccountNumber(), "90022");
	    assertEquals("Alex Lee", creditCard.getCustomerName());
	    assertEquals(0.0, creditCard.getBalance(), 0.001);
	    assertEquals("90022", creditCard.getZipCode());
	}
	
	
	@Test
	public void testTransaction()
	{
		Customer newCustomer = new Customer("Alex Lee", "4400 National Blvd., Santa Monica 90037", "4509000432");
		Transaction transaction = new Transaction(newCustomer, "Credit", 100);

	    assertEquals(newCustomer, transaction.getCustomer());
	    assertEquals("Credit", transaction.getTransactionType());
	    assertEquals(100, transaction.getAmount(), 0.001);
	    assertEquals("Alex Lee", transaction.getCustomerName());
	}
	
	
	

}

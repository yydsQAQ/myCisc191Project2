package myCisc191Project2;

/**
 * Lead Author(s):
 * 
 * @author Shuyi Yu
 * @author Jing Xie
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 *         Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 *         Version/date: 03/04/2023
 * 
 *         Responsibilities of class: Bank class that creates and stores the
 *         accounts and
 *         cards in their arrayLists, and implement the method to input/output a
 *         file, looking for
 *         an account, and replacing an old card.
 * 
 */
import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bank
{
	private Account[] accounts; // a bank has-many accounts
	private Card[] cards; // a bank has-many cards
	private int accountCounter = 0;
	private int cardCounter = 0;
	private SearchAccount searchAccount;

	// Bank constructor
	public Bank()
	{
		// arrayLists to hold the accounts and cards inside the bank class
		accounts = new Account[100];
		cards = new Card[100];
		searchAccount = new SearchAccount();
	}

	public void inPut(String address, Scanner scan) throws IOException
	{
		// String variable that says nothing
		String line = "";
		// try block to try to do the code inside the try block, if a problem
		// occurs go to the catch block to print out error that happen
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader(address));
			/**
			 * csv file source: https://www.briandunning.com/sample-data/
			 * Purpose: create a BufferedReader object to scan the File object
			 * called reader to open the file from the computer
			 * 
			 * @param pass in a new reader object FileReader to the constructor
			 *             of BufferedReader with the directory address of the
			 *             file to read the file
			 */

			// while loop to enter and read one line and store it to line if
			// that line is not null then there is content
			while ((line = reader.readLine()) != null)
			{
				// create String array called values
				// store the separated values by a comma into the values array
				String[] values = line.split(",");
				if (values[0].equals("s&c"))
				{
					Customer newCustomer = new Customer(values[1], values[2],
							values[3]);
					double cBalance = Double.parseDouble(values[5]);
					double sBalance = Double.parseDouble(values[6]);
					CheckingAccount checking = new CheckingAccount(newCustomer,
							cBalance);
					SavingAccount saving = new SavingAccount(newCustomer,
							sBalance);

					DebitCard debitCard = new DebitCard(newCustomer.getName(),
							checking.getAccountNumber(),
							saving.getAccountNumber(), values[4]);
					System.out.println("Debit card was successfully created!\n"
							+ "Please record your checking account, saving account, and debit card information below.");
					System.out.println(checking);
					System.out.println(saving);
					System.out.println(debitCard);
					addAccount(checking);
					addAccount(saving);
					addCard(debitCard);
				}
				else if (values[0].equals("r"))
				{
					Customer newCustomer = new Customer(values[1], values[2],
							values[3]);
					double balance = Double.parseDouble(values[5]);
					double bonus = Double.parseDouble(values[6]);
					RewardsAccount account = new RewardsAccount(newCustomer,
							balance);

					CreditCard creditCard = new CreditCard(
							newCustomer.getName(), account.getAccountNumber(),
							values[4]);
					System.out.println("Credit card was successfully created!\n"
							+ "Please record your rewards account and credit card information below.");
					account.withdraw(balance, scan);
					account.addBonus(bonus);
					System.out.println(account);
					System.out.println(creditCard);
					addAccount(account);
					addCard(creditCard);
				}
				else
				{
					throw new NoSuchElementException(
							"Unforeseen account type!");
				}
			}
			System.out.println("Input file done!");
		}
		// if exception happens, will print out the trace of the issue
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if (reader != null) reader.close();
		}

	}// end of input

	// getter method to return an arrayList of accounts
	public Account getAccount(int i)
	{
		return accounts[i];
	}

	// method to add any account to the arrayList accounts
	public void addAccount(Account account)
	{
		accounts[accountCounter] = account;
		accountCounter++;
		searchAccount.add(account.getCustomerName(), account);
	}

	// method to remove any account from the arrayList accounts
	public void removeAccount(String accountNumber)
	{
		int i = findAccount(accountNumber);
		accounts[i] = null;
	}

	// method to find an account by looping though the arrayList account for an
	// identical accountNumber
	// @param: the string acountNumber want to look for
	public int findAccount(String accountNumber)
	{
		try
		{
			for (int index = 0; index < accountCounter; index++)
			{
				if (accounts[index].getAccountNumber().equals(accountNumber))
				{
					return index;
				}
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Could not find account!");
		}
		return -1;
	}

	public int findCard(String cardNumber)
	{
		try
		{
			for (int i = 0; i < cardCounter; i++)
			{
				if (cards[i].getCardNum().equals(cardNumber))
				{
					return i;
				}
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Could not find an account!");
		}
		return -1;
	}

	// Retrieving the cards arrayList from the Bank
	public Card getCard(int i)
	{
		return cards[i];
	}

	// Adding a card into the cards arrayList
	public void addCard(Card card)
	{
		cards[cardCounter] = card;
		cardCounter++;
	}

	// method to remove old creditcard and add new creditcard to the Bank's
	// cards array
	public void replaceCreditCard(int i)
	{
		CreditCard oldCard = (CreditCard) cards[i];
		CreditCard newCreditCard = new CreditCard(oldCard); // copy oldCard to newCard
		cards[i] = newCreditCard;
		System.out.println("Old credit card was successfully replaced.");
		System.out.println(
				"Please keep your new credit card information carefully.");
		System.out.println(newCreditCard);

	}

	// method to remove old debitcard and add new debitcard to the Bank's cards
	// array
	public void replaceDebitCard(int i, Scanner scan)
	{
		DebitCard newDebitCard = new DebitCard(); // empty new card
		DebitCard oldCard = (DebitCard) cards[i];
		newDebitCard.setCustomerName(oldCard.getCustomerName());
		newDebitCard.setAccountNumber(oldCard.getAccountNumber());
		newDebitCard.setSavingAccountNumber(oldCard.getSavingAccountNumber());
		newDebitCard.setPin(oldCard.getPin(), scan);
		cards[i] = newDebitCard;
		System.out.println("Old debit card was successfully replaced.");
		System.out.println(
				"Please keep your new debit card information carefully.");
		System.out.println(newDebitCard);

	}
	
	/**
	 * TODO find customer's accounts, and print all the information
	 * @param name of String
	 */
	public void findAccountByName(String name)
	{
		ArrayList<Account> temp = searchAccount.search(name);
		if(temp.size() == 0)
		{
			System.out.println("This customer does not have any accounts in our bank.");
		}else
		{
			System.out.println("Below is account information for " + name);
			for(Account each : temp)
			{
				System.out.println(each.toString());
			}
		}
		
	}

}

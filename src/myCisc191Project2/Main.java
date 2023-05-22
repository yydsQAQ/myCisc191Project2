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
 *         Responsibilities of class: main class
 * 
 */
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main
{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		/*
		 * services: open account in bank, deposit cash, withdraw cash,
		 * search for account info,
		 * change account info, renew card, redeem bonus, printing report, repay
		 * credit card balance,
		 * remove account
		 */
		try
		{
			Bank bank = new Bank();
			System.out.println("Do you need to create a bank using a text file?"
					+ " (y = yes | "
					+ "Press any key to enter our exisiting bank)");
			// /Users/shuyiyu/Desktop/input.txt
			String A0 = scan.nextLine();
			if (A0.equalsIgnoreCase("y"))
			{
				// /Users/shuyiyu/Desktop/input.txt
				System.out.println("Please enter the file name");
				bank.inPut(scan.nextLine(), scan);
			}

			do
			{
				System.out.println(
						"Welcome to our Bank, are you a new customer or an existing customer? (New/Existing) n/e \n"
								+ "Press any key to choose whether you want to leave the Bank");
				String A1 = scan.nextLine();
				if (A1.equalsIgnoreCase("n"))
				{
					System.out.println("For new customer, do you wish to open a new account? (yes/no) y/n");
					String A2 = scan.nextLine();
					if (A2.equalsIgnoreCase("n"))
					{
						System.out.println("Thank you for coming in, have a good day!");
					}
					else if (A2.equalsIgnoreCase("y"))
					{
						System.out.println("Choose which type of account you wish to open (Checking and Savings or Rewards) (s&c / r)");
						String A3 = scan.nextLine();
						if (A3.equalsIgnoreCase("s&c"))
						{
							var newCustomer = Utilities.getCustomerInfo(scan);
							CheckingAccount checking = new CheckingAccount(newCustomer, 0);
							SavingAccount saving = new SavingAccount(newCustomer, 0);
							System.out.println("You have successfully created the Checking and Saving Account! " + "Checking account number: "
											+ checking.getAccountNumber() + " Saving account number: " + saving.getAccountNumber());
							DebitCard debitCard = new DebitCard(newCustomer.getName(), checking.getAccountNumber(),saving.getAccountNumber(), null);
							System.out.println("Please enter a four digit pin to create a debit card");
							String A4 = scan.nextLine();
							debitCard.setPin(A4, scan);
							System.out.println("Debit card was successfully created!\n"+ "Please record your debit card information below because you would use it to access to your checking and saving account in the future.");
							System.out.println(debitCard);
							bank.addAccount(checking);
							bank.addAccount(saving);
							bank.addCard(debitCard);
						}
						else if (A3.equalsIgnoreCase("r"))
						{
							var newCustomer = Utilities.getCustomerInfo(scan);

							RewardsAccount account = new RewardsAccount(newCustomer, 0);
							System.out.println("You have successfully created the Rewards Account!" + " Rewards account number: " + account.getAccountNumber());
							CreditCard creditCard = new CreditCard(newCustomer.getName(), account.getAccountNumber(), "12345");
							System.out.println("Please enter a five digit zip code to create a credit card");
							creditCard.setZipCode(scan.nextLine(), scan);
							System.out.println("Credit card was successfully created!\n"
											+ "Please record your credit card information below because you would use it to access to your rewards account in the future.");
							System.out.println(creditCard);
							bank.addAccount(account);
							bank.addCard(creditCard);

						}
						else
						{
							throw new IllegalArgumentException("Please choose a valid option!");
						}
					}
					else
					{
						throw new IllegalArgumentException("Please choose a valid option!");
					}
				}
				if (A1.equalsIgnoreCase("e"))
				{

					System.out
							.println("Choose one of the following services: \n "
									+ "1.Deposit\n " + "2.Withdraw\n "
									+ "3.Account Information\n "
									+ "4.Renew Card\n " + "5.Print Statement\n "
									+ "6.Make Purchase\n " + "7.Redeem Bonus\n "
									+ "8.Make Payment\n " + "9.Delete Account\n"
									+ "10.Wire Transfer\n" + "11.Quit\n"
									+ "12.Search Account Information by Entering Name");
					int option = Integer.parseInt(scan.nextLine());
					try
					{
						switch (option)
						{
							case 1:
								System.out.println("Would you like to deposit to Checking account or Savings account? (s/c)");
								String A5 = scan.nextLine();
								if (A5.equalsIgnoreCase("c"))
								{
									CheckingAccount checking = Utilities.getChecking(bank, scan);
									System.out.println("Please enter the deposit amount");
									int amount = Integer.parseInt(scan.nextLine());
									checking.deposit(amount, scan);
								}
								else if (A5.equalsIgnoreCase("s"))
								{
									SavingAccount saving = Utilities.getSaving(bank, scan);
									System.out.println("Please enter the deposit amount");
									int amount = Integer.parseInt(scan.nextLine());
									saving.deposit(amount, scan);
								}
								else
								{
									throw new IllegalArgumentException("Please choose a valid option!");
								}
								break;
							case 2:
								System.out.println("Would you like to withdraw Checking account or Savings account? (s/c)");
								String A6 = scan.nextLine();
								if (A6.equalsIgnoreCase("c"))
								{
									CheckingAccount checking = Utilities.getChecking(bank, scan);
									System.out.println("Please enter the withdraw amount");
									int amount = Integer.parseInt(scan.nextLine());
									checking.withdraw(amount, scan);
								}
								else if (A6.equalsIgnoreCase("s"))
								{
									SavingAccount saving = Utilities.getSaving(bank, scan);
									System.out.println("Please enter the withdraw amount");
									int amount = Integer.parseInt(scan.nextLine());
									saving.withdraw(amount, scan);
								}
								else
								{
									throw new IllegalArgumentException("Please choose a valid option!");
								}
								break;
							case 3:
								System.out.println("Would you like to get Checking account, Savings account, or Rewards account information? Enter(s/c/r)");
								String A7 = scan.nextLine();
								if (A7.equalsIgnoreCase("c"))
								{
									CheckingAccount checking = Utilities.getChecking(bank, scan);
									System.out.println(checking);
								}
								else if (A7.equalsIgnoreCase("s"))
								{
									SavingAccount saving = Utilities.getSaving(bank, scan);
									System.out.println(saving);
								}
								else if (A7.equalsIgnoreCase("r"))
								{
									RewardsAccount rewards = Utilities.getRewards(bank, scan);
									System.out.println(rewards);
								}
								else
								{
									throw new IllegalArgumentException("Please choose a valid option!");
								}
								break;
							case 4:
								// renew card
								System.out.println("Would you like to renew the credit card or debit card? (c/d)");
								String A8 = scan.nextLine();
								if (A8.equalsIgnoreCase("c"))
								{
									System.out.println("Please provide your credit card number");
									int position = bank.findCard(scan.nextLine());
									CreditCard credit = (CreditCard) bank.getCard(position);
									System.out.println("Please enter your zip code");
									if (credit.isValidZipCode(scan.nextLine()))
									{
										bank.replaceCreditCard(position);
									}
									else
									{
										throw new InputMismatchException("Please try again");
									}
								}
								else if (A8.equalsIgnoreCase("d"))
								{
									System.out.println("Please provide your debit card number");
									int position = bank.findCard(scan.nextLine());
									DebitCard debit = (DebitCard) bank.getCard(position);
									System.out.println("Please enter your pin");
									if (debit.isPinValid(scan.nextLine()))
									{
										bank.replaceDebitCard(position, scan);
									}
									else
									{
										throw new InputMismatchException("Please try again");
									}
								}
								else
								{
									throw new IllegalArgumentException("Please choose a valid option!");
								}
								break;
							case 5:
								System.out.println("Which account would you like to print statement? (s/c/r)");
								String A10 = scan.nextLine();
								System.out.println("Please name the output file.");
								String path = scan.nextLine();
								BufferedWriter writer = new BufferedWriter(new FileWriter(path));
								if (A10.equalsIgnoreCase("s"))
								{
									SavingAccount saving = Utilities.getSaving(bank, scan);
									writer.write(LocalDate.now()
											+ "\nACCOUNT STATEMENT for "
											+ LocalDate.now().getMonth());
									writer.write(" TRANSACTIONS: \n");
									for (Transaction transaction : saving.getTransactions())
									{
										if (transaction != null)
										{
											writer.write("Date: "
													+ transaction.getDate()
													+ transaction.getTime()
													+ "\n");
											writer.write("Transaction Type: "
													+ transaction.getTransactionType()
													+ "\n");
											writer.write("Customer number: "
													+ transaction.getCustomerNumber()
													+ "\n");
											writer.write("Amount: "
													+ transaction.getAmount()
													+ "\n");
											writer.write("Customer name: "
													+ transaction.getCustomerName()
													+ "\n");
											writer.write("\n");
										}
									}
									writer.write("Your current balance: "
											+ saving.getBalance() + "\n");

								}
								else if (A10.equalsIgnoreCase("c"))
								{
									CheckingAccount checking = Utilities.getChecking(bank, scan);
									writer.write(LocalDate.now()
											+ "\nACCOUNT STATEMENT for "
											+ LocalDate.now().getMonth()
											+ "\n");
									writer.write(" TRANSACTIONS: \n");
									for (Transaction transaction : checking.getTransactions())
									{
										if (transaction != null)
										{
											writer.write("Date: "
													+ transaction.getDate()
													+ transaction.getTime()
													+ "\n");
											writer.write("Transaction Type: "
													+ transaction.getTransactionType()
													+ "\n");
											writer.write("Customer number: "
													+ transaction.getCustomerNumber()
													+ "\n");
											writer.write("Amount: "
													+ transaction.getAmount()
													+ "\n");
											writer.write("Customer name: "
													+ transaction.getCustomerName()
													+ "\n");
											writer.write("\n");
										}
									}
									writer.write("Your current balance: "
											+ checking.getBalance() + "\n");

								}
								else if (A10.equalsIgnoreCase("r"))
								{
									RewardsAccount rewards = Utilities.getRewards(bank, scan);
									writer.write("Current Date: "
											+ LocalDate.now()
											+ "\nACCOUNT STATEMENT for "
											+ LocalDate.now().getMonth());
									writer.write(" TRANSACTIONS: \n");
									for (Transaction transaction : rewards.getTransactions())
									{
										if (transaction != null)
										{
											writer.write("Date: "
													+ transaction.getDate()
													+ " "
													+ transaction.getTime()
													+ "\n");
											writer.write("Transaction Type: "
													+ transaction
															.getTransactionType()
													+ "\n");
											writer.write("Customer number: "
													+ transaction
															.getCustomerNumber()
													+ "\n");
											writer.write("Amount: "
													+ transaction.getAmount()
													+ "\n");
											writer.write("Customer name: "
													+ transaction
															.getCustomerName()
													+ "\n");
											writer.write("\n");
										}
									}
									writer.write("Your current bonus is: "
											+ rewards.getBonus() + "\n");
									writer.write("Your current balance: "
											+ rewards.getBalance() + "\n");

								}
								else
								{
									throw new IllegalArgumentException("Please choose a valid option!");
								}
								System.out.println("Statement has been exported to " + path);
								writer.close();
								break;
							case 6:
								RewardsAccount account = Utilities.getRewards(bank, scan);
								System.out.println("Please enter the purchase amount");
								double amount = Double.parseDouble(scan.nextLine());
								account.deposit(amount, scan);
								break;
							case 7:
								RewardsAccount rewards = Utilities.getRewards(bank, scan);
								System.out.println("Please enter the amount of bonus you want to redeem");
								double bonus = Double.parseDouble(scan.nextLine());
								rewards.redeemBonus(bonus);
								System.out.println("Redeemed successfully! Your current bonus is "+ rewards.getBonus());
								break;
							case 8:
								RewardsAccount acc = Utilities.getRewards(bank, scan);
								System.out.println("Please enter the payment amount");
								double payment = Double.parseDouble(scan.nextLine());
								acc.withdraw(payment, scan);
								break;
							case 9:
								System.out.println("Please enter the account number that you want to delete");
								bank.removeAccount(scan.nextLine());
								System.out.println("Account was successfully deleted.");
								break;
							case 10:
								// wire transfer
								Utilities.print("Please enter the recipient account number");
								int position = bank.findAccount(scan.nextLine());
								Account recipient = bank.getAccount(position);
								System.out.println("Would you like to withdraw Checking account or Savings account? (s/c)");
								String A9 = scan.nextLine();
								if (A9.equalsIgnoreCase("c"))
								{
									CheckingAccount checking = Utilities.getChecking(bank, scan);
									System.out.println("Please enter the transfer amount");
									int amount1 = Integer.parseInt(scan.nextLine());
									checking.withdraw(amount1, scan);
									recipient.deposit(amount1, scan);
								}
								else if (A9.equalsIgnoreCase("s"))
								{
									SavingAccount saving = Utilities.getSaving(bank, scan);
									System.out.println("Please enter the transfer amount");
									int amount1 = Integer.parseInt(scan.nextLine());
									saving.withdraw(amount1, scan);
									recipient.deposit(amount1, scan);
								}
								else
								{
									throw new IllegalArgumentException("Please choose a valid option!");
								}
								break;
							case 11:
								break;
							case 12:
								System.out.println("Please enter your name to get all accounts information");
								String name = scan.nextLine();
								bank.findAccountByName(name);
								break;
							default:
								throw new InputMismatchException("Option " + option + " not found");
						}
					}
					catch (InputMismatchException e)
					{
						System.out.println("Please enter a valid option!");
					}
				}
				System.out.println("Would you like to leave the bank? (nl = not leave) | "
								+ "Press any key to leave the bank");
				
			} while (scan.nextLine().equalsIgnoreCase("nl"));// end of do-while

			System.out.println("Would you like to fill out a satisfactory survey? (yes=y or press any key to exit)");
			String A11 = scan.nextLine();

			if(A11.equalsIgnoreCase("y"))
			{
				SurveyWindow window = new SurveyWindow();
				
			}
			else
			{
				System.out.println("Thank you for coming in, goodbye!");
			}
			

		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}

	}// end of main

}// end of Main
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
 * Responsibilities of class: interface to provide abstract methods 
 * 
 */
public interface IAccount
{

	public void deposit(double amount, Scanner scan); //abstract method to deposit
	public void withdraw(double amount, Scanner scan); //abstract method to withdraw
}

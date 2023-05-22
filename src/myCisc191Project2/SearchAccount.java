package myCisc191Project2;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Lead Author(s):
 * 
 * @author Jing Xie
 * @author Shuyi Yu
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
 *         Version/date:5/15
 * 
 *         Responsibilities of class: SearchAccount stores keywords(customer
 *         name) with their
 *         accounts
 * 
 */
public class SearchAccount
{
	private HashMap<String, ArrayList<Account>> engine;// SeachAccount has-a
	// engine of HashMap

	/**
	 * TODO no-arg SearchAccount constructor
	 */
	public SearchAccount()
	{
		engine = new HashMap<String, ArrayList<Account>>();
	}

	/**
	 * TODO add name and link to the hash map
	 * 
	 * @param name of String
	 * @param link of String
	 */
	public void add(String name, Account account)
	{
		// find the value by using key name
		ArrayList<Account> accounts = search(name);
		// add the account to the ArrayList of accounts
		accounts.add(account);
		// put the name and new ArrayList to the hash map
		engine.put(name, accounts);

	}

	/**
	 * search the matched Accounts, copy it to another Arraylist and return
	 * 
	 * @param name of String
	 * @return ArrayList of accounts
	 */
	public ArrayList<Account> search(String name)
	{
		// find the value by using key name, if no value found, create a new
		// ArrayList
		ArrayList<Account> temp = engine.getOrDefault(name,
				new ArrayList<Account>());
		// create another empty array list
		ArrayList<Account> value = new ArrayList<>();
		// copy the temp to value
		for (Account each : temp)
		{
			value.add(each);
		}
		return value;
	}

}

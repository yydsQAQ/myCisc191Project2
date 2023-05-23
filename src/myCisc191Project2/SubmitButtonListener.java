package myCisc191Project2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
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
 *         https://www.youtube.com/watch?v=Os1lAvj8LBc
 *         https://www.youtube.com/watch?v=VlmyTOvvuJc
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 *         Version/date: 05/04/2023
 * 
 *         Responsibilities of class: create action listener class to implement the actionPerformed method of what to display after a submit button is clicked
 * 
 */
	/*
	 * purpose: action listener class for submit survey button
	 */
	public class SubmitButtonListener implements ActionListener //inner class
	{
		private JRadioButton[][] radioButton;//a SurveyWindow has-a radioButton that is a JLable multidimensional array
		
		/*
		 * SubmitButtonListener constructor 
		 * @param two-dimensional array of JRadioButton radioButton
		 */
		public SubmitButtonListener(JRadioButton[][] radioButton)
		{
			this.radioButton = radioButton;
		}
		/*
		 * purpose: method executes when submit button is clicked 
		 * @param: e the event object
		 */
		@Override
		public void actionPerformed(ActionEvent e)
		{
			int sum = 0;//initialize sum to 0
			int divisor = 0;//initialize divisor to 0
			//for loop too go sum up all the selected radioButtons
			for(int i = 0; i < radioButton.length; i++)
			{
				for(int j = 0; j < radioButton[i].length; j++)
				{
					if(radioButton[i][j].isSelected())
					{
						sum += Integer.parseInt(radioButton[i][j].getText());
						//increment divisor once a radioButton is selected
						divisor++;
					}
				}
			}
			//calculating average operation
			double average = (double) sum / divisor;
			//display on console after a result is calculated with a string formatter of 2 decimal points
			System.out.println("Your feedback average: " + String.format("%.2f", average));
			System.out.println("Thank you for your feedback. We appreciate your business and look forward to serving you in the future. ");
			//exit out
			System.exit(0);
		}		
	}//end of SubmitButtonListener
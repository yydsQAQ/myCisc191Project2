package myCisc191Project2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

/*
	 * purpose: action listener class for submit survey button
	 */
	public class SubmitButtonListener implements ActionListener //inner class
	{
		private JRadioButton[][] radioButton;
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
			int sum = 0;
			int divisor = 0;
			for(int i = 0; i < radioButton.length; i++)
			{
				for(int j = 0; j < radioButton[i].length; j++)
				{
					if(radioButton[i][j].isSelected())
					{
						sum += Integer.parseInt(radioButton[i][j].getText());
						divisor++;
					}
				}
			}
			double average = (double) sum / divisor;
			System.out.println("Your feedback average: " + String.format("%.2f", average));
			System.out.println("Thank you for your feedback. We appreciate your business and look forward to serving you in the future. ");
			System.exit(0);
		}		
	}//end of SubmitButtonListener
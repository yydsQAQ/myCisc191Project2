package myCisc191Project2;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
 *         Responsibilities of class: GUI class extends from JFrame
 * 
 */

//outer class
public class SurveyWindow extends JFrame // SurveyWindow is-a JFrame
{
	private final int WINDOW_WIDTH = 900; //window width in pixels
	private final int WINDOW_HEIGHT = 600; //window height in pixels
	private JPanel messagePanel;//a SurveyWindow has-a panel to add in the messages
	/*
	 * purpose: SurveyWindow constructor to set the basics of the window and add panel to content pane
	 */
	public SurveyWindow()
	{
		setTitle("Our Bank's Survey");//set window title
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);//set window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//specify end of program when close button is clicked
		messagePanel = new JPanel();//a SurveyWindow has-a panel to add in the messages
		add(messagePanel);//add panel to content pane
		buildPanel();//build panel and add it to the frame
		setLocationRelativeTo(null);//centered setting
		setVisible(true);//display the window
	}
	/*
	 * purpose: build the components and add them to the panels
	 */
	private void buildPanel()
	{
		String[] questions = {"1. How satisfied are you with the overall customer service you received?",
				"2. How satisfied are you with the friendliness of our staff?", 
				"3. How satisfied are you with the knowledge of our customer service representatives?",
				"4. How satisfied are you with the availability of our services?",
				"5. How satisfied are you with the accuracy of our financial statements and transactions?",
				"6. How satisfied are you with the convenience of our banking services?",
				"7. How satisfied are you with the security measures in place to protect your account?",
				"8. How satisfied are you with the ease of use of our online and mobile banking platforms?",
				"9. How likely are you to recommend our bank to others? ",
				"10.How satisfied are you with the quality of service provided?"
		}; //string array that contains the question labels
		
		JLabel messageLabel = new JLabel("Please rate your level of satisfaction with each question on a scale of 1 to 5, where 1 is very unsatisfied and 5 is very satisfied."); //a SurveyWindow has-a messageLabel
		messagePanel.add(messageLabel);//add instruction to messagePane
		JLabel[] messageLabel1 = new JLabel[questions.length]; 	//a SurveyWindow has-a messageLabel1 that is a JLable array
		for(int i = 0; i < questions.length; i++)
		{
			messageLabel1[i] = new JLabel(questions[i]);
		}
		
		JRadioButton[][] radioButton = new JRadioButton[questions.length][5];//a SurveyWindow has-a radioButton that is a JLable multidimensional array
		ButtonGroup[] radioButtonGroup = new ButtonGroup[questions.length];//a SurveyWindow has-a radioButtonGroup that is a JLable array
		for(int i = 0; i < questions.length; i++)
		{
			radioButtonGroup[i] = new ButtonGroup();//create ButtonGroup with 5 radio button in each group
			for(int j = 0; j <5; j++)
			{
				radioButton[i][j] = new JRadioButton(String.valueOf(j + 1)); //5 radio buttons from 1-5 in each group
				radioButtonGroup[i].add(radioButton[i][j]);	//add each set of radioButtons to raduoButtonGroup	
			}
		}
		JButton submitButton = new JButton("Submit");//a SurveyWindow has-a submitButton

		submitButton.setSize(2, 10);//setting size for submitButton
		submitButton.addActionListener(new SubmitButtonListener(radioButton));//add action listener to submit button and passing in a radioButton to the constructor
		
		messagePanel.setLayout(new FlowLayout(1,10, 5));
		for(int i=0; i< questions.length; i++)
		{
			JPanel radioButtonPanel = new JPanel();//a SurveyWindow has-a panel to add in radio buttons
			radioButtonPanel.setLayout(new GridLayout(1, 5, 10, 10)); //for radio buttons
			for(int j=0; j<5; j++)
			{
				radioButtonPanel.add(radioButton[i][j]);//adding radio buttons
			}
			messagePanel.add(messageLabel1[i]);//adding each messageLabels to messagePanel
			messagePanel.add(radioButtonPanel);//adding radioButtonPanel to messagePanel
		}
		messagePanel.add(submitButton);	//adding submit button
		
	}

}//end of SurveyWindow


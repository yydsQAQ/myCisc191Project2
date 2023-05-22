package myCisc191Project2;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 *         Version/date: 03/04/2023
 * 
 *         Responsibilities of class: GUI class extends from JFrame
 * 
 */

//outer class
public class SurveyWindow extends JFrame // SurveyWindow is-a JFrame
{
	private final int WINDOW_WIDTH = 900; //window width in pixels
	private final int WINDOW_HEIGHT = 600; //window height in pixels
	private JPanel panel;//a SurveyWindow has-a panel
	private JPanel panel2;//a SurveyWindow has-a panel2
	private JLabel messageLabel;//a SurveyWindow has-a messageLabel
	private JLabel[] messageLabel1;//a SurveyWindow has-a messageLabel1 that is a JLable array
	private ButtonGroup[] radioButtonGroup;//a SurveyWindow has-a radioButtonGroup that is a JLable array
	private JRadioButton[][] radioButton;//a SurveyWindow has-a radioButton that is a JLable multidimensional array
	private JButton submitButton;//a SurveyWindow has-a submitButton
	private String[] questions = {"1. How satisfied are you with the overall customer service you received?",
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
	
	/*
	 * purpose: SurveyWindow constructor to set the basics of the window and add panel to content pane
	 */
	public SurveyWindow()
	{
		setTitle("Our Bank's Survey");//set window title
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);//set window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//specify end of program when close button is clicked
		panel = new JPanel();
		buildPanel();//build panel and add it to the frame
		add(panel);//add panel to content pane
		setLocationRelativeTo(null);
		setVisible(true);//display the window
	}
	/*
	 * purpose: build the components and add them to the panels
	 */
	private void buildPanel()
	{
		//create 11 new label to display instruction
		messageLabel = new JLabel("Please rate your level of satisfaction with each question on a scale of 1 to 5, where 1 is very unsatisfied and 5 is very satisfied.");
		panel.add(messageLabel);
		messageLabel1 = new JLabel[questions.length];
		for(int i = 0; i < questions.length; i++)
		{
			messageLabel1[i] = new JLabel(questions[i]);
		}
		
		radioButton = new JRadioButton[questions.length][5];
		radioButtonGroup = new ButtonGroup[questions.length];
		for(int i = 0; i < questions.length; i++)
		{
			radioButtonGroup[i] = new ButtonGroup();
			for(int j = 0; j <5; j++)
			{
				radioButton[i][j] = new JRadioButton(String.valueOf(j + 1));
				radioButtonGroup[i].add(radioButton[i][j]);		
			}
		}
		submitButton = new JButton("Submit");//create new submit button
		submitButton.setSize(2, 10);
		submitButton.addActionListener(new SubmitButtonListener(radioButton));//add action listener to submit button
		
		panel.setLayout(new FlowLayout(1,10, 5));
		for(int i=0; i< questions.length; i++)
		{
			panel2 = new JPanel();
			panel2.setLayout(new GridLayout(1, 10, 10, 10)); //for radio buttons
			for(int j=0; j<5; j++)
			{
				panel2.add(radioButton[i][j]);
			}
			panel.add(messageLabel1[i]);
			panel.add(panel2);
		}
		panel.add(submitButton);	
		
	}
	
}//end of SurveyWindow


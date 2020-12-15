import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class EmployeeHome2 extends JFrame implements ActionListener
{
	JLabel welcomeLabel;
	JButton manageEmployeeBtn, changePasswordBtn, viewDetailsBtn, logoutBtn,manageEmployeeBtn2,manageEmployeeBtn3;
	JPanel panel;
	String userId,role;
	private ImageIcon img;
	private JLabel imgLabel;
	
	public EmployeeHome2(String userId)
	{
		super("Employee Home Window");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("Welcome, "+userId);
		welcomeLabel.setBounds(350, 50, 130, 50);
		panel.add(welcomeLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(320, 370, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(320, 120, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		manageEmployeeBtn = new JButton("Manage Customer");
		manageEmployeeBtn.setBounds(320, 220, 150, 30);
		manageEmployeeBtn.addActionListener(this);
		panel.add(manageEmployeeBtn);
		
		manageEmployeeBtn2 = new JButton("Manage Book");
		manageEmployeeBtn2.setBounds(320, 270, 150, 30);
		manageEmployeeBtn2.addActionListener(this);
		panel.add(manageEmployeeBtn2);
		
		manageEmployeeBtn3 = new JButton("Manage Borrow");
		manageEmployeeBtn3.setBounds(320, 320, 150, 30);
		manageEmployeeBtn3.addActionListener(this);
		panel.add(manageEmployeeBtn3);
		
		viewDetailsBtn = new JButton("My Information");
		viewDetailsBtn.setBounds(320, 170, 150, 30);
		viewDetailsBtn.addActionListener(this);
		panel.add(viewDetailsBtn);
		
		this.add(panel);
	}

	////////////////////////////////////////////
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		
		else if(text.equals(changePasswordBtn.getText()))
		{
			ChangePassword3 cp = new ChangePassword3(userId);
			cp.setVisible(true);
			this.setVisible(false);
		}
		
		else if(text.equals(manageEmployeeBtn.getText()))
		{
			
			    ManageEmployee2 me = new ManageEmployee2(userId);
				me.setVisible(true);
				this.setVisible(false);
			
		}
		
		else if(text.equals(manageEmployeeBtn2.getText()))
		{
			
			    ManageEmployee3 me = new ManageEmployee3(userId);
				me.setVisible(true);
				this.setVisible(false);
			
		}
		
		else if(text.equals(manageEmployeeBtn3.getText()))
		{
			
			    ManageEmployee4 me = new ManageEmployee4(userId);
				me.setVisible(true);
				this.setVisible(false);
		}
					
		else if(text.equals(viewDetailsBtn.getText()))
		{
			
				MyInfo2 me = new MyInfo2(userId);
				me.setVisible(true);
				this.setVisible(false);
			
		}
		
		else{}
	}
	
}
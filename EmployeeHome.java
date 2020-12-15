import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class EmployeeHome extends JFrame implements ActionListener
{
	JLabel welcomeLabel;
	JButton manageEmployeeBtn, changePasswordBtn, viewDetailsBtn, logoutBtn,bookBtn,manageCustomerBtn,borrowBtn;
	JPanel panel;
	String userId,role;
	
	private JLabel imgLabel;
	
	public EmployeeHome(String userId)
	{
		super("Employee Home Window");
		
		this.userId = userId;
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("Welcome, "+userId);
		welcomeLabel.setBounds(350, 50, 130, 50);
		panel.add(welcomeLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(320, 400, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(320, 100, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		manageEmployeeBtn = new JButton("Manage Employeee");
		manageEmployeeBtn.setBounds(320, 200, 150, 30);
		manageEmployeeBtn.addActionListener(this);
		panel.add(manageEmployeeBtn);
		
		manageCustomerBtn = new JButton("Manage Customer");
		manageCustomerBtn.setBounds(320, 250, 150, 30);
		manageCustomerBtn.addActionListener(this);
		panel.add(manageCustomerBtn);
		
		bookBtn = new JButton("Manage Book");
		bookBtn.setBounds(320, 300, 150, 30);
		bookBtn.addActionListener(this);
		panel.add(bookBtn);
		
		borrowBtn = new JButton("Manage Borrow");
		borrowBtn.setBounds(320, 350, 150, 30);
		borrowBtn.addActionListener(this);
		panel.add(borrowBtn);
		
		viewDetailsBtn = new JButton("My Information");
		viewDetailsBtn.setBounds(320, 150, 150, 30);
		viewDetailsBtn.addActionListener(this);
		panel.add(viewDetailsBtn);
		
		this.add(panel);
	}
	

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
			ChangePassword2 cp = new ChangePassword2(userId);
			cp.setVisible(true);
			this.setVisible(false);
		}
		
		else if(text.equals(manageEmployeeBtn.getText()))
		{
			    ManageEmployee me = new ManageEmployee(userId);
				me.setVisible(true);
				this.setVisible(false);
		}
			
		else if(text.equals(manageCustomerBtn.getText()))
		{
			    ManageEmployee5 me = new ManageEmployee5(userId);
				me.setVisible(true);
				this.setVisible(false);
		}
		
		else if(text.equals(bookBtn.getText()))
		{
			    ManageEmployee6 me = new ManageEmployee6(userId);
				me.setVisible(true);
				this.setVisible(false);
		}
		
		else if(text.equals(borrowBtn.getText()))
		{
			    ManageEmployee7 me = new ManageEmployee7(userId);
				me.setVisible(true);
				this.setVisible(false);
		}
			
		else if(text.equals(viewDetailsBtn.getText()))
		{
			
				MyInfo me = new MyInfo(userId);
				me.setVisible(true);
				this.setVisible(false);
			
		}
		
		else{}
	}
	
}
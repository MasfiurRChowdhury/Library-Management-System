import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class CustomerHome extends JFrame implements ActionListener
{
	JLabel welcomeLabel;
	JButton borrowBtn,changePasswordBtn,viewDetailsBtn,logoutBtn,borrowbook,bookBtn;
	JPanel panel;
	String userId;
	
	public CustomerHome(String userId)
	{
		super("Customer Home Window");
		
		this.userId = userId;
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("Welcome, "+userId);
		welcomeLabel.setBounds(340, 50, 180, 80);
		panel.add(welcomeLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(320,270, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(320, 120, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		viewDetailsBtn = new JButton("My Information");
		viewDetailsBtn.setBounds(320, 170, 150, 30);
		viewDetailsBtn.addActionListener(this);
		panel.add(viewDetailsBtn);
		
		bookBtn = new JButton("Search Book");
		bookBtn.setBounds(320, 220, 150, 30);
		bookBtn.addActionListener(this);
		panel.add(bookBtn);
		
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
			ChangePassword cp = new ChangePassword(userId);
			cp.setVisible(true);
			this.setVisible(false);
		}
		
		else if(text.equals(viewDetailsBtn.getText()))
		{
			    ViewCustomer vc = new ViewCustomer(userId);
				vc.setVisible(true);
				this.setVisible(false);
			
		}
		
		else if(text.equals(bookBtn.getText()))
		{
			SearchBook2 ve = new SearchBook2(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		
		
		else{}
	}
	
}
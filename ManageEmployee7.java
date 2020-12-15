import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ManageEmployee7 extends JFrame implements ActionListener
{
	JButton BanBtn, BookUpdateBtn, backBtn, logoutBtn,viewCustomerBtn,viewallCustomerBtn,bookEntryBtn,bookBtn,borrowBtn,borrowBtn2,bListbtn;
	JPanel panel;
	String userId;
	private ImageIcon img;
	private JLabel imgLabel;
	
	public ManageEmployee7(String userId)
	{
		super("Manage Borrow Window");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(320, 270, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		borrowBtn = new JButton("Borrow Return");
		borrowBtn.setBounds(320, 170, 150, 30);
		borrowBtn.addActionListener(this);
		panel.add(borrowBtn);
		
		borrowBtn2 = new JButton("Borrow");
		borrowBtn2.setBounds(320, 120, 150, 30);
		borrowBtn2.addActionListener(this);
		panel.add(borrowBtn2);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(320, 220, 150, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(userId);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		
		else if(text.equals(borrowBtn.getText()))
		{
			borrowUpdate2 ve = new borrowUpdate2(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(borrowBtn2.getText()))
		{
			borrowBook2 ve = new borrowBook2(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		
		else{}
	}
}
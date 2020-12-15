import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ManageEmployee3 extends JFrame implements ActionListener
{
	JButton BanBtn, BookUpdateBtn, backBtn, logoutBtn,viewCustomerBtn,viewallCustomerBtn,bookEntryBtn,bookBtn,borrowBtn,borrowBtn2;
	JPanel panel;
	String userId;
	private ImageIcon img;
	private JLabel imgLabel;
	
	public ManageEmployee3(String userId)
	{
		super("Manage Book Window");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(320, 320, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		BookUpdateBtn = new JButton("Book Update");
		BookUpdateBtn.setBounds(320, 170, 150, 30);
		BookUpdateBtn.addActionListener(this);
		panel.add(BookUpdateBtn);
		
		bookEntryBtn = new JButton("Book Entry");
		bookEntryBtn.setBounds(320, 120, 150, 30);
		bookEntryBtn.addActionListener(this);
		panel.add(bookEntryBtn);
		
		bookBtn = new JButton("Search Book");
		bookBtn.setBounds(320, 220, 150, 30);
		bookBtn.addActionListener(this);
		panel.add(bookBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(320, 270, 150, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			EmployeeHome2 eh = new EmployeeHome2(userId);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		
		else if(text.equals(BookUpdateBtn.getText()))
		{
			BookUpdate bu = new BookUpdate(userId);
			bu.setVisible(true);
			this.setVisible(false);
		}
		
		else if(text.equals(bookEntryBtn.getText()))
		{
			bookEntry ve = new bookEntry(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(bookBtn.getText()))
		{
			SearchBook ve = new SearchBook(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		
		else{}
	}
}
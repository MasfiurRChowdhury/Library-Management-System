import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ManageEmployee2 extends JFrame implements ActionListener
{
	JButton BanBtn, BookUpdateBtn, backBtn, logoutBtn,viewCustomerBtn,viewallCustomerBtn,bookEntryBtn,bookBtn,borrowBtn,borrowBtn2;
	JPanel panel;
	String userId;
	private ImageIcon img;
	private JLabel imgLabel;
	
	public ManageEmployee2(String userId)
	{
		super("Manage Customer Window Manager");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(320, 220, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		viewCustomerBtn = new JButton("View Customer");
		viewCustomerBtn.setBounds(320, 120, 150, 30);
		viewCustomerBtn.addActionListener(this);
		panel.add(viewCustomerBtn);
		 
		backBtn = new JButton("Back");
		backBtn.setBounds(320, 170, 150, 30);
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
	
		else if(text.equals(viewCustomerBtn.getText()))
		{
			ViewCustomer3 ve = new ViewCustomer3(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		
	
		else{}
	}
}
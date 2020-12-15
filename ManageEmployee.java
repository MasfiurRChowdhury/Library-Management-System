import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ManageEmployee extends JFrame implements ActionListener
{
	JButton addEmployeeBtn, viewEmployeeBtn, backBtn, logoutBtn,viewCustomerBtn,viewallCustomerBtn,viewallEmployeeBtn;
	JPanel panel;
	String userId;
	private ImageIcon img;
	private JLabel imgLabel;
	
	public ManageEmployee(String userId)
	{
		super("Manage Employee Window");
		
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
		
		addEmployeeBtn = new JButton("Add Employee");
		addEmployeeBtn.setBounds(320, 120, 150, 30);
		addEmployeeBtn.addActionListener(this);
		panel.add(addEmployeeBtn);
		
		viewEmployeeBtn = new JButton("View Employee");
		viewEmployeeBtn.setBounds(320, 170, 150, 30);
		viewEmployeeBtn.addActionListener(this);
		panel.add(viewEmployeeBtn);
		
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
		else if(text.equals(addEmployeeBtn.getText()))
		{
			AddEmployee a = new AddEmployee(userId);
			a.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(viewEmployeeBtn.getText()))
		{
			ViewEmployee ve = new ViewEmployee(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		
		else{}
	}
}
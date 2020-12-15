import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class MyInfo2 extends JFrame implements ActionListener
{
	JLabel userLabel, eNameLabel, phoneLabel, roleLabel,salaryLabel;
	JTextField userTF, phoneTF1, phoneTF2, eNameTF, roleTF,salaryTF;
	JButton refreshBtn, loadBtn, updateBtn, delBtn, backBtn, logoutBtn;
	JPanel panel;
	private ImageIcon img;
	private JLabel imgLabel;
	
	String userId;
	
	public MyInfo2(String userId)
	{
		super("My Info");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(620,400,120, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(250, 70, 120, 30);
		panel.add(userLabel);
		
		eNameLabel = new JLabel("Customer Name : ");
		eNameLabel.setBounds(250, 120, 120, 30);
		panel.add(eNameLabel);
		
		phoneLabel = new JLabel("Phone No. : ");
		phoneLabel.setBounds(250, 170, 120, 30);
		panel.add(phoneLabel);
		
		roleLabel = new JLabel("Role : ");
		roleLabel.setBounds(250, 220, 120, 30);
		panel.add(roleLabel);
		
		salaryLabel = new JLabel("Salary : ");
		salaryLabel.setBounds(250, 270, 120, 30);
		panel.add(salaryLabel);
		
		userTF = new JTextField(userId);
		userTF.setBounds(400, 70, 120, 30);
		userTF.setEnabled(false);
		panel.add(userTF);
		
		eNameTF = new JTextField();
		eNameTF.setBounds(400, 120, 120, 30);
		panel.add(eNameTF);
	
		phoneTF1 = new JTextField();
		phoneTF1.setBounds(400, 170, 35, 30);
		phoneTF1.setEnabled(false);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField();
		phoneTF2.setBounds(435, 170, 85, 30);
		panel.add(phoneTF2);

		roleTF = new JTextField();
		roleTF.setBounds(400, 220, 120, 30);
		panel.add(roleTF);
	
		salaryTF = new JTextField();
		salaryTF.setBounds(400, 270, 120, 30);
		panel.add(salaryTF);
		
		loadBtn = new JButton("Load");////
		loadBtn.setBounds(600, 70, 120, 30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(20, 400, 120, 30);
		updateBtn.setEnabled(false);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		delBtn = new JButton("Delete");
		delBtn.setBounds(220, 400, 120, 30);
		delBtn.setEnabled(false);
		delBtn.addActionListener(this);
		panel.add(delBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(420, 400, 120, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			EmployeeHome2 me = new EmployeeHome2(userId);
			me.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(loadBtn.getText()))
		{
			loadFromDB();			
		}
		else if(text.equals(updateBtn.getText()))
		{
			updateInDB();
			MyInfo2 l = new MyInfo2(userId);
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(delBtn.getText()))
		{
			
			deleteFromDB();
			Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
			
		}
		
		else{}
	}
	
	public void loadFromDB()
	{
		//String loadId = userId;
		String query = "SELECT `employeeName`, `phoneNumber`, `role`, `salary` FROM `employee` WHERE `userId`='"+userId+"';";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/f2","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			boolean flag = false;
			String eName = null;
			String phnNo = null;
			String role =null;
			double sal = 0.0;
			String salary = Double.toString(sal);
						
			while(rs.next())
			{
                eName = rs.getString("employeeName");
				phnNo = rs.getString("phoneNumber");
				role = rs.getString("role");
				salary = rs.getString("salary");
				flag=true;
				
				eNameTF.setText(eName);
				phoneTF1.setText("+880");
				phoneTF2.setText(phnNo.substring(4,14));
				roleTF.setText(role);
				salaryTF.setText(salary);
				userTF.setEnabled(false);
				updateBtn.setEnabled(true);
				delBtn.setEnabled(true);
			}
			if(!flag)
			{
				eNameTF.setText("");
				phoneTF1.setText("");
				phoneTF2.setText("");
				roleTF.setText("");
				salaryTF.setText("");
				JOptionPane.showMessageDialog(this,"Invalid ID"); 
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
	
	public void updateInDB()
	{
		String newId = userId;
		String eName = eNameTF.getText();
		String phnNo = phoneTF1.getText()+phoneTF2.getText();
		String role = roleTF.getText();
		String salary = salaryTF.getText();
		String query = "UPDATE employee SET employeeName='"+eName+"', phoneNumber = '"+phnNo+"', role = '"+role+"',salary = '"+salary+"' WHERE userId='"+newId+"'";	
        Connection con=null;//for connection
        Statement st = null;//for query execution
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/f2","root","");
			st = con.createStatement();//create statement
			st.executeUpdate(query);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			
			updateBtn.setEnabled(false);
			delBtn.setEnabled(false);
			userTF.setEnabled(true);
			userTF.setText("");
			eNameTF.setText("");
			phoneTF1.setText("");
			phoneTF2.setText("");
			roleTF.setText("");
			salaryTF.setText("");
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
		}
	}
	
	public void deleteFromDB()
	{
		String newId = userId;
		String query1 = "DELETE from employee WHERE userId='"+newId+"';";
		String query2 = "DELETE from login WHERE userId='"+newId+"';";
		System.out.println(query1);
		System.out.println(query2);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/f2", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.execute(query2);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}
	
}
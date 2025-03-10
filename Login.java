import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Login extends JFrame implements ActionListener,MouseListener
{
	JLabel title,signup,userLabel,passLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn,signupBtn,hidebtn;
	JPanel panel;
	private ImageIcon img,Icon;
	private JLabel imgLabel;
	String role;
	
	public Login()
	{
		super("Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Bangladesh Library");
		title.setBounds(340, 40, 130, 30);
		panel.add(title);
		
		
		signup = new JLabel("Click Signup to become a new member !");
		signup.setBounds(280,330,360,80);
		panel.add(signup);
		
		signupBtn = new JButton("SignUp");
		signupBtn.setBounds(350, 310, 100, 25);
		signupBtn.addActionListener(this);
		panel.add(signupBtn);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 200, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		Icon i = new ImageIcon("image.jpg");
		hidebtn = new JButton(i);
		hidebtn.setBounds(480, 155, 25, 20);
		hidebtn.addActionListener(this);
		hidebtn.addMouseListener(this);
		panel.add(hidebtn);
		
		this.add(panel);
	}
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseReleased(MouseEvent me)
	{
		if(me.getSource().equals(hidebtn))
		{
			passPF.setEchoChar('*');
		}
		else{}
	}
	public void mousePressed(MouseEvent me)
	{
		if(me.getSource().equals(hidebtn))
		{
			passPF.setEchoChar((char)0);
		}
		else{}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(loginBtn.getText()))
		{
			checkLogin();
		}
		else if(text.equals(signupBtn.getText()))
		{
			            AddCustomer ch = new AddCustomer();
						ch.setVisible(true);
						this.setVisible(false);
		}
		else if(text.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else{}
	}
	
	
	public void checkrole(String userId)
	{
		String newUser=userId;
		
		String query = "SELECT `role` FROM `employee`WHERE userId='"+newUser+"'"; 
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:1234/oop1","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			boolean flag = false;			
			while(rs.next())
			{
                role = rs.getString("role");
				System.out.println(role);
              
			}
		}
			catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
	}
	
	public void checkLogin()
	{
		String query = "SELECT `userId`, `password`, `status` FROM `login`;"; 
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:1234/oop1","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			checkrole(userTF.getText());
			
			boolean flag = false;			
			while(rs.next())
			{
                String userId = rs.getString("userId");
                String password = rs.getString("password");
				int status = rs.getInt("status");
				
				
				if(userId.equals(userTF.getText()) && password.equals(passPF.getText()))
				{
					flag=true;
					if(status==0 && role.equals("Manager"))
					{
						EmployeeHome eh = new EmployeeHome(userId);
						eh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==0 && role.equals("Emplolyee"))
					{
						EmployeeHome2 eh = new EmployeeHome2(userId);
						eh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==1)
					{
						CustomerHome ch = new CustomerHome(userId);
						ch.setVisible(true);
						this.setVisible(false);
					}
					else if(status==2)
					{
						JOptionPane.showMessageDialog(this, "you are Ban. Please Contact in office");
						Login ch = new Login();
						ch.setVisible(true);
						this.setVisible(false);
					}
					
					
					
					else{}
				}
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
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
	
}
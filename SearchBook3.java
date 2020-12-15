import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class SearchBook3 extends JFrame implements ActionListener
{
	JLabel userLabel, eNameLabel, phoneLabel, addressLabel;
	JTextField userTF, phoneTF1, phoneTF2, eNameTF, addressTF;
	JButton refreshBtn, loadBtn, updateBtn, delBtn, backBtn, logoutBtn;
	JPanel panel;
	private ImageIcon img;
	private JLabel imgLabel;
	
	String userId;
	
	public SearchBook3(String userId)
	{
		super("Search Book Window Manager");
		
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(400,400,120, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		userLabel = new JLabel("Book Name : ");
		userLabel.setBounds(250, 150, 120, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(400, 150, 120, 30);
		panel.add(userTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(400, 100, 120, 30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		eNameLabel = new JLabel("Book ID: ");
		eNameLabel.setBounds(250, 200, 120, 30);
		panel.add(eNameLabel);
		
		eNameTF = new JTextField();
		eNameTF.setBounds(400, 200, 120, 30);
		panel.add(eNameTF);
		
		addressLabel = new JLabel("Quantity : ");
		addressLabel.setBounds(250, 250, 120, 30);
		panel.add(addressLabel);
		
		addressTF = new JTextField();
		addressTF.setBounds(400, 250, 120, 30);
		panel.add(addressTF);
				
		backBtn = new JButton("Back");
		backBtn.setBounds(250, 400, 120, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			ManageEmployee6 me = new ManageEmployee6(userId);
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
	
		else{}
	}
	
	///////////////////////////////////////////////////////////////
	public void loadFromDB()
	{
		String loadId = userTF.getText();
		String query = "SELECT `bookId`, `bookTitle`, `availableQuantity` FROM `book` WHERE `bookTitle`='"+loadId+"';";     
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
			String bName = null;
			String bId = null;
			String aQnt =null;
						
			while(rs.next())
			{
                aQnt = rs.getString("bookTitle");
				bId = rs.getString("bookId");
				bName = rs.getString("availableQuantity");
				flag=true;
				
				eNameTF.setText(bId);
				addressTF.setText(bName);
				userTF.setText(aQnt);
				
				userTF.setEnabled(false);
				
			}
			if(!flag)
			{
				eNameTF.setText("");
				addressTF.setText("");
				userTF.setText("");
				JOptionPane.showMessageDialog(this,"Invalid Book"); 
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
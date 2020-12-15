import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ChangePassword3 extends JFrame implements ActionListener,MouseListener
{
	JLabel oldPassLabel, newPassLabel;
	JPasswordField oldPassTF, newPassTF;
	JButton changeBtn, backBtn, logoutBtn,hidebtn,hidebtn2;
	JPanel panel;
	String userId;
	private ImageIcon img,i,ii;
	private JLabel imgLabel;
	
	public ChangePassword3(String userId)
	{
		super("Change Password Window");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.userId=userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(370, 350, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changeBtn = new JButton("Save");
		changeBtn.setBounds(300, 250, 100, 30);
		changeBtn.addActionListener(this);
		panel.add(changeBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(430, 250, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		oldPassLabel = new JLabel("Old Password : ");
		oldPassLabel.setBounds(250, 100, 120, 30);
		panel.add(oldPassLabel);
		
		newPassLabel = new JLabel("New Password : ");
		newPassLabel.setBounds(250, 150, 120, 30);
		panel.add(newPassLabel);
		
		oldPassTF = new JPasswordField();
		oldPassTF.setBounds(400, 100, 120, 30);
		oldPassTF.setEchoChar('*');
		panel.add(oldPassTF);
		
		Icon i=new ImageIcon("image.jpg");
		hidebtn = new JButton(i);
		hidebtn.setBounds(530, 105, 25, 20);
		hidebtn.addActionListener(this);
		hidebtn.addMouseListener(this);
		panel.add(hidebtn);
		
		newPassTF = new JPasswordField();
		newPassTF.setBounds(400, 150, 120, 30);
		newPassTF.setEchoChar('*');
		panel.add(newPassTF);
		
		Icon ii=new ImageIcon("image.jpg");
		hidebtn2 = new JButton(ii);
		hidebtn2.setBounds(530, 155, 25, 20);
		hidebtn2.addActionListener(this);
		hidebtn2.addMouseListener(this);
		panel.add(hidebtn2);
		
		this.add(panel);
	}
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseReleased(MouseEvent me)
	{
		if(me.getSource().equals(hidebtn))
		{
			oldPassTF.setEchoChar('*');
		}
		else if(me.getSource().equals(hidebtn2))
		{
			newPassTF.setEchoChar('*');
		}
		else{}
	}
	public void mousePressed(MouseEvent me)
	{
		if(me.getSource().equals(hidebtn))
		{
			oldPassTF.setEchoChar((char)0);
		}
		else if(me.getSource().equals(hidebtn2))
		{
			newPassTF.setEchoChar((char)0);
		}
		else{}
	}
	
	
	public void updateInDB()
	{
		String newPass = newPassTF.getText();
		String newUser = userId;
		
		String query = "UPDATE login SET password='"+newPass+"' WHERE userId='"+newUser+"'";	
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
			
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(changeBtn.getText()))
		{
		    updateInDB();
		    Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
		
		}
		else if(text.equals(backBtn.getText()))
		{
			EmployeeHome2 ch = new EmployeeHome2(userId);
						ch.setVisible(true);
						this.setVisible(false);
		}
	}
}
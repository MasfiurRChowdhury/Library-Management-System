import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener,MouseListener
{
	JLabel userLabel, passLabel, eNameLabel, phoneLabel, roleLabel, salaryLabel;
	JTextField userTF,phoneTF1, phoneTF2, eNameTF, salaryTF;
	JPasswordField passTF;
	JComboBox roleCombo;
	JButton autoPassBtn, addBtn, backBtn, logoutBtn,hidebtn;
	JPanel panel;
	private ImageIcon img,Icon;
	private JLabel imgLabel;
	
	String userId;
	
	public AddEmployee(String userId)
	{
		super("Add New Employee");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(500, 400, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(250, 100, 120, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(400, 100, 120, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(250, 150, 120, 30);
		panel.add(passLabel);
		
		passTF = new JPasswordField();
		passTF.setBounds(400, 150, 120, 30);
		passTF.setEchoChar('*');
		panel.add(passTF);
		
		Icon i=new ImageIcon("image.jpg");
		hidebtn = new JButton(i);
		hidebtn.setBounds(530, 155, 25, 20);
		hidebtn.addActionListener(this);
		hidebtn.addMouseListener(this);
		panel.add(hidebtn);
		
		eNameLabel = new JLabel("Employee Name : ");
		eNameLabel.setBounds(250, 200, 120, 30);
		panel.add(eNameLabel);
		
		eNameTF = new JTextField();
		eNameTF.setBounds(400, 200, 120, 30);
		panel.add(eNameTF);
		
		phoneLabel = new JLabel("Phone No. : ");
		phoneLabel.setBounds(250, 250, 120, 30);
		panel.add(phoneLabel);
		
		phoneTF1 = new JTextField("+880");
		phoneTF1.setBounds(400, 250, 35, 30);
		phoneTF1.setEnabled(false);
		phoneTF1.setForeground(Color.BLACK);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField();
		phoneTF2.setBounds(435, 250, 85, 30);
		panel.add(phoneTF2);
		
		roleLabel = new JLabel("Role : ");
		roleLabel.setBounds(250, 300, 120, 30);
		panel.add(roleLabel);
		
		String []items = {"Manager", "Emplolyee"};
		roleCombo = new JComboBox(items);
		roleCombo.setBounds(400, 300, 120, 30);
		panel.add(roleCombo);
		
		salaryLabel = new JLabel("Salary : ");
		salaryLabel.setBounds(250, 350, 120, 30);
		panel.add(salaryLabel);
		
		salaryTF = new JTextField();
		salaryTF.setBounds(400, 350, 120, 30);
		panel.add(salaryTF);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(200, 400, 120, 30);
		addBtn.addActionListener(this);
		panel.add(addBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(350, 400, 120, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseReleased(MouseEvent me)
	{
		if(me.getSource().equals(hidebtn))
		{
			passTF.setEchoChar('*');
		}
		else{}
	}
	public void mousePressed(MouseEvent me)
	{
		if(me.getSource().equals(hidebtn))
		{
			passTF.setEchoChar((char)0);
		}
		else{}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			ManageEmployee me = new ManageEmployee(userId);
			me.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		
		else if(text.equals(addBtn.getText()))
		{
			insertIntoDB();
			AddEmployee lg = new AddEmployee(userId);
			lg.setVisible(true);
			this.setVisible(false);
			
		}
		else{}
	}
	public void insertIntoDB()
	{
		String newId = userTF.getText();
		String newPass = passTF.getText();
		String eName = eNameTF.getText();
		String phnNo = phoneTF1.getText()+phoneTF2.getText();
		String role = roleCombo.getSelectedItem().toString();
		double salary = Double.parseDouble(salaryTF.getText());
		int status = 0;
		
		
		String query1 = "INSERT INTO Employee VALUES ('"+newId+"','"+eName+"','"+ phnNo+"','"+role+"',"+salary+");";
		String query2 = "INSERT INTO Login VALUES ('"+newId+"','"+newPass+"',"+status+");";
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
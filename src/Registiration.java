
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Registiration extends JFrame {
	
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextArea txtAdress;

	Font ft;
	Icon back,regIcon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Registiration frame = new Registiration();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registiration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 454, 343);
		 //setSize(700,450);
		setSize(454,400);
	     setLocation(300,150);
		
		setTitle("Hizmet Sepeti");
		getContentPane().setLayout(null);
		
		 ft = new Font("Verdana",Font.BOLD,18);
		
		 
		// Header Title
		JLabel hRegister = new JLabel("Register Data");
		hRegister.setFont(ft);
		hRegister.setForeground(new Color(0,170,50));
		
		hRegister.setHorizontalAlignment(SwingConstants.CENTER);
		hRegister.setBounds(111, 31, 250, 20);
		getContentPane().add(hRegister);

		// *** Header ***//
		JLabel hUsername = new JLabel("Username :");
		hUsername.setBounds(78, 82, 89, 14);
		hUsername.setForeground(new Color(0,100,100));
		getContentPane().add(hUsername);
		
		JLabel hPassword = new JLabel("Password :");
		hPassword.setBounds(78, 114, 89, 14);
		hPassword.setForeground(new Color(0,100,100));
		getContentPane().add(hPassword);
		
		JLabel hConfirmPassword = new JLabel("Confirm Password :");
		hConfirmPassword.setBounds(77, 143, 140, 14);
		hConfirmPassword.setForeground(new Color(0,100,100));
		getContentPane().add(hConfirmPassword);
		
		JLabel hName = new JLabel("Name :");
		hName.setBounds(78, 178, 89, 14);
		hName.setForeground(new Color(0,100,100));
		getContentPane().add(hName);

		JLabel hEmail = new JLabel("Email :");
		hEmail.setBounds(80, 206, 89, 14);
		hEmail.setForeground(new Color(0,100,100));
		getContentPane().add(hEmail);
		
		JLabel hAdress = new JLabel("Adress :");
		hAdress.setBounds(80, 234, 89, 14);
		hAdress.setForeground(new Color(0,100,100));
		getContentPane().add(hAdress);
		
		


		// CustomerID
		txtUsername = new JTextField("");
		txtUsername.setBounds(217, 82, 176, 20);
		getContentPane().add(txtUsername);
		
		// Password
		txtPassword = new JPasswordField();
		txtPassword.setBounds(217, 114, 176, 20);
		getContentPane().add(txtPassword);
		
		// Confirm Password
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(217, 142, 176, 20);
		getContentPane().add(txtConfirmPassword);

		// Name
		txtName = new JTextField("");
		txtName.setBounds(217, 170, 176, 20);
		getContentPane().add(txtName);

		// Email
		txtEmail = new JTextField("");
		txtEmail.setBounds(217, 202, 176, 20);
		getContentPane().add(txtEmail);
		
		// Adress
		txtAdress= new JTextArea("");
		txtAdress.setBounds(217, 234, 176, 60);
		txtAdress.setLineWrap(true);
		txtAdress.setWrapStyleWord(true);
		txtAdress.setBorder( BorderFactory.createLineBorder(Color.GRAY));
		
		getContentPane().add(txtAdress);
		
		//register Icon
	
		 regIcon = new ImageIcon("/home/user/workspace/372 Gui/src/mdpi.png");
		 JLabel lblIcon = new JLabel(regIcon);
		 lblIcon.setBounds(338, 15, 50, 50);
		 getContentPane().add(lblIcon);

		//Clear Button
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//reset fields
				txtUsername.setText("");
				txtPassword.setText("");
				txtConfirmPassword.setText("");
				txtName.setText("");
				txtEmail.setText("");
				
			}
		});
		
		btnClear.setBounds(78, 317, 89, 23);
		btnClear.setForeground(new Color(0,170,170));
		getContentPane().add(btnClear);		
		

		// Save Button
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(new Color(0,170,170));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(RegisterData()) {
					//REZ   #1
					Login loginPage = new Login(); //  #2 anasayfanın nesnesi olusturulacak
					loginPage.setVisible(true);
    				dispose();
    				
					JOptionPane.showMessageDialog(null,
							"Register Data Successfully");
				}
			}
		});
		btnSave.setBounds(181, 317, 89, 23);
		getContentPane().add(btnSave);		
		
		
		 //Back Button
		 
		 back = new ImageIcon("/home/user/workspace/372 Gui/src/aa.png");
		 
		 JButton btnBack = new JButton("Back");
		 btnBack.setBounds(5, 5, 75, 35);
		 btnBack.setForeground(new Color(0,170,170));
		 btnBack.setMargin(new Insets(0, 0, 0, 0));
		 btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login loginPage = new Login(); //  #2 anasayfanın nesnesi olusturulacak
				loginPage.setVisible(true);
				dispose();
			}
		});
		 btnBack.setIcon(back);
		 getContentPane().add(btnBack);
		
		 

	}
	
	private Boolean RegisterData()
	{
		
		String strUsername = txtUsername.getText();
		String strPassword = new String(txtPassword.getPassword());
		String strConfirmPassword = new String(txtConfirmPassword.getPassword());
		String strName = txtName.getText();
		String strEmail = txtEmail.getText();
		
		if(strUsername.equals("")) // Username
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Username)");
			txtUsername.requestFocusInWindow(); 
			return false;
		}
		if(strPassword.equals("")) // Password
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Password)");
			txtPassword.requestFocusInWindow(); 
			return false;
		}
		
		if(strConfirmPassword.equals("")) // Confirm Password
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Confirm Password)");
			txtConfirmPassword.requestFocusInWindow(); 
			return false;
		}
		if(!strPassword.equals(strConfirmPassword)) // Password math
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Password Not Match!)");
			txtPassword.requestFocusInWindow(); 
			return false;
		}		
		if(strName.equals("")) // Name
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Name)");
			txtName.requestFocusInWindow(); 
			return false;
		}	
		
		if(strEmail.equals("")) // Email
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Email)");
			txtEmail.requestFocusInWindow(); 
			return false;
		}	
		
		Connection connect = null;
		Statement s = null;
		Boolean status = false;

		try {
			/*Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(""
					+ "jdbc:mysql://localhost/mydatabase"
					+ "?user=root&password=root");

			s = connect.createStatement();*/
			
			// SQL Insert
			String sql = "INSERT INTO member "
					+ "(Username,Password,Email,Name) "
					+ "VALUES ('" + strUsername + "','"
					+ strPassword + "','"
					+ strEmail + "'" + ",'"
					+ strName + "') ";
			//s.execute(sql);
		
			System.out.println(sql);
			// Reset Text Fields
			txtUsername.setText("");
			txtPassword.setText("");
			txtConfirmPassword.setText("");
			txtName.setText("");
			txtEmail.setText("");
				
			status  = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		
		
		return status;

	}
}

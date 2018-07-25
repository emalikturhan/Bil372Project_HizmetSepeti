
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.sql.*;
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

	static Connection currentConnection = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField tc_no;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtEmail;
	private JTextField txtPhone;
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
		setSize(500,650);
	     setLocation(300,150);
		
		setTitle("Hizmet Sepeti");
		getContentPane().setLayout(null);
		
		 ft = new Font("Verdana",Font.BOLD,18);
		
		 
		// Header Title
		JLabel hRegister = new JLabel("Register Data");
		hRegister.setFont(ft);
		hRegister.setForeground(new Color(0,170,50));
		
		hRegister.setHorizontalAlignment(SwingConstants.CENTER);
		hRegister.setBounds(115, 25, 250, 20);
		getContentPane().add(hRegister);

		// *** Header ***//
		JLabel hUsername = new JLabel("Username :");
		hUsername.setBounds(80, 80, 90, 14);
		hUsername.setForeground(new Color(0,100,100));
		getContentPane().add(hUsername);
		
		JLabel hPassword = new JLabel("Password :");
		hPassword.setBounds(80, 110, 90, 14);
		hPassword.setForeground(new Color(0,100,100));
		getContentPane().add(hPassword);
		
		JLabel hConfirmPassword = new JLabel("Confirm Password :");
		hConfirmPassword.setBounds(80, 140, 90, 14);
		hConfirmPassword.setForeground(new Color(0,100,100));
		getContentPane().add(hConfirmPassword);

		JLabel hTC = new JLabel("TC NO :");
		hTC.setBounds(80, 170, 90, 14);
		hTC.setForeground(new Color(0,100,100));
		getContentPane().add(hTC);

		JLabel hFName = new JLabel("First Name :");
		hFName.setBounds(80, 200, 90, 14);
		hFName.setForeground(new Color(0,100,100));
		getContentPane().add(hFName);

		JLabel hLName = new JLabel("Last Name :");
		hLName.setBounds(80, 230, 90, 14);
		hLName.setForeground(new Color(0,100,100));
		getContentPane().add(hLName);

		JLabel hEmail = new JLabel("Email :");
		hEmail.setBounds(80, 260, 90, 14);
		hEmail.setForeground(new Color(0,100,100));
		getContentPane().add(hEmail);

		JLabel hPhone = new JLabel("Phone :");
		hPhone.setBounds(80, 290, 90, 14);
		hPhone.setForeground(new Color(0,100,100));
		getContentPane().add(hPhone);
		
		JLabel hAdress = new JLabel("Adress :");
		hAdress.setBounds(80, 320, 90, 14);
		hAdress.setForeground(new Color(0,100,100));
		getContentPane().add(hAdress);

		// CustomerID
		txtUsername = new JTextField("");
		txtUsername.setBounds(217, 80, 176, 20);
		getContentPane().add(txtUsername);
		
		// Password
		txtPassword = new JPasswordField();
		txtPassword.setBounds(217, 110, 176, 20);
		getContentPane().add(txtPassword);
		
		// Confirm Password
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(217, 140, 176, 20);
		getContentPane().add(txtConfirmPassword);

		tc_no = new JTextField("");
		tc_no.setBounds(217, 170, 176, 20);
		getContentPane().add(tc_no);

		// Name
		txtFName = new JTextField("");
		txtFName.setBounds(217, 200, 176, 20);
		getContentPane().add(txtFName);

		txtLName = new JTextField("");
		txtLName.setBounds(217, 230, 176, 20);
		getContentPane().add(txtLName);

		// Email
		txtEmail = new JTextField("");
		txtEmail.setBounds(217, 260, 176, 20);
		getContentPane().add(txtEmail);

		txtPhone = new JTextField("");
		txtPhone.setBounds(217, 290, 176, 20);
		getContentPane().add(txtPhone);
		
		// Adress
		txtAdress= new JTextArea("");
		txtAdress.setBounds(217, 320, 176, 60);
		txtAdress.setLineWrap(true);
		txtAdress.setWrapStyleWord(true);
		txtAdress.setBorder( BorderFactory.createLineBorder(Color.GRAY));
		
		getContentPane().add(txtAdress);
		
		//register Icon
	
		 regIcon = new ImageIcon("./src/mdpi.png");
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
				tc_no.setText("");
				txtFName.setText("");
				txtLName.setText("");
				txtEmail.setText("");
				txtPhone.setText("");
				txtAdress.setText("");
			}
		});
		
		btnClear.setBounds(80, 420, 89, 23);
		btnClear.setForeground(new Color(0,170,170));
		getContentPane().add(btnClear);		
		

		// Save Button
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(new Color(0,170,170));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(RegisterData()) {
					String insertQuery = "insert into appuser(user_id, user_psw, tc_no, fname, lname, address, email, phone) values (?,?,?,?,?,?,?,?)";
					try {
						ConnectionManager connect = new ConnectionManager();
						currentConnection = connect.getConnection();
						ps = currentConnection.prepareStatement(insertQuery);
						ps.setString(1, txtUsername.getText());
						ps.setString(2, txtPassword.getText());
						ps.setString(3, tc_no.getText());
						ps.setString(4, txtFName.getText());
						ps.setString(5, txtLName.getText());
						ps.setString(6, txtAdress.getText());
						ps.setString(7, txtEmail.getText());
						ps.setString(8, txtPhone.getText());
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						finalizeConnection(currentConnection, ps, rs);
					}
					Login loginPage = new Login(); //  #2 anasayfanın nesnesi olusturulacak
					loginPage.setVisible(true);
    				dispose();
    				
					JOptionPane.showMessageDialog(null,
							"Register Data Successfully updated.");
				}
			}
		});
		btnSave.setBounds(180, 420, 89, 23);
		getContentPane().add(btnSave);		
		
		
		 //Back Button
		 
		 back = new ImageIcon("./src/aa.png");
		 
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
	
	private Boolean RegisterData() {
		String strUsername = txtUsername.getText();
		String strPassword = new String(txtPassword.getPassword());
		String strConfirmPassword = new String(txtConfirmPassword.getPassword());
		String strTCNO = tc_no.getText();
		String strFName = txtFName.getText();
		String strLName = txtLName.getText();
		String strEmail = txtEmail.getText();
		String strPhone = txtPhone.getText();
		String strAddress = txtAdress.getText();

		String searchQuery1 = "select * from appuser where user_id=?";
		String searchQuery2 = "select * from appuser where email=?";
		try {
			ConnectionManager connect = new ConnectionManager();
			currentConnection = connect.getConnection();
			ps = currentConnection.prepareStatement(searchQuery1);
			ps.setString(1, txtUsername.getText());
			rs = ps.executeQuery();
			boolean controlID = rs.next();
			if (controlID) {
				JOptionPane.showMessageDialog(null,
						"Bu kullanici adi daha once alinmistir. Lutfen yeni bir kullanici adi giriniz.");
				txtPassword.requestFocusInWindow();
				return false;
			} else {
				ps = currentConnection.prepareStatement((searchQuery2));
				ps.setString(1, txtEmail.getText());
				rs = ps.executeQuery();
				boolean controlEmail = rs.next();
				if (controlEmail) {
					JOptionPane.showMessageDialog(null,
							"Bu e-maile sahip kullanici vardir. Lutfen baska e-mail deneyiniz.");
					txtPassword.requestFocusInWindow();
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			finalizeConnection(currentConnection, ps, rs);
		}

		if (!strPassword.equals(strConfirmPassword)) // Password math
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Password Not Match!)");
			txtPassword.requestFocusInWindow();
			return false;
		}

		if (strUsername.equals("") || strPassword.equals("") || strTCNO.equals("") || strFName.equals("")
				|| strLName.equals("") || strEmail.equals("") || strPhone.equals("") || strAddress.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Lutfen tum bilgileri giriniz!");
			txtFName.requestFocusInWindow();
			return false;
		}
		return true;
	}

	public static void finalizeConnection(Connection connection, PreparedStatement preparedStatement,
										  ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
			}
			resultSet = null;
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (Exception e) {
			}
			preparedStatement = null;
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
			}
			connection = null;
		}
	}
}

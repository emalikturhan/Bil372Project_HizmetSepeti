import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

class ProfilePanel extends JPanel {
        
    	private JTextField txtUsername;
    	private JPasswordField txtPassword;
    	private JPasswordField txtConfirmPassword;
    	private JTextField txtName;
    	private JTextField txtEmail;
    	private JTextArea txtAdress;
            
            ProfilePanel() {
        	 try {
                 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               } catch (Exception ex) {
               }
            	


     		// Save Button
     		JButton btnSave = new JButton("Save");
     		btnSave.setForeground(new Color(0,170,170));     		
     		btnSave.setBounds(161, 17, 89, 23);
     		add(btnSave);	
     		
     	// Logout Button
            JButton btnLogout= new JButton("Log Out");
            btnLogout.setForeground(new Color(0,170,170));
            btnLogout.setBounds(271, 17, 89, 23);
            add(btnLogout);
            
            
            JSeparator x = new JSeparator(SwingConstants.HORIZONTAL);
            x.setBounds(0, 60, 1000, 100);
           add(x);
            ////////////////////////////////////////////////////
            
            Font ft = new Font("Verdana",Font.BOLD,15);
            
            JLabel hRegister = new JLabel("Edit Profile");
    		hRegister.setFont(ft);
    		hRegister.setForeground(new Color(0,170,50));
    		
    		hRegister.setHorizontalAlignment(SwingConstants.CENTER);
    		hRegister.setBounds(151, 121, 250, 30);
    		add(hRegister);

    		// *** Header ***/
        	 
        	 setLayout(null);
    		JLabel hUsername = new JLabel("Username :");
    		hUsername.setBounds(128, 177, 89, 14);
    		hUsername.setForeground(new Color(0,100,100));
    		add(hUsername);
    		
    		JLabel hPassword = new JLabel("Password :");
    		hPassword.setBounds(128, 209, 89, 14);
    		hPassword.setForeground(new Color(0,100,100));
    		add(hPassword);
    		
    		JLabel hConfirmPassword = new JLabel("Confirm Password :");
    		hConfirmPassword.setBounds(127, 238, 140, 14);
    		hConfirmPassword.setForeground(new Color(0,100,100));
    		add(hConfirmPassword);
    		
    		JLabel hName = new JLabel("Name :");
    		hName.setBounds(128, 273, 89, 14);
    		hName.setForeground(new Color(0,100,100));
    		add(hName);

    		JLabel hEmail = new JLabel("Email :");
    		hEmail.setBounds(130, 301, 89, 14);
    		hEmail.setForeground(new Color(0,100,100));
    		add(hEmail);
    		
    		JLabel hAdress = new JLabel("Adress :");
    		hAdress.setBounds(130, 329, 89, 14);
    		hAdress.setForeground(new Color(0,100,100));
    		add(hAdress);


    		// CustomerID
    		txtUsername = new JTextField("");
    		txtUsername.setBounds(267, 172, 176, 25);
    		add(txtUsername);
    		
    		// Password
    		txtPassword = new JPasswordField();
    		txtPassword.setBounds(267, 204, 176, 25);
    		add(txtPassword);
    		
    		// Confirm Password
    		txtConfirmPassword = new JPasswordField();
    		txtConfirmPassword.setBounds(267, 232, 176, 25);
    		add(txtConfirmPassword);

    		// Name
    		txtName = new JTextField("");
    		txtName.setBounds(267, 260, 176, 25);
    		add(txtName);

    		// Email
    		txtEmail = new JTextField("");
    		txtEmail.setBounds(267, 292, 176, 25);
    		add(txtEmail);
    		
    		// Adress
    		txtAdress= new JTextArea("");
    		txtAdress.setBounds(267, 324, 176, 75);
    		txtAdress.setLineWrap(true);
    		txtAdress.setWrapStyleWord(true);
    		txtAdress.setBorder( BorderFactory.createLineBorder(Color.GRAY));
    		
    		add(txtAdress);
    		
    		//register Icon
    	
    	
    		 JLabel lblIcon = new JLabel(new ImageIcon("./src/profile.png"));
    		 lblIcon.setBounds(338, 105, 50, 50);
    		 add(lblIcon);
    		 
    		 // Text Field dataları   #rez bilgiler databaseden çekilecek  #1
    		 
    		 txtUsername.setText("TestData");
    		 txtPassword.setText("TestData");
    		 txtConfirmPassword.setText("TestData");
    		 txtName.setText("TestData");
    		 txtEmail.setText("TestData");
    		 txtAdress.setText("TestData");
    		 ///
    		 
    		 btnSave.addActionListener(new ActionListener() {
    				public void actionPerformed(ActionEvent arg0) {
    					
    					if(RegisterData()) {// KONTROLLER
    						    				
    						JOptionPane.showMessageDialog(null,
    								"Register Data Successfully");
    					}
    				}
    			});
    		 
    		 btnLogout.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent arg0) {
 					 					 					
 					JOptionPane.showMessageDialog(null,"Log out Successfully"); 					
 					System.exit(0);
 					
 				}
 			});
    		 
        }
            
            public Boolean RegisterData()
        	{
        		
        		String strUsername = txtUsername.getText();
        		String strPassword = new String(txtPassword.getPassword());
        		String strConfirmPassword = new String(txtConfirmPassword.getPassword());
        		String strName = txtName.getText();
        		String strEmail = txtEmail.getText();
        		String strAdress = txtAdress.getText();
        		
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

        		// #2 #rez veriler datbase yazılacak 
        		try {
        			/*Class.forName("com.mysql.jdbc.Driver");

        			connect = DriverManager.getConnection(""
        					+ "jdbc:mysql://localhost/mydatabase"
        					+ "?user=root&password=root");

        			s = connect.createStatement();*/
        			
        			// SQL Insert
        			String sql = "INSERT INTO member "
        					+ "(Username,Password,Email,Name,Address) "
        					+ "VALUES ('" + strUsername + "','"
        					+ strPassword + "','"
        					+ strEmail + "'" + ",'"
        					+ strName+ ",'"+ strAdress + "') ";
        			//s.execute(sql);
        		
        			System.out.println(sql);
        			
        			// Update Text Fields
        			txtUsername.setText(strUsername);
        			txtPassword.setText(strPassword);
        			txtConfirmPassword.setText(strConfirmPassword);
        			txtName.setText(strName);
        			txtEmail.setText(strEmail);
        			txtAdress.setText(strAdress);
        				
        			status  = true;

        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			JOptionPane.showMessageDialog(null, e.getMessage());
        			e.printStackTrace();
        		}

        		
        		
        		return status;

        	}
    }
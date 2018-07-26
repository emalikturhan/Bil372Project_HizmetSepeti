import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ProfilePanel extends JPanel {

	static Connection currentConnection = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static ConnectionManager connect = null;

	private JTextField txtUsername = new JTextField(Login.getUsername());
	private JPasswordField txtPassword = new JPasswordField();
	private JPasswordField txtConfirmPassword = new JPasswordField();
	private JTextField tc_no;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextArea txtAdress;

	ProfilePanel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
		}



		// Save Button
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(new Color(0,170,170));
		btnSave.setBounds(50, 17, 90, 23);
		add(btnSave);

		// Sales Record Button
		JButton btnSales = new JButton("Sales Record");
		btnSales.setForeground(new Color(0,170,170));
		btnSales.setBounds(160, 17, 120, 23);
		add(btnSales);

		// Purchase Record Button
		JButton btnPurchase = new JButton("Purchase Record");
		btnPurchase.setForeground(new Color(0,170,170));
		btnPurchase.setBounds(300, 17, 120, 23);
		add(btnPurchase);

		// Logout Button
		JButton btnLogout= new JButton("Log Out");
		btnLogout.setForeground(new Color(0,170,170));
		btnLogout.setBounds(440, 17, 90, 23);
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

		JLabel hTC = new JLabel("TC NO :");
		hTC.setBounds(125, 235, 90, 14);
		hTC.setForeground(new Color(0,100,100));
		add(hTC);

		JLabel hFName = new JLabel("First Name :");
		hFName.setBounds(125, 175, 90, 14);
		hFName.setForeground(new Color(0,100,100));
		add(hFName);

		JLabel hLName = new JLabel("Last Name :");
		hLName.setBounds(125, 205, 90, 14);
		hLName.setForeground(new Color(0,100,100));
		add(hLName);

		JLabel hEmail = new JLabel("Email :");
		hEmail.setBounds(125, 265, 90, 14);
		hEmail.setForeground(new Color(0,100,100));
		add(hEmail);

		JLabel hPhone = new JLabel("Phone :");
		hPhone.setBounds(125, 295, 90, 14);
		hPhone.setForeground(new Color(0,100,100));
		add(hPhone);

		JLabel hAdress = new JLabel("Adress :");
		hAdress.setBounds(125, 325, 90, 14);
		hAdress.setForeground(new Color(0,100,100));
		add(hAdress);

		// CustomerID

		tc_no = new JTextField("");
		tc_no.setBounds(267, 235, 176, 20);
		add(tc_no);

		// Name
		txtFName = new JTextField("");
		txtFName.setBounds(267, 175, 176, 20);
		add(txtFName);

		txtLName = new JTextField("");
		txtLName.setBounds(267, 205, 176, 20);
		add(txtLName);

		// Email
		txtEmail = new JTextField("");
		txtEmail.setBounds(267, 265, 176, 20);
		add(txtEmail);

		txtPhone = new JTextField("");
		txtPhone.setBounds(267, 295, 176, 20);
		add(txtPhone);

		// Adress
		txtAdress= new JTextArea("");
		txtAdress.setBounds(267, 325, 176, 60);
		txtAdress.setLineWrap(true);
		txtAdress.setWrapStyleWord(true);
		txtAdress.setBorder( BorderFactory.createLineBorder(Color.GRAY));
		add(txtAdress);

		//register Icon


		JLabel lblIcon = new JLabel(new ImageIcon("./src/profile.png"));
		lblIcon.setBounds(338, 105, 50, 50);
		add(lblIcon);

		// Text Field dataları   #rez bilgiler databaseden çekilecek  #1
		String query = "select * from appuser where user_id=?";
		try {
			connect = new ConnectionManager();
			currentConnection = connect.getConnection();
			ps = currentConnection.prepareStatement(query);
			ps.setString(1, txtUsername.getText());
			rs = ps.executeQuery();
			if (rs.next()) {
				txtFName.setText(rs.getString("fname"));
				txtLName.setText(rs.getString("lname"));
				txtEmail.setText(rs.getString("email"));
				tc_no.setText(rs.getString("tc_no"));
				txtAdress.setText(rs.getString("address"));
				txtPhone.setText(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finalizeConnection(currentConnection, ps, rs);
		}


		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(true) {// KONTROLLER
					String insertQuery = "UPDATE appuser set fname=?, lname=?, tc_no=?, address=?, email=?, phone=? where user_id=?";
					try {
						ConnectionManager connect = new ConnectionManager();
						currentConnection = connect.getConnection();
						ps = currentConnection.prepareStatement(insertQuery);
						ps.setString(1, txtFName.getText());
						ps.setString(2, txtLName.getText());
						ps.setString(3, tc_no.getText());
						ps.setString(4, txtAdress.getText());
						ps.setString(5, txtEmail.getText());
						ps.setString(6, txtPhone.getText());
						ps.setString(7, txtUsername.getText());
						ps.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						finalizeConnection(currentConnection, ps, rs);
					}
					JOptionPane.showMessageDialog(null,
							"Register Data Successfully updated.");
				}
			}
		});

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null,"Log out Successfully");
				Login loginPage = new Login();
				loginPage.setVisible(true);
				dispose();
			}
		});

		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "select service.service_name, appuser.fname, appuser.lname, sales_record.price, sales.amount_to_pay, sales.amount_paid, sales.s_date" +
						" from service, customer, appuser, sales_record, sales " +
						" where service.service_id = sales_record.service_id AND" +
						" sales.customer_id = customer.customer_id AND" +
						" customer.user_id = appuser.user_id AND" +
						" sales.sales_id = sales_record.sales_id";
				//JOptionPane.showMessageDialog(null,str,"SALES RECORDS", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "select service.service_name, appuser.fname, appuser.lname, purchase_record.price, purchase.amount_to_pay, purchase.amount_paid, purchase.p_date" +
						" from service, provider, appuser, purchase_record, purchase " +
						" where service.service_id = purchase_record.service_id AND" +
						" purchase.provider_id = provider.provider_id AND" +
						" provider.user_id = appuser.user_id AND" +
						" purchase.purchase_id = purchase_record.purchase_id";
				//JOptionPane.showMessageDialog(null,str,"PURCHASE RECORDS", JOptionPane.INFORMATION_MESSAGE);

			}
		});

	}

	public Boolean RegisterData()
	{
		String strTCNO = tc_no.getText();
		String strFName = txtFName.getText();
		String strLName = txtLName.getText();
		String strEmail = txtEmail.getText();
		String strPhone = txtPhone.getText();
		String strAddress = txtAdress.getText();

		if (strTCNO.equals("") || strFName.equals("") || strLName.equals("") || strEmail.equals("") || strPhone.equals("") || strAddress.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Lutfen bos alan birakmayiniz, tum bilgileri eksiksiz giriniz.");
			txtFName.requestFocusInWindow();
			return false;
		}
		return true;
	}
	public void dispose() {
		JFrame parent = (JFrame) this.getTopLevelAncestor();
		parent.dispose();
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
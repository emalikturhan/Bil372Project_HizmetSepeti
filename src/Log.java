import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Log extends JFrame {

	public static void main(String[] args) {
		Log frameTabel = new Log();
	}

	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField txuser = new JTextField(15);
	JPasswordField pass = new JPasswordField(15);
	JLabel reg = new JLabel("not a member? sign up here");
	JLabel username = new JLabel("Username");
	JLabel password = new JLabel("Password");
	
	JLabel deneme = new JLabel(new ImageIcon("heart.png"));
	
	
	  private Cursor prevCursor;

	Log() {
		super("Hizmet Sepeti Login");
		setBounds(280, 200, 400, 500);
		panel.setLayout(null);

		txuser.setBounds(70, 80, 210, 25);
		pass.setBounds(70, 140, 210, 25);
		reg.setBounds(70, 165, 210, 25);
		blogin.setBounds(110, 190, 80, 25);
		username.setBounds(70,50,210,25);
		password.setBounds(70,110,210,25);
		deneme.setBounds(10, 10, 20, 20);
		
		reg.setForeground(Color.BLUE);

		panel.add(blogin);
		panel.add(txuser);
		panel.add(pass);
		panel.add(reg);
		panel.add(username);
		panel.add(password);
		panel.add(deneme);
		
		
		reg.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {

				setCursor(prevCursor);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				//reg.setFont(new Font());
				 prevCursor = getCursor();
			        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
					MyForm form = new MyForm();
					form.setVisible(true);
					dispose();
				System.out.println("tıklandı");
			}
		});
		
		

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionlogin();
	}

	public void actionlogin() {
		blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String puname = txuser.getText();
				String ppaswd = pass.getText();
				if (puname.equals("test") && ppaswd.equals("12345")) {
					newframe regFace = new newframe();
					regFace.setVisible(true);
					dispose();
				} else {

					JOptionPane.showMessageDialog(null, "Wrong Password / Username");
					txuser.setText("");
					pass.setText("");
					txuser.requestFocus();
				}

			}
		});
	}
}
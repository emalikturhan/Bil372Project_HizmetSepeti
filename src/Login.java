import java.sql.*; 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class Login extends JFrame implements ActionListener{
 
    JPanel pan;
 
    JLabel lblIcon,lblTitle, lblUsername,lblPassword, reg, welcome;
    Icon logoImage;
    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnSubmit,btnReset;
   
    Cursor cSubmit,cReset,prevCursor;
 
    Font ft;
 
    Connection con1;
    PreparedStatement stat1;
    ResultSet rest1;
 
   // //LibraryMainMenu lmm;        
    //LibraryReportMenu lrm;
 
    public Login(){
 
        super("Login");
        pan = new JPanel();
        pan.setLayout(null);
 
        logoImage = new ImageIcon("/home/user/workspace/372 Gui/src/bas.png");
 
        lblIcon = new JLabel(logoImage);
 
        lblTitle = new JLabel("Login");
        ft = new Font("Verdana",Font.BOLD,15);
 
        lblUsername = new JLabel("Username");
        lblPassword =  new JLabel("Password");
        reg = new JLabel("not a member? sign up here");
        welcome= new JLabel("Welcome to HİZMET SEPETİ");
 
        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        txtPassword.setEchoChar('*');
 
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
 
        btnSubmit.setMnemonic(KeyEvent.VK_S);
        btnReset.setMnemonic(KeyEvent.VK_R);
 
        btnSubmit.setRolloverEnabled(true); //efekt
        btnSubmit.setMargin(new Insets(20,10,20,10));
 
        pan.setBackground(new Color(255,255,255));
         
        lblTitle.setForeground(new Color(0,50,50));
        lblUsername.setForeground(new Color(0,100,100));
        lblPassword.setForeground(new Color(0,100,100));
        reg.setForeground(new Color(0, 170, 0));
        welcome.setForeground(new Color(0,100, 100));
 
        btnSubmit.setForeground(new Color(0,170,170));
        btnReset.setForeground(new Color(0,170,170));
 
        cSubmit = btnSubmit.getCursor();
        cReset = btnReset.getCursor();
 
        btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 
        lblIcon.setBounds(20,20,377,381);
 
        lblTitle.setBounds(500,120,80,20);
        lblTitle.setFont(ft);
        lblUsername.setBounds(420,150,80,20);
        lblPassword.setBounds(420,190,80,20);
        reg.setBounds(420,220, 210, 20);
        welcome.setBounds(120, 0, 600, 100);
        
        welcome.setFont(new Font("Verdana", Font.BOLD, 30));
 
        txtUsername.setBounds(510,150,120,20);
        txtPassword.setBounds(510,190,120,20);
 
        btnSubmit.setBounds(460,260,80,20);
        btnReset.setBounds(550,260,80,20); 
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);
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
				reg.setForeground(new Color(0, 170, 0));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			
			reg.setForeground(Color.BLACK);
			 prevCursor = getCursor();
	        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				MyForm form = new MyForm();
				form.setVisible(true);
				dispose();
				
			}
		});
 
        pan.add(lblIcon);
        pan.add(lblUsername);
        pan.add(lblTitle);
        pan.add(lblPassword);
        pan.add(txtUsername);
        pan.add(txtPassword);
        pan.add(btnSubmit);
        pan.add(btnReset);
        pan.add(reg);
        pan.add(welcome);
 
        getContentPane().add(pan);
 
        setSize(700,450);
        setLocation(300,150);
        setVisible(true);
 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent evt){
 
        if(evt.getSource()==btnSubmit){
        		String username = txtUsername.getText();
        		String password = txtPassword.getText();
	        	
        		//REZ
        		//DATABASE SORGUSU YAPİLACAK
        		
        		if(password.equals("1")){ // #1
        			System.out.println("başarıyla girdiniz");
        			
        			newframe form = new newframe(); //  #2 anasayfanın nesnesi olusturulacak
    				form.setVisible(true);
    				dispose();
        			
        		}else {
        			
        			JOptionPane.showMessageDialog(null, "Wrong Password or Username");
        			txtUsername.setText("");
                	txtPassword.setText("");
                	txtUsername.requestFocus();
        		}
        		
             
        }
 
        if(evt.getSource()==btnReset){
        	txtUsername.setText("");
        	txtPassword.setText("");
 
        }
    }
    public static void main(String args[]){
 
        Login lg = new Login();
    }
}
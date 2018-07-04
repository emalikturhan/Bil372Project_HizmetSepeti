import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
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

class AboutPanel extends JPanel {

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextArea txtAdress;

	AboutPanel() {
        	 try {
                 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               } catch (Exception ex) {
               }
        	 setLayout(null);
        	 Font ft1 = new Font("Verdana",Font.BOLD,25);
        	 JLabel contLabel = new JLabel("Contributors");
        	 contLabel.setFont(ft1);
        	 contLabel.setBounds(201, 17, 250,40);
        	 contLabel.setForeground(new Color(0,170,50));
        	 add(contLabel);

            JSeparator a = new JSeparator(SwingConstants.HORIZONTAL);
            a.setBounds(0, 60, 1000, 100);
           add(a);
           
           JSeparator b = new JSeparator(SwingConstants.HORIZONTAL);
           b.setBounds(0, 260, 1000, 100);
          add(b);
            ////////////////////////////////////////////////////
            
           
            Font ft = new Font("Verdana",Font.BOLD,15);
               	
    		// Icons
    	    	
    		 JLabel lblIcon = new JLabel(new ImageIcon("/home/user/workspace/372 Gui/src/user1.png"));
    		 lblIcon.setBounds(88, 65, 100, 100);
    		 add(lblIcon);
    		 
    		 JLabel lblIcon2 = new JLabel(new ImageIcon("/home/user/workspace/372 Gui/src/user2.png"));
    		 lblIcon2.setBounds(398, 65, 100, 100);
    		 add(lblIcon2);
    		 
    		 JLabel lblIcon3 = new JLabel(new ImageIcon("/home/user/workspace/372 Gui/src/user3.png"));
    		 lblIcon3.setBounds(88, 270, 100, 100);
    		 add(lblIcon3);
    		 
    		 JLabel lblIcon4 = new JLabel(new ImageIcon("/home/user/workspace/372 Gui/src/user4.png"));
    		 lblIcon4.setBounds(398, 270, 100, 100);
    		 add(lblIcon4);
    		 
    		 // Labels
    		 
    		 String enes ="<html><p>Enes Malik TURHAN </p><p>eturhan@etu.edu.tr </p><p>141101003</p></html>";
    		 
    		JLabel lbl1 = new JLabel(enes);
    		lbl1.setFont(ft);
    		lbl1.setForeground(new Color(0,170,50));     		
    		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
     		lbl1.setBounds(20, 165, 250, 90);
     		add(lbl1);
     		
     		 String riza ="<html><p>Rıza IŞIK </p><p>risik@etu.edu.tr </p><p>141101032</p></html>";
    		 
     		JLabel lbl2 = new JLabel(riza);
     		lbl2.setFont(ft);
     		lbl2.setForeground(new Color(0,170,50));     		
     		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
     		lbl2.setBounds(350, 165, 250, 90);
      		add(lbl2);
      		
      		 String mustafa ="<html><p>Mustafa TOKMAK </p><p>m.tokmak@etu.edu.tr </p><p>131101009</p></html>";
    		 
     		JLabel lbl3 = new JLabel(mustafa);
     		lbl3.setFont(ft);
     		lbl3.setForeground(new Color(0,170,50));     		
     		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
     		lbl3.setBounds(20, 365, 250, 90);
      		add(lbl3);
      		
      		
      		 String ahmet ="<html><p>Ahmet Burak ÖZGÜNGÖRDÜ </p><p>aozgungordu@etu.edu.tr </p><p>141101063</p></html>";
    		 
     		JLabel lbl4 = new JLabel(ahmet);
     		lbl4.setFont(ft);
     		lbl4.setForeground(new Color(0,170,50));     		
     		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
     		lbl4.setBounds(350,365, 250, 90);
      		add(lbl4);
    	   		 
    		 
        }

}
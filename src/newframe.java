import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class newframe extends JFrame {

	public static void main(String[] args) {
		newframe frameTabel = new newframe();
	}

	JLabel welcome = new JLabel("ANASAYFAYA HOŞGELDİNİZ");
	JPanel panel = new JPanel();

	newframe() {
		super("Welcome");
		setSize(500, 400);
		setLocation(200, 100);
		panel.setLayout(null);

		welcome.setBounds(100, 80, 350, 60);

		panel.add(welcome);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
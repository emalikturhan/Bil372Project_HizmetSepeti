    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    class TabbedPane extends JFrame {
    	
        JTabbedPane tabs;        
        GiveServicePanel course;
        TakeServicePanel selectCourse;
        ProfilePanel profilePanel;
        AboutPanel aboutPanel;
        
        TabbedPane() {
            super("Home Page");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Setting the JTabbedPane Position and Layout as Wrap
            tabs = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.WRAP_TAB_LAYOUT);           
            course = new GiveServicePanel();
            selectCourse = new TakeServicePanel();
            profilePanel= new ProfilePanel();
            aboutPanel = new AboutPanel();
            
            // Adding user defined pannels to JTabbedPane
            
            
          //  ImageIcon img1 = new ImageIcon("/home/user/Desktop/tt/mdpi.png");
            
            tabs.addTab("Give Service",new ImageIcon("./src/giveservice.png"), course);
         //   ImageIcon img2 = new ImageIcon("home/user/Desktop/tt/ldpi.png");
            tabs.addTab("Take Service",new ImageIcon("./src/takeservice.png"), selectCourse);
            
            // Adding JPanels to JTabbedPane
            tabs.addTab("Profile           ",new ImageIcon("./src/profile.png"), profilePanel);
           
            tabs.addTab("About..",aboutPanel);

            getContentPane().add(tabs);
        }
    }
       
    class HomePage {
        public static void main(String args[]) throws Exception {
            
        	 new HomePage();
        }
        
        public HomePage() {
        	TabbedPane frame = new TabbedPane();
        	 frame.setSize(800, 500);
        	 frame.setLocation(300,150);
             frame.setVisible(true);
		}
    }
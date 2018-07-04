    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    class TabbedPane extends JFrame {
        JTabbedPane tabs;
        GiveServicePanel course;
        TakeServicePanel selectCourse;
        ProfilePanel profilePanel;
        TabbedPane() {
            super("Tabbed Pane Example");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Setting the JTabbedPane Position and Layout as Wrap
            tabs = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.WRAP_TAB_LAYOUT);           
            course = new GiveServicePanel();
            selectCourse = new TakeServicePanel();
            profilePanel= new ProfilePanel();
            // Adding user defined pannels to JTabbedPane
            
            
          //  ImageIcon img1 = new ImageIcon("/home/user/Desktop/tt/mdpi.png");
            
            tabs.addTab("Give Service",new ImageIcon("/home/user/workspace/372 Gui/src/giveservice.png"), course);
         //   ImageIcon img2 = new ImageIcon("home/user/Desktop/tt/ldpi.png");
            tabs.addTab("Take Service",new ImageIcon("/home/user/workspace/372 Gui/src/takeservice.png"), selectCourse);
            
            // Adding JPanels to JTabbedPane
            tabs.addTab("Profile           ",new ImageIcon("/home/user/workspace/372 Gui/src/profile.png"), profilePanel);
            tabs.addTab("Comment", new JTextArea(10, 40));
            tabs.addTab("More..", new JPanel());

            getContentPane().add(tabs);
        }
    }
    /*Creating CoursePanel by extending JPanel*/
    class GiveServicePanel extends JPanel {
        JButton addCourse, clear;
        GiveServicePanel() {
            addCourse = new JButton("Add Course");
            clear = new JButton("Clear");
            setLayout(new FlowLayout());
            add(addCourse);
            add(clear);
        }
    }
    /*Creating SelectCoursePanel by extending JPanel*/
    class TakeServicePanel extends JPanel {
        JCheckBox java, swing, hibernate;
        TakeServicePanel() {
            java = new JCheckBox("Java");
            swing = new JCheckBox("Spring");
            hibernate = new JCheckBox("Hibernate");
            setLayout(new FlowLayout());
            add(java);
            add(swing);
            add(hibernate);
        }
    }
    class ProfilePanel extends JPanel {
        JCheckBox java, swing, hibernate;
        ProfilePanel() {
            java = new JCheckBox("Java");
            swing = new JCheckBox("Spring");
            hibernate = new JCheckBox("Hibernate");
            setLayout(new FlowLayout());
            add(java);
            add(swing);
            add(hibernate);
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
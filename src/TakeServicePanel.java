import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class TakeServicePanel extends JPanel {
	
    	TakeServicePanel() {
    		 try {
                 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
               } catch (Exception ex) {
               }
    		
    		 
    		 setLayout(new BorderLayout());
    		 
    		 JPanel ustPanel = new JPanel(new FlowLayout());
    		 JPanel altPanel = new JPanel(new BorderLayout());
    		 
    		// ustPanel.setBackground(Color.BLUE);
    		 altPanel.setBackground(Color.RED);
    		 add(ustPanel,BorderLayout.NORTH);
    		 add(altPanel,BorderLayout.CENTER);
    		 
         

    		 Font ft = new Font("Verdana",Font.BOLD,15);
                
            JComboBox comboBox = new JComboBox();
          
            comboBox.addItem( "String" );
            comboBox.addItem( "String2" );
            comboBox.addItem( "String3" );
            comboBox.addItem( "String4" );
            JComboBox comboBox2 = new JComboBox();
            
            comboBox2.addItem( "String" );
            comboBox2.addItem( "String2" );
            comboBox2.addItem( "String3" );
            comboBox2.addItem( "String4" );
            JComboBox comboBox3 = new JComboBox();
            
            comboBox3.addItem( "String" );
            comboBox3.addItem( "String2" );
            comboBox3.addItem( "String3" );
            comboBox3.addItem( "String4" );
            JComboBox comboBox4 = new JComboBox();
            
            comboBox4.addItem( "String" );
            comboBox4.addItem( "String2" );
            comboBox4.addItem( "String3" );
            comboBox4.addItem( "String4" );
            
            ustPanel.add(comboBox);
            ustPanel. add(comboBox2);
            ustPanel.add(comboBox3);
            ustPanel.add(comboBox4);
            
            JButton btnSearch = new JButton("Search");
            btnSearch.setForeground(new Color(0,170,170)); 
            ustPanel.add(btnSearch);
            
            
       		DefaultListModel<String> listModel = new DefaultListModel<>();
            listModel.addElement("USA");
            listModel.addElement("India");
            listModel.addElement("Vietnam");
            listModel.addElement("Canada");
            listModel.addElement("Denmark");
            listModel.addElement("France");
            listModel.addElement("Great Britain");
            listModel.addElement("Japan");
     
            //create the list
            JList countryList = new JList<>(listModel);
            altPanel.add(countryList);    
       		 
        }
    	public void itemStateChanged(ItemEvent e) {
    		
    		if(e.getSource()=="comboBox2"){
    			System.out.println();
    		}
    	}
    }
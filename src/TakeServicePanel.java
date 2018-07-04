import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

class TakeServicePanel extends JPanel {
    	JCheckBox java, swing, hibernate;
    	TakeServicePanel() {
            java = new JCheckBox("Java");
            setLayout(new FlowLayout());
            add(java);
            
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
            
            add(comboBox);
            add(comboBox2);
            add(comboBox3);
            add(comboBox4);
            
            JSeparator x = new JSeparator(SwingConstants.HORIZONTAL);
            x.setPreferredSize(new Dimension(1000,1000));
           add(x);
        }
    }
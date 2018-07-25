import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

class TakeServicePanel extends JPanel {

    String txtCmb="";
    String txtCmb2="";
    String txtCmb3="";
    String txtField="";

    TakeServicePanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }


        setLayout(new BorderLayout());

        JPanel ustPanel = new JPanel(new FlowLayout());
        JPanel ortaPanel = new JPanel(new BorderLayout());
        JPanel altPanel = new JPanel(new FlowLayout());

        // ustPanel.setBackground(Color.BLUE);
        altPanel.setBackground(Color.LIGHT_GRAY);
        add(ustPanel,BorderLayout.NORTH);
        add(ortaPanel,BorderLayout.CENTER);
        add(altPanel,BorderLayout.SOUTH);


        Font ft = new Font("Verdana",Font.BOLD,15);

        JLabel label1= new JLabel("İş türü:");
        JLabel label2= new JLabel("Şehir:");
        JLabel label3= new JLabel("Type:");
        JLabel label4= new JLabel("Search:");


        JComboBox comboBox = new JComboBox();

        comboBox.addItem( "Boya" );
        comboBox.addItem( "Nakliye" );
        comboBox.addItem( "D.şekeri" );
        comboBox.addItem( "Diyetisyen" );
        comboBox.setSelectedIndex(-1);

        JComboBox comboBox2 = new JComboBox();

        comboBox2.addItem( "Ankara" );
        comboBox2.addItem( "İstanbul" );
        comboBox2.addItem( "İzmir" );
        comboBox2.addItem( "Konya" );
        comboBox2.setSelectedIndex(-1);

        JComboBox comboBox3 = new JComboBox();

        comboBox3.addItem( "Direct" );
        comboBox3.addItem( "Remote" );
        comboBox3.setSelectedIndex(-1);

        JTextField txtSearch = new JTextField("");
        txtSearch.setPreferredSize(new Dimension(100,30));


        ustPanel.add(label1);
        ustPanel.add(comboBox);
        ustPanel.add(label2);
        ustPanel.add(comboBox2);
        ustPanel.add(label3);
        ustPanel.add(comboBox3);
        ustPanel.add(label4);
        ustPanel.add(txtSearch);


        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtCmb=comboBox.getSelectedItem().toString();
            }
        });

        comboBox2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtCmb2=comboBox2.getSelectedItem().toString();
            }
        });

        comboBox3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtCmb3=comboBox3.getSelectedItem().toString();
            }
        });





        DefaultListModel<String> listModel = new DefaultListModel<>();
        // DUMMY DATAS
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
        JLabel lblIcon = new JLabel(new ImageIcon("./src/empty-state.png"));

        if(listModel.getSize()==0){
            ortaPanel.add(lblIcon);
        }
        else{
            ortaPanel.add(countryList);
        }


        JButton btnSearch = new JButton("Search");
        btnSearch.setForeground(new Color(0,170,170));
        ustPanel.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // #rez veritabanı sorgudu yapılıp liste dönülecek

                txtField= txtSearch.getText();

                //System.out.println(txtCmb+ txtCmb2 +txtCmb3+ txtField ); // basaili bi sekilde dataları topladik
                // database sorgusu yapıp sonucları listeye ekle

                if(listModel.getSize()==0){ // arama sonucu boşsa iconu göster
                    ortaPanel.removeAll();
                    ortaPanel.add(lblIcon);
                    ortaPanel.repaint();
                }
                else{							//arama sonucu dluysa listeyi bas
                    ortaPanel.removeAll();

                    ortaPanel.add(countryList);
                    ortaPanel.repaint();
                }

            }
        });


        JButton btnAdd = new JButton("Add");
        btnAdd.setForeground(new Color(0,170,170));
        altPanel.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(countryList.getSelectedValue()!=null){

                    System.out.println(countryList.getSelectedValue());//bunu kaldır insert into yap record lara

                }

            }
        });


    }

}
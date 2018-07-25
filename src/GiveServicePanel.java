import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class GiveServicePanel extends JPanel {

    String selectedItem = "";

    GiveServicePanel() {
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


        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("2123");
        listModel.addElement("2124");
        listModel.addElement("2125");
        listModel.addElement("2126");
        listModel.addElement("2127");
        listModel.addElement("2128");
        listModel.addElement("2129");
        listModel.addElement("2130");

        //create the list
        JList countryList = new JList<>(listModel);
        altPanel.add(countryList);




        JButton btnAdd = new JButton("Add New Service");
        btnAdd.setForeground(new Color(0,170,170));
        ustPanel.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                AddServicePage page = new AddServicePage();
                page.setVisible(true);
                //	dispose();

                System.out.println(countryList.getSelectedValue());
            }
        });


        JButton btnEdit = new JButton("Edit Service");
        btnEdit.setForeground(new Color(0,170,170));
        ustPanel.add(btnEdit);
        btnEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(countryList.getSelectedValue()!=null){

                    String serviceID = countryList.getSelectedValue().toString();// listenin içinde ıd den başka şeyler de olacak buraya tekrar bak

                    EditServicePage frame = new EditServicePage(serviceID); // parapetre olarak editelenecek işin ıd si yollancak
                    frame.setVisible(true);

                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Lütfen editlemek için bir hizmet seçin.");
                }

            }
        });


    }

}
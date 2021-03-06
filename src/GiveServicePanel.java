import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

class GiveServicePanel extends JPanel {

    static Connection currentConnection = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    static ConnectionManager connect = null;
    private JList countryList;
    private JPanel altPanel;
    private DefaultListModel<String> listModel;

    GiveServicePanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }


        setLayout(new BorderLayout());

        JPanel ustPanel = new JPanel(new FlowLayout());
        altPanel = new JPanel(new BorderLayout());

        // ustPanel.setBackground(Color.BLUE);
        altPanel.setBackground(Color.RED);
        add(ustPanel,BorderLayout.NORTH);
        add(altPanel,BorderLayout.CENTER);



        Font ft = new Font("Verdana",Font.BOLD,15);
        listModel = new DefaultListModel<>();
        int count = 1;
        while(true) {
            String query = "select service_id, fname, lname, appuser.user_id, service_name, service_type, location, price from service, appuser where service_id = " + count + " AND " +
                    "appuser.user_id = service.user_id";
            try {
                connect = new ConnectionManager();
                currentConnection = connect.getConnection();
                ps = currentConnection.prepareStatement(query);
                rs = ps.executeQuery();
                if (rs.next()) {
                    if(rs.getString("user_id").equals(Login.getUsername())) {
                        String provider = rs.getString("fname") + rs.getString("lname");
                        Query que = new Query(rs.getString("service_id"), provider, rs.getString("service_name")
                                , rs.getString("service_type"), rs.getString("location"), rs.getString("price"));
                        String tmp = que.price;
                        if(tmp.indexOf('.') != -1) {
                            tmp = tmp.substring(0, tmp.indexOf('.') + 3);
                        }
                        String str = "ID: " + que.id + "; Provider: " + que.provider + "; Name: " + que.name + "; Type: " + que.type + "; Location: " + que.location + "; Price: " + tmp;
                        listModel.addElement(str);
                        listModel.addElement("\n");
                    }
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                finalizeConnection(currentConnection, ps, rs);
            }
            count++;
        }
        //create the list
        countryList = new JList<>(listModel);
        altPanel.add(countryList);




        JButton btnAdd1 = new JButton("Add New Qualified Service");
        btnAdd1.setForeground(new Color(0,170,170));
        ustPanel.add(btnAdd1);
        btnAdd1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                AddQualifiedServicePage page = new AddQualifiedServicePage();
                page.setVisible(true);
                dispose();
            }
        });

        JButton btnAdd2 = new JButton("Add New Unqualified Service");
        btnAdd2.setForeground(new Color(0,170,170));
        ustPanel.add(btnAdd2);
        btnAdd2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                AddUnqualifiedServicePage page = new AddUnqualifiedServicePage();
                page.setVisible(true);
                dispose();
            }
        });


        JButton btnEdit = new JButton("Edit Service");
        btnEdit.setForeground(new Color(0,170,170));
        ustPanel.add(btnEdit);
        btnEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(countryList.getSelectedValue()!=null){

                    String que = countryList.getSelectedValue().toString();// listenin içinde ıd den başka şeyler de olacak buraya tekrar bak
                    String serviceID = que.substring(que.indexOf(' ') + 1, que.indexOf(';'));

                    String query = "select * from qualified where service_id=" + serviceID;
                    try {
                        connect = new ConnectionManager();
                        currentConnection = connect.getConnection();
                        ps = currentConnection.prepareStatement(query);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            EditQServicePage frame = new EditQServicePage(serviceID); // parapetre olarak editelenecek işin ıd si yollancak
                            frame.setVisible(true);
                            dispose();
                        }
                        else {
                            EditUQServicePage frame = new EditUQServicePage(serviceID); // parapetre olarak editelenecek işin ıd si yollancak
                            frame.setVisible(true);
                            dispose();
                        }
                    } catch (Exception exp) {
                        exp.printStackTrace();
                    } finally {
                        finalizeConnection(currentConnection, ps, rs);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Lütfen editlemek için bir hizmet seçin.");
                }

            }
        });


    }

    public static void finalizeConnection(Connection connection, PreparedStatement preparedStatement,
                                          ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
            }
            resultSet = null;
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
            }
            preparedStatement = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
            }
            connection = null;
        }
    }
    public void dispose() {
        JFrame parent = (JFrame) this.getTopLevelAncestor();
        parent.dispose();
    }
}

class Query {
    String id;
    String provider;
    String name;
    String type;
    String location;
    String price;

    Query(String id, String provider, String name, String type, String location, String price) {
        this.id = id;
        this.provider = provider;
        this.name = name;
        this.type = type;
        this.location = location;
        this.price = price;
    }
}
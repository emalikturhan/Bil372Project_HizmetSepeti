
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditUQServicePage extends JFrame {

    static Connection currentConnection = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    static ConnectionManager connect = null;

    private JTextField txtServicename;
    private JTextField txtLocation;
    private JTextField txtType;
    private JTextField txtPrice;
    private JTextArea txtInfo;

    Font ft;


    public EditUQServicePage(String serviceID) {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,450);
        setLocation(500,200);

        setTitle("Edit Service");
        getContentPane().setLayout(null);

        ft = new Font("Verdana",Font.BOLD,18);

        // Header Title
        JLabel hRegister = new JLabel("Edit Service");
        hRegister.setFont(ft);
        hRegister.setForeground(new Color(0,170,50));

        hRegister.setHorizontalAlignment(SwingConstants.CENTER);
        hRegister.setBounds(111, 31, 250, 20);
        getContentPane().add(hRegister);

        // *** Header ***//
        JLabel hServicename = new JLabel("Service Name :");
        hServicename.setBounds(70, 82, 89, 14);
        hServicename.setForeground(new Color(0,100,100));
        getContentPane().add(hServicename);

        JLabel hLocation = new JLabel("Location (City):");
        hLocation.setBounds(70, 114, 89, 14);
        hLocation.setForeground(new Color(0,100,100));
        getContentPane().add(hLocation);

        JLabel hType = new JLabel("Type (Remote/Direct):");
        hType.setBounds(70, 143, 140, 14);
        hType.setForeground(new Color(0,100,100));
        getContentPane().add(hType);

        JLabel hPrice = new JLabel("Price (TL):");
        hPrice.setBounds(70, 173, 140, 14);
        hPrice.setForeground(new Color(0,100,100));
        getContentPane().add(hPrice);

        JLabel hInfo = new JLabel("Information :");
        hInfo.setBounds(70, 208, 89, 14);
        hInfo.setForeground(new Color(0,100,100));
        getContentPane().add(hInfo);

        txtServicename = new JTextField("");
        txtServicename.setBounds(215, 80, 176, 20);
        getContentPane().add(txtServicename);

        txtLocation = new JTextField("");
        txtLocation.setBounds(215, 110, 176, 20);
        getContentPane().add(txtLocation);

        txtType = new JTextField("");
        txtType.setBounds(215, 140, 176, 20);
        getContentPane().add(txtType);

        txtPrice = new JTextField("");
        txtPrice.setBounds(215, 170, 176, 20);
        getContentPane().add(txtPrice);

        txtInfo= new JTextArea("");
        txtInfo.setBounds(215, 200, 176, 60);
        txtInfo.setLineWrap(true);
        txtInfo.setWrapStyleWord(true);
        txtInfo.setBorder( BorderFactory.createLineBorder(Color.GRAY));
        getContentPane().add(txtInfo);

        String query = "select * from unqualified, service where service.service_id = unqualified.service_id AND unqualified.service_id=" + serviceID;
        try {
            connect = new ConnectionManager();
            currentConnection = connect.getConnection();
            ps = currentConnection.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                txtServicename.setText(rs.getString("service_name"));
                txtLocation.setText(rs.getString("location"));
                txtType.setText(rs.getString("service_type"));
                txtInfo.setText(rs.getString("information"));
                txtPrice.setText(rs.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            finalizeConnection(currentConnection, ps, rs);
        }

        //Clear Button
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //reset fields
                txtServicename.setText("");
                txtLocation.setText("");
                txtType.setText("");
                txtPrice.setText("");
                txtInfo.setText("");
            }
        });

        btnClear.setBounds(78, 340, 89, 23);
        btnClear.setForeground(new Color(0,170,170));
        getContentPane().add(btnClear);


        // Save Button
        JButton btnSave = new JButton("Save");
        btnSave.setForeground(new Color(0,170,170));
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(RegisterData()) {
                    String insertQuery1 = "UPDATE service set service_name=?, location=?, service_type=?, information=?, price=? where service_id=" + serviceID;
                    try {
                        ConnectionManager connect = new ConnectionManager();
                        currentConnection = connect.getConnection();
                        ps = currentConnection.prepareStatement(insertQuery1);
                        ps.setString(1, txtServicename.getText());
                        ps.setString(2, txtLocation.getText());
                        ps.setString(3, txtType.getText());
                        ps.setString(4, txtInfo.getText());
                        ps.setDouble(5, Double.parseDouble(txtPrice.getText()));
                        ps.executeUpdate();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        finalizeConnection(currentConnection, ps, rs);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Register Data Successfully updated.");
                    HomePage homepage = new HomePage();
                    dispose();
                }
            }
        });
        btnSave.setBounds(181, 340, 89, 23);
        getContentPane().add(btnSave);




    }
    private Boolean RegisterData() {
        String strServicename = txtServicename.getText();
        String strLocation = txtLocation.getText();
        String strType = txtType.getText();
        String strInfo = txtInfo.getText();
        String strPrice = txtPrice.getText();

        if (strServicename.equals("") || strLocation.equals("") || strType.equals("")
                || strInfo.equals("") || strPrice.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Lutfen tum bilgileri giriniz!");
            return false;
        }
        return true;
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
}

package poess;

import java.awt.*;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



public class zhuce extends JFrame implements ActionListener{
JButton b1,b2;
JTextField t1, t2;
JLabel l1, l2;

zhuce() {
    super("ע��");
    this.setLayout(new FlowLayout());
    l1 = new JLabel("�û���");
    t1 = new JTextField(10);
    l2 = new JLabel("����");
    t2 = new JTextField(10);
    b1 = new JButton("ע��");
    b2 = new JButton("����");
    this.add(l1);
    this.add(t1);
    this.add(l2);
    this.add(t2);
    this.add(b1);
    this.add(b2);
    b1.addActionListener(this);
    b2.addActionListener(this);
    this.setVisible(true);
    this.setBounds(100, 100, 400, 300);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
      
        String name = t1.getText();
        String password = t2.getText();

        Connection con = test.connect();
        Statement sql;
         try {
             sql = con.createStatement();

           sql.executeUpdate("INSERT INTO student (name, password) VALUES ('" + name + "', '" + password + "')");
            con.close();
            JOptionPane.showMessageDialog(this, "ע��ɹ�");
            this.dispose(); 
            new dengluchuangkou(); 
        } catch (SQLException ee) {
            JOptionPane.showMessageDialog(this, "ע��ʧ��"+ ee.getMessage());
        }
    }
    if (e.getSource() == b2) {
        this.dispose();
        new dengluchuangkou(); 
    }
}

	   }


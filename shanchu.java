package poess;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class shanchu extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField t1;
    JLabel l1;
    Connection con = null;
    PreparedStatement pstmt = null;

    shanchu() {
    	   super("ɾ��ְ��");
        this.setLayout(new FlowLayout());
        l1 = new JLabel("�û���");
        t1 = new JTextField(10);
        b1 = new JButton("ɾ��");
        b2 = new JButton("����");

        this.add(l1);
        this.add(t1);
        this.add(b1);
        this.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        this.setVisible(true);
        this.setBounds(0, 0, 800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                con = test.connect(); 
                String sql = "DELETE FROM staffinformation WHERE name2 = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, t1.getText());
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
            } catch (SQLException ee) {
                JOptionPane.showMessageDialog(this, "ɾ��ʧ�ܣ�" + ee.getMessage());
            } finally {
                try {
                    if (pstmt != null) pstmt.close();
                    if (con != null) con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        if (e.getSource() == b2) {
            this.dispose(); // �رյ�ǰ����
        }
    }
}


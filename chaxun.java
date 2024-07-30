package poess;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class chaxun extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField t1;
    JTextArea t6;
    JLabel l1, l6;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    chaxun() {
    	   super("��ѯ");
        this.setLayout(new FlowLayout());
        l1 = new JLabel("�û���");
        t1 = new JTextField(10);
        l6 = new JLabel("ְ����Ϣ");
        t6 = new JTextArea(10, 10);
        t6.setEditable(false);
        b1 = new JButton("��ѯ");
        b2 = new JButton("����");

        this.add(l1);
        this.add(t1);
        this.add(l6);
        this.add(t6);
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
            String name2 = t1.getText();
            try {
                con = test.connect(); 
                String sql = "SELECT * FROM staffinformation WHERE name2 = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, name2);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    String info = "����: " + rs.getString("name2") + "\n"
                                 + "�Ա�: " + rs.getString("sex") + "\n"
                                 + "����: " + rs.getInt("age") + "\n"
                                 + "����: " + rs.getString("nationality") + "\n"
                                 + "��ͥסַ: " + rs.getString("address") + "\n"
                                 + "ְλ: " + rs.getString("position") + "\n";
                    t6.setText(info);
                } else {
                    JOptionPane.showMessageDialog(this, "û���ҵ���ְ������Ϣ��");
                }
            } catch (SQLException ee) {
                JOptionPane.showMessageDialog(this, "��ѯʧ�ܣ�" + ee.getMessage());
            } finally {
               
                try {
                    if (rs != null) rs.close();
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

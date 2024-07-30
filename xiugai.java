package poess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class xiugai extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField t1, t3, t4;
    JTextArea t6;
    JLabel l1, l3, l4, l6;
    JRadioButton radioM, radioF;
    ButtonGroup group;
    JComboBox<String> comBox;
    JPanel radioPanel = new JPanel();

    xiugai() {
    	   super("�޸�ְ����Ϣ");
        this.setLayout(new FlowLayout());
        l1 = new JLabel("�û���");
        t1 = new JTextField(10);
        group = new ButtonGroup();
        radioM = new JRadioButton("��");
        radioF = new JRadioButton("Ů");
        l3 = new JLabel("����");
        t3 = new JTextField(10);
        l4 = new JLabel("����");
        t4 = new JTextField(10);
        l6 = new JLabel("��ͥסַ");
        t6 = new JTextArea(10, 10);
        comBox = new JComboBox<String>();
        comBox.addItem("���³�");
        comBox.addItem("����");
        comBox.addItem("��ͨԱ��");
        comBox.addItem("��ʱ��");
        comBox.addItem("��ٹ�");
        radioPanel.add(radioM);
        radioPanel.add(radioF);
        radioPanel.setVisible(true);

        this.add(l1);
        this.add(t1);
        this.add(radioPanel);
        this.add(l3);
        this.add(t3);
        this.add(l4);
        this.add(t4);
        this.add(l6);
        this.add(t6);
        this.add(comBox);
        b1 = new JButton("�޸�");
        b2 = new JButton("����");
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
            String sex = radioM.isSelected() ? "��" : "Ů";
            String age = t3.getText();
            String nationality = t4.getText();
            String address = t6.getText();
            String position = (String) comBox.getSelectedItem();
            Connection con = null;
            PreparedStatement pstmt = null;
            try {
                con = test.connect(); 
                String sql = "UPDATE staffinformation SET sex = ?, age = ?, nationality = ?, address = ?, position = ? WHERE name2 = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, sex);
                pstmt.setInt(2, Integer.parseInt(age));
                pstmt.setString(3, nationality);
                pstmt.setString(4, address);
                pstmt.setString(5, position);
                pstmt.setString(6, name2);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "�޸ĳɹ���");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "������������֣�" + ex.getMessage());
            } catch (SQLException ee) {

                JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ�" + ee.getMessage());
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

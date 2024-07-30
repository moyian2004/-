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
    	   super("查询");
        this.setLayout(new FlowLayout());
        l1 = new JLabel("用户名");
        t1 = new JTextField(10);
        l6 = new JLabel("职工信息");
        t6 = new JTextArea(10, 10);
        t6.setEditable(false);
        b1 = new JButton("查询");
        b2 = new JButton("返回");

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
                    String info = "姓名: " + rs.getString("name2") + "\n"
                                 + "性别: " + rs.getString("sex") + "\n"
                                 + "年龄: " + rs.getInt("age") + "\n"
                                 + "民族: " + rs.getString("nationality") + "\n"
                                 + "家庭住址: " + rs.getString("address") + "\n"
                                 + "职位: " + rs.getString("position") + "\n";
                    t6.setText(info);
                } else {
                    JOptionPane.showMessageDialog(this, "没有找到该职工的信息！");
                }
            } catch (SQLException ee) {
                JOptionPane.showMessageDialog(this, "查询失败：" + ee.getMessage());
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
            this.dispose(); // 关闭当前窗口
        }
    }
}

package poess;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class chaXunAll extends JFrame implements ActionListener {
    JButton b1, b2;
    JTable table;
    JScrollPane scrollPane;
    JLabel l6;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    DefaultTableModel model;

    chaXunAll() {
    	   super("查询所有学生");
        this.setLayout(new FlowLayout());
        l6 = new JLabel("职工信息");
        table = new JTable();
        scrollPane = new JScrollPane(table);
        b1 = new JButton("查询所有职工");
        b2 = new JButton("返回");

        this.add(l6);
        this.add(scrollPane);
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
                String sql = "SELECT * FROM staffinformation";
                pstmt = con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                model = new DefaultTableModel();
                model.addColumn("姓名");
                model.addColumn("性别");
                model.addColumn("年龄");
                model.addColumn("民族");
                model.addColumn("家庭住址");
                model.addColumn("职位");

                while (rs.next()) {
                    Object[] rowData = new Object[]{
                        rs.getString("name2"),
                        rs.getString("sex"),
                        rs.getInt("age"),
                        rs.getString("nationality"),
                        rs.getString("address"),
                        rs.getString("position")
                    };
                    model.addRow(rowData);
                }
                table.setModel(model);
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

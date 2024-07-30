package poess;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
	public class tianjia extends JFrame implements ActionListener {
		  JButton b1, b2;
		    JTextField t1, t3, t4;
		    JTextArea t6;
		    JLabel l1, l3, l4, l6;
		    JRadioButton radioM, radioF;
		    ButtonGroup group;
		    JComboBox<String> comBox;
		    JPanel radioPanel = new JPanel();

		    tianjia() {
		    	   super("添加职工");
		        this.setLayout(new FlowLayout());
		        l1 = new JLabel("用户名");
		        t1 = new JTextField(10);
		        group = new ButtonGroup();
		        radioM = new JRadioButton("男");
		        radioF = new JRadioButton("女");
		        l3 = new JLabel("年龄");
		        t3 = new JTextField(10);
		        l4 = new JLabel("民族");
		        t4 = new JTextField(10);
		        l6 = new JLabel("家庭住址");
		        t6 = new JTextArea(10, 10);
		        comBox = new JComboBox<String>();
		        comBox.addItem("董事长");
		        comBox.addItem("经理");
		        comBox.addItem("普通员工");
		        comBox.addItem("临时工");
		        comBox.addItem("暑假工");
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
		        b1 = new JButton("添加");
		        b2 = new JButton("返回");
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
		            String sex = radioM.isSelected() ? "男" : "女";
		            String age = t3.getText();
		            String nationality = t4.getText();
		            String address = t6.getText();
		            String position = (String) comBox.getSelectedItem();
		            Connection con = test.connect();
		            PreparedStatement pstmt = null;
		            try {
		                pstmt = con.prepareStatement("INSERT INTO staffinformation (name2, sex, age, nationality, address, position) VALUES (?, ?, ?, ?, ?, ?)");
		                pstmt.setString(1, name2);
		                pstmt.setString(2, sex);
		                pstmt.setInt(3, Integer.parseInt(age)); // 假设年龄是整数
		                pstmt.setString(4, nationality);
		                pstmt.setString(5, address);
		                pstmt.setString(6, position);
		                pstmt.executeUpdate();
		                JOptionPane.showMessageDialog(this, "添加成功！");
		                this.dispose(); // 添加成功后关闭窗口
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(this, "年龄必须是数字：" + ex.getMessage());
		            } catch (SQLException ee) {
		                JOptionPane.showMessageDialog(this, "添加失败：" + ee.getMessage());
		            } finally {
		                try {
		                    if (pstmt != null) pstmt.close();
		                    if (con != null) con.close();
		                } catch (SQLException ex) {
		                    JOptionPane.showMessageDialog(this, "数据库连接关闭失败：" + ex.getMessage());
		                }
		            }
		        }

		        if (e.getSource() == b2) {
		            this.dispose(); // 关闭当前窗口
		        }
		    }
	}



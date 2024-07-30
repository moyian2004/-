package poess;


	import javax.swing.*;

	import java.awt.*;
	import java.awt.event.*;
	import java.sql.*;
	public class dengluchuangkou extends JFrame implements ActionListener {
		 JButton b1, b2, b3;
		    JTextField t1, t2;
		    JLabel l1, l2;

		    public dengluchuangkou() {
		        super("登录窗口");
		        l1 = new JLabel("用户名");
		        t1 = new JTextField(10);
		        l2 = new JLabel("密码");
		        t2 = new JTextField(10);
		        b1 = new JButton("登录");
		        b2 = new JButton("取消");
		        b3 = new JButton("注册");
		        this.add(l1);
		        this.add(t1);
		        this.add(l2);
		        this.add(t2);
		        this.add(b1);
		        this.add(b2);
		        this.add(b3);
		        b1.addActionListener(this);
		        b2.addActionListener(this);
		        b3.addActionListener(this);
		        this.setLayout(new FlowLayout());
		        this.setVisible(true);
		        this.setSize(300, 150);
		        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    }

		    public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == b1) {
		         
		            String username = t1.getText();
		            String password = t2.getText();

		 
		            Connection con = test.connect();
		           Statement sql;
		             ResultSet rs;
		            try {
		               sql = con.createStatement();
		                rs = sql.executeQuery("SELECT * FROM student");
		                while (rs.next()) {
		                    String name = rs.getString(1);
		                     String ps = rs.getString(2); 
		                     if (username.equals(name) && password.equals(ps)) {
		                       new MyFrame();
		                       this.dispose();
		                       break;
		                      
		                    } 
		                }
		                con.close();
		              }   
		             catch (SQLException ee) {
		                System.out.println(ee);
		            }

		        } 
		        else if (e.getSource() == b2) {
		           
		            t1.setText(""); 
		            t2.setText(""); 
		        } else if (e.getSource() == b3) {
		        
		            new zhuce();
		      
		        }
		    }
	   } 


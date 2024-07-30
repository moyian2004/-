package poess;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;


public class MyFrame extends JFrame implements ActionListener {
	JButton b1,b2,b3,b4,b6;
	JLabel l1;

	MyFrame()
	{
		   super("主要功能");	
		   this.setLayout(new FlowLayout());
		   l1 = new JLabel("欢迎来到职工管理系统");
		   Font font=new Font("宋体",Font.BOLD,22);
		   l1.setFont(font);
	 
	
		b1 =new JButton("查询员工");
		b2 =new JButton("添加员工");
		b3 =new JButton("修改员工信息");
		b4 =new JButton("删除员工");               
		b6=new JButton("查看所有员工");
		this.add(l1);
		this.add(b1);
		this.add(b2);	
		this.add(b3);
		this.add(b4);
		
		this.add(b6);
		b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	   
	    b6.addActionListener(this);
		this.setVisible(true);
		this.setBounds(0,0,300,400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
           
        	new chaxun();

        }
        else if (e.getSource() == b2) {
        
   	           
   	        	new tianjia();
   	        	
        }
        else if(e.getSource() == b3) {
        	new xiugai();
        
        }
        else if (e.getSource() == b4) {
        	 new shanchu();
        	 
           }
            
        else if (e.getSource() == b6) {
            	new chaXunAll ();
            	
            }
    }
  
}
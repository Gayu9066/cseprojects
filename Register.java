package shp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Register extends JFrame {

	JLabel l1,l2,l3,l4,l5,l6;
	JTextField tf,tf1,tf2;
	JButton b;
	JPasswordField ps,ps1;
	
	Register(){
		JFrame f=new JFrame("REGISTRATION FORM");
		JPanel p=new JPanel();
		JLabel pic=new JLabel();
		pic.setBounds(0,0,400,400);
		ImageIcon icon=new ImageIcon("C:\\Users\\Kaushik\\Pictures\\wallpapers\\p4YBAFa_2mCAKkj1AAFfftRaGlE53.jpeg");
		Image img=icon.getImage();
		Image newimg=img.getScaledInstance(pic.getWidth(),pic.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newicon=new ImageIcon(newimg);
		pic.setIcon(newicon);
		p.setBounds(0,0,400,400);
		p.add(pic);
		
		l1=new JLabel("REGISTRATION FORM");
		l1.setForeground(Color.ORANGE);
		l1.setFont(new Font("Serif", Font.BOLD,20));
		
		l2=new JLabel("Name");
		l3=new JLabel("Password");
		l4=new JLabel("Confirm Password");
		l5=new JLabel("Mobile");
		l6=new JLabel("Address");
		tf=new JTextField();
		tf1=new JTextField();
		tf2=new JTextField();
		ps =new JPasswordField();
		ps1 =new JPasswordField();
		b=new JButton("REGISTER");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try{
						String name=tf.getText();
						String pass=ps.getText();
						String cpass=ps1.getText();
						String mobile=tf1.getText();
						String addr=tf2.getText();
						if(name.isEmpty()||pass.isEmpty()|| cpass.isEmpty()||mobile.isEmpty()||addr.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Invalid Username or Password or mobile or address");	
						}
						else if(pass.equals(cpass)){
							
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					Statement st=con.createStatement();
					String sql="insert into login1(name,password,mobile,address)  values('"+name+"','"+pass+"','"+mobile+"','"+addr+"')";
					int r=st.executeUpdate(sql);
					if(r!=0){
						
						JOptionPane.showMessageDialog(null, "Registered successful");
						new Loginform1();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Registered unsuccessful");
					}
				}
					
				}catch(Exception e){
					System.out.println(e); }
					}
		});
		l1.setBounds(50,30,400,30);
		l2.setBounds(50,80,200,30);
		tf.setBounds(180,80,200,30);
		l3.setBounds(50,120,200,30);
		ps.setBounds(180,120,200,30);
		l4.setBounds(50,160,200,30);
		ps1.setBounds(180,160,200,30);
		l5.setBounds(50,200,200,30);
		tf1.setBounds(180,200,200,30);
		l6.setBounds(50,240,200,30);
		tf2.setBounds(180,240,200,30);
		l4.setBounds(50,160,200,30);
		ps1.setBounds(180,160,200,30);
		b.setBounds(150,290,100,30);
		
		
		f.getContentPane().setBackground(Color.decode("#bdb67b"));
		l2.setForeground(Color.GREEN);
		l3.setForeground(Color.green);
		l4.setForeground(Color.GREEN);
		l5.setForeground(Color.GREEN);
		l6.setForeground(Color.GREEN);
		b.setBackground(Color.lightGray);
		
		f.add(l1);
		f.add(l2);
		f.add(tf);
		f.add(l3);
		f.add(ps);
		f.add(l4);
		f.add(ps1);
		f.add(l5);
		f.add(l6);
		f.add(tf1);
		f.add(tf2);
		f.add(b);
		f.add(p);
		f.setSize(400,400);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

	}
}

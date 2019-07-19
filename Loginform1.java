package shp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.event.AncestorListener;

public class Loginform1 extends JFrame {
	
	JLabel l1,l2,l3;
	JTextField tf;
	JButton b,b1,b2;
	JPasswordField ps;
	static int logid;
	static String n1;
	Loginform1()
	{
		JFrame f=new JFrame("LOGIN FORM");
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
		l1=new JLabel("AMAZON LOGIN FORM");
		l1.setForeground(Color.ORANGE);
		l1.setFont(new Font("Serif", Font.BOLD,20));
		
		l2=new JLabel("USERNAME");
		l3=new JLabel("PASSWORD");
		tf=new JTextField();
		ps =new JPasswordField();
		b=new JButton("LOGIN");
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try{
					String name=tf.getText();
					n1=name;
					String pass=ps.getText();
					if(name.isEmpty()||pass.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");	
					}
					else {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
						Statement st=con.createStatement();
						String sql="select *from login1 where name='"+tf.getText()+"'and password='"+ps.getText()+"'";
						ResultSet r=st.executeQuery(sql);
						if(r.next())
						{
							logid=r.getInt(5);
							JOptionPane.showMessageDialog(null, "login successful");
							new Menubar1(logid,n1);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "login unsuccessful");
						}
					}
					
				}
					catch(Exception e){
					System.out.println(e);
				}
			}
		});
		b1=new JButton("Click here to Register");
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Register();	}	
		});
		b2=new JButton("Exit");
		b2.addActionListener((event)->System.exit(0));
		
		l1.setBounds(100,30,400,30);
		l2.setBounds(50,80,200,30);
		l3.setBounds(50,120,200,30);
		tf.setBounds(150,80,200,30);
		ps.setBounds(150,120,200,30);
		b.setBounds(80,180,100,30);
		b2.setBounds(140,220,100,30);
		b1.setBounds(190,180,180,30);
		
		f.getContentPane().setBackground(Color.decode("#bdb67b"));
		l2.setForeground(Color.GREEN);
		l3.setForeground(Color.green);
		b.setBackground(Color.lightGray);
		b1.setBackground(Color.lightGray);
		b2.setBackground(Color.lightGray);
		
		f.add(l1);
		f.add(l2);
		f.add(tf);
		f.add(l3);
		f.add(ps);
		f.add(b);
		f.add(b1);
		f.add(b2);
		f.add(p);
		f.setSize(400,400);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

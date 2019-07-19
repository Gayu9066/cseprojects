package shp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Menubar1 extends JFrame
{
	JLabel pic;
	Timer tm;
	int x=0;
	int logid1; 
	String n1;
	
	String[] list={
			"C:\\Users\\Kaushik\\Pictures\\9ad279ba1163e5bb29abc843963ed4d6.jpg",
			"C:\\Users\\Kaushik\\Pictures\\ICON-209S-T100_0005_Layer-130.jpg" ,
			"C:\\Users\\Kaushik\\Pictures\\Gift-Icon-Purple-Cotton-Saree-SDL945876681-1-3b47d.jpeg" ,
			"C:\\Users\\Kaushik\\Pictures\\Jewellery_M_pf.jpg" ,
			"C:\\Users\\Kaushik\\Pictures\\M_Watches_HappyDimaonds_v1.jpg"
			};
	JFrame f=new JFrame(" USER INFORMATION");;
	JButton b;
	public Menubar1(int a,String nam) {
		n1=nam;
		logid1=a;
		createMenuBar();
		f.setSize(400,400);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
		pic=new JLabel();
		b=new JButton();
		pic.setBounds(0,0,400,100);
		b.setBounds(0,0,400,100);
			setimage(4);
			
			tm =new Timer(800,new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					setimage(x);
					x=x+1;
					if(x>=list.length){
						x=0;
					}	
				}
			});
			f.add(pic);
			tm.start();
			f.getContentPane().setBackground(Color.decode("#bdb67b"));
	}
	public void setimage(int i){	
		ImageIcon icon=new ImageIcon(list[i]);
		Image img=icon.getImage();
		Image newimg=img.getScaledInstance(pic.getWidth(),pic.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newicon=new ImageIcon(newimg);
		pic.setIcon(newicon);
	}

	private void createMenuBar(){
		JMenuBar menu=new JMenuBar();

		JMenu file1=new JMenu("Category");
		
		JMenu m1=new JMenu("Men");
		JMenuItem m11=new JMenuItem("Tshirt");
		
		m11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new Tshirt(logid1,1);
			}
			
		});
	/*	m112.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new Tshirt(logid1,2);
			}
			
		});
		
		m113.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new Tshirt(logid1,3);
			}
			
		});*/
		
		JMenuItem m13=new JMenuItem("Shirts");
		
		m13.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new Tshirt1(logid1,1);
			}
			
		});
		JMenuItem m14=new JMenuItem("Shoes");
		
		JMenuItem m12=new JMenuItem("Pants");
		
		
		m1.add(m11);
		m1.add(m12);
		m1.add(m13);
		m1.add(m14);

		JMenu m2=new JMenu("Women");
		JMenuItem m21=new JMenuItem("Ethinic wear");
		JMenuItem m22=new JMenuItem("Pants");
		JMenuItem m23=new JMenuItem("chudis");
		
		m2.add(m21);
		m2.add(m22);
		m2.add(m23);
		
		JMenu file=new JMenu("My Profile");
		JMenuItem mit=new JMenuItem("WishList");
		
		mit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new Wishlist(logid1);
			}
		});
		
		JMenuItem mit1=new JMenuItem("Moblile number");
		mit1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {

				JFrame f=new JFrame("mobile info");
				JLabel l1,l2,pic;
				JPanel p;
				JButton b;
				b=new JButton("UPDATE");
				b.setBounds(150,120,100,20);
				b.setForeground(Color.DARK_GRAY);
				String a=null;
				p=new JPanel();
				pic=new JLabel();
				pic.setBounds(0,0,400,400);
				ImageIcon icon=new ImageIcon("C:\\Users\\Kaushik\\Pictures\\wallpapers\\p4YBAFa_2mCAKkj1AAFfftRaGlE53.jpeg");
				Image img=icon.getImage();
				Image newimg=img.getScaledInstance(pic.getWidth(),pic.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newicon=new ImageIcon(newimg);
				pic.setIcon(newicon);
				p.setBounds(0,0,400,400);
				p.add(pic);
				try{
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
				Statement st=con.createStatement();
				String sql="select *from login1 where name='"+n1+"'";
				ResultSet r=st.executeQuery(sql);
				if(r.next())
				{
					 a=r.getString("mobile");
				}
				}catch(Exception e){
						System.out.println(e);
					}
				 JLabel mb=new JLabel();
				 mb.setText(": "+a);
				 f.getContentPane().setBackground(Color.lightGray);
				 l1=new JLabel("MOBILE NUMBER");
				 l1.setForeground(Color.GREEN);
				 mb.setForeground(Color.GREEN);
				 l1.setFont(new Font("Serif", Font.BOLD,15));
				 l1.setBounds(50,30,400,100);
					
					mb.setBounds(210,30,100,100);
					
					b.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							String num = null;
							num=JOptionPane.showInputDialog(null,"Enter Phone Number",num);
							if(num.isEmpty()){
								JOptionPane.showMessageDialog(null, "Invalid Phone Number");	
							}
							else
							{
								Connection con;
								try {
									con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
									Statement st=con.createStatement();
									String sql="update login1 set mobile='"+num+"'where name='"+n1+"'";
									int r=st.executeUpdate(sql);
									if(r!=0)
									{
										JOptionPane.showMessageDialog(null, "Mobile number updated successfully ");
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Mobile number updated was unsuccessful");
									}
									
								} catch (SQLException e) {
									e.printStackTrace();
								}
								
								
							}
							
						}
						
					});
					f.add(l1);
					f.add(mb);	
					f.add(b);
					f.add(p);
					f.setSize(400,400);
					f.setLayout(null);
					f.setLocationRelativeTo(null);
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					f.setVisible(true);

			}
		});
		JMenuItem mit2=new JMenuItem("Address");
		mit2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {

				JFrame f=new JFrame("Address info");
				JLabel l1,l2,pic;
				JPanel p;
				JButton b;
				b=new JButton("UPDATE");
				b.setBounds(150,120,100,20);
				b.setForeground(Color.DARK_GRAY);
				String a=null;
				p=new JPanel();
				pic=new JLabel();
				pic.setBounds(0,0,400,400);
				ImageIcon icon=new ImageIcon("C:\\Users\\Kaushik\\Pictures\\wallpapers\\p4YBAFa_2mCAKkj1AAFfftRaGlE53.jpeg");
				Image img=icon.getImage();
				Image newimg=img.getScaledInstance(pic.getWidth(),pic.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newicon=new ImageIcon(newimg);
				pic.setIcon(newicon);
				p.setBounds(0,0,400,400);
				p.add(pic);
				try{
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
				Statement st=con.createStatement();
				String sql="select *from login1 where name='"+n1+"'";
				ResultSet r=st.executeQuery(sql);
				if(r.next())
				{
					 a=r.getString("address");
				}
				}catch(Exception e){
						System.out.println(e);
					}
				 JLabel mb=new JLabel();
				 mb.setText(""+a);
				 f.getContentPane().setBackground(Color.lightGray);
				 l1=new JLabel("Address: ");
				 l1.setForeground(Color.GREEN);
				 mb.setForeground(Color.GREEN);
				 l1.setFont(new Font("Serif", Font.BOLD,15));
				 l1.setBounds(50,30,100,100);	
				 mb.setBounds(150,30,100,100);
					
					b.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							String num = null;
							num=JOptionPane.showInputDialog(null,"Enter address",num);
							if(num.isEmpty()){
								JOptionPane.showMessageDialog(null, "Invalid address");	
							}
							else
							{
								Connection con;
								try {
									con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
									Statement st=con.createStatement();
									String sql="update login1 set address='"+num+"'where name='"+n1+"'";
									int r=st.executeUpdate(sql);
									if(r!=0)
									{
										JOptionPane.showMessageDialog(null, "Address updated successfully ");
									}
									else
									{
										JOptionPane.showMessageDialog(null, "updated was unsuccessful");
									}
									
								} catch (SQLException e) {
									e.printStackTrace();
								}
								
								
							}
							
						}
						
					});
					f.add(l1);
					f.add(mb);	
					f.add(b);
					f.add(p);
					f.setSize(400,400);
					f.setLayout(null);
					f.setLocationRelativeTo(null);
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					f.setVisible(true);

			}
		});
		JMenuItem mit3=new JMenuItem("EXIT");
		
		file.add(mit);
		file.add(mit1);
		file.add(mit2);
		menu.add(file);
		file1.add(m1);
		file1.add(m2);
		//file1.add(m3);
		//file1.add(m4);
		file.add(file1);
		file.add(mit3);
		f.add(menu);
		f.setJMenuBar(menu);
		mit3.addActionListener((event)->System.exit(0));
}
}
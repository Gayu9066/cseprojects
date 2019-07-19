package shp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Wishlist  {
	
	JFrame f11;
	int logid;
	public Wishlist(int a){
		int i=0;
		logid=a;
		JLabel pic,imd,item,images,prices,price,cost;
		JButton b56,b1,buy;
		f11=new JFrame("WISH LIST");
		try{
			FileOutputStream f1=null;
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			PreparedStatement ps=con.prepareStatement("select *from wishlist where id='"+logid+"'");
			ResultSet r=ps.executeQuery();
			while(r.next()){
			Blob b=r.getBlob(1);
				int id=r.getInt(4);
				int pri=r.getInt(3);
				f1=new FileOutputStream("C://img/"+id+".jpg");
				int len =(int)b.length();
				byte buf[]=b.getBytes(1,len);
				f1.write(buf,0,len);
				pic=new JLabel();
				item=new JLabel("ITEMS");
				item.setForeground(Color.GREEN);
				images=new JLabel("ID");
				images.setForeground(Color.GREEN);
				imd=new JLabel(""+id);
				imd.setForeground(Color.MAGENTA);
				prices=new JLabel("Price");
				prices.setForeground(Color.GREEN);
				price=new JLabel(""+pri);
				price.setForeground(Color.MAGENTA);
				
				b56=new JButton();
				b1=new JButton("DELETE");
				buy=new JButton("BUY");
				pic.setBounds(0,0,100,100);
				String list[]={"C://img/"+id+".jpg"};
				ImageIcon icon=new ImageIcon(list[0]);
				java.awt.Image img=icon.getImage();
				java.awt.Image newimg=img.getScaledInstance(pic.getWidth(),pic.getHeight(),Image.SCALE_SMOOTH);
				icon=new ImageIcon(newimg);
				//pic.setIcon(icon);
				b56.setIcon(icon);
				b56.setBounds(0,30+i,100,100);
				b1.setBounds(280,140,100,30);
				buy.setBounds(280,190,100,30);
				imd.setBounds(140,70+i,30,10);
				item.setBounds(20,10,50,10);
				images.setBounds(140,10,30,10);
				prices.setBounds(170,10,30,10);
				price.setBounds(170,70+i,30,10);
				i=i+100;
				f11.add(b56);
				f11.add(b1);
				f11.add(buy);
				f11.add(imd);
				f11.add(item);
				f11.add(images);
				f11.add(price);
				f11.add(prices);
				b1.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Connection con;
						try {
							String num =null ;
							num=JOptionPane.showInputDialog(null,"Enter id to be deleted: ",num);
							if(num.isEmpty()){
								JOptionPane.showMessageDialog(null, "Invalid id");	
							}else{
								int a=Integer.parseInt(num);
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
							Statement st=con.createStatement();
							PreparedStatement ps=con.prepareStatement("delete from wishlist where id='"+logid+"'and imgno='"+a+"'");
							int i=ps.executeUpdate();
							if(i!=0){
								JOptionPane.showMessageDialog(null, "successfully deleted");	
							}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				});
				buy.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Connection con;
						try {
							int price,sum=0;
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
							PreparedStatement ps=con.prepareStatement("select price from wishlist where id='"+logid+"'");
							ResultSet r=ps.executeQuery();
							while(r.next()){
								 price=r.getInt("price");
								 sum=sum+price;
							}
							new Payment(sum);
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				});
				//f11.add(p);
				//f11.getContentPane().setBackground(Color.decode("#bdb67b"));
				f11.setSize(400,400);
				f11.setLayout(null);
				f11.setLocationRelativeTo(null);
				f11.setVisible(true);
				}
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

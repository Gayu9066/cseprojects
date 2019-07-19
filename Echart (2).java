package shp;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.*;
 
class EChart extends Jacket{
JFrame f;
JButton b,b1;
JLabel l,l1;
int logid2=0;
	public EChart(int num, int ab) {
		super(num, ab);
		chart1(num,ab);
	}
	void chart1(int num,int ab){
		f=new JFrame("description");
		ImageIcon icon=new ImageIcon(list1[num]);
		Image img=icon.getImage();
		b=new JButton();
		l=new JLabel();
		b.setBounds(0,0,100,100);
		b1=new JButton("Add");
		b1.setBounds(100,250,80,20);
		Image newimg=img.getScaledInstance(b.getWidth(),b.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newicon=new ImageIcon(newimg);
		l.setIcon(newicon);
		l.setBounds(10,10,100,100);
		logid2=ab;
		b1.addActionListener(new ActionListener(){
			
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			PreparedStatement ps=con.prepareStatement("insert into Wishlist(img,id,price) values(?,?,?)");
			ps.setInt(2, logid2);
			Random ra=new Random();
			int rup=ra.nextInt(2000);
			ps.setInt(3,rup);
			File fi=new File(list1[num]);
			FileInputStream fs=new FileInputStream(fi);
			ps.setBinaryStream(1,fs,(int)fi.length());
			int i=ps.executeUpdate();
			if(i!=0){
			JOptionPane.showMessageDialog(null, "Added to chart");
			con.close();}
			} 
		catch(Exception e){
			System.out.println(e);
			}
		
	}
	});
		f.add(l);
		f.add(b1);
		f.setLayout(null);
		f.setSize(400,400);
		f.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
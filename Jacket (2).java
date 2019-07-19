package shp;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Jacket extends JFrame{
	JLabel pic;
	JButton b,b1,b2,b3,b4,b5;
	JFrame f;
	JPanel p;
	int x=0;
	 int i1,logid1,sel;
	Timer tm;
	String[] list={
			"C:\\Users\\Kaushik\\Pictures\\merc-cloven-jacket-black-s.jpg",
			"C:\\Users\\Kaushik\\Pictures\\images.jpg" ,
			"C:\\Users\\Kaushik\\Pictures\\image.jpg" ,
			"C:\\Users\\Kaushik\\Pictures\\icon_jackets-textile_overlord_orange.jpg" ,
			"C:\\Users\\Kaushik\\Pictures\\M_Watches_HappyDimaonds_v1.jpgGraphic_Icon_Sweater_front_1000x.jpg"
			};
public	String[] list1={
				"C:\\Users\\Kaushik\\Pictures\\merc-cloven-jacket-black-s.jpg",
				"C:\\Users\\Kaushik\\Pictures\\icon-team-merc-blue-jacket-1-600x600.jpg",
				"C:\\Users\\Kaushik\\Pictures\\icon-merc-deployed-grey-camo-jacket-p4930-25136_image.jpg",
				"C:\\Users\\Kaushik\\Pictures\\image.jpg",
				"C:\\Users\\Kaushik\\Pictures\\Icon-Jacket_65542_001_hero.jpg"
				};
	 public Jacket(int a,int s){
		 //super("slideshow");
		 sel=s;
		 logid1=a;
		 f=new JFrame("TShirt");
		b=new JButton();
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		b4=new JButton();
		b5=new JButton();
		b.setBounds(0,0,400,100);
		b1.setBounds(0,120,100,100);
		b2.setBounds(140,120,100,100);
		b3.setBounds(260,120,100,100);
		b4.setBounds(0,240,100,100);
		b5.setBounds(140,240,100,100);
		setimage(4);
		tm =new Timer(1200,new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setimage(x);
				x=x+1;
				if(x>=list.length){
					x=0;
				}	
			}
		});
		
		f.add(b);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		tm.start();
		f.setLayout(null);
		f.setSize(400,400);
		f.getContentPane().setBackground(Color.decode("#bdb67b"));
		f.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
}
public void setimage(int i){
		ImageIcon icon=new ImageIcon(list[i]);
		ImageIcon icon1=new ImageIcon(list1[0]);
		ImageIcon icon2=new ImageIcon(list1[1]);
		ImageIcon icon3=new ImageIcon(list1[2]);
		ImageIcon icon4=new ImageIcon(list1[3]);
		ImageIcon icon5=new ImageIcon(list1[4]);
		
		Image img=icon.getImage();
		Image img1=icon1.getImage();
		Image img2=icon2.getImage();
		Image img3=icon3.getImage();
		Image img4=icon4.getImage();
		Image img5=icon5.getImage();
		
		Image newimg=img.getScaledInstance(b.getWidth(),b.getHeight(),Image.SCALE_SMOOTH);
		Image newimg1=img1.getScaledInstance(b1.getWidth(),b1.getHeight(),Image.SCALE_SMOOTH);
		Image newimg2=img2.getScaledInstance(b2.getWidth(),b2.getHeight(),Image.SCALE_SMOOTH);
		Image newimg3=img3.getScaledInstance(b3.getWidth(),b3.getHeight(),Image.SCALE_SMOOTH);
		Image newimg4=img4.getScaledInstance(b4.getWidth(),b4.getHeight(),Image.SCALE_SMOOTH);
		Image newimg5=img5.getScaledInstance(b5.getWidth(),b5.getHeight(),Image.SCALE_SMOOTH);
		
		ImageIcon newicon=new ImageIcon(newimg);
		ImageIcon newicon1=new ImageIcon(newimg1);
		ImageIcon newicon2=new ImageIcon(newimg2);
		ImageIcon newicon3=new ImageIcon(newimg3);
		ImageIcon newicon4=new ImageIcon(newimg4);
		ImageIcon newicon5=new ImageIcon(newimg5);
		
		b.setIcon(newicon);
		
		b1.setIcon(newicon1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new JChart(0,logid1);
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					new JChart(1,logid1);
			}
		});
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
					new JChart(2,logid1);
			}
		});
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			new JChart(3,logid1);
			}
		});
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new JChart(4,logid1);
			}
		});		
		b2.setIcon(newicon2);
		b3.setIcon(newicon3);
		b4.setIcon(newicon4);
		b5.setIcon(newicon5);
		}
}
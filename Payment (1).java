package shp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Payment  {
	JLabel l1,l2,l3,l4;
	JButton b,b1,b2;
	JTextField tf;
	JPasswordField ps;
	JFrame f=new JFrame("Payment form");
	public Payment(int sum)
	{
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
	l4=new JLabel("");
	b1=new JButton("Debit card");
	b1.setBounds(150,100,100,30);
	
	b1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
				JFrame f=new JFrame("PAYMENT FORM");
				l1=new JLabel("PAYMENT  FORM");
				l1.setForeground(Color.ORANGE);
				l1.setFont(new Font("Serif", Font.BOLD,20));
				l2=new JLabel("debit card no.");
				l3=new JLabel("Cvv");
				tf=new JTextField();
				ps =new JPasswordField();
				b=new JButton("Pay");
				l4.setText("Price : "+sum);
				b.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						try{
							String name=tf.getText();
							String pass=ps.getText();
							if(name.isEmpty()||pass.isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Invalid debit card or Cvv ");	
							}
							else {			
								Class.forName("com.mysql.jdbc.Driver");
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
								Statement st=con.createStatement();
								String sql = "select *from pay where debit='"+name+"'and cvv='"+pass+"'";
								ResultSet r=st.executeQuery(sql);
								if(r.next()){
									Random ran=new Random();
									int num=ran.nextInt(1000);
									String otp1 = null;
									JOptionPane.showMessageDialog(null,"OTP IS: "+num);
									int otp=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter OTP",otp1));
									if(otp==num)
									{
										JOptionPane.showMessageDialog(null, "Payment successful");
									}
									else
									{
										JOptionPane.showMessageDialog(null, " unsuccessful");
									}
								}
								else{
									JOptionPane.showMessageDialog(null, " wrong card no. or cvv");
								
								}
							}
						}catch(Exception e){
							System.out.println(e); }
					}
				});
				l1.setBounds(50,30,400,30);
				l2.setBounds(80,100,150,30);
				tf.setBounds(180,100,150,30);
				l3.setBounds(80,150,50,30);
				ps.setBounds(180,150,50,30);
				l4.setBounds(150,200,150,30);
				b.setBounds(150,290,100,30);
				
				l2.setForeground(Color.MAGENTA);
				l3.setForeground(Color.MAGENTA);
				l4.setForeground(Color.MAGENTA);
				b.setBackground(Color.lightGray);
				
				f.add(l1);
				f.add(l4);
				f.add(tf);
				f.add(l2);
				f.add(l3);
				f.add(ps);
				f.add(b);
				f.add(p);
				f.setSize(400,400);
				f.setLayout(null);
				f.setLocationRelativeTo(null);
				f.setVisible(true);

		}
	});
	b2=new JButton("Credit card");
	b2.setBounds(150,150,100,30);
	
	b2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame f=new JFrame("PAYMENT FORM");
			l1=new JLabel("PAYMENT  FORM");
			l1.setForeground(Color.ORANGE);
			l1.setFont(new Font("Serif", Font.BOLD,20));
			l2=new JLabel("credit card no.");
			l3=new JLabel("Cvv");
			tf=new JTextField();
			ps =new JPasswordField();
			b=new JButton("Pay");
			l4.setText("Price : "+sum);
			b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					try{
						String name=tf.getText();
						String pass=ps.getText();
						if(name.isEmpty()||pass.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Invalid debit card or Cvv ");	
						}
						else {			
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
							Statement st=con.createStatement();
							String sql = "select *from pay where debit='"+name+"'and cvv='"+pass+"'";
							ResultSet r=st.executeQuery(sql);
							if(r.next()){
								Random ran=new Random();
								int num=ran.nextInt(1000);
								String otp1 = null;
								JOptionPane.showMessageDialog(null,"OTP IS: "+num);
								int otp=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter OTP",otp1));
								if(otp==num)
								{
									JOptionPane.showMessageDialog(null, "Payment successful");
								}
								else
								{
									JOptionPane.showMessageDialog(null, " unsuccessful");
								}
							}
							else{
								JOptionPane.showMessageDialog(null, " wrong card no. or cvv");
							
							}
						}
					}catch(Exception e){
						System.out.println(e); }
				}
			});
			l1.setBounds(50,30,400,30);
			l2.setBounds(80,100,150,30);
			tf.setBounds(180,100,150,30);
			l3.setBounds(80,150,50,30);
			ps.setBounds(180,150,50,30);
			l4.setBounds(150,200,150,30);
			b.setBounds(150,290,100,30);
			
			l2.setForeground(Color.MAGENTA);
			l3.setForeground(Color.MAGENTA);
			l4.setForeground(Color.MAGENTA);
			b.setBackground(Color.lightGray);
			
			f.add(l1);
			f.add(l4);
			f.add(tf);
			f.add(l2);
			f.add(l3);
			f.add(ps);
			f.add(b);
			f.add(p);
			f.setSize(400,400);
			f.setLayout(null);
			f.setLocationRelativeTo(null);
			f.setVisible(true);

	}
});
	f.add(b1);
	f.add(b2);
	f.add(p);
	f.setSize(400,400);
	f.setLayout(null);
	f.setLocationRelativeTo(null);
	f.setVisible(true);

	
}

	/*public static void main(String[] args) {
new Payment(10);

	}*/

}

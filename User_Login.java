package quiz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Admin.DateBaseConnection;

class User_Login 
{
	JFrame jf=new JFrame("User Login Page");
	
	JPanel jp=new JPanel();
	JLabel un=new JLabel("Email Id");
	JTextField tfun=new JTextField();
	JLabel pass=new JLabel("Password");
	JPasswordField tfpass=new JPasswordField();
	JButton log=new JButton("Login");
	JButton res=new JButton("Reset");
	JButton sin=new JButton("Sign Up");
	JButton fpass=new JButton("Forgot Password ??");
	JButton ext=new JButton("Exit");
	
	
	 User_Login() 
	{
		    jp.setLayout(null);

		    un.setBounds(800,200,100,30);
			jp.add(un);//un=username
			
			tfun.setBounds(900,200,150,30);
			jp.add(tfun);//tfun=textfield username
			
			
			pass.setBounds(800,260,100,30);
			jp.add(pass);//pass=password
			
			tfpass.setBounds(900,260,150,30);
			jp.add(tfpass);//tfpass=textfield password
			tfpass.addKeyListener(new login());
			
			
			log.setBounds(800,350,100, 30);
			jf.add(log);
			log.addActionListener(new login());
			log.addKeyListener(new login());
			
			
			
			res.setBounds(950,350,100, 30);
			jf.add(res);
			res.addActionListener(new reset());
			
			sin.setBounds(800,420,100, 30);
			jf.add(sin);
			sin.addActionListener(new sinup());
			
			fpass.setBounds(950,420,150, 30);
			jf.add(fpass);
			fpass.addActionListener(new Forgot_pass());
			
			ext.setBounds(1200,30,100,30);
			jp.add(ext);
			ext.addActionListener(new exitt());
			


		 jf.add(jp);
		 jf.setSize(1400,800);
		 jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		 jf.setVisible(true);
	}
	 
	 class exitt implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			jf.dispose();
			new Start_up();
			
		}
		 
	 }
	 
	 class User_login extends JPanel
	 {
		 public void paintComponent(Graphics g)
		 {
			Image ii= Toolkit.getDefaultToolkit().getImage("img/IMG_5069.JPG"); 
			// Image ii=new ImageIcon("img/IMG_5069.JPG").getImage();
			 g.drawImage(ii,0,0,this.getWidth(),this.getHeight(),this);
			 
		 }
	 }
	 
	
	 class login implements ActionListener,KeyListener
	 {
		 Override actionOverride;

		@Override
		public void actionPerformed(ActionEvent E) 
		{
			String usernm=tfun.getText();
			String passwrd=tfpass.getText();
			
			
			Connection conn=DateBaseConnection.javaConnection();
			try
			{
				Statement st=conn.createStatement();
				String query="select * from user_info where email_id='"+usernm+"' and password='"+passwrd+"'";
				ResultSet rr=st.executeQuery(query);
				if(rr.next())
				{
					new User_Welcome(rr.getInt("id"),rr.getString("full_name"));
					jf.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"username and password did not match");
				}
			
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}

			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			int j=arg0.getKeyCode();
			if(j==arg0.VK_ENTER);
			{
			String usernm=tfun.getText();
			String passwrd=tfpass.getText();
			
			
			Connection conn=DateBaseConnection.javaConnection();
			try
			{
				Statement st=conn.createStatement();
				String query="select * from user_info where email_id='"+usernm+"' and password='"+passwrd+"'";
				ResultSet rr=st.executeQuery(query);
				if(rr.next())
				{
					new User_Welcome(rr.getInt("id"),rr.getString("full_name"));
					jf.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"username and password did not match");
				}
			
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
			
		}
	}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	 }

	 class reset implements ActionListener
	 {
		 Override actionOverride;

		@Override
		public void actionPerformed(ActionEvent E) 
		{
			
			
			 tfun.setText(null);
			 tfpass.setText(null);
			 
		} 
		
		 
	 }
	 
	 class Forgot_pass implements ActionListener
	 {
		 Override actionOverride;

		@Override
		public void actionPerformed(ActionEvent E) 
		{
			
			//sin.addActionListener(null);
			new Forgot_password();
			jf.dispose();
			
		} 
		
		 
	 }
	 
	 class sinup implements ActionListener
	 {
		 Override actionOverride;

		@Override
		public void actionPerformed(ActionEvent E) 
		{
			
			//sin.addActionListener(null);
			new sign_up();
			jf.dispose();
			
		} 
		
		 
	 }
}

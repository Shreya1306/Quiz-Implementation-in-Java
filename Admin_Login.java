package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.text.PasswordView;

import quiz.User_Login.exitt;




class Admin_Login 
{
	JFrame jf=new JFrame("Admin Login Page");
	JLabel un=new JLabel("Username");
	JTextField tfun=new JTextField();
	JLabel pass=new JLabel("Password");
	JPasswordField tfpass=new JPasswordField();
	JButton log=new JButton("Login");
	JButton res=new JButton("Reset");
	JButton ext=new JButton("Exit");
	
	Admin_Login()
	{
	
	
	//JFrame jf=new JFrame("Admin Login Page");
	
	JPanel jp=new JPanel();
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
				String query="select * from admin_info where User_name='"+usernm+"' and password='"+passwrd+"'";
				ResultSet rr=st.executeQuery(query);
				if(rr.next())
				{
					new Admin_welcome();
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
			if(j==arg0.VK_ENTER)
			{
				String usernm=tfun.getText();
				String passwrd=tfpass.getText();
				
				
				Connection conn=DateBaseConnection.javaConnection();
				try
				{
					Statement st=conn.createStatement();
					String query="select * from admin_info where User_name='"+usernm+"' and password='"+passwrd+"'";
					ResultSet rr=st.executeQuery(query);
					if(rr.next())
					{
						new Admin_welcome();
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

	
}

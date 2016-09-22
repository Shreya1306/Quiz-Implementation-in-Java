package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Start_up {
	
	JFrame jf=new JFrame("");

	 JPanel jp=new JPanel();
	 JButton ad,usr;
	
	public Start_up() {
		
		jp.setLayout(null);
		
		ad=new JButton("Admin Login");
		ad.setBounds(400,300,200,30);
		jp.add(ad);
		ad.addActionListener(new admin_log());
		
		usr=new JButton("User Login");
		usr.setBounds(700,300,100,30);
		jp.add(usr);
		usr.addActionListener(new user_log());
		
		
		
		jf.add(jp);
		jf.setSize(1400,800);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
	}
	
	class admin_log implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			jf.dispose();
			new Admin_Login();
			
		}
		
	}
	
	class user_log implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			jf.dispose();
			new User_Login();
			
		}
		
	}

}

package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

class Change_password 
{
	
	JFrame jf=new JFrame("Change Password");

	JPanel jp=new JPanel();
	JButton logout=new JButton("Logout");
	JButton bk=new JButton("Back");
	JLabel odpass=new JLabel("Old Password");
	JPasswordField tfod=new JPasswordField();
	JLabel nwpass=new JLabel("New Password");
	JPasswordField tfnw=new JPasswordField();
	JLabel cfpass=new JLabel("Confirm Password");
	JPasswordField tfcf=new JPasswordField();
	JButton ch=new JButton("Change");
	JButton res=new JButton("Reset");

		Change_password() 
	{
		
	
	
	jp.setLayout(null);
	
	
	logout.setBounds(1200,20,80, 30);
	jp.add(logout);
	logout.addActionListener(new logout());//logout

	
	bk.setBounds(1000,20,70, 30);
	jp.add(bk);
	bk.addActionListener(new back());//back buttun

	
	odpass.setBounds(300,200,130, 30);
	jp.add(odpass);
	tfod.setBounds(450,200,150,30);
	jp.add(tfod);
	
	nwpass.setBounds(300,250,130, 30);
	jp.add(nwpass);
	tfnw.setBounds(450, 250,150,30);
	jp.add(tfnw);
	
	cfpass.setBounds(300,300,130, 30);
	jp.add(cfpass);
	tfcf.setBounds(450, 300,150,30);
	jp.add(tfcf);
	
	ch.setBounds(350,450,90, 30);
	jp.add(ch);
	ch.addActionListener(new pass());
	
	res.setBounds(700,450,70, 30);
	jp.add(res);
	
	




	jf.add(jp);
	jf.setSize(1400,800);
	jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	jf.setVisible(true);
	
	}
		
		class pass implements ActionListener
		 {
			 Override actionOverride;

			@Override
			public void actionPerformed(ActionEvent E) 
			{
				String oldpas=tfod.getText();
				String newpas=tfnw.getText();
				String conpas=tfcf.getText();
				
				Connection conn=DateBaseConnection.javaConnection();
				if(newpas .equals(conpas))
				{
				try
				{
					Statement st=conn.createStatement();
					String query="Update admin_info set password='"+newpas+"' where password='"+oldpas+"' ";
					int rr=st.executeUpdate(query);
					
						if(rr==1)
						{
							new Admin_welcome();
							jf.dispose();
							JOptionPane.showMessageDialog(null," Password was changed successfully...");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"old password did not match");
							new Change_password();
							jf.dispose();
						}
					
					
						
					
					
				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}

				}
				else
				{
					JOptionPane.showMessageDialog(null,"new password and confirm passwords did not match ");
					jf.dispose();
					new Change_password();
				}
			}
		 }
		class back implements ActionListener
		 {
			@Override
			public void actionPerformed(ActionEvent arg0) 
		 	{
				
			 jf.dispose();
			 new Admin_welcome();
				
			}
			 
		 }
		 
		 class logout implements ActionListener
		 {
			@Override
			public void actionPerformed(ActionEvent arg0) 
		 	{
				
			 jf.dispose();
			 new Admin_Login();
				
			}
			 
		 }
		
	
}

package quiz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Admin.DateBaseConnection;


	class feedback {
		
		 JFrame jf=new JFrame("Feedback");

		 JPanel jp=new JPanel();
		 JButton logout=new JButton("Logout");
		 JButton bk=new JButton("Back");
		 JButton sv=new JButton("Save");
		 JLabel fd=new JLabel("We would be pleased to have your feedback..");
		 JTextArea ta=new JTextArea();
		 int id;
		 String name;
		 
		
		 		feedback(int i,String nm) {
		 			
		 		id=i;
		 		name=nm;
			 jp.setLayout(null);
			
			 Font f=new Font("Casteller",Font.ROMAN_BASELINE,16);
			 
			 
			 fd.setBounds(200,200,400,30);
			 jp.add(fd);
			 fd.setFont(f);
			 
			 ta.setBounds(250,300,400,150);
			 jp.add(ta);
			 
			 	logout.setBounds(1200,20,80, 30);
				jp.add(logout);
				logout.addActionListener(new logout());//logout
				
				bk.setBounds(1000,20,70, 30);
				jp.add(bk);
				bk.addActionListener(new back());//back buttun
			 
			 sv.setBounds(400,500,70,30);
			 jp.add(sv);
			 sv.addActionListener(new save());
			 


				jf.add(jp);
				jf.setSize(1400,800);
				jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
				jf.setVisible(true);
			
		}
		 	
		 		 class save implements ActionListener
				 {
					@Override
					public void actionPerformed(ActionEvent arg0) 
				 	{
						
					 String fed=ta.getText();
					// System.out.println(fed);
					 if(fed.equals(""))
					 {
						 JOptionPane.showMessageDialog(null,"Your feedback is empty");
						 
					 }
					 else
					 {
					 
						 Connection cnt= DateBaseConnection.javaConnection();
						try {
							Statement st= cnt.createStatement();
							String qq="insert into user_feedback (user_id,Name,feedback) values('"+id+"','"+name+"','"+fed+"')";
							int rr= st.executeUpdate(qq);
							if(rr==1)
							{
								JOptionPane.showMessageDialog(null,"Your response is added");
								jf.dispose();
								new thank(id,name);
							}
						}
						catch(SQLException e)
						{
							new thank(id,name);
							jf.dispose();
						}
							
							
					}
				 	}
					 
				 }
		 
		 class back implements ActionListener
		 {
			@Override
			public void actionPerformed(ActionEvent arg0) 
		 	{
				
			 jf.dispose();
			 new User_Welcome(id,name);
				
			}
			 
		 }
		 
		 class logout implements ActionListener
		 {
			@Override
			public void actionPerformed(ActionEvent arg0) 
		 	{
				
			 jf.dispose();
			 new User_Login();
				
			}
			 
		 }


}

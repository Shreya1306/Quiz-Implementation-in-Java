package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class hello {
	public static void main(String[] args) {
		Admin_welcome ad=new Admin_welcome();
	}
}
 class Admin_welcome {
	 JFrame jf=new JFrame("Admin Welcome Page");
	 JPanel jp=new JPanel();
	 JLabel wel=new JLabel("Welcome \n Miss Astha..");
	 JButton logout=new JButton("Logout");
	 JButton chpass=new JButton("Change Password");
	 JButton addq=new JButton("Add Question");
	 JButton editq=new JButton("Delete Question");
	 JButton std=new JButton("View Student Details");
	 JButton fb=new JButton("Show Feedback");
	
	 ArrayList<list> show=new ArrayList<list>();
	 
	 Admin_welcome()
	 {
		
		

		
		jp.setLayout(null);
		
		
		wel.setBounds(50, 30, 200, 100);
		jp.add(wel);
		
		
		logout.setBounds(1200,50,90, 30);
		jp.add(logout);
		logout.addActionListener(new logout());
		
		
		chpass.setBounds(220, 340,140,30);
		jp.add(chpass);
		chpass.addActionListener(new change_pass() );
		
		
		addq.setBounds(220,220,140,30);
		jp.add(addq);
		addq.addActionListener(new add_ques());
		
		
		editq.setBounds(220, 160,180,30);
		jp.add(editq);
		editq.addActionListener(new edit());
		
		
		std.setBounds(220,400,180,30);
		jp.add(std);
		std.addActionListener(new student_rec());
		
		
		fb.setBounds(220, 280,140,30);
		jp.add(fb);//show feedback
		fb.addActionListener(new feed());
		
		
		jf.add(jp);
		jf.setSize(1400,800);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
	}
	 
	 class feed implements ActionListener
	 {
		 Override actionOverride;

		@Override
		public void actionPerformed(ActionEvent E) 
		{
			
			ArrayList<list> fed=new ArrayList<list>();
			Connection cnt= DateBaseConnection.javaConnection();
			try {
				Statement st= cnt.createStatement();
				String qq="select * from user_feedback";
				ResultSet rr= st.executeQuery(qq);
				while(rr.next())
				{
					list q= new list();
					q.setId(rr.getString("user_id"));
					q.setName(rr.getString("Name"));
					q.setFeed(rr.getString("feedback"));
					
					fed.add(q);
			
				}
				
				jf.dispose();
				new Show_feedback(fed);
			}	
				catch (SQLException e) 
				{
					jf.dispose();
					e.printStackTrace();
				}
			
		}
	 }
	 
	 
	 class add_ques implements ActionListener
	 {
		 Override actionOverride;

		@Override
		public void actionPerformed(ActionEvent E) 
		{
			new Add_Question();
			jf.dispose();
			
		}
	 }
	 
	 class student_rec implements ActionListener
	 {
		 Override actionOverride;

		@Override
		public void actionPerformed(ActionEvent E) 
		{
			ArrayList<list> user=new ArrayList<list>();
			Connection cnt= DateBaseConnection.javaConnection();
			try {
				Statement st= cnt.createStatement();
				String qq="select * from result";
				ResultSet rr= st.executeQuery(qq);
				while(rr.next())
				{
					list q= new list();
					q.setName(rr.getString("Name"));
					q.setId(rr.getString("user_id"));
					q.setCat(rr.getString("catagory"));
					q.setDate(rr.getString("Date"));
					q.setLevel(rr.getString("level"));
					q.setMarks(rr.getString("Marks_obtained"));
					
					user.add(q);
			
				}
				
				jf.dispose();
				new Student_record(user);
			}	
				catch (SQLException e) 
				{
					jf.dispose();
					e.printStackTrace();
				}
		
	 }
}
	 
	 class edit implements ActionListener
	 {
		 Override actionOverride;

		@Override
		public void actionPerformed(ActionEvent E) 
		{
			new Edit_Remove_question(show);
			jf.dispose();
		}
	 }
	 
	 class change_pass implements ActionListener
	 {
		 Override actionOverride;

		@Override
		public void actionPerformed(ActionEvent E) 
		{
			new Change_password();
			jf.dispose();
		}
	 }
	 
	 class logout implements ActionListener
	 {
		 Override actionOverride;

		@Override
		public void actionPerformed(ActionEvent E) 
		{
			new Admin_Login();
			jf.dispose();
		}

	 }
 }
 

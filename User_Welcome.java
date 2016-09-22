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

import Admin.DateBaseConnection;

class User_Welcome 
{
	JFrame jf=new JFrame("User Welcome Page");

	JPanel jp=new JPanel();
	
	JLabel wel;
	 JButton logout=new JButton("Logout");
	 JButton quiz=new JButton("Start Quiz");
	 
	 JButton prsnl=new JButton("Personal Details");
	 JButton fd=new JButton("Leave Feedback");
	 JButton cont=new JButton("Contact us");
	 int id;
	 String full_name;
	 	@SuppressWarnings("static-access")
		User_Welcome(int i,String nm) 
	{
	 		id=i;
	 		full_name=nm;
		jp.setLayout(null);
		wel=new JLabel("Welcome   "+full_name);

		wel.setBounds(50, 30, 200, 100);
		jp.add(wel);
		
		
		logout.setBounds(1200,50,90, 30);
		jp.add(logout);
		logout.addActionListener(new logout());
		
		quiz.setBounds(600,250,100,30);
		jp.add(quiz);
		quiz.addActionListener(new startQuiz());
		
		prsnl.setBounds(40,120,130,30);
		//jp.add(prsnl);
		
		
		fd.setBounds(1100,650,130,30);
		jp.add(fd);
		fd.addActionListener(new feed());
		
		cont.setBounds(900,650,120,30);
		jp.add(cont);
		cont.addActionListener(new contact());
		
		
		
		


		jf.add(jp);
		jf.setSize(1400,800);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	 	
	 	class contact implements ActionListener
	 	{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				jf.dispose();
				new Contact(id,full_name);
				
			}
	 		
	 	}
	 	class feed implements ActionListener
	 	{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				jf.dispose();
				new feedback(id,full_name);
				
			}
	 		
	 	}
	 	
	 	class details implements ActionListener
		 {
			 Override actionOverride;
			 ArrayList<Quizlist> detail=new ArrayList<Quizlist>();

			public void actionPerformed(ActionEvent E)
			{
				//ArrayList<list> detail=new ArrayList<list>();
				Connection cnt= DateBaseConnection.javaConnection();
				try {
					Statement st= cnt.createStatement();
					String qq="select * from result";
					ResultSet rr= st.executeQuery(qq);
					Quizlist d= new Quizlist();
					while(rr.next())
					{
						d.setMks(rr.getString("Marks_obtained"));
						d.setInc_ques(rr.getString("incorrect_response"));
						d.setName(rr.getString("Name"));
						d.setCat(rr.getString("catagory"));
						d.setDt(rr.getString("Date"));
						d.setLvl(rr.getString("level"));
						d.setId(rr.getString("user_id"));
						
					}
				}
				catch(SQLException e)
				{
					new Personal_details(detail);
					jf.dispose();
				}
         }
			}
	 	
	 	
	 	
	 	class startQuiz implements ActionListener
		 {
			 Override actionOverride;


			public void actionPerformed(ActionEvent E)
			{
				new instructions(id,full_name);
				jf.dispose();
			}
}
	 	
	 	 class logout implements ActionListener
		 {
			 Override actionOverride;

			@Override
			public void actionPerformed(ActionEvent E)
			{
				new User_Login();
				jf.dispose();
			}
}
}

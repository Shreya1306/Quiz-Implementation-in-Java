package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Admin.DateBaseConnection;





 class Start_quiz 
{
	 JFrame jf=new JFrame("Start my Quiz");

	 JPanel jp=new JPanel();
	 JLabel wel;           
	 JButton logout=new JButton("Logout");
	 JButton quiz=new JButton("Start Quiz");
	
	 JButton prsnl=new JButton("Personal Details");
	 JButton bk=new JButton("Back");
	 
	 JLabel cat=new JLabel("Select Catagory");
	 JComboBox cct=new JComboBox();
	 JLabel lv=new JLabel("Select Level");
	 JComboBox clv=new JComboBox();
	
	 int id;
	 String full_name;
	 
	 public Start_quiz(int i,String nm) 
	{
		 id=i;
		 full_name=nm;
		 jp.setLayout(null);
		 
		 wel=new JLabel("Welcome"+full_name);

		    wel.setBounds(50, 30, 200, 100);
			jp.add(wel);
		 
			logout.setBounds(1200,50,90, 30);
			jp.add(logout);
			logout.addActionListener(new logout());
			
			
			bk.setBounds(1000,50,70, 30);
			jp.add(bk);
			bk.addActionListener(new back());
			
			quiz.setBounds(600,250,100,30);
			jp.add(quiz);
			quiz.addActionListener(new startQuiz());
			
			prsnl.setBounds(40,120,130,30);
			//jp.add(prsnl);
			
			
			cat.setBounds(500,350,100,30);
			jp.add(cat);
			
			lv.setBounds(500,400,100,30);
			jp.add(lv);
			
			cct.setBounds(700,350,100,30);
			cct.addItem("Physics");
			cct.addItem("Mathematics");
			cct.addItem("Chemistry");
			cct.addItem("Aptitude");
			cct.addItem("English");
			jp.add(cct);
			
			clv.setBounds(700,400,100,30);
			clv.addItem("Easy");
			clv.addItem("Average");
			clv.addItem("Hard");
			jp.add(clv);
			
			
			
			jf.add(jp);
			jf.setSize(1400,800);
			jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
			jf.setVisible(true);
	}
	 
	 
	 
	 class startQuiz implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<Quizlist> qlist= new ArrayList<Quizlist>();
				String cat= (String) cct.getSelectedItem();
				String lvl=(String)clv.getSelectedItem();
				
				Connection cnt= DateBaseConnection.javaConnection();
				try {
					Statement st= cnt.createStatement();
					String qq="select * from questions where catagory='"+cat+"' and level='"+lvl+"'";
					ResultSet rr= st.executeQuery(qq);
					while(rr.next())
					{
						Quizlist q= new Quizlist();
						q.setQid(rr.getString("s_num"));
						q.setQues(rr.getString("question"));
						q.setOp_A(rr.getString("option_A"));
						q.setOp_B(rr.getString("option_B"));
						q.setOp_C(rr.getString("option_C"));
						q.setOP_D(rr.getString("option_D"));
						q.setAns(rr.getString("answer"));
						
						qlist.add(q);
						
					}
					new Play(id,full_name,cat,lvl,qlist);
				} catch (SQLException e) 
				{
					jf.dispose();
					e.printStackTrace();
				}
				
		}
			
		}
	 class back implements ActionListener
	 {
		@Override
		public void actionPerformed(ActionEvent arg0) 
	 	{
			
		 jf.dispose();
		 new instructions(id,full_name);
			
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

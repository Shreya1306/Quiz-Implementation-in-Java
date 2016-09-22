package quiz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import quiz.Start_quiz.back;
import quiz.Start_quiz.logout;

	class instructions {
		
		JFrame jf=new JFrame("Instructions");
		JPanel jp=new JPanel();
		JLabel ins=new JLabel("Instructions Of The Quiz");
		JLabel lb,in1,in2,in3,in4;
		 JButton logout=new JButton("Logout");
		 JButton bk=new JButton("Back");
		 String name;
		 int id;
		 JButton go=new JButton("Get Set Go");
		
	
			instructions(int k,String nm) {
				
				jp.setLayout(null);
				id=k;
				name=nm;
				Font f=new Font("Casteller",Font.ROMAN_BASELINE,22);
				
				
				ins.setBounds(150,150,300,30);
				jp.add(ins);
				ins.setFont(f);
				
				logout.setBounds(1200,50,90, 30);
				jp.add(logout);
				logout.addActionListener(new logout());
				
				
				bk.setBounds(1000,50,70, 30);
				jp.add(bk);
				bk.addActionListener(new back());
				
				
				int j=200;			
				for(int i=1;i<5;i++)
				{
					lb=new JLabel(i+".");
					lb.setBounds(150,j,30,30);
					jp.add(lb);
					j=j+40;
				}
				in1=new JLabel("Candidates would not allowed to go back to any previous question.");
				in1.setBounds(180,200,600,30);
				jp.add(in1);
				
				in2=new JLabel("Once you start your quiz you will not be allowed to change youe catagory and level.");
				in2.setBounds(180,240,600,30);
				jp.add(in2);
				
				in3=new JLabel("You are not allowed to reset your response so,choose wisely.");
				in3.setBounds(180,280,600,30);
				jp.add(in3);
				
				in4=new JLabel("Remmember , Until you Traverse all the questions your result will not be generated.");
				in4.setBounds(180,320, 600,30);
				jp.add(in4);
				
				go.setBounds(500,500,200,30);
				jp.add(go);
				go.addActionListener(new strt());
				
				
				
				
				jf.add(jp);
				jf.setSize(1400,800);
				jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
				jf.setVisible(true);
		
	}
			class strt implements ActionListener
			 {
				@Override
				public void actionPerformed(ActionEvent arg0) 
			 	{
					
				 jf.dispose();
				 new Start_quiz(id,name);
					
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

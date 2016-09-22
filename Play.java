package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Admin.DateBaseConnection;







		class Play 
{

			 JFrame jf=new JFrame("Quiz");
			JPanel jp=new JPanel();
			
			JButton ext=new JButton("Exit Quiz");
			//JButton bk=new JButton("Back");
			
			JLabel que=new JLabel("Question");
			JLabel ques;
			JLabel op=new JLabel("Options");
			JRadioButton a=new JRadioButton();
			JLabel tfa;
			JLabel tfb;
			JRadioButton b=new JRadioButton();
			JRadioButton c=new JRadioButton();
			JLabel tfc;
			JRadioButton d=new JRadioButton();
			ButtonGroup bg=new ButtonGroup();
			
			JLabel tfd;
			
			JButton nxt=new JButton("NEXT");
						
			ArrayList<Quizlist> qlist;
			Quizlist qlst;
			int id;
			String full_name,cat,level;
			
		
	
	Play(int i,String nm,String ct,String l,ArrayList<Quizlist> q)
	{
		
		
		jp.setLayout(null);
		
		
		id=i;
		full_name=nm;
		cat=ct;
		level=l;
		qlist=q;
		qlst=q.get(0);
		System.out.println(qlist.size());
		 
	    
		
		
//		bk.setBounds(1000,20,70, 30);
//		jp.add(bk);
//		bk.addActionListener(new back());//back buttun
		
		
		
		que.setBounds(300,210,120,30);
		jp.add(que);
		ques=new JLabel(qlst.getQues());
		ques.setBounds(450,200,200,70);
		jp.add(ques);
		
		op.setBounds(300,300,100,30);
		jp.add(op);
		a.setBounds(420,300,30,30);
		jp.add(a);
		tfa=new JLabel(qlst.getOp_A());
		tfa.setBounds(450, 300,150,30);
		jp.add(tfa);
		
		
		
		
		b.setBounds(420,360,30,30);
		jp.add(b);
		
		tfb=new JLabel(qlst.getOp_B());
		tfb.setBounds(450, 360,150,30);
		jp.add(tfb);
		
		
		c.setBounds(420,420,30,30);
		jp.add(c);
		
		tfc=new JLabel(qlst.getOp_C());
		tfc.setBounds(450, 420,150,30);
		jp.add(tfc);
		
		
		d.setBounds(420,480,30,30);
		jp.add(d);
		
		tfd=new JLabel(qlst.getOP_D());
		tfd.setBounds(450, 480,150,30);
		jp.add(tfd);
		
		bg.add(a);
		bg.add(b);
		bg.add(c);
		bg.add(d);
								
		nxt.setBounds(400,570,70, 30);
		jp.add(nxt);
		nxt.addActionListener(new NxtBtn());
		
		ext.setBounds(900,570,100, 30);
		jp.add(ext);
		ext.addActionListener(new exit_quiz());//exit
		
		
		
	
	 jf.add(jp);
	 jf.setSize(1400,800);
	 jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	 jf.setVisible(true);
	}
	
//	class prev implements ActionListener
//	{
//		int i; 
//			prev(int p) {
//			i=p;
//			
//		}
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			Connection cnt= DateBaseConnection.javaConnection();
//			if(i>0)
//			{
//			try {
//				qlst= qlist.get(i-1);
//				ques.setText(qlst.getQues());
//				tfa.setText(qlst.getOp_A());
//				tfb.setText(qlst.getOp_B());
//				tfc.setText(qlst.getOp_C());
//				tfd.setText(qlst.getOP_D());
//				i=i-1;
//				System.out.println(i);
//				//i++;
//				bg.clearSelection();
//			}
//			
//			
//			
//		 	catch (IndexOutOfBoundsException ii) 
//		 	{
//				
//			ii.printStackTrace();
//			}
//		}
//		}
//				
//	}
//	
//	
	class NxtBtn implements ActionListener
	{ 
		int i=1,count=0,q_left=0;
		
			
		public void actionPerformed(ActionEvent arg0) {
			
			JLabel lb=new JLabel("Question "+i+" of 10 ");
			lb.setBounds(200,200,200,30);
			jf.add(lb);
			
			Connection cnt= DateBaseConnection.javaConnection();	
			
			try
			{
			 
			String anss="";
				if(a.isSelected())
				{
					anss="A";
				}
				else if(b.isSelected())
				{
					anss="B";
				}
				else if(c.isSelected())
				{
					anss="C";
				}
				else if(d.isSelected())
				{
					anss="D";
				}
				else
				{
					q_left++;
				}
				
				
				try {
					Statement st= cnt.createStatement();
					String qq="select * from questions where s_num='"+qlst.getQid()+"' and answer='"+anss+"'";
					ResultSet rr= st.executeQuery(qq);
					if(rr.next())
					{
						 count++;
						
					}
					
					 
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
//				if(i>0){
//					JButton prev=new JButton("Previous");
//					prev.setBounds(150,450,100,30);
//					jp.add(prev);
//					//prev.addActionListener(new prev(i));
//					
				
				qlst= qlist.get(i);
				ques.setText(qlst.getQues());
				tfa.setText(qlst.getOp_A());
				tfb.setText(qlst.getOp_B());
				tfc.setText(qlst.getOp_C());
				tfd.setText(qlst.getOP_D());
				i++;
				bg.clearSelection();
			}
			catch(IndexOutOfBoundsException ii)
			{
				JOptionPane.showMessageDialog(null, "Quiz is over, you have got "+count+" marks");
				try {
					java.util.Date date=new java.util.Date();
					Statement st= cnt.createStatement();
					String qq="insert into result(Name,catagory,level,questions_attempted,incorrect_responses,Marks_obtained,Date,user_id) values ('"+full_name+"','"+cat+"','"+level+"','"+(10-q_left)+"','"+(10-(count+q_left))+"','"+count+"','"+date+"','"+id+"')";
					int r= st.executeUpdate(qq);
					if(r==1)
					{
						JOptionPane.showMessageDialog(null, "Result is updated");
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				
				jf.dispose();
				//new Play(id,full_name,qlist);
			}
			
			
			
			
		}
		
	}
	 
	 class exit_quiz implements ActionListener
	 {
		@Override
		public void actionPerformed(ActionEvent arg0) 
	 	{
			
		int ans= JOptionPane.showConfirmDialog(null,"Do you really want to exit?");
		// System.out.println(ans);
		 if(ans==0)
		 {
			 jf.dispose();
			  new thank(id,full_name);
		 }

			
		}
		 
	 }

}

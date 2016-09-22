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



public class Edit_Question 
{

	 JFrame jf=new JFrame("Add Question frame");
	JPanel jp=new JPanel();
	
	JButton logout=new JButton("Logout");
	JButton bk=new JButton("Back");
	JLabel que=new JLabel("New Question");
	JTextField ques;
	JLabel op=new JLabel("Options");
	JRadioButton a=new JRadioButton();
	JTextField tfa;
	JTextField tfb;
	JRadioButton b=new JRadioButton();
	JRadioButton c=new JRadioButton();
	JTextField tfc;
	JRadioButton d=new JRadioButton();
	ButtonGroup bg=new ButtonGroup();
	
	JButton nxt=new JButton("Next");
	
	JTextField tfd;
	
	JButton add=new JButton("Save");
	ArrayList<list> show;
	 list lst;
	 String id;

	
	public Edit_Question(ArrayList<list> l) 
	{
		 jp.setLayout(null);
		 show=l;
		 //id=i;
		 lst=l.get(0);
		    
			logout.setBounds(400,20,80, 30);
			jp.add(logout);
			logout.addActionListener(new logout());//logout
			
			bk.setBounds(300,20,70, 30);
			jp.add(bk);
			bk.addActionListener(new back());//back buttun
			
			que.setBounds(40,150,120,30);
			jp.add(que);
			
			ques=new JTextField(lst.getQues());
			ques.setBounds(150,150,200,70);
			jp.add(ques);
			
			
			
			op.setBounds(40,240,120,30);
			jp.add(op);
			
			a.setBounds(150,240,30,30);
			jp.add(a);
			
			tfa=new JTextField(lst.getOp_A());
			tfa.setBounds(190, 240,150,30);
			jp.add(tfa);
			
			b.setBounds(150,280,30,30);
			jp.add(b);
			
			tfb=new JTextField(lst.getOp_B());
			tfb.setBounds(190, 280,150,30);
			jp.add(tfb);
			
			c.setBounds(150,320,30,30);
			jp.add(c);
			
			tfc=new JTextField(lst.getOp_C());
			tfc.setBounds(190, 320,150,30);
			jp.add(tfc);
			
			d.setBounds(150,360,30,30);
			jp.add(d);
			
			tfd=new JTextField(lst.getOp_D());
			tfd.setBounds(190, 360,150,30);
			jp.add(tfd);
			bg.add(a);
			bg.add(b);
			bg.add(c);
			bg.add(d);
									
			add.setBounds(50,450,70, 30);
			jp.add(add);
			add.addActionListener(new Save());
			nxt.setBounds(150,450,70,30);
			jp.add(nxt);
			nxt.addActionListener(new NxtBtn());
			
			
			
	 
		 jf.add(jp);
		 jf.setSize(500,600);
		 jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		 jf.setVisible(true);
	}
	
	class NxtBtn implements ActionListener
	{ 
		int i=1;
		public void actionPerformed(ActionEvent arg0) {
			Connection cnt= DateBaseConnection.javaConnection();
			try {
				try {
					Statement st= cnt.createStatement();
					String qq="select * from questions where s_num='"+lst.getQues_id()+"'";
					ResultSet rr= st.executeQuery(qq);
									 
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				lst= show.get(i);
				ques.setText(lst.getQues());
				tfa.setText(lst.getOp_A());
				tfb.setText(lst.getOp_B());
				tfc.setText(lst.getOp_C());
				tfd.setText(lst.getOp_D());
				i++;
				bg.clearSelection();
			} catch (IndexOutOfBoundsException ii) {
				jf.dispose();
				new Admin_welcome();
			}
		}
	}
			
			
			
	
	class Save implements ActionListener
	 {
		@Override
		public void actionPerformed(ActionEvent arg0) 
	 	{
			String nwqs=ques.getText();
			String nwop_a=tfa.getText();
			String nwop_b=tfb.getText();
			String nwop_c=tfc.getText();
			String nwop_d=tfd.getText();
			
			String ans=null;
			if(a.isSelected())
			{
				ans="A";
			}
			else if(b.isSelected())
			{
				ans="B";
			}
			else if(c.isSelected())
			{
				ans="C";
			}
			else if(d.isSelected())
			{
				ans="D";
			}
			
			
			Connection conn=DateBaseConnection.javaConnection();
			
			try
			{
				Statement st=conn.createStatement();
				String query="Update questions set question='"+nwqs+"',option_A='"+nwop_a+"',option_B='"+nwop_b+"',option_C='"+nwop_c+"',option_D='"+nwop_d+"',answer='"+ans+"' where s_num='"+id+"' ";
				int rr=st.executeUpdate(query);
				
					if(rr==1)
					{
						
						JOptionPane.showMessageDialog(null," Question was updated successfully...");
						
					}
								
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}

			
		
			
		 jf.dispose();
		 new Edit_Question(show);
			
		}
		 
	 }

	
	
	class back implements ActionListener
	 {
		@Override
		public void actionPerformed(ActionEvent arg0) 
	 	{
			
		 jf.dispose();
		 new Edit_Remove_question(show);
			
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



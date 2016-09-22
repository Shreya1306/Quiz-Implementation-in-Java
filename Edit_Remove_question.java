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

 class Edit_Remove_question 
{
	 JFrame jf=new JFrame("Remove Question");

	 JPanel jp=new JPanel();
	 	JButton logout=new JButton("Logout");
		JButton bk=new JButton("Back");
		JLabel ct=new JLabel("Catagory");
		JComboBox cct=new JComboBox();
		JComboBox clv=new JComboBox();
		JLabel lv=new JLabel("Level");
		JButton swqu=new JButton("Show Questions");

	 
	 @SuppressWarnings("static-access")
	public Edit_Remove_question(ArrayList<list> show) 
	{
		 
		 jp.setLayout(null);

			logout.setBounds(1200,20,80, 30);
			jp.add(logout);
			logout.addActionListener(new logout());
			
			bk.setBounds(1000,20,70, 30);
			jp.add(bk);
			bk.addActionListener(new back());
			
			ct.setBounds(100,100,100,30);
			jp.add(ct);
			cct.addItem("Physics");
			cct.addItem("Mathematics");
			cct.addItem("Chemistry");
			cct.addItem("Aptitude");
			cct.addItem("English");
			cct.setBounds(250,100,100,30);
			jp.add(cct);
			
			lv.setBounds(100,150,120,30);
			jp.add(lv);
			
			clv.addItem("Easy");
			clv.addItem("Average");
			clv.addItem("Hard");
			clv.setBounds(250,150,100,30);
			jp.add(clv);
			
			swqu.setBounds(500,300,130, 30);
			jp.add(swqu);
			swqu.addActionListener(new showQues());


		 jf.add(jp);
		 jf.setSize(1400,800);
		 jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		 jf.setVisible(true);
		 
	}
	 
	 class showQues implements ActionListener
	 {
		@Override
		public void actionPerformed(ActionEvent arg0) 
	 	{
			
			ArrayList<list> show= new ArrayList<list>();
			String cat= (String) cct.getSelectedItem();
			String lvl=(String)clv.getSelectedItem();
			
			Connection cnt= DateBaseConnection.javaConnection();
			try {
				Statement st= cnt.createStatement();
				String qq="select * from questions where catagory='"+cat+"' and level='"+lvl+"'";
				ResultSet rr= st.executeQuery(qq);
				while(rr.next())
				{
					list q= new list();
					q.setQues_id(rr.getString("s_num"));
					q.setQues(rr.getString("question"));
					q.setOp_A(rr.getString("option_A"));
					q.setOp_B(rr.getString("option_B"));
					q.setOp_C(rr.getString("option_C"));
					q.setOp_D(rr.getString("option_D"));
					q.setAnss(rr.getString("answer"));
					
					show.add(q);
					
				}
				jf.dispose();
				new Show_Questions(show);
				
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

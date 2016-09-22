package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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

 class Show_Questions 
{
	 JFrame jf=new JFrame("Show Questions");

	 JPanel jp=new JPanel();
	 JButton logout=new JButton("Logout");
	 JButton bk=new JButton("Back");
	// JButton sv=new JButton("Edit");
	 JButton del=new JButton("Delete");
	 JLabel num,ques,opa,opb,opc,opd,ans,lacom,idd[];
	 
	 JRadioButton rb[];
	 ArrayList<list> show;
	 list lst;
	 ButtonGroup bg=new ButtonGroup();
	 
	 JLabel arr[];
	 JTextField qu,oa,ob,oc,od,an;
	 
	 
	  @SuppressWarnings("static-access")
	Show_Questions( ArrayList<list> l)
	{
		 
		 jp.setLayout(null);
		 
		 int i=0,j=100;
		 	show=l;
		 	lst=l.get(0);
			logout.setBounds(1200,20,80, 30);
			jp.add(logout);
			logout.addActionListener(new logout());
			
			
			bk.setBounds(100,20,70, 30);
			jp.add(bk);
			bk.addActionListener(new back());
			
			num=new JLabel("Q_id");
			num.setBounds(15,65,30,30);
			jp.add(num);
			
			ques=new JLabel("Question");
			ques.setBounds(60,65,200,30);
			jp.add(ques);
			
			opa=new JLabel("Option A");
			opa.setBounds(260,65,200,30);
			jp.add(opa);
			
			opb=new JLabel("Option B");
			opb.setBounds(460,65,200,30);
			jp.add(opb);
			
			opc=new JLabel("Option C");
			opc.setBounds(660,65,200,30);
			jp.add(opc);
			
			opd=new JLabel("Option D");
			opd.setBounds(860,65,200,30);
			jp.add(opd);
			
			ans=new JLabel("Answer");
			ans.setBounds(1060,65,200,30);
			jp.add(ans);
			
							
			int k=show.size();
			arr=new JLabel[k];
			
			
			rb=new JRadioButton[k];
			idd=new JLabel[k]; 
			
			
			for (list lst : l) {
				
				
				idd[i]=new JLabel(lst.getQues_id());
				idd[i].setBounds(20,j,30,30);
				jp.add(idd[i]);
				
				arr[i]= new JLabel(lst.getQues());
				arr[i].setBounds(60,j,200,30);
				jp.add(arr[i]);
				
				arr[i]=new JLabel(lst.getOp_A());
				arr[i].setBounds(260,j,200,30);
				jp.add(arr[i]);
				
				arr[i]=new JLabel(lst.getOp_B());
				arr[i].setBounds(460,j,200,30);
				jp.add(arr[i]);
				
				arr[i]=new JLabel(lst.getOp_C());
				arr[i].setBounds(660,j,200,30);
				jp.add(arr[i]);
				
				arr[i]=new JLabel(lst.getOp_D());
				arr[i].setBounds(860,j,200,30);
				jp.add(arr[i]);
				
				arr[i]=new JLabel(lst.getAnss());
				arr[i].setBounds(1060,j,200,30);
				jp.add(arr[i]);
				
				rb[i]=new JRadioButton();
				rb[i].setBounds(1280,j,30,30);
				jp.add(rb[i]);
				bg.add(rb[i]);
				
				i++;
				j=j+40;	
			}
			
			 
			 
			
			
			
			
			del.setBounds(600,650,80, 30);
			jp.add(del);
			del.addActionListener(new delete());


		 jf.add(jp);
		 jf.setSize(1500,900);
		 jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		 jf.setVisible(true);
		 
	}
	  
//	  class edit implements ActionListener
//	  {
//		  JTextField qu,oa,ob,oc,od,an;
//		  
//		  @Override
//			public void actionPerformed(ActionEvent arg0) 
//		 	{
//			  //String id=(String) com.getSelectedItem();
//			//  new Edit_Question(show);
//			  
//			  int m=-1;
//				for(int i=0;i<10;i++)
//				{
//					if(rb[i].isSelected())
//					{
//						m=i;
//						break;
//					}
//				}
//				//System.out.println(m);
//				
//				if(m!=-1)
//				{
//					arr1[m].setVisible(false);
//					arr2[m].setVisible(false);
//					arr3[m].setVisible(false);
//					arr4[m].setVisible(false);
//					arr5[m].setVisible(false);
//					arr6[m].setVisible(false);
//					
//					qu=new JTextField(lst.getQues());
//					qu.setBounds(60,100+(40*(m)),200,30);
//					jp.add(qu);
//					
//					oa=new JTextField(lst.getOp_A());
//					oa.setBounds(260,100+(40*(m)),200,30);
//					jp.add(oa);
//					
//					ob=new JTextField(lst.getOp_B());
//					ob.setBounds(460,100+(40*(m)),200,30);
//					jp.add(ob);
//					
//					oc=new JTextField(lst.getOp_C());
//					oc.setBounds(660,100+(40*(m)),200,30);
//					jp.add(oc);
//					
//					od=new JTextField(lst.getOp_D());
//					od.setBounds(860,100+(40*(m)),200,30);
//					jp.add(od);
//					
//					an=new JTextField(lst.getAnss());
//					an.setBounds(1060,100+(40*(m)),200,30);
//					jp.add(an);
//					
//					JButton s=new JButton("Save");
//					s.setBounds(600,650,100,30);
//					jp.add(s);
//					sv.setVisible(false);
//					s.addActionListener(new save());
//				}
//				else
//				{
//					JOptionPane.showMessageDialog(null,"Please select an entry to edit");
//				}
//				
//			  
//		 	}
//	  }
//	  
//	  class save implements ActionListener
//	  {
//		  
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			
//			int m=-1;
//			for(int i=0;i<10;i++)
//			{
//				if(rb[i].isSelected())
//				{
//					m=i;
//					break;
//				}
//			}
//			if(m!=-1)
//			{
//				String iid= idd[m].getText();
//				String nwqu= qu.getText();
//				String nopa= oa.getText();
//				String nopb= ob.getText();
//				String nopc= oc.getText();
//				String nopd= od.getText();
//				String nans= an.getText();
//				
//				System.out.println(iid);
//				System.out.println(nwqu);
//				
//				Connection cnt= DateBaseConnection.javaConnection();
//				try {
//					Statement st= cnt.createStatement();
//					String qq="Update questions set question='"+nwqu+"',option_A='"+nopa+"',option_B='"+nopb+"',option_C='"+nopc+"',option_D='"+nopd+"',answer='"+nans+"' where s_num='"+iid+"' ";
//					int rr= st.executeUpdate(qq);
//					
//					if(rr==1)
//					{
//						JOptionPane.showMessageDialog(null,"selected entry is updated successfully...!!");
//						jf.dispose();
//						new Edit_Remove_question(show);
//						
//					}
//					
//					
//				} 
//				catch (SQLException e) 
//				{
//					jf.dispose();
//					e.printStackTrace();
//				}
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(null,"PLease select an entry to update...");
//				
//			}
//			
//			
//			
//		}
//		  
//	  }
	  
	  class delete implements ActionListener
		 {
			@Override
			public void actionPerformed(ActionEvent arg0) 
		 	{
				int k=show.size();
				int m=-1;
				for(int i=0;i<k;i++)
				{
					if(rb[i].isSelected())
					{
						m=i;
						break;
					}
				}
				if(m!=-1)
				{
					String id= idd[m].getText();
					Connection cnt= DateBaseConnection.javaConnection();
					try {
						Statement st= cnt.createStatement();
						String qq="delete from questions where s_num='"+id+"'";
						int rr= st.executeUpdate(qq);
						
						if(rr==1)
						{
							JOptionPane.showMessageDialog(null,"selected entry is deleted successfully...!!");
							jf.dispose();
							new Edit_Remove_question(show);
							
						}
						
						
					} 
					catch (SQLException e) 
					{
						jf.dispose();
						e.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"PLease select an entry to delete...");
					
				}
				
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

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

	class Show_feedback {

		 
		JFrame jf=new JFrame("FeedBack");
		 JPanel jp=new JPanel();
		
		 JLabel idd,nm,fd;
		 JButton bk,lgt,del;
		 JRadioButton rb[];
		 JLabel arr[],fdb[];
		 ArrayList<list> fdbk;
		 list lst;
		 ButtonGroup bg=new ButtonGroup();
		 
		 @SuppressWarnings("static-access")
		Show_feedback(ArrayList<list> fed) {
			
			jp.setLayout(null);
			fdbk=fed;
			lst=fed.get(0);
			
			bk=new JButton("Back");
			bk.setBounds(1000,20,70, 30);
			jp.add(bk);
			bk.addActionListener(new back());//back buttun
			
			lgt=new JButton("Logout");
			lgt.setBounds(1200,20,90, 30);
			jp.add(lgt);
			lgt.addActionListener(new logout());
	
			
			
			idd=new JLabel("User_id");
			idd.setBounds(70,100,70,30);
			jp.add(idd);
			
			
			nm=new JLabel("Name");
			nm.setBounds(200,100,150,30);
			jp.add(nm);
			
			fd=new JLabel("FeedBack");
			fd.setBounds(400,100,500,30);
			jp.add(fd);
			
			int k=fdbk.size();
			
			rb=new JRadioButton[k];
			arr=new JLabel[k];
			fdb=new JLabel[k];
			int i=0;
			int j=140;
			int n=1;
			for (list lst : fed) {
				
				rb[i]=new JRadioButton();
				rb[i].setBounds(30,j,30,30);
				jp.add(rb[i]);
				bg.add(rb[i]);
				
				arr[i]=new JLabel(lst.getId());
				arr[i].setBounds(80,j,70,30);
				jp.add(arr[i]);
				
				arr[i]=new JLabel(lst.getName());
				arr[i].setBounds(210,j,100,30);
				jp.add(arr[i]);
				
				fdb[i]=new JLabel(lst.getFeed());
				fdb[i].setBounds(410,j,200,30);
				jp.add(fdb[i]);
				
				i++;
				j=j+40;
				
				
			}
			
			
			del=new JButton("Delete");
			del.setBounds(500,j+70,100,30);
			jp.add(del);
			del.addActionListener(new delete());
						
			
			
			jf.add(jp);
			jf.setSize(1400,800);
			jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
			jf.setVisible(true);
			
		}
		 
		 class delete implements ActionListener
		 {
			@Override
			public void actionPerformed(ActionEvent arg0) 
		 	{
				int m=-1;
				for(int i=0;i<10;i++)
				{
					if(rb[i].isSelected())
					{
						m=i;
						break;
					}
				}
				if(m!=-1)
				{
					String fd=fdb[m].getText();
					Connection cnt= DateBaseConnection.javaConnection();
					try {
						Statement st= cnt.createStatement();
						String qq="delete from user_feedback where feedback='"+fd+"'";
						int rr= st.executeUpdate(qq);
						
						if(rr==1)
						{
							JOptionPane.showMessageDialog(null,"selected entry is deleted successfully...!!");
							jf.dispose();
							new Admin_welcome();
							
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

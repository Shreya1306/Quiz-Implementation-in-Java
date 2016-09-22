package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Admin.DateBaseConnection;

	class sign_up 
{
		JFrame jf=new JFrame("sign up");
		
		ButtonGroup bg=new ButtonGroup();

		JPanel jp=new JPanel();
		
		JButton bk=new JButton("Back");
		JLabel nm=new JLabel("Full Name");
		JTextField tfnm=new JTextField();
		
		
		JLabel id=new JLabel("email id");
		JTextField tfid=new JTextField();
		
		JLabel dob=new JLabel("Date of Birth");
		JComboBox cdd=new JComboBox();
		JComboBox cmm=new JComboBox();
		JComboBox cyy=new JComboBox();
		JLabel dd=new JLabel("dd");
		JLabel mm=new JLabel("mm");
		JLabel yy=new JLabel("yy");
		
		JLabel pass=new JLabel("Password");
		JPasswordField tfpas=new JPasswordField();
		
		JLabel cpass=new JLabel("Confirm Password");
		JPasswordField tfcpas=new JPasswordField();
		
		JLabel gen=new JLabel("Gender");
		JRadioButton ml=new JRadioButton("Male");
		JRadioButton fl=new JRadioButton("Female");
		
		
		JLabel sch=new JLabel("Schooling");
		JTextField tfsch=new JTextField();
		
		JLabel hstd=new JLabel("Higher Studies");
		JTextField tfhstd=new JTextField();
		
		JLabel sec=new JLabel("Security Question");
		JComboBox csec=new JComboBox();
		JLabel ans=new JLabel("Answer");
		JTextField tfans=new JTextField();
			
		JLabel intr=new JLabel("Intersts");
		JTextPane tpintr=new JTextPane();
		
		JButton sn=new JButton("sign up??");
				
		
			sign_up() 
		{
				jp.setLayout(null);

				bk.setBounds(1200,50,90, 30);
				jp.add(bk);
				bk.addActionListener(new back());
				
				
				bg.add(ml);
				bg.add(fl);
				
				nm.setBounds(100,100,100,30);
				jp.add(nm);//nm=full name
				tfnm.setBounds(250,100,170,30);
				jp.add(tfnm);
				
				
				id.setBounds(600,100,100,30);
				jp.add(id);//id=email id
				tfid.setBounds(700,100,230,30);
				jp.add(tfid);
				
				dob.setBounds(100,160,100,30);
				jp.add(dob);
				
				int j=1;
				for(j=1;j<32;j++)
				{
					
					cdd.addItem(j);
				}
				cdd.setBounds(250,160,40,30);
				jp.add(cdd);
				dd.setBounds(260, 190,30,30);
				jp.add(dd);
				cmm.setBounds(300,160,40,30);
				for(j=1;j<13;j++)
				{
					
					cmm.addItem(j);
				}
				jp.add(cmm);
				mm.setBounds(310, 190,30,30);
				jp.add(mm);
				cyy.setBounds(350,160,70,30);
				for(j=1980;j<2020;j++)
				{
					
					cyy.addItem(j);
				}
				jp.add(cyy);
				yy.setBounds(360, 190,30,30);
				jp.add(yy);
				
				pass.setBounds(100,240,100,30);
				jp.add(pass);//pass=password
				tfpas.setBounds(250,240,170,30);
				jp.add(tfpas);//tfpas=textfield password
				
				cpass.setBounds(600,240,120,30);
				jp.add(cpass);//cpass= confirm password
				tfcpas.setBounds(730,240,200,30);
				jp.add(tfcpas);//tfcpas=textfield confirm password
				
				gen.setBounds(600, 160,100 ,30);
				jp.add(gen);
				ml.setBounds(720, 160,80 ,30);
				jp.add(ml);
				fl.setBounds(820, 160,80 ,30);
				jp.add(fl);
				
				sch.setBounds(100, 300,100 ,30);
				jp.add(sch);
				tfsch.setBounds(250, 300,170 ,30);
				jp.add(tfsch);
				
				hstd.setBounds(600, 300,100 ,30);
				jp.add(hstd);
				tfhstd.setBounds(730, 300,200 ,30);
				jp.add(tfhstd);
				
				intr.setBounds(100, 360,100 ,30);
				jp.add(intr);
				tpintr.setBounds(250, 360,170 ,80);
				jp.add(tpintr);
				
				sn.setBounds(200, 600,100 ,30);
				jp.add(sn);
				sn.addActionListener(new sinup());
				
				sec.setBounds(100,460,150,30);
				jp.add(sec);
				
				csec.setBounds(250,460,250, 30);
				csec.addItem("What is your nick name?");
				csec.addItem("What is your mobile brand?");
				csec.addItem("What is your highest percentage marks?");
				csec.addItem("Who is your favourite actor?");
				csec.addItem("What is your favorite movie?");
				jp.add(csec);
				
				ans.setBounds(100,520,100,30);
				jp.add(ans);
				tfans.setBounds(250,520,220,30);
				jp.add(tfans);
				
				
				jf.add(jp);
				jf.setSize(1400,800);
				jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
				jf.setVisible(true);
		}
			
			class sinup implements ActionListener
			 {
				 Override actionOverride;
				 int i;

				@Override
				public void actionPerformed(ActionEvent E) 
				{
					String email=tfid.getText();
					String passwrd=tfpas.getText();
					String cpasswrd=tfcpas.getText();
					String name=tfnm.getText();
					String gender=null;
					if(ml.isSelected())
					{
						gender="Male";
					}
					else if(fl.isSelected())
					{
						gender="Female";
					}
					int date=cdd.getSelectedIndex();
					int mnth=cmm.getSelectedIndex();
					int year=cyy.getSelectedIndex();
					String School=tfsch.getText();
					String intrst=tpintr.getText();
					String studies=tfhstd.getText();
					String secqus=(String) csec.getSelectedItem();
					String anss=tfans.getText();
					
					
					if(passwrd.equals(cpasswrd))
					{
						if(email.equals("") || School.equals("") || name.equals("") || gender==null || intrst.equals("") || studies.equals("") || secqus.equals("") || anss.equals(""))
						{
							JOptionPane.showMessageDialog(null,"Please fill all the entries");
							 
							
						}
						else
						{
							
							Connection conn=DateBaseConnection.javaConnection();
							try
							{
								String em=null;
								Statement st=conn.createStatement();
								em="Select * from user_info where email_id='"+email+"' ";
								ResultSet e=st.executeQuery(em);
								if(em.equals(null))
								{
									 String query="insert into user_info(full_name,email_id,password,gender,dob,schooling,higher_studies,interests,Sec_ques,answer) values('"+name+"','"+email+"','"+passwrd+"','"+gender+"','"+date+"/"+mnth+"/"+year+"','"+School+"','"+studies+"','"+intrst+"','"+secqus+"','"+anss+"')";
										int rr=st.executeUpdate(query);
								}
								else{
									JOptionPane.showMessageDialog(null,"This email id already exits please enter a valid email");
									em=null;
								    }
								}
							catch(SQLException ex)
							{
								ex.printStackTrace();
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"password did not confirm");
						
					}					
				}
			 }

			 class back implements ActionListener
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
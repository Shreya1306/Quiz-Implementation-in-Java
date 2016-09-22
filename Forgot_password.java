package quiz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



	class Forgot_password 
{
		JFrame jf=new JFrame("Forgot Password??");

		JPanel jp=new JPanel();
		JLabel rec=new JLabel("Password Recovery");
		JRadioButton _1=new JRadioButton();
		JRadioButton _2=new JRadioButton();
		JButton bk=new JButton("Back");
		
		JLabel op1=new JLabel("via email");
		JLabel op2=new JLabel("via security question");
		
		JButton dn=new JButton("Done");
		ButtonGroup bg=new ButtonGroup();

		public Forgot_password() 
		{
			jp.setLayout(null);
			bg.add(_1);
			bg.add(_2);
			
			Font f3=new Font("Casteller",Font.ROMAN_BASELINE,16);
			
			bk.setBounds(1200,50,70, 30);
			jp.add(bk);
			bk.addActionListener(new back());//back buttun
			bk.setFont(f3);
			
			rec.setBounds(200,150,180,30);
			jp.add(rec);
			
			_1.setBounds(200,200,30,30);
			jp.add(_1);
			_2.setBounds(200,240,30,30);
			jp.add(_2);
			
			Font f2=new Font("Bodoni MT", Font.PLAIN, 16);
			op1.setBounds(250,200,100,30);
			jp.add(op1);
			op1.setFont(f2);
			op2.setBounds(250,240,150,30);
			jp.add(op2);
			op2.setFont(f2);
			
			
			
			dn.setBounds(360,360,100,30);
			jp.add(dn);
			dn.setFont(f3);
			dn.addActionListener(new done());
			
			
			Font f1=new Font("Tahoma",Font.PLAIN,18);
			rec.setFont(f1);
			
			
			
			jf.add(jp);
			jf.setSize(1400,800);
			jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
			jf.setVisible(true);
		}
		
		
		
		 class done implements ActionListener
		 {
			@Override
			public void actionPerformed(ActionEvent arg0) 
		 	{
			
				if (_1.isSelected())
				{
					jf.dispose();
					new MainClassEmail();
				}
				else if(_2.isSelected())
				{
					jf.dispose();
					new via_sec_ques();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please selectan option to go forward");
				}
				
			}
			 
		 }
		
		 class back implements ActionListener
		 {
			@Override
			public void actionPerformed(ActionEvent arg0) 
		 	{
				
			 jf.dispose();
			 new User_Login();
				
			}
			 
		 }
}

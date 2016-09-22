package quiz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import quiz.Forgot_password.back;

 class Contact {
	 JFrame jf=new JFrame("Show Questions");

	 JPanel jp=new JPanel();
	 JLabel mail=new JLabel("For any assistance you can leave your query at ");
	 JLabel id=new JLabel("asthagrwl240@gmail.com");
	 JLabel cont=new JLabel("Contact");
	 JLabel num1=new JLabel("9468698918");
	 JLabel num2=new JLabel("9568421637");
	 JButton bk=new JButton("Back");
	 int idd;
	 String name;
	
	 	Contact(int i,String nm) {
		
		 jp.setLayout(null);
		 idd=i;
		 name=nm;
		 
		 Font f=new Font("Casteller",Font.ROMAN_BASELINE,16);
		 mail.setBounds(100,100,400,30);
		 jp.add(mail);
		 mail.setFont(f);
		 id.setBounds(500,100,200,30);
		 jp.add(id);
		 id.setFont(f);
		 
		 cont.setBounds(100,200,100,30);
		 jp.add(cont);
		 cont.setFont(f);
		 
		 
		 num1.setBounds(250,200,100,30);
		 jp.add(num1);
		 num2.setBounds(250,250,100,30);
		 jp.add(num2);
		 num1.setFont(f);
		 num2.setFont(f);
		 
		 bk.setBounds(1200,50,70, 30);
			jp.add(bk);
			bk.addActionListener(new back());//back buttun
		 
		 jf.add(jp);
		 jf.setSize(1500,900);
		 jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		 jf.setVisible(true);
		
	}
	 	
	 	 class back implements ActionListener
		 {
			@Override
			public void actionPerformed(ActionEvent arg0) 
		 	{
				
			 jf.dispose();
			 new User_Welcome(idd,name);
				
			}
			 
		 }

}

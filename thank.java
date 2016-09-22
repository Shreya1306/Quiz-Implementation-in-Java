package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class thank {
	
	 JFrame jf=new JFrame("Feedback");

	 JPanel jp=new JPanel();
	 JButton logout=new JButton("Logout");
	 JLabel lb=new JLabel("Thank You..!!");
	 JButton hm=new JButton("Home");
	 String name;
	 int id;
	 
	public thank(int i,String nm) {
		
		 jp.setLayout(null);
		 id=i;
		 name=nm;
		 
		 logout.setBounds(1200,20,80, 30);
			jp.add(logout);
			logout.addActionListener(new logout());//logout
			
			Font f=new Font("ENGRAVERS MT", Font.CENTER_BASELINE,20);
			lb.setBounds(200,200,200,30);
			
			jp.add(lb);
			lb.setFont(f);
			Color cc=new Color(10,10,10);
			
			hm.setBounds(1000,20,100,30);
			jp.add(hm);
			hm.addActionListener(new home());
			
			jf.add(jp);
			jf.setSize(1400,800);
			jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
			jf.setVisible(true);
	}
	
	class home implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
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

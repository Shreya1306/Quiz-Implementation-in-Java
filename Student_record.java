package quiz;

import java.applet.Applet;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
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

class Student_record 
{
	
	JFrame jf=new JFrame("Student Record");

	 JPanel jp=new JPanel();
	JLabel stdnm=new JLabel("Student name");
	JLabel id=new JLabel("id");
	JLabel dt=new JLabel("Date");
	JLabel mk=new JLabel("Marks");
	JLabel lv=new JLabel("Level");
	JLabel cat=new JLabel("Catagory");
	ButtonGroup bg=new ButtonGroup();
	
	JButton logout=new JButton("Logout");
	JButton bk=new JButton("Back");
	JButton del;
	JRadioButton rb[];
	
	
//	JRadioButton rst1=new JRadioButton();
//	JRadioButton rst2=new JRadioButton();
//	JRadioButton rst3=new JRadioButton();
//	JRadioButton rst4=new JRadioButton();
//	JRadioButton rst5=new JRadioButton();
	
	ArrayList<list> user ;
	list rec;
	JLabel lb[],da[];
	int k;
	
	 Student_record(ArrayList<list> us) 
	{
		 user=us;
		 rec = us.get(0);
		 jp.setLayout(null);
		 
		 logout.setBounds(1200,20,100, 30);
		jp.add(logout);
		logout.addActionListener(new logout());
			
			
		bk.setBounds(1000,20,100, 30);
		jp.add(bk);
		bk.addActionListener(new back());
		 
		 stdnm.setBounds(50,50,130,30);
		 jp.add(stdnm);
		 
		 id.setBounds(200,50,70,30);
		 jp.add(id);
		 
		 dt.setBounds(270,50,160,30);
		 jp.add(dt);
		 
		 mk.setBounds(460,50,80,30);
		 jp.add(mk);
		 
		 lv.setBounds(580,50,80,30);
		 jp.add(lv);
		 
		 cat.setBounds(700,50,100,30);
		 jp.add(cat);
		 
		 
		 
		// System.out.println(k);
		 k=user.size();
		 lb=new JLabel[k];
		 da=new JLabel[k];
		 rb=new JRadioButton[k];
		 
		 	
		 	int i=0,j=100;
		 	for(list rec: us){
		 	
		 	rb[i]=new JRadioButton();	
		 	rb[i].setBounds(20, j, 30, 30);
		 	jp.add(rb[i]);
		 	bg.add(rb[i]);
		 	
			lb[i]=new JLabel(rec.getName());
			lb[i].setBounds(50,j,130,30);
			jp.add(lb[i]);
			
			lb[i]=new JLabel(rec.getId());
			lb[i].setBounds(200,j,70,30);
			jp.add(lb[i]);
			
			da[i]=new JLabel(rec.getDate());
			da[i].setBounds(270,j,140,30);
			jp.add(da[i]);
			
			lb[i]=new JLabel(rec.getMarks());
			lb[i].setBounds(460,j,80,30);
			jp.add(lb[i]);
			
			lb[i]=new JLabel(rec.getLevel());
			lb[i].setBounds(580,j,80,30);
			jp.add(lb[i]);
			
			lb[i]=new JLabel(rec.getCat());
			lb[i].setBounds(700,j,100,30);
			jp.add(lb[i]);
			
			
			i++;
			j=j+50;
			
		}
//		 	JScrollBar sc=new JScrollBar();
//		 	//sc.getHeight();
//		 	sc.setBlockIncrement(20);
//		 	sc.setAutoscrolls(true);
//		 	jp.add(sc);
		 	
		 	del=new JButton("Delete");
			 del.setBounds(700,j+50,100,30);
			 jp.add(del);
			 del.addActionListener(new delete());
			 
		 
		 	
		 jf.add(jp);
		 jf.setSize(1500,900);
		 jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		 jf.setVisible(true);
	
	}
	 
	 public class Scroll extends Applet implements AdjustmentListener

	 {

	 Scrollbar hsb, vsb;

	 int hr, vr;
	 @Override
		public void adjustmentValueChanged(AdjustmentEvent arg0) {

	 

	 hsb=new Scrollbar (Scrollbar.HORIZONTAL, 10,100,10,1000);

	 vsb=new Scrollbar (Scrollbar.VERTICAL, 10, 100, 10, 1000);

	add (hsb);

	jp.add(vsb);

	 hsb.addAdjustmentListener(this);

	 vsb.addAdjustmentListener(this);

	 jf.add(jp);
	 jf.setVisible (true);
	 
//	 hr=hsb.getValue ();
//	 vr=vsb.getValue ();
//	 repaint ();


	 }	
}

	 

	 
	 class delete implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
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
				String dte= da[m].getText();
				Connection cnt= DateBaseConnection.javaConnection();
				try {
					Statement st= cnt.createStatement();
					String qq="delete from result where Date='"+dte+"'";
					int rr= st.executeUpdate(qq);
					
					if(rr==1)
					{
						JOptionPane.showMessageDialog(null,"selected Name is deleted successfully...!!");
						jf.dispose();
						new Student_record(user);
						
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


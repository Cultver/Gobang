package register;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.five.ctrl.FiveChessControl;
import com.five.view.FiveChessView;
import com.five.view.MainFrame;

import view.Mainframe1;

public class Button extends JPanel
{
	private	MainFrame c;
	private	Mainframe1 c1;
	private JButton dl;
	private JButton dl1;
	JLabel username;
	private JTextField zh;
	JLabel password;
	 
	public static int jianyan;
	private JTextField mm;
	int b =0;
	int b1=0;
	 public Button() 
	 {
		
		c=new MainFrame();
		c1=new Mainframe1();
		username=new JLabel ("ÕËºÅ");
		zh=new JTextField(String.valueOf(""),10);
		password=new JLabel ("ÃÜÂë");
		mm=new JTextField(String.valueOf(""),10);
		
		
		dl=new JButton("µÇÂ¼Îå×ÓÆå");
		dl1=new JButton("µÇÂ¼ÇàÍÜ¹ýºÓ");
		zh.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				String a=zh.getText();
				int a1=	Integer.parseInt(a);					
				if(a1==147) 
				{
					b=1;
				}
				System.out.println(a);
			}	
		});
		/*mm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String b=zh.getText();
				
				int a1=	Integer.parseInt(b);
				
				
				if(a1==123) {
					b1=1;
				}
				System.out.println(b);
			}	
			});*/
		dl.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(b==1) 
				{
					//dl.setEnabled(false);
					jianyan=1;
					c.main(null);
					repaint();
				}				
			}
		});
		dl1.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if(b==1) 
				{
					//dl1.setEnabled(false);
					jianyan=1;
					c1.main(null);
					repaint();
				}
				
			}
		});
		//mm.setBounds(20,20, 20,20);
		//mima.setBounds(60,20, 50,20);
		//zh.setBounds(20,70, 20,20);
		//zhanghao.setBounds(60,70, 50,20);
		//this.add(mm,BorderLayout.WEST);
		//this.add(mima,BorderLayout.EAST);
		this.add(zh,BorderLayout.WEST);
		//this.setLayout(new GridLayout(2,1));
		
		add(username,BorderLayout.EAST);
		
		this.add(dl,BorderLayout.SOUTH);
		this.add(dl1,BorderLayout.SOUTH);
	 }

	
 }

package register;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.five.view.MainFrame;

import view.Mainframe1;

public class Register extends JFrame
{
	private Button b; 
	public Register () 
	{	
		setTitle("µÇÂ¼");                                                                       
		b=new Button();
		Container c=getContentPane();
		c.add(b);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public static void main(String[] args) 
	{
		new Register();		
	}
}

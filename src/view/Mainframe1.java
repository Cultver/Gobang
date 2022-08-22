package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import control.Frog;
import register.Button;

public class Mainframe1 extends JFrame
{
	private Frog a;
	private Go b;
	public Mainframe1() 
	{
		setTitle("วเอÜนýบำ");
		 a=new Frog();
		 b=new Go();
		Container c=getContentPane();
		if(Button.jianyan==1) 
		{
			c.add(a);
			c.add(b,BorderLayout.NORTH);
			a.setSize(50, 55);
			b.setSize(50, 55);
			setLocationRelativeTo(null);
			setSize(500,200);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
		}
	}
	public static void main(String[] args)
	{
		new Mainframe1();	
	}
}

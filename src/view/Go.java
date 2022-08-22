package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.Frog;

public class Go extends JPanel
{
	public JButton ks;
	public JButton csks;
	public Frog qw;
	public int k,k1;
	
	public Go() 
	{
	
		ks=new JButton("开始");
		csks=new JButton("重新开始");
		csks.setEnabled(false);
		this.add(ks);
		this.add(csks);
		ks.addActionListener(new ActionListener()
		{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
					for(int i=0 ;i<7;i++)
					{
						Frog.d[i]=1;
					}
					Frog.d[3]=0;
					ks.setEnabled(false);
					csks.setEnabled(true);
					}
					});
		csks.addActionListener(	new ActionListener()
		{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						for(int i=0;i<7;i++) 
						{
							if(Frog.c[i]==true) 
							{
								k=i;
							}
							 if(Frog.c[i]==false)
							 {
								k1=i;
							 }
							Frog.d[i]=0;
						}
						for(int i=0;i<3;i++) 
						{
							Frog.c[i]=true;
							Frog.a[i].setIcon(Frog.a[k].getIcon());
						}
						for(int i=4;i<7;i++) 
						{
							Frog.c[i]=false;
							Frog.a[i].setIcon(Frog.a[k1].getIcon());
						}
						Frog.a[3].setIcon(null);
						ks.setEnabled(true);
						csks.setEnabled(false);
						
					}
		});
	}
}

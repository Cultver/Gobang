package com.five.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

import com.five.ctrl.CustomEvent;
import com.five.ctrl.CustomListener;
import com.five.ctrl.FiveChessControl;

public class OptionDialog extends JDialog{
	private JButton ok;
	private JButton cancel;
	
	public static Color color=new Color(160,150,50);
	private EventListenerList listenerList;
	JPanel preview;
	JLabel yanse;
	JLabel time;
	JLabel hong;
	JSlider honghua;
	JSlider lvhua;
	JSlider lanhua;
	JLabel lv;
	JLabel lan;
	JTextField red;
	JTextField green;
	JTextField blue;
	public  int rvalue=255;
	public  int gvalue=128;
	public  int bvalue=0;
	public  int hvalue=255;
	public  int lvvalue=128;
	public  int lanvalue=0;
	
	
	public OptionDialog (Frame owner,String title)
	{
			super(owner,title,false);
			listenerList = new EventListenerList();
			ok=new JButton("确定");
			ok.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					color=new Color(hvalue,lvvalue,lanvalue);
					
					setVisible(false);
					FiveChessControl.shezhistart=0;
				}});
			
			cancel=new JButton("取消");
			cancel.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
					color=new Color(hvalue,lvvalue,lanvalue);
					setVisible(false);
					FiveChessControl.shezhistart=0;
				}
			});
			
			
			hong=new JLabel ("红色");
			lv=new JLabel ("绿色");
			lan=new JLabel ("蓝色");
			yanse = new JLabel("调节颜色");
			time=new JLabel("调节时间");
			red=new JTextField(String.valueOf(255));
			
			green=new JTextField(String.valueOf(128));
			blue=new JTextField(String.valueOf(0));
			JPanel south =new JPanel();
			
		south.add(ok);
		south.add(cancel);
		
		JPanel a =new JPanel();
	    a.add(yanse);
	    

		//滑块
		honghua=new JSlider(SwingConstants.HORIZONTAL,0,255,255);//创建红色滑块
		honghua.setBounds(160,55, 160, 45);//设置滑块的位置以及大小
		honghua.putClientProperty("JSlider.isFilled",Boolean.TRUE);//填充滑块
		honghua.setPaintTicks(true);//绘制勾号标记
		honghua.setMajorTickSpacing(50);//主要的勾号标记大小
		honghua.setMinorTickSpacing(25);//次要的勾号标记大小
		honghua.setPaintLabels(true);//显示主要刻度的数字标记
		lvhua=new JSlider(SwingConstants.HORIZONTAL,0,255,128);
		lvhua.setBounds(160,125, 160, 45);
		lvhua.putClientProperty("JSlider.isFilled",Boolean.TRUE);
		lvhua.setPaintTicks(true);
		lvhua.setMajorTickSpacing(50);
		lvhua.setMinorTickSpacing(25);
		lvhua.setPaintLabels(true);
		lanhua=new JSlider(SwingConstants.HORIZONTAL,0,255,0);
		lanhua.setBounds(160,195, 160, 45);
		lanhua.putClientProperty("JSlider.isFilled",Boolean.TRUE);
		lanhua.setPaintTicks(true);
		lanhua.setMajorTickSpacing(50);
		lanhua.setMinorTickSpacing(25);
		lanhua.setPaintLabels(true);
		
		honghua.addChangeListener(new ChangeListener() 
		{
			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				// TODO Auto-generated method stub
				 hvalue=honghua.getValue();
					color=new Color(hvalue,lvvalue,lanvalue);								
			}
		
		});
		lvhua.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent arg0) 
			{
				// TODO Auto-generated method stub
				 lvvalue=lvhua.getValue();
				color=new Color(hvalue,lvvalue,lanvalue);
			}
		
		});
		lanhua.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent arg0) 
			{
				// TODO Auto-generated method stub
				 lanvalue=lanhua.getValue();
					color=new Color(hvalue,lvvalue,lanvalue);
					
				//red.getText()=value;
				
			}
		
		});
		red.addActionListener(new ActionListener()
		{
	
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
					// TODO Auto-generated method stub
					rvalue=Integer.parseInt(red.getText());
					hvalue=rvalue;
					//color=new Color(rvalue,gvalue,bvalue);
				    //honghua.getValue()=value;
					System.out.println(rvalue);
				}	
		});
		green.addActionListener(new ActionListener() 
		{
	
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				gvalue=Integer.parseInt(green.getText());
				
			    //honghua.getValue()=value;
				
			}	
		});
		blue.addActionListener(new ActionListener() 
		{
	
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				bvalue=Integer.parseInt(blue.getText());
			    //honghua.getValue()=value;
			}	
		});
		//文字，文本框
		Font font = new Font("粗体", Font.BOLD,22);
		yanse.setFont(font);
		time.setFont(font);
		a.setLayout(new GridLayout(1,1));
		//b.setLayout(new GridLayout(2,1));
		//field.setPreferredSize(new Dimension (100,100));
		//field.setSize(200, 5);
		red.setBounds(320,55, 50,20);
		hong.setBounds(120,55, 50,20);
		lv.setBounds(120,125, 50,20);
		lan.setBounds(120,195, 50,20);
		green.setBounds(320,125, 50,20);
		blue.setBounds(320,195, 50,20);
		
		this.getContentPane().add(honghua);
		this.getContentPane().add(lvhua);
		this.getContentPane().add(lanhua);
	
		//this.getContentPane().add(red);
		//this.getContentPane().add(green);
		//this.getContentPane().add(blue);
		this.getContentPane().add(hong);
		this.getContentPane().add(lv);
		this.getContentPane().add(lan);
		this.getContentPane().add(a);
		this.getContentPane().add(south,BorderLayout.SOUTH);
		this.setSize(350, 350);
	}
		public void addCustomListener(CustomListener listener)
		{
				listenerList.add(CustomListener.class, listener);
		}
		public void removeCustomListener(CustomListener listener)
		{
			listenerList.remove(CustomListener.class, listener);
		}
		public void showDiolog() 
		{
			this.setVisible(true);
		}
		public void custom(CustomEvent e)
		{
			Object[] listeners = listenerList.getListeners(CustomListener.class);
			for(int i = 0; i < listeners.length; i++)
			{
				((CustomListener)listeners[i]).customAction(e);
			}
		}
		public void addCustomListener(FiveChessControl fiveChessControl) 
		{
			
			
		}
}

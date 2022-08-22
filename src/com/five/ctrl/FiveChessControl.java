package com.five.ctrl;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;


import com.five.model.Clock;
import com.five.view.ClockView;
import com.five.view.FiveChessView;
import com.five.view.NorthView;
import com.five.view.OptionDialog;
import com.five.view.SouthView;

public class FiveChessControl 
{
	private NorthView northView;
	private JLabel blackTime;
	private JLabel whiteTime;
	private ClockView clockView;
	private JButton btn_setup;
	private JButton btn_start;
	
	public static int shezhistart=1;
	public static Timer timer;
	private Clock clock;
	public  int second =0;
	private FiveChessView a;
	public int minute =0;
	public static int count =0;
	public static int max =20;
	private OptionDialog dialog;
	public static int next =1;
	public FiveChessControl(NorthView nv, SouthView sv)
	{
		timer = new Timer(1000, 
			new ActionListener()
		{
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					// TODO Auto-generated method stub
					String s1="00:"+2+"0";
					count++;
					int escape=max-count;
					minute=escape/60;
					second=escape%60;
					
					
					String buffer=((minute<10)?"0":"")+minute+":"+((second<10)?"0":"")+second;
					if(escape<1)
					{
						timer.stop();
						String msg ="";
						FiveChessView.kaishi1=999;
						if(FiveChessView.heibai==true) 
						{
							
							msg="白赢";
							
						}else 
						{
							msg="黑赢";
						}
						JOptionPane.showMessageDialog(null, msg);
					}
					if(FiveChessView.heibai==true) 
					{
						whiteTime.setText(s1);
						blackTime.setText(buffer);
						
					
					}
					// 
					if(FiveChessView.heibai==false) 
					{
					blackTime.setText(s1);
					whiteTime.setText(buffer);
					
					
					
					}
					clock.move();
				}
			
		});
		
		this.northView = nv;
		clock = northView.getClock();
		
		blackTime=northView.getBlackTime();
		whiteTime=northView.getWhiteTime();
		whiteTime.setOpaque(true);
		btn_start = sv.getStartButton();
		btn_setup = sv.getSetupButton();
		
		btn_start.addActionListener(new ActionListener()
		{
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
					// TODO Auto-generated method stub
					
					FiveChessView.kaishi1=0;
					shezhistart=0;
					next=(int)(Math.random()*2)+1;
					String msg ="";
					if(next==1) 
					{
						msg="黑方先";
						FiveChessView.heibai=true;
					}else 
					{
						msg="白方先";
						FiveChessView.heibai=false;
					}
					JOptionPane.showMessageDialog(null, msg);
					
					timer.start();
					FiveChessView.start=false;
					SouthView.backButton.setEnabled(true);
					SouthView.startButton.setEnabled(false);
					SouthView.setupButton.setEnabled(false);
					SouthView.backButton.setEnabled(true);
					SouthView.restartButton.setEnabled(true);
					FiveChessView.y1=1;
				}
				
		});
		btn_setup.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
							if(dialog==null) 
							{
								dialog=new OptionDialog(null,"设置");
							}
							dialog.showDiolog();
							System.out.println("ok");
							dialog.addCustomListener(FiveChessControl.this);
							shezhistart=1;					
					}					
				}
		);	
	}
	public int getNext() 
	{
		return this.next;
	}
	public void customAction(CustomEvent event) 
	{
		Color color = event.getColor();
		whiteTime.setBackground(color);
	}
	
	
}


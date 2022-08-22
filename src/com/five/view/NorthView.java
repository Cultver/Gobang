package com.five.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import com.five.model.Clock;

public class NorthView extends JPanel 
{
	public static JLabel blackTime;
	public static JLabel whiteTime;
	private ClockView clockView;
	private Clock clock;
	
	
	public NorthView()
	{				
		JLabel blackName = new JLabel("ºÚ·½");
		JLabel whiteName = new JLabel("°×·½");
		blackTime = new JLabel("00:00");
		whiteTime = new JLabel("00:00");
		blackName.setHorizontalAlignment(SwingConstants.CENTER);
		whiteName.setHorizontalAlignment(SwingConstants.LEFT);
		whiteTime.setHorizontalAlignment(SwingConstants.CENTER);
		blackTime.setHorizontalAlignment(SwingConstants.LEFT);
		
		blackName.setForeground(Color.WHITE);
		blackTime.setForeground(Color.WHITE);
		whiteName.setForeground(Color.WHITE);
		whiteTime.setForeground(Color.WHITE);
		Font font = new Font("", Font.BOLD, 18);
		blackName.setFont(font);
		whiteName.setFont(font);
		blackTime.setFont(font);
		whiteTime.setFont(font);
		clockView = new ClockView();
		clock = new Clock();
		clock.setView(clockView);
		clockView.setClock(clock);
		
		//Border border=BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.black);
		whiteTime.setBackground(new Color(33,20,18  ));
		this.setLayout(new GridLayout(1, 5));
		this.setBackground(new Color(33,20,18  ));
		this.add(blackName);
		this.add(blackTime);
		this.add(clockView);
		this.add(whiteTime);
		this.add(whiteName);
		clockView.setBackground(new Color(33,20,18  ));
	}

	public Clock getClock() 
	{
		return clock;
	}
	public JLabel getBlackTime()
	{	
		return this.blackTime;
	}
	public JLabel getWhiteTime() 
	{
		return this.whiteTime;
	}
	@Override
	public Dimension getMaximumSize() 
	{
		return new Dimension(600, 62);
	}
	@Override
	public Dimension getMinimumSize() 
	{
		return new Dimension(560, 62);
	}
	@Override
	public Dimension getPreferredSize() 
	{
		return getMinimumSize();
	}
}

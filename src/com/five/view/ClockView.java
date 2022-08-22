package com.five.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.five.model.Clock;

public class ClockView extends JPanel
{
	private Clock clock;	
	
	public void setClock(Clock c)
	{
		this.clock = c;
	}
	@Override
	protected void paintComponent(Graphics arg0) 
	{
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		double centerx = (double)this.getWidth() / 2;
		double centery = (double)this.getHeight() / 2;
		Graphics2D g = (Graphics2D)arg0;
		
		if(clock != null)
		{
			g.setColor(Color.WHITE);
			clock.setCenter(centerx, centery);
			clock.draw(g);
		}
	}
}
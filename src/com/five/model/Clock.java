package com.five.model;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import com.five.view.ClockView;

public class Clock 
{
	private double radius = 26;
	private double centerx;
	private double centery;
	
	private double secondLen = 22;
	private double minuteLen = 18;
	private double sAlpha = -Math.PI / 2;
	private double mAlpha = -Math.PI / 2;
	private ClockView view;
	
	public void setCenter(double x, double y)
	{
		this.centerx = x;
		this.centery = y;
	}
	public void setView(ClockView v)
	{
		this.view = v;
	}
	
	public void draw(Graphics2D g)
	{
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.draw(new Ellipse2D.Double(centerx - radius, centery - radius, 2 * radius, 2 * radius));
		g.draw(new Line2D.Double(centerx, centery, centerx + secondLen * Math.cos(sAlpha), centery + secondLen * Math.sin(sAlpha)));
		g.draw(new Line2D.Double(centerx, centery, centerx + minuteLen * Math.cos(mAlpha), centery + minuteLen * Math.sin(mAlpha)));
	}
	public void move()
	{
		sAlpha += Math.PI / 30;
		mAlpha += Math.PI / 1800;
		view.repaint();
	}
}


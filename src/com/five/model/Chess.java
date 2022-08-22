package com.five.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Chess 
{
	
	
	private double centerx;
	private double centery;
	private JPanel view;
	
	public static final int black = 1;
	public static final int white = 2;
	public static final double radius = 30;	
	
	private int current ;
	private final float[]  dist =  {0f,0.5f,1f};//½¥±äÉ«
	private final Color[] whiteColors = {Color.lightGray,Color.gray,Color.white};
	private final Color[] blackColors = {Color.black,Color.darkGray,Color.gray};
	
	private Paint whitepaint = new RadialGradientPaint((float)centerx,(float)centery,(float)radius,dist,whiteColors);
	private Paint blackpaint = new RadialGradientPaint((float)centerx,(float)centery,(float)radius,dist,blackColors);
	
	
	public Chess(JPanel v,int current)
	{
		this.current = current;
		this.view = v;
	}
	public void setCenter(double x,double y)
	{
		this.centerx =x;
		this.centery =y;
	}
	public void draw(Graphics2D g)
	{
		if(current==Chess.black)
		{
			 g.setPaint(blackpaint);				
		}
		else if(current==Chess.white)
		{
			g.setPaint(whitepaint);
		}
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//¿¹¾â³Ý
		g.fill(new Ellipse2D.Double(centerx-radius, centery-radius,2*radius, 2*radius));
		 view.repaint();
	}
}
	
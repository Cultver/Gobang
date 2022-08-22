package com.five.model;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class FiveChess 
{
	public static final double radius = 30;
//	public static final int white = 1;
//	public static final int black = 1;
	private double centerx;
	private double centery;
	private Color color;
	public FiveChess(double x,double y,Color color)
	{
		this.centerx=x;
		this.centery=y;
		this.color = color;
	}
	
	public double getRadius() 
	{
		return radius;
	}

	public double getCenterx()
	{
		return centerx;
	}
	public double getCentery() 
	{
		return centery;
	}
	public Color getColor() 
	{
		return color;
	}	
}

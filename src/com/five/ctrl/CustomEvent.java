package com.five.ctrl;

import java.awt.Color;
import java.util.EventObject;

public class CustomEvent extends EventObject 
{
	private Color color;
	public CustomEvent(Object src,Color color) 
	{
	super(src);
	this.color=color;
	}
	public Color getColor()
	{
		return color;
	}
}

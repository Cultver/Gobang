package com.five.ctrl;

import java.util.EventListener;

public interface CustomListener extends EventListener 
{
	public void customAction(CustomEvent event);
}

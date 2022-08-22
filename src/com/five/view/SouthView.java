
package com.five.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SouthView extends JPanel 
{
	public static JButton startButton;
	public static JButton setupButton;
	public static JButton restartButton;
	public static JButton backButton;
	public static JButton exitButton;
//	private JMenuBar menubar;//菜单栏
//	private JMenu Menu;
//	private JMenuItem backItem,restartItem;//菜单项
	public SouthView(){
		
		startButton = new JButton("开始");
		backButton= new JButton("悔棋");
		restartButton= new JButton("重新开始");
		setupButton = new JButton("棋盘背景色");
		exitButton = new JButton("退出");
		
		
		startButton.setPreferredSize(new Dimension(130,40));
		startButton.setBounds(100,100,110,40);
		startButton.setForeground(Color.WHITE);
		startButton.setHorizontalAlignment(SwingConstants.LEFT);
		startButton.setContentAreaFilled(false);
		startButton.setBorder(null);
		startButton.addActionListener(null);
		setupButton.setForeground(Color.WHITE);
		setupButton.setHorizontalAlignment(SwingConstants.CENTER);
		setupButton.setContentAreaFilled(false);
		setupButton.setBorder(null);
		setupButton.addActionListener(null);
		
		backButton.setForeground(Color.WHITE);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.addActionListener(null);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setEnabled(false);
		
		restartButton.setForeground(Color.WHITE);
		restartButton.setHorizontalAlignment(SwingConstants.CENTER);
		restartButton.setContentAreaFilled(false);
		restartButton.setBorder(null);
		restartButton.setEnabled(false);
		restartButton.addActionListener(null);
	
		exitButton.setForeground(Color.white);
		exitButton.setHorizontalAlignment(SwingConstants.RIGHT);
		exitButton.addActionListener(null);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorder(null);
		exitButton.setEnabled(true);
		
		Font font = new Font("粗体", Font.BOLD,22);
		startButton.setFont(font);
		setupButton.setFont(font);
		restartButton.setFont(font);
		backButton.setFont(font);
		exitButton.setFont(font);
		
		this.setBackground(new Color(33,20,18));
		this.setLayout(new GridLayout(1,5));
		this.add(startButton);
		this.add(setupButton);
		this.add(restartButton);
		this.add(backButton);
		this.add(exitButton);
	}
	public static JButton getStartButton(){
		return startButton;
	}
	public static JButton getBackButton(){
		return backButton;
	}
	public static JButton getRestartButton(){
		return restartButton;
	}
	public static JButton getSetupButton(){
		return setupButton;
	}
	public static JButton getExitButton(){
		return exitButton;
	}			
}

package com.five.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

import com.five.ctrl.FiveChessControl;
import com.five.view.FiveChessView;

import register.Button;
public class MainFrame extends JFrame
{ 
	private	FiveChessView a;
	private	NorthView northview;
	private	SouthView southView;
	
	public MainFrame() 
	{
		setTitle("五子棋");
		if(Button.jianyan==1) 
		{
			northview=new NorthView();
			southView=new SouthView();
			FiveChessControl ctrl=new FiveChessControl(northview,southView);
			FiveChessView a = new FiveChessView();
			Container c=this.getContentPane();
			c.add(northview,BorderLayout.NORTH);
			c.add(a,BorderLayout.CENTER);
			c.add(southView,BorderLayout.SOUTH);	
		}
		setSize(1000,1000);
		this.setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);//棋盘大小不可移动更改
		//pack();
	}
	public static void main(String[] args) 
	{
		new MainFrame();		
	}	
}
/*public class MainFrame extends JFrame 
{
	private FiveChessView FiveChessView;
	private JPanel toolbar;//工具栏
	private JButton button_start,button_back,button_exit;
	private JMenuBar menubar;//菜单栏
	private JMenu Menu;
	private JMenuItem startItem,backItem,exitItem;//菜单项
	public MainFrame(String title)
	{
		super(title);
		ClockView view = new ClockView();
		Clock clock = new Clock();
		NorthView northView = new NorthView();
		
	
		view.setClock(clock);
		clock.setView(view);
		FiveChessView chessboard = new FiveChessView();
		
		Container c = this.getContentPane();
		c.add(northView, BorderLayout.NORTH);
		c.add(chessboard);
		
		menubar = new JMenuBar();
		Menu = new JMenu("选项");
		startItem = new JMenuItem("开始");
		backItem = new JMenuItem("悔棋");
		exitItem = new JMenuItem("退出");
		Menu.add(startItem);
		Menu.add(backItem);
		Menu.add(exitItem);
		
		MyItemListener lis = new MyItemListener();
		this.startItem.addActionListener(lis);
		this.backItem.addActionListener(lis);
		this.exitItem.addActionListener(lis);
		menubar.add(Menu);
		setJMenuBar(menubar);//设置菜单栏
		toolbar = new JPanel();//工具面板
		button_start = new JButton("开始");
		button_back = new JButton("悔棋");
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolbar.add(button_start);
		toolbar.add(button_back);
		toolbar.add(button_exit);
		button_start.addActionListener(lis);
		button_back.addActionListener(lis);
		button_exit.addActionListener(lis);
		add(toolbar,BorderLayout.SOUTH);
		
		add(chessboard);//添加面板对象
		Dimension dim = getToolkit().getScreenSize();
		this.getContentPane().add(chessboard);
		//pack();//生成异常？
	} 
	private class MyItemListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()==startItem||e.getSource()==button_start)
			{
				System.out.println("重新开始");
				//chessboard.restartGame();
			}
			else if(e.getSource()==backItem||e.getSource()==button_back)
			{
				System.out.println("悔棋...");
				//chessboard.goback();
			}
			else if(e.getSource()==exitItem||e.getSource()==button_exit){
				System.exit(0);
			}
			
			
			
		}
	}
	public static void main(String[] args) 
	{
		 new MainFrame("五子棋");
	}

}*/

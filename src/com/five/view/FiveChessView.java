package com.five.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.five.ctrl.FiveChessControl;


public class FiveChessView extends JPanel
{
	private JButton ch;
	private JButton back;
	private JButton exit;
    private final	int  line=19;
    public static final float radius = 26;	
    private final float[]  dist =  {0f,0.5f,1f};//渐变色
	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	int gezi=(height*3/76);
	String message;
	public static int[][] chess=new int[19][19];
	int luozi;
	public static boolean heibai; 
	public static boolean start=true ;
	public static int kaishi1=1;
	public int x;
	public int y;
	public static int y1=0;
	public int x1=0;
	SouthView sv;
	public FiveChessView() 
	{
		
		this.addMouseListener( new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e)
			{
				FiveChessControl.count=0;
				int X=e.getX();
				int Y=e.getY();  // 用来获取鼠标坐标
			     x=(X-(height/8))/gezi;
				 y=(Y-gezi)/gezi;
				
					//让鼠标在棋盘范围内
					if(x<0||x>18||y<0||y>18) 
					{  
				         return;  
					}
					
					//落子
				    //落子的判定
					
					 if(heibai&&chess[x][y]==0&&!start&&kaishi1==0)
					 {
						chess[x][y] =1;
						luozi=1;
						heibai = false;
					 }
				
				else if(!heibai&&chess[x][y]==0&&!start&&kaishi1==0)
				{
					chess[x][y] = 2;
					luozi=1;
					heibai = true;	
				}else 
				{
					return;
				}
					 repaint();
			}
			
		
		});	
		
		ch=SouthView.getRestartButton();
		ch.addActionListener(new ActionListener()
		{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						// TODO Auto-generated method stub
						kaishi1=0;
						start=true;
						cho();
						x1=0;
						y1=0;
						SouthView.startButton.setEnabled(true);
						SouthView.restartButton.setEnabled(false);
						SouthView.setupButton.setEnabled(false);
						SouthView.backButton.setEnabled(true);
					}
					
		});
		back=SouthView.getBackButton();
		back.addActionListener(new ActionListener()
		{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						// TODO Auto-generated method stub
						int result = JOptionPane.showConfirmDialog(null, (heibai == true ? "白方悔棋,黑方是否同意？" :"黑方悔棋，白方是否同意？"));	
						if(result == 0)
						{
							chess[x][y]=0;
							if(heibai == true )
							{
								heibai = false;
							}else 
							{
								heibai = true;
							}
							
							repaint();
			
						}
					}
		});
		exit =SouthView.getExitButton();
		exit.addActionListener(new ActionListener() 
		{
	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()!=null)
					System.exit(0);
			}
		});
	}
	public  void cho()
	{
		for (int i = 0; i < line; i++) 
		{
			for (int j = 0; j < line; j++) 
			{
				chess[i][j] = 0;  //清空棋盘的棋子
			}
			
		}
			repaint();
	}
public int panduan(int bianhuax,int bianhuay,int color)
{
	int qizishu=0;
	int gudingx=bianhuax;
	int gudingy=bianhuay;
	//横向
	while(bianhuax+x>=0&&bianhuax+x<=18&&bianhuay+y>=0&&bianhuay+y<=18&&color==chess[x+bianhuax][y+bianhuay])
	{
		qizishu++;
		if(bianhuax!=0) 
		{
			bianhuax++;
		}
		if(bianhuay!=0) 
		{
			if(bianhuay>0) 
			{
				bianhuay++;
			}else 
			{
				bianhuay--;
			}
		}
		
	}
	bianhuax=gudingx;
	bianhuay=gudingy;
	while(x-bianhuax>=0&&x-bianhuax<=18&&y-bianhuay>=0&&y-bianhuay<=18&&color==chess[x-bianhuax][y-bianhuay]) 
	{
		qizishu++;
		if(bianhuax!=0) 
		{
			bianhuax++;
		}
		if(bianhuay!=0) 
		{
			if(bianhuay>0)
			{
				bianhuay++;
			}else 
			{
				bianhuay--;
			}
		}
		
	}
	
	return qizishu;
}

	@Override
	public void paintComponent(Graphics g) 
	{
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		//this.setBackground(new Color(33,20,18));
		g.setColor(new Color(33,20,18));
		g.fill3DRect(0, 0, 1000,1000 , true);
		 
		
		if(FiveChessControl.shezhistart==1)
		{
			this.updateUI();
		}
		g.setColor(OptionDialog.color);	
		g.fill3DRect(height/8-30, 0, gezi*18+60, gezi*18+60, true);
		
		  // 创建画笔
		for(int i=0;i<line;i++)
		{
			g.setColor(Color.BLACK);
			g.drawLine(height/8, (i*gezi)+30,(height/8)+(gezi*18), (i*gezi)+30);//横线
			g.drawLine( (i*gezi)+(height/8),30,(i*gezi)+(height/8),(gezi*18)+30);//竖线
		}
		for(int i=0; i<line; i++)
		{
			for (int j = 0; j < line; j++) //画实心黑子
			{
				int tempX = i*gezi+(height/8)-30;
				int tempY = j*gezi;
				
				if(chess[i][j] == 1)
				{   	
					Color[] colors={Color.black,Color.darkGray,Color.gray};					
					Graphics2D g2 = (Graphics2D)g;
					Point2D center=new Point2D.Float(tempX+14, tempY+14);
					RadialGradientPaint p =new RadialGradientPaint(center, radius, dist, colors);
					((Graphics2D) g).setPaint(p);
					g2.fillOval(tempX+14, tempY+14, 26, 26);
					g2.drawOval(tempX+14, tempY+14, 26, 26);
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT);	
				}
				//画实心白子
				if(chess[i][j] == 2)
				{
					Color[] colors={Color.lightGray,Color.gray,Color.white};								 
					Graphics2D g2 = (Graphics2D)g;
					Point2D center=new Point2D.Float(tempX+14, tempY+14);
					RadialGradientPaint p =new RadialGradientPaint(center, radius, dist, colors);	
					((Graphics2D) g).setPaint(p);
					g2.fillOval(tempX+14, tempY+14, 26, 26);
					g2.drawOval(tempX+14, tempY+14, 26, 26);
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT);	
				}
				
			}
		}

		if(panduan(1,0,chess[x][y])>=4)
		{
			if(chess[x][y]==1&&y1==1) 
			{
				SouthView.backButton.setEnabled(false);
				x1=100;
				FiveChessControl.timer.stop();
				g.setColor(Color.red);
				g.setFont(new Font("粗体",10,48));
				g.drawString("黑赢",300,300);
				start=true;
				
			}
			if(chess[x][y]==2&&y1==1) 
			{
				SouthView.backButton.setEnabled(false);
				x1=100;
				FiveChessControl.timer.stop();
				g.setColor(Color.red);
				g.setFont(new Font("粗体",0,48));
				start=true;
				g.drawString("白赢",300,300);
			}
		}
		if(panduan(0,1,chess[x][y])>=4) 
		{
			if(chess[x][y]==1&&y1==1) 
			{
				SouthView.backButton.setEnabled(false);
				x1=100;
				FiveChessControl.timer.stop();
				g.setColor(Color.red);
				g.setFont(new Font("粗体",0,48));
				start=true;
				g.drawString("黑赢",300,300);
			}
				if(chess[x][y]==2&&y1==1) 
				{
					SouthView.backButton.setEnabled(false);
					x1=100;
					FiveChessControl.timer.stop();
					g.setColor(Color.red);
					g.setFont(new Font("粗体",0,48));
					start=true;
					g.drawString("白赢",300,300);
				}
		}
		if(panduan(1,1,chess[x][y])>=4)
		{
			if(chess[x][y]==1&&y1==1) 
			{
				SouthView.backButton.setEnabled(false);
				x1=100;
				FiveChessControl.timer.stop();
				g.setColor(Color.red);
				g.setFont(new Font("粗体",0,48));
				start=true;
				g.drawString("黑赢",300,300);
			}
				if(chess[x][y]==2&&y1==1)
				{
					SouthView.backButton.setEnabled(false);
					x1=100;
					FiveChessControl.timer.stop();
					g.setColor(Color.red);
					g.setFont(new Font("粗体",0,48));
					start=true;
					g.drawString("白赢",300,300);
				}
		}
		if(panduan(1,-1,chess[x][y])>=4) 
		{
			if(chess[x][y]==1&&y1==1) 
			{
				SouthView.backButton.setEnabled(false);

				x1=100;
				FiveChessControl.timer.stop();
				
				g.setColor(Color.red);
				g.setFont(new Font("粗体",0,48));
				start=true;
				g.drawString("黑赢",300,300);
				
			}
				if(chess[x][y]==2&&y1==1) 
				{
					SouthView.backButton.setEnabled(false);

					x1=100;
					FiveChessControl.timer.stop();
					g.setColor(Color.red);
					g.setFont(new Font("粗体",0,48));
					start=true;
					g.drawString("白赢",300,300);
				}
		}
	//rightView.chongkai.setEnabled(true);
	}

}

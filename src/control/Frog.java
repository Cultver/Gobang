package control;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.five.view.FiveChessView;

public class Frog extends JPanel  implements MouseListener
{
	public static boolean[] c;//�ж�����
	public static int[] d;//�ж��Ƿ�������
	public static JButton[] a;//��ť����ƴͼ�е�ÿ���ƶ��ĸ���
	public static ImageIcon[] b;//��ť�е�ͼƬ
	public static ImageIcon[] e;
	public Frog()
	{
		e=new ImageIcon[2];
		e[0]=new ImageIcon("C:\\a.jpg");
		e[1]=new ImageIcon("C:\\b.jpg");
		qw();
	}

	@Override
	public void mouseClicked(MouseEvent arg0){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		int k=0;
		for(int i = 0;i<a.length;i++)
		{
			if(e.getSource()==a[i])
			{
			     k=i;
				break;
			}
		}
		if(k<7&&c[k]==true&&d[k]==1&&d[k+1]==0)
		{
			 a[k+1].setIcon(a[k].getIcon());
             a[k].setIcon(null);
             d[k]=0;
             d[k+1]=1;
             c[k+1]=true;
		}
		if(k<6&&c[k]==true&&d[k]==1&&d[k+2]==0)
		{
			   a[k+2].setIcon(a[k].getIcon());
	           a[k].setIcon(null);
	           d[k]=0;
	           d[k+2]=1;
	           c[k+2]=true;
		}
		if(k>0&&c[k]==false&&d[k]==1&&d[k-1]==0)
		{
			 a[k-1].setIcon(a[k].getIcon());
	         a[k].setIcon(null);
	         d[k]=0;
	         d[k-1]=1;
	         c[k-1]=false;
		}
		if(k>0&&c[k]==false&&d[k]==1&&d[k-2]==0)
		{
			  a[k-2].setIcon(a[k].getIcon());
			  a[k].setIcon(null);
			  d[k]=0;
			  d[k-2]=1;
			  c[k-2]=false;
		}
			System.out.println(c[0]); 
			System.out.println(c[1]); 
			System.out.println(c[2]); 
			
		if(c[0]==false&&c[1]==false&&c[2]==false&&c[4]==true&&c[5]==true&&c[6]==true) 
		{
				String msg ="";
				msg="ʤ����";
				JOptionPane.showMessageDialog(null, msg);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void qw()
	{
		c=new boolean[7];
		d=new int[7];
		a = new JButton[7];//��ʼ��������n*n��
		b = new ImageIcon[7];
		setLayout(new GridLayout(1,7));//ʹ�����񲼾�
		//������ʼ�����ȳ�ʼ�������������ٳ�ʼ������
		//��ʼ�����������и���ͼƬ
		for(int i = 0;i<3;i++)
		{
			c[i]=true;
			b[i] = new ImageIcon("C:\\b.jpg");
		}
		for(int i = 4;i<7;i++)
		{
			
			c[i]=false;
		    b[i] = new ImageIcon("C:\\a.jpg");
		}
		
			b[3] = null;//Ϊ��
			//��ÿ����ťָ��ͼƬ����ʱ��ť�ϵ�ͼƬ�ǹ̶�����ȷ��
		for(int i = 0;i<7;i++)
		{
		 a[i] = new JButton(b[i]);//������ťʱָ��ͼƬ
		 a[i].addMouseListener(this);
		 add(a[i]);
		}
	}
}

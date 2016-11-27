package 区域填充;
import java.awt.*;

import javax.swing.*;

//import 区域填充算法.Edge;

import java.util.*;
public class 边填充算法 {
	static JFrame f = new JFrame();
	static MyPanel mp = new MyPanel();
	public static void main(String arg[]){
		f.setSize(600,600);
		f.setLocation(100,100);
		f.add(mp) ;
		Thread t = new Thread();
		f.setVisible(true);
	}
}
class Edge{
	int x ;   //当前扫描线与边的交点
	double dx;    //从当前扫描线到下一扫描线的x增量
	int ymax;    //边所交的最高扫描线标号
} 
class MyPanel extends JPanel implements Runnable{
	Vector v [] ;  //容器，用以实现模板类
	Edge m[] = new Edge[6];
	Edge n[] = new Edge[6];
	Edge t = new Edge();
	private Boolean ad ;
	int i,j,k,l;
	int x,y,x1,x2 ;
	public void Location(){
		for(int i = 0; i<6 ;i++){
			m[i] = new Edge() ;
			n[i] = new Edge() ;
		}
		m[0].x = 2;
		m[0].dx = 0 ;
		m[0].ymax = 7 ;
		m[1].x = 3 ;
		m[1].dx = -1.5 ;
		m[1].ymax = 7 ;
		m[2].x = 7 ;
		m[2].dx = 2 ;
		m[2].ymax = 8 ;
		m[3].x = 11 ;
		m[3].dx = 0 ;
		m[3].ymax = 8 ;
		m[4].x = 9 ;
		m[4].dx = 2 ;
		m[4].ymax = 8 ;
		m[5].x = 11 ;
		m[5].dx = 0 ;
		m[5].ymax = 8 ;
	}
	public MyPanel(){
		//super.paint(g);
		Location();
		v = new Vector[9];
		for(int i =0 ;i<6 ; i++){
			v[i] = new Vector<Edge> () ;
		}
		Boolean ad1 = v[1].add(m[0]) ;
		Boolean ad2 = v[1].add(m[1]) ;
		Boolean ad3 = v[2].add(m[2]) ;
		Boolean ad4 = v[3].add(m[3]) ;
		Boolean ad5 = v[5].add(m[4]) ;
		Boolean ad6 = v[5].add(m[5]) ;
		k = 0 ;
}
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.pink);
		for(i=0;i<=30;i++)
		{
			x=10+50*i;
			g.drawLine(x,0,x,1000);
		}
		for(j=0;j<=60;j++)
		{
			y=50*j;
			g.drawLine(10,y,10000,y);
		}
		j = 0;
		g.setColor(Color.green);
		g.drawLine(110,150,110,400);
		g.drawLine(110,400,260,450);
		g.drawLine(260,450,560,350);
		g.drawLine(560,350,560,100);
		g.drawLine(560,100,260,250);
		g.drawLine(260,250,110,150);
		g.drawLine(560,350,560,700);
		if(j == 0)   repaint();
	}
	public void update(Graphics g){
			k=0;
			g.setColor(Color.blue);
			for(int q=0;q<8;q++)
			{
				j++;
					for(i=0;i<v[j].size();i++){
						m[k]=(Edge)v[j].get(i);
						k++;
					}
					for(l=0;l<k-1;l++){
						for(i=l;i<k-1;i++){
							if(m[i].x>m[i+1].x){
							  t=m[i];
							  m[i]=m[i+1];
							  m[i+1]=t;
						 }
						}
					}
					for(l=0;l<k-1;l++){
						if(m[l].x==m[l+1].x)
						{
							if(m[l].ymax==j&&m[l+1].ymax>j)
							{
								for(i=l;i<k-1;i++)
								{
									m[i]=m[i+1];
								}
								k=k-1;
							}
						}
					}
					for(i=0;i<k-1;i=i+2)
					{	
						x1=m[i].x;
						x2=m[i+1].x;
						while(x1<=x2)
						{
							x=x1*50+10-5;
							y=500-j*50-5;
							g.fillOval(x,y,10,10);
							x1++;
							try{Thread.sleep(1000);}catch(Exception e){}
						}
					}
					for(i=0;i<k;i++)
					{
						if(m[i].ymax==j)
						{
							l=i;
							while(l<k-1)
							{
								m[l]=m[l+1];
								l++;
							}
							k--;
							i=-1;
						}
						else if(m[i].ymax>j)
						{
							m[i].x=(int)(m[i].x+m[i].dx);
						}
					}
					if(j==8)
						break;
			}
		}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
	}
}

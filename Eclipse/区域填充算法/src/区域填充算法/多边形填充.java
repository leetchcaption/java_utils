package 区域填充算法;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class 多边形填充 {
	public static void main(String []args){
		JFrame f=new JFrame("扫描线算法");
		MyCanvas c=new MyCanvas();
		f.add(c);
		f.setSize(650,650);
		f.setLocation(100,100);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}
class Edge{
	int x;
	double dx;
	int ymax;
}
class MyCanvas extends Canvas{
	Vector v[];
	Edge n[]=new Edge[6];
	Edge m[]=new Edge[6];
	Edge t=new Edge();
    int x1,x2,x,y;
	int i,j,k,l;
	private Boolean add;
	public MyCanvas(){
		for(i=0;i<6;i++)
		{
			n[i]=new Edge();
			m[i]=new Edge();
		}
		n[0].x=5;
		n[0].dx=-3;
		n[0].ymax=2;
		n[1].x=5;
		n[1].dx=3;
		n[1].ymax=3;
		n[2].x=2;
		n[2].dx=0;
		n[2].ymax=7;
		n[3].x=11;
		n[3].dx=0;
		n[3].ymax=8;
		n[4].x=5;
		n[4].dx=2;
		n[4].ymax=8;
		n[5].x=5;
		n[5].dx=-1.5;
		n[5].ymax=7;
		v=new Vector[9];
		for(i=0;i<9;i++)
		{
			v[i]=new Vector<Edge>();
		}
		Boolean add1=v[1].add(n[0]);
		Boolean add2=v[1].add(n[1]);
		Boolean add3=v[2].add(n[2]);
		Boolean add4=v[3].add(n[3]);
		Boolean add5=v[5].add(n[4]);
		Boolean add6=v[5].add(n[5]);
		k=0;
	}
	public void paint(Graphics g){
		int flag=0;
		this.setBackground(Color.black);
		for(i=0;i<=11;i++)
		{
			x=10+50*i;
			g.drawLine(x,100,x,500);
		}
		for(j=0;j<=8;j++)
		{
			y=100+50*j;
			g.drawLine(10,y,560,y);
		}
		j=0;
		g.setColor(Color.blue);
		g.drawLine(110,150,110,400);
		g.drawLine(110,400,260,450);
		g.drawLine(260,450,560,350);
		g.drawLine(560,350,560,100);
		g.drawLine(560,100,260,250);
		g.drawLine(260,250,110,150);
		if(j==0)this.repaint();
	}
	public void update(Graphics g){
		k=0;
		g.setColor(Color.white);
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
}

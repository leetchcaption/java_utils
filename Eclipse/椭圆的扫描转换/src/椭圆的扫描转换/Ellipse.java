package 椭圆的扫描转换;
import java.awt.*;

import javax.swing.*;

import java.io.*;
import java.util.*;
public class Ellipse extends JFrame{
	static int x ;
	static int y;
	static int a,b ; 
	static JFrame f = new JFrame();     //当f,mp,t,为非静态字段时候，static void main()里面不可以对其直接访问
	public static void main(String arg[]){
		f.setSize(900, 600);
		f.setLocation(100,100);
		System.out.println("请输入原点坐标:");
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt(); 
		System.out.println("请输入截距:");
		a = sc.nextInt();
		b = sc.nextInt();
		MyPanel mp = new MyPanel(x,y,a,b);
		Thread t = new Thread(mp);
		t.start();
		f.add(mp);
		f.setVisible(true);
	}
}
class MyPanel extends JPanel implements Runnable{
	static int pointx = 0,pointy = 0;
	static int a,b;
	public MyPanel(int pointx,int pointy,int a2, int b2) {
		// TODO 自动生成的构造函数存根
		this.pointx = pointx ;
		this.pointy = pointy ;
		this.a = a2 ;
		this.b = b2 ; 
		//this.setLocation(pointx, pointy);
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawString("*", pointx, pointy);
		int x,y ;
		float d1,d2 ;
		x = 0  ;
		y = b ;
		d1 = (float)(b*b + a*a*(-b+0.25));
		g.drawString("+", x+pointx, y+pointy);
		while(b*b*(x+1)<a*a*(y-0.5)){
			if(d1<0){
				d1 += b*b*(2*x+3);
				x ++;
			}
			else{
				d1 += (b*b*(2*x+3)+a*a*(-2*y+2));
				x ++;
				y --;
			}
			g.drawString("+", x+pointx, y+pointy);
		}//上半部分
		d2 = (float) (Math.pow(b*(x+0.5), 2)+Math.pow(a*(y-1), 2)-Math.pow(a*b, 2));
		while(y>0){
			if(d2<0){
				d2 += b*b*(2*x + 2)+ a*a*(-2*y + 3) ;
				x++;
				y--;
			}
			else{
				d2 += a*a*(-2*y + 3) ;
				y --;
			}
			g.drawString("+", x+pointx, y+pointy);
		}
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try{
		}catch(Exception e){e.printStackTrace();}
	}
	
}

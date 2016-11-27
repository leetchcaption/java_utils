package 中点画线法;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class 中点画线法 extends JFrame {
	public static void main(String arg[]){
		while(true){
			int x1=0,y1=0;
			int x2=0,y2=0;
			JFrame jf =new JFrame();
			jf.setSize(800,600);
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入起点坐标:");
			x1 = sc.nextInt(); y1 = sc.nextInt();
			System.out.println("请输入终点坐标：");
			x2 = sc.nextInt(); y2 = sc.nextInt();
			MyPanel mp = new MyPanel(x1,y1,x2,y2);
			jf.add(mp);
			Thread t = new Thread(mp);
			t.start();
			//System.out.println("程序运行完成!");
			//mp.MidpointLine(x1, y1, x2, y2);
			jf.setVisible(true);
		}
	}	
}
class MyPanel extends JPanel implements Runnable{
	int x1,y1,x2,y2;
	public MyPanel(int x1,int y1,int x2,int y2){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}
	public void paint(Graphics g){     //中点画线算法
		g.setColor(Color.blue);
		int a,b,delta1,delta2,d,x,y;
		a = y1-y2;
		b = x1-x2;
		d = 2*a+b;
		delta1 = 2*a;
		delta2 = 2*(a+b);
		x = x1;
		y = y1;
		g.drawString("*", x, y);
		while(x<x2){
			if(d<0){
				x++;
				y++;
				d += delta2;
			}
			else{
				x++;
				d += delta1;		
			}
			g.drawString("*", x, y);
		}
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		/*try{
			Thread.sleep(10);
		}catch(Exception e){} */
	}
	
}

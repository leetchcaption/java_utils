package ��Բ��ɨ��ת��;
import java.awt.*;

import javax.swing.*;

import java.io.*;
import java.util.*;
public class Ellipse extends JFrame{
	static int x ;
	static int y;
	static int a,b ; 
	static JFrame f = new JFrame();     //��f,mp,t,Ϊ�Ǿ�̬�ֶ�ʱ��static void main()���治���Զ���ֱ�ӷ���
	public static void main(String arg[]){
		f.setSize(900, 600);
		f.setLocation(100,100);
		System.out.println("������ԭ������:");
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt(); 
		System.out.println("������ؾ�:");
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
		// TODO �Զ����ɵĹ��캯�����
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
		}//�ϰ벿��
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
		// TODO �Զ����ɵķ������
		try{
		}catch(Exception e){e.printStackTrace();}
	}
	
}

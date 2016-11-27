import java.awt.*;
import java.util.*;
import java.awt.Paint;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Bezier曲线 extends JFrame {
	static ArrayList points = new ArrayList();   //获得点坐标
	static int si;
	public static void main(String arg[]){
		new Bezier曲线("Bezier");
	}
	public Bezier曲线(String s){
		super(s);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//在退出时同时关闭该进程
		points= new ArrayList();
		this.setLocation(200,100);
		this.setSize(650,500);
		this.setBackground(Color.gray);
		this.setVisible(true);
		JOptionPane.showMessageDialog(null, "左键选择点，右键停止选点");
		this.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent e){
				if(e.getButton() == MouseEvent.BUTTON1){   //Button1 左键
					points.add(new Point(e.getX(),e.getY()));
					repaint();
				}
				if(e.getButton() == MouseEvent.BUTTON3){  //Button3 右键
					si = points.size();
					si = si ;
					System.out.println(si);
					JOptionPane.showMessageDialog(null,"finish");
					repaint();
				}
			}
		});
	} 
	public Bezier曲线(ArrayList al,int count){
		this.setLocation(200,100);
		this.setBackground(Color.black);
		this.setSize(700,500);
		this.setVisible(true);
		repaint();
	}
	@SuppressWarnings("rawtypes")
	public void paint(Graphics g){
		Iterator it = points.iterator();
		while (it.hasNext()){
			Point q = (Point)it.next();
			g.fillOval(q.x, q.y, 5, 5);
		}
		if(si>1) drawBezier(g);
	}
	public void drawBezier(Graphics g){
		Iterator it =points.iterator();
		float t ;
		float p[][] = new float[si][2];
		for(int j=0;it.hasNext();j++){
			Point q = (Point)it.next();
			p[j][0] = q.x;
			p[j][1] = q.y;
			int j1 = j+1;
			System.out.println("第"+j1+"点的坐标为: X="+q.x+" Y="+q.y);			
		}
		float [] f = new float[si];
		f = sf(si);
		int rate = 200,x0 =(int)p[0][0],x1,y1;
		int y0=(int)p[0][1];
		g.setColor(Color.blue);
		for(int i =0;i<si-1;i++){
			g.drawLine((int)p[i][0], (int)p[i][1],(int)p[i+1][0], (int)p[i+1][1]);
		}
		int s = si-1;
		for(t=0;t<=1;t+=1.0/rate){
			double xt = 0;
			double yt = 0;
			for(int i=0;i<si;i++){
				double m = f[i]*Math.pow(t,i)*Math.pow(1-t, s-i)*p[i][0];
				xt = xt+m ;
			}
			for(int i=0;i<si;i++){
				double m = f[i]*Math.pow(t,i)*Math.pow(1-t, s-i)*p[i][1];
				yt = yt+m;
			}
			x1 = (int)(xt);
			y1 = (int)(yt);
			g.setColor(Color.red);
			g.drawLine(x0, y0, x1, y1);
			x0 = x1 ;
			y0 = y1 ;
		}
	}
	public static float[] sf(int num){
		int n = num-1;
		float[] list = new float[n+1];
		list[0] = 1 ;
		for(int i = 1;i<n;i++){
			float add = 1 ;
			for(int j =n,k=1;k<=i;j--,k++){
				add = add*j;
				add = add/k;
			}
			list[i] = add;
		}
		for(int i =0;i<num;i++){
			if(list[i]==0)
				list[i] = 1 ;
		}
		return list;
	}
}

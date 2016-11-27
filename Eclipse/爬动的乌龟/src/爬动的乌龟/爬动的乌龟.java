package 爬动的乌龟;
import java.awt.*;
import javax.swing.*;

public class 爬动的乌龟 {
	public static void main(String arg[]){
		JFrame f = new JFrame();
		f.setSize(800,600);
		MyPanel M = new MyPanel();
		f.add(M);
		Thread t = new Thread(M);
		t.start();
		f.setVisible(true);
	}
}
class MyPanel extends JPanel implements Runnable{
	int X[]={320,350,400,437,390,364};		//定点X坐标;
	int Y[]={240,290,290,240,132,132};		//定点Y坐标；
	int x = 365 ;
	int y = 60 ;
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(new Color(100,255,255));
		g.fillOval(x, y, 30, 60);		//乌龟头部
		g.fillRoundRect(x-85, y+120, 100, 90, 10, 10);
		g.fillRoundRect(x+15, y+120, 100, 90, 10, 10);
		g.drawOval(x-65, y+40, 160, 240);
		g.setColor(Color.BLUE);
		g.fillOval(x-65, y+40, 160, 240);
		g.setColor(Color.RED );
		g.drawPolygon(X,Y,6);
		g.fillPolygon(X,Y,6);
		g.setColor(Color.GREEN );
		g.drawLine(300, 242, 320, 240);
		g.drawLine(330, 314, 350, 290);
		g.drawLine(420, 320, 400, 290);
		g.drawLine(456, 238, 437, 240);
		g.drawLine(405, 106, 390, 132);
		g.drawLine(350, 106, 364, 132);
		g.fill3DRect(370, 233, 20, 20, true);
		g.setColor(Color.GRAY);
		g.fillOval(370, 75, 6, 6);
		g.fillOval(380, 75, 6, 6);
		g.drawString("Hello JAVA!", 350, 210);
	}
	public void run(){
		while(true){
			y++;
			if(y>400){
				y = 0;
			}
			try{
				Thread.sleep(30);
			}catch(Exception e){}
			repaint();
		}
	}
}
package 鼠标控制小球_测试版;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class 鼠标控制小球_测试版 {
	public static void main(String arg[]){
		Frame f = new Frame();
		f.setSize(1000,600);
		Mypanel M = new Mypanel();
		f.add(M);
		f.addMouseMotionListener(M);
		M.addMouseMotionListener(M);
		f.show();
	}
}
class Mypanel extends Panel implements MouseMotionListener{
	int x = 100;
	int y = 100;
	public void paint(Graphics G){
		G.fillOval(x, y, 30, 30);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
		x = e.getX();
		y= e.getY();
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
	}
	
}
package ������С��_���԰�;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ������С��_���԰� {
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
		// TODO �Զ����ɵķ������
		x = e.getX();
		y= e.getY();
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO �Զ����ɵķ������
	}
	
}
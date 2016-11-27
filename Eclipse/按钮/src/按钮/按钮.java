package 按钮;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class 按钮 {
	public static void main(String arg[]){
		JFrame f=new JFrame();
		f.setSize(400,300);
		Mypanel m=new Mypanel();
		f.add(m);
		f.addMouseListener(m);
		m.addMouseListener(m);
		f.setVisible(true);
	}
}
class Mypanel extends JPanel implements MouseListener{
	boolean tag=true;
	public void paint(Graphics g){
		if(tag){
			g.setColor(Color.white);
			g.drawLine(200, 100, 250, 100);
			g.drawLine(200, 100, 200, 130);
			g.setColor(Color.black);
			g.drawLine(200, 130, 250, 130);
			g.drawLine(250, 100, 250, 130);
		}else{
			g.setColor(Color.black);
			g.drawLine(200, 100, 250, 100);
			g.drawLine(200, 100, 200, 130);
			g.setColor(Color.white);
			g.drawLine(200, 130, 250, 130);
			g.drawLine(250, 100, 250, 130);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(e.getX()>200&&e.getX()<250 && e.getY()>100&&e.getY()<130){
			tag=false;
			this.repaint();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		tag=true;
		repaint();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
}

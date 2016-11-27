package 记事本的实现;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
public class JAVA链表系统库 {
	static JFrame f = new JFrame();
	static MPanel mp = new MPanel();
	public static void main(String arg[]){
		f.setLocation(200,100);
		f.setSize(300, 600);
		f.add(mp);
		
		f.addKeyListener(mp);
		mp.addKeyListener(mp);
		
		f.setVisible(true);
	}
}
class MPanel extends JPanel implements KeyListener{
	LinkedList ll = new LinkedList();
	int con = 0;
	public void paint(Graphics g){
		super.paint(g);
		for(int i =0;i<ll.size();i++){
			g.drawString(""+ll.get(i).toString(), 10+8*i, 10);
		}g.drawLine(10+con*8, 0, 10+con*8, 10);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		if(e.getKeyCode() >= KeyEvent.VK_A && e.getKeyCode() <= KeyEvent.VK_Z){
			ll.add(con,e.getKeyChar()) ;
			con ++ ;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(con>0){
				con -- ;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(con<ll.size()){
				con ++ ;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_DELETE){
			if(con < ll.size()){
				ll.remove(con);
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			if(con>0){
				ll.remove(con-1);
				con -- ;
			}
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
}

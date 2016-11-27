package 记事本的实现List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class List_notebook {
	static JFrame f = new JFrame();
	static MyPanel mp = new MyPanel();
	public static void main(String arg[]){
		f.setLocation(200,100);
		f.setSize(300,500);
		f.add(mp);
		f.addKeyListener(mp);
		mp.addKeyListener(mp);
		f.setVisible(true);
	}
}
class Node{
	public char value = ' ';
	public Node next = null ;
}
class MyPanel extends JPanel implements KeyListener{
	Node firstNode = new Node();
	Node nowNode = firstNode ;
	int con = 0 ;
	public void paint(Graphics g){
		super.paint(g);	
		Node tmpNode = firstNode;
		int x = 0;
		while(tmpNode.next != null){
			g.drawString(""+tmpNode.next.value, 10+8*x, 10);
			x ++ ;
			tmpNode = tmpNode.next;
		}
		g.drawLine(10+con*8, 0, 10+con*8, 10);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		if(e.getKeyCode() >=KeyEvent.VK_A){
			if(nowNode.next == null){
				Node nd = new Node();
				nd.value = e.getKeyChar();
				nowNode.next = nd ;  //后插法
				nowNode = nd ;
				//nd.next = nowNode.next;   //前插法
				//nowNode.next = nd ;
				con++ ;
			}else{
				Node nd = new Node();
				nd.value = e.getKeyChar();
				nd.next = nowNode.next ;
				nowNode.next = nd ;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(con>0){
				con -- ;
				Node tmpNode = firstNode ;
				while(tmpNode.next != nowNode){
					tmpNode = tmpNode.next ; 
				}nowNode = tmpNode ; //修改nowNode的值
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(nowNode.next != null){
				con ++ ;
				nowNode = nowNode.next ;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_DELETE){
			if(nowNode.next != null){
				nowNode.next = nowNode.next.next;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
}
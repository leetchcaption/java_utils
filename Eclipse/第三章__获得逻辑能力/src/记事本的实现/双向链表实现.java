/**
 * 
 */
package 记事本的实现;

/**
 * @author Leetch
 *
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class 双向链表实现 {
	static JFrame f = new JFrame();
	static NewPanel np = new NewPanel();
	public static void main(String arg[]){
		f.setLocation(300,100);
		f.setSize(300,600);
		f.add(np);
		f.addKeyListener(np);
		np.addKeyListener(np);
		f.setVisible(true);
	}
}
class Node {
	char value = ' ';
	Node next = null ;
	Node befor = null ;
}
class NewPanel extends JPanel implements KeyListener{
	int con = 0 ;
	Node frist = new Node() ;
	Node nownode = frist ;
	public void paint(Graphics g){
		super.paint(g);
		int x = 0 ;
		Node node = frist;
		while(node.next != null){
			g.drawString(""+node.value, 10+8*x, 10);
			x ++ ;
			node = node .next;
			//node.next.befor = node ;
		}
		g.drawLine(10+8*con, 0, 10+8*con, 10);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		if(e.getKeyCode() >= KeyEvent.VK_A && e.getKeyCode() <= KeyEvent.VK_Z){
			if(nownode.next == null){
				Node cnode = new Node();
				cnode.value = e.getKeyChar() ;
				nownode.next = cnode ;
				cnode.befor = nownode ;
				nownode = cnode ;
				con ++ ;
			}else{
				Node cnode = new Node();   //创建新节点
				cnode.value = e.getKeyChar(); //给节点node赋值
				cnode.next = nownode.next;//让新节点的next 指向下一个节点
				nownode.next.befor = cnode ;
				nownode.next = cnode ;  //让当前节点的next指向新节点
				cnode.befor = nownode ;
				nownode = cnode ;   //维护nownode和光标位置
				con++ ;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(con > 0){
				con-- ;
				nownode = nownode.befor;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(nownode.next != null){
				con ++ ;
				nownode = nownode.next ;
			}
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
}

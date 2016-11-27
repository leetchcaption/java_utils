package 记事本的实现;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class arrey_notebook {
	public static void main(String s[]){
		JFrame f = new JFrame();
		f.setLocation(200,100);
		f.setSize(300, 500);
		Mypanel mp = new Mypanel();
		f.add(mp);
		f.addKeyListener(mp);
		mp.addKeyListener(mp);
		f.setVisible(true);
	}
}
class Mypanel extends JPanel implements KeyListener{
	char c[] = new char[1000];
	int size = 0 ;
	int loca = 0 ;
	public void paint(Graphics g){
		super.paint(g);
		for(int i = 0;i<size ; i++){
			g.drawString(""+c[i], 10+8*i, 10);
		}
		g.drawLine(10+8*loca, 0, 10+8*loca, 10);
	} 
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根	
			for(int i = size ; i>loca ;i--){
				c[i] = c[i-1];
			}
			c[loca] = e.getKeyChar();
			size ++ ;
			loca ++ ;
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(loca > 0 ){
				loca -- ;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(loca < size){
				loca ++ ;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_DELETE){   //delete
			if(loca < size){
				for(int i=loca;i<size;i++){
					c[i]=c[i+1];
				}size --;//loca --;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			if(loca>0){
				for(int i=loca;i<=size;i++){
					c[i-1] = c[i];
				}
				size --;
				loca --;
			}
		}
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根		
	}	
}
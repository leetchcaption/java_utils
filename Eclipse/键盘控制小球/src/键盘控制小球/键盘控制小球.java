package ���̿���С��;
import java.awt.*;
import java.awt.event.*;

public class ���̿���С��{
	public static void main(String arg[]){
		Frame F = new Frame ();
		F.setSize(1000,600);
		F.setBackground(new Color(24,56,78));
		Mypanel M = new  Mypanel();
		F.add(M);
		F.addKeyListener(M);   //ע���¼�
		M.addKeyListener(M);
		
		F.show();
	}
}
class Mypanel extends Panel implements KeyListener{
	int x = 100;
	int y = 100;
	int m = 500;
	int n = 400;
	public void paint(Graphics G){
		G.setColor(Color.blue);
		G.fillOval(x, y, 30, 30);
		G.setFont(new Font("",0,30));
		G.drawString("JAVA", m, n);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getKeyCode() == 37){
			x--;
			System.out.println("��");
		}
		if(e.getKeyCode() == 38){
			y--;
		}
		if(e.getKeyCode() == 39){
			x++;
		}
		if(e.getKeyCode() == 40){
			y++;
		}
		if(e.getKeyChar() == 'w'){
			n--;
		}
		if(e.getKeyChar() == 's'){
			n++;
		}
		if(e.getKeyChar() == 'a'){
			m--;
		}
		if(e.getKeyChar() == 'd'){
			m++;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}
}
package ����ĸ��Ϸ_���԰�;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ����ĸ��Ϸ_���԰� {
	public static void main(String arg[]){
		JFrame f = new JFrame();
		f.setSize(1000,600);
		lei K = new lei();
		f.add(K);
		Thread t = new Thread(K);
		t.start();
		f.addKeyListener(K);  //ע���¼�
		K.addKeyListener(K);
		f.setVisible(true);
	}
}
class lei extends JPanel implements Runnable,KeyListener{
	int x[] = new int[10];
	int y[] = new int[10];
	char s[] = new char[10];
	int score =1000;
	lei(){
		for(int i=0;i<10;i++){
			x[i] = (int)(Math.random()*950+10);
			y[i] = (int)(Math.random()*450+30);
			s[i] = (char)(Math.random()*26+65);
		}
	}
	public void paint(Graphics G){
		super.paint(G);
		for(int i=0;i<10;i++){
			G.setFont(new Font("",0,32));
			G.drawString(new Character(s[i]).toString(), x[i], y[i]);
			G.setColor(Color.red);
			G.drawString("��ĳɼ�:"+score, 740, 30);
			G.setColor(Color.black);
		}
	}
	public void run(){
		while(true){
			try{
				for(int i=0;i<10;i++){
					y[i]++;
					if(y[i]>500){
						x[i] = (int)(Math.random()*950+10);
						y[i] = (int)(Math.random()*450+30);
						s[i] = (char)(Math.random()*26+65);
						score -=100;
					}
				}
				Thread.sleep(30);
			}catch(Exception e){}
			repaint();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int nowy=0;       //��ǰy��������
		int index=-1;    //�洢�±�
		char arg=e.getKeyChar();
		for(int i=0;i<10;i++){
			if(arg == s[i]){
				if(y[i]>nowy){
					nowy = y[i];
					index = i;
				}
			}
		}
		if(index != -1){
			y[index] = 0;
			x[index] = (int)(Math.random()*950+10);
			s[index] = (char)(Math.random()*26+65);
			score +=100;
		}else{
			score -=100;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}
}

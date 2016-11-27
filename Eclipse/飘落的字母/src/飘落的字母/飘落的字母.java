package 飘落的字母;
import java.awt.*;
import javax.swing.*;
public class 飘落的字母{
	public static void main(String arg[]){
		JFrame f = new JFrame();
		f.setBackground(Color.BLACK);
		f.setSize(1000,600);
		Mypanel m = new Mypanel();
		f.add(m);
		
		Thread t = new Thread(m);
		t.start();
		f.setVisible(true);
	}
}
class Mypanel extends JPanel implements Runnable{
	int x[] = new int[30];
	int y[] = new int[30];
	Mypanel(){  //构造方法
		for(int i=0;i<30;i++){
			x[i] = (int)(Math.random()*1000);
			y[i] = (int)(Math.random()*600);
		}
	}
	public void paint(Graphics G){   //归根结底是数组问题！！！
		super.paint(G);
		String chars="Abcdefghijklmnopqrstuvwxyz" ; 
		G.setColor(Color.white);
		for(int i=0;i<30;i++){
			//G.setColor(new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255)));
			String str = String.valueOf(chars.charAt((int)(Math.random() * 26)));
			G.setFont(new Font("",0,33));
			G.drawString(str, x[i], y[i]);
		}
	}
	public void run(){
		while(true){
			try{
				for(int i=0;i<30;i++){
					y[i]++;
					if(y[i]>500){
						x[i] = (int)(Math.random()*800+10);
						y[i] = (int)(Math.random()*420+30);
					}
				}
				Thread.sleep(30);
			}catch(Exception e){}
			repaint();
		}
	}
}
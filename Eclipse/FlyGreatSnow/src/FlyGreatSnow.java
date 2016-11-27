import java.awt.*;
import javax.swing.*;
public class FlyGreatSnow {
	public static void main(String Arg[]){
		JFrame f = new JFrame();
		f.setSize(1000,700);
		Mypanel M = new Mypanel();
		Thread t = new Thread(M);
		t.start();
		f.add(M);
		Container C = f.getContentPane();
		C.setBackground(Color.black);   //������ɫ
		//f.getContentPane().setBackground(Color.black);
		//f.setBackground(Color.black);
		f.setVisible(true);
	}
}
class Mypanel extends JPanel implements Runnable{
	int x[] = new int[450];
	int y[] = new int[450];
	//int i; 
	Mypanel(){   //���췽��������ͬ����������ʼ�����ö��������ɵ���һ���л�����һЩ������������
		for(int i=0;i<450;i++){
			x[i] = (int)(Math.random()*1360);
			y[i] = (int)(Math.random()*768);
		}
	}
	public void paint(Graphics G){
		super.paint(G);
		G.setColor(Color.white);
		for(int i=0;i<450;i++){
			G.setFont(new Font("",0,24));
			G.drawString("*", x[i], y[i]);
		}	
	}
	public void run(){
		while(true){
			try{
				for(int i=0;i<450;i++){
					y[i] = y[i]+3;
					x[i]++;
					if(y[i]>768 ){
						y[i] = (int)(Math.random()*350);
					}
					if(x[i]>1360){
						x[i] = (int)(Math.random()*900);
					}
				}
				Thread.sleep(15);
			}catch(Exception e){}
			repaint();
		}
	}
}

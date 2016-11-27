import java.awt.*;
import javax.swing.*;
public class Wugui{
	public static void main(String arg[]){
		JFrame f = new JFrame();
		f.setSize(800,600);
		Mypanel x= new Mypanel();
		f.add(x);
		Thread t = new Thread(x);
		t.start();
		f.setVisible(true);
	}
}
class Mypanel extends JPanel implements Runnable{
	int x = 100;
	int y = 100;
	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(x, y, 100, 100);
	}
	public void run(){
		int flag =0;
		while(true){
			if(flag == 0){
				x++;
				y++;
			}else if(flag == 1){
				x--;
				y++;
			}else if(flag == 2){
				x--;
				y--;
			}else if(flag == 3){
				x++;
				y--;
			}
			if(x+120>800){
				if(flag == 0){
					flag = 1;
				}else  flag =2;
			}
			if(y+133>600){
				if(flag == 1){
					flag = 2;
				}else flag = 3;
			}
			if(x<0){
				if(flag == 2){
					flag = 3;
				}else flag = 0;
			}
			if(y<0){
				if(flag == 3){
					flag = 0;
				}else flag = 1;
			}
			try{
				Thread.sleep(10);
			}catch(Exception e){}
			repaint();
		}
	}
}
import java.awt.*;

public class FlyingBoll {
	public static void main(String arg[]){
		Frame fm = new Frame();
		fm.setSize(1368, 768);
		fm.setBackground(Color.blue);
		MyPanel css = new MyPanel();
		fm.add(css);
		
		Thread t = new Thread(css);  //建立线程
		t.start();  //此时的线程处于就绪状态，随时等待CPU的轮转调度
		
		fm.show();
		System.out.println("Hello~");
	}
}

class MyPanel extends Panel implements Runnable{
	int x = 300;
	int y = 100;
	public void paint(Graphics G){
		G.setColor(Color.WHITE);
		G.fillOval(x, y, 50, 50);
		
	/*  int x=300,y=100;
		while(y<700){
			G.setColor(Color.WHITE);
			G.fillOval(x, y, 50, 50);
			//G.setColor(Color.blue);
			G.fillOval(x, y, 50, 50);
			//x=x+3;
			y=y+3;
		}*/
	}
	public void run(){
		while(true){
			y++;x++;
			if(y>600 || x>1000){
				y = 10;
				x = 10;
			}
			try{
				Thread.sleep(10);
			}catch(Exception e){}
			repaint(); //发出repaint的系统调用，系统见到后会调用paint，进行重画操作；
		}
	}
}

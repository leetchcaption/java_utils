import java.awt.*;

public class LiangQiuZhuangQiang {
	public static void main(String arg[]){
		Frame F = new Frame();
		F.setBackground(Color.GRAY);
		F.setSize(1000,600);
		MyPanel css = new MyPanel();
		F.add(css);
		Thread t = new Thread(css);
		t.start();
		
		F.show();
	}
}
class MyPanel extends Panel implements Runnable{
	int x=0,y=0,m=950,n=500;
	int tab1=0,tab2=0;
	public void paint(Graphics G){
		G.setColor(Color.orange);
		G.fillOval(x, y, 50, 50);
		G.setColor(Color.yellow);
		G.fillOval(m, n, 50, 50);
	}
	public void run(){
		while(true){
			if(x+65>1000){
				if(tab1 == 0){
					tab1 = 1;
				}else tab1 = 2;
			}
			if(y+85>600){
				if(tab1 == 1){
					tab1 = 2;
				}else tab1 = 3;
			}
			if(x<0){
				if(tab1 == 2){
					tab1 = 3;
				}else tab1 = 0;
			}
			if(y<0){
				if(tab1 == 3){
					tab1 = 0;
				}else tab1 = 1;
			}
			if(m+65>1000){
				if(tab2 == 0){
					tab2 = 1;
				}else tab2 = 2;
			}
			if(n+85>600){
				if(tab2 == 1){
					tab2 = 2;
				}else tab2 = 3;
			}
			if(m<0){
				if(tab2 == 2){
					tab2 = 3;
				}else tab2 = 0;
			}
			if(n<0){
				if(tab2 == 3){
					tab2 = 0;
				}else tab2 = 1;
			}
			if(tab1==0){
				x++;y++;
			}else if(tab1==1){
				x--;y++;
			}else if(tab1==2){
				x--;y--;
			}else if(tab1==3){
				x++;y--;
			}
			if(tab2==0){
				m++;n++;
			}else if(tab2==1){
				m--;n++;
			}else if(tab2==2){
				m--;n--;
			}else if(tab2==3){
				m++;n--;
			}
			try{
				Thread.sleep(5);
			}catch(Exception e){}
		repaint();
		}
	}
}

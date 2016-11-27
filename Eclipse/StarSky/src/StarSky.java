import java.awt.*;

public class StarSky{
	public static void main(String ARg[]){
		Frame f = new Frame ();
		f.setSize(1368,768);
		f.setBackground(Color.BLACK );
		MyPanel fm = new MyPanel();
		f.add(fm);
		Thread t = new Thread(fm);
		t.start();
		f.show ();
	}
}
class MyPanel extends Panel implements Runnable{
	int x=20,y=60;
	int flag=0;//用于标示方向：0：↘；1：↙；2：↖；3：↗；
	public void paint(Graphics G){
		G.setColor(new Color(160,32,240));
		G.fillOval(x, y, 100, 100);
		G.setColor(Color.BLACK);
		G.fillOval(x+40, y-10, 100, 100);
		for(int k=0;k<300;k++){
			G.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
			G.setFont(new Font("",0,32));
			G.drawString("*", (int)(Math.random()*1368), (int)(Math.random()*1368));
		}
	}
	public void run(){
		while(true){
			if(flag == 0){   //定义飞行姿态
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
			
			if(x+100>1368){  //撞墙后改变方向
				if(flag == 0){
					flag=1;
				}else flag=2;
			}
			if(y+135>768){
				if(flag == 1){
					flag=2;
				}else flag=3;
			}
			if(x<0){
				if(flag == 2){
					flag =3;
				}else flag=0;
			}
			if(y<0){
				if(flag == 3){
					flag=0;
				}else flag=1;
			} 
			try{
				Thread.sleep(10);
			}catch(Exception e){}
			repaint();
		}
	}
}

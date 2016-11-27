import java.awt.*;

public class XiaoQiuWall {
	public static void main(String arg[]){
		System.out.println("Hello ,小球撞墙！");
		Frame F = new Frame();
		F.setBackground(new Color(160,32,140));
		F.setSize(1000, 600);
		MyPanel Boll = new MyPanel();
		F.add(Boll);
		Thread t = new Thread(Boll);
		t.start();
		F.show();
	}
}
class MyPanel extends Panel implements Runnable{
	int x=0;
	int y=0;
	int flag=0;//状态标识;0表示↘；1表示↙；2表示↖；3表示↗；
	public void paint(Graphics G){       //画小球
		G.setColor(new Color(flag*40,flag*10,flag*80));
		G.fillOval(x, y, 50, 50);
	}
	public void run(){
		while(true){
			if(flag == 0){
				x++;y++;
			}else if(flag == 1){
				x--;y++;
			}else if(flag == 2){
				x--;y--;
			}else if(flag == 3){
				x++;y--;
			}
			if(x+65>1000){
				if(flag == 0){
					flag = 1;
				}else{
					flag =2;
				}
			}
			if(y+85>600){
				if(flag == 1){
					flag =2;
				}else{
					flag =3;
				}
			}
			if(x<0){
				if(flag == 2){
					flag =3;
				}else{
					flag =0;
				}
			}
			if(y<0){
				if(flag == 3){
					flag =0;
				}else{
					flag =1;
				}
			}try{
				Thread.sleep(6);
			}catch(Exception e){}
			repaint();
		}
	}
}

package ����ĸ��Ϸ;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class ����ĸ��Ϸ {
	public static void main(String arg[]){
		JFrame f = new JFrame();
		//f.setBackground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
		//f.getContentPane().setBackground(Color.blue);
		f.setSize(850, 600);
		Mypanel comp = new Mypanel();
		comp.setBackground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
		f.add(comp);
		Thread t = new Thread(comp);
		t.start();		
		f.setLayout(new BorderLayout());
		//f.add(comp.p1,BorderLayout.SOUTH);   ????
		f.add(comp);
		f.addKeyListener(comp);//ע�������Ӧ�¼�
		comp.addKeyListener(comp);
		f.setVisible(true);
		//System.out.println((char )a);
	}
}
class Mypanel extends JPanel implements Runnable,KeyListener,ActionListener{   //����ӿ���,����
	int x[] = new int[10];
	int y[] = new int[10];
	char c[] = new char[10];
	int w=30;
	int  score = 1000;
	JButton b1 = new JButton("����");
	JButton b2 = new JButton("�м�");
	JButton b3 = new JButton("�߼�");
	JPanel p1 = new JPanel();
	Mypanel(){//���췽�����൱�ڶ�Mypanel�������г�ʼ����û��˭��˭��
		for(int i=0;i<10;i++){
			x[i] = (int)(Math.random()*800+10);
			y[i] = (int)(Math.random()*420+30);
			c[i] = (char)(Math.random()*26+65);
		}
		p1.setLayout(new FlowLayout());
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
	}
	public void paint(Graphics G){
		super.paint(G);
		for(int i=0;i<10;i++){	
			G.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
			G.setFont(new Font("",0,32));
			G.drawString(new Character(c[i]).toString(), x[i], y[i]);
			G.setColor(Color.BLUE);
			G.drawString("-----------------------------���Ƿָ���--------------------------------", 0, 455);
			G.setColor(Color.red);
			G.drawString("���ĳɼ�:"+score, 600, 50);
			if(score<=0){
				G.drawString("���������������ѽ��", 300, 300);
			}
		}
	
	}
	public void run(){
		while(true){
			for(int i=0;i<10;i++){
				y[i]++;
				if(y[i]>450){
					y[i] = (int)(Math.random()*300+20);
					x[i] = (int)(Math.random()*800+5);
					c[i] = (char)(Math.random()*26+65);
					score = score-20;
				}
			}
			try{
				Thread.sleep(w);
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
		int index=-1;
		int nowy=0;
		char arg = e.getKeyChar();
		//System.out.println("HDCB");
		for(int i=0;i<10;i++){
			if(arg == c[i]){
				if(y[i]>nowy){
					nowy = y[i];
					index = i;
				}
			}
		}
		if(index != -1){
			y[index] = (int)(Math.random()*200);
			x[index] = (int)(Math.random()*800);
			c[index] = (char)(Math.random()*26+65);
			score += 20;
		}else{
			score -= 100;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getActionCommand().equals("�߼�")){
			w = 5 ;
			System.out.println("�߼�");
		}
		if(e.getActionCommand().equals("�м�")){
			w = 30;
			System.out.println("�м�");
		}
		if(e.getActionCommand().equals("����")){
			w = 50;
			System.out.println("����");
		}
	}

}
package com.leetch.java;
import java.awt.*;
import java.awt.event.*;
import java.awt.peer.LabelPeer;

import javax.swing.*;
class Travil extends JFrame implements KeyListener{
	private JTextArea[][] grids ;    //��Ÿ��Ե��ı���
	private int data[][];			//��Ӧÿ�����ӵ����ݣ�1�����У�0����û��
	private int rect;				//��ǰ����ķ������ͣ���Ӧall�е�����
	private int[] allRect;			//���еķ������ͣ���16���ֽ�����¼
	private int x,y; 				//��ǰ���������λ�ã�x�����У�y������
	private int score;				//�÷֣�ÿ��ʧһ�е�һ��
	private JLabel getscore;		//������ʾ�����ı�ǩ
	private boolean running;		//�ж���Ϸ�Ƿ����
	public Travil(){				//���캯����������г�ʼ��
		grids = new JTextArea[21][12];//����ߣ����ұߺ����±���Ϊ��Ϸ�ı߿�
		data = new int[21][12];			//��������Ӧ������
		//���еķ������ͣ���16���ֽ�����¼����ռ�ø������
		allRect = new int []{0xcc,0x8888,0xf,0xc44,0x2e,0x88c,0xe8,0xc88,
				0xe2,0x44c,0x8e,0x8c4,0x6c,0x4c8,0xc6,0x8c8,0x4e,0x4c4,0xe4};
		getscore = new JLabel("Socre:0");
		running = false;
		init();							//��ʼ��		
	}
	public void init(){
		JPanel mainJPanel = new JPanel();			//�����
		JPanel rightJPanel = new JPanel();				//��Ϣ���
		mainJPanel.setLayout(new GridLayout(21,12,1,1));  //��岼��
		for(int i=0;i<grids.length;i++){
			for(int j=0;j<grids[i].length;j++){
				grids[i][j] = new JTextArea(20,20);
				grids[i][j].setBackground(Color.white);
				if(j==0 || j==grids[i].length-1 || i==grids.length-1){
					grids[i][j]=new JTextArea(20,20);
					grids[i][j].setBackground(Color.green);
					grids[i][j].addKeyListener(this);
					data[i][j]=1;
				}
				grids[i][j].setEditable(false);
				mainJPanel.add(grids[i][j]);
			}	
		}
		rightJPanel.setLayout(new GridLayout(4,4,1,1));
		rightJPanel.add(new JLabel(" a : left"));
		rightJPanel.add(new JLabel(" d : right"));
		rightJPanel.add(new JLabel(" s : down"));
		rightJPanel.add(new JLabel(" w : change"));
		rightJPanel.add(new JLabel(""));
		rightJPanel.add(getscore);
		this.setLayout(new BorderLayout());
		this.add(mainJPanel,BorderLayout.CENTER);
		this.add(rightJPanel,BorderLayout.EAST);
		running = true;
	}
	public void ranRect(){        //���������������
		rect = allRect[(short)(Math.random()*19)];
	}
	public void keyPressed(KeyEvent arg0) {}
	public void keyReleased(KeyEvent arg0){}
	public void keyTyped(KeyEvent arg0) {    //���񰴼��������ң����䣬���εĲ���
		// TODO �Զ����ɵķ������
		if(arg0.getKeyChar()=='a'){
			if (running==false) {
				return ;
			}
			if(y<=1) return ;
			int tmp = 0x8000;
			for (int i=x;i<x+4;i++){
				for(int j=y;j<y+4;j++){
					if((rect&tmp)!=0){
						if(data[i][j-1]==1)  return ;
					}
					tmp>>=1;  			//λ���ƶ�һλ
				}
			}
			clear(x,y);					//���ͼ��
			y--;
			draw(x,y);					//�ػ�ͼ��
		}
		if(arg0.getKeyChar()=='d'){		//���Ʋ���
			if (running==false) {
				return ;
			}
			int tmp = 0x8000;
			int num = 7;
			int m=x,n=y;
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					if((rect&tmp)!=0){
						if(n>num) num=n ;
					}
					tmp>>=1;
					n++;
				}
				m++;
				n-=4;
			}
			if(num>10) return ;
			tmp = 0x8000;
			for(int i =x;i<x+4;i++){
				for(int j=y;j<y+4;j++){
					if((rect&tmp)!=0){
						if(data[i][j+1]==1) return ;
					}
					tmp>>=1;
				}
			}
			clear(x,y);
			y++;
			draw(x,y);
		}
		if(arg0.getKeyChar()=='s'){     //���Ʋ���
			if(running == false){
				return ;
			}
			if(canFall(x,y)== false){
				saveData(x,y);
				return ;
			}
			clear(x,y);
			x++;
			draw(x,y);				//����ͼ��
		}
		if(arg0.getKeyChar()=='w'){			//���β���
			if(running==false){
				return ;
			}
			int i=0;
			for(;i<allRect.length;i++){
				if(rect==allRect[i]) break;
			}
			if(i==0) return ;
			clear(x,y); 
			if(i==1 || i==2){
				rect=allRect[i==1?2:1];				//ͼ������1
				if(y>7) y=7;
			}
			if(i>=3 && i<=6){
				rect=allRect[i+1>6?3:i+1];			//ͼ������2
			}
			if(i>=7 && i<=10){
				rect=allRect[i+1>10?7:i+1];			//ͼ������3
			}
			if(i==11 || i==12){
				rect=allRect[i==11?12:11];			//ͼ������4
			}
			if(i==13 || i==14){
				rect=allRect[i==13?14:13];			//ͼ������5
			}
			if(i>=15 && i<=18){
				rect=allRect[i+1>18?15:i+1];		//ͼ������6
			}
			if(y>8) y=8;
			draw(x,y);
		}
	}
	public void fall(int m,int n){
		if(m>0)  clear(m-1,n);
		draw(m,n);
	}
	public void draw(int m,int n){
		int tmp=0x8000;
		for(int j=0;j<4;j++){
			for(int k=0;k<4;k++){
				if((tmp&rect)!=0)  grids[m][n].setBackground(Color.black);  //���ݷ�������ݻ���ͼ�Σ���ɺ�ɫ
				tmp>>=1;
				n++;
			}
			m++;
			n-=4;
		}
	}
	public void clear(int m,int n){    //��m,n �������������
		int tmp = 0x8000;
		for(int j=0;j<4;j++){
			for(int k=0;k<4;k++){
				if((tmp & rect)!=0)   grids[m][n].setBackground(Color.white);
				tmp>>=1;
				n++;
			}
			m++;
			n-=4;
		}
	}
	public boolean canFall(int m,int n){      //�ж��Ƿ񻹿��Լ�������
		int tmp = 0x8000;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if((tmp&rect)!=0) {
					if(data[m+1][n]==1)  return false;//�����һ���ط��ж�������ֱ�ӷ���false
				}
				tmp>>=1;
				n++;
			}
			m++;
			n-=4;
		}
		return true ;
	}
	public void saveData(int m,int n){		//��m,n�����µķ��鱣�浽data������
		int tmp = 0x8000;
		for(int j=0;j<4;j++){
			for(int k=0;k<4;k++){
				if((tmp&rect)!=0){
					data[m][n] = 1;
				}
				tmp >>=1;
				n++;
			}
			m++;
			n-=4;
		}		
	}
	public void removeRow(int row){      //ɾ����row�У����ϵ��������½�
		for(int i = row;i>=1;i--){
			for(int j=1;j<=10;j++){
				data[i][j] = data[i-1][j];
			}
		}
		reflesh();  //ˢ��
		score++;
		getscore.setText("Score:"+getscore);		
	}
	public void reflesh(){    //����data����ˢ��ÿ������
		for(int i=1;i<20;i++){
			for(int j=1;j<11;j++){
				if(data[i][j]==1)  grids[i][j].setBackground(Color.black);
				else   grids[i][j].setBackground(Color.white);
			}
		}		
	}
	public void start(){     //�÷��鿪ʼ�Զ�����
		x=0;					//�����0��ʼ�������5��ʼ
		y=5;
		for(int i=0;i<21;i++){
			try{
				Thread.sleep(1000);
				if(canFall(x, y)==false){
					saveData(x, y);
					for(int k=x;k<x+4;k++){
						int sum=0;
						for(int j=1;j<=10;j++){
							if(data[k][j]==1)   sum++;
						}
						if(sum==10)  removeRow(k);
					}
					for(int j=1;j<=10;j++){
						if(data[3][j]==1){
							running = false;
							break;
						}
					}
					break;
				}
				x++;
				fall(x, y);
			}catch(Exception e2){e2.printStackTrace();}
		}	
	}
	public void showme(){    //��ʾ��������
		this.setSize(600,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void go(){   //��ʼ��Ϸ
		while(true){
			if(running == false) break;
			ranRect();
			start();
		}
		getscore.setText("Game Over!!!");
	}
}
	
public class TravilGame {
	public static void main(String arge[]){
		Travil travil = new Travil();
		travil.showme();
		travil.go();
	}
}

package com.leetch.java;
import java.awt.*;
import java.awt.event.*;
import java.awt.peer.LabelPeer;

import javax.swing.*;
class Travil extends JFrame implements KeyListener{
	private JTextArea[][] grids ;    //存放各自的文本域
	private int data[][];			//对应每个格子的数据，1代表有，0代表没有
	private int rect;				//当前下落的方块类型，对应all中的数据
	private int[] allRect;			//所有的方块类型，又16个字节来记录
	private int x,y; 				//当前方块的坐标位置，x代表行，y代表列
	private int score;				//得分，每消失一行得一分
	private JLabel getscore;		//用来显示分数的标签
	private boolean running;		//判断游戏是否结束
	public Travil(){				//构造函数，对其进行初始化
		grids = new JTextArea[21][12];//最左边，最右边和最下边作为游戏的边框
		data = new int[21][12];			//与格子相对应的数据
		//所有的方块类型，又16个字节来记录方块占用格子情况
		allRect = new int []{0xcc,0x8888,0xf,0xc44,0x2e,0x88c,0xe8,0xc88,
				0xe2,0x44c,0x8e,0x8c4,0x6c,0x4c8,0xc6,0x8c8,0x4e,0x4c4,0xe4};
		getscore = new JLabel("Socre:0");
		running = false;
		init();							//初始化		
	}
	public void init(){
		JPanel mainJPanel = new JPanel();			//主面板
		JPanel rightJPanel = new JPanel();				//信息面板
		mainJPanel.setLayout(new GridLayout(21,12,1,1));  //面板布局
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
	public void ranRect(){        //随机产生方块类型
		rect = allRect[(short)(Math.random()*19)];
	}
	public void keyPressed(KeyEvent arg0) {}
	public void keyReleased(KeyEvent arg0){}
	public void keyTyped(KeyEvent arg0) {    //捕获按键进行左，右，下落，变形的操作
		// TODO 自动生成的方法存根
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
					tmp>>=1;  			//位置移动一位
				}
			}
			clear(x,y);					//清除图像
			y--;
			draw(x,y);					//重绘图像
		}
		if(arg0.getKeyChar()=='d'){		//右移操作
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
		if(arg0.getKeyChar()=='s'){     //下移操作
			if(running == false){
				return ;
			}
			if(canFall(x,y)== false){
				saveData(x,y);
				return ;
			}
			clear(x,y);
			x++;
			draw(x,y);				//绘制图像
		}
		if(arg0.getKeyChar()=='w'){			//变形操作
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
				rect=allRect[i==1?2:1];				//图像类型1
				if(y>7) y=7;
			}
			if(i>=3 && i<=6){
				rect=allRect[i+1>6?3:i+1];			//图像类型2
			}
			if(i>=7 && i<=10){
				rect=allRect[i+1>10?7:i+1];			//图象类型3
			}
			if(i==11 || i==12){
				rect=allRect[i==11?12:11];			//图象类型4
			}
			if(i==13 || i==14){
				rect=allRect[i==13?14:13];			//图象类型5
			}
			if(i>=15 && i<=18){
				rect=allRect[i+1>18?15:i+1];		//图象类型6
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
				if((tmp&rect)!=0)  grids[m][n].setBackground(Color.black);  //根据方块的数据绘制图形，变成黑色
				tmp>>=1;
				n++;
			}
			m++;
			n-=4;
		}
	}
	public void clear(int m,int n){    //在m,n 坐标下清除方块
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
	public boolean canFall(int m,int n){      //判断是否还可以继续下落
		int tmp = 0x8000;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if((tmp&rect)!=0) {
					if(data[m+1][n]==1)  return false;//如果下一个地方有东西，则直接返回false
				}
				tmp>>=1;
				n++;
			}
			m++;
			n-=4;
		}
		return true ;
	}
	public void saveData(int m,int n){		//将m,n坐标下的方块保存到data数组中
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
	public void removeRow(int row){      //删除第row行，以上的依次往下降
		for(int i = row;i>=1;i--){
			for(int j=1;j<=10;j++){
				data[i][j] = data[i-1][j];
			}
		}
		reflesh();  //刷新
		score++;
		getscore.setText("Score:"+getscore);		
	}
	public void reflesh(){    //根据data数据刷新每个格子
		for(int i=1;i<20;i++){
			for(int j=1;j<11;j++){
				if(data[i][j]==1)  grids[i][j].setBackground(Color.black);
				else   grids[i][j].setBackground(Color.white);
			}
		}		
	}
	public void start(){     //让方块开始自动下落
		x=0;					//横向从0开始，纵向从5开始
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
	public void showme(){    //显示整个窗体
		this.setSize(600,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void go(){   //开始游戏
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

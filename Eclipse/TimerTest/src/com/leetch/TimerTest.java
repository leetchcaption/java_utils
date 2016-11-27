package com.leetch;
//接口的实现
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
public class TimerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ActionListener listener =new TimerPrinter();
		Timer t = new Timer(10000,listener);  //构造一个定时器，每隔10毫秒通告listener一次。
		//Thread thread = new Thread();
		t.start();//启动定时器，一旦启动成功，定时器将调用监听器的actionperformed方法
		
		//t.stop();  //停止定时器，一旦停止成功，将不再调用监听器方法
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}
class TimerPrinter implements ActionListener{  //定义一个监听器类，实现了actionlistener接口

	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Date time = new Date();
		System.out.println("At this moment,Time is "+time);
		Toolkit.getDefaultToolkit().beep();
	}
	
}

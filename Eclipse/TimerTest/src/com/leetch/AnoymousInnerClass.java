package com.leetch;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class AnoymousInnerClass {   

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TalkClock tk = new TalkClock();
		tk.start(10000,true);
		JOptionPane.showMessageDialog(null, "Quit now?...");
		System.exit(0);
	}
}
class TalkClock{
	public void start(int var,final boolean boop){
		ActionListener listener = new ActionListener() {//定义一个实现了接口actionlistener的匿名内部类
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Date date = new Date();
				System.out.println("当前时间是:"+date);
				if(boop)Toolkit.getDefaultToolkit().beep();
			}
		};
		Timer timer = new Timer(var, listener);
		timer.start();
	}
}
package com.leetch;
//内部类
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;;
public class InnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TalkingClock tkClock = new TalkingClock(10000, true);
		tkClock.start();
		JOptionPane.showMessageDialog(null, "Quit now?");
		System.exit(0);

	}

}
class TalkingClock {
	private boolean boop;
	public int varlear;
	
	public TalkingClock(int var,boolean boop){
		this.varlear = var;
		this.boop = boop;
	}
	
	private class TimerPrinter implements ActionListener{  //实现actionlistener接口的内部类，可以访问包围类的变量
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			Date date = new Date();
			System.out.println("At this moment,the time is " +date+",Please wait...");
			if(boop) Toolkit.getDefaultToolkit().beep();
		}		
	}
	
	public void start(){
		ActionListener listener = new TimerPrinter();
		Timer timer = new Timer(varlear,listener);
		timer.start();
	}
} 
package com.leetch;
//�ڲ���
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
		// TODO �Զ����ɵķ������
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
	
	private class TimerPrinter implements ActionListener{  //ʵ��actionlistener�ӿڵ��ڲ��࣬���Է��ʰ�Χ��ı���
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
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
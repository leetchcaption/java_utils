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
		// TODO �Զ����ɵķ������
		TalkClock tk = new TalkClock();
		tk.start(10000,true);
		JOptionPane.showMessageDialog(null, "Quit now?...");
		System.exit(0);
	}
}
class TalkClock{
	public void start(int var,final boolean boop){
		ActionListener listener = new ActionListener() {//����һ��ʵ���˽ӿ�actionlistener�������ڲ���
			
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				Date date = new Date();
				System.out.println("��ǰʱ����:"+date);
				if(boop)Toolkit.getDefaultToolkit().beep();
			}
		};
		Timer timer = new Timer(var, listener);
		timer.start();
	}
}
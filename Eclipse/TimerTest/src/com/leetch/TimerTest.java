package com.leetch;
//�ӿڵ�ʵ��
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
		// TODO �Զ����ɵķ������
		ActionListener listener =new TimerPrinter();
		Timer t = new Timer(10000,listener);  //����һ����ʱ����ÿ��10����ͨ��listenerһ�Ρ�
		//Thread thread = new Thread();
		t.start();//������ʱ����һ�������ɹ�����ʱ�������ü�������actionperformed����
		
		//t.stop();  //ֹͣ��ʱ����һ��ֹͣ�ɹ��������ٵ��ü���������
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}
class TimerPrinter implements ActionListener{  //����һ���������࣬ʵ����actionlistener�ӿ�

	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		Date time = new Date();
		System.out.println("At this moment,Time is "+time);
		Toolkit.getDefaultToolkit().beep();
	}
	
}

package ���칤��_���԰�;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.*;
public class QQMain extends JFrame implements ActionListener{
	JTextField text = new JTextField();
	JButton b1=new JButton("Send");
	JComboBox cb = new JComboBox(); //������ѡ��
	JTextArea area = new JTextArea();
	JScrollPane sp = new JScrollPane(area);//�����б�
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	QQMain(){
		this.setLocation(700,50);
		this.setSize(400,700);
		p1.setLayout(new GridLayout(1,2));
		p1.add(cb);
		p1.add(b1);
		p2.setLayout(new GridLayout(2,1));
		p2.add(text);
		p2.add(p1);
		p3.setLayout(new BorderLayout());
		p3.add(p2,BorderLayout.NORTH);
		p3.add(sp,BorderLayout.CENTER);
		this.add(p3);
		try{
			
		}catch(Exception ex){ex.printStackTrace();}
	}
	public static void main(String arg[]){
		QQMain w = new QQMain();
		w.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		
	}

}

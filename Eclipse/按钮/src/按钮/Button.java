package 按钮;
import java.awt.*;
import javax.swing.*;
public class Button {
	public static void main(String a[]){
		JFrame f=new JFrame();
		f.setSize(600,400);
		JButton b1 = new JButton("north");
		JButton b2 = new JButton("west");
		JButton b3 = new JButton("east ");
		JButton b4 = new JButton("south");
		JButton b5 = new JButton("center");
		//设置布局
		//BorderLayout e = new BorderLayout();
		//f.setLayout(e);					//边框布局
		f.setLayout(new FlowLayout());   //尽可能的居中显示按钮
		f.setLayout(new GridLayout(3,2));//表格布局管理
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.setVisible(true);
	}
}

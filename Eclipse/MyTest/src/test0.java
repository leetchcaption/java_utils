
import java.awt.*;
import javax.swing.*;
public class test0 {
	public static void main(String arg[]){
		MyFrame mf = new MyFrame();
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
}
class MyFrame extends JFrame{
	public MyFrame(){
		this.setLocation(300,200);
		this.setSize(500, 400);
		MyPanel mp = new MyPanel();
		this.add(mp);
	}
}
class MyPanel extends JPanel{
	JButton Confirm = new JButton("ȷ��");
	JButton Angin = new JButton("����һ��");
	JButton Exit = new JButton("�˳�");
	JLabel l1 = new JLabel("�²����\n\n\n");
	JLabel l2 = new JLabel("����²����:");
	JTextField txt = new JTextField();
	JLabel l3 = new JLabel("̫С");
	JPanel input = new JPanel();
	JPanel button = new JPanel();
	public MyPanel(){
		button.setLayout(new FlowLayout());
		button.add(l2);
		button.add(txt);
		button.add(l3);
		button.add(Confirm);
		button.add(Angin);
		button.add(Exit);
		
		this.setLayout(new BorderLayout());
		this.add(input,BorderLayout.CENTER);
		this.add(button,BorderLayout.SOUTH);
	}
}
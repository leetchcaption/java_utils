import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*; 
public class QQMain extends JFrame implements ActionListener{
	JTextField t1=new JTextField();
	JButton b1=new JButton("发送");
	JComboBox c1=new JComboBox();
	JTextArea area=new JTextArea();
	JScrollPane sp=new JScrollPane(area);
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	QQMain(){
		this.setSize(350,700);
		this.setLocation(800, 20);
		p1.setBackground(null);
		p1.setLayout(new GridLayout(1,2));  //布置p1
		p1.add(c1);
		p1.add(b1);
		p2.setBackground(null);
		p2.setLayout(new GridLayout(2,1));
		p2.add(t1);
		p2.add(p1);
		area.setBackground(new Color(85,123,200));
		p3.setLayout(new BorderLayout());
		p3.add(p2,BorderLayout.NORTH);
		p3.add(area,BorderLayout.CENTER);
		b1.addActionListener(this);
		this.add(p3);
		try{
			File fr=new File("E:/my Documents/Coder/JAVA/File/聊天记录.txt");
			FileReader fread=new FileReader(fr);
			BufferedReader buf=new BufferedReader(fread);
			while(buf.ready()){
				area.append(buf.readLine()+"\n");
			}
		}catch(Exception ex){ex.printStackTrace();}
	}
	public static void main(String arg[]){
		QQMain w=new QQMain();
		w.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String str=t1.getText();
		try{
			File fw=new File("E:/my Documents/Coder/JAVA/File/聊天记录.txt");
			FileWriter fwrite=new FileWriter(fw,true);
			BufferedWriter bufw=new BufferedWriter(fwrite);
			bufw.write(str+"\n");
			area.append(str+"\n");
			t1.setText("");
			bufw.close();
		}catch(Exception exc){exc.printStackTrace();}
		//System.out.println("Hello");
	}
}

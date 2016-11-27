import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QQLogin_new extends JFrame implements ActionListener{
	JLabel l1=new JLabel("UserName:");
	JTextField t1=new JTextField();
	JLabel l2=new JLabel("Password:");
	JPasswordField t2=new JPasswordField();
	JButton b1=new JButton("LOGIN");
	JButton b2=new JButton("REGISTER");
	JButton b3=new JButton("CANCEL");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	QQLogin_new (){
		this.setSize(300,150);   //this 已经继承了JFream
		this.setLocation(400,300);
		p1.setBackground(null);
		p1.setLayout(new GridLayout(2,2));
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p2.setBackground(null);
		p2.setLayout(new FlowLayout());
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p3.setBackground(new Color(255,100,250));
		p3.setLayout(new BorderLayout());
		p3.add(p1,BorderLayout.CENTER);
		p3.add(p2,BorderLayout.SOUTH);
		this.add(p3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	public static void main(String arg[]){
		QQLogin_new w=new QQLogin_new();
		w.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		try{
			if(e.getActionCommand().equals("LOGIN")){
				String u=t1.getText();
				String p=t2.getText();
				Socket s=new Socket("localhost",8000);
				OutputStream ous=s.getOutputStream(); //发送账号密码端
				OutputStreamWriter ousw=new OutputStreamWriter(ous);
				PrintWriter pw=new PrintWriter(ousw,true);
				pw.println(u+"%"+p);
				InputStream ins=s.getInputStream();  //接收确认信息端
				InputStreamReader insr=new InputStreamReader(ins);
				BufferedReader br=new BufferedReader(insr);
				if(br.readLine().equals("OK")){
					this.setVisible(false);
					QQMain_new x=new QQMain_new();
					x.setSocket(s);
					x.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(this, "账号密码错误！");
				}
			}
			if(e.getActionCommand().equals("REGISTER")){
				System.out.println("Register");
			}
			if(e.getActionCommand().equals("CANCEL")){
				System.out.println("Cancel");
			}
		}catch(Exception m){m.printStackTrace();}	
	}
	
}
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class QQlogin extends JFrame implements ActionListener{
	JLabel L1=new JLabel("UserName:");
	JTextField user=new JTextField();
	JLabel L2=new JLabel("PassWord:");
	JPasswordField pswd=new JPasswordField();
	JButton b1=new JButton("Login");
	JButton b2=new JButton("Register");
	JButton b3=new JButton("Cancel");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	QQlogin(){
		this.setSize(300,150);
		this.setLocation(400,300);
		p1.setBackground(null);
		p1.setLayout(new GridLayout(2,2));
		p1.add(L1);
		p1.add(user);
		p1.add(L2);
		p1.add(pswd);
		p2.setBackground(null);
		p2.setLayout(new FlowLayout());
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p3.setBackground(Color.pink);
		p3.setLayout(new BorderLayout());
		p3.add(p1,BorderLayout.CENTER);
		p3.add(p2,BorderLayout.SOUTH);
		this.add(p3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	public static void main(String arg[]){
		QQlogin w=new QQlogin();
		w.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String u=user.getText();
		String p=pswd.getText();
		if(e.getActionCommand().equals("Login")){
			try{
				Socket s=new Socket("127.0.0.1",8090);
				OutputStream os=s.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os);
				PrintWriter pw=new PrintWriter(osw,true);
				pw.println(u+"%"+p);
				
				InputStream is=s.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				if(br.readLine().equals("OK")){
					this.setVisible(false);
					QQMain wx=new QQMain();
					wx.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(this, "密码错误!");
				}
			}catch(Exception ex){ex.printStackTrace();}			
		}
		if(e.getActionCommand().equals("Register")){
			System.out.println("Register");
		}
		if(e.getActionCommand().equals("Cancel")){
			System.out.println("Cancel");
		}
	}
}
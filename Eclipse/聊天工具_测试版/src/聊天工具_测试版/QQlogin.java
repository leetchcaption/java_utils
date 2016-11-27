package 聊天工具_测试版;
import java.awt.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

import java.awt.event.*;
public class QQlogin extends JFrame implements ActionListener{
	JLabel user = new JLabel("UserName:"); 
	JTextField u = new JTextField();
	JLabel pswd = new JLabel("PassWord:");
	JPasswordField p = new JPasswordField();
	JButton b1 = new JButton("Login");
	JButton b2 = new JButton("Register");
	JButton b3 = new JButton("Cancel");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	QQlogin(){
		this.setSize(300,150);
		p1.setLayout(new GridLayout(2,2));
		p1.setBackground(null);
		p1.add(user);
		p1.add(u);
		p1.add(pswd);
		p1.add(p);
		p2.setLayout(new FlowLayout());
		p2.setBackground(null);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p3.setLayout(new BorderLayout());
		p3.setBackground(Color.pink);
		p3.add(p1,BorderLayout.CENTER);
		p3.add(p2,BorderLayout.SOUTH);
		this.setLocation(400,300);
		this.add(p3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand().equals("Login")){
			System.out.println("Login");
			if(u.getText().equals("") || p.getText().equals("")){
				JOptionPane.showMessageDialog(null, "ERROR!","tips:",JOptionPane.ERROR_MESSAGE);
			}
			else {
				String USER = u.getText();
				String PSWD = p.getText();
				try {
					Socket s = new Socket("127.0.0.1",8090);
					OutputStream os= s.getOutputStream(); //发送端
					OutputStreamWriter osw = new OutputStreamWriter(os);
					PrintWriter pw = new PrintWriter(osw,true);
					pw.println(USER+"%"+PSWD);
					InputStream is = s.getInputStream();//接收反馈消息
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					if(br.readLine().equals("OK")){
						this.setVisible(false);
					}
					else{
						JOptionPane.showMessageDialog(this, "Error!");
					}
				} catch (Exception e1) {e1.printStackTrace();} 
				this.setVisible(false);
			}
		}
		if(e.getActionCommand().equals("Register")){
			System.out.println("Register");
		}
		if(e.getActionCommand().equals("Cancel")){
			System.out.println("Cancel");
		}
	}
	public static void main(String arg[]){
		QQlogin w = new QQlogin();
		w.setVisible(true);
	}
}

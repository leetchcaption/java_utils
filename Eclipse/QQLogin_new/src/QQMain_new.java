import java.io.*;
import java.net.Socket;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class QQMain_new extends JFrame implements ActionListener{
	JButton b1=new JButton("����");
	JComboBox c1=new JComboBox();
	JTextField t1=new JTextField();
	JTextArea t2=new JTextArea();
	JScrollPane sp=new JScrollPane(t2);  //���ù�����
	JPanel small=new JPanel();  //����С���
	JPanel big=new JPanel();
	JPanel middle=new JPanel(); //�����м����
	QQMain_new(){
		//t2.setBackground(Color.pink);
		this.setSize(350,700);
		this.setLocation(800,20);
		small.add(c1);
		small.add(b1);
		small.setLayout(new GridLayout(1,2));
		small.setBackground(null);
		middle.add(t1);
		middle.add(small);
		middle.setLayout(new GridLayout(2,1));
		middle.setBackground(null);
		big.setLayout(new BorderLayout());
		big.add(middle,BorderLayout.NORTH);
		big.add(sp,BorderLayout.CENTER);
		big.setBackground(null);
		this.add(big);
		//QQMain_new arg0=new QQMain_new();ע����Ӧ�¼�
		b1.addActionListener(this);
		this.setVisible(true);
		try{ //��ȡԭʼ�������¼��
			File f=new File("E:/my Documents/Coder/JAVA/File/�����¼.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			while(br.ready()){
				t2.append(br.readLine()+"\n");
			}
		}catch(Exception es){es.printStackTrace();}
	}
	
	
	private Socket s;
	public void setSocket(Socket value){
		s=value;
	}
	
	public static void main(String arg[]){
		QQMain_new w=new QQMain_new();
		w.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		t2.append(t1.getText()+"\n");   //��ӵ��ı���
		try{
			File f=new File("E:/my Documents/Coder/JAVA/File/�����¼.txt");
			FileWriter fw=new FileWriter(f,true);
			PrintWriter pw=new PrintWriter(fw);
			pw.println(t1.getText());
			pw.close();
		}catch(Exception wes){wes.printStackTrace();}
		try{
			OutputStream os=s.getOutputStream();
			OutputStreamWriter osr=new OutputStreamWriter(os);
			PrintWriter posw=new PrintWriter(osr,true);
			posw.println(t1.getText());
		}catch(Exception esw){esw.printStackTrace();}
		t1.setText("");
	}
}

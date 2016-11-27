import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class CopyDir_new extends JFrame implements ActionListener, Runnable{   //ʵ��������ʹ�������
	JLabel LbFrom = new JLabel("ԴĿ¼");//��ǩ
	JLabel LbTo = new JLabel("Ŀ��Ŀ¼:");
	
	JTextField TxtFrom = new JTextField();  //�����
	JTextField TxtTo = new JTextField();
	
	JButton BtFrom = new JButton("ԴĿ¼");
	JButton BtTo = new JButton("Ŀ��Ŀ¼");
	
	JTextArea TxtIng = new JTextArea();  //�������
	JScrollPane jstxting = new JScrollPane(TxtIng); //��ӱ߼ʿ�
	JButton btcopy = new JButton("����");
	JPanel Input= new JPanel();
	CopyDir_new(){
		this.setLocation(300,100);
		this.setSize(500,600);
		
		BtFrom.addActionListener(this);  //ע���¼�����
		BtTo.addActionListener(this);
		btcopy.addActionListener(this);
		
		Input.setLayout(new GridLayout(2,3));
		Input.add(LbFrom);
		Input.add(TxtFrom);
		Input.add(BtFrom);
		
		Input.add(LbTo);
		Input.add(TxtTo);
		Input.add(BtTo);
		
		this.setLayout(new BorderLayout());
		this.add(Input,BorderLayout.NORTH);
		this.add(jstxting,BorderLayout.CENTER);
		this.add(btcopy,BorderLayout.SOUTH);
	}
	public static void main(String arg[]){
		CopyDir_new cd = new CopyDir_new();
		cd.setVisible(true);
	}
	public void showsub(File f){     //�ݹ����ʵ�ֱ��������ļ�Ŀ¼
		File[] sub = f.listFiles();
		for(int i=0;i<sub.length;i++){
			if(sub[i].isDirectory()){
				System.out.println("Ŀ¼��====>"+sub[i]);
				showsub(sub[i]);
			}
			if(sub[i].isFile()){
				System.out.println("�ļ���---->"+sub[i]);
			}
		}
	}
	
	public void copy(File from,File to){                //����Ŀ¼
		String newDir = to.getPath()+"/"+from.getName();  //��Ŀ���ļ����н���һ����Դ�ļ�Ŀ¼ͬ�����ļ���
		System.out.println(newDir);
		File [] sub = from.listFiles(); //��ȡ�ļ��б�
		TxtIng.append("���ڴ���Ŀ¼"+newDir+"...\n");
		File newfile = new File(newDir);
		newfile.mkdir();    //������newDirΪ���ֵ���Ŀ¼
		for(int i=0;i<sub.length;i++){
			if(sub[i].isDirectory()){
				copy(sub[i],newfile);
			}
			if(sub[i].isFile()){
				TxtIng.append("���ڸ����ļ�"+sub[i]+"...\n");
				copyfile(sub[i],new File(newDir+"/"+sub[i].getName()));
			}
		}
	}
	
	public void copyfile(File from,File to){
		try{
			FileInputStream fis = new FileInputStream(from);
			FileOutputStream fos = new FileOutputStream(to);
			
			byte[] tmp = new byte[8192] ; //����һ��8192�ֽڵĻ�����
			int length = fis.available()/8192 ;
			for(int i=0;i<length;i++){   //����length����������������ݣ�
				fis.read(tmp);
				fos.write(tmp);
			}
			int size = fis.read(tmp);
			fos.write(tmp, 0, size);
			fos.close();
		}catch(Exception e){}
	}
	public void run(){
		copy(new File(TxtFrom.getText()),new File(TxtTo.getText()));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getActionCommand().equals("ԴĿ¼")){
			JFileChooser chice = new JFileChooser();    //ѡ��Ի������
			System.out.println(e.getActionCommand());
			chice.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  //���ÿ���ѡ��Ŀ¼��ģʽ
			chice.showDialog(this, "��");
			File choosefile = chice.getSelectedFile();   //�õ���ѡ���ļ���·��
			TxtFrom.setText(choosefile.getPath());
			System.out.println(choosefile);
		}
		if(e.getActionCommand().equals("Ŀ��Ŀ¼")){
			JFileChooser chice = new JFileChooser();
			chice.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chice.showOpenDialog(this);
			File choosefile = chice.getSelectedFile();
			TxtTo.setText(choosefile.getPath());			
		}
		if(e.getActionCommand().equals("����")){
			Thread t = new Thread(this);
			t.start();
		}
	}
}

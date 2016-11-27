import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class CopyDir_new extends JFrame implements ActionListener, Runnable{   //实现鼠标点击和创建进程
	JLabel LbFrom = new JLabel("源目录");//标签
	JLabel LbTo = new JLabel("目标目录:");
	
	JTextField TxtFrom = new JTextField();  //输入框
	JTextField TxtTo = new JTextField();
	
	JButton BtFrom = new JButton("源目录");
	JButton BtTo = new JButton("目标目录");
	
	JTextArea TxtIng = new JTextArea();  //大输入框
	JScrollPane jstxting = new JScrollPane(TxtIng); //添加边际框
	JButton btcopy = new JButton("复制");
	JPanel Input= new JPanel();
	CopyDir_new(){
		this.setLocation(300,100);
		this.setSize(500,600);
		
		BtFrom.addActionListener(this);  //注册事件监听
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
	public void showsub(File f){     //递归调用实现遍历所有文件目录
		File[] sub = f.listFiles();
		for(int i=0;i<sub.length;i++){
			if(sub[i].isDirectory()){
				System.out.println("目录：====>"+sub[i]);
				showsub(sub[i]);
			}
			if(sub[i].isFile()){
				System.out.println("文件：---->"+sub[i]);
			}
		}
	}
	
	public void copy(File from,File to){                //复制目录
		String newDir = to.getPath()+"/"+from.getName();  //在目标文件夹中建立一个和源文件目录同名的文件夹
		System.out.println(newDir);
		File [] sub = from.listFiles(); //获取文件列表
		TxtIng.append("正在创建目录"+newDir+"...\n");
		File newfile = new File(newDir);
		newfile.mkdir();    //创建以newDir为名字的新目录
		for(int i=0;i<sub.length;i++){
			if(sub[i].isDirectory()){
				copy(sub[i],newfile);
			}
			if(sub[i].isFile()){
				TxtIng.append("正在复制文件"+sub[i]+"...\n");
				copyfile(sub[i],new File(newDir+"/"+sub[i].getName()));
			}
		}
	}
	
	public void copyfile(File from,File to){
		try{
			FileInputStream fis = new FileInputStream(from);
			FileOutputStream fos = new FileOutputStream(to);
			
			byte[] tmp = new byte[8192] ; //开辟一个8192字节的缓冲区
			int length = fis.available()/8192 ;
			for(int i=0;i<length;i++){   //处理length个缓冲区里面的内容；
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
		// TODO 自动生成的方法存根
		if(e.getActionCommand().equals("源目录")){
			JFileChooser chice = new JFileChooser();    //选择对话框的类
			System.out.println(e.getActionCommand());
			chice.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  //设置可以选择目录的模式
			chice.showDialog(this, "打开");
			File choosefile = chice.getSelectedFile();   //得到所选择文件的路径
			TxtFrom.setText(choosefile.getPath());
			System.out.println(choosefile);
		}
		if(e.getActionCommand().equals("目标目录")){
			JFileChooser chice = new JFileChooser();
			chice.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chice.showOpenDialog(this);
			File choosefile = chice.getSelectedFile();
			TxtTo.setText(choosefile.getPath());			
		}
		if(e.getActionCommand().equals("复制")){
			Thread t = new Thread(this);
			t.start();
		}
	}
}

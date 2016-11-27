import java.awt.*;  //导入所有的类
import java.applet.*;
import java.io.*;
import javax.swing.*;
public class MyTest{   //文件的输入输出流
	public static void main(String arg[]){
		try{
			File f=new File("E:/my Documents/Coder/JAVA/File/yuanwendang.txt");
			FileReader fread=new FileReader(f);
			BufferedReader bfrd=new BufferedReader(fread);
			while(bfrd.ready()){
				System.out.print(bfrd.readLine());
				System.out.print("\n");
			}
		}catch(Exception e){e.printStackTrace();}
	}
}
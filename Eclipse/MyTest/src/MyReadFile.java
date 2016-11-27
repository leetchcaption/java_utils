import java.io.*;
public class MyReadFile {
	public static void main(String arg[]){
		try{
			File fr=new File ("E:/my Documents/Coder/JAVA/File/yuanwendang.txt");
			File fw=new File ("E:/my Documents/Coder/JAVA/File/test0.txt");
			FileReader read=new FileReader(fr);
			FileWriter writer=new FileWriter(fw);
			while(read.ready()){
				writer.write((char)read.read());
			}
			writer.close();
		}catch(Exception e){e.printStackTrace();}		
	}
}

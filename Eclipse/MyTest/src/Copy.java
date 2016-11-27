import java.io.*;
import javax.swing.*;
public class Copy {
	public static void main(String arg[]){
		try{
			File f=new File("E:/my Documents/Coder/JAVA/File/yuanwendang.txt");
			File f0=new File("E:/my Documents/Coder/JAVA/File/test0.txt");
			FileReader fread=new FileReader(f);
			BufferedReader fr=new BufferedReader(fread);
			FileWriter fwrite=new FileWriter(f0);
			PrintWriter fw=new PrintWriter(fwrite);
			while(fr.ready()){
				fw.print((char)fr.read());
				fw.print("\n");
			}
			fw.flush();
		}catch(Exception e){e.printStackTrace();}
	}
}

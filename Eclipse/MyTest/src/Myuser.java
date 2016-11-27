import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
public class Myuser {
	public static void main(String arg[]){
		String u="aaa";
		String p="123";
		try{
			File f=new File("E:/my Documents/Coder/JAVA/File/user.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			boolean b=false;
			while(br.ready()){
				String udmp=br.readLine();
				String user=udmp.split("%")[0] ;
				String pass=udmp.split("%")[1];
				if(u.equals(user) && p.equals(pass)){
					b=true;
					break;
				}
			}
			if(b){
				System.out.println("验证通过!");
			}
			else {
				System.out.println("验证失败!");
			}
		}catch(Exception e){e.printStackTrace();}
	}
}

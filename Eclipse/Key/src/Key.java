import java.io.*;
public class Key{
	public static void main(String arg[]){
		try{
			File key0=new File("E:/my Documents/Coder/JAVA/File/key0.key");
			FileOutputStream fout=new FileOutputStream(key0);
			for(int i=0;i<128;i++){
				fout.write((int)(Math.random()*128));
			}
		}catch(Exception e){e.printStackTrace();}
	}
}
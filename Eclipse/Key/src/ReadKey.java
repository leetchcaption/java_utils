import java.io.*;
public class ReadKey{
	public static void main(String arg[]){
		try{
			File key0=new File("E:/my Documents/Coder/JAVA/File/key0.key");
			FileInputStream fread=new FileInputStream(key0);
			int len=fread.available();
			for(int i=0;i<len;i++){
				System.out.print((int)(fread.read()));
				System.out.print("\n");
			}
		}catch(Exception e){e.printStackTrace();}
	}
}
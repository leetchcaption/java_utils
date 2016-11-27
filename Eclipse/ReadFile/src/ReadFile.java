//ÎÄ¼şÒÆÖ²¼ÓÃÜ
import java.io.*;
public class ReadFile{
	public static void main(String str[]){
		try{
			File f=new File("C:/work/test2.txt");
			FileInputStream fin=new FileInputStream(f);
			int len=fin.available();
			for(int i=0;i<len;i++){
				System.out.print((char)(fin.read()-i%100));
			}
		}catch(Exception e){}
	}
}
	
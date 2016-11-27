import java.io.*;
public class DelSecret{
	public static void main(String arg[]){
		try{
			int key[]=new int[128];
			File key0=new File("E:/my Documents/Coder/JAVA/File/key0.key");
			FileInputStream fread=new FileInputStream(key0);
			for(int i=0;i<128;i++){
				key[i]=(int)fread.read();
			}
			File fr=new File("E:/my Documents/Coder/JAVA/File/addsecret.txt");
			FileInputStream frd=new FileInputStream(fr);
			File fw=new File("E:/my Documents/Coder/JAVA/File/Delsecret.txt");
			FileOutputStream fwrite=new FileOutputStream(fw);
			int len=frd.available();
			for(int i=0;i<len;i++){
				//System.out.print((char)(frd.read()-key[i%128]));
				fwrite.write((char)(frd.read()-key[i%128]));
			}
		}catch(Exception e){e.printStackTrace();}
	}
}
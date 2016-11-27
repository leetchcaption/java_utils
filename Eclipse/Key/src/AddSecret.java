import java.io.*;
public class AddSecret{
	public static void main(String arg[]){
		try{
			int key[]=new int[128];
			File key0=new File("E:/my Documents/Coder/JAVA/File/key0.key");  //定点
			FileInputStream key0read=new FileInputStream(key0);//建立管道
			for(int i=0;i<128;i++){
				key[i]=(int)(key0read.read());  //读取
			}
			File fr=new File("E:/my Documents/Coder/JAVA/File/yuanwendang.txt");
			FileInputStream fread=new FileInputStream(fr);
			File fw=new File("E:/my Documents/Coder/JAVA/File/addsecret.txt");
			FileOutputStream fwrite=new FileOutputStream(fw);
			int len=fread.available();
			for(int i=0;i<len;i++){
				fwrite.write(fread.read()+key[i%128]);
			}
		}catch(Exception e){e.printStackTrace();}
	}
}
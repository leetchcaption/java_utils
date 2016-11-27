import java.io.*;
public class WriteFile{
	public static void main(String arg[]){
		try{
			File f1=new File("C:/Program Files/Java/jdk1.7.0/src.zip");
			File f2=new File("C:/work/src.zip");
			FileInputStream fis=new FileInputStream(f1);
			FileOutputStream fos=new FileOutputStream(f2);
			int len=fis.available();
			byte[] tmp=new byte[8192];
			for(int i=0;i<len/8192;i++){
				fis.read(tmp);
				fos.write(tmp);
			}  //处理剩余的字节
			int size=fis.available();
			fos.write(tmp, 0, size);
			fos.close();
		}catch(Exception e){}
	}
}
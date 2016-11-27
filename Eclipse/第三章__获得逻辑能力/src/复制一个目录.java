import java.io.*;
public class 复制一个目录 {
	public static void showdir(File f){
		try{
			File[] s = f.listFiles();
			for(int i=0;i<s.length;i++){
				if(s[i].isDirectory()){
					showdir(s[i]);
					System.out.println("目录====》"+s[i]);
				}
				if(s[i].isFile()){
					System.out.println("文件---->"+s[i]);
				}
			}
		}catch(Exception e){}
	}
	public static void main(String s[]){
		try{
			File ff= new File("E:/my Documents/Coder/JAVA");
			showdir(ff);
		}catch(Exception e){}
	}
}

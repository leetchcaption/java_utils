package 词法扫描程序;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String s[]){
		try{
			Scaner sc = new Scaner();
			while(sc.State()==false){
				sc.scan();
			}
			sc.SaveToken();
			sc.savesymbols();
			System.out.println("程序运行完成，请查看文件！");
		}catch(Exception e){e.printStackTrace();}
	}
}

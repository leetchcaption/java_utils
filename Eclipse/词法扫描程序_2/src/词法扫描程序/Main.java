package �ʷ�ɨ�����;
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
			System.out.println("����������ɣ���鿴�ļ���");
		}catch(Exception e){e.printStackTrace();}
	}
}

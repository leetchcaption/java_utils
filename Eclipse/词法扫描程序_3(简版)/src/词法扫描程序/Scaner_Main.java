package �ʷ�ɨ�����;
import java.util.Scanner;
import java.io.*;
public class Scaner_Main {
	public static void main(String s[]){
		try{
			Scaner sc = new Scaner();
			while(sc.state()== false){
				sc.tokenscan();
			}
			sc.Savetoken();
			System.out.println("�����������!...");
		}catch(Exception e){e.printStackTrace();}
	}
}

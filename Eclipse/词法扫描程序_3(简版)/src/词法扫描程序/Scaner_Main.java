package 词法扫描程序;
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
			System.out.println("程序运行完成!...");
		}catch(Exception e){e.printStackTrace();}
	}
}

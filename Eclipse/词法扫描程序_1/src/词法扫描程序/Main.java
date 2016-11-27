package 词法扫描程序;
import java.io.*;
public class Main {
	public static void main(String[] args){
		try{
			lexer Lexer = new lexer();
			while (Lexer.getReaderState() == false) {
				Lexer.scan();
			}
			/* 保存相关信息 */
			Lexer.saveTokens();
			Lexer.saveSymbolsTable();
			System.out.println("程序运行完成,请查看文件!");		
		}catch(Exception e){e.printStackTrace();}
	}
}

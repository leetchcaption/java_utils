package �ʷ�ɨ�����;
import java.io.*;
public class Main {
	public static void main(String[] args){
		try{
			lexer Lexer = new lexer();
			while (Lexer.getReaderState() == false) {
				Lexer.scan();
			}
			/* ���������Ϣ */
			Lexer.saveTokens();
			Lexer.saveSymbolsTable();
			System.out.println("�����������,��鿴�ļ�!");		
		}catch(Exception e){e.printStackTrace();}
	}
}

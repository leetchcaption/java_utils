package �ʷ�ɨ�����;
/*
 * ������
 */
import java.io.*;
import Lexer.*;

public class Main {
	public static void main(String[] args) throws IOException {
		lexer lexer = new lexer();
		
		while (lexer.getReaderState() == false) {
			lexer.scan();
		}
		
		/* ���������Ϣ */
		lexer.saveTokens();
		lexer.saveSymbolsTable();
		
	}
}

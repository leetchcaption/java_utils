package 词法扫描程序;
/*
 * 主程序
 */
import java.io.*;
import Lexer.*;

public class Main {
	public static void main(String[] args) throws IOException {
		lexer lexer = new lexer();
		
		while (lexer.getReaderState() == false) {
			lexer.scan();
		}
		
		/* 保存相关信息 */
		lexer.saveTokens();
		lexer.saveSymbolsTable();
		
	}
}

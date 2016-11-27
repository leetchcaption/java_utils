package Lexer;
import java.io.*;
import java.util.*;
import symbols.*;

public class lexer {
	public static int line = 1;		/* ��¼�к� */
	char peek = ' ';		/* ��һ�������ַ� */
	Hashtable<String, Word> words = 
		new Hashtable<String, Word>();
	/* ���ű� */
	private Hashtable<Token, String> table = 
		new Hashtable<Token, String>();
	/* token���� */
	private List<String> tokens = 
		new LinkedList<String> ();
	/* ��ȡ�ļ����� */
	BufferedReader reader = null; 
	/* ���浱ǰ�Ƿ��ȡ�����ļ��Ľ�β  */
	private Boolean isEnd = false;
	
	/* �Ƿ��ȡ���ļ��Ľ�β */
	public Boolean getReaderState() {
		return this.isEnd;
	}
	
	/* ����洢��table�е� */
	public void saveSymbolsTable() throws IOException {
		FileWriter writer = new FileWriter("E:/my Documents/Coder/JAVA/File/���ű�.txt");
		writer.write("[����]			[����������Ϣ]\n");
		writer.write("\r\n");
		
		Enumeration<Token> e = table.keys();
		while( e.hasMoreElements() ){
			Token token = (Token)e.nextElement();
			String desc = table.get(token);
			
			/* д���ļ� */
			writer.write(token + "\t\t\t" + desc + "\r\n");
		}
			
		writer.flush();
	}
	
	/* ����Tokens */
	public void saveTokens() throws IOException {
		FileWriter writer = new FileWriter("E:/my Documents/Coder/JAVA/File/Tokens��.txt");
		writer.write("[����]	\n");
		writer.write("\r\n");
		
		for(int i = 0; i < tokens.size(); ++i) {
			String tok = (String)tokens.get(i);
			
			/* д���ļ� */
			writer.write(tok + "\r\n");
		}	
			
		writer.flush();
	}
	
	void reserve(Word w) {
		words.put(w.lexme, w);
	}
	
	/*
	 * ���캯���н��ؼ��ֺ�������ӵ�hashtable words��
	 */
	public lexer() {
		/* ��ʼ����ȡ�ļ����� */
		try {
			reader = new BufferedReader(new FileReader("E:/my Documents/Coder/JAVA/File/input.txt"));
		}
		catch(IOException e) {
			System.out.print(e);
		}
		
		
		/* �ؼ��� */
		this.reserve(new Word("if", Tag.IF));
		this.reserve(new Word("then", Tag.THEN));
		this.reserve(new Word("else", Tag.ELSE));
		this.reserve(new Word("while", Tag.WHILE));
		this.reserve(new Word("do", Tag.DO));
		
		/* ���� */
		this.reserve(Word.True);
		this.reserve(Word.False);
		this.reserve(Type.Int);
		this.reserve(Type.Char);
		this.reserve(Type.Bool);
		this.reserve(Type.Float);
	}
	
	public void readch() throws IOException {
		/* ����Ӧ����ʹ�õ��� */
		peek = (char)reader.read();
		if((int)peek == 0xffff){
			this.isEnd = true;
		}
		// peek = (char)System.in.read();
	}
	
	public Boolean readch(char ch) throws IOException {
		readch();
		if (this.peek != ch) {
			return false;
		}
		
		this.peek = ' ';
		return true;
	}
	
	public Token scan() throws IOException {
		/* �����հ� */ 
		for( ; ; readch() ) {
			if(peek == ' ' || peek == '\t')
				continue;
			else if (peek == '\n') 
				line = line + 1;
			else
				break;
		}
		
		/* ���濪ʼ�ָ�ؼ��֣���ʶ������Ϣ  */
		switch (peek) {
		/* ���� ==, >=, <=, !=������ʹ��״̬��ʵ�� */
		case '=' :
			if (readch('=')) {
				tokens.add("==");
				return Word.eq;	
			}
			else {
				tokens.add("=");
				return new Token('=');
			}
		case '>' :
			if (readch('=')) {
				tokens.add(">=");
				return Word.ge;
			}
			else {
				tokens.add(">");
				return new Token('>');
			}
		case '<' :
			if (readch('=')) {
				tokens.add("<=");
				return Word.le;
			}
			else {
				tokens.add("<");
				return new Token('<');
			}
		case '!' :
			if (readch('=')) {
				tokens.add("!=");
				return Word.ne;
			}
			else {
				tokens.add("!");
				return new Token('!');
			}	
		}
		
		/* �����Ƕ����ֵ�ʶ�𣬸����ķ��Ĺ涨�Ļ��������
		 * ����ֻҪ���ܹ�ʶ����������.
		 */
		if(Character.isDigit(peek)) {
			int value = 0;
			do {
				value = 10 * value + Character.digit(peek, 10);
				readch();
			} while (Character.isDigit(peek));
			
			Num n = new Num(value);
			tokens.add(n.toString());
			//table.put(n, "Num");
			return n;
		}
		
		/*
		 * �ؼ��ֻ����Ǳ�ʶ����ʶ��
		 */
		if(Character.isLetter(peek)) {
			StringBuffer sb = new StringBuffer();
			
			/* ���ȵõ�������һ���ָ� */
			do {
				sb.append(peek);
				readch();
			} while (Character.isLetterOrDigit(peek));
			
			/* �ж��ǹؼ��ֻ��Ǳ�ʶ�� */
			String s = sb.toString();
			Word w = (Word)words.get(s);
			
			/* ����ǹؼ��ֻ��������͵Ļ���w��Ӧ���ǿյ� */
			if(w != null) {
				// table.put(w, "KeyWord or Type");
				tokens.add(w.toString());
				return w; /* ˵���ǹؼ��� ������������ */
			}
			
			/* �������һ����ʶ��id */
			w = new Word(s, Tag.ID);
			tokens.add(w.toString());
			table.put(w, "id");
			words.put(s,  w);
			
			return w;
		}
		
		/* peek�е������ַ�������Ϊ�Ǵʷ���Ԫ���� */
		Token tok  = new Token(peek);
		// table.put(tok, "Token or Seprator");
		if ((int)peek != 0xffff ) 
			tokens.add(tok.toString());
		peek = ' ';
		
		return tok;
	}
}

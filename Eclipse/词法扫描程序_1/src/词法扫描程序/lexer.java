package 词法扫描程序;
import java.io.*;
import java.util.*;
public class lexer {
	public static int line = 1;				 	//记录行号
	char peek = ' ';		  					//读入下一个字符
	Hashtable<String, Word> words = new Hashtable<String, Word>();          	//符号表
	private Hashtable<Token, String> table = new Hashtable<Token, String>();    //token序列表
	private List<String> tokens = new LinkedList<String> (); 
	private Boolean isEnd = false;    			// 当前是否读取到了文件的结尾  
	BufferedReader br = null;					//读取文件变量
	public lexer() {  						
		try {
			File f = new File("E:/my Documents/Coder/JAVA/File/输入源程序.txt");
			FileReader fr = new FileReader(f);
			br = new BufferedReader(fr);
		}catch(IOException e) {}
		//定义关键字
		this.reserve(new Word("if", Tag.IF));  
		this.reserve(new Word("then", Tag.THEN));
		this.reserve(new Word("else", Tag.ELSE));
		this.reserve(new Word("while", Tag.WHILE));
		this.reserve(new Word("do", Tag.DO));
		//定义类型
		this.reserve(Word.True);
		this.reserve(Word.False);
		this.reserve(Type.Int);
		this.reserve(Type.Char);
		this.reserve(Type.Bool);
		this.reserve(Type.Float);
	}
	public Boolean getReaderState() {  
		return this.isEnd;
	}
	/* 保存存储在table中的 */
	public void saveSymbolsTable() {
		try{
			File f= new File("E:/my Documents/Coder/JAVA/File/输出文件.txt");
			FileWriter fw = new FileWriter(f);
			fw.write("[符号]			[符号类型信息]\n");
			fw.write("\r\n");
			Enumeration<Token> e = table.keys();
			while( e.hasMoreElements() ){
				Token token = (Token)e.nextElement();
				String desc = table.get(token);
				/* 写入文件 */
				fw.write(token + "\t\t\t" + desc + "\r\n");
			}	
			fw.close();
		}catch(Exception e){e.printStackTrace();}
	}
	public void saveTokens(){   
		try{
			File f = new File("E:/my Documents/Coder/JAVA/File/Tokens表.txt");
			FileWriter fw = new FileWriter(f);
			fw.write("[Token序列:]	\n");
			fw.write("\r\n");
			for(int i = 0; i < tokens.size(); ++i) {
				String tok = (String)tokens.get(i);
				/* 写入文件 */
				fw.write("‘"+tok + "’");
			}	
			fw.close();
		}catch(Exception ex){ex.printStackTrace();}
	}
	void reserve(Word w) {
		words.put(w.lexme, w);
	}
	public void readch() throws IOException {   //Java的多态，重载函数
		peek = (char)br.read();
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
	public Token scan() throws IOException {   //产生token序列
		for( ; ; readch() ) {   //消除多余的空格
			if(peek == ' ' || peek == '\t')
				continue;
			else if (peek == '\n') 
				line = line + 1;
			else
				break;
		}
		/* 下面开始分割关键字，标识符等信息  */
		switch (peek) {
		/* 对于 ==, >=, <=, !=的区分使用状态机实现 */
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
		//数字的识别，只能识别整数
		if(Character.isDigit(peek)) {
			int value = 0;
			do {
				value = 10 * value + Character.digit(peek, 10);//返回十进制码
				readch();
			} while (Character.isDigit(peek));
			
			Num n = new Num(value);
			tokens.add(n.toString());
			table.put(n, "Num");
			return n;
		}
		
		/*
		 * 关键字或者是标识符的识别
		 */
		if(Character.isLetter(peek)) {
			StringBuffer sb = new StringBuffer();
			
			/* 首先得到整个的一个分割 */
			do {
				sb.append(peek);
				readch();
			} while (Character.isLetterOrDigit(peek));
			
			/* 判断是关键字还是标识符 */
			String s = sb.toString();
			Word w = (Word)words.get(s);
			if(w != null) {
				table.put(w, "KeyWord or Type");
				tokens.add(w.toString());
				return w; /* 说明是关键字 或者是类型名 */
			}
			
			/* 否则就是一个标识符id */
			w = new Word(s, Tag.ID);
			tokens.add(w.toString());
			table.put(w, "id");
			words.put(s,  w);		
			return w;
		}
		/* peek中的任意字符都被认为是词法单元返回 */
		Token tok  = new Token(peek);
		if ((int)peek != 0xffff ) 
			tokens.add(tok.toString());
		peek = ' ';
		return tok;
	}
}

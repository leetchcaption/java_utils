package �ʷ�ɨ�����;
import java.io.*;
import java.util.*;
public class lexer {
	public static int line = 1;				 	//��¼�к�
	char peek = ' ';		  					//������һ���ַ�
	Hashtable<String, Word> words = new Hashtable<String, Word>();          	//���ű�
	private Hashtable<Token, String> table = new Hashtable<Token, String>();    //token���б�
	private List<String> tokens = new LinkedList<String> (); 
	private Boolean isEnd = false;    			// ��ǰ�Ƿ��ȡ�����ļ��Ľ�β  
	BufferedReader br = null;					//��ȡ�ļ�����
	public lexer() {  						
		try {
			File f = new File("E:/my Documents/Coder/JAVA/File/����Դ����.txt");
			FileReader fr = new FileReader(f);
			br = new BufferedReader(fr);
		}catch(IOException e) {}
		//����ؼ���
		this.reserve(new Word("if", Tag.IF));  
		this.reserve(new Word("then", Tag.THEN));
		this.reserve(new Word("else", Tag.ELSE));
		this.reserve(new Word("while", Tag.WHILE));
		this.reserve(new Word("do", Tag.DO));
		//��������
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
	/* ����洢��table�е� */
	public void saveSymbolsTable() {
		try{
			File f= new File("E:/my Documents/Coder/JAVA/File/����ļ�.txt");
			FileWriter fw = new FileWriter(f);
			fw.write("[����]			[����������Ϣ]\n");
			fw.write("\r\n");
			Enumeration<Token> e = table.keys();
			while( e.hasMoreElements() ){
				Token token = (Token)e.nextElement();
				String desc = table.get(token);
				/* д���ļ� */
				fw.write(token + "\t\t\t" + desc + "\r\n");
			}	
			fw.close();
		}catch(Exception e){e.printStackTrace();}
	}
	public void saveTokens(){   
		try{
			File f = new File("E:/my Documents/Coder/JAVA/File/Tokens��.txt");
			FileWriter fw = new FileWriter(f);
			fw.write("[Token����:]	\n");
			fw.write("\r\n");
			for(int i = 0; i < tokens.size(); ++i) {
				String tok = (String)tokens.get(i);
				/* д���ļ� */
				fw.write("��"+tok + "��");
			}	
			fw.close();
		}catch(Exception ex){ex.printStackTrace();}
	}
	void reserve(Word w) {
		words.put(w.lexme, w);
	}
	public void readch() throws IOException {   //Java�Ķ�̬�����غ���
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
	public Token scan() throws IOException {   //����token����
		for( ; ; readch() ) {   //��������Ŀո�
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
		//���ֵ�ʶ��ֻ��ʶ������
		if(Character.isDigit(peek)) {
			int value = 0;
			do {
				value = 10 * value + Character.digit(peek, 10);//����ʮ������
				readch();
			} while (Character.isDigit(peek));
			
			Num n = new Num(value);
			tokens.add(n.toString());
			table.put(n, "Num");
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
			if(w != null) {
				table.put(w, "KeyWord or Type");
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
		if ((int)peek != 0xffff ) 
			tokens.add(tok.toString());
		peek = ' ';
		return tok;
	}
}

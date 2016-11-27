package �ʷ�ɨ�����;
public class Token {  //Token����
	public final int  tag;
	public Token(int t){
		this.tag = t;
	}
	public String toString(){
		return "" + (char)tag;
	}
}
class Flag{
	public final static int tag = 0;
}
class Word extends Token{     //�����ַ�
	public String lex = "";
	public Word(String s , int t) {
		super(t);
		this.lex = s;
		// TODO �Զ����ɵĹ��캯�����
	}
	public String toString(){
		return this.lex;
	}
	public static final Word 	
		and = new Word("&&",Flag.tag),
		or  = new Word("||",Flag.tag),
		equal = new Word("==",Flag.tag),
		noteuqal = new Word("!=",Flag.tag),
		litterequal = new Word("<=",Flag.tag),
		greatequal = new Word(">=",Flag.tag),
		True = new Word("true",Flag.tag),
		False = new Word("false",Flag.tag),
		Main = new  Word("main",Flag.tag),
		Plus = new Word("--",Flag.tag),
		Add = new Word("++",Flag.tag),
		Dric = new Word("->",Flag.tag);	
}
class Type extends Word{     //��������
	public Type(String s, int t) {
		super(s, t);				// TODO �Զ����ɵĹ��캯�����
	}	
	public static final Type 
		Int = new Type("int",Flag.tag),
		Float = new Type("float",Flag.tag),
		Char = new Type("char",Flag.tag),
		Bool = new Type("bool",Flag.tag),
		Double =new Type("double",Flag.tag);
} 
class number extends Token{    //����
	public final int value;
	public number(int v) {
		super(Flag.tag);
		this.value = v;
	}
	public String toString(){
		return  "" + value;
	} 
} 

package 词法扫描程序;
public class Token {
	public final int tag;  //final 最终的，
	public Token(int t) {
		this.tag = t;
	}
	public String toString() {
		return "" + (char)tag;
	}
}
class Tag {
	public final static int 
		ffk     = 234,
		AND		= 256,
		BASIC	= 257,
		BREAK	= 258,
		DO		= 259,
		ELSE	= 260,
		EQ		= 261,	/* == */
		FALSE	= 262,
		GE		= 263,
		ID		= 264,
		IF		= 265,
		INDEX	= 266,
		LE		= 267,
		MINUS	= 268,
		NE		= 269,
		NUM		= 270,
		OR		= 271,
		REAL	= 272,
		TEMP	= 273,
		TRUE	= 274,
		WHILE	= 275,
		THEN	= 276;
}
class Type extends Word{
	public Type(String s, int tag) {   //构造方法
		super(s, tag);
	}
	public static final Type
		Int = new Type("int", Tag.BASIC),
		Float = new Type("float", Tag.BASIC),
		Char = new Type ("char", Tag.BASIC),
		Bool =  new Type("bool", Tag.BASIC);
 }
class Num extends Token{
	public final int value;
	public Num(int v) {   //构造函数
		super(Tag.NUM);
		this.value = v;
	}
	public String toString() {
		return  "" + value;
	}
}
class Word extends Token {  //管理保留字符
	public String lexme = "";	
	public Word (String s, int t) {
		super(t);
		this.lexme = s;
	}
	public String toString() {
		return this.lexme;
	}
	public static final Word   //保留字符表
		and = new Word("&&", Tag.AND),
		or = new Word("||", Tag.OR),
		eq = new Word ("==", Tag.EQ),
		ne = new Word("!=", Tag.NE),
		le = new Word("<=", Tag.LE),
		ge = new Word(">=", Tag.GE),
		minus = new Word("minus", Tag.MINUS),
		True = new Word("true", Tag.TRUE),
		False = new Word("false", Tag.FALSE),
		temp = new Word("t", Tag.TEMP);
}
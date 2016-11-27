package 词法扫描程序;
import java.util.*;
import java.io.*;
import javax.swing.*;
public class Scaner {
	public static int line = 1 ;
	Hashtable <String,Word> words = new Hashtable<String,Word>();
	Hashtable <Token,String> table = new Hashtable<Token,String>();//字符表
	List<String> tokens = new LinkedList<String>();  //链表
	char next= ' ';
 	Boolean isend = false ;
 	BufferedReader br = null;
 	public Scaner(){     //构造函数
 		try{
 			File f = new File("E:/my Documents/Coder/JAVA/File/输入源程序.txt");
 			FileReader fr = new FileReader(f);
 			br = new BufferedReader(fr);
 		}catch(Exception e){e.printStackTrace();}
 	this.Reserve(new Word("if",Flag.tag));
 	this.Reserve(new Word("else",Flag.tag));
 	this.Reserve(new Word("then",Flag.tag));
 	this.Reserve(new Word("while",Flag.tag));
 	this.Reserve(new Word("do",Flag.tag));
 	this.Reserve(new Word("for",Flag.tag));
 	this.Reserve(new Word("include",Flag.tag));
 	this.Reserve(Word.True);
 	this.Reserve(Word.False);
 	this.Reserve(Word.Main);
 	this.Reserve(Type.Int);
 	this.Reserve(Type.Char);
 	this.Reserve(Type.Bool);
 	this.Reserve(Type.Float);
 	this.Reserve(Type.Double);
 	}
 	public Boolean State(){
 		return this.isend;
 	}
 	public void Reserve(Word w){
 		words.put(w.lex, w);
 	}
 	public void SaveToken(){
 		try{
 			File f =new File("E:/my Documents/Coder/JAVA/File/输出文件.txt");
 			FileWriter fw = new FileWriter(f);
 			PrintWriter pw = new PrintWriter(fw);
 			pw.println("产生的Token序列：");
 			for(int i=0;i<tokens.size();i++){
 				if((String)tokens.get(i)!=" " && (String)tokens.get(i)!="\n"){
 						if(i%15 == 0){
 							pw.println();pw.println();
 						}
 						pw.print(tokens.get(i)+"     ");
 				}
 			}pw.println();pw.close();
 		}catch(Exception ex){ex.printStackTrace();}
 	}
 	public void savesymbols() {
		try{
			File f= new File("E:/my Documents/Coder/JAVA/File/输出文件.txt");
			FileWriter fw = new FileWriter(f,true);
			PrintWriter pw = new PrintWriter(fw,true);
			pw.println();
			pw.println("符号分类：");
			pw.println("符号  			               符号类型");
			Enumeration<Token> e = table.keys();
			while( e.hasMoreElements() ){
				Token t = (Token)e.nextElement();
				pw.write(t + "—————————————————" + table.get(t) + "\r\n");
			}pw.close();
		}catch(Exception e){e.printStackTrace();}
	}
 	public void ReadC(){
 		try{
 			next = (char)br.read();
 			if((int)next == 0xffff){     //判断文件是否读完
 				this.isend = true;
 			}
 		}catch(Exception ex){ex.printStackTrace();}
 	}
 	public Boolean ReadC(char ch){
 		try{
 			ReadC();
 			if(this.next != ch){
 				return false;
 			}
 		}catch(Exception ex){}
 		this.next = ' ';
 		return true;
 	}
 	public Token scan(){
 		try{
 			for( ; ; ReadC() ){   //去掉多余的空格
 				if(next == ' ' || next == '\t'){
 					continue;
 				}else if(next == '\n'){
 					line = line + 1;
 				}
 				else  break; 
 			}
 			switch(next){
 			case '=' :							//	==
 				if(ReadC('=')){
 					tokens.add("==");
 					return Word.equal;
 				}else{
 					tokens.add("=");
 					return new Token('=');
 				}
 			case '>' :							//	>=
 				if(ReadC('=')){
 					tokens.add(">=");
 					return Word.greatequal;
 				}else{
 					tokens.add(">");
 					return new Token('>');
 				}
 			case '<' :							//	<=
 				if(ReadC('=')){
 					tokens.add("<=");
 					return Word.litterequal;
 				}else{
 					tokens.add("<");
 					return new Token('<');
 				}
 			case '!' :							//	!=
 				if(ReadC('=')){
 					tokens.add("!=");
 					return Word.noteuqal;
 				}else{
 					tokens.add("!");
 					return new Token('!');
 				}
 			case '|' :
 				if(ReadC('|')){
 					tokens.add("||");
 					return Word.or;
 				}else{
 					tokens.add("|");
 					return new Token('|');
 				}
 			case '-':
 				if(ReadC('-')){
 					tokens.add("--");
 					return Word.Plus;
 				}else {
 					tokens.add("-");
 					return new Token('-');
 				}
 			case '+':
 				if(ReadC('+')){
 					tokens.add("++");
 					return Word.Add;
 				}else {
 					tokens.add("+");
 					return new Token('+');
 				}
 			}
 			if(Character.isDigit(next)){     //判断数字
 				int value = 0;
 				while(Character.isDigit(next)){
 					value = 10 * value +Character.digit(next,10);
 					ReadC();
 				}
 				number n = new number(value);
 				tokens.add(n.toString());
 				table.put(n, "数字");
 				return n;
 			}
 			if(Character.isLetter(next)){    //变量的定义
 				StringBuffer sb = new StringBuffer();
 				while(Character.isLetterOrDigit(next)){
 					sb.append(next);
 					ReadC();
 				}
 				String s = sb.toString();
 				Word w = (Word)words.get(s);//if是关键字或者类型的话，w不应该是空的
 				if(w!=null){                //从字符表里面找s
 					tokens.add(w.toString());
 					table.put(w, "关键字");
 					return w;
 				} 
 				w = new Word(s,Flag.tag);
 				tokens.add(w.toString());
 				table.put(w, "标识符");
 				words.put(s, w);
 				return w;
 			}
 		}catch(Exception ex){}
 		Token tok = new Token(next);
 		if((int)next != 0xffff){
 			tokens.add(tok.toString());
 		}
 		next = ' '; 
		return tok;
 	}
}

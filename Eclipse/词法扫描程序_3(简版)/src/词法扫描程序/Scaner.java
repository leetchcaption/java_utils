package 词法扫描程序;
import java.util.*;
import java.io.*;
public class Scaner {
	Hashtable<String,Word> words=new Hashtable<String,Word> ();
	LinkedList<String> tokens = new LinkedList<String>();
	BufferedReader br = null;
	char next=' ';
	Boolean isEnd = false;
	public Scaner(){
		try{
			File f = new File("E:/my Documents/Coder/JAVA/File/input.txt");
			FileReader fr = new FileReader(f);
			br = new BufferedReader(fr);
		}catch(Exception e){e.printStackTrace();}
	}
	public Boolean state(){
		return this.isEnd;
	}
	public void ReadC(){
		try {
			next=(char)br.read();
			if((int)next == 0xffff){
				this.isEnd = true;
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public Boolean ReadC(char ch){
		try{
			ReadC();
			if(this.next != ch){
				return false;
			}
		}catch(Exception e){}
		this.next = ' ';
		return true;
	}
	public void Savetoken(){
		try{
			File f = new File("E:/my Documents/Coder/JAVA/File/Token序列.txt");
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			pw.write("源程序产生的Token序列：");
			for(int i=0;i<tokens.size();i++){
				if((String)tokens.get(i)!=" " && (String)tokens.get(i)!="\n"){
					pw.print("‘ "+(String)tokens.get(i)+" ’   ");
				}
			}
			pw.close();
		}catch(Exception e){e.printStackTrace();}
	}
	public Token tokenscan(){
		try{
			for(; ; ReadC()){
				if(next==' ' || next=='\t' || next == '\n'){
					continue;
				}else break;
			}
			switch (next){
			case '=':
				if(ReadC('=')){
					tokens.add("==");
				}else tokens.add("=");
			case '>':
				if(ReadC('=')){
					tokens.add(">=");
				}else tokens.add(">");
			case '<':
				if(ReadC('=')){
					tokens.add("<=");
				}else tokens.add("<");
			case '!':
				if(ReadC('=')){
					tokens.add("!=");
				}else tokens.add("!");
			case '|':
				if(ReadC('|')){
					tokens.add("||");
				}else tokens.add("|");
			case '+':
				if(ReadC('=')){
					tokens.add("+=");
				}else tokens.add("+");
			case '-':
				if(ReadC('=')){
					tokens.add("-=");
				}else tokens.add("-");
			}
			if(Character.isLetter(next)){
				StringBuffer sb = new StringBuffer();
				while(Character.isLetterOrDigit(next)){   //判断变量
					sb.append(next);
					ReadC();
				}
				String s = sb.toString();
				Word w = new Word(s);
				tokens.add(w.tostr());
			}
		}catch(Exception e){e.printStackTrace(); }
		Token tok = new Token();
		if((int)next != 0xffff){
			tokens.add(tok.tostr());
		}
		next = ' ';
		return tok;	
	}
}
class Token {
	public  String tag=null ;
	public Token(String s){
		this.tag = s;
	}
	public Token(){	
	}
	public String tostr(){
		return ""+this.tag;
	}
}
class Word extends Token{
	public String lex = null;
	public Word(String s){
		this.lex = s;
	}
	public String tostr(){
		return this.lex;
	}
}
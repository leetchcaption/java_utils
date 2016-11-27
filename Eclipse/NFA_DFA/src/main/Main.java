package main;

import core.Converter;
import core.FA;
import core.InputFA;

public class Main {
  public static void main(String[] args) {
	//输入有穷自动机32
	  
	FA nfa=new InputFA().input();
	Converter.NFAConvertToDFA(nfa);
  }
}

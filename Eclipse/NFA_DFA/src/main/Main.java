package main;

import core.Converter;
import core.FA;
import core.InputFA;

public class Main {
  public static void main(String[] args) {
	//���������Զ���32
	  
	FA nfa=new InputFA().input();
	Converter.NFAConvertToDFA(nfa);
  }
}

package util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtil { //��������һ������
	public static int inputNum(Scanner scanner) {
        String s=scanner.next();
        
        Pattern pattern=Pattern.compile("\\d+") ;
        Matcher matcher=pattern.matcher(s);
        if(matcher.matches()){
        	return Integer.parseInt(s);
        }else{
        	System.out.println("�������Ϊ������ϵͳ�����˳�!");
        	System.exit(0);
        	return 0;
        }
	}
	
	//��������һ�����ڵ���a,С�ڵ���b������
	public static int inputNumBetweenAandB(Scanner scanner,int a,int b){
		int s=inputNum(scanner);
		if(s>=a&&s<=b){
			return s;
		}else{
			System.out.println("���������������ڵ��� "+a+" С�ڵ���"+b+"��ϵͳ�����˳�!");
			System.exit(0);
			return 0;
		}
	}
}

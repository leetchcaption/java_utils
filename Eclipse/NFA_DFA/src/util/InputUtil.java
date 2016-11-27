package util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtil { //负责输入一个整数
	public static int inputNum(Scanner scanner) {
        String s=scanner.next();
        
        Pattern pattern=Pattern.compile("\\d+") ;
        Matcher matcher=pattern.matcher(s);
        if(matcher.matches()){
        	return Integer.parseInt(s);
        }else{
        	System.out.println("输入必须为整数，系统错误退出!");
        	System.exit(0);
        	return 0;
        }
	}
	
	//负责输入一个大于等于a,小于等于b的整数
	public static int inputNumBetweenAandB(Scanner scanner,int a,int b){
		int s=inputNum(scanner);
		if(s>=a&&s<=b){
			return s;
		}else{
			System.out.println("输入的整数必须大于等于 "+a+" 小于等于"+b+"，系统错误退出!");
			System.exit(0);
			return 0;
		}
	}
}

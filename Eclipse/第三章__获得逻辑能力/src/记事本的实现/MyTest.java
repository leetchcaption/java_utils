package ���±���ʵ��;
import java.util.*;
public class MyTest {
	public static void main(String arg[]){
		ArrayList al = new ArrayList();
		LinkedList ll = new LinkedList();
		long time = System.currentTimeMillis();
		for(int i=0; i<1000000;i++){
			al.add(i) ;
		}	time = System.currentTimeMillis()-time ;
		System.out.println("ArraryList���1000000��ֵ��ʱ"+time+"ms");
		for(int i =0;i<1000000;i++){
			ll.add(i);
		}time = System.currentTimeMillis()-time ;
		System.out.println("LinkedList���1000000��ֵ��ʱ"+time+"ms");
	}
}

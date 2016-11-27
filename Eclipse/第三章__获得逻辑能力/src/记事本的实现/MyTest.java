package 记事本的实现;
import java.util.*;
public class MyTest {
	public static void main(String arg[]){
		ArrayList al = new ArrayList();
		LinkedList ll = new LinkedList();
		long time = System.currentTimeMillis();
		for(int i=0; i<1000000;i++){
			al.add(i) ;
		}	time = System.currentTimeMillis()-time ;
		System.out.println("ArraryList添加1000000个值耗时"+time+"ms");
		for(int i =0;i<1000000;i++){
			ll.add(i);
		}time = System.currentTimeMillis()-time ;
		System.out.println("LinkedList添加1000000个值耗时"+time+"ms");
	}
}

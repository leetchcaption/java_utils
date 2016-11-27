package 记事本的实现;
import java.util.*;
public class Test {
	public static void main(String arg[]){
		ArrayList al = new ArrayList();
		LinkedList ll = new LinkedList();
		long time = System.currentTimeMillis();  //得到系响应时间
		for(int i =0 ;i<1000;i++){
			al.add(1,i);
		}time = System.currentTimeMillis() - time ;
		System.out.println(time);
		time = System.currentTimeMillis();
		for(int i = 0 ; i <1000 ; i++){
			ll.add(1,i);
		}time = System.currentTimeMillis() - time ;
		System.out.println(time);
	}
}

package 记事本的实现List;
import java.util.*;
import java.awt.*;
public class 上溯和下溯 {
	public static void main3(String arg[]){
		ArrayList al = new ArrayList () ;
		Frame f = new Frame();
		al.add(f);
		String s = (String)al.get(0);       //明显错误，但是不会被检测出来
	}
	public void main2(){
		ArrayList <Frame> al = new ArrayList<Frame>();//在C#中为了检测上溯和下溯的类型是否一致，我们将这个做法叫做“泛型”；
		Frame f = new Frame();
		al.add(f);
		//String s = (String) al.get(0);
		Frame F = al.get(0);
	}
//Java在此基础上还引入了新的循环算法，当然，这也是从c#中学习回来的
	public static void main(String arg[]){
		ArrayList<Integer> al = new ArrayList <Integer> ();
		for(int i=0 ;i<100;i++){   //需要说明的是，我们向集合存入的值是int类型，但是由于int是基本数据类型，不是对象，
			al.add(i);//所以自动的装箱操作会将int 转换成他的封装类Integer， 因此在定义泛型的时候不能用int，而是Integer。
		}
		/*for(int v = 0;v<al.size();v++){
			System.out.print(" "+al.get(v));
		}  */
	    for (int v : al){
	      	System.out.print(" "+v);
	    }
	}
}

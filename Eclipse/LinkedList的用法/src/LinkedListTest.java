import java.util.*;
public class LinkedListTest {
	static LinkedList<String> link = new LinkedList<String>();
	public static void main(String arg[]){
		link.add("1");
		link.add("2");
		link.add("3");
		link.add("4");
		link.add("5");
		System.out.println("链表的第一个元素是："+link.getFirst());
		System.out.println("链表的最后一个元素是:"+link.getLast());
		//获取链表元素
		int x=34;
		link.add(2, "34");
		for(int i=0;i<link.size();i++){
			System.out.println(link.get(i));
		}
	}
}

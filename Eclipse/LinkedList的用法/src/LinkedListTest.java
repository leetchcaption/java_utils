import java.util.*;
public class LinkedListTest {
	static LinkedList<String> link = new LinkedList<String>();
	public static void main(String arg[]){
		link.add("1");
		link.add("2");
		link.add("3");
		link.add("4");
		link.add("5");
		System.out.println("����ĵ�һ��Ԫ���ǣ�"+link.getFirst());
		System.out.println("��������һ��Ԫ����:"+link.getLast());
		//��ȡ����Ԫ��
		int x=34;
		link.add(2, "34");
		for(int i=0;i<link.size();i++){
			System.out.println(link.get(i));
		}
	}
}

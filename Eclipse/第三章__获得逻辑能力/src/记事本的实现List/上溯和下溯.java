package ���±���ʵ��List;
import java.util.*;
import java.awt.*;
public class ���ݺ����� {
	public static void main3(String arg[]){
		ArrayList al = new ArrayList () ;
		Frame f = new Frame();
		al.add(f);
		String s = (String)al.get(0);       //���Դ��󣬵��ǲ��ᱻ������
	}
	public void main2(){
		ArrayList <Frame> al = new ArrayList<Frame>();//��C#��Ϊ�˼�����ݺ����ݵ������Ƿ�һ�£����ǽ�����������������͡���
		Frame f = new Frame();
		al.add(f);
		//String s = (String) al.get(0);
		Frame F = al.get(0);
	}
//Java�ڴ˻����ϻ��������µ�ѭ���㷨����Ȼ����Ҳ�Ǵ�c#��ѧϰ������
	public static void main(String arg[]){
		ArrayList<Integer> al = new ArrayList <Integer> ();
		for(int i=0 ;i<100;i++){   //��Ҫ˵�����ǣ������򼯺ϴ����ֵ��int���ͣ���������int�ǻ����������ͣ����Ƕ���
			al.add(i);//�����Զ���װ������Ὣint ת�������ķ�װ��Integer�� ����ڶ��巺�͵�ʱ������int������Integer��
		}
		/*for(int v = 0;v<al.size();v++){
			System.out.print(" "+al.get(v));
		}  */
	    for (int v : al){
	      	System.out.print(" "+v);
	    }
	}
}

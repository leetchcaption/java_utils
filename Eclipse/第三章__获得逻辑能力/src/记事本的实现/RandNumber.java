package ���±���ʵ��;
import java.util.*;
public class RandNumber {   //����1000��0~2000֮�䲻��ȵ������
	public static void main(String arg[]){
		ArrayList<Integer> al = new ArrayList<Integer>();
		while(al.size()<1000){
			int value = (int)(Math.random()*2000);
			boolean b = true ;
			for(int v : al){
				if(value == v){
					b = false ; break ;
				}
			}
			if(b){
				al.add(value);
			}
		}
	/*  ArrayList<Integer> sort = new ArrayList<Integer>();
		while(al.size()>0){       //�����㷨1
			int minvalue = 2001 ;
			for(int v : al){
				if(minvalue >= v){
					minvalue = v ;
				}
			}
			sort.add(minvalue);
			al.remove(new Integer(minvalue));
		}   
		for(int v : sort){
			System.out.print(v+"\n");
		}    */
		for(int i=0 ;i<al.size()-1;i++){       //ð����������
			for(int j=al.size()-1;j>i;j--){
				if(al.get(j)>al.get(j-1)){
					int tmp = al.get(j);
					al.set(j,al.get(j-1) );
					al.set(j-1, tmp);
				}
			}
		}
		for(int v : al ){
			System.out.print(v+"\n");
		}
		Numberhs nu = new Numberhs();
		nu.random();
	}
}
class Numberhs{
	public void random(){
		HashSet<Integer> hs = new HashSet<Integer> () ;
		while(hs.size()<1000){
			int value = (int)(Math.random()*2000);
			hs.add(value);
		}
		ArrayList<Integer> al = new ArrayList<Integer> (hs);
		boolean tag = true ;
		while(tag){
			tag = false ;
			int temp ;
			for(int i=0 ; i< al.size()-1;i++){
				if(al.get(i)>al.get(i+1)){
					temp = al.get(i);
					al.set(i, al.get(i+1));
					al.set(i+1, temp);
					tag = true ;
				}
			}
		}
		for(int v : al){
			System.out.print("\t"+v);
		}
	}
}

package 记事本的实现;
import java.util.*;
public class RandNumber {   //生成1000个0~2000之间不相等的随机数
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
		while(al.size()>0){       //排序算法1
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
		for(int i=0 ;i<al.size()-1;i++){       //冒泡排序排列
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

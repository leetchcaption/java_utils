import java.util.*;
public class 二分查找法 {
	public static void main(String arg[]){
		//产生1000个0——3000之间的随机数
		HashSet<Integer> hs = new HashSet<Integer> () ;
		while (hs.size()<1000){
			int value = (int) (Math.random()*3000) ; //产生0——3000的不同的随机数
			hs.add(value) ;
		}
		ArrayList<Integer> al = new ArrayList<Integer> (hs);//将hashset中的元素装入ArrayList中；
		int sort[] = new int [3000] ;  //排序算法，将al中的所有元素装入sort数组中
		//for(int v=0; v<al.size(); v++){
		//	sort[v] = al.get(v);
		//}al.clear();
		for(int v : al){
			sort[v] = v ;
		}al.clear();
		for(int v : sort){
			if(v>0){
				al.add(v);
			}
		}
		if(al.size()<1000){
			al.add(0,0) ;
		}
		
		//二分查找
		int des = 100 ;
		int minindex = 0 ;
		int maxindex = 999 ;
		while(true){
			//计算中间的下标值
			int midindex = (minindex+maxindex)/2;
			if(des == al.get(midindex)){
				System.out.println("找到了,第"+midindex+"个数.");
				break;
			}
			//找到的值大
			if(des<al.get(midindex)){
				maxindex = (midindex-1);
			}
			//找到的值偏小
			if(des>al.get(midindex)){
				minindex = (midindex+1);
			}
			if(minindex>maxindex){
				System.out.println("没有找到啊!");
				break;
			}
		}
	}
}

import java.util.*;
public class ���ֲ��ҷ� {
	public static void main(String arg[]){
		//����1000��0����3000֮��������
		HashSet<Integer> hs = new HashSet<Integer> () ;
		while (hs.size()<1000){
			int value = (int) (Math.random()*3000) ; //����0����3000�Ĳ�ͬ�������
			hs.add(value) ;
		}
		ArrayList<Integer> al = new ArrayList<Integer> (hs);//��hashset�е�Ԫ��װ��ArrayList�У�
		int sort[] = new int [3000] ;  //�����㷨����al�е�����Ԫ��װ��sort������
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
		
		//���ֲ���
		int des = 100 ;
		int minindex = 0 ;
		int maxindex = 999 ;
		while(true){
			//�����м���±�ֵ
			int midindex = (minindex+maxindex)/2;
			if(des == al.get(midindex)){
				System.out.println("�ҵ���,��"+midindex+"����.");
				break;
			}
			//�ҵ���ֵ��
			if(des<al.get(midindex)){
				maxindex = (midindex-1);
			}
			//�ҵ���ֵƫС
			if(des>al.get(midindex)){
				minindex = (midindex+1);
			}
			if(minindex>maxindex){
				System.out.println("û���ҵ���!");
				break;
			}
		}
	}
}

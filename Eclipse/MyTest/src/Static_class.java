import javax.swing.*;
import java.awt.*;
class Static_class{    //���࣬�����ͱ���һ��
	public static void main(String arg[]){
		//AX test = new AX();
		//AX tset = new AX();
		//System.out.println(tset.i);
		//AX a;
		try{
			Class.forName("AX");//ֻ��ʾ��̬���ڵ�
		}catch(Exception e){e.printStackTrace();}
	}
}
class AX {
	int i = 10 ;
	public AX(){
		System.out.println("AAAAAAAAAA");
	}
	public void show(){
		System.out.println(i);
	}
	static {   //��̬�Ķ���ֻ��һ�ݣ�����˵����ʱ�򣬾�̬������Ѿ�������
		System.out.println("aaaaaaaaaa");
	}
}

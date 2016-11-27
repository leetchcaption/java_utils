import javax.swing.*;
import java.awt.*;
class Static_class{    //主类，类名和标题一样
	public static void main(String arg[]){
		//AX test = new AX();
		//AX tset = new AX();
		//System.out.println(tset.i);
		//AX a;
		try{
			Class.forName("AX");//只显示静态存在的
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
	static {   //静态的东西只有一份，在类说明的时候，静态的类就已经存在了
		System.out.println("aaaaaaaaaa");
	}
}

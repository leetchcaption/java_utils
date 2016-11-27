import java.util.Scanner;

interface hero{   //实现英雄的接口
	public void kill();
	public void magic();
	public void walk();
	public void run();
}
class 法师 implements hero{
	public void kill(){
		System.out.println("法师杀人!");
	}
	public void magic(){
		System.out.println("法师放魔法!");
	}
	public void walk(){
		System.out.println("法师走!");
	}
	public void run(){
		System.out.println("法师跑!");
	}
}
class 得罗伊 implements hero{
	public void kill(){
		System.out.println("德罗意杀人!");
	}
	public void magic(){
		System.out.println("德罗意放魔法!");
	}
	public void walk(){
		System.out.println("德罗意走!");
	}
	public void run(){
		System.out.println("德罗意跑!");
	}
}
class 亚马逊 implements hero{
	public void kill(){
		System.out.println("亚马逊杀人!");
	}
	public void magic(){
		System.out.println("亚马逊放魔法!");
	}
	public void walk(){
		System.out.println("亚马逊走!");
	}
	public void run(){
		System.out.println("亚马逊跑!");
	}
}
public  class classforname {
   public static void main(String arg[]){
	   while(true){
		   Scanner scan = new Scanner(System.in);
		   String choice = scan.next();
		   try{
			 Class c = Class.forName(choice);//相比if而言，class.forname具有更强的
			 Object o = c.newInstance();//灵活性，更加能够体现多态的用法
			 hero h = (hero) o;
			  h.magic();
		   }catch(Exception e){e.printStackTrace();}
	   }
   }
}

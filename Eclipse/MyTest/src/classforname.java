import java.util.Scanner;

interface hero{   //ʵ��Ӣ�۵Ľӿ�
	public void kill();
	public void magic();
	public void walk();
	public void run();
}
class ��ʦ implements hero{
	public void kill(){
		System.out.println("��ʦɱ��!");
	}
	public void magic(){
		System.out.println("��ʦ��ħ��!");
	}
	public void walk(){
		System.out.println("��ʦ��!");
	}
	public void run(){
		System.out.println("��ʦ��!");
	}
}
class ������ implements hero{
	public void kill(){
		System.out.println("������ɱ��!");
	}
	public void magic(){
		System.out.println("�������ħ��!");
	}
	public void walk(){
		System.out.println("��������!");
	}
	public void run(){
		System.out.println("��������!");
	}
}
class ����ѷ implements hero{
	public void kill(){
		System.out.println("����ѷɱ��!");
	}
	public void magic(){
		System.out.println("����ѷ��ħ��!");
	}
	public void walk(){
		System.out.println("����ѷ��!");
	}
	public void run(){
		System.out.println("����ѷ��!");
	}
}
public  class classforname {
   public static void main(String arg[]){
	   while(true){
		   Scanner scan = new Scanner(System.in);
		   String choice = scan.next();
		   try{
			 Class c = Class.forName(choice);//���if���ԣ�class.forname���и�ǿ��
			 Object o = c.newInstance();//����ԣ������ܹ����ֶ�̬���÷�
			 hero h = (hero) o;
			  h.magic();
		   }catch(Exception e){e.printStackTrace();}
	   }
   }
}

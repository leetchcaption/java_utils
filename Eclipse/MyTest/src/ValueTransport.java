import java.awt.*;
public class ValueTransport {
   public static void main(String arg[]){
	   A x=new B();
	   System.out.println(x.i);
   }
}
class A{
	int i=10;
	public void show(){
		System.out.println(i);
	}
}
class B extends A{
	int i=100;
	public void show(){
		System.out.println(i);
	}
}
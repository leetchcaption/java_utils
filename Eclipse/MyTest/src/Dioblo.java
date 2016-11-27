import java.lang.reflect.Method;
import java.util.Scanner;
public class Dioblo {
	public static void main(){
		Scanner scn = new Scanner(System.in);
		String choice = scn.next();
		try{
			Class c = Class.forName(choice);
			Object o = c.newInstance();
			Method m = c.getMethod("kill");
			m.invoke(o);
		}catch(Exception e){}
	}
}

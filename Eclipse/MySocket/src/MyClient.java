import java.net.*;
import java.io.*;
public class MyClient{
	public static void main(String asd[]){
		try{
			Socket s=new Socket("127.0.0.1",8000);
			OutputStream ou=s.getOutputStream();
			OutputStreamWriter ouw=new OutputStreamWriter(ou);
			PrintWriter pw=new PrintWriter(ouw,true);
			pw.println("hello");
			
			InputStream in=s.getInputStream();
			InputStreamReader inr=new InputStreamReader(in);
			BufferedReader br=new BufferedReader(inr);
			System.out.println(br.readLine());
		}catch(Exception e){}
	}
}
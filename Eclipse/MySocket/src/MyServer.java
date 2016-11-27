import java.net.*;
import java.io.*;
public class MyServer{
	public static void main(String arg[]){
		try{
			ServerSocket ss=new ServerSocket(8000);
			Socket s=ss.accept();
			InputStream in=s.getInputStream();
			InputStreamReader inr=new InputStreamReader(in);
			BufferedReader br=new BufferedReader(inr);
			String recieve=br.readLine();
			System.out.println(recieve);
			
			OutputStream os=s.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			PrintWriter pw=new PrintWriter(osw,true);
			pw.println("ÔÚÃ´£¿");
		}catch(Exception e){}
	}
}
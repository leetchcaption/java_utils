import java.net.*;
import java.io.*;
public class Client {
	public static void main(String arg[]){
		try{
			Socket s=new Socket("127.0.0.1",8000);
			OutputStream out=s.getOutputStream();
			OutputStreamWriter outw=new OutputStreamWriter(out);
			PrintWriter pw=new PrintWriter(outw,true);
			pw.println(" ’µΩ√¥£ø");
			
			InputStream in=s.getInputStream();
			InputStreamReader inr=new InputStreamReader(in);
			BufferedReader br=new BufferedReader(inr);
			System.out.println(br.readLine());
		}catch(Exception e){e.printStackTrace();}
	}
}

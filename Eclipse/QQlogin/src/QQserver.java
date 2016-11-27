import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
public class QQserver {
	public static void main(String ar[]){
		try{
			ServerSocket ss=new ServerSocket(8090);
			Socket s=ss.accept();
			InputStream is=s.getInputStream(); //接收端
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String text=br.readLine();
			String u=text.split("%")[0];
			String p=text.split("%")[1];
			System.out.println(text);
			OutputStream os=s.getOutputStream();  //发送端
			OutputStreamWriter osw=new OutputStreamWriter(os);
			PrintWriter pw=new PrintWriter(osw,true);
			if(u.equals("aaa") && p.equals("123")){
				pw.println("OK");
			}
			else{
				pw.println("Error！");
			}
		}catch(Exception e){e.printStackTrace();System.out.println("出错了！");}		
	}
}

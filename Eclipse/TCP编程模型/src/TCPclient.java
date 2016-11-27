import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.Date;
import java.util.Scanner;
public class TCPclient {
	public static void main(String arg[]){
		try {     //客户端程序
			Socket s = new Socket("localhost",3390);   //用IP地址和端口号创建socket对象
			//构建IO流
			OutputStream outputStream =s.getOutputStream(); //获得输入流
			OutputStreamWriter outputStreamwriter =new OutputStreamWriter(outputStream); //创建bufferread对象
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamwriter);
			//构建键盘输入
			Scanner scanner = new Scanner(System.in);
			while(true){
				bufferedWriter.write(scanner.nextLine());
				bufferedWriter.newLine();
				bufferedWriter.flush();
				
				//读取服务器端返回的消息
				BufferedReader bReader = new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				
				System.out.println(s.getInetAddress().getLocalHost()+" : "+s.getPort()+bReader.readLine());	
			}
			//String string = BufferedWriter.readLine();
					
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

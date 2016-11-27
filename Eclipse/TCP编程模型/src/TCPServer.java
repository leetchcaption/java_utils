import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
public class TCPServer {     //服务器程序
	public static void main(String a[]){
		try {    //服务程序段
			ServerSocket ss = new ServerSocket(3390);
			Socket s = ss.accept();//服务器监听
			System.out.println("服务器已启动，Socket正在监听...");
			while(true){
				OutputStreamWriter oStream = new OutputStreamWriter(
						s.getOutputStream());  //获得输出流
				InputStreamReader iStream = new InputStreamReader(
						s.getInputStream());  // 获得输入流
				
				BufferedReader bReader  = new BufferedReader(iStream);
				BufferedWriter bWriter = new BufferedWriter(oStream); //调用输入输出流的read（）或write（）方法，进行数据的传输
				
				String string = bReader.readLine();
				bWriter.write("now date is"+new Date()+"服务器>>"+string);  //传输的内容
				bWriter.flush();    //及时刷新缓冲区
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

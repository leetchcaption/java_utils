import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
public class TCPServer {     //����������
	public static void main(String a[]){
		try {    //��������
			ServerSocket ss = new ServerSocket(3390);
			Socket s = ss.accept();//����������
			System.out.println("��������������Socket���ڼ���...");
			while(true){
				OutputStreamWriter oStream = new OutputStreamWriter(
						s.getOutputStream());  //��������
				InputStreamReader iStream = new InputStreamReader(
						s.getInputStream());  // ���������
				
				BufferedReader bReader  = new BufferedReader(iStream);
				BufferedWriter bWriter = new BufferedWriter(oStream); //���������������read������write�����������������ݵĴ���
				
				String string = bReader.readLine();
				bWriter.write("now date is"+new Date()+"������>>"+string);  //���������
				bWriter.flush();    //��ʱˢ�»�����
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

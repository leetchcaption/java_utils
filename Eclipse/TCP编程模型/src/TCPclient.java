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
		try {     //�ͻ��˳���
			Socket s = new Socket("localhost",3390);   //��IP��ַ�Ͷ˿ںŴ���socket����
			//����IO��
			OutputStream outputStream =s.getOutputStream(); //���������
			OutputStreamWriter outputStreamwriter =new OutputStreamWriter(outputStream); //����bufferread����
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamwriter);
			//������������
			Scanner scanner = new Scanner(System.in);
			while(true){
				bufferedWriter.write(scanner.nextLine());
				bufferedWriter.newLine();
				bufferedWriter.flush();
				
				//��ȡ�������˷��ص���Ϣ
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

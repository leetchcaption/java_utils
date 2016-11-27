package 聊天工具_测试版;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.awt.*;
public class QQserver {
	public static void main(String arg[]){
		try{
			ServerSocket ss= new ServerSocket(8090);
			while(true){
				System.out.println("开始监听...");
				Socket s = ss.accept();
				Myserver t = new Myserver();
				t.setsocket(s);
				t.start();				
			}
		}catch(Exception e){e.printStackTrace();}
		
	}
}
class Myserver  extends Thread{
	Socket s = null;
	public void setsocket(Socket value){
		this.s = value ;
	}
	public void run(){
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			InputStream is = s.getInputStream();  //接收客户端发过来的Socket
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String yure = br.readLine();
			String u = yure.split("%")[0];
			String p = yure.split("%")[1];
			
			OutputStream os= s.getOutputStream(); //给客户端作反馈
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw,true); 
			//以下部分为对数据库的操作
			File f = new File("E:/my Documents/Coder/JAVA/File/SQL.ini");
			FileReader fr =new FileReader(f);
			BufferedReader bur = new BufferedReader(fr);
			String driver =bur.readLine();
			String url = bur.readLine();
			String username=bur.readLine();
			String password=bur.readLine();
			Class.forName(driver);
			cn = DriverManager.getConnection(url,username,password);
			String str = "select * from user where username = ? and password = ?";
			ps = cn.prepareStatement(str);
			ps.setString(1, u);
			ps.setString(2, p);
			rs = ps.executeQuery();
			if(rs.next()){
				pw.println("OK");
				while(true){
					String msg = br.readLine();
					System.out.println(msg);
				}
			}
			else {
				pw.println("Error");
			}
		}catch(Exception ex){ex.printStackTrace();}
		finally{
			try{
				cn.close();
				ps.close();
				rs.close();
			}catch(Exception exc){exc.printStackTrace();}
		}
	}
}

import java.net.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
public class QQServer_new{
	public static void main(String arg[]){
		try{
			ServerSocket ss=new ServerSocket(8000);  //不能放在循环里面
			while(true){
				System.out.println("开始监听...");
				Socket s = ss.accept();
				Myserver t = new Myserver();
				t.setsocket(s);
				t.start();   //进程开始创建运行
			}
		}catch(Exception e){}
	}
}
class Myserver extends Thread{
	private Socket s;
	public void setsocket(Socket value){
		this.s=value;
	}
	public void run(){
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			InputStream in = s.getInputStream();  //接收端
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			OutputStream ou = s.getOutputStream();  //发射端
			OutputStreamWriter ouw = new OutputStreamWriter(ou);
			PrintWriter pw = new PrintWriter(ouw,true);
			String udmp = br.readLine();
			String u = udmp.split("%") [0];
			String p = udmp.split("%") [1];
			File f = new File("E:/my Documents/Coder/JAVA/File/SQL.ini");   //链接数据库配置文件
			FileReader fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			String driver = bfr.readLine();
			String url = bfr.readLine();
			String username = bfr.readLine();
			String password = bfr.readLine();
			Class.forName(driver);
			cn = DriverManager.getConnection(url,username,password);
			String str = "select * from user where username =? and password = ?";
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
				pw.println("Error!");
			}
		}catch(Exception e){e.printStackTrace();}
		finally{
			try{
				cn.close();
				ps.close();
				rs.close();
			}catch(Exception ex ){}
		}
	}
}

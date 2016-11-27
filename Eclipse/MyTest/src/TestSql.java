import java.sql.*;
import java.util.Scanner;
import java.io.*;
public class TestSql{
	public static void main(String arg[]){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner scn = new Scanner(System.in);
		String user = scn.next();
		Scanner sca = new Scanner(System.in);
		String pswd = sca.next();
		try{
			File f = new File("E:/my Documents/Coder/JAVA/File/SQL.ini");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String driver = br.readLine();
			String url=br.readLine();
			String username=br.readLine();  //数据库root用户登录密码
			String password=br.readLine();
			Class.forName(driver);
			cn = DriverManager.getConnection(url,username,password);
			st = cn.createStatement();
			String str = "select * from user where username='"+user+"' and password='"+pswd+"'";
			rs = st.executeQuery(str);
			if(rs.next()){
				System.out.println("验证通过！");
			}
			else {
				System.out.println("验证未通过!");
			}
		}catch(Exception e){System.out.println("ERROR!");}
		finally{
			try{
				cn.close();
				st.close();
				rs.close();
			}catch(Exception E){E.printStackTrace();System.out.println("error！");}
		}
	}
}
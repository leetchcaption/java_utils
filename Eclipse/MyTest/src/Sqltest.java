import java.sql.*;
public class Sqltest{
	public static void main(String arg[]){
		String u="aaa";
		String p="123";
		Connection cn = null ;
		ResultSet rs = null;
		PreparedStatement ps = null ;
		try{ 
			Class.forName("org.gjt.mm.mysql.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qq","root","leetch");
			ps = cn.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, u);
			ps.setString(2, p);
			rs=ps.executeQuery();
			if(rs.next()){
				System.out.println("验证通过!");
			}else{
				System.out.println("验证未通过!");
			}
			
		}catch(Exception e){e.printStackTrace();}
	}
}
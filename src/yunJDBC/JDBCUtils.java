package yunJDBC;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	private static String user = null;
	private static String pwd = null;
	private static String driverclass = null;
	private static String url = null;
	
	static {
		InputStream in = null;
		try {
			in = JDBCUtils.class.getResourceAsStream("./jdbc.properties");
			Properties pro = new Properties();
			pro.load(in);
			url = pro.getProperty("url");
			
			user = pro.getProperty("user");
			pwd = pro.getProperty("password");
			
			driverclass = pro.getProperty("driver");
			Class.forName(driverclass);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn= DriverManager.getConnection(url, user,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	public static void main(String[] args) {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(conn);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


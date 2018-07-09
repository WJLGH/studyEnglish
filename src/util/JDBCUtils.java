package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String user = null;
	private static String pwd = null;
	private static String driverclass = null;
	private static String url = null;
	/**
	 * 这里保证conn在一次登录中保持单例，省去每一次连接的时间
	 */
	private static Connection conn = null;
	/**
	 * 初始化数据库连接配置
	 */
	static {
		try {
			initSet();
		} catch (Exception e) {
			System.out.println("数据库配置失败");
			e.printStackTrace();
		}
		//弃用 ，无法读取 .proerties文件
//		InputStream in = null;
//		try {
//			in = JDBCUtils.class.getResourceAsStream("./jdbc.properties");
//			Properties pro = new Properties();
//			pro.load(in);
//			url = pro.getProperty("url");
//
//			user = pro.getProperty("user");
//			pwd = pro.getProperty("password");
//
//			driverclass = pro.getProperty("driver");
//			System.out.println("数据库信息为："+url+","+user+","+pwd+","+driverclass);
//			Class.forName(driverclass);
//			conn = getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("数据库配置失败");
//		}
	}
	public static void initSet() throws Exception {
		user = "root";
		pwd = "pp123456";
		url="jdbc:mysql://123.207.14.231:3306/studyEnglish?useSSL=true";
		driverclass="com.mysql.jdbc.Driver";
		Class.forName(driverclass);
	}
	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		if (conn != null) {
			return conn;
		}
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取数据库连接失败");
		}

		return conn;
	}
	

	/**
	 * 关闭数据库连接
	 * 
	 * @param con
	 */
	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeResource( ) {
		try {
			if(conn != null) {
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeResource(Statement sta) {
		try {
			if (sta != null) {
				sta.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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

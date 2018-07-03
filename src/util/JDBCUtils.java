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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库配置失败");
		}
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

	public static void closeConnection(Connection con, Statement sta, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (sta != null) {
				sta.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据连接关闭失败");
		}
	}

	public static void closeConnection(Connection con, Statement sta) {
		try {
			if (sta != null) {
				sta.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据连接关闭失败");
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

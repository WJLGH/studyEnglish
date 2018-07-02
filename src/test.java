import java.sql.*;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import model.ManagerBean;
import util.JDBCUtils;
public class test {
	public static void main(String[] args)  {
		Connection conn = JDBCUtils.getConnection();
		ManagerBean mb = null;
		String sql = "select * from manager where mname = ?";
		QueryRunner qr = new QueryRunner();
		try {
			/**
			 * 1）多条数据匹配，第一条数据
			 * 2）如果JavaBean中有数据库没有的成员变量，不设置，
			 * 3)调用无参构造函数，在调用setter
			 */
			mb = qr.query(conn, sql, new BeanHandler<ManagerBean>(ManagerBean.class), "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(mb);
		JDBCUtils.closeConnection(conn);
	}
}

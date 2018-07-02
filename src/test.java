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
		String sql = "select * from manager where mid = ?";
		QueryRunner qr = new QueryRunner();
		try {
			mb = qr.query(conn, sql, new BeanHandler<ManagerBean>(ManagerBean.class), 10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mb);
		JDBCUtils.closeConnection(conn);
	}
}

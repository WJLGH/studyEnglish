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
			 * 1����������ƥ�䣬��һ������
			 * 2�����JavaBean�������ݿ�û�еĳ�Ա�����������ã�
			 * 3)�����޲ι��캯�����ڵ���setter
			 */
			mb = qr.query(conn, sql, new BeanHandler<ManagerBean>(ManagerBean.class), "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(mb);
		JDBCUtils.closeConnection(conn);
	}
}

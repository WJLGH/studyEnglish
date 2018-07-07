package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import model.ManagerBean;
import model.UserBean;
import model.WordBean;
import util.JDBCUtils;

public class UserDao {
	/**
	 * ��¼��֤
	 */
	/**
	 * ��½��֤
	 * nullΪû��
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException 
	 */
	public static UserBean checkLogin(String name,String pwd) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "select uid,uname,upwd,upage from user where uname=? and upwd=?";
		UserBean userBean = runner.query(con,sql,new BeanHandler<UserBean>(UserBean.class),name,pwd);
		return userBean;
	}
	
	
	/**
	 * �˳���¼����¼��Ϣ*********************************���޸�
	 * �˳�ʱ�����ݸ�logoutһ��new userBean
	 * ����upage��״̬���´ε�¼ʱ�����ʴ��µ�upage��ʼ
	 * @param user
	 * @return 
	 * @throws SQLException 
	 */
	public static boolean Logout(UserBean user) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "update user set upage=? where uname=?";
		int i =  runner.update(con,sql,user.getUpage(),user.getUname());
		return 0 < i;
	}
	
	public static boolean setPwd(int uid,String pwd) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "update user set upwd=? where uid=?";
		return 0 < runner.update(con,sql,pwd,uid);
	}
	
	public static boolean addUser(UserBean user) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Connection conn = JDBCUtils.getConnection();
		String sql = "INSERT INTO user (uname,upwd) VALUES(?,?)";
		return 0< qr.update(conn, sql, user.getUname(),user.getUpwd());
	}


	public static boolean userNameAvailable(String uname) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT * FROM user WHERE uname = ?";
		return qr.query(conn, sql, new BeanHandler<UserBean>(UserBean.class),uname) == null;
	}
	public static void main(String[] args) {
		try {
			System.out.println(userNameAvailable("1111"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

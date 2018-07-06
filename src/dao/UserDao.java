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
	 * 登录验证
	 */
	/**
	 * 登陆验证
	 * null为没有
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
	 * 退出登录，记录信息*********************************有修改
	 * 退出时，传递给logout一个new userBean
	 * 保存upage的状态，下次登录时背单词从新的upage开始
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
	
}

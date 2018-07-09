package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import model.ManagerBean;
import util.JDBCUtils;

public class ManagerDao {
	
	/**
	 * 登陆验证
	 * null 为没有
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException 
	 */
	
	public static ManagerBean checkLogin(String name,String pwd) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "select mid,mname,mpwd,lastlogin from manager where mname=? and mpwd=?";
		ManagerBean mBean = runner.query(con,sql,new BeanHandler<ManagerBean>(ManagerBean.class),name,pwd);
		return mBean;
	}
	/**
	 * 保存最新登陆时间 **************************************有修改 增加了date
	 * @param m
	 * @return 
	 * @throws SQLException 
	 */
	public static boolean saveDate(ManagerBean m) throws SQLException {  
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "update manager set lastlogin=? where mname=?";
		return 0 < runner.update(con,sql,new Date(),m.getMname());
		
	}
	/**
	 * 设置某个管理员的密码
	 * @param mid
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	public static boolean setPwd(int mid,String pwd) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "update manager set mpwd=? where mid=?";
		return 0 < runner.update(con,sql,pwd,mid);
	}
}

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
	 * ��½��֤
	 * null Ϊû��
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
	 * �������µ�½ʱ�� **************************************���޸� ������date
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
	 * ����ĳ������Ա������
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

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
	 */
	public static void Logout(UserBean user) {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		
	}
	
}

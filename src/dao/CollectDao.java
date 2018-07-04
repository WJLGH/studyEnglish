package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import model.CollectBean;
import model.UserBean;
import model.WordBean;
import util.JDBCUtils;
import util.stringutil;

public class CollectDao {
	/**
	 * ��ѯĳ���û��ղصĵ���***************************�����г������ղص��ʣ�
	 * Ψһ��ѯ
	 * @param uid
	 * @return
	 * @throws SQLException SQLException
	 */
	public static List<WordBean> queryUserCollect(int uid) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "select distinct s.uid,s.wid from user u left join collect s on u.uid=? ";
		List<CollectBean> cLists = runner.query(con, sql,new BeanListHandler<CollectBean>(CollectBean.class),uid);
		List<WordBean> wLists = new ArrayList<WordBean>();
		for(CollectBean cBean:cLists) {
			if(cBean.getUid()==uid) {
			 String sql2 = "select * from word where wid=?";
			 WordBean wBean = runner.query(con, sql2,new BeanHandler<WordBean>(WordBean.class),cBean.getWid());
			 wLists.add(wBean);
			}
			
		}
		return wLists;
	}
	/**
	 * ����һ���û��ղصĵ���********************����Ӧ���Ǹ�wordbean��
	 * @param co
	 * @throws SQLException 
	 */
	public static void addCollectBean(CollectBean co) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "insert into collect(uid,wid) values(?,?)";
		runner.update(con,sql,co.getUid(),co.getWid());
	}
	/**
	 * ɾ��һ���û��ղصĵ���
	 * @param uid
	 * @param wid
	 * @throws SQLException 
	 */
	public static void deleteCollectBean(int uid,int wid) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "delete from collect where uid=? and wid=?";
		runner.update(con,sql,uid,wid);
	}
}

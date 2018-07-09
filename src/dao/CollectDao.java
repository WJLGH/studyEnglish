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

public class CollectDao {
	/**
	 * ��ѯĳ���û��ղصĵ���***************************�����г������ղص���
	 * Ψһ��ѯ
	 * @param uid
	 * @return
	 * @throws SQLException SQLException
	 */
	public static List<WordBean> queryUserCollect(int uid) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		
		//����collect �� word��ѯ
		String sql = "SELECT w.`wid`, w.`word`,w.`eg`,w.`trans`,w.`vid` FROM collect c,word w WHERE c.uid = ? AND c.wid = w.wid GROUP BY w.`wid`";
		List<WordBean> list = runner.query(con, sql, new BeanListHandler<WordBean>(WordBean.class), uid);
		
		//����ÿ�����ʵ�����
		for (WordBean wordBean : list) {
			wordBean.setMeans(MeaningDao.queryMeaning(wordBean));
		}
		return list;
	}
	/**
	 * ����һ���û��ղصĵ���
	 * @param co
	 * @return 
	 * @throws SQLException 
	 */
	public static boolean addCollectBean(CollectBean co) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		//���뵽cllect����
		String sql = "insert into collect(uid,wid) values(?,?)";
		return 0 < runner.update(con,sql,co.getUid(),co.getWid());
	}
	/**
	 * ɾ��һ���û��ղص�һ������
	 * @param uid
	 * @param wid
	 * @return 
	 * @throws SQLException 
	 */
	public static boolean deleteCollectBean(int uid, int wid) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		//����ɾ�����ӵ����ͬ uid �� wid�ļ�¼
		String sql = "delete from collect where uid = ? and wid = ?";
		return 0 < runner.update(con,sql,uid,wid);
	}
}

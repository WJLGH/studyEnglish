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
	 * 查询某个用户收藏的单词***************************这是列出所有收藏单词
	 * 唯一查询
	 * @param uid
	 * @return
	 * @throws SQLException SQLException
	 */
	public static List<WordBean> queryUserCollect(int uid) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		
		//联合collect ， word查询
		String sql = "SELECT w.`wid`, w.`word`,w.`eg`,w.`trans`,w.`vid` FROM collect c,word w WHERE c.uid = ? AND c.wid = w.wid GROUP BY w.`wid`";
		List<WordBean> list = runner.query(con, sql, new BeanListHandler<WordBean>(WordBean.class), uid);
		
		//设置每个单词的释义
		for (WordBean wordBean : list) {
			wordBean.setMeans(MeaningDao.queryMeaning(wordBean));
		}
		return list;
	}
	/**
	 * 增加一个用户收藏的单词
	 * @param co
	 * @return 
	 * @throws SQLException 
	 */
	public static boolean addCollectBean(CollectBean co) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		//插入到cllect表中
		String sql = "insert into collect(uid,wid) values(?,?)";
		return 0 < runner.update(con,sql,co.getUid(),co.getWid());
	}
	/**
	 * 删除一个用户收藏的一个单词
	 * @param uid
	 * @param wid
	 * @return 
	 * @throws SQLException 
	 */
	public static boolean deleteCollectBean(int uid, int wid) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		//可能删除多个拥有相同 uid 和 wid的记录
		String sql = "delete from collect where uid = ? and wid = ?";
		return 0 < runner.update(con,sql,uid,wid);
	}
}

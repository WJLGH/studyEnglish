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
	 * 查询某个用户收藏的单词***************************这是列出所有收藏单词
	 * 唯一查询
	 * @param uid
	 * @return
	 * @throws SQLException SQLException
	 */
	public static List<WordBean> queryUserCollect(int uid) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "SELECT w.`wid`, w.`word`,w.`eg`,w.`trans`,w.`vid` FROM collect c,word w WHERE c.uid = ? AND c.wid = w.wid GROUP BY w.`wid`";
		List<WordBean> list = runner.query(con, sql, new BeanListHandler<WordBean>(WordBean.class), uid);
		for (WordBean wordBean : list) {
			wordBean.setMeans(MeaningDao.queryMeaning(wordBean));
		}
		return list;
	}
	/**
	 * 增加一个用户收藏的单词********************参数应该是个wordbean？
	 * @param co
	 * @return 
	 * @throws SQLException 
	 */
	public static boolean addCollectBean(CollectBean co) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "insert into collect(uid,wid) values(?,?)";
		return 0 < runner.update(con,sql,co.getUid(),co.getWid());
	}
	/**
	 * 删除一个用户收藏的单词
	 * @param uid
	 * @param wid
	 * @return 
	 * @throws SQLException 
	 */
	public static boolean deleteCollectBean(int sid ) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "delete from collect where sid = ?";
		return 0 < runner.update(con,sql,sid);
	}
	public static boolean deleteCollectBean(int uid, int wid) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "delete from collect where uid = ? and wid = ?";
		return 0 < runner.update(con,sql,uid,wid);
	}
}

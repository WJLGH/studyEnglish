package dao;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import model.MeaningBean;
import model.WordBean;
import util.JDBCUtils;

public class MeaningDao {
	/**
	 * 删除某个cid 的记录
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	public static boolean deleteMeanigBean(int cid) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "delete from meaning where cid = ?";
		QueryRunner qr = new QueryRunner();
		return 0 < qr.update(conn,sql, cid);
	}
	/**
	 * 删除某个单词的释义
	 * @param wid
	 * @return
	 * @throws SQLException
	 */
	public static boolean deleteWordMeaing(int wid) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "delete from meaning where wid = ?";
		QueryRunner qr = new QueryRunner();
		return 0 < qr.update(conn,sql, wid);
	}
	/**
	 * 添加一条释义
	 * @param mb
	 * @return
	 * @throws SQLException
	 */
	public static boolean addMeaningBean(MeaningBean mb) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "insert into meaning (chinese,wid) values (?,?)";
		QueryRunner qr = new QueryRunner();
		return 0 < qr.update(conn, sql, mb.getChinese(),mb.getWid());
	}
	/**
	 * 通过某个单词的英文查询这个单词的释义
	 * @param word
	 * @return
	 * @throws SQLException
	 */
	public static List<MeaningBean>  queryMeaning(String word) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql  = "SELECT m.`cid`,m.`chinese`,m.`wid` FROM word w,meaning m WHERE w.`word` = ? AND m.`wid` = w.`wid`";
		QueryRunner qr = new QueryRunner();
		return qr.query(conn,sql,new BeanListHandler<MeaningBean>( MeaningBean.class),word);
	}
	/**
	 * 通过某个单词的Bean对象来查询一个单词的释义
	 * @param word
	 * @return
	 * @throws SQLException
	 */
	public static List<MeaningBean> queryMeaning(WordBean word) throws SQLException{
		Connection conn = JDBCUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from meaning where wid =?";
		return qr.query(conn, sql, new BeanListHandler<MeaningBean>( MeaningBean.class) , word.getWid());
	}
	/**
	 * 通过释义来确定某个单词对象
	 * @param chinese
	 * @return
	 * @throws SQLException
	 */
	public static WordBean queryWord(String chinese) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT w.`wid`,w.`word`,w.`eg`,w.`vid`,w.`eg`,w.`trans` FROM meaning AS m, word AS w  WHERE chinese LIKE ? AND m.wid = w.wid ";
		QueryRunner qr = new QueryRunner();
		WordBean wBean = qr.query(conn, sql, new BeanHandler<WordBean>(WordBean.class), chinese);
		if(wBean != null) {
			wBean.setMeans(queryMeaning(wBean));
		}
		return wBean;
	}
	
}

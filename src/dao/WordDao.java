package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
<<<<<<< HEAD
=======
import org.apache.commons.dbutils.handlers.BeanListHandler;
>>>>>>> 9408d57d89bafcc3c3fc888559854cd44ce9bcb7

import model.MeaningBean;
import model.WordBean;
import util.JDBCUtils;

public class WordDao {
	/**
	 * 增删改查
	 */
	//页大小
	public static int pageSize = 10;
	
	/**
	 * 用户背单词查询
	 * 分页查询
	 * @param page
	 * @return
	 * @throws SQLException 
	 */
	public static List<WordBean> limitQuery(int page) throws SQLException{
		Connection conn  = JDBCUtils.getConnection();
		String sql = "select * from word limit ? offset ?";
		QueryRunner qr = new QueryRunner();
		List<WordBean> list = qr.query(conn, sql, new BeanListHandler<WordBean>(WordBean.class), pageSize,page);
		for (WordBean wordBean : list) {
			wordBean.setMeans(MeaningDao.queryMeaning(wordBean));
		}
		return list;
	}
	/**
	 * 英文查找中文
	 * null为空
	 * @param word
	 * @return
	 * @throws SQLException 
	 */
	public static List<MeaningBean> enQueryZh(String word) throws SQLException {
		WordBean r = null;
		r = queryWordBean(word);
		
		return r==null? null : MeaningDao.queryMeaning(r);
	}
	/**
<<<<<<< HEAD
	 * 中文查找英文   多表查询
	 * null为空
	 * @param chinese
	 * @return
	 * @throws SQLException 
	 */
	public static WordBean zhQueryEn(String chinese) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();	
		String sql = "select w.wid,w.word,w.eg,w.trans,w.vid from word w,meaning m where m.chinese=? and m.wid=w.wid";
		WordBean w  = runner.query(con,sql,new BeanHandler<WordBean>(WordBean.class),chinese);	
	    return w;
=======
	 * 根据一个单词查找这个单词的WordBean对象
	 * @param word
	 * @return
	 * @throws SQLException
	 */
	public static WordBean queryWordBean(String word) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql ="select * from word where word = ?";
		QueryRunner qr = new QueryRunner();
		WordBean wb = qr.query(conn, sql,new BeanHandler<WordBean>(WordBean.class),word);
		wb.setMeans(MeaningDao.queryMeaning(wb));
		return wb;
>>>>>>> 9408d57d89bafcc3c3fc888559854cd44ce9bcb7
	}
	
	/**
	 * 增加单词
	 * @param word
	 * @throws SQLException 
	 */
	public static void addWordBean(WordBean word) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql ="INSERT INTO word (word,eg,trans,vid) VALUES(?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, word.getWord(),word.getEg(),word.getEg(),word.getVid());
		for(MeaningBean mb :word.getMeans()) {
			MeaningDao.addMeaningBean(mb);
		}
	}
	/**
	 * 删除单词
	 * @param word
	 * @throws SQLException 
	 */
	public static void deleteWordBean(int wid) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql ="delete from word where wid = ?";
		QueryRunner qr = new QueryRunner();
		qr.update(conn,sql,wid);
	}
	/**
	 * 修改单词
	 * @param word
	 * @throws SQLException 
	 */
	public static void updateWordBean(WordBean word) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "UPDATE word SET word = ? ,eg = ?, trans =  ? WHERE wid = ?";
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, word.getWord(),word.getEg(),word.getEg(),word.getWid());
	}
	/**
	 * 查询某个词汇表里的单词
	 * @param vid
	 * @return
	 * @throws SQLException 
	 */
	public static List<WordBean> queryVocabulary(int vid) throws SQLException {
		Connection conn  = JDBCUtils.getConnection();
		String sql = "select * from word where vid = ?";
		QueryRunner qr = new QueryRunner();
		List<WordBean> list = qr.query(conn, sql, new BeanListHandler<WordBean>(WordBean.class), vid);
		for (WordBean wordBean : list) {
			wordBean.setMeans(MeaningDao.queryMeaning(wordBean));
		}
		return list;	
	}
}

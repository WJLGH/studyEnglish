package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import model.MeaningBean;
import model.WordBean;
import util.CharacterUtil;
import util.JDBCUtils;

public class WordDao {
	/**
	 * 增删改查
	 */
	// 页大小
	public static int pageSize = 3;

	/**
	 * 用户背单词查询 分页查询
	 * 
	 * @param page
	 * @return
	 * @throws SQLException
	 */
	public static List<WordBean> limitQuery(int page) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		System.out.println("yeshu" + page);
		String sql = "select * from word limit ? offset ?";
		QueryRunner qr = new QueryRunner();
		List<WordBean> list = qr.query(conn, sql, new BeanListHandler<WordBean>(WordBean.class), pageSize, page);
		for (WordBean wordBean : list) {
			wordBean.setMeans(MeaningDao.queryMeaning(wordBean));
		}
		return list;
	}

	/**
	 * 
	 * 中文查找英文 多表查询 null为空
	 * 
	 * @param chinese
	 * @return
	 * @throws SQLException
	 */
	public static List<WordBean> zhQueryEn(String chinese) throws SQLException {
		Connection con = JDBCUtils.getConnection();
		String sql = "select w.wid,w.word,w.eg,w.trans,w.vid from word w,meaning m where m.chinese = ? and m.wid = w.wid";
		QueryRunner qr = new QueryRunner();
		List<WordBean> list = qr.query(con, sql, new BeanListHandler<WordBean>(WordBean.class),chinese);
		for (WordBean wordBean : list) {
			System.out.println(wordBean);
			wordBean.setMeans(MeaningDao.queryMeaning(wordBean));
		}
		return list;
	}
	/**
	 * 添加的时候查询到新单词的wid
	 * 再添加释义
	 * @param wb
	 * @return
	 * @throws SQLException 
	 */
	public static Integer queryWordBean(WordBean wb) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT wid FROM word WHERE word = ? AND vid = ?";
		QueryRunner qr = new QueryRunner();
		return qr.query(conn, sql, new ResultSetHandler<Integer>() {

			@Override
			public Integer handle(ResultSet rs) throws SQLException {
				if(rs != null) {
					rs.next();
					return rs.getInt("wid");
				}
				return null;
			}
			
		},wb.getWord(),wb.getVid());
	}
	/**
	 * 根据一个单词查找这个单词的WordBean对象
	 * 
	 * @param word
	 * @return
	 * @throws SQLException
	 */
	public static WordBean queryWordBean(String word) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from word where word = ?";
		QueryRunner qr = new QueryRunner();
		WordBean wb = qr.query(conn, sql, new BeanHandler<WordBean>(WordBean.class), word);
		if (wb != null) {
			wb.setMeans(MeaningDao.queryMeaning(wb));
		}
		return wb;

	}

	/**
	 * 增加单词
	 * 
	 * @param word
	 * @throws SQLException
	 */
	public static boolean addWordBean(WordBean word) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "INSERT INTO word (word,eg,trans,vid) VALUES(?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		int i = qr.update(conn, sql, word.getWord(), word.getEg(), word.getTrans(), word.getVid());
		return i > 0;
	}

	/**
	 * 删除单词
	 * 
	 * @param word
	 * @return
	 * @throws SQLException
	 */
	public static boolean deleteWordBean(int wid) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "delete from word where wid = ?";
		QueryRunner qr = new QueryRunner();
		return 0 < qr.update(conn, sql, wid);
	}

	/**
	 * 修改单词
	 * 
	 * @param word
	 * @return
	 * @throws SQLException
	 */
	public static boolean updateWordBean(WordBean word) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "UPDATE word SET word = ? ,eg = ?, trans =  ?,vid = ? WHERE wid = ?";
		MeaningDao.deleteWordMeaing(word.getVid());
		QueryRunner qr = new QueryRunner();
		return 0 < qr.update(conn, sql, word.getWord(), word.getEg(), word.getEg(),word.getVid(), word.getWid());
	}

	/**
	 * 查询某个词汇表里的单词
	 * 
	 * @param vid
	 * @return
	 * @throws SQLException
	 */
	public static List<WordBean> queryVocabulary(int vid) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from word where vid = ?";
		QueryRunner qr = new QueryRunner();
		List<WordBean> list = qr.query(conn, sql, new BeanListHandler<WordBean>(WordBean.class), vid);
		for (WordBean wordBean : list) {
			wordBean.setMeans(MeaningDao.queryMeaning(wordBean));
		}
		return list;
	}

	public static List<WordBean> querySearch(String word, int vid)throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		StringBuffer sql = new StringBuffer("SELECT * FROM word WHERE word LIKE \"%"+word+"%\" ");
		if(vid != -1) {
			sql.append("and vid = "+vid );
		}
		QueryRunner qr = new QueryRunner();
		List<WordBean> list  = qr.query(conn, sql.toString(), new BeanListHandler<WordBean>(WordBean.class));
		for (WordBean wordBean : list) {
			wordBean.setMeans(MeaningDao.queryMeaning(wordBean));
		}
		return list;
	}

	public static List<WordBean> fuzzySearchWordBean(String input) throws SQLException {
		if("".equals(input)) {
			return null;
		}
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT * FROM word WHERE word LIKE \"%"+input+"%\"  ";
		QueryRunner qr = new QueryRunner();
		List<WordBean> list = qr.query(conn, sql, new BeanListHandler<WordBean>(WordBean.class));
		for (WordBean wordBean : list) {
			wordBean.setMeans(MeaningDao.queryMeaning(wordBean));
		}
		return list;
	}
}

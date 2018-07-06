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
import util.JDBCUtils;

public class WordDao {
	/**
	 * ��ɾ�Ĳ�
	 */
	// ҳ��С
	public static int pageSize = 3;

	/**
	 * �û������ʲ�ѯ ��ҳ��ѯ
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
	 * ���Ĳ���Ӣ�� ����ѯ nullΪ��
	 * 
	 * @param chinese
	 * @return
	 * @throws SQLException
	 */
	public static WordBean zhQueryEn(String chinese) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "select w.wid,w.word,w.eg,w.trans,w.vid from word w,meaning m where m.chinese=? and m.wid=w.wid";
		WordBean w = runner.query(con, sql, new BeanHandler<WordBean>(WordBean.class), chinese);
		return w;
	}
	/**
	 * ��ӵ�ʱ���ѯ���µ��ʵ�wid
	 * ���������
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
	 * ����һ�����ʲ���������ʵ�WordBean����
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
	 * ���ӵ���
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
	 * ɾ������
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
	 * �޸ĵ���
	 * 
	 * @param word
	 * @return
	 * @throws SQLException
	 */
	public static boolean updateWordBean(WordBean word) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "UPDATE word SET word = ? ,eg = ?, trans =  ? WHERE wid = ?";
		MeaningDao.deleteWordMeaing(word.getVid());
		QueryRunner qr = new QueryRunner();
		int i = qr.update(conn, sql, word.getWord(), word.getEg(), word.getEg(), word.getWid());
		for (MeaningBean meaning : word.getMeans()) {
			MeaningDao.addMeaningBean(meaning);
		}
		return i > 0;
	}

	/**
	 * ��ѯĳ���ʻ����ĵ���
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
}

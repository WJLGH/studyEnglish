package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

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
	 */
	public static List<WordBean> limitQuery(int page){
		return null;
	}
	/**
	 * 英文查找中文
	 * null为空
	 * @param word
	 * @return
	 */
	public static List<MeaningBean> enQueryZh(String word) {
		return null;
	}
	/**
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
	}
	/**
	 * 增加单词
	 * @param word
	 */
	public static void addWordBean(WordBean word) {
		
	}
	/**
	 * 删除单词
	 * @param word
	 */
	public static void deleteWordBean(int wid) {
		
	}
	/**
	 * 修改单词
	 * @param word
	 */
	public static void updateWordBean(int  wid) {
		
	}
	/**
	 * 查询某个词汇表里的单词
	 * @param vid
	 * @return
	 */
	public static List<WordBean> queryVocabulary(int vid) {
		return null;
	}
}

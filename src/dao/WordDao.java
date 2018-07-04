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
	 * ��ɾ�Ĳ�
	 */
	//ҳ��С
	public static int pageSize = 10;
	
	/**
	 * �û������ʲ�ѯ
	 * ��ҳ��ѯ
	 * @param page
	 * @return
	 */
	public static List<WordBean> limitQuery(int page){
		return null;
	}
	/**
	 * Ӣ�Ĳ�������
	 * nullΪ��
	 * @param word
	 * @return
	 */
	public static List<MeaningBean> enQueryZh(String word) {
		return null;
	}
	/**
	 * ���Ĳ���Ӣ��   ����ѯ
	 * nullΪ��
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
	 * ���ӵ���
	 * @param word
	 */
	public static void addWordBean(WordBean word) {
		
	}
	/**
	 * ɾ������
	 * @param word
	 */
	public static void deleteWordBean(int wid) {
		
	}
	/**
	 * �޸ĵ���
	 * @param word
	 */
	public static void updateWordBean(int  wid) {
		
	}
	/**
	 * ��ѯĳ���ʻ����ĵ���
	 * @param vid
	 * @return
	 */
	public static List<WordBean> queryVocabulary(int vid) {
		return null;
	}
}

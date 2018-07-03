package dao;

import java.util.List;

import model.MeaningBean;
import model.WordBean;

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
	 * 中文查找英文
	 * null为空
	 * @param chinese
	 * @return
	 */
	public static WordBean zhQueryEn(String chinese) {
		return null;
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

package dao;

import java.util.List;

import model.MeaningBean;
import model.WordBean;

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
	 * ���Ĳ���Ӣ��
	 * nullΪ��
	 * @param chinese
	 * @return
	 */
	public static WordBean zhQueryEn(String chinese) {
		return null;
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

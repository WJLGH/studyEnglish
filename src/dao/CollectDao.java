package dao;

import java.util.List;

import model.CollectBean;
import model.UserBean;
import model.WordBean;

public class CollectDao {
	/**
	 * 查询某个用户收藏的单词
	 * 唯一查询
	 * @param uid
	 * @return
	 */
	public static List<WordBean> queryUserCollect(int uid) {
		return null;
	}
	/**
	 * 增加一个用户收藏的单词
	 * @param co
	 */
	public static void addCollectBean(CollectBean co) {
		
	}
	/**
	 * 删除一个用户收藏的单词
	 * @param uid
	 * @param wid
	 */
	public static void deleteCollectBean(int uid,int wid) {
		
	}
}

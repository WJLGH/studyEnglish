package dao;

import java.util.List;

import model.UserBean;
import model.WordBean;

public class UserDao {
	/**
	 * 登录验证，用户词汇量查询，用户收藏词汇表增删查
	 */
	/**
	 * 登陆验证
	 * null为没有
	 * @param name
	 * @param pwd
	 * @return
	 */
	public static UserBean checkLogin(String name,String pwd) {
		return null;
	}
	/**
	 * 查询收藏单词表
	 * @param user
	 * @return
	 */
	public static void queryUserCollect (UserBean user) {
	}
	/**
	 * 删除收藏单词
	 * @param user
	 * @param word
	 */
	public static void deleteUserCollectItem(UserBean user,WordBean word) {
		
	}
	/**
	 * 添加收藏单词
	 * @param user
	 * @param word
	 */
	public static void addUserCollectItem(UserBean user,WordBean word) {
		
	}
}

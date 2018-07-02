package dao;

import java.util.List;

import model.UserBean;
import model.WordBean;

public class UserDao {
	/**
	 * 登录验证，用户词汇量查询，用户收藏词汇表增删查
	 */
	public static UserBean checkLogin(String name,String pwd) {
		return null;
	}
	public static int queryWords(UserBean user) {
		return 0;
	}
	public static List<WordBean> queryUserCollect (UserBean user) {
		return null;
	}
	public static void deleteUserCollectItem(UserBean user,WordBean word) {
		
	}
	
	public static void addUserCollectItem(UserBean user,WordBean word) {
		
	}
}

package dao;

import java.util.List;

import model.UserBean;
import model.WordBean;

public class UserDao {
	/**
	 * ��¼��֤���û��ʻ�����ѯ���û��ղشʻ����ɾ��
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

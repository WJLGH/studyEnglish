package dao;

import java.util.List;

import model.UserBean;
import model.WordBean;

public class UserDao {
	/**
	 * ��¼��֤���û��ʻ�����ѯ���û��ղشʻ����ɾ��
	 */
	/**
	 * ��½��֤
	 * nullΪû��
	 * @param name
	 * @param pwd
	 * @return
	 */
	public static UserBean checkLogin(String name,String pwd) {
		return null;
	}
	/**
	 * ��ѯ�ղص��ʱ�
	 * @param user
	 * @return
	 */
	public static void queryUserCollect (UserBean user) {
	}
	/**
	 * ɾ���ղص���
	 * @param user
	 * @param word
	 */
	public static void deleteUserCollectItem(UserBean user,WordBean word) {
		
	}
	/**
	 * ����ղص���
	 * @param user
	 * @param word
	 */
	public static void addUserCollectItem(UserBean user,WordBean word) {
		
	}
}

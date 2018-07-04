package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.CollectDao;
import dao.UserDao;
import dao.WordDao;
import model.CollectBean;
import model.UserBean;
import model.WordBean;

public class ReciteWords {
	private UserBean user;
	private List<WordBean> list;
	private Iterator<WordBean> ite;
	/**
	 * ���캯������һ���û���Ϊ����
	 * @param user
	 */
	public ReciteWords(UserBean user) {
		this.user = user;
		getList();
	}
	/**
	 * ͨ���û���ǰ��¼��page�ֶλ�ȡ�µ�δ������
	 */
	private void getList() {
		list = WordDao.limitQuery(user.getUpage());
		System.out.println("�����ݿ��л�ȡ"+list);
	}
	/**
	 * ����Ҫ���еĵ��ʱ�
	 * @param list
	 */
	public void setList(List<WordBean> list) {
		this.list = list;
	}
	/**
	 * �ж��Ƿ��굱ǰ�б��еĵ���
	 * Ҫ�ǵõ���saveUserPageȥ���浱ǰ���û���Ϣ
	 * @return
	 */
	public boolean isFinish() {
		return null == list || list.size() == 0;
	}

	private int getSize() {
		return list.size();
	}
	/**
	 * �ѵ�ǰ�ĵ�����ӵ��û����ղ���
	 * ������ǵ�ǰ���ʵ�wid
	 * @param wid
	 * @throws SQLException 
	 */
	public void addCollectBean(int wid) throws SQLException {
		CollectBean co = new CollectBean();
		co.setUid(user.getUid());
		co.setWid(wid);
		CollectDao.addCollectBean(co);
	}
	/**
	 * �ѵ�ǰ�����Ƴ��б�
	 * ն������
	 */
	public void removeFromList() {
		ite.remove();
	}
	/**
	 * ��ȡ��һ������
	 * @return
	 */
	public WordBean getNext() {
		if (isFinish()) {
			System.out.println("hh");
			return null;
		}
		if (null == ite || !ite.hasNext()) {
			ite = list.iterator();
		}
		return ite.next();
	}
	/**
	 * �б�����ɺ�Ҫ
	 * �������������ݿ�ĸ���
	 * @throws SQLException 
	 */
	public void saveUserPage() throws SQLException {
		int nPage = user.getUpage() + WordDao.pageSize;
		user.setUpage(nPage);
		UserDao.Logout(user);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ReciteWords rw = new ReciteWords(new UserBean());
		List<WordBean> list = new ArrayList<WordBean>() {
			{
				add(new WordBean(1, "aaa", "hhh", "", 1, null));
				add(new WordBean(1, "bbb", "hhh", "", 1, null));
				add(new WordBean(1, "ccc", "hhh", "", 1, null));
				add(new WordBean(1, "eee", "hhh", "", 1, null));
				add(new WordBean(1, "fff", "hhh", "", 1, null));
			}
		};
		rw.setList(list);
		while (! rw.isFinish()) {
			WordBean word = rw.getNext();
			System.out.println(word);
			int op = in.nextInt();
			switch (op) {
			case 1:
				System.out.println("continue");
				break;

			case 2:

				System.out.println("shanchu");
				rw.removeFromList();
				break;

			default:
				break;
			}
		}
	}
}

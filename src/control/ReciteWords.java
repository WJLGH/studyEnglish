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
	private UserBean user;// 当前登录用户
	private List<WordBean> list; // 当前所背诵的单词列表
	private Iterator<WordBean> ite; // 单词列表的迭代器
	private int cnt; //这是从数据库中所得到单词列表中单词的个数
	/**
	 * 构造函数传入一个用户作为参数
	 * @param user
	 */
	public ReciteWords(UserBean user) {
		this.user = user;
		getList();
		if(list != null) {
			cnt = list.size();
		}
	}
	/**
	 * 查询数据库通过用户当前记录的page字段
	 * 获取新的未背单词
	 */
	private void getList() {
		try {
			list = WordDao.limitQuery(user.getUpage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 设置要背诵的单词表
	 * @param list
	 */
	public void setList(List<WordBean> list) {
		this.list = list;
	}
	/**
	 * 判断是否背完当前列表中的单词
	 * 要记得调用saveUserPage去保存当前的用户信息
	 * @return
	 */
	public boolean isFinish() {
		return null == list || list.size() == 0;
	}
	
	/**
	 * 把当前的单词添加到用户的收藏中
	 * 传入的是当前单词的wid
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
	 * 把当前单词移出列表
	 * 斩掉单词
	 */
	public void removeFromList() {
		ite.remove();
	}
	/**
	 * 获取下一个单词
	 * @return
	 */
	public WordBean getNext() {
		//如果背完了
		if (isFinish()) {
			return null;
		}
		//如果到列表最后则从头循环
		if (null == ite || !ite.hasNext()) {
			ite = list.iterator();
		}
		return ite.next();
	}
	/**
	 * 列表背诵完成后要
	 * 进行数据向数据库的更新
	 * @throws SQLException 
	 */
	public void saveUserPage() throws SQLException {
		int nPage = user.getUpage() + cnt;
		user.setUpage(nPage);
		UserDao.Logout(user);
	}
	public static void main(String[] args) {
		/**
		 * 测试功能
		 */
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

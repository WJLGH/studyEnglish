import java.sql.*;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.CollectDao;
import dao.ManagerDao;
import dao.UserDao;
import dao.VocabularyDao;
import dao.WordDao;
import model.CollectBean;
import model.ManagerBean;
import model.UserBean;
import model.VocabularyBean;
import model.WordBean;
import util.JDBCUtils;
public class test {
	public static void main(String[] args) throws SQLException  {
//		Connection conn = JDBCUtils.getConnection();
//		ManagerBean mb = null;
//		String sql = "select * from manager where mname = ?";
//		QueryRunner qr = new QueryRunner();
//		try {
//			/**
//			 * 1）多条数据匹配，第一条数据
//			 * 2）如果JavaBean中有数据库没有的成员变量，不设置，
//			 * 3)调用无参构造函数，在调用setter
//			 */
//			mb = qr.query(conn, sql, new BeanHandler<ManagerBean>(ManagerBean.class), "1234");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println(mb);
//		JDBCUtils.closeConnection(conn);
		
		/**
		 * 测试的ManagerDao
		 * 测试成功
		 */
//		Date date = new Date();
//		
//		ManagerDao.setPwd(1,"1234");
//		ManagerBean manager = ManagerDao.checkLogin("1234","1234");
//		ManagerDao.saveDate(manager, date);
//		if(manager==null) {
//			System.out.println("没有此用户");
//		}else {
//			System.out.println(manager);
//		}
		/**
		 * 测试VocabularyDao
		 * 测试成功
		 */
//		VocabularyDao.addVocabularyBean(new VocabularyBean(4,"v4"));
//		VocabularyDao.updataVocabularyBeanName(4, "v5");
//		VocabularyDao.deleteVocabularyBean(3);
//		List<VocabularyBean> vBeans;
//		vBeans = VocabularyDao.query();
//		for(VocabularyBean vBean:vBeans) {
//			System.out.println(vBean);
//		}
//		System.out.println(VocabularyDao.vNumber());
	   /**
	    * 测试userDao
	    * 测试成功
	    */
//		UserBean uBean = UserDao.checkLogin("user1", "123456");
//		if(uBean==null) {
//			System.out.println("没有此用户");
//		}else {
//			System.out.println(uBean);
//		}
//		UserDao.Logout(new UserBean(1,"user1","123456",5));
		/**
		 * 
		 */
//		WordBean wordBean = WordDao.zhQueryEn("我的");
//		System.out.println(wordBean.getWord());
		/**
		 * CollectDao测试
		 * 测试成功
		 */

//		CollectDao.addCollectBean(new CollectBean(1,4));
//		CollectDao.deleteCollectBean(1, 4);
//		List<WordBean> list = null;
//		list=CollectDao.queryUserCollect(1);
//		for(WordBean wordBean:list) {
//			if(wordBean!=null)
//			System.out.println(wordBean.getWord());
//		}
		
		
		
	}
}

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
//			 * 1����������ƥ�䣬��һ������
//			 * 2�����JavaBean�������ݿ�û�еĳ�Ա�����������ã�
//			 * 3)�����޲ι��캯�����ڵ���setter
//			 */
//			mb = qr.query(conn, sql, new BeanHandler<ManagerBean>(ManagerBean.class), "1234");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println(mb);
//		JDBCUtils.closeConnection(conn);
		
		/**
		 * ���Ե�ManagerDao
		 * ���Գɹ�
		 */
//		Date date = new Date();
//		
//		ManagerDao.setPwd(1,"1234");
//		ManagerBean manager = ManagerDao.checkLogin("1234","1234");
//		ManagerDao.saveDate(manager, date);
//		if(manager==null) {
//			System.out.println("û�д��û�");
//		}else {
//			System.out.println(manager);
//		}
		/**
		 * ����VocabularyDao
		 * ���Գɹ�
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
	    * ����userDao
	    * ���Գɹ�
	    */
//		UserBean uBean = UserDao.checkLogin("user1", "123456");
//		if(uBean==null) {
//			System.out.println("û�д��û�");
//		}else {
//			System.out.println(uBean);
//		}
//		UserDao.Logout(new UserBean(1,"user1","123456",5));
		/**
		 * 
		 */
//		WordBean wordBean = WordDao.zhQueryEn("�ҵ�");
//		System.out.println(wordBean.getWord());
		/**
		 * CollectDao����
		 * ���Գɹ�
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

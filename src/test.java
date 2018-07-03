import java.sql.*;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.ManagerDao;
import dao.VocabularyDao;
import model.ManagerBean;
import model.VocabularyBean;
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
//		VocabularyDao.deleteVocabularyBean(4);
//		List<VocabularyBean> vBeans;
//		vBeans = VocabularyDao.query();
//		for(VocabularyBean vBean:vBeans) {
//			System.out.println(vBean);
//		}
	   /**
	    * 
	    */
	}
}

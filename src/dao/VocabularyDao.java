package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import model.VocabularyBean;
import util.JDBCUtils;

public class VocabularyDao {
	/**
	 * 添加一个单词表
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public static boolean addVocabularyBean(VocabularyBean v) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "insert into vocabulary(vname,vdesc) values(?,?)";
		return 0 < runner.update(con, sql, v.getVname(),v.getVdesc());
	}
	/**
	 * 删除一个单词表
	 * @param vid
	 * @return
	 * @throws SQLException
	 */
	public static boolean deleteVocabularyBean(int vid) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "delete from vocabulary where vid=?";

		return 0 < runner.update(con, sql, vid);// n为成功删除记录的条数
		// System.out.println(n+"条数据删除成功");
	}
	/**
	 * 修改一个单词表
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public static boolean updataVocabularyBeanName(VocabularyBean v) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "update vocabulary set vname=? ,vdesc = ? where vid=?";
		return 0 < runner.update(con, sql, v.getVname(),v.getVdesc(),v.getVid());
	}
	/**
	 * 查询所有的单词表
	 * @return
	 * @throws SQLException
	 */
	public static List<VocabularyBean> query() throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
        String sql = "select * from vocabulary";
        List<VocabularyBean> vBeans = runner.query(con,sql,new BeanListHandler<VocabularyBean>(VocabularyBean.class));
		return vBeans;
	}

	/**
	 * 查询有几个表********************新增方法
	 * @throws SQLException 
	 */
	public static long vNumber() throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "select count(vid) from vocabulary";
		return runner.query(con,sql, new ScalarHandler<Long>());
	}
	/**
	 * 通过某个单词表的名字获得它的id
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public static Integer queryVid(String name) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection conn = JDBCUtils.getConnection();
		String sql = "select vid from vocabulary where vname = ?";
		return runner.query(conn, sql, new ResultSetHandler<Integer>() {

			@Override
			public Integer handle(ResultSet rs) throws SQLException {
				if(rs ==null) {
					return null;
				}
				rs.next();
				return rs.getInt("vid");
			}
		},name);
	}
	/**
	 * 通过某个单词表的id获得这个单词表
	 * @param vid
	 * @return
	 */
	public static VocabularyBean queryByVid(int vid) {
		QueryRunner qr = new QueryRunner();
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from vocabulary where vid = ?";
		VocabularyBean vb = null;
		try {
			vb = qr.query(conn, sql, new BeanHandler<VocabularyBean>(VocabularyBean.class), vid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vb;
	}
}

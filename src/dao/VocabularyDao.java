package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import model.VocabularyBean;
import util.JDBCUtils;

public class VocabularyDao {
	/**
	 * 词汇表增删改查
	 * 
	 * @throws SQLException
	 */
	public static void addVocabularyBean(VocabularyBean v) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "insert into vocabulary(vname) values(?)";
		runner.update(con, sql, v.getVname());
	}

	public static void deleteVocabularyBean(int vid) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "delete from vocabulary where vid=?";

		int n = runner.update(con, sql, vid);// n为成功删除记录的条数
		// System.out.println(n+"条数据删除成功");
	}

	public static void updataVocabularyBeanName(int vid, String name) throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
		String sql = "update vocabulary set vname=? where vid=?";
		runner.update(con, sql, name, vid);
	}

	public static List<VocabularyBean> query() throws SQLException {
		QueryRunner runner = new QueryRunner();
		Connection con = JDBCUtils.getConnection();
        String sql = "select vid,vname from vocabulary";
        List<VocabularyBean> vBeans = runner.query(con,sql,new BeanListHandler<VocabularyBean>(VocabularyBean.class));
		return vBeans;
	}

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
				return rs.getInt("vid");
					
			}
		},name);
	}
}

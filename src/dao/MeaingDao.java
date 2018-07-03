package dao;

import java.sql.*;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import model.MeaningBean;
import model.WordBean;
import util.JDBCUtils;

public class MeaingDao {
	
	public static void deleteMeanigBean(int cid) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "delete from meaning where cid = ?";
		QueryRunner qr = new QueryRunner();
		qr.update(conn,sql, cid);
	}
	
	public static void addMeaningBean(MeaningBean mb) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "insert into meaning (chinese,wid) values (?,?)";
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, mb.getChinese(),mb.getWid());
		
	}
	
	public static void  queryMeaning(WordBean word) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from meaning where wid = ?";
		QueryRunner qr = new QueryRunner();
		List<MeaningBean> list = null;
		list = qr.query(sql,new BeanListHandler<MeaningBean>( MeaningBean.class),word.getWid());
		word.setMeans(list);
		
	}
}

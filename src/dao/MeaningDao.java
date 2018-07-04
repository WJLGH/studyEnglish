package dao;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import model.MeaningBean;
import model.WordBean;
import util.JDBCUtils;

public class MeaningDao {
	public static void main(String[] args) throws SQLException {
//		List<MeaningBean> list = queryMeaning(null);
//		for (MeaningBean meaningBean : list) {
//			System.out.println(meaningBean);
//		}
		
		deleteMeanigBean(7);
		deleteMeanigBean(8);
		
	}
	
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
	
	public static List<MeaningBean>  queryMeaning(WordBean word) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from meaning where wid = ?";
		QueryRunner qr = new QueryRunner();
		List<MeaningBean> list = null;
		return qr.query(conn,sql,new BeanListHandler<MeaningBean>( MeaningBean.class),word.getWid());
	}
	public static WordBean queryWord(String chinese) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT w.`wid`,w.`word`,w.`eg`,w.`vid`,w.`eg`,w.`trans` FROM meaning AS m, word AS w  WHERE chinese LIKE ? AND m.wid = w.wid ";
		QueryRunner qr = new QueryRunner();
		return qr.query(conn, sql, new BeanHandler<WordBean>(WordBean.class), chinese);
	}
	
}

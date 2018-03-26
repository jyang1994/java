package com.kaishengit.util;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.kaishengit.exception.DataAccessException;

public class DbHelp {

	private static QueryRunner runner = new QueryRunner(ConnectionManager.getDataSource());

	/**
	 * ִ��insert delete update
	 */
	public static void executeUpdate(String sql, Object... params) {
		try {
			System.out.println("SQL:" + sql);
			runner.update(sql, params);
		} catch (SQLException e) {
			throw new DataAccessException("ִ��" + sql + "�쳣", e);
		} 
	}

	public static <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) {
		try {
			System.out.println("SQL:" + sql);
			return runner.query(sql, rsh, params);
		} catch (SQLException e) {
			throw new DataAccessException("ִ��" + sql + "�쳣", e);
		} 
	}
}
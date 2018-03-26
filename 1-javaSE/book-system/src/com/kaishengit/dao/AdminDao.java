package com.kaishengit.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kaishengit.entity.Admin;
import com.kaishengit.util.DbHelp;

public class AdminDao {

	/**
	 * �����û���������admin����
	 * @return
	 * @throws SQLException 
	 */
	public Admin findByName(String name) {
		String sql = "select * from t_admin where name = ?";
		return DbHelp.query(sql, new BeanHandler<Admin>(Admin.class), name);
	}

}

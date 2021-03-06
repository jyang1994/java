package com.kaishengit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.kaishengit.entity.User;
import com.kaishengit.util.RowMapper;

public class UserRowMapper implements RowMapper{

	@Override
	public Object mapperRow(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setAddress(rs.getString(3));
		user.setTel(rs.getString(4));
		return user;
	}

}

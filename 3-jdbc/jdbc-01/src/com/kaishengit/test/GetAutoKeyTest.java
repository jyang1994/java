package com.kaishengit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAutoKeyTest {

	public static void main(String[] args) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/db_25";
		String name = "root";
		String password = "rootroot";
		
		try {
			// 1.�������ݿ�����
			Class.forName(driver);
			
			// 2.��ȡ���ݿ�����
			Connection conn = DriverManager.getConnection(url, name, password);
			
			// 3.ִ��sql
			String sql = "insert into t_user (name, address, tel) values (?, ?, ?)";
			
			PreparedStatement pstat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstat.setString(1, "gedern");
			pstat.setString(2, "houston");
			pstat.setString(3, "117");
			
			pstat.executeUpdate();

			ResultSet rs = pstat.getGeneratedKeys();
			
			if(rs.next()) {
//				int id = rs.getInt("id"); 
				int id = rs.getInt(1);
				System.out.println("id:" + id);
			}
			
			// 4.�ͷ���Դ
			pstat.close();
			conn.close();
			
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}

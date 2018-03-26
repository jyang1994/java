package com.kaishengit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddBatchTest {

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
			String sql = "insert into t_account (name, password) values (?, ?)";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			long startTime = System.currentTimeMillis();
			
			for(int i = 0; i < 1000; i++) {
				pstat.setString(1, "gedern" + i);
				pstat.setString(2, "123123");
				// ��ӵ�������
				pstat.addBatch();
				
				if(i % 100 == 0) {
					// ÿ100��ѭ��ִ��һ��������
					pstat.executeBatch();
					pstat.clearBatch();
				}
				
			}
			pstat.executeBatch();
			
			
			long endTime = System.currentTimeMillis();
			System.out.println("�����ģ�" + (endTime - startTime) + "ms");
			
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

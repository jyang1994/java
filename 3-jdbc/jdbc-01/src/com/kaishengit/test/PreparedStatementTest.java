package com.kaishengit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("�������û���:");
			String name = input.nextLine();
			
			System.out.println("����������:");
			String password = input.next();
			
			Connection conn = DriverManager.getConnection("jdbc:mysql:///db_25","root","rootroot");

//			String sql = "select * from t_account where name = '" + name + "' and password = '" + password + "'";
			String sql = "select * from t_account where name = ? and password = ?";// ռλ��
			
//			Statement stat = conn.createStatement();
			PreparedStatement pstat = conn.prepareStatement(sql); // Ԥ����
			pstat.setString(1, name);
			pstat.setString(2, password);
			
			System.out.println("sql:" + sql);
//			ResultSet rs = stat.executeQuery(sql);
			ResultSet rs = pstat.executeQuery();
			
			
			if(rs.next()) {
				System.out.println("��¼�ɹ�");
			} else {
				System.out.println("��¼ʧ��");
			}
			
			rs.close();
			pstat.close();
			conn.close();
			input.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

}

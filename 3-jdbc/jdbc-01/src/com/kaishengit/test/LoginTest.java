package com.kaishengit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql:///db_25","root","rootroot");
			Statement stat = conn.createStatement();
			
			
			System.out.println("�������û���:");
			String name = input.nextLine();
			
			System.out.println("����������:");
			String password = input.next();
			
			
			String sql = "select * from t_account where name = '" + name + "' and password = '" + password + "'";
			System.out.println("sql:" + sql);
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("��¼�ɹ�");
			} else {
				System.out.println("��¼ʧ��");
			}
			
			rs.close();
			stat.close();
			conn.close();
			input.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}

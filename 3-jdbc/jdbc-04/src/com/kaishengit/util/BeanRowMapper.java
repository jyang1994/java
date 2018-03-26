package com.kaishengit.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BeanRowMapper<T> implements RowMapper<T> {

	private Class<T> clazz;

	public BeanRowMapper(Class<T> clazz) { // = Account.class
		this.clazz = clazz;
	}

	@Override
	public T mapperRow(ResultSet rs) throws SQLException {
		try {
			T obj = clazz.newInstance();

			ResultSetMetaData rsmd = rs.getMetaData();

			// ��ý�����е�����
			int columnCount = rsmd.getColumnCount();

			for (int i = 1; i <= columnCount; i++) {
				// ��ñ�Ŷ�Ӧ������
				String columnLabel = rsmd.getColumnLabel(i);
				// �ӽ�����л��������Ӧ��ֵ
				Object res = rs.getObject(columnLabel);
				// ����������ö�Ӧ�ķ�����
				String methodName = "set" + columnLabel.substring(0, 1).toUpperCase() + columnLabel.substring(1);

				Method[] methods = clazz.getMethods();
				for (Method method : methods) {
					if (methodName.equalsIgnoreCase(method.getName())) {
						method.invoke(obj, res);// setName(name)
						break;
					}
				}

			}
			
			return obj;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

		return null;
	}

}

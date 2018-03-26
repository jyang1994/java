package com.kaishengit.util;

public class StringUtil {

	/**
	 * �жϲ����ַ����Ƿ�Ϊ������
	 * @param str ��Ҫ�жϵ��ַ���
	 * @return ture:������  false:�Ǵ�����
	 */
	public static boolean isNumber(String str) {
		
		String regex = "\\d+";
		
		// �пմ���
		if(isEmpty(str)){
			return false;
		}
		
		return str.matches(regex);
		
		
		/*char[] chars = str.toCharArray();
		
		for(int i = 0; i< chars.length; i++) {
			char ch = chars[i];
			if(!Character.isDigit(ch)) {
				return false;
			}
		}
		
		return true;*/
		
		/*// �пմ���
		if(str == null || str.isEmpty()){
			return false;
		}
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);// ��ö�Ӧ�������ַ�
//			if(!(ch >= 48 && ch <=57)) {
//			if(ch < 48 || ch > 57) {
			if(ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;*/
		
	}
	
	
	
	/**
	 * �жϲ����ַ�����ʽ�Ƿ�Ϊemail
	 * @param str Ҫ�����жϵ��ַ���
	 * @return true:email��ʽ��ȷ  false��email��ʽ����
	 */
	public static boolean isEmail(String str) {
		// 4567892@qq.com
		// jimi_jin123@163.com
		// zhangsan@ligong.edu.cn
		
		if(isEmpty(str)) {
			return false;
		}
		
//		String regex = "\\w+@\\w+(.\\w+){1,2}";// .com   .com.cn
		return str.matches("\\w+@\\w+(\\.\\w+){1,2}");
		
		
		/*
		// �ж�@ .��λ��
		int atIndex = str.indexOf("@");
		int dotIndex = str.indexOf(".");
		
		// ���str�в�����@����. return false
		if(atIndex == -1 || dotIndex == -1) {
			return false;
		}
		
		// ���@�ǵ�һλ�������һλ������false
		if(atIndex == 0 || atIndex == str.length() -1) {
			return false;
		}
		//	���.�ǵ�һλ�������һλ������false
		if(dotIndex == 0 || dotIndex == str.length() -1) {
			return false;
		}
		
		// .��@֮ǰ ����false
		if(dotIndex - atIndex < 2) {
			return false;
		} 
		
		// �жϲ���������@���ж�indexOf()��lastindexOf()�Ƿ���ȣ������֤������������@����
		int lastAtIndex = str.lastIndexOf("@");
		if(atIndex != lastAtIndex) {
			return false;
		}
		
		// .ֻ����һ���������������ܸ���
		String[] strs = str.split("\\.");//����������ʽ��.�������ַ���������ȥ��
		if(strs.length > 3) {
			return false;
		}

		// ���������.����ô������.��������
		int lastDotIndex = str.lastIndexOf(".");
		if(lastDotIndex - dotIndex == 1) {
			return false;
		}
		
		return true;*/
	}
	
	/**
	 * �ж��ַ����Ƿ�Ϊnull���߿��ַ���
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}
	
	
	/**
	 * �ж��ַ����Ƿ�Ϊnull�Ϳ��ַ���
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
//		return str != null && !str.isEmpty();
		return !isEmpty(str);
	}
	
	/**
	 * �������֤����û��ĳ������
	 * @param idCard ���֤
	 * @return �������
	 */
	public static String getBornYear(String idCard) {
		String year = idCard.substring(6, 10);
		return year;
	}
	
	
	/**
	 * �������֤�������û����Ա�
	 * @param idCard
	 * @return �Ա�
	 */
	public static String getSex(String idCard) {
		String sex = idCard.substring(idCard.length() - 2, idCard.length() - 1);
		int sexNum = Integer.parseInt(sex);
		if(sexNum % 2 == 0) {
			return "woman";
		} else {
			return "man";
		}
	}
	
}

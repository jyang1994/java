package com.kaishengit.test;

import com.kaishengit.exception.NameEmptyException;
import com.kaishengit.exception.TelEMptyException;

public class Test {

	public static void main(String[] args) {
		PhoneNumber number = new PhoneNumber();
		try{
			number.findByTel("");
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch(NameEmptyException ex) {
			ex.printStackTrace();
		} catch(TelEMptyException e) {
			e.printStackTrace();
		}
		
		System.out.println("the end!");
		
//		Integer in = new Integer("abc");
		
		/*File f = new File("d:/1.txt");
		FileInputStream inputStream = new FileInputStream(f);*/
		
		
//		int a = 10 / 1;
		
		
		/*String name = "aa";
		try{
			name.equals("tom");
			
			int[] nums = new int[5];
			System.out.println(nums[4]);
			
			Integer in = new Integer("abc");
			
			
		} catch(ArrayIndexOutOfBoundsException ex1) {
			System.out.println("�±�Խ����..");
			ex1.printStackTrace();
		} catch(NullPointerException ex) {
			System.out.println("��ָ����");
		} finally {
			System.out.println("finally block");
		} 
		
		
		catch(RuntimeException ex2) {
			System.out.println("����ʱ�쳣");
		} catch(Exception ex3) {
			System.out.println("���쳣��");
		}
		// ���쳣�ŵ����棬С�쳣�ŵ�ǰ�棬�ֵ��쳣˳�����
		
		System.out.println("the end!");*/
		
		
	}
	
}

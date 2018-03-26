package com.kaishengit.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneNumber2 {

	Scanner input = new Scanner(System.in);
	
	Map<String, String> maps = new HashMap<>(); 
	
	public void startup() {
		
		System.out.println("��ӭʹ�õ绰���뱾��");
		System.out.println("1. ���");
		System.out.println("2. ��ѯ");
		System.out.println("3. ɾ��");
		System.out.println("4. �˳�");
		System.out.println("��ѡ��");

		int index = input.nextInt();
		if(1 == index) {
			save();
		} else if(2 == index) {
			find();
		} else if(3 == index) {
			remove();
		} else if(4 == index) {
			System.exit(0);
		} else {
			System.out.println("�����������������");
		} 
		startup();
		
	}

	/**
	 * ���ݵ绰����ɾ����Ӧ����ϵ��
	 */
	private void remove() {
		System.out.println("������绰");
		String phoneNo = input.next();
		
		String name = maps.get(phoneNo);
		
		if(name == null) {
			System.out.println("����ϵ�˲�����");
		} else {
			maps.remove(phoneNo);
			System.out.println("ɾ���ɹ�!");
		}
	}

	/**
	 * ���ң����ݵ绰���������ϵ��������
	 */
	private void find() {
	
		System.out.println("������绰");
		String phoneNo = input.next();
		
		String name = maps.get(phoneNo);
		
		if(name == null) {
			System.out.println("���޴���");
		} else {
			System.out.println("����ϵ��Ϊ��" + name);
		}
		
	}

	/**
	 * ����绰����
	 */
	private void save() {
		System.out.println("������绰���룺");
		String phoneNo = input.next();
		
		if(maps.containsKey(phoneNo)) {
			System.out.println("�õ绰�����Ѵ��ڣ�����������");
		} else {
			System.out.println("��������ϵ��������");
			String name = input.next();
			
			maps.put(phoneNo, name);
			System.out.println("����ɹ���");
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.kaishengit.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class PhoneNumber {

	Scanner input = new Scanner(System.in);
	
	Map<String, String> maps = new HashMap<>(); 
	
	public void startup() {
		
		System.out.println("��ӭʹ�õ绰���뱾��");
		System.out.println("1. ���");
		System.out.println("2. ͨ���绰��ѯ��ϵ��");
		System.out.println("3. ͨ����������ѯ�绰");
		System.out.println("4. ͨ���绰ɾ����ϵ��");
		System.out.println("5. ͨ������ɾ����ϵ��");
		System.out.println("6. �˳�");
		System.out.println("��ѡ��");

		int index = input.nextInt();
		if(1 == index) {
			save();
		} else if(2 == index) {
			findByTel();
		} else if(3 == index) {
			findByName();
		} else if(4 == index) {
			removeByTel();
		} else if(5 == index) {
			removeByName();
		} else if(6 == index) {
			System.exit(0);
		} else {
			System.out.println("�����������������");
		} 
		startup();
		
	}

	/**
	 * ��������ɾ����ϵ��
	 */
	private void removeByName() {
		System.out.println("��������ϵ��������");
		String name = input.next();
		
		List<String> telList = new ArrayList<>();
		
		Set<Entry<String,String>> entrys =  maps.entrySet();
		
		for(Entry<String,String> entry : entrys) {
			if(name.equals(entry.getValue())) {
				telList.add(entry.getKey());
			}
		}
		
		if(telList.size() > 0) {
			for(String tel : telList) {
				maps.remove(tel);
			}
			System.out.println("ɾ���ɹ�!");
		} else {
			System.out.println("���޴���");
		}
		
	}

	/**
	 * ͨ����������
	 */
	private void findByName() {
		
		System.out.println("��������ϵ��������");
		String name = input.next();
		
		List<String> telList = new ArrayList<>();
		
		Set<Entry<String,String>> entrys =  maps.entrySet();
		
		for(Entry<String,String> entry : entrys) {
			if(name.equals(entry.getValue())) {
				telList.add(entry.getKey());
			}
		}
		
		if(telList.size() > 0) {
			for(String tel : telList) {
				System.out.println(name + "�ĵ绰����Ϊ��" + tel);
			}
		} else {
			System.out.println("���޴���");
		}
		
	}

	/**
	 * ���ݵ绰����ɾ����Ӧ����ϵ��
	 */
	private void removeByTel() {
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
	private void findByTel() {
	
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

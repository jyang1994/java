package com.kaishengit.entity;

public class Student {

	private String name;

	public static int age;// ���徲̬����

	static {
		//��̬�����
		System.out.println("��̬�����ִ��...");
		age = 20;
		sayHello();
	}
	
	public static void sayHello() {
		System.out.println("student hello...");
		// sayHi();
		age = 40;
	}

	public void sayHi() {
		System.out.println("hi...");
		sayHello();
		System.out.println(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

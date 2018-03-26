package com.kaishengit.entity;

public class Student {

	private String name;
	private int age;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}


	
	
	
	@Override
	public boolean equals(Object obj) {
		// ��������ڴ��ַ��ͬ
		if(this == obj) {
			return true;
		}
		
		// �������Ϊnull��return false
		if(obj == null) {
			return false;
		}
		
		// �ж�obj�ǲ���Student��Ķ���������Ƿ���false
		if(!(obj instanceof Student)) {
			return false;
		}
		
		// �жϵ�ǰ�����obj�������Ƿ����
		Student otherStu = (Student)obj;
		if(this.age != otherStu.getAge()) {
			return false;
		} 
		
		if(this.name == null) {
			if(otherStu.getName() != null) {
				return false;
			}
		} else {
			if(!this.name.equals(otherStu.getName())) {
				return false;
			}
		}
		
		
		return true;
	}
}

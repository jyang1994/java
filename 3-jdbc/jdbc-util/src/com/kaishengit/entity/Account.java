package com.kaishengit.entity;

public class Account {

	private int id;
	private String name;
	private String password;
	private int money;
	private boolean enable;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void sayHello() {
		System.out.println("hello,account");
	}

	public void sayHello(String name) {
		System.out.println("hello," + name);
	}

	public void sayHello(String name, int age) {
		System.out.println("hello," + name);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}

package com.kaishengit.test;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

	private int money = 10000;
	
	// ͬ����
//	private ReentrantLock reentrantLock = new ReentrantLock();
	
	public void pickMoney(String name ,int money) {
//		reentrantLock.lock();
		try{
			if(money < this.money) {
				
				this.money = this.money - money;
				System.out.println(name + "ȡ��ɹ������Ϊ��" + this.money );
			} else {
				System.out.println("����");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
//			reentrantLock.unlock();
		}
			
	}
	
	
}

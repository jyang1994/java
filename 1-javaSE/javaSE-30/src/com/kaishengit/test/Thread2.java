package com.kaishengit.test;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		//�߳�����ʱ��������
		for(int i = 0; i < 100; i++) {
			System.out.println("thread2:" + i);
		}
	}

}

package com.kaishengit.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamTest {

	public static void main(String[] args) {
		
		try {
			//�����ֽ������������ʵ��
			FileInputStream inputStream = new FileInputStream("d:/img/1.jpg");
			FileOutputStream outputStream = new FileOutputStream("d:/img/2.jpg");
			
			int len = -1;
			// ÿ�δ�FileInputStream����һ���ֽڵ�FileOutputStream
			while((len = inputStream.read()) != -1 ) {
				outputStream.write(len);
			}
			
			// �ر����������
			inputStream.close();
			outputStream.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

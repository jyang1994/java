package com.kaishengit.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamTest2 {

	public static void main(String[] args) {
		
		try {
			//�����ֽ������������ʵ��
			FileInputStream inputStream = new FileInputStream("d:/img/1.jpg");
			FileOutputStream outputStream = new FileOutputStream("d:/img/2.jpg");
			
			int len = -1;
			byte[] buffer = new byte[1024];
			// ÿ�δ�FileInputStream����һ���ֽڵ�FileOutputStream
			while((len = inputStream.read(buffer)) != -1 ) {
				outputStream.write(buffer,0,len);
			}
			
			// �ر����������
			
			outputStream.flush();
			outputStream.close();
			
			inputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

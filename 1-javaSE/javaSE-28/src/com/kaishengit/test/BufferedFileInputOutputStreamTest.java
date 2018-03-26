package com.kaishengit.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedFileInputOutputStreamTest {

	public static void main(String[] args) {
		
		try {
			//�����ֽ������������ʵ��
			FileInputStream inputStream = new FileInputStream("d:/img/1.jpg");
			FileOutputStream outputStream = new FileOutputStream("d:/img/2.jpg");
			
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
			
			int len = -1;
			while((len = bufferedInputStream.read()) != -1) {
				bufferedOutputStream.write(len);
			}
			
			// �ر����������
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			
			bufferedInputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

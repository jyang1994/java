package com.kaishengit.test;

import com.kaishengit.util.FileUtil;

public class Test {

	public static void main(String[] args) {
		
		int totalSpace = FileUtil.getFilesTotalSpace("d:/img");
		System.out.println("total:" + FileUtil.getReadSpace(totalSpace));
		System.out.println("end");
//		File file = new File("d:/jars");
		
		/*boolean res = file.mkdirs();
		System.out.println(res);*/
		
		/*File[] files = file.listFiles();
		
		for(File f : files) {
			if(f.isFile()){
				System.out.println(f.getName());
			} else {
				System.out.println("["+f.getName()+"]");
			}
		}*/
		
		
		/*String[] names = file.list();
		for(String name : names) {
			File subFile = new File(file, name); 
			if(subFile.isFile()) {
				System.out.println(name);
			} else {
				System.out.println("["+name+"]");
			}
		
		}*/
		
		
//		File file = new File("d:/img/1.txt");
//		
//		System.out.println(file.length()); // �ļ���С
		
		// ��ҵ�����ֽ���ת��������ɶ��Ĵ�С 23MB  145GB
//		System.out.println(file.getFreeSpace()); // ���ô�С
//		System.out.println(file.getTotalSpace()); // �ܴ�С
		
//		System.out.println(file.isFile());
//		System.out.println(file.isDirectory());
//		System.out.println(file.isHidden());
		
		
		
		
		
		// ������ɾ��
		/*if(file.exists()) {
			file.delete();
		}
		
		try {
			boolean res = file.createNewFile();
			System.out.println(res);
		} catch(IOException e) {
			e.printStackTrace();
		}*/
		
//		System.out.println(file.getName()); // �ļ���
//		System.out.println(file.getAbsolutePath()); // �ļ�ȫ·��
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		boolean res = file.delete();
//		System.out.println("res:" + res);
		
		
		
//		File file= new File("d:/jars/abcd.mp3");
//		File file = new File("d:/jars","abc.mp3");
		
//		File file = new File("d:/jars");
//		File subFile = new File(file, "abc.mp3");
		
//		System.out.println(file.canRead());
//		System.out.println(file.canWrite());
//		System.out.println(file.canExecute());
		
		
		
		
		
		
		
		
		//win
//		String path = "D:\\wopit";
//		System.out.println(path);
		// linux and win
//		String path = "d:/topit";
//		System.out.println(path);
	}

}

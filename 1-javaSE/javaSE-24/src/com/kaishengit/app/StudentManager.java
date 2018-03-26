package com.kaishengit.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kaishengit.entity.Student;

/**
 * 
 * ѧ������ϵͳ
 * 
 * @author jimi
 *
 */
public class StudentManager {

	Scanner input = new Scanner(System.in);
	List<Student> stuList = new ArrayList<>();

	public void startup() {

		System.out.println("��ӭ����ѧ������ϵͳ��");
		System.out.println("1. ¼��ѧԱ��Ϣ");
		System.out.println("2. ��ѯѧԱ��Ϣ");
		System.out.println("3. �޸�ѧԱ��Ϣ");
		System.out.println("4. ɾ��ѧԱ��Ϣ");
		System.out.println("5. ͳ��ѧԱƽ���ɼ�");
		System.out.println("6. �˳�");
		System.out.println("��ѡ��");

		int index = input.nextInt();

		if (1 == index) {
			save();
		} else if (2 == index) {
			find();
		} else if (3 == index) {
			modify();
		} else if (4 == index) {
			remove();
		} else if (5 == index) {
			avg();
		} else if (6 == index) {
			System.exit(0);
		} else {
			System.out.println("ѡ���������������");
		}
		startup();

	}

	/**
	 * ͳ��ѧԱƽ���ɼ�
	 */
	private void avg() {
		// 1.ͳ���ܳɼ�
		int total = 0;
		for(Student stu : stuList) {
			total += stu.getScore();
		}
		
		if(stuList.size() > 0) {
			// 2.ƽ���ɼ� = �ܳɼ� / ����
			double avg = (double)total / stuList.size();
			// 3.���ƽ���ɼ�
			System.out.println("ѧԱƽ���ɼ�Ϊ��" + avg);
		} else {
			System.out.println("ѧԱƽ���ɼ�Ϊ��0");
		}
		
	}

	/**
	 * ɾ��ѧԱ��Ϣ
	 */
	private void remove() {
		// 1. �û�����ѧԱѧ��
		System.out.println("������ѧԱѧ�ţ�");
		String code = input.next();

		// 2.����ѧ�Ų�ѯѧԱ
		Student stu = findByCode(code);

		if (stu == null) {
			// 4.���ѧԱ�����ڣ���ʾ������
			System.out.println("���޴���");
		} else {
			stuList.remove(stu);
			System.out.println("ɾ���ɹ�!");
		}

	}

	/**
	 * �޸�ѧԱ��Ϣ
	 */
	private void modify() {

		// 1. �û�����ѧԱѧ��
		System.out.println("������ѧԱѧ�ţ�");
		String code = input.next();

		// 2.����ѧ�Ų�ѯѧԱ
		Student stu = findByCode(code);

		if (stu == null) {
			// 4.���ѧԱ�����ڣ���ʾ������
			System.out.println("���޴���");
		} else {
			boolean flag = false;

			// 3.���ѧԱ���ڣ���ʾ�û�ѡ���Ƿ��޸Ķ�Ӧ��Ϣ
			System.out.println("�Ƿ�Ҫ�޸�ѧԱ����(Y|N)?");
			String answer = input.next();
			if ("Y".equalsIgnoreCase(answer)) {
				System.out.println("������ѧԱ������");
				String name = input.next();
				stu.setName(name);
				flag = true;
			}

			System.out.println("�Ƿ�Ҫ�޸�ѧԱ����(Y|N)?");
			answer = input.next();
			if ("Y".equalsIgnoreCase(answer)) {
				System.out.println("������ѧԱ���䣺");
				int age = input.nextInt();
				stu.setAge(age);
				flag = true;
			}

			System.out.println("�Ƿ�Ҫ�޸�ѧԱ�ɼ�(Y|N)?");
			answer = input.next();
			if ("Y".equalsIgnoreCase(answer)) {
				System.out.println("������ѧԱ�ɼ���");
				int score = input.nextInt();
				stu.setScore(score);
				flag = true;
			}

			if (flag) {
				System.out.println("�޸ĳɹ�!");
			}

		}

	}

	/**
	 * ��ѯѧԱ��Ϣ
	 */
	private void find() {
		// 1. �û�����ѧԱѧ��
		System.out.println("������ѧԱѧ�ţ�");
		String code = input.next();

		// 2.����ѧ�Ų�ѯѧԱ
		Student stu = findByCode(code);
		// 3.�жϲ���ʾ
		if (stu == null) {
			System.out.println("���޴���");
		} else {
			System.out.println(stu);
		}
	}

	/**
	 * ¼��ѧԱ��Ϣ
	 */
	private void save() {
		// 1.�û�����ѧԱ��Ϣ

		System.out.println("������ѧԱѧ�ţ�");
		String code = input.next(); // �����в��ܰ����ո� tom hanks

		// 1.5У��ѧ���Ƿ���ڣ���������������
		Student stu = findByCode(code);

		if (stu == null) {
			System.out.println("������ѧԱ������");
			String name = input.next();

			System.out.println("������ѧԱ���䣺");
			int age = input.nextInt();

			System.out.println("������ѧԱ�ɼ���");
			int score = input.nextInt();

			// 2.��װStudent����
			stu = new Student(code, name, age, score);

			// 3.��ӵ�List����
			stuList.add(stu);
		} else {
			System.out.println("��ѧ���Ѵ���,����������");
			save();
		}

	}

	/**
	 * ����ѧ�Ų�ѯ��Ӧ��ѧԱ
	 * 
	 * @param code
	 *            ѧ��
	 * @return ѧ�Ŷ�Ӧ��student���������������Ϊnull
	 */
	private Student findByCode(String code) {
		for (int i = 0; i < stuList.size(); i++) {
			Student stu = stuList.get(i);
			if (stu != null && code.equals(stu.getCode())) {
				return stu;
			}
		}

		return null;
	}

}

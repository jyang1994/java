
public class Hello {
	
	public static void main(String[] args) {
		
		int score = 66;
		
		if(score > 90) {
			System.out.println("A");
		} else if(score >= 80 && score < 90) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}
		
		
		
		
		/*
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("������ֵ��");
		int level = input.nextInt();
		*/
		
		/*
		*	�������ֱ�����int��char��String����
		*   ֻ������ֵ�жϣ�ֵ���ֲ����ظ�
		*/
		/*
		switch(level) {
			case 1:
				System.out.println("�ʼǱ�����-1");
				System.out.println("�ʼǱ�����-2");
				break;
			case 2:
				System.out.println("�ֻ�");
				break;
			case 3:
				System.out.println("Head first Java");
				break;
			default:
				System.out.println("������");
		}
		*/
		
		//����ѡ��
		/*if(level == 1) {
			System.out.println("�ʼǱ�����");
		} else if(level == 2) {
			System.out.println("�ֻ�");
		} else if(level == 3) {
			System.out.println("Head first Java");
		} else {
			System.out.println("������");
		}*/
		
		
		
		/*
		if(level == 1) {
			System.out.println("�ʼǱ�����");
		} else {
			if(level == 2) {
				System.out.println("�ֻ�");
			} else {
				if(level == 3) {
					System.out.println("Head first Java");
				} else {
					System.out.println("������");
				}
			}
		}
		*/
		
		
		
		
		
		
		//int a = 10;
		//int b = 20;
		//��Ԫ���ʽ
		//int c = a > b ? a : b;
		
		/*
		if(a > b) {
			c = a;
		} else {
			c = b;
		}*/
		
		//System.out.println(c);
		
		
		
		
		
		
		
		
		
		
		
		/*
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("�������˺ţ�");
		String name = input.next();
		
		System.out.println("���������룺");
		String password = input.next();
		
		if("tom".equals(name) && "123123".equals(password)) {
			System.out.println("��¼�ɹ�");
		} else {
			System.out.println("�˺Ż��������");
		}
		*/
		
		
		
		
		/*
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("����������������");
		String name = input.next();
		
		if("Tom".equals(name)) {
			System.out.println("Welcome Tom");
		}
		*/
		
		//if(name.equals("Tom")) {
		//	System.out.println("Welcome Tom");
		//}
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		//1. ��ȡ�û������ѽ��
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("���������ѽ�");
		int money = input.nextInt();
		
		//2. �жϽ���Ƿ�����-20������ > 100
		if(money > 100) {
			//money -= 20; // money = money - 20;
			int temp = money / 100;
			money = money - temp * 20;
		}
		
		//3. ����û�Ӧ��֧���Ľ��
		System.out.println("��Ӧ֧����" + money + "Ԫ");
		*/
		
		
		
		//boolean result = 1 != 1;
		//System.out.println(result);
		
		/*
		if(false) {
			System.out.println("if����������� - 1");
			System.out.println("if����������� - 2");
			System.out.println("if����������� - 3");
		}
		
		System.out.println("The end!");
		*/
		
	} 
	
}
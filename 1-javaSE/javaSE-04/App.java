public class App {
	
	public static void main(String[] args) {
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int errorCount = 0; //�������
		String lastErrorName = ""; //���һ�δ�����˺�
		//��������û�����������������3�Σ���ʾ���˺Ŷ���
		while(errorCount < 3) {
			System.out.println("�������˺ţ�");
			String userName = input.next();
			
			System.out.println("���������룺");
			String password = input.next();
			
			if("tom".equals(userName) && "123123".equals(password)) {
				System.out.println("��¼�ɹ�");
				errorCount = 3;
			} else {
				if(!userName.equals(lastErrorName)) {
					errorCount = 0;
					lastErrorName = userName;
				}
				errorCount++;
				if(errorCount == 3) {
					System.out.println("�˺ű�����");
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		/*
		int i = 0;
		while(i < 10) {
			System.out.println(i);
			i++;
		}*/
		
		/*
		for(int i = 0;i < 10;i++) {
			System.out.println(i);
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		String name;
		do {
			System.out.println("����������:");
			name = input.next();
			
			if(!"quit".equals(name)) {
				System.out.println("����������:" + name);
			}
		}while(!"quit".equals(name));
		
		*/
		
		
		
		
		
		
		/*
		//��ִ�У����ж�
		int count = 10;
		
		do{
			System.out.println("hello," + count);
			count--;
		}while(count > 0);
		*/
		
		
		
		
		
		/*
		//1. ��ȡ�༶������
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("������༶��������");
		int count = input.nextInt(); //������
		
		//2. ����ÿ��ͬѧ�ĳɼ������ɼ��ۼӻ���ܳɼ�
		int total = 0; //�ܳɼ�
		int c = 0;
		
		int i = 1;
		while(i <= count) {
			
			System.out.println("�������" + i +"��ͬѧ�ĳɼ���");
			int score = input.nextInt();
			
			if(score >= 80) {
				c++;
				total += score;//total = total + score;
			}
			
			
			i++;
		}
		
		//3. ʹ���ܳɼ����԰༶����������ȡƽ���ɼ�
		int avg = total / c;
		//4. ���ƽ���ɼ�
		System.out.println("�ܳɼ�Ϊ��" + total + " ƽ���ɼ�Ϊ��" + avg);
		*/
		
		
		
		
		
		
		
		
		
		
		
		/*
		int count = 10;
		while(count > 20) {
			System.out.println("xxx");
			count++;
		}
		*/
		//.....
		
		
		/*
		int count = 1;
		while(count <= 100) {
			System.out.println(count + "ֻ����" + count + "���죬" + (count * 2) +"ֻ�۾�" + (count * 4) +"����");
			count++;
		}
		*/
		
		
		/*
		int count = 0; //��ʼ��
		while(count < 3) { //�����жϲ���
			System.out.println("Hello"); 
			count++; //���ı���
		}
		*/
		
		
	}
	
}
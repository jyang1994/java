public class App {
	
	public static void main(String[] args) {
		//0. ����������
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		//1. ��Ҫ��������
		System.out.println("�������һ�����֣�");
		int a = input.nextInt();
		System.out.println("������ڶ�������:");
		int b = input.nextInt();
		
		//2. ����
		// a 1 b 5
		a = a + b;
		b = a - b;
		a = a - b;
		//int c = a;
		//a = b;
		//b = c;
		
		//3. ������
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
	}
	
}
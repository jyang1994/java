public class App2 {
	
	public static void main(String[] args) {
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		String lastErrorName = "";
		int errorCount = 0;
		
		while(true) {
			System.out.println("�������˺ţ�");
			String userName = input.next();
			
			System.out.println("���������룺");
			String password = input.next();
			
			if("tom".equals(userName) && "123123".equals(password)) {
				System.out.println("��¼�ɹ�");
				break;
			} else {
				//�����ǰ�û������ϴδ����һ�£��������+1
				if(!lastErrorName.equals(userName)) {
					//�����ǰ�û������ϴδ���Ĳ�һ�£���¼��ǰ��������֣����������������
					errorCount = 0;
					lastErrorName = userName;
				}
				errorCount++;
				if(errorCount == 3) {
					System.out.println("�˺Ŷ���");
					break;
				}
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		int i = 10;
		while(i > 0) {
			i--;
			if(i == 5) {
				//break;
				continue;
			}
			System.out.println(i);
			
		}
		
		System.out.println("The end!");
		*/
	}
	
	
}
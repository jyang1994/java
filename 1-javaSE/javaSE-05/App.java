public class App {
	
	public static void main(String[] args) {
		
		
		java.util.Random rd = new java.util.Random();
		
		//System.out.println(rd.nextInt(100)); // 0(����) - 100 ����������
		
		String[] names = {"tom","jerry","alex","rose","moon"};
		int index = rd.nextInt(names.length);
		
		System.out.println(names[index]);
		
		
		
		
		
		
		
		
		//�����㷨��ð������
		/*
		int[] nums = {45,23,678,1234,34,67,986};
		
		for(int i = 0;i < nums.length-1;i++) {
			
			for(int j = 0;j < nums.length-i-1;j++) {
				if(nums[j] < nums[j+1]) {
					int c = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = c;
				}
			}
			
			
		}
		
		for(int n : nums) {
			System.out.println(n);
		}
		*/
		
		
		
		/*
		String[] names = {"A","B","C","D"};
		
		for(String name : names) {
			System.out.println(name);
		}
		
		for(int i = 0;i < names.length;i++) {
			if(i % 2 == 0) {
				String name = names[i];
				System.out.println(name);
			}
		}
		
		*/
		
		
		//int[] nums = {45,23,678,1234,34,67,986};
		
		//����
		//JDK5.0 <= foreach 
		//for(int n : nums) {
		//	System.out.println(n);
		//}
		
		
		
		//for(int i = 0;i < nums.length;i++) {
		//	int n = nums[i];
		//	System.out.println(n);
		//}
		
		
		//int[] nums = {45,23,678,1234,34,67,986};
		//int max = nums[0];
		
		//for(int i = 1;i < nums.length;i++) {
			/*if(max < nums[i]) {
				max = nums[i];
			}*/
		//	max = max < nums[i] ? nums[i] : max;
		//}
		
		//System.out.println("���ֵΪ:" + max);
		
		
		
		
		
		
		
		
		/*
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int[] nums = new int[12];
		
		//System.out.println(nums.length);
		// nums.length
		
		
		for(int i = 0;i < nums.length;i++) {
			System.out.println("�������" + i + "����");
			nums[i] = input.nextInt();
		}
		
		//������������
		for(int i = 0;i < nums.length;i++) {
			System.out.println(nums[i]);
		}
		*/
		
		
		
		
		
		
		//String[] names = new String[5];
		//names[5] = "zzz";
		
		
		
		
		
		
		
		
		
		
		
		/*
		String[] names = new String[5];
		System.out.println(names[3]);
		
		//if(names[3] != null && names[3].equals("abc")) {
		if("abc".equals(names[3])) {
			
			System.out.println("hello��Array");
		}
		*/
		
		
		//int[] nums = new int[3];
		
		//System.out.println(nums[2]);
		
		
		
		//1. ����ĳ�����5
		//2. �ֱ��ÿ���±긳ֵ
		//String[] names = new String[]{"A","X","V","U","Q"};
		
		
		
		//1. ����ĳ�����5
		//2. �ֱ��ÿ���±긳ֵ
		//String[] names = {"A","X","V","U","Q"};
		//names[3] = "T";
		
		
		
		
		
		
		//�������� ������ = ֵ;
		//int[] nums = new int[10];
		//String[] names = new String[5]; //����һ������
		//names[1] = "Jack"; //�������±긳ֵ
		
		//System.out.println(names[1]); //��ȡ�����±��Ӧ��ֵ
		
		
		
		//int nums[] = new int[10]; ���Ƽ�
		
		
	}
	
}
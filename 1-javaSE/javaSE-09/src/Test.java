
public class Test {

	public static void main(String[] args) {
		
		CellPhoneAppV3 app = new CellPhoneAppV3();
		app.startup();
		
		/*CellPhoneAppV2 app = new CellPhoneAppV2();
		app.startup();*/
		
		/*CellPhoneAppV1 app = new CellPhoneAppV1();
		String phoneNo = app.getPhpneNo("jack1");
		System.out.println("����ϵ�˵ĵ绰����Ϊ:" + phoneNo);*/
		
		/*PC pc = new PC();
		pc.playMusic("������");
		pc.chat("С��");*/
		
		/*MyMath math = new MyMath();
		int[] numbers = {23,543,12,344,6744,235,1223,87};
		int max = math.getMax(numbers);
		
		System.out.println(max);*/
		
		/*java.util.Scanner input = new java.util.Scanner(System.in);
		MyMath math = new MyMath();
		
		System.out.println("�������һ����:");
		int numA = input.nextInt();
		
		System.out.println("������ڶ�����:");
		int numB = input.nextInt();
		
		System.out.println("������Ԫ�����(+-* /):");
		String symbol = input.next();
		
		int res = 0;
		boolean flag = true;
		
		if("+".equals(symbol)) {
			res = math.add(numA, numB);
		} else if("-".equals(symbol)) {
			res = math.sub(numA, numB);
		} else if("*".equals(symbol)) {
			res = math.mutil(numA, numB);
		} else if("/".equals(symbol)) {
			if(numB == 0) {
				flag = false;
				System.out.println("��������Ϊ0");
			} else {
				res = math.division(numA, numB);
			}
		} else {
			flag = false;
			System.out.println("������������");
		}
		
		if(flag) {
			System.out.println("������Ϊ��" + res);
		}
		*/
		
	}

}

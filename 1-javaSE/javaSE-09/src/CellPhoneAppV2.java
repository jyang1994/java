
/**
 * �绰���뱾�ڶ���
 * @author jimi_jin
 * @version 2.0
 */
public class CellPhoneAppV2 {

	String[] names = new String[5];
	String[] nums = new String[5];
	java.util.Scanner input = new java.util.Scanner(System.in);
	
	/**
	 * ��������
	 */
	public void startup() {
		
		System.out.println("1.����");
		System.out.println("2.����");
		System.out.println("3.�˳�");
		System.out.println("��ѡ��");
		
		int index = input.nextInt();
		
		if(1 == index) {
			save();
		} else if(2 == index) {
			find();
		} else if(3 == index) {
			System.exit(0); //ϵͳ�����˳�
		} else {
			System.out.println("ѡ��������������");
		}
		
		startup();
		
	}
	
	/**
	 * ����绰����
	 */
	private void save() {
		// 1.�û�������ϵ������
		System.out.println("��������ϵ������");
		String name = input.next();
		
		boolean flag = false;
		
		// 3.���������ҵ���һ��Ϊnull�Ŀռ���б���
		for(int i = 0; i < names.length; i ++) {
			if(names[i] == null) {
				
				// 2.�û�������ϵ�˵绰
				System.out.println("��������ϵ�˵绰");
				String phoneNo = input.next();
				
				flag = true;
				names[i] = name;
				nums[i] = phoneNo;
				break;
			} 
			/*if(i == 49) {
				System.out.println("�ڴ�����");
			}*/
			
		}
		
		// 4.��ʾ����ɹ������ڴ�����
		if(flag) {
			System.out.println("����ɹ�");
		} else {
			System.out.println("�ڴ�����");
		}
	}
	
	/**
	 * ���ҵ绰����
	 */
	private void find() {
		//1.�û�������ϵ������
		System.out.println("��������ϵ������");
		String name = input.next();
		
		String number = null;
		//2.��names�����в��Ҷ�Ӧ����ϵ������
		for(int i = 0; i < names.length; i++) {
			
			if(names[i] != null && names[i].equals(name)) {
				//3.�����names�������ҵ��ˣ�����ݶ�Ӧ�������±굽nums�������ҵ���Ӧ�ĵ绰����
				number = nums[i];
				break;
			}
			
		}
		//4.��ӡ�ҵ��ĵ绰�������޴���
		if(number != null) {
			System.out.println("��ϵ�˵绰��" + number);
		} else {
			System.out.println("���޴���");
		}
		
	}
	
	
}

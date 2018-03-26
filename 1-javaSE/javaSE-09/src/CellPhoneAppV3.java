
/**
 * �绰���뱾������
 * @author jimi_jin
 * @version 3.0
 */
public class CellPhoneAppV3 {

	Person[] persons = new Person[50];
			
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
		for(int i = 0; i < persons.length; i ++) {
			if(persons[i] == null) {
				
				// 2.�û�������ϵ�˵绰
				System.out.println("��������ϵ�˵绰");
				String phoneNo = input.next();
				
				// 3.�û�������ϵ��qq
				System.out.println("��������ϵ��qq");
				String qq = input.next();
				
				Person person = new Person();
				person.setName(name);
				person.setNum(phoneNo);
				person.setQq(qq);
				
				persons[i] = person;
				
				flag = true;
				
				break;
			} 
			
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
		
		Person person = null;
		//2.��names�����в��Ҷ�Ӧ����ϵ������
		for(int i = 0; i < persons.length; i++) {
			//if(persons[i] != null && persons[i].getName() != null && persons[i].getName().equals(name)) {
			if(persons[i] != null && name.equals(persons[i].getName())) {
				person = persons[i];
				break;
			}
			
		}
		//4.��ӡ�ҵ��ĵ绰�������޴���
		if(person != null) {
			System.out.println("����ϵ�˵ĵ绰Ϊ��" + person.getNum());
			System.out.println("����ϵ�˵�QQΪ��" + person.getQq());
		} else {
			System.out.println("���޴���");
		}
	}
	
	
}

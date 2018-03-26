import java.util.List;

public class ATM {
	
	// ���뱣֤bank����ֻ��һ��
	private Bank bank = Bank.getInstance();
	private java.util.Scanner input = new java.util.Scanner(System.in);
	private Account currAccount = null;// current  ��ǰ��¼��account����

	public void startup() {
		
		System.out.println("1. ����");
		System.out.println("2. �忨");
		System.out.println("3. ϵͳ����");
		System.out.println("4. �˳�ϵͳ");
		System.out.println("��ѡ��˵���");

		int index = input.nextInt();
		
		if(1 == index) {
			createAccount();
		} else if(2 == index) {
			insertCard();
		} else if(3 == index) {
			sysManage();
		} else if(4 == index) {
			System.exit(0);// ϵͳ�����˳�
		} else {
			System.out.println("ѡ���������������");
		}

		startup();
		
	}

	/**
	 * ϵͳ����
	 */
	private void sysManage() {
		//1.�������Ա����
		System.out.println("���������Ա����:");
		String password = input.next();
		
		//2.�жϹ���Ա�����Ƿ���ȷ
		if("123456".equals(password)) {
			//3.���������ȷ����ʾ����Ա�����˵�
			System.out.println("��¼�ɹ�");
			showSysMenu();
		} else {
			//4.������벻��ȷ����ʾ��������
			System.out.println("����Ա�����������������");
		}
		sysManage();
	}

	/**
	 * ����Ա�����˵�
	 */
	private void showSysMenu() {
		System.out.println("1. ��ʾ�����˻�");
		System.out.println("2. �����˻�");
		System.out.println("3. �ָ��˻�");
		System.out.println("4. �˳�");
		System.out.println("��ѡ��:");

		int index = input.nextInt();
		
		switch(index) {
			case 1: 
				showAllAccounts();
				break;
			case 2:
				frozenAccount();
				break;
			case 3:
				recoverAccount();
				break;
			case 4:
				startup();
				break;
			default:
				System.out.println("ѡ�����������ѡ��");
				break;
		}
		
		showSysMenu();
		
	}

	/**
	 * �ָ��˻�
	 */
	private void recoverAccount() {
		//1.��ʾ�����ѱ�������˻�
		List<Account> accs = bank.getAccounts();
		
		System.out.println("�˻���\t\t״̬");
		for(int i = 0; i < accs.size(); i++) {
			Account acc = accs.get(i);
			if(acc != null && !acc.isEnable()) {
				System.out.println(acc.getName() + "\t\t" + (acc.isEnable() ? "����" : "�쳣"));
			}
		}
		
		//2.����Ա���붳���˻���
		System.out.println("������Ҫ�ָ����˻�:");
		String name = input.next();
		
		//3.�жϸ��˻��Ƿ����
		Account acc = bank.findByName(name);
		
		if(acc != null) {
			//4.������ڣ��޸ĸö����enable����Ϊtrue
			acc.setEnable(true);
			System.out.println("�ָ��ɹ�");
		} else {
			//5.��������ڣ���ʾ����
			System.out.println("���˻�������");
		}
	}

	/**
	 * �����˻�
	 */
	private void frozenAccount() {
		//1.��ʾ����δ��������˻�
		List<Account> accs = bank.getAccounts();
		
		System.out.println("�˻���\t\t״̬");
		for(int i = 0; i < accs.size(); i++) {
			Account acc = accs.get(i);
			if(acc != null && acc.isEnable()) {
				System.out.println(acc.getName() + "\t\t" + (acc.isEnable() ? "����" : "�쳣"));
			}
		}
		
		//2.����Ա���붳���˻���
		System.out.println("������Ҫ������˻�:");
		String name = input.next();
		
		//3.�жϸ��˻��Ƿ����
		Account acc = bank.findByName(name);
		
		if(acc != null) {
			//4.������ڣ��޸ĸö����enable����Ϊfalse
			acc.setEnable(false);
			System.out.println("����ɹ�");
		} else {
			//5.��������ڣ���ʾ����
			System.out.println("���˻�������");
		}

	}

	/**
	 * ��ʾ�����˻�
	 */
	private void showAllAccounts() {

		//1.���accounts����
		List<Account> accs = bank.getAccounts();
		
		System.out.println("�˻���\t\t״̬");
		//2.�������accounts����Ķ����ֵ
		for(int i = 0; i < accs.size(); i++) {
			Account acc = accs.get(i);
			if(acc != null) {
				System.out.println(acc.getName() + "\t\t" + (acc.isEnable() ? "����" : "�쳣"));
			}
		}
		
	}

	/**
	 * �忨(��¼)
	 */
	private void insertCard() {
		//1.�û������˻�������
		System.out.println("�������˻�:");
		String name = input.next();
		
			System.out.println("����������:");	String password = input.next();
		
		//2.�ж��˻������������Ƿ���ȷ���ж��˻�״̬
			currAccount = bank.findByNameAndPassword(name, password);// accounts[i]
		
			if(currAccount != null) {
			//�ж��˻�״̬
			if(currAccount.isEnable()) {
				//2.1������ȷ����״̬��������ʾ�����˵�
			System.out.println("��¼�ɹ�");
				showAccMenu();
			} else {
				System.out.println("�˻�״̬�쳣������ϵ����Ա");
			}
			
			
		} else{
			//2.2���������ʾ��������
			System.out.println("�˻����������������������");
			insertCard();
		}
		
	}

	/**
	 * �˻��Ķ����˵�
	 */
	private void showAccMenu() {

		System.out.println("1. ��ѯ���");
		System.out.println("2. ȡ��");
		System.out.println("3. ���");
		System.out.println("4. ת��");
		System.out.println("5. �޸�����");
		System.out.println("6. �˳�");
		System.out.println("��ѡ��˵�");
		
		int index = input.nextInt();
		
		if(1 == index) {
			showCurrentMoney();
		} else if (2 == index) {
			drawMoney();
		} else if (3 == index) {
			inMoney();
		} else if (4 == index) {
			transMoney();
		} else if (5 == index) {
			changePassword();
		} else if (6 == index) {
			startup();
		} else {
			System.out.println("�����������������");
			showAccMenu();
		}
		
		
	}

	/**
	 * ת��
	 */
	private void transMoney() {
		// 1.�û�����ת���˻�
		System.out.println("������ת���˻�:");
		String name = input.next();
		
		// 2.У����˻��Ƿ����
		Account inAccount = bank.findByName(name);
		// 3.���ת���˻�����
		if(inAccount != null) {
			// 3.1 �û�����ת�˽��
			System.out.println("������ת�˽��:");
			int money = input.nextInt();
			
			// 3.2 �ж�ת�˽���Ƿ�>0����С�ڵ�ǰ��¼�˻�currAccount�˻������
			if(money < 0) {
				System.out.println("ת�˽�����ò���ȷ");
			} else if(money > currAccount.getMoney()) {
				System.out.println("����");
			} else {
				// 3.3�޸ĵ�ǰ��¼�˻�currAccount�����= ��� - ת�˽��
				currAccount.setMoney(currAccount.getMoney() - money);
				// 3.4 �޸�ת���˻�inAccount�����= ���Լ������  + ת�˽�� 
				inAccount.setMoney(inAccount.getMoney() + money);
				System.out.println("ת�˳ɹ�");
			}
		} else {
			// 4.���ת���˻������ڣ���ʾ��Ϣ
			System.out.println("ת���˻������ڣ�����������");
		}
		
		showAccMenu();
	}

	/**
	 * �޸�����
	 */
	private void changePassword() {

		//1. �û�����ԭʼ����
		System.out.println("������ԭʼ����:");
		String oldPassword = input.next();
		
		//2. �ж�ԭʼ�����Ƿ���ȷ
		if(oldPassword.equals(currAccount.getPassword())) {
			//3. �����ȷ��ʾ�û�����������
			System.out.println("������������:");
			String newPassword = input.next();
			
			//4. ���õ�ǰ��¼currAccount�����password����
			currAccount.setPassword(newPassword);
			System.out.println("�������óɹ�,�����µ�¼");
			insertCard();
		} else {
			System.out.println("ԭʼ���벻��ȷ");
		}
		//5. ��ʾ�����˵�
		showAccMenu();
	}

	/**
	 * ���
	 */
	private void inMoney() {

		//1. �û���������
		System.out.println("����������:");
		int money = input.nextInt();
		
		//2. �жϽ���Ƿ�>0
		if(money < 0) {
			System.out.println("��������벻��ȷ,����������");
		} else {
			//3. ���õ�ǰ��¼�˻�currAccount��money����Ϊ(��� + �����)
			currAccount.setMoney(currAccount.getMoney() + money);
			System.out.println("���ɹ�");
		}
		//4. ��ʾ�����˵�
		showAccMenu();
	}

	/**
	 * ȡ��
	 */
	private void drawMoney() {
		// 1. �û�����ȡ����
		System.out.println("������ȡ����:");
		int money = input.nextInt();
				
		// 2. �жϽ���Ƿ�>0
		if(money < 0) {
			System.out.println("ȡ���������������������");
		} else if(money > currAccount.getMoney()) {
			// 3. �жϽ���Ƿ�<��ǰ���
			System.out.println("���� ");
		} else {
			// 4. ���õ�ǰcurrAccount��money����Ϊ(��� - ȡ����)
			currAccount.setMoney(currAccount.getMoney() - money);
			System.out.println("ȡ��ɹ�");
		}
		
		// 5. ��ʾ�����˵�
		showAccMenu();
		
	}

	/**
	 * ��ѯ���
	 */
	private void showCurrentMoney() {
		System.out.println("��ǰ�˻����Ϊ:" + currAccount.getMoney());
		showAccMenu();
	}

	/**
	 * ����
	 */
	private void createAccount() {
		//1.�û������˻���
		System.out.println("�������˻�:");
		String name = input.next();
		
		//2.У����˻����Ƿ����
		Account acc = bank.findByName(name);
		
		if(acc == null) {
			//2.1 ������˻����ã��û���������
			System.out.println("���������룺");
			String password = input.next();
			
			//�����˻�:��װAccount���󣬱��浽bank�����accounts������
			Account account = new Account();
			account.setName(name);
			account.setPassword(password);
			
			boolean isSave = bank.saveAccount(account);
			
			if(isSave) {
				System.out.println("�����ɹ�");
			} else {
				System.out.println("����ʧ�ܣ�����ϵ����Ա");
			}
			
			
		} else {
			//2.2 ����˻������ã���ʾ�˻���ռ�ã���������
			System.out.println("�˻��Ѵ��ڣ�����������");
			createAccount();
		}
		
	}
	
	
}

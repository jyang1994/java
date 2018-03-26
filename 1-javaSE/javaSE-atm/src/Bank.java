import java.util.ArrayList;
import java.util.List;

public class Bank {

	private static Bank bank;
	
	private Bank(){}
	
	public static Bank getInstance() {
		if(bank == null) {
			bank = new Bank();
		}
		return bank;
	}
	
	
	// ��������˻���ֵ���൱�����ݿ�
	private List<Account> accounts = new ArrayList<>();
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	/**
	 * �����˻�
	 */
	public boolean saveAccount(Account acc) {
		return accounts.add(acc);
	}
	
	
	/**
	 * У����û����Ƿ����
	 * @param accountName ҪУ����˻�
	 * @return true:���˻����� false:������
	 */
	public Account findByName(String accountName) {
		for(int i = 0; i < accounts.size(); i++) {
			Account acc = accounts.get(i);
			if(acc != null && accountName.equals(acc.getName())) {
				return acc;
			}
		}
		return null;
		
	}
	
	/**
	 * �����û���������Ҷ�Ӧ���˻�
	 * @params name ��¼���˻�  password ��¼������ 
	 * @return true:�˻�������ȷ  false:�˻������������
	 * 
	 */
	public Account findByNameAndPassword(String name, String password) {
		
		for(int i = 0; i < accounts.size(); i++) {
			Account acc = accounts.get(i);
			if(acc != null && name.equals(acc.getName()) && password.equals(acc.getPassword())){
				return acc;
			}
		}
		return null;
		
	}


}

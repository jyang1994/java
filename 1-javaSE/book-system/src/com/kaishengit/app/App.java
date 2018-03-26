package com.kaishengit.app;

import java.util.List;
import java.util.Scanner;

import com.kaishengit.dao.AdminDao;
import com.kaishengit.dao.BookCardDao;
import com.kaishengit.dao.BookDao;
import com.kaishengit.dao.CardDao;
import com.kaishengit.entity.Admin;
import com.kaishengit.entity.Book;
import com.kaishengit.entity.BookCard;
import com.kaishengit.entity.Card;

public class App {

	Scanner input = new Scanner(System.in);
	AdminDao adminDao = new AdminDao(); 
	BookDao bookDao = new BookDao();
	CardDao cardDao = new CardDao();
	BookCardDao bookCardDao = new BookCardDao();
	
	public void startup() {
		
		System.out.println("���������Ա�ʺţ�");
		String name = input.next();
		
		System.out.println("���������Ա���룺");
		String password = input.next();
		
		Admin admin = adminDao.findByName(name);
		
		if(admin != null && password.equals(admin.getPassword())) {
			System.out.println("��¼�ɹ�");
			showMenu();
			
		} else {
			System.out.println("�ʺŻ��������������������");
			startup();
		}
		
		
	}

	private void showMenu() {

		System.out.println("��ӭ����ͼ�����ϵͳ");
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. �������");
		System.out.println("4. �����鼮");
		System.out.println("5. ɾ���鼮");
		System.out.println("6. ��ѯ�����鼮");
		System.out.println("7. ��ѯָ���鼮");
		System.out.println("8. ����ͼ��֤");
		System.out.println("9. �˳�");
		System.out.println("��ѡ��:");

		int index = input.nextInt();
		
		if(1 == index) {
			borrowBook();
		} else if(2 == index) {
			returnBook();
		} else if(3 == index) {
			addBook();
		} else if(4 == index) {
			updateBook();
		} else if(5 == index) {
			deleteBook();
		} else if(6 == index) {
			showAllBooks();
		} else if(7 == index) {
			showQueryBooks();
		} else if(8 == index) {
			addCard();
		} else if(9 == index) {
			System.exit(0);
		} else {
			System.out.println("������������������");
		}
		
		showMenu();
		
	}

	/**
	 * ����
	 */
	private void returnBook() {
		// 1. �û��������֤����
		System.out.println("������ͼ��֤����:");
		String code = input.next();
		
		// 2. �жϸú����Ƿ����
		Card card = cardDao.findByCode(code);
		
		if(card != null) {
			List<Book> bookList = bookCardDao.findBorrowBookList(card.getId());
			
			// 3. չʾ�����б�
			System.out.println("�鼮����\t\t����\t\t������\t\t ISBN");
			
			if(bookList.isEmpty()) {
				System.out.println("��������");
			}
			
			for(Book book : bookList) {
				System.out.println(book);
			}
			
			// 4. ����Ҫ�����鼮��isbn
			System.out.println("������Ҫ���鼮��isbn");
			String isbn = input.next();
			
			Book book = bookDao.findByIsbn(isbn);
			
			// 5. У����鼮�Ƿ����
			if(book != null) {
				BookCard bookCard = bookCardDao.findByBidAndCid(book.getId(), card.getId());
				if(bookCard != null) {
					// 6. ������
					// 6.1. ɾ��card��book�Ľ��Ĺ�ϵ
					bookCardDao.delete(book.getId(), card.getId());
					// 6.2. ���¿��
					book.setCurrNum(book.getCurrNum() + 1);
					bookDao.update(book);
					
					System.out.println("����ɹ�");
				} else {
					System.out.println("���鼮�����ڽ��Ĺ�ϵ�����ѯ����������");
				}
			} else {
				System.out.println("���鼮������");
			}
			
			
		} else {
			System.out.println("��ͼ��֤�����ڣ������������");
		}
		
	}

	/**
	 * ����
	 */
	private void borrowBook() {
		// 1. �û��������֤����
		System.out.println("������ͼ��֤����:");
		String code = input.next();
		
		// 2. �жϸú����Ƿ����
		Card card = cardDao.findByCode(code);
		
		if(card != null) {
			// 3. �жϸ�ͼ��֤�Ƿ��Ѵ�����(5)
			int num = bookCardDao.countBorrowNum(card.getId());
			if(num < 5) {
				// 4. �û�����isbn,���жϸ��鼮�������
				System.out.println("�������鼮isbn");
				String isbn = input.next();
				
				Book book = bookDao.findByIsbn(isbn);
				
				if(book != null) {
					// 5. �жϸ��鼮�Ƿ��ڽ���״̬
					BookCard bookCard = bookCardDao.findByBidAndCid(book.getId(), card.getId());
					
					if(bookCard == null) {
						// 6. �жϸ������Ƿ�>0
						if(book.getCurrNum() > 0) {
							// 7. �������
							// 7.1 ����card��book�Ľ��Ĺ�ϵ
							bookCardDao.save(book.getId(), card.getId());
							
							// 7.2 ���¿��
							book.setCurrNum(book.getCurrNum() - 1);
							bookDao.update(book);
							
							System.out.println("���ĳɹ�");
						} else {
							System.out.println("��治��");
						}
					} else {
						System.out.println("��ͼ���Ѿ����ڽ���״̬�����ö��ν���");
					}
					
				} else {
					System.out.println("���鼮������");
				}
				
			} else {
				System.out.println("��ͼ��֤���������Ѵ�����");
			}
			
		} else {
			System.out.println("��ͼ��֤�����ڣ������������");
		}
		
	}

	/**
	 * ����ͼ��֤
	 */
	private void addCard() {

		System.out.println("������ͼ֤����:");
		String code = input.next();
		
		Card card = cardDao.findByCode(code);
		if(card == null) {
			System.out.println("������ѧ������:");
			String name = input.next();
			
			System.out.println("��������ϵ�绰:");
			String tel = input.next();
			
			card = new Card();
			card.setCode(code);
			card.setName(name);
			card.setTel(tel);
			
			cardDao.save(card);
			System.out.println("ͼ��֤�½��ɹ�");
			
		} else {
			System.out.println("֤�������Ѵ��ڣ�����������:");
			addCard();
		}
		
		
	}

	/**
	 * ��ѯָ���鼮
	 */
	private void showQueryBooks() {
		System.out.println("������Ҫ���ҵĹؼ���:");
		String keys = input.next();
		
		List<Book> bookList = bookDao.findByKeys(keys);
		System.out.println("�鼮����\t\t����\t\t������\t\t ISBN \t\t������\t\t���");
		
		if(bookList.isEmpty()) {
			System.out.println("��������");
		}
		
		for(Book book : bookList) {
			System.out.println(book);
		}
		
	}

	/**
	 * ��ѯ�����鼮
	 */
	private void showAllBooks() {

		List<Book> bookList = bookDao.findAll();
		
		System.out.println("�鼮����\t\t����\t\t������\t\t ISBN \t\t������\t\t���");
		
		if(bookList.isEmpty()) {
			System.out.println("��������");
		}
		
		for(Book book : bookList) {
			System.out.println(book);
		}
		
	}

	/**
	 * ɾ���鼮
	 */
	private void deleteBook() {

		System.out.println("������isbn��:");
		String isbn = input.next();
		
		Book book = bookDao.findByIsbn(isbn);
		
		if(book != null) {
			// ������鼮�����������ɾ��
			if(book.getTotalNum() == book.getCurrNum()) {
				 bookDao.delete(book.getId());
				 System.out.println("ɾ���ɹ���");
			} else {
				System.out.println("���鼮�ѱ����������ɾ��");
			}
			
		} else {
			System.out.println("���鼮������");
		}
		
		
	}

	/**
	 * �����鼮
	 */
	private void updateBook() {

		System.out.println("�������鼮��isbn��:");
		String isbn = input.next();
		
		Book book = bookDao.findByIsbn(isbn);
		
		if(book != null) {
			System.out.println("�Ƿ���Ҫ�޸��鼮������?(Y|N)");
			String answer = input.next();
			boolean flag = false;
			
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("�������µ��鼮����:");
				String bookName = input.next();
				book.setBookName(bookName);
				flag = true;
			}
			
			System.out.println("�Ƿ�Ҫ�޸��鼮����������?(Y|N)");
			answer = input.next();
			
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("�������µ���������:");
				String authorName = input.next();
				book.setBookAuthor(authorName);
				flag = true;
			}
			
			
			System.out.println("�Ƿ�Ҫ�޸��鼮������?(Y|N)");
			answer = input.next();
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("�������µ��鼮����");
				int totalNum = input.nextInt();
				int changeNum = totalNum - book.getTotalNum();
				int currentNum = book.getCurrNum() + changeNum;
				if(currentNum >= 0) {
					book.setTotalNum(totalNum);
					book.setCurrNum(currentNum);
					flag = true;
				} else {
					System.out.println("���ݿ���������㣬�����޸�");
				}
				
			}
			if(flag) {
				bookDao.update(book);
				System.out.println("���³ɹ�");
			}
			
			
		} else {
			System.out.println("���鼮������");
		}
		
	}

	/**
	 * �������
	 */
	private void addBook() {
		
		System.out.println("�������鼮ISBN��");
		String isbn = input.next();
		
		Book book = bookDao.findByIsbn(isbn);
		if(book == null) {
			System.out.println("�������鼮����");
			String name = input.next();
			
			System.out.println("�������鼮��������");
			String authorName = input.next();
			
			System.out.println("�������鼮����������");
			String publishName = input.next();
			
			System.out.println("�������鼮����");
			int totalNum = input.nextInt();
			
			book = new Book();
			book.setISBN(isbn);
			book.setBookAuthor(authorName);
			book.setBookName(name);
			book.setPublishName(publishName);
			book.setTotalNum(totalNum);
			book.setCurrNum(totalNum);
			
			bookDao.save(book);
			
			System.out.println("����ɹ�");
			
		} else {
			System.out.println("���鼮�Ѿ�¼�룬�����ٴ�¼��");
		}
		
	}
}

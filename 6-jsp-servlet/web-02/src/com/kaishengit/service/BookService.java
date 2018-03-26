package com.kaishengit.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.dao.BookDao;
import com.kaishengit.entity.Book;
import com.kaishengit.exception.ServiceException;

/**
 * �������ڴ���book��ص�ҵ���߼�
 * @author jimi_jin
 *
 */
public class BookService {
	
	BookDao bookDao = new BookDao();
	/**
	 * @param name �鼮����
	 * @param author �鼮����
	 * @param publish �鼮������
	 * @param isbn isbn
	 * @param num ����
	 * @throws ServiceException ��isbn�ظ���ʱ���׳����쳣
	 */
	public void addBook(String name, String author, String publish, String isbn, String num)
			throws ServiceException{
		
		// 2.1 �ж�isbn�Ƿ����
		Book book = bookDao.findByIsbn(isbn);
		
		if(book == null) {
			// 3.��װ��entity����
			book = new Book();
			book.setName(name);
			book.setAuthor(author);
			book.setPublish(publish);
			book.setIsbn(isbn);
			book.setTotal(Integer.parseInt(num));
			book.setCurrentNum(Integer.parseInt(num));
			
			// 4.����daoִ�б������
			bookDao.save(book);
		} else {
			// �ֶ��׳��쳣
			throw new ServiceException("ISBN�ظ�");
		}
		
	}

	/**
	 * �����鼮�б�
	 * @return �鼮�б�
	 */
	public List<Book> findAllBook() {
		return bookDao.findAll();
	}

	public void delBook(String id) {

		if(StringUtils.isNumeric(id)) {
			Book book = bookDao.findById(id);
			if(book != null) {
				//TODO �ж��鼮���޽��
				bookDao.delById(id);
			} else {
				throw new ServiceException("�����쳣");
			}
		} else {
			throw new ServiceException("�����쳣");
		}
		
		
	}

	/**
	 * ����id�����鼮
	 * @param id
	 * @return
	 */
	public Book findBookById(String id) {
		return bookDao.findById(id);
	}

	/**
	 * �����鼮��Ϣ
	 * @param name
	 * @param author
	 * @param publish
	 * @param isbn
	 * @param total
	 * @param currentNum
	 * @param currentNum2 
	 */
	public void updateBook(String id,String name, String author, String publish, String isbn, String total, String currentNum) {
		
		Book book = new Book();
		
		book.setId(Integer.parseInt(id));
		book.setName(name);
		book.setAuthor(author);
		book.setPublish(publish);
		book.setIsbn(isbn);
		book.setTotal(Integer.parseInt(total));
		book.setCurrentNum(Integer.parseInt(currentNum));
		
		bookDao.update(book);
		
	}
	
}

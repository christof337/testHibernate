package net.joastbg.sampleapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;
import net.joastbg.sampleapp.entities.Book;
import net.joastbg.sampleapp.entities.BookDao;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class BookDaoTest {

	@Autowired
	BookDao bookDao;
	
	@Test
	public void testSave(){
		Long id = bookDao.persist(new Book("test"));
		Assert.assertNotNull(id);
		Book book = bookDao.find(id);
		
		Assert.assertNotNull(book);
		Assert.assertEquals("test", book.getTitle());
	}
	
	@Test
	public void testRecupAuthor() {
		Book book = bookDao.find(30L);
		Assert.assertEquals("Rowling", book.getAuthor().getLastName());
	}
	
}

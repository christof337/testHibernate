package net.joastbg.sampleapp;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;
import net.joastbg.sampleapp.entities.Author;
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
		Assert.assertNotNull("Id livre null",id);
		
		Book book = bookDao.find(id);
		
		Assert.assertNotNull("Livre null", book);
		Assert.assertEquals("Intitule livre incorrect","test", book.getTitle());
	}
	
	@Test
	public void testRecupAuthor() {
		Book book = bookDao.find(30L);
		Set<Author> authors = book.getAuthors();
		Assert.assertFalse("Set d'auteurs vide", authors.isEmpty());
		Author author = authors.iterator().next();
		Assert.assertEquals("Noms de famille différents", "Rowling", author.getLastName());
	}
	
}

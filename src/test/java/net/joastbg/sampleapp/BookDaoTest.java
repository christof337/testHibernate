package net.joastbg.sampleapp;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;
import net.joastbg.sampleapp.entities.Person;
import net.joastbg.sampleapp.dao.BookDao;
import net.joastbg.sampleapp.entities.Book;
import net.joastbg.sampleapp.exceptions.DaoException;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class BookDaoTest {

	@Autowired
	BookDao bookDao;
	Long id;
	
	@Before
	public void setUp() {

	}
	
	@Test
	public void testSave(){
	/*	Assert.assertNotNull("Id livre null",id);
		id = bookDao.persist(new Book("test"));
		Book book = bookDao.find(id);
		
		Assert.assertNotNull("Livre null", book);
		Assert.assertEquals("Intitule livre incorrect","test", book.getTitle());*/
	}
	
	@Test
	public void testRecupAuthor() throws DaoException {
		Book book = bookDao.findByTitle("Song of Ice and Fire");

		Assert.assertNotNull(book);

		Assert.assertNotNull("Aucun auteur trouvé", book.getAuthors());
/*		Assert.assertFalse("Set d'auteurs vide", authors.get().isEmpty());
		Person author = authors.get().iterator().next();
		Assert.assertEquals("Noms de famille différents", "Tolkien", author.getLastName());*/
	}

	@Test
	public void testSelectAll(){
		List<Book> books =bookDao.findAll();
		Assert.assertNotNull(books);
		for(Book book: books){
			System.out.println(book.getTitle());
		}
	}
	
}

package net.joastbg.sampleapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;
import net.joastbg.sampleapp.entities.Author;
import net.joastbg.sampleapp.entities.AuthorDao;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class AuthorDaoTest {

	@Autowired
	AuthorDao authorDao;
	
	@Test
	public void testSave(){
		Long id = authorDao.persist(new Author("Nazareth","Jesus"));
		Assert.assertNotNull(id);
		Author author = authorDao.find(id);
		
		Assert.assertNotNull(author);
		Assert.assertEquals("Nazareth", author.getLastName());
		Assert.assertEquals("Jesus", author.getFirstName());
	}
}

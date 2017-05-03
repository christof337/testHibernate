package net.joastbg.sampleapp;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;
import net.joastbg.sampleapp.entities.Person;
import net.joastbg.sampleapp.entities.PersonDao;
import net.joastbg.sampleapp.entities.TypePerson;
import net.joastbg.sampleapp.exceptions.DaoException;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class PersonDaoTest {

	@Autowired
	PersonDao personDao;
	
	@Test
	public void testSave(){
		Long id = personDao.persist(new Person("Nazareth","Jesus",TypePerson.AUTHOR));
		Assert.assertNotNull("Id auteur null",id);
		Person person = personDao.find(id);
		
		Assert.assertNotNull("Auteur null",person);
		Assert.assertEquals("Nom de famille incorrect","Nazareth", person.getLastName());
		Assert.assertEquals("Prénom incorrect","Jesus", person.getFirstName());
	}
	
	@Test
	public void testBooks() {
		Optional<Person> person = Optional.empty();
		try {
			person = Optional.ofNullable(personDao.findByName("Tolkien"));
		} catch (DaoException e) {
			Assert.fail("Echec de récupération de l'auteur : " + e.getMessage());
		}
		Assert.assertTrue(person.isPresent());
		Assert.assertNotNull(person.get().getBooks());
	}
}

package net.joastbg.sampleapp;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import net.joastbg.sampleapp.entities.Person;
import net.joastbg.sampleapp.entities.Book;

/**
 *
 * @author Johan Astborg <joastbg@gmail.com>
 */

public class TestPerson {

	@Test
	public void testCreateNewAuthorWithName() {
		Person person = new Person("Asimov","Isaac");
//		Assert.assertNotNull("Id auteur null",author.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithEmptyLastName() {
		new Person("","JRR");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithEmptyFirstName() {
		new Person("Tolkien","");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithEmptyFirstNameAndLastName() {
		new Person("","");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithNullLastName() {
		new Person(null,"George RR");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithNullFirstName() {
		new Person("Martin",null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewBookWithNullFirstNameAndLastName() {
		new Person(null, null);
	}
	
	@Test 
	public void testAddBooksToAuthorMesCouilles() {
		Person person = new Person("Tolkien", "JRR");
		Set<Book> books = new HashSet<Book>();
		
		books.add(new Book("La communauté de l'anneau"));
		books.add(new Book("Les deux tours"));
		books.add(new Book("Le retour du roi"));
		
		person.setBooks(books);
		
		Assert.assertEquals(books, person.getBooks());
	}
}

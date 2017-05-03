package net.joastbg.sampleapp;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import net.joastbg.sampleapp.entities.Person;
import net.joastbg.sampleapp.entities.TypePerson;
import net.joastbg.sampleapp.entities.Book;

/**
 *
 * @author Charlotte Cavalier <charlotte.cavalier@gmail.com>
 */

public class TestPerson {

	@Test
	public void testCreateNewAuthorWithName() {
		Person person = new Person("Asimov","Isaac",TypePerson.AUTHOR);
//		Assert.assertNotNull("Id auteur null",author.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithEmptyLastName() {
		new Person("","JRR",TypePerson.AUTHOR);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithEmptyFirstName() {
		new Person("Tolkien","",TypePerson.AUTHOR);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithEmptyFirstNameAndLastName() {
		new Person("","",TypePerson.VEDETTE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithNullLastName() {
		new Person(null,"George RR",TypePerson.AUTHOR);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithNullFirstName() {
		new Person("Martin",null,TypePerson.AUTHOR);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewBookWithNullFirstNameAndLastName() {
		new Person(null, null, null);
	}
	
	@Test 
	public void testAddBooksToAuthorMesCouilles() {
		Person person = new Person("Tolkien", "JRR",TypePerson.AUTHOR);
		Set<Book> books = new HashSet<Book>();
		
		books.add(new Book("La communauté de l'anneau"));
		books.add(new Book("Les deux tours"));
		books.add(new Book("Le retour du roi"));
		
		person.setBooks(books);
		
		Assert.assertEquals(books, person.getBooks());
	}
}

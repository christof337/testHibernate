package net.joastbg.sampleapp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import net.joastbg.sampleapp.entities.Author;
import net.joastbg.sampleapp.entities.Book;

/**
 *
 * @author Johan Astborg <joastbg@gmail.com>
 */

public class TestAuthor {

	@Test
	public void testCreateNewBookWithTitle() {
		Author author = new Author("Asimov","Isaac");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithEmptyLastName() {
		new Author("","JRR");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithEmptyFirstName() {
		new Author("Tolkien","");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithEmptyFirstNameAndLastName() {
		new Author("","");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithNullLastName() {
		new Author(null,"George RR");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewAuthorWithNullFirstName() {
		new Author("Martin",null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewBookWithNullFirstNameAndLastName() {
		new Author(null, null);
	}
	
	@Test 
	public void testAddBooksToAuthorMesCouilles() {
		Author author = new Author("Tolkien", "JRR");
		List<Book> books = new ArrayList<Book>();
		
		books.add(new Book("La communauté de l'anneau"));
		books.add(new Book("Les deux tours"));
		books.add(new Book("Le retour du roi"));
		
		author.setBooks(books);
		
		Assert.assertEquals(books, author.getBooks());
	}
}

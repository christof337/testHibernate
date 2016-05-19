package net.joastbg.sampleapp;

import org.junit.Test;

import junit.framework.Assert;
import net.joastbg.sampleapp.entities.Author;
import net.joastbg.sampleapp.entities.Book;

/**
 *
 * @author Johan Astborg <joastbg@gmail.com>
 */
public class TestBook {

	@Test
	public void testCreateNewBookWithTitle() {
		new Book("My Book");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewBookWithEmptyTitle() {
		new Book("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateNewBookWithNullTitle() {
		new Book(null);
	}
	
	@Test
	public void testSetAuthorToBook() {
		Book book = new Book("Les Robots");
		Author author = new Author("Asimov", "Isaac");
		book.setAuthor(author);
		Assert.assertEquals(author, book.getAuthor());
	}
}

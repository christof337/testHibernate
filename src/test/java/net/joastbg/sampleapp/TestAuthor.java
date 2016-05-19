package net.joastbg.sampleapp;

import org.junit.Test;

import net.joastbg.sampleapp.entities.Author;

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
}

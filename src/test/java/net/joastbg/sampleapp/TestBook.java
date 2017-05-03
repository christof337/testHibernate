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
public class TestBook {

	@Test
	public void testCreateNewBookWithTitle() {
		Book book = new Book("My Book");
//		Assert.assertNotNull("Id livre null",book.getIdArticle());
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
		Person person = new Person("Asimov", "Isaac",TypePerson.AUTHOR);
		Set<Person> authorsSet = new HashSet<Person>();
		authorsSet.add(person);
		book.setAuthors(authorsSet);
		Assert.assertEquals(authorsSet, book.getAuthors());
	}
}

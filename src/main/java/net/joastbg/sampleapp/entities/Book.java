package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Describes a Book
 * 
 * @author Charlotte Cavalier <charlotte.cavalier@gmail.com>
 */
@Entity
@SequenceGenerator(name="SEQ_ARTICLE",sequenceName="SEQ_DB_NAME")
@Table(name="BOOK")
public class Book extends Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7615624242713702030L;

	@Column
	private String title;
	
	@Column
	private String ISBN;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "WROTE_BY_AUTHOR_BOOK", joinColumns = {
			@JoinColumn(name = "idBook", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "idAuthor",
					nullable = false, updatable = false) })
	private Set<Person> authors;

	public Book() {
		super();
	}
	
	public Book(String title) throws IllegalArgumentException {
		super();
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Title must not be empty");
		}
		setTitle(title);
	}

	/**
	 * 
	 * @return
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * 
	 * @param ISBN
	 */
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}


	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Set<Person> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Person> persons) {
		this.authors = persons;
	}
}

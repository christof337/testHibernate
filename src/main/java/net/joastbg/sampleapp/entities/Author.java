package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Describes an Author
 * 
 * @author Christophe Pont <christof337@hotmail.fr>
 */
@Entity
@Table(name="AUTHOR")
public class Author implements Serializable, Comparable<Author> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5849043776684119492L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private String lastName;
	
	@Column
	private String firstName;
	
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "BOOK", joinColumns = { 
//			@JoinColumn(name = "author_id", nullable = false, updatable = false) }, 
//			inverseJoinColumns = { @JoinColumn(name = "idArticle", 
//					nullable = false, updatable = false) })
//	private List<Book> books;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "WROTE_BY_AUTHOR_BOOK", joinColumns = {
			@JoinColumn(name = "idAuthor", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "idBook",
					nullable = false, updatable = false) })
	private Set<Book> books;
	
	public Author() {
		
	}

	public Author(String lastName, String firstName) throws IllegalArgumentException {
		if (lastName == null || lastName.isEmpty() || firstName == null || firstName.isEmpty()) {
			throw new IllegalArgumentException("Title must not be empty");
		}
		setLastName(lastName);
		setFirstName(firstName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public int compareTo(Author o) {
		return o.getFirstName().compareTo(this.getFirstName()) + o.getLastName().compareTo(this.getLastName());
	}
	
}

package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Describes an Person
 * 
 * @author Charlotte Cavalier <charlotte.cavalier@gmail.com>
 */
@Entity
@Table(name="PERSON")
public class Person implements Serializable, Comparable<Person> {

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
	
	@Column
	@Enumerated(EnumType.STRING)
	private TypePerson personType;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "WROTE_BY_AUTHOR_BOOK", joinColumns = {
			@JoinColumn(name = "idAuthor", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "idBook",
					nullable = false, updatable = false) })
	private Set<Book> books;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "PLAYED_IN_DVD_PERSON", joinColumns = {
			@JoinColumn(name = "idVedette", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "idDvd",
					nullable = false, updatable = false) })
	private Set<Dvd> films;
	
	// -------------------- 
	// CONSTRUCTORS
	// --------------------
	public Person() {
		
	}

	public Person(String lastName, String firstName, TypePerson personType) throws IllegalArgumentException {
		if (lastName == null || lastName.isEmpty() || firstName == null || firstName.isEmpty() || personType == null) {
			throw new IllegalArgumentException("Last name nor first name nor person type must not be empty");
		}
		setLastName(lastName);
		setFirstName(firstName);
		setPersonType(personType);
	}


	// -------------------- 
	// GETTERS AND SETTERS
	// --------------------
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

	/**
	 * @return the personType
	 */
	public TypePerson getPersonType() {
		return personType;
	}

	/**
	 * @param personType the personType to set
	 */
	public void setPersonType(TypePerson personType) {
		this.personType = personType;
	}

	/**
	 * @return the films
	 */
	public Set<Dvd> getFilms() {
		return films;
	}

	/**
	 * @param films the films to set
	 */
	public void setFilms(Set<Dvd> films) {
		this.films = films;
	}

	@Override
	public int compareTo(Person o) {
		return o.getFirstName().compareTo(this.getFirstName()) + o.getLastName().compareTo(this.getLastName()) + o.getPersonType().compareTo(this.getPersonType());
	}
	
}

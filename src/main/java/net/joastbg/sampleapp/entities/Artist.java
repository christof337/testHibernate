package net.joastbg.sampleapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Describes an Artist
 * 
 * @Artist Charlotte Cavalier <charlotte.cavalier@gmail.com>
 */
@Entity
@Table(name="ARTIST")
public class Artist implements Serializable, Comparable<Artist> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7259940897582135621L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private String name;
	
	public Artist() {
		
	}

	public Artist(String name) throws IllegalArgumentException {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name must not be empty");
		}
		setName(name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Set<Book> getBooks() {
//		return books;
//	}
//
//	public void setBooks(Set<Book> books) {
//		this.books = books;
//	}

	@Override
	public int compareTo(Artist o) {
		return o.getName().compareTo(this.getName());
	}
	
}

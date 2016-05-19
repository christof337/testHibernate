package net.joastbg.sampleapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Long id;

	@Column
	private String lastName;
	
	@Column
	private String firstName;

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

	@Override
	public int compareTo(Author o) {
		return o.getFirstName().compareTo(this.getFirstName()) + o.getLastName().compareTo(this.getLastName());
	}
}

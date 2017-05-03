package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Describes a Dvd
 * 
 * @author Charlotte Cavalier <charlotte.cavalier@gmail.com>
 */
@Entity
@SequenceGenerator(name="SEQ_ARTICLE",sequenceName="SEQ_DB_NAME")
@Table(name="DVD")
public class Dvd extends Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9185080208096257030L;

	@Column
	@Enumerated(EnumType.STRING)
	private DvdCategory category;
	
	@ManyToOne(optional=false) 
    @JoinColumn(name="idRealisateur", nullable=false, updatable=false)
	private Person realisateur;
		
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "PLAYED_IN_DVD_PERSON", joinColumns = {
			@JoinColumn(name = "idDvd", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "idVedette",
					nullable = false, updatable = false) })
	private Set<Person> vedettes;
	
	
	public Dvd() {
		
	}
	
//	public Dvd(String title) throws IllegalArgumentException {
//		if (title == null || title.isEmpty()) {
//			throw new IllegalArgumentException("Title must not be empty");
//		}
//		setTitle(title);
//	}

	/**
	 * @return the category
	 */
	public DvdCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(DvdCategory category) {
		this.category = category;
	}

	/**
	 * @return the realisateur
	 */
	public Person getRealisateur() {
		return realisateur;
	}

	/**
	 * @param realisateur the realisateur to set
	 */
	public void setRealisateur(Person realisateur) {
		this.realisateur = realisateur;
	}

	/**
	 * @return the vedettes
	 */
	public Set<Person> getVedettes() {
		return vedettes;
	}

	/**
	 * @param vedettes the vedettes to set
	 */
	public void setVedettes(Set<Person> vedettes) {
		this.vedettes = vedettes;
	}
}

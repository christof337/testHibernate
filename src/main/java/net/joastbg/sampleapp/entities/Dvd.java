package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import javax.persistence.*;
import org.joda.time.DateTime;

import org.hibernate.annotations.Type;

/**
 * Describes a Book
 * 
 * @author Johan Astborg <joastbg@gmail.com>
 */
@Entity
@Table(name="DVD")
public class Dvd implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9185080208096257030L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="article_seq_gen")
	@SequenceGenerator(name="article_seq_gen", sequenceName="ARTICLE_SEQ")
	private Long idArticle;

	@Column
	private Long categorie;
		
	@Column
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime published;

	public Dvd() {
		
	}
	
//	public Dvd(String title) throws IllegalArgumentException {
//		if (title == null || title.isEmpty()) {
//			throw new IllegalArgumentException("Title must not be empty");
//		}
//		setTitle(title);
//	}

	/**
	 * 
	 * @return
	 */
	public Long getIdArticle() {
		return idArticle;
	}

	/**
	 * 
	 * @param id
	 */
	public void setIdArticle(Long id) {
		this.idArticle = id;
	}

	/**
	 * @return the categorie
	 */
	public Long getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Long categorie) {
		this.categorie = categorie;
	}

	/**
	 * 
	 * @return
	 */
	public DateTime getPublished() {
		return published;
	}

	/**
	 * 
	 * @param published
	 */
	public void setPublished(DateTime published) {
		this.published = published;
	}

}

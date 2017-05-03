package net.joastbg.sampleapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

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
	@Enumerated(EnumType.ORDINAL)
	private DvdCategory category;
		
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

package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import javax.persistence.*;
import org.joda.time.DateTime;

import org.hibernate.annotations.Type;

/**
 * Describes a Disk
 * 
 * @author Johan Astborg <joastbg@gmail.com>
 */
@Entity
@Table(name="DISK")
public class Disk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1635687572249825983L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="article_seq_gen")
	@SequenceGenerator(name="article_seq_gen", sequenceName="ARTICLE_SEQ")
	private Long idArticle;

	@Column
	private Long idMusicien;

	@Column
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime published;

	public Disk() {
		
	}
	
//	public Disk(String title) throws IllegalArgumentException {
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
	 * @return the idMusicien
	 */
	public Long getIdMusicien() {
		return idMusicien;
	}

	/**
	 * @param idMusicien the idMusicien to set
	 */
	public void setIdMusicien(Long idMusicien) {
		this.idMusicien = idMusicien;
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

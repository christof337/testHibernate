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

	@Column
	private Long idArtist;
	
	@Column 
	@Enumerated(EnumType.ORDINAL)
	private MusicStyle musicStyle;

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
	 * @return the idArtist
	 */
	public Long getIdArtist() {
		return idArtist;
	}

	/**
	 * @param idMusicien the idMusicien to set
	 */
	public void setIdArtist(Long idArtist) {
		this.idArtist = idArtist;
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

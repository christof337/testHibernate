package net.joastbg.sampleapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Describes a Disk
 * 
 * @author Charlotte Cavalier <charlotte.cavalier@gmail.com>
 */
@Entity
@SequenceGenerator(name="SEQ_ARTICLE",sequenceName="SEQ_DB_NAME")
@Table(name="DISK")
public class Disk extends Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1635687572249825983L;

	@Column
	private Long idArtist;
	
	@Column(name = "style")
	@Enumerated(EnumType.STRING)
	private MusicStyle musicStyle;

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
	 * @return the musicStyle
	 */
	public MusicStyle getMusicStyle() {
		return musicStyle;
	}

	/**
	 * @param musicStyle the musicStyle to set
	 */
	public void setMusicStyle(MusicStyle musicStyle) {
		this.musicStyle = musicStyle;
	}
}

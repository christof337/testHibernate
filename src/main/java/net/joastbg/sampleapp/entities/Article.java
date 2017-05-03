package net.joastbg.sampleapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Describes an Article
 * 
 * @Article Christophe Pont <christof337@hotmail.fr>
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="ARTICLE")
public class Article implements Serializable, Comparable<Article> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2950938335694212226L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="article_seq")
	@SequenceGenerator(
		name="article_seq",
		sequenceName="article_sequence",
		allocationSize=20
	)
	@Column
	private Long idArticle;

	@Column
	private Float price;
	
	@Column
	private String description;
	
	public Article() {
		
	}

	public Article(String description, Float price) throws IllegalArgumentException {
		if (description == null || description.isEmpty() || price == null) {
			throw new IllegalArgumentException("Description nor price must not be empty");
		}
		setPrice(price);
		setDescription(description);
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String firstName) {
		this.description = firstName;
	}

	@Override
	public int compareTo(Article o) {
		return o.getDescription().compareTo(this.getDescription()) + o.getPrice().compareTo(this.getPrice());
	}
	
}

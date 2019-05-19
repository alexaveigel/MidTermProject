package com.skilldistillery.beerlab.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "favorite_beer")
public class FavoriteBeer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@Column(name = "beer_id")
//	private int beerId;

	@Column(name = "date_added")
	@Temporal(TemporalType.DATE)
	private Date dateAdded;

	private String comment;

	@ManyToOne
	@JoinColumn(name = "drinker_id")
	private Drinker drinker;
	
	@ManyToOne
	@JoinColumn(name = "beer_id")
	private Beer beer;
	
	
	
	public Beer getBeer() {
		return beer;
	}

	public void setBeer(Beer beer) {
		this.beer = beer;
	}

	public Drinker getDrinker() {
		return drinker;
	}

	public void setDrinker(Drinker drinker) {
		this.drinker = drinker;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beer == null) ? 0 : beer.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result + ((drinker == null) ? 0 : drinker.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoriteBeer other = (FavoriteBeer) obj;
		if (beer == null) {
			if (other.beer != null)
				return false;
		} else if (!beer.equals(other.beer))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (drinker == null) {
			if (other.drinker != null)
				return false;
		} else if (!drinker.equals(other.drinker))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FavoriteBeer [id=" + id + ", dateAdded=" + dateAdded + ", comment=" + comment + ", drinker=" + drinker
				+ ", beer=" + beer + "]";
	}

	public FavoriteBeer() {
		super();
	}

}

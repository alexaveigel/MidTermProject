package com.skilldistillery.beerlab.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "favorite_beer")
public class FavoriteBeer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "drinker_id")
	private int drinkerId;

	@Column(name = "beer_id")
	private int beerId;

	@Column(name = "date_added")
	@Temporal(TemporalType.DATE)
	private Date dateAdded;

	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDrinkerId() {
		return drinkerId;
	}

	public void setDrinkerId(int drinkerId) {
		this.drinkerId = drinkerId;
	}

	public int getBeerId() {
		return beerId;
	}

	public void setBeerId(int beerId) {
		this.beerId = beerId;
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
		result = prime * result + beerId;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result + drinkerId;
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
		if (beerId != other.beerId)
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
		if (drinkerId != other.drinkerId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FavoriteBeer [id=" + id + ", drinkerId=" + drinkerId + ", beerId=" + beerId + ", dateAdded=" + dateAdded
				+ ", comment=" + comment + "]";
	}

	public FavoriteBeer(int id, int drinkerId, int beerId, Date dateAdded, String comment) {
		super();
		this.id = id;
		this.drinkerId = drinkerId;
		this.beerId = beerId;
		this.dateAdded = dateAdded;
		this.comment = comment;
	}

	public FavoriteBeer() {
		super();
	}

}

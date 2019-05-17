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
@Table(name="favorite_bar")
public class FavoriteBar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "bar_id")
	private int barId;

	@Column(name = "drinker_id")
	private int drinkerId;
	
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

	public int getBarId() {
		return barId;
	}

	public void setBarId(int barId) {
		this.barId = barId;
	}

	public int getDrinkerId() {
		return drinkerId;
	}

	public void setDrinkerId(int drinkerId) {
		this.drinkerId = drinkerId;
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
	public String toString() {
		return "FavoriteBar [id=" + id + ", barId=" + barId + ", drinkerId=" + drinkerId + ", dateAdded=" + dateAdded
				+ ", comment=" + comment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + barId;
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
		FavoriteBar other = (FavoriteBar) obj;
		if (barId != other.barId)
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
	
	
}

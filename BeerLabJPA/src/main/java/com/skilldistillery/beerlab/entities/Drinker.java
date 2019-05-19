package com.skilldistillery.beerlab.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;



@Entity
public class Drinker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private String gender;
	
	@Column(name = "beer_style")
	private String beerStyle;
	
	@Column(name = "pic_url")
	private String picUrl;
	
	@Column(name = "address_id")
	private int addressId;

	@ManyToMany
	@JoinTable(name = "favorite_beer", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "drinker_id"))
	private List<FavoriteBeer> favBeer;
	
	
	public List<FavoriteBeer> getFavBeer() {
		return favBeer;
	}

	public void setFavBeer(List<FavoriteBeer> favBeer) {
		this.favBeer = favBeer;
	}

	public Drinker() {
		super();
	}

	public Drinker(int id, User user, String firstName, String lastName, Date dob, String gender, String beerStyle,
			String picUrl, int addressId) {
		super();
		this.id = id;
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.beerStyle = beerStyle;
		this.picUrl = picUrl;
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Drinker [id=" + id + ", user=" + user + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dob=" + dob + ", gender=" + gender + ", beerStyle=" + beerStyle + ", picUrl=" + picUrl
				+ ", addressId=" + addressId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + ((beerStyle == null) ? 0 : beerStyle.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((favBeer == null) ? 0 : favBeer.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((picUrl == null) ? 0 : picUrl.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Drinker other = (Drinker) obj;
		if (addressId != other.addressId)
			return false;
		if (beerStyle == null) {
			if (other.beerStyle != null)
				return false;
		} else if (!beerStyle.equals(other.beerStyle))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (favBeer == null) {
			if (other.favBeer != null)
				return false;
		} else if (!favBeer.equals(other.favBeer))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (picUrl == null) {
			if (other.picUrl != null)
				return false;
		} else if (!picUrl.equals(other.picUrl))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBeerStyle() {
		return beerStyle;
	}

	public void setBeerStyle(String beerStyle) {
		this.beerStyle = beerStyle;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
}

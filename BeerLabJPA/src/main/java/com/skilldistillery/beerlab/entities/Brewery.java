package com.skilldistillery.beerlab.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Brewery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "logo_url")
	private String logoUrl;
	
	@Column(name = "website_url")
	private String webUrl;
	
	// We may not need the Cascade Persist
	// One to One unidirectional with Address
	// Deleted regular field called addressId so this field wouldn't conflict
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name= "address_id")
	private Address address;
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	

	@Override
	public String toString() {
		return "Brewery [id=" + id + ", name=" + name + ", logoUrl=" + logoUrl + ", webUrl=" + webUrl + ", address="
				+ address + "]";
	}

	public Brewery() {
		super();
	}

	public Brewery(int id, String name, String logoUrl, String webUrl, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.logoUrl = logoUrl;
		this.webUrl = webUrl;
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((logoUrl == null) ? 0 : logoUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((webUrl == null) ? 0 : webUrl.hashCode());
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
		Brewery other = (Brewery) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (logoUrl == null) {
			if (other.logoUrl != null)
				return false;
		} else if (!logoUrl.equals(other.logoUrl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (webUrl == null) {
			if (other.webUrl != null)
				return false;
		} else if (!webUrl.equals(other.webUrl))
			return false;
		return true;
	}
	
	



	
	
	
	
}

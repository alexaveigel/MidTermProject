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
public class Bar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String message;

//	@Column(name = "address_id")
//	private int addressId;

	@Column(name = "website_url")
	private String webUrl;

	@Column(name = "logo_url")
	private String logoUrl;
	
	// One to One unidirectional with Address
	// Deleted regular field called addressId so this field wouldn't conflict
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name= "address_id")
	private Address address;
	
	
	

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Bar() {
		super();
	}

	public Bar(int id, String name, String message, String webUrl, String logoUrl, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.webUrl = webUrl;
		this.logoUrl = logoUrl;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Bar [id=" + id + ", name=" + name + ", message=" + message + ", webUrl=" + webUrl + ", logoUrl="
				+ logoUrl + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((logoUrl == null) ? 0 : logoUrl.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		Bar other = (Bar) obj;
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
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
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

package com.skilldistillery.beerlab.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String message;

	@Column(name = "address_id")
	private int addressId;

	@Column(name = "website_url")
	private String webUrl;

	@Column(name = "logo_url")
	private String logoUrl;

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

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
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
		if (addressId != other.addressId)
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

	@Override
	public String toString() {
		return "Bar [id=" + id + ", name=" + name + ", message=" + message + ", addressId=" + addressId + ", webUrl="
				+ webUrl + ", logoUrl=" + logoUrl + "]";
	}

	public Bar(int id, String name, String message, int addressId, String webUrl, String logoUrl) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.addressId = addressId;
		this.webUrl = webUrl;
		this.logoUrl = logoUrl;
	}

	public Bar() {
		super();
	}

}

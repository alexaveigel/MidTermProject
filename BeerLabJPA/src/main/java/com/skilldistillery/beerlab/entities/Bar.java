package com.skilldistillery.beerlab.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Bar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String message;

	@Column(name = "website_url")
	private String webUrl;

	@Column(name = "logo_url")
	private String logoUrl;
	
	// __________________________________
	
	
	@ManyToMany(mappedBy="bars", fetch = FetchType.EAGER)
	private List<Beer> beers;
	
	
	public void addBeer(Beer beer) {
		if (beers  == null) beers = new ArrayList<>();
	
		
		if(!beers.contains(beer)) {
			beers.add(beer);
			beer.addBar(this);
		}
	}
	
	public void removeBeer(Beer beer) {
		beer.setBars(null);
		if(beers != null) {
			beers.remove(beer);
		}
	}


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

	public List<Beer> getBeers() {
		return beers;
	}

	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Bar other = (Bar) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bar [id=" + id + ", name=" + name + ", message=" + message + ", webUrl=" + webUrl + ", logoUrl="
				+ logoUrl + ", address=" + address + "]";
	}

	public Bar(int id, String name, String message, String webUrl, String logoUrl, List<Beer> beers, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.webUrl = webUrl;
		this.logoUrl = logoUrl;
		this.beers = beers;
		this.address = address;
	}

	public Bar() {
		super();
	}
	
	



}

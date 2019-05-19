 package com.skilldistillery.beerlab.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Beer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String style;

	private String name;

	private double abv;

	private String description;
	
	private int approved;

	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "bar_inventory",
	joinColumns =@JoinColumn(name = "beer_id"),
	inverseJoinColumns =@JoinColumn(name = "bar_id"))
	private List<Bar> bars;
	
	public void addBar(Bar bar) {
		if(bars == null) bars = new ArrayList<>();
		
		if (!bars.contains(bar)) {
			bars.add(bar);
			if(bar != null) {
			 bar.getBeers().remove(this);
			}
			bar.addBeer(this);
		}
		
	}
	
	public void removeBar(Bar bar) {
		bar.setBeers(null);
		if(bars != null) {
			bars.remove(bar);
		}
	}

	
	@ManyToOne
	@JoinColumn(name = "brewery_id")
	private Brewery brewery;
	
	@OneToMany(mappedBy = "beer")
	private List<FavoriteBeer> listFavBeers;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public List<Bar> getBars() {
		return bars;
	}

	public void setBars(List<Bar> bars) {
		this.bars = bars;
	}

	public Brewery getBrewery() {
		return brewery;
	}

	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}

	public List<FavoriteBeer> getListFavBeers() {
		return listFavBeers;
	}

	public void setListFavBeers(List<FavoriteBeer> listFavBeers) {
		this.listFavBeers = listFavBeers;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", style=" + style + ", name=" + name + ", abv=" + abv + ", description="
				+ description + ", approved=" + approved + ", bars=" + bars + ", brewery=" + brewery + "]";
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
		Beer other = (Beer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Beer(int id, String style, String name, double abv, String description, int approved, List<Bar> bars,
			Brewery brewery, List<FavoriteBeer> listFavBeers) {
		super();
		this.id = id;
		this.style = style;
		this.name = name;
		this.abv = abv;
		this.description = description;
		this.approved = approved;
		this.bars = bars;
		this.brewery = brewery;
		this.listFavBeers = listFavBeers;
	}

	public Beer() {
		super();
	}

	
	
}

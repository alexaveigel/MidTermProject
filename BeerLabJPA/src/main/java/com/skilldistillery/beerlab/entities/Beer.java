package com.skilldistillery.beerlab.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Beer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String style;
	
	private String name;
	
	private double abv;
	
//	@Column(name = "brewery_id")
//	private int breweryId;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "brewery_id")
	private Brewery brewery;
	

	public Brewery getBrewery() {
		return brewery;
	}

	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}
	
	

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


	public Beer(int id, String style, String name, double abv, String description, Brewery brewery) {
		super();
		this.id = id;
		this.style = style;
		this.name = name;
		this.abv = abv;
		this.description = description;
		this.brewery = brewery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(abv);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((brewery == null) ? 0 : brewery.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((style == null) ? 0 : style.hashCode());
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
		if (Double.doubleToLongBits(abv) != Double.doubleToLongBits(other.abv))
			return false;
		if (brewery == null) {
			if (other.brewery != null)
				return false;
		} else if (!brewery.equals(other.brewery))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", style=" + style + ", name=" + name + ", abv=" + abv + ", description="
				+ description + ", brewery=" + brewery + "]";
	}

	public Beer() {
		super();
	}

}

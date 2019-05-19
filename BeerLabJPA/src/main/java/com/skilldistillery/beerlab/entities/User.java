package com.skilldistillery.beerlab.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	private String password;

	private String role;

	@OneToOne(mappedBy = "user")
	private Drinker drinker;
	
	
	// ************************************
	
//	@ManyToMany(cascade = CascadeType.PERSIST)
//	@JoinTable(name = "bar_owner", joinColumns = @JoinColumn(name = "bar_id"), 
//	inverseJoinColumns = @JoinColumn(name = "user_id"))
//	private List<Bar> bars;


	// ***************************************
	
//	public List<Bar> getBars() {
//		return bars;
//	}
//
//	public void setBars(List<Bar> bars) {
//		this.bars = bars;
//	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}

	public User(int id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	}

}

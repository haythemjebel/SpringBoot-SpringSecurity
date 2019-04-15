package com.haythem.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	private String username;
	private String password;
	private Boolean actived;
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Role> roles;

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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public User() {

	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, Boolean actived) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
	}

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
	}

}

package com.tts.eCommerce.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;

	@Email(message = "Please provide a valid email")
	@NotEmpty(message = "Please provide an email")
	private String email;

	@Length(min = 5, message = "A username must have at least 5 characters")
	@Length(max = 15, message = "A username cannot have more than 15 characters")
	@Pattern(regexp = "[^\\s]+", message = "A username cannot contain spaces")
	private String username;

	@Length(min = 10, message = "A password must have at least 10 characters")
	private String password;

	@NotEmpty(message = "Please provide your full name")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_admin", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "admin_id"))
	private List<User> admins;

	private User() {}

	private User(Long id,
			@Email(message = "Please provide a valid email") @NotEmpty(message = "Please provide an email") String email,
			@Length(min = 5, message = "A username must have at least 5 characters") @Length(max = 15, message = "A username cannot have more than 15 characters") @Pattern(regexp = "[^\\s]+", message = "A username cannot contain spaces") String username,
			@Length(min = 5, message = "A password must have at least 5 characters") String password,
			@NotEmpty(message = "Please provide your full name") String name, Set<Role> roles, List<User> admins) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.name = name;
		this.roles = roles;
		this.admins = admins;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<User> getAdmins() {
		return admins;
	}

	public void setAdmins(List<User> admins) {
		this.admins = admins;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password + ", name="
				+ name + ", roles=" + roles + ", admins=" + admins + "]";
	}

}

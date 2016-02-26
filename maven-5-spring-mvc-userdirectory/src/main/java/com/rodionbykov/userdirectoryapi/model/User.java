package com.rodionbykov.userdirectoryapi.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="users",uniqueConstraints=@UniqueConstraint(columnNames={"login"}))
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique=true, name="login")
	@NotEmpty
	private String login;
	
	@Column(name="passwd")
	@NotEmpty
	private String passwd;
	
	@Column(name="firstname")	
	private String firstname;
	
	@Column(name="lastname")	
	private String lastname;
	
	@Column(name="level")	
	@Min(value=0)
	@Max(value=30)
	private int level;

	@Column(name="securitytoken")
	private String securityToken;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getSecurityToken() {
		return securityToken;
	}

	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

}
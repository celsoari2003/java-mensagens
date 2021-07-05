package br.com.atlantico.consumer.consumer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "USER")
public class User {

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, String login, String password, Date createdDate, Date updatedDate,
			String email, boolean admin) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.email = email;
		this.admin = admin;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	private String login;
	private String password;
	private Date createdDate;
	private Date updatedDate;
	private String email;
	private boolean admin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updateDate) {
		this.updatedDate = updateDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}

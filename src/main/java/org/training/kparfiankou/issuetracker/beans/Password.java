package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Passwords")
public class Password extends AbstractEntity {

	@OneToOne
	@MapsId
	private User user;
	@Column(name="password")
	private String password;

	/**
	 * The default constructor.
	 */
	public Password() {		
	}

	/**
	 * @param user the user to set 
	 * @param password the password to set
	 */
	public Password(User user, String password) {
		this.user = user;
		this.password = password;
		setId(user.getId());
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
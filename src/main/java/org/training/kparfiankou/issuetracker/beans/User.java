package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
@Table(name = "Users")
public class User extends AbstractEntity {

	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "emailAddress")
	private String emailAddress;
	@Column(name = "role")
	private Role role;

	/**
	 * @param id the id to set
	 */
	public User(long id) {
		super(id);
	}

	/**
	 * @param id the id to set
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 * @param emailAddress the email address to set
	 * @param role the role to set
	 */
	public User(long id, String firstName, String lastName,
			String emailAddress, Role role) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.role = role;
	}


	/**
	 * @return String
	 */
	public String toString() {
		return firstName + " " + lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}
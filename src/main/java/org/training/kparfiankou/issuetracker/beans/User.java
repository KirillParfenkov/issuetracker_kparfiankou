package org.training.kparfiankou.issuetracker.beans;


/**
 * @author Kiryl_Parfiankou
 *
 */
public class User extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String emailAddress;
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
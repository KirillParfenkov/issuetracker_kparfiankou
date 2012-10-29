package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Role;
import org.training.kparfiankou.issuetracker.beans.User;

/**
 * @author theparf
 *
 */
public interface IUserDAO {

	/**
	 * @return List of existing users.
	 */
	List<User> getListUser();

	/**
	 * @param id Unique object identifier.
	 * @return Object of class User.
	 */
	User getUser(int id);

	/**
	 * @param emailAddress email address of user.
	 * @return Object of class User.
	 */
	User getUser(String emailAddress);

	/**
	 * @param lastName set last name new user
	 * @param firstName set first name new user
	 * @param role set role new user
	 * @param emailAddress set email address new user
	 * @param password set password new user
	 */
	void inserUser(String lastName,
				   String firstName,
				   Role role,
				   String emailAddress,
				   String password);

	/**
	 * @param id if of user
	 */
	void removeUser(int id);

	/**
	 * @param emailAddres email address of user.
	 * @param password password of user.
	 * @return Object of class of class User.
	 */
	User authenticate(String emailAddres, String password);

	/**
	 * Close DAO.
	 */
	void close();

}
package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

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
	 * @param password the password of user.
	 * @param user object of type User.
	 */
	void inserUser(User user, String password);

	/**
	 * @param user object of class User
	 */
	void updateUser(User user);

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
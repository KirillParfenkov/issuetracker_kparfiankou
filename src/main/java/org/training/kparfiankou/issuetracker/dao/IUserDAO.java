package org.training.kparfiankou.issuetracker.dao;

import java.util.List;
import java.util.Map;

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
	User getUser(long id);

	/**
	 * @param emailAddress email address of user.
	 * @return Object of class User.
	 */
	User getUser(String emailAddress);

	/**
	 * @param password the password of user.
	 * @param user object of type User.
	 */
	void insertUser(User user, String password);

	/**
	 * @param user object of class User
	 */
	void updateUser(User user);

	/**
	 * @param id if of user
	 */
	void removeUser(long id);

	/**
	 * @param emailAddres email address of user.
	 * @param password password of user.
	 * @return Object of class of class User.
	 */
	User authenticate(String emailAddres, String password);

	/**
	 * @return max index;
	 */
	long getMaxIndex();

	/**
	 * Close DAO.
	 */
	void close();

	/**
	 * @param map keys of search.
	 * @return List of existing users.
	 */
	List<User> searchUsers(Map<String, String> map);

	/**
	 * @param id id of user.
	 * @param password password of user.
	 */
	void newPassword(long id, String password);

}
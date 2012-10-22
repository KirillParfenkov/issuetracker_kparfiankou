package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.User;

/**
 * @author theparf
 *
 */
public interface IUserDAO {
	/**
	 *
	 * @return List of existing users.
	 */
	List<User> getListUser();
	/**
	 *
	 * @param id Unique object identifier.
	 * @return Object of class User.
	 */
	User getUser(int id);

	/**
	 *
	 * @param emailAddres email address of user.
	 * @param password password of user.
	 * @return Object of class of class User.
	 */
	User authenticate(String emailAddres, String password);
}
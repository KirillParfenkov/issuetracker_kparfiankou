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
	public List<User> getListUser();
	/**
	 * 
	 * @param id Unique object identifier.
	 * @return Object of class User.
	 */
	public User getUser(int id);
}

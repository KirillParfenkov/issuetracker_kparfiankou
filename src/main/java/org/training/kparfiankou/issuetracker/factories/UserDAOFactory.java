package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.UserXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 *
 * @author parf
 *
 */
public final class UserDAOFactory {

	private static IUserDAO userDAO;

	private UserDAOFactory() {
		// Prevent instantiation
	}

	/**
	 *
	 * @return IUserDAO
	 */
	public static IUserDAO getClassFromFactory() {

		if (userDAO == null) {
			userDAO = new UserXMLDAO();
		}

		return userDAO;
	}
}
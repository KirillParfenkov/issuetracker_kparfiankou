package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.UserXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 *
 * @author parf
 *
 */
public class UserDAOFactory {

	private static IUserDAO userDAO;

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
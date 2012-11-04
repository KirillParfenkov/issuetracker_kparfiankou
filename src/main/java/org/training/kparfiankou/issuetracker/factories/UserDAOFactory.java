package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.database.UserDatabaseDAO;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 *
 * @author parf
 *
 */
public final class UserDAOFactory {

	private UserDAOFactory() {
		// Prevent instantiation
	}

	/**
	 * @return IUserDAO
	 */
	public static IUserDAO getClassFromFactory() {

		return new UserDatabaseDAO();
	}
}
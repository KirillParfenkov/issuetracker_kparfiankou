package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.dao.hibernate.UserHibernateDAO;
import org.training.kparfiankou.issuetracker.dao.IUserDAO;

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

		return new UserHibernateDAO();
	}
}
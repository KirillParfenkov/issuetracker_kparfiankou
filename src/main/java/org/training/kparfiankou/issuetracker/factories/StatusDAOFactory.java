package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.dao.hibernate.StatusHibernateDAO;
import org.training.kparfiankou.issuetracker.dao.IStatusDAO;

/**
 *
 * @author parf
 *
 */
public final class StatusDAOFactory {

	private StatusDAOFactory() {
		// Prevent instantiation
	}

	/**
	 * @return IStatusDAO
	 */
	public static IStatusDAO getClassFromFactory() {

		return new StatusHibernateDAO();
	}
}
package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.dao.hibernate.PriorityHibernateDAO;
import org.training.kparfiankou.issuetracker.dao.IPriorityDAO;

/**
 *
 * @author parf
 *
 */
public final class PriorityDAOFactory {

	private PriorityDAOFactory() {
		// Prevent instantiation
	}

	/**
	 * @return IPriorityDAO
	 */
	public static IPriorityDAO getClassFromFactory() {

		return new PriorityHibernateDAO();
	}
}
package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.dao.hibernate.ResolutionHibernateDAO;
import org.training.kparfiankou.issuetracker.dao.IResolutionDAO;

/**
 *
 * @author parf
 *
 */
public final class ResolutionDAOFactory {

	private ResolutionDAOFactory() {
		// Prevent instantiation
	}

	/**
	 * @return IResolutionDAO
	 */
	public static IResolutionDAO getClassFromFactory() {

		return new ResolutionHibernateDAO();
	}
}
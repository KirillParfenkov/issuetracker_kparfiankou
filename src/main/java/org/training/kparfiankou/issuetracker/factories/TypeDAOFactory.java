package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.dao.hibernate.TypeHibernateDAO;
import org.training.kparfiankou.issuetracker.dao.ITypeDAO;

/**
 *
 * @author parf
 *
 */
public final class TypeDAOFactory {

	private TypeDAOFactory() {
		// Prevent instantiation
	}

	/**
	 * @return ITypeDAO
	 */
	public static ITypeDAO getClassFromFactory() {

		return new TypeHibernateDAO();
	}
}
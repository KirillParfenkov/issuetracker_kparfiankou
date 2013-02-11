package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.database.TypeDatabaseDAO;
import org.training.kparfiankou.issuetracker.impl.hibernate.TypeHibernateDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;

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
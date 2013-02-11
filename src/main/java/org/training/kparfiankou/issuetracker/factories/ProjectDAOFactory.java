package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.database.ProjectDatabaseDAO;
import org.training.kparfiankou.issuetracker.impl.hibernate.ProjectHibernateDAO;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;

/**
 *
 * @author parf
 *
 */
public final class ProjectDAOFactory {

	private ProjectDAOFactory() {
		// Prevent instantiation
	}

	/**
	 * @return IProjectDAO
	 */
	public static IProjectDAO getClassFromFacroty() {

		return new ProjectHibernateDAO();
	}

}
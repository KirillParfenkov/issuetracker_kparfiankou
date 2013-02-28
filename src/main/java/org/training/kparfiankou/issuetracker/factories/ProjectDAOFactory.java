package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.dao.hibernate.ProjectHibernateDAO;
import org.training.kparfiankou.issuetracker.dao.IProjectDAO;

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
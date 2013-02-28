package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.dao.hibernate.IssueHibernateDAO;
import org.training.kparfiankou.issuetracker.dao.IIssueDAO;

/**
 *
 * @author parf
 *
 */
public final class IssueDAOFactory {

	private IssueDAOFactory() {
		// Prevent instantiation
	}

	/**
	 * @return IIssueDAO
	 */
	public static IIssueDAO getClassFromFactory() {

		return new IssueHibernateDAO();
	}
}
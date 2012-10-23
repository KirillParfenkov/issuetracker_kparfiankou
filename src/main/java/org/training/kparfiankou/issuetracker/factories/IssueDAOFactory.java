package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.xml.IssueXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;

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
	 *
	 * @return IIssueDAO
	 */
	public static IIssueDAO getClassFromFactory() {

		return new IssueXMLDAO();
	}
}
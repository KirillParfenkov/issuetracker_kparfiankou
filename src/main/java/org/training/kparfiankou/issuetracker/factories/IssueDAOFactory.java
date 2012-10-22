package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.IssueXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;

/**
 *
 * @author parf
 *
 */
public class IssueDAOFactory {
	/**
	 *
	 * @return IIssueDAO
	 */
	public static IIssueDAO getClassFromFactory() {

		return new IssueXMLDAO();
	}
}
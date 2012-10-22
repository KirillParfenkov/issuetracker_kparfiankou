package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.StatusXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;
/**
 *
 * @author parf
 *
 */
public final class StatusDAOFactory {

	private static IStatusDAO statusDAO;

	private StatusDAOFactory() {
		// Prevent instantiation
	}

	/**
	 *
	 * @return IStatusDAO
	 */
	public static IStatusDAO getClassFromFactory() {

		if (statusDAO == null) {
			statusDAO = new StatusXMLDAO();
		}
		return statusDAO;
	}
}
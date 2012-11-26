package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.database.StatusDatabaseDAO;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;

/**
 *
 * @author parf
 *
 */
public final class StatusDAOFactory {

	private StatusDAOFactory() {
		// Prevent instantiation
	}

	/**
	 * @return IStatusDAO
	 */
	public static IStatusDAO getClassFromFactory() {

		return new StatusDatabaseDAO();
	}
}
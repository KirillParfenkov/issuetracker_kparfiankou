package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.xml.PriorityXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;

/**
 *
 * @author parf
 *
 */
public final class PriorityDAOFactory {

	private PriorityDAOFactory() {
		// Prevent instantiation
	}

	/**
	 * @return IPriorityDAO
	 */
	public static IPriorityDAO getClassFromFactory() {

		return new PriorityXMLDAO();
	}
}
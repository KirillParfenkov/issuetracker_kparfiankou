package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.xml.PriorityXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
/**
 *
 * @author parf
 *
 */
public final class PriorityDAOFactory {

	private static IPriorityDAO priorityDAO;

	private PriorityDAOFactory() {
		// Prevent instantiation
	}

	/**
	 *
	 * @return IPriorityDAO
	 */
	public static IPriorityDAO getClassFromFactory() {

		if (priorityDAO == null) {
			priorityDAO = new PriorityXMLDAO();
		}

		return priorityDAO;
	}
}
package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.PriorityXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
/**
 *
 * @author parf
 *
 */
public class PriorityDAOFactory {

	private static IPriorityDAO priorityDAO;
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
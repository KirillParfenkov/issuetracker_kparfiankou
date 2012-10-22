package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.ProjectXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;
/**
 *
 * @author parf
 *
 */
public class ProjectDAOFactory {

	private static IProjectDAO projectDAO;

	/**
	 *
	 * @return IProjectDAO
	 */
	public static IProjectDAO getClassFromFacroty() {

		if (projectDAO == null) {
			projectDAO = new ProjectXMLDAO();
		}

		return projectDAO;
	}

}
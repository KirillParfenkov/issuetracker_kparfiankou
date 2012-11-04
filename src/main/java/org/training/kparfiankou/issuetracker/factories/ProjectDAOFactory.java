package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.xml.ProjectXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;

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

		return new ProjectXMLDAO();
	}

}
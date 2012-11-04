package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.xml.ResolutionXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;

/**
 *
 * @author parf
 *
 */
public final class ResolutionDAOFactory {

	private ResolutionDAOFactory() {
		// Prevent instantiation
	}

	/**
	 * @return IResolutionDAO
	 */
	public static IResolutionDAO getClassFromFactory() {

		return new ResolutionXMLDAO();
	}
}
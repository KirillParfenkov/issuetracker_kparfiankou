package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.ResolutionXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;

/**
 *
 * @author parf
 *
 */
public final class ResolutionDAOFactory {

	private static IResolutionDAO resolutionDAO;

	private ResolutionDAOFactory() {
		// Prevent instantiation
	}

	/**
	 *
	 * @return IResolutionDAO
	 */
	public static IResolutionDAO getClassFromFactory() {

		if (resolutionDAO == null) {
			resolutionDAO = new ResolutionXMLDAO();
		}
		return resolutionDAO;
	}

}
package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.TypeXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;

/**
 *
 * @author parf
 *
 */
public final class TypeDAOFactory {

	private static ITypeDAO typeDAO = null;

	private TypeDAOFactory() {
		// Prevent instantiation
	}

	/**
	 *
	 * @return ITypeDAO
	 */
	public static ITypeDAO getClassFromFactory() {
		if (typeDAO == null) {
			typeDAO = new TypeXMLDAO();
		}
		return typeDAO;
	}
}
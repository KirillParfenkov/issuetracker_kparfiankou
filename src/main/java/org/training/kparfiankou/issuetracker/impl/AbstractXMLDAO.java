package org.training.kparfiankou.issuetracker.impl;

/**
 *
 * @author Kiryl_Parfiankou
 *
 */
public abstract class AbstractXMLDAO {

	private static final String NAME_PROJECT_ROOT = "/";
	private String xmlDirectoryPath = getClass().getResource(NAME_PROJECT_ROOT).getPath() + "/dataXML/";

	/**
	 *
	 * @return get XML Directory path.
	 */
	public String getXmlDirectoryPath() {
		return xmlDirectoryPath;
	}
}
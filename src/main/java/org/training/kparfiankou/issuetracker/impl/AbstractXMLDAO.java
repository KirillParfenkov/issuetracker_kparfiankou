package org.training.kparfiankou.issuetracker.impl;

public abstract class AbstractXMLDAO {

	private static final String NAME_PROJECT_ROOT = "/";
	private String xmlDirectoryPath = getClass().getResource(NAME_PROJECT_ROOT).getPath() + "/dataXML/";

	public String getXmlDirectoryPath() {
		return xmlDirectoryPath;
	}
}
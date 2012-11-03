package org.training.kparfiankou.issuetracker.impl.xml;

import java.io.IOException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.impl.xml.handlers.ProjectXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Kiryl_Parfiankou
 *
 */
public class ProjectXMLDAO extends AbstractXMLDAO implements IProjectDAO {

	private static final String TYPE_XML_FILE_NAME = "projects.xml";
	private List<Project> projects;
	private ProjectXMLHandler handler;

	/**
	 * Default constructor.
	 */
	public ProjectXMLDAO() {

		try {

			String realPath = getXmlDirectoryPath() + TYPE_XML_FILE_NAME;

			XMLReader reader = XMLReaderFactory.createXMLReader();
			handler = new ProjectXMLHandler();

			reader.setContentHandler(handler);
			reader.parse(realPath);

			projects = handler.getProjects();

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Project> getListProject() {

		return projects;
	}

	@Override
	public Project getProject(int id) {

		for (Project project: projects) {
			if (project.getId() == id) {
				return project;
			}
		}

		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertProject(Project project) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeProject(int id) {
		// TODO Auto-generated method stub
	}
}
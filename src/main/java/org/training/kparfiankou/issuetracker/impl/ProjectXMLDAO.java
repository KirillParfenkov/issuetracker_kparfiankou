package org.training.kparfiankou.issuetracker.impl;

import java.io.IOException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.impl.xmlhandlers.ProjectXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ProjectXMLDAO extends AbstractXMLDAO implements IProjectDAO{
	
	private List<Project> projects;
	ProjectXMLHandler handler;
	private final static String TYPE_XML_FILE_NAME = "projects.xml";
	
	
	public ProjectXMLDAO(){
		
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

	public List<Project> getListProject() {

		return projects;
	}

	
	public Project getProject(int id) {
	
		for (Project project: projects){
			if (project.getId() == id){
				return project;
			}
		}
		
		return null;
	}
}

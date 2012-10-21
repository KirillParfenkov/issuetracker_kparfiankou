package org.training.kparfiankou.issuetracker.impl.xmlhandlers;

import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Build;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ProjectXMLHandler extends DefaultHandler{
	
	private enum Node{
		PROJECTS,
		PROJECT,
		DESCRIPTION,
		BUILD,
		BUILDS
	}
	
	private final static int ID = 0;
	private final static int NAME = 1;
	private final static int ID_MENAGER = 2;
	
	private IUserDAO userDAO;
	private Project currentEntity;
	private Node currentNode;
	private List<Project> projects;
	
	public ProjectXMLHandler(){
		
		userDAO = UserDAOFactory.getClassFromFactory();
		projects = new ArrayList<Project>();
		
	}
	
	public List<Project> getProjects(){
		return projects;
	}
	
	public void startElement(String uri, String localName,
			  String qName, Attributes attrs) throws SAXException{
		
		currentNode = Node.valueOf(localName.toUpperCase()); 
		
		if (currentNode.equals(Node.PROJECT)){
			
			User menager = userDAO.getUser(Integer.valueOf(attrs.getValue(ID_MENAGER)));
		
			currentEntity = new Project(Integer.valueOf(attrs.getValue(ID)),
										attrs.getValue(NAME),
										menager);	
		}
		
		if(currentNode.equals(Node.BUILD)){
			currentEntity.addBuild(new Build(Integer.valueOf(attrs.getValue(ID)),
					                          attrs.getValue(NAME)));
			
		}
	}
	
	public void endElement(String uri, String localName, String qName){
		
		Node node = Node.valueOf(localName.toUpperCase());
		
		if(node.equals(Node.PROJECT)){
			projects.add(currentEntity);
		}
		
	}
	
	public void characters(char[] ch, int start,int length){
		
		if (currentNode.equals(Node.DESCRIPTION)){
			String str = new String(ch);
			currentEntity.setDescription(str.substring(start, start+length));
		}
		
	}
}
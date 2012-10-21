package org.training.kparfiankou.issuetracker.impl.xmlhandlers;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Build;
import org.training.kparfiankou.issuetracker.beans.Comment;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.factories.StatusDAOFactory;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class IssueXMLHandler extends DefaultHandler{
	
	private final static int ID = 0;
	private final static int STATUS = 1;
	private final static int TYPE = 2;
	private final static int PRIORITY = 3;
	private final static int PROJECT = 4;
	private final static int BUILD = 5;
	private final static int ASSIGNEE = 6;
	private final static int CREATE_DATA = 7;
	private final static int CREATER = 8;
	private final static int MODIFY_DATE = 9;
	private final static int LAST_MODIFIER = 10;
	private final static int RESOLUTION = 11;
	
	private enum Node{
		ISSUES,
		ISSUE,
		SUMMARY,
		DESCRIPTION,
		COMMENTS,
		COMMENT,
	}
	
	private Node currentNode;
	private Issue currentIssue;
	private Comment currentCommet;
	private StringBuffer strBuffer;
	private List<Issue> issues;
	
	private IStatusDAO statusDAO;
	private ITypeDAO typeDAO;
	private IPriorityDAO priorityDAO;
	private IProjectDAO projectDAO;
	private IUserDAO userDAO; 
	private IResolutionDAO resolutionDAO;
	private DateFormat dateFormat;
	
	public IssueXMLHandler(){
		
		issues = new ArrayList<Issue>();
		statusDAO = StatusDAOFactory.getClassFromFactory();
		typeDAO = TypeDAOFactory.getClassFromFactory();
		priorityDAO = PriorityDAOFactory.getClassFromFactory();
		projectDAO = ProjectDAOFactory.getClassFromFacroty();
		userDAO = UserDAOFactory.getClassFromFactory();
		resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
		dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		
	}
	
	public List<Issue>getIsssues(){
		return issues;
	}
	
	
	public void startElement(String uri, String localName,
			  String qName, Attributes attrs) throws SAXException{
		
		currentNode = Node.valueOf(localName.toUpperCase());
		
		if(currentNode.equals(Node.ISSUE)){
			try {
				
				int id = Integer.valueOf(attrs.getValue(ID));
				Status status = statusDAO.getStatus(Integer.valueOf(attrs.getValue(STATUS)));
				Type type = typeDAO.getType(Integer.valueOf(attrs.getValue(TYPE)));
				Priority priority = priorityDAO.getPriority(Integer.valueOf(attrs.getValue(PRIORITY)));
				Project project = projectDAO.getProject(Integer.valueOf(attrs.getValue(PROJECT)));
				Build build = project.getBuild(Integer.valueOf(attrs.getValue(BUILD)));
				User assignee = userDAO.getUser(Integer.valueOf(attrs.getValue(ASSIGNEE)));
				Date createDate = dateFormat.parse(attrs.getValue(CREATE_DATA));
				User creater = userDAO.getUser(Integer.valueOf(attrs.getValue(CREATER)));
				Date modifyDate = dateFormat.parse(attrs.getValue(MODIFY_DATE));
				User lastModifier = userDAO.getUser(Integer.valueOf(attrs.getValue(LAST_MODIFIER)));
				Resolution resolution = resolutionDAO.getResolution( Integer.valueOf(attrs.getValue(RESOLUTION)));
				
				currentIssue = new Issue(id);
				currentIssue.setStatus(status);
				currentIssue.setType(type);
				currentIssue.setPriority(priority);
				currentIssue.setProject(project);
				currentIssue.setBuild(build);
				currentIssue.setAssignee(assignee);
				currentIssue.setCreateDate(createDate);
				currentIssue.setCreater(creater);
				currentIssue.setModifyDate(modifyDate);
				currentIssue.setLastModifier(lastModifier);
				currentIssue.setResolution(resolution);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if(currentNode.equals(Node.COMMENT)){
			
			currentCommet = new Comment(Integer.valueOf(attrs.getValue(ID)));
			strBuffer = new StringBuffer();
		}
		
		if(currentNode.equals(Node.DESCRIPTION) || 
		   currentNode.equals(Node.SUMMARY)){
			
			strBuffer = new StringBuffer();
		}
		
	}
	
	public void characters(char[] ch, int start,int length){
			
		if (currentNode.equals(Node.DESCRIPTION)||
			currentNode.equals(Node.SUMMARY)||
			currentNode.equals(Node.COMMENT)){
			
			strBuffer.append(ch,start,length);
		}
	}
	
	public void endElement(String uri, String localName, String qName){
		
		Node node = Node.valueOf(localName.toUpperCase());
		
		if(node.equals(Node.ISSUE)){
			issues.add(currentIssue);
		}
		
		if(node.equals(Node.COMMENT)){
			currentCommet.setContent(strBuffer.toString());
			currentIssue.addCommet(currentCommet);
		}
		
		if(node.equals(Node.DESCRIPTION)){
			currentIssue.setDescription(strBuffer.toString());
		}
		
		if(node.equals(Node.SUMMARY)){
			currentIssue.setSummary(strBuffer.toString());
		}	
	}
}
package org.training.kparfiankou.issuetracker.impl;

import java.io.IOException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.impl.xmlhandlers.IssueXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class IssueXMLDAO extends AbstractXMLDAO implements IIssueDAO{
	
	private List<Issue> issues;
	private IssueXMLHandler handler;
	private static final String TYPE_XML_FILE_NAME = "issues.xml";
	private String realPath;
	
	
	public IssueXMLDAO(){
		
		realPath = getXmlDirectoryPath() + TYPE_XML_FILE_NAME;
		updateData();	
	}
	
	
	public void updateData(){
		
		try {
			
			XMLReader reader = XMLReaderFactory.createXMLReader();
			handler = new IssueXMLHandler();
			
			reader.setContentHandler(handler);
			reader.parse(realPath);
			
			issues = handler.getIsssues();
			
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Issue> getListIssue() {
		
		return issues;
	}

	
	public Issue getIssue(int id) {
		
		for (Issue issue: issues){
			if(issue.getId() == id){
				return issue;
			}
		}
		
		return null; // think here
	}

}
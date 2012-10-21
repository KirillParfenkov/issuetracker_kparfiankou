package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.IssueXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;

public class IssueDAOFactory {
	
	private static IIssueDAO issueDAO;
	
	public static IIssueDAO getClassFromFactory(){
		if (issueDAO == null){
			issueDAO = new IssueXMLDAO();
		}
		return issueDAO;
	}
}
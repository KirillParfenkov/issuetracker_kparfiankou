package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.IssueXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;

public class IssueDAOFactory {
	
	public static IIssueDAO getClassFromFactory(){
	
		return new IssueXMLDAO();
	}
}
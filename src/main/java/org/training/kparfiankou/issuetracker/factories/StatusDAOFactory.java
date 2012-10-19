package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.StatusXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;

public class StatusDAOFactory {
	
	private static IStatusDAO statusDAO;
	
	public static IStatusDAO getClassFromFactory(){
		if (statusDAO == null){
			statusDAO = new StatusXMLDAO();
		}
		return statusDAO;
	}

}

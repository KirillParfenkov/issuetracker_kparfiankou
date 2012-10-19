package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.ResolutionXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;

public class ResolutionDAOFactory {
	
	private static IResolutionDAO resolutionDAO;
	
	public static IResolutionDAO getClassFromFactory(){
		if (resolutionDAO == null){
			resolutionDAO = new ResolutionXMLDAO();
		}
		return resolutionDAO;
	}
	
}

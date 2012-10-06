package org.training.kparfiankou.issuetracker.factories;

import org.training.kparfiankou.issuetracker.impl.TypeXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;

public class TypeDAOFactory {
	
	private static ITypeDAO typeDAO = null;
	
	public static ITypeDAO getClassFromFactory(){
		if (typeDAO == null){
			typeDAO = new TypeXMLDAO();
		}
		return typeDAO;
	}
}

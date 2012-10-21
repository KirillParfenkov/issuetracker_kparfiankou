package org.training.kparfiankou.issuetracker.impl;

import java.io.IOException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.impl.xmlhandlers.UserXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class UserXMLDAO extends AbstractXMLDAO implements IUserDAO{
	
	private UserXMLHandler handler;
	private List<User> users;
	private final static String TYPE_XML_FILE_NAME = "users.xml";
	
	
	public UserXMLDAO(){
		
		try {
			
			String realPath = getXmlDirectoryPath() + TYPE_XML_FILE_NAME;
			
			XMLReader reader = XMLReaderFactory.createXMLReader();
			handler = new UserXMLHandler();
			
			reader.setContentHandler(handler);
			reader.parse(realPath);
			
			users = handler.getUsers();
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public List<User> getListUser() {
		
		return users;
	}

	
	public User getUser(int id) {
		
		for(User user: users){
			if (user.getId() == id){
				return user;
			}
		}
		
		return null; // think here
	}

}
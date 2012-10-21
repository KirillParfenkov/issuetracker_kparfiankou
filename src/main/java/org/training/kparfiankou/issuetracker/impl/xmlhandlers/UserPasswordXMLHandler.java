package org.training.kparfiankou.issuetracker.impl.xmlhandlers;

import org.training.kparfiankou.issuetracker.beans.Role;
import org.training.kparfiankou.issuetracker.beans.User;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class UserPasswordXMLHandler extends DefaultHandler{
	
	private final static String KEY_USER = "user";
	private final static int ID = 0;
	private final static int FIRST_NAME = 1;
	private final static int LAST_NAME = 2;
	private final static int ROLE = 3;
	private final static int EAMIL_ADDRES = 4;
	private final static int PASSWORD = 5;
	
	private User user;
	private String incomingEmail;	
	private String incomingPassword;

	
	public UserPasswordXMLHandler(String email, String password){
		incomingEmail = email;
		incomingPassword = password;
	}
	
	public User getUser(){
		return user;
	}
	public void startElement(String uri, String localName,
			  String qName, Attributes attrs) throws SAXException{
		
		if (KEY_USER.equals(localName)){
			
			String password = attrs.getValue(PASSWORD);
			String email = attrs.getValue(EAMIL_ADDRES);
			
			if (incomingEmail.equals(email) && 
				incomingPassword.equals(password)){
				
				int id = Integer.valueOf(attrs.getValue(ID));
				String firstName = attrs.getValue(FIRST_NAME);
				String lastName = attrs.getValue(LAST_NAME);
				Role role = Role.valueOf(attrs.getValue(ROLE));
				
				user = new User(id,firstName,lastName,email,role);
			}
		}
	}
}

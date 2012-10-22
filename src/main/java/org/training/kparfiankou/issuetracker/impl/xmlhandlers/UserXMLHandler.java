package org.training.kparfiankou.issuetracker.impl.xmlhandlers;

import java.util.ArrayList;
import java.util.List;


import org.training.kparfiankou.issuetracker.beans.Role;
import org.training.kparfiankou.issuetracker.beans.User;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserXMLHandler extends DefaultHandler {

	private static final String  KEY_TYPE = "user";
	private static final int ID = 0;
	private static final int FIRST_NAME = 1;
	private static final int LAST_NAME = 2;
	private static final int ROLE = 3;
	private static final int EMAIL_ADDRESS = 4;

	private List<User> users;


	public UserXMLHandler(){
		users = new ArrayList<User>();
	}

	public List<User> getUsers() {
		return users;
	}

	public void startElement(String uri, String localName,
			  String qName, Attributes attrs) throws SAXException {

		if (KEY_TYPE.equals(localName)) {
			users.add(new User(Long.valueOf(attrs.getValue(ID)),
				               attrs.getValue(FIRST_NAME),
				               attrs.getValue(LAST_NAME),
				               attrs.getValue(EMAIL_ADDRESS),
				               Role.valueOf(attrs.getValue(ROLE))));
		}
	}
}
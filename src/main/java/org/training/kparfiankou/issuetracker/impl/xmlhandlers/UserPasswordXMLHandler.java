package org.training.kparfiankou.issuetracker.impl.xmlhandlers;

import org.training.kparfiankou.issuetracker.beans.Role;
import org.training.kparfiankou.issuetracker.beans.User;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Kiryl_Parfiankou
 *
 */
public class UserPasswordXMLHandler extends DefaultHandler {

	private static final String KEY_USER = "user";
	private static final int ID = 0;
	private static final int FIRST_NAME = 1;
	private static final int LAST_NAME = 2;
	private static final int ROLE = 3;
	private static final int EAMIL_ADDRES = 4;
	private static final int PASSWORD = 5;

	private User user;
	private String incomingEmail;
	private String incomingPassword;

	/**
	 *
	 * @param email the email of user
	 * @param password the password of user
	 */
	public UserPasswordXMLHandler(String email, String password) {
		incomingEmail = email;
		incomingPassword = password;
	}
	/**
	 *
	 * @return User
	 */
	public User getUser() {
		return user;
	}

	@Override
	public void startElement(String uri, String localName,
			  String qName, Attributes attrs) throws SAXException {

		if (KEY_USER.equals(localName)) {

			String password = attrs.getValue(PASSWORD);
			String email = attrs.getValue(EAMIL_ADDRES);

			if (incomingEmail.equals(email)
				&& incomingPassword.equals(password)) {

				int id = Integer.valueOf(attrs.getValue(ID));
				String firstName = attrs.getValue(FIRST_NAME);
				String lastName = attrs.getValue(LAST_NAME);
				Role role = Role.valueOf(attrs.getValue(ROLE));

				user = new User(id, firstName, lastName, email, role);
			}
		}
	}
}
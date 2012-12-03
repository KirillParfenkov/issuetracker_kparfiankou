package org.training.kparfiankou.issuetracker.impl.xml;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.impl.xml.handlers.UserPasswordXMLHandler;
import org.training.kparfiankou.issuetracker.impl.xml.handlers.UserXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author parf
 *
 */
public class UserXMLDAO extends AbstractXMLDAO implements IUserDAO {

	private static final String TYPE_XML_FILE_NAME = "users.xml";
	private UserXMLHandler userHandler;
	private List<User> users;
	private String realPath;

	/**
	 * Default constructor.
	 */
	public UserXMLDAO() {

		try {
			realPath = getXmlDirectoryPath() + TYPE_XML_FILE_NAME;

			XMLReader reader = XMLReaderFactory.createXMLReader();
			userHandler = new UserXMLHandler();

			reader.setContentHandler(userHandler);
			reader.parse(realPath);

			users = userHandler.getUsers();

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getListUser() {

		return users;
	}

	@Override
	public User getUser(int id) {

		for (User user: users) {
			if (user.getId() == id) {
				return user;
			}
		}

		return null; // think here
	}

	/**
	 * @param emailAddres the email address of user.
	 * @param password the password of user.
	 * @return User
	 */
	public User authenticate(String emailAddres, String password) {

		UserPasswordXMLHandler passwordHandler =
			new  UserPasswordXMLHandler(emailAddres, password);

		try {

			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(passwordHandler);
			reader.parse(realPath);

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return passwordHandler.getUser();
	}

	@Override
	public void inserUser(User user, String password) {
		// TODO Auto-generated method stub
	}

	@Override
	public User getUser(String emailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getMaxIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> searchUsers(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void newPassword(long id, String password) {
		// TODO Auto-generated method stub
	}
}
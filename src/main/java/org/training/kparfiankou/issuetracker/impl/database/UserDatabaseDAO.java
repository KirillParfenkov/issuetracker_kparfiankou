package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;
import org.training.kparfiankou.issuetracker.beans.Role;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 * @author parf
 *
 */
public class UserDatabaseDAO extends AbstractDatabaseDAO implements IUserDAO {

	// function for User!
	private static final String COL_USER_ID = "Users.id";
	private static final String COL_FIRST_NAME = "firstName";
	private static final String COL_LAST_NAME = "lastName";
	private static final String COL_ROLE_NAME = "Roles.name";
	private static final String COL_EMAIL_ADDRESS = "emailAddress";
	private static final String DB_TABLE_NAME = "Users";

	private Connection connection;
	private PreparedStatement psInserUser;
	private PreparedStatement psRemoveUser;
	private PreparedStatement psSelecUsers;
	private PreparedStatement psSelecUserById;
	private PreparedStatement psSelecUserByName;
	private PreparedStatement psSelecAuthenticateUser;
	private PreparedStatement psSelectId;

	/**
	 * default constructor.
	 */
	UserDatabaseDAO() {

		try {

			connection = getConnection();
			initQuerys();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	private int getMaxIdexId() {

		final String collumIdName = "id";

		ResultSet resultSet = null;
		try {

			resultSet = psSelectId.executeQuery();

			if (resultSet.next()) {
				return resultSet.getInt(collumIdName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}

		return 0;
	}

	private void initQuerys() throws SQLException {

		int numDbTableUsers = 1;

		psInserUser = connection.prepareStatement(ConstantSqlQuerys.INSERT_USER);
		psRemoveUser = connection.prepareStatement(ConstantSqlQuerys.DELETE_USER_BY_ID);
		psSelecAuthenticateUser = connection.prepareStatement(ConstantSqlQuerys.SELECT_AUTHENTICATION_USER);
		psSelecUsers =  connection.prepareStatement(ConstantSqlQuerys.SELECT_USERS);
		psSelecUserById =  connection.prepareStatement(ConstantSqlQuerys.SELECT_USER_BY_ID);
		psSelecUserByName =  connection.prepareStatement(ConstantSqlQuerys.SELECT_USER_BY_NAME);
		psSelectId = connection.prepareStatement(ConstantSqlQuerys.SELECT_MAX_ID);
		psSelectId.setString(numDbTableUsers, DB_TABLE_NAME);
	}


	@Override
	public List<User> getListUser() {

		ResultSet resultSet = null;
		List<User> users = null;

		try {

			resultSet = psSelecUsers.executeQuery();
			users = new ArrayList<User>();
			User user;
			while (resultSet.next()) {

				user = new User(resultSet.getInt(COL_USER_ID));
				user.setFirstName(resultSet.getString(COL_FIRST_NAME));
				user.setLastName(resultSet.getString(COL_LAST_NAME));
				user.setEmailAddress(COL_EMAIL_ADDRESS);
				user.setRole(Role.valueOf(resultSet.getString(COL_ROLE_NAME)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}

		return users;
	}

	@Override
	public User getUser(int id) {

		final int numId = 1;

		ResultSet resultSet = null;
		User user = null;

		try {

			psSelecUserById.setInt(numId, id);
			resultSet = psSelecUserById.executeQuery();

			if (resultSet.next()) {

				user = new User(resultSet.getInt(COL_USER_ID));
				user.setFirstName(resultSet.getString(COL_FIRST_NAME));
				user.setLastName(resultSet.getString(COL_LAST_NAME));
				user.setEmailAddress(COL_EMAIL_ADDRESS);
				user.setRole(Role.valueOf(resultSet.getString(COL_ROLE_NAME)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}

		return user;
	}

	@Override
	public User getUser(String emailAddress) {

		final int numEmailAddress = 1;

		ResultSet resultSet = null;
		User user = null;

		try {

			psSelecUserByName.setString(numEmailAddress, emailAddress);
			resultSet = psSelecUserByName.executeQuery();

			if (resultSet.next()) {

				user = new User(resultSet.getInt(COL_USER_ID));
				user.setFirstName(resultSet.getString(COL_FIRST_NAME));
				user.setLastName(resultSet.getString(COL_LAST_NAME));
				user.setEmailAddress(COL_EMAIL_ADDRESS);
				user.setRole(Role.valueOf(resultSet.getString(COL_ROLE_NAME)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}

		return user;
	}

	@Override
	public User authenticate(String emailAddres, String password) {

		final int numEmailAddress = 1;
		final int numPassword = 2;

		ResultSet resultSet = null;
		User user = null;

		try {

			psSelecAuthenticateUser.setString(numEmailAddress, emailAddres);
			psSelecAuthenticateUser.setString(numPassword, password);
			resultSet = psSelecUserByName.executeQuery();

			if (resultSet.next()) {

				user = new User(resultSet.getInt(COL_USER_ID));
				user.setFirstName(resultSet.getString(COL_FIRST_NAME));
				user.setLastName(resultSet.getString(COL_LAST_NAME));
				user.setEmailAddress(COL_EMAIL_ADDRESS);
				user.setRole(Role.valueOf(resultSet.getString(COL_ROLE_NAME)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}
		return null;
	}

	@Override
	public void inserUser(String lastName, String firstName, Role role,
			String emailAddress, String password) {

		final int numId = 1;
		final int numLastName = 2;
		final int numFirtName = 3;
		final int numRole = 4;
		final int numEmailAddress = 5;
		final int numPassword = 6;

		ResultSet resultSet = null;

		try {

			int maxId = getMaxIdexId();
			psInserUser.setInt(numId, ++maxId);
			psInserUser.setString(numLastName, lastName);
			psInserUser.setString(numFirtName, firstName);
			psInserUser.setString(numRole, role.toString());
			psInserUser.setString(numEmailAddress, emailAddress);
			psInserUser.setString(numPassword, password);
			psInserUser.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}
	}

	@Override
	public void removeUser(int id) {

		final int numId = 1;

		try {

			psRemoveUser.setInt(numId, id);
			psRemoveUser.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {

		closeConnection(connection);
		closeConnection(psInserUser);
		closeConnection(psRemoveUser);
		closeConnection(psSelecUsers);
		closeConnection(psSelecUserById);
		closeConnection(psSelecUserByName);
		closeConnection(psSelecAuthenticateUser);
		closeConnection(psSelectId);
	}
}
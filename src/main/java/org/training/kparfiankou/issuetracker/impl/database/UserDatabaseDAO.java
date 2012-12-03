package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Role;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 * @author parf
 *
 */
public class UserDatabaseDAO extends AbstractDatabaseDAO implements IUserDAO {

	private static final String COL_USER_ID = "Users.id";
	private static final String COL_FIRST_NAME = "firstName";
	private static final String COL_LAST_NAME = "lastName";
	private static final String COL_ROLE_NAME = "Roles.name";
	private static final String COL_EMAIL_ADDRESS = "emailAddress";

	private Connection connection;
	private PreparedStatement psInserUser;
	private PreparedStatement psRemoveUser;
	private PreparedStatement psSelecUsers;
	private PreparedStatement psSelecUserById;
	private PreparedStatement psSelecUserByName;
	private PreparedStatement psSelecAuthenticateUser;
	private PreparedStatement psSelectId;
	private PreparedStatement psSelecRoleId;
	private PreparedStatement psSearchUsers;
	private PreparedStatement psUpdateUser;
	private PreparedStatement psUpdateUserPassword;

	/**
	 * default constructor.
	 */
	public UserDatabaseDAO() {

		try {

			connection = getConnection();
			initQuerys();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void initQuerys() throws SQLException {

		psInserUser = connection.prepareStatement(ConstantSqlQuerys.INSERT_USER);
		psRemoveUser = connection.prepareStatement(ConstantSqlQuerys.DELETE_USER_BY_ID);
		psSelecAuthenticateUser = connection.prepareStatement(ConstantSqlQuerys.SELECT_AUTH_USER);
		psSelecUsers =  connection.prepareStatement(ConstantSqlQuerys.SELECT_USERS);
		psSelecUserById =  connection.prepareStatement(ConstantSqlQuerys.SELECT_USER_BY_ID);
		psSelecUserByName =  connection.prepareStatement(ConstantSqlQuerys.SELECT_USER_BY_NAME);
		psSelectId = connection.prepareStatement(ConstantSqlQuerys.SELECT_MAX_ID_USER);
		psSelecRoleId = connection.prepareStatement(ConstantSqlQuerys.SELECT_ROLE_BY_NAME);
		psUpdateUser = connection.prepareStatement(ConstantSqlQuerys.UPDATE_USER);
		psUpdateUserPassword = connection.prepareStatement(ConstantSqlQuerys.UPDATE_USER_PASSWORD);
	}

	private User pickUser(ResultSet resultSet) throws SQLException {

		User user = new User(resultSet.getInt(COL_USER_ID));
		user.setFirstName(resultSet.getString(COL_FIRST_NAME));
		user.setLastName(resultSet.getString(COL_LAST_NAME));
		user.setEmailAddress(resultSet.getString(COL_EMAIL_ADDRESS));
		user.setRole(Role.valueOf(resultSet.getString(COL_ROLE_NAME)));

		return user;
	}

	@Override
	public void newPassword(long id, String password) {

		int numPassword = 1;
		int numId = 2;

		try {

			psUpdateUserPassword.setString(numPassword, password);
			psUpdateUserPassword.setLong(numId, id);
			psUpdateUserPassword.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int getRoleId(String name) {

		final int numName = 1;
		final String roleId = "id";

		ResultSet resultSet = null;
		int result = -1;

		try {

			psSelecRoleId.setString(numName, name);
			resultSet = psSelecRoleId.executeQuery();

			if (resultSet.next()) {

				result = resultSet.getInt(roleId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}

		return result;
	}

	@Override
	public List<User> getListUser() {

		ResultSet resultSet = null;
		List<User> users = null;

		try {

			resultSet = psSelecUsers.executeQuery();
			users = new ArrayList<User>();

			while (resultSet.next()) {

				users.add(pickUser(resultSet));
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

				user = pickUser(resultSet);
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

				user = pickUser(resultSet);
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
			resultSet = psSelecAuthenticateUser.executeQuery();

			if (resultSet.next()) {

				user = pickUser(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}

		return user;
	}

	@Override
	public void inserUser(User user, String password) {

		final int numId = 1;
		final int numLastName = 3;
		final int numFirtName = 2;
		final int numRole = 4;
		final int numEmailAddress = 5;
		final int numPassword = 6;

		ResultSet resultSet = null;

		try {

			psInserUser.setLong(numId, user.getId());
			psInserUser.setString(numLastName, user.getLastName());
			psInserUser.setString(numFirtName, user.getFirstName());
			psInserUser.setLong(numRole, getRoleId(user.getRole().toString()));
			psInserUser.setString(numEmailAddress, user.getEmailAddress());
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

		closeConnection(psInserUser);
		closeConnection(psRemoveUser);
		closeConnection(psSelecUsers);
		closeConnection(psSelecUserById);
		closeConnection(psSelecUserByName);
		closeConnection(psSelecAuthenticateUser);
		closeConnection(psSelectId);
		closeConnection(psSelecRoleId);
		closeConnection(psUpdateUserPassword);
		closeConnection(connection);
	}

	@Override
	public int getMaxIndex() {

		int numIdColum = 1;
		int maxId = 0;
		ResultSet resultSet = null;

		try {
			resultSet = psSelectId.executeQuery();
			if (resultSet.next()) {
				maxId = resultSet.getInt(numIdColum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}
		return maxId;
	}

	@Override
	public void updateUser(User user) {

		final int numfirstName = 1;
		final int numLastName = 2;
		final int numEmailAddress = 3;
		final int numRoleId = 4;
		final int numIdUser = 5;

		try {

			psUpdateUser.setString(numfirstName, user.getFirstName());
			psUpdateUser.setString(numLastName, user.getLastName());
			psUpdateUser.setString(numEmailAddress, user.getEmailAddress());
			psUpdateUser.setLong(numRoleId, getRoleId(user.getRole().toString().toUpperCase()));
			psUpdateUser.setLong(numIdUser, user.getId());

			psUpdateUser.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> searchUsers(Map<String, String> map) {

		int numLastName = 0;
		int numfirstName = 0;
		int numEmailAddress = 0;

		StringBuffer fullQuery = new StringBuffer(ConstantSqlQuerys.SELECT_SEARCH_USERS);

		String firstName = map.get(Constants.KEY_INPUT_FIRST_NAME);
		String lastName = map.get(Constants.KEY_INPUT_LAST_NAME);
		String email = map.get(Constants.KEY_INPUT_EMAIL);

		ResultSet resultSet = null;
		List<User> users = null;

		int index = 1;
		try {

			if (lastName != null) {
				fullQuery.append(" AND (lastName = ?)");
				numLastName = index++;
			}
			if (firstName != null) {
				fullQuery.append(" AND (firstName = ?)");
				numfirstName = index++;
			}
			if (email != null) {
				fullQuery.append(" AND (emailAddress = ?)");
				numEmailAddress = index;
			}

			psSearchUsers = connection.prepareStatement(fullQuery.toString());

			if (lastName != null) {
				psSearchUsers.setString(numLastName, lastName);
			}
			if (firstName != null) {
				psSearchUsers.setString(numfirstName, firstName);
			}
			if (email != null) {
				psSearchUsers.setString(numEmailAddress, email);
			}

			resultSet = psSearchUsers.executeQuery();
			users = new ArrayList<User>();

			while (resultSet.next()) {
				users.add(pickUser(resultSet));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
			closeConnection(psSearchUsers);
		}
		return users;
	}
}
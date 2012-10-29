package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;

/**
 *
 * @author parf
 *
 */
public class PriorityDatabaseDAO extends AbstractDatabaseDAO implements IPriorityDAO {

	private static final String ID = "id";
	private static final String NAME = "name";

	private static Connection connection;
	private static PreparedStatement psInsertPriority;
	private static PreparedStatement psRemovePriority;
	private static PreparedStatement psSelecPrioritys;
	private static boolean isPrioritysModified;
	private static List<Priority> prioritys;

	/**
	 * Default constructor.
	 */
	public PriorityDatabaseDAO() {

		try {
			connection = getConnection();
			initQuerys();
			updateStatusList();
			isPrioritysModified = false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	private void initQuerys() throws SQLException {

		psInsertPriority = connection.prepareStatement(ConstantSqlQuerys.INSERT_STATUS);
		psRemovePriority = connection.prepareStatement(ConstantSqlQuerys.DELETE_STATUS_BY_ID);
		psSelecPrioritys =  connection.prepareStatement(ConstantSqlQuerys.SELECT_STATUSES);
	}

	private void updateStatusList() {

		ResultSet resultSet = null;

		try {

			resultSet = psSelecPrioritys.executeQuery();
			prioritys = new ArrayList<Priority>();

			while (resultSet.next()) {
				prioritys.add(new Priority(resultSet.getInt(ID),
								   		   resultSet.getString(NAME)));
			}

			isPrioritysModified = false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}
	}


	@Override
	public List<Priority> getListPriority() {

		if (isPrioritysModified) {
			updateStatusList();
		}

		return prioritys;
	}

	@Override
	public Priority getPriority(int id) {

		if (isPrioritysModified) {
			updateStatusList();
		}

		for (Priority priority: prioritys) {
			if (priority.getId() == id) {
				return priority;
			}
		}

		return null;
	}

	@Override
	public Priority getPriority(String namePriority) {

		if (isPrioritysModified) {
			updateStatusList();
		}

		for (Priority priority: prioritys) {
			if (priority.getName().equals(namePriority)) {
				return priority;
			}
		}
		return null;
	}

	@Override
	public void close() {

		closeConnection(psInsertPriority);
		closeConnection(psRemovePriority);
		closeConnection(connection);
	}

	@Override
	public void removePriority(int id) {

		final int numId = 1;

		try {

			psRemovePriority.setInt(numId, id);
			psRemovePriority.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isPrioritysModified = true;
		}
	}

	@Override
	public void insertPriority(String namePriority) {

		final int numNameResolution = 1;

		try {

			psInsertPriority.setString(numNameResolution, namePriority);
			psInsertPriority.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isPrioritysModified = true;
		}
	}
}
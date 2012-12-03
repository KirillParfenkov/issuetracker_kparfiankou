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

	private static boolean isPrioritysModified;
	private static List<Priority> prioritys;

	private Connection connection;
	private PreparedStatement psInsertPriority;
	private PreparedStatement psRemovePriority;
	private PreparedStatement psSelecPrioritys;
	private PreparedStatement psUpdatePriority;
	private PreparedStatement psSelectMaxIndex;

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
		}
	}

	private void initQuerys() throws SQLException {

		psInsertPriority = connection.prepareStatement(ConstantSqlQuerys.INSERT_PRIORITY);
		psRemovePriority = connection.prepareStatement(ConstantSqlQuerys.DELETE_PRIORITY_BY_ID);
		psSelecPrioritys =  connection.prepareStatement(ConstantSqlQuerys.SELECT_PRIORITYS);
		psUpdatePriority = connection.prepareStatement(ConstantSqlQuerys.UPDATE_PRIORY);
		psSelectMaxIndex = connection.prepareStatement(ConstantSqlQuerys.SELECT_MAX_ID_PRIORITY);
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
	public void updatePriority(Priority priority) {

		final int numNamePriority = 1;
		final int numNameId = 2;

		try {

			psUpdatePriority.setString(numNamePriority, priority.getName());
			psUpdatePriority.setLong(numNameId, priority.getId());
			psUpdatePriority.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isPrioritysModified = true;
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
		closeConnection(psUpdatePriority);
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
	public int getMaxIndex() {

		int numIdColum = 1;
		int maxId = 0;
		ResultSet resultSet = null;

		try {
			resultSet = psSelectMaxIndex.executeQuery();
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
	public void insertPriority(Priority priority) {

		final int numId = 1;
		final int numNameResolution = 2;

		try {

			psInsertPriority.setString(numNameResolution, priority.getName());
			psInsertPriority.setLong(numId, priority.getId());
			psInsertPriority.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isPrioritysModified = true;
		}
	}
}
package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;


/**
 *
 * @author parf
 *
 */
public class StatusDatabaseDAO extends AbstractDatabaseDAO implements IStatusDAO {

	private static final String ID = "id";
	private static final String NAME = "name";

	private static Connection connection;
	private static PreparedStatement psInserStatus;
	private static PreparedStatement psRemoveStatus;
	private static PreparedStatement psSelecStatuses;
	private static boolean isStatusesModified;
	private static List<Status> statuses;


	/**
	 * Default constructor.
	 */
	public StatusDatabaseDAO() {

		try {
			connection = getConnection();
			initQuerys();
			updateStatusList();
			isStatusesModified = false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	private void initQuerys() throws SQLException {

		psInserStatus = connection.prepareStatement(ConstantSqlQuerys.INSERT_STATUS);
		psRemoveStatus = connection.prepareStatement(ConstantSqlQuerys.DELETE_STATUS_BY_ID);
		psSelecStatuses =  connection.prepareStatement(ConstantSqlQuerys.SELECT_STATUSES);
	}

	private void updateStatusList() {

		ResultSet resultSet = null;

		try {

			resultSet = psSelecStatuses.executeQuery();
			statuses = new ArrayList<Status>();

			while (resultSet.next()) {
				statuses.add(new Status(resultSet.getInt(ID),
								   		resultSet.getString(NAME)));
			}

			isStatusesModified = false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}
	}

	@Override
	public List<Status> getListStatus() {

		if (isStatusesModified) {
			updateStatusList();
		}

		return statuses;
	}

	@Override
	public Status getStatus(int id) {

		if (isStatusesModified) {
			updateStatusList();
		}

		for (Status status: statuses) {
			if (status.getId() == id) {
				return status;
			}
		}

		return null;
	}

	@Override
	public Status getStatus(String name) {

		if (isStatusesModified) {
			updateStatusList();
		}

		for (Status status: statuses) {
			if (status.getName().equals(name)) {
				return status;
			}
		}

		return null;
	}

	@Override
	public void insertStatus(String nameStatus) {

		final int numNameStatus = 1;

		try {

			psInserStatus.setString(numNameStatus, nameStatus);
			psInserStatus.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isStatusesModified = true;
		}
	}

	@Override
	public void removeStatus(int id) {

		final int numId = 1;

		try {

			psRemoveStatus.setInt(numId, id);
			psRemoveStatus.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isStatusesModified = true;
		}
	}

	@Override
	public void close() {

		closeConnection(psRemoveStatus);
		closeConnection(psInserStatus);
		closeConnection(connection);
	}
}
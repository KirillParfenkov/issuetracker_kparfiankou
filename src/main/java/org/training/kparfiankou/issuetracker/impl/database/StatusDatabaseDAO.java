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

	private static boolean isStatusesModified;
	private static List<Status> statuses;

	private Connection connection;
	private PreparedStatement psInserStatus;
	private PreparedStatement psRemoveStatus;
	private PreparedStatement psSelecStatuses;
	private PreparedStatement psUpdateStatus;

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
		}
	}

	private void initQuerys() throws SQLException {

		psInserStatus = connection.prepareStatement(ConstantSqlQuerys.INSERT_STATUS);
		psRemoveStatus = connection.prepareStatement(ConstantSqlQuerys.DELETE_STATUS_BY_ID);
		psSelecStatuses =  connection.prepareStatement(ConstantSqlQuerys.SELECT_STATUSES);
		psUpdateStatus = connection.prepareStatement(ConstantSqlQuerys.UPDATE_STATUS);
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
	public void updateStatus(Status status) {

		final int numNameStatus = 1;
		final int numNameId = 2;

		try {

			psUpdateStatus.setString(numNameStatus, status.getName());
			psUpdateStatus.setLong(numNameId, status.getId());
			psUpdateStatus.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isStatusesModified = true;
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
	public Status getStatus(long id) {

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
	public void insertStatus(Status status) {

		final int numNameStatus = 1;

		try {

			psInserStatus.setString(numNameStatus, status.getName());
			psInserStatus.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isStatusesModified = true;
		}
	}

	@Override
	public void removeStatus(long id) {

		final int numId = 1;

		try {

			psRemoveStatus.setLong(numId, id);
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
		closeConnection(psUpdateStatus);
		closeConnection(connection);
	}

	@Override
	public long getMaxIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
}
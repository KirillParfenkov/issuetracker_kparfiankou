package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;

/**
 *
 * @author parf
 *
 */
public class ResolutionDatabaseDAO extends AbstractDatabaseDAO implements IResolutionDAO {

	private static final String ID = "id";
	private static final String NAME = "name";

	private static Connection connection;
	private static PreparedStatement psInsertResolution;
	private static PreparedStatement psRemoveResolution;
	private static PreparedStatement psSelecResolutions;
	private static boolean isResolutionsModified;
	private static List<Resolution> resolutions;

	/**
	 * Default constructor.
	 */
	public ResolutionDatabaseDAO() {

		try {
			connection = getConnection();
			initQuerys();
			updateStatusList();
			isResolutionsModified = false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	private void initQuerys() throws SQLException {

		psInsertResolution = connection.prepareStatement(ConstantSqlQuerys.INSERT_STATUS);
		psRemoveResolution = connection.prepareStatement(ConstantSqlQuerys.DELETE_STATUS_BY_ID);
		psSelecResolutions =  connection.prepareStatement(ConstantSqlQuerys.SELECT_STATUSES);
	}

	private void updateStatusList() {

		ResultSet resultSet = null;

		try {

			resultSet = psSelecResolutions.executeQuery();
			resolutions = new ArrayList<Resolution>();

			while (resultSet.next()) {
				resolutions.add(new Resolution(resultSet.getInt(ID),
								   		   	   resultSet.getString(NAME)));
			}

			isResolutionsModified = false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}
	}


	@Override
	public List<Resolution> getListResolution() {

		if (isResolutionsModified) {
			updateStatusList();
		}

		return resolutions;
	}

	@Override
	public Resolution getResolution(int id) {

		if (isResolutionsModified) {
			updateStatusList();
		}

		for (Resolution resolution: resolutions) {
			if (resolution.getId() == id) {
				return resolution;
			}
		}

		return null;
	}

	@Override
	public Resolution getResolution(String nameResolution) {

		if (isResolutionsModified) {
			updateStatusList();
		}

		for (Resolution resolution: resolutions) {
			if (resolution.getName().equals(nameResolution)) {
				return resolution;
			}
		}
		return null;
	}

	@Override
	public void close() {

		closeConnection(psInsertResolution);
		closeConnection(psRemoveResolution);
		closeConnection(connection);
	}

	@Override
	public void removeResolution(int id) {

		final int numId = 1;

		try {

			psRemoveResolution.setInt(numId, id);
			psRemoveResolution.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isResolutionsModified = true;
		}
	}

	@Override
	public void insertResolution(String nameResolution) {

		final int numNameResolution = 1;

		try {

			psInsertResolution.setString(numNameResolution, nameResolution);
			psInsertResolution.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isResolutionsModified = true;
		}
	}
}
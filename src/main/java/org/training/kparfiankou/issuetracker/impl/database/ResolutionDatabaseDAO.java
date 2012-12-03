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
	private static final String NAME_TABLE = "Resolutions";

	private static boolean isResolutionsModified;
	private static List<Resolution> resolutions;

	private Connection connection;
	private PreparedStatement psInsertResolution;
	private PreparedStatement psRemoveResolution;
	private PreparedStatement psSelecResolutions;
	private PreparedStatement psUpdateResolution;
	private PreparedStatement psSelectMaxIndex;

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
		}
	}

	private void initQuerys() throws SQLException {

		psInsertResolution = connection.prepareStatement(ConstantSqlQuerys.INSERT_RESOLUTION);
		psRemoveResolution = connection.prepareStatement(ConstantSqlQuerys.DELETE_RESOLUTION_BY_ID);
		psSelecResolutions =  connection.prepareStatement(ConstantSqlQuerys.SELECT_RESOLUTIONS);
		psUpdateResolution =  connection.prepareStatement(ConstantSqlQuerys.UPDATE_RESOLUTION);
		psSelectMaxIndex = connection.prepareStatement(ConstantSqlQuerys.SELECT_MAX_ID_RESOLUTION);
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
	public void updateResolution(Resolution  resolution) {

		final int numNameResolution = 1;
		final int numNameId = 2;

		try {

			psUpdateResolution.setString(numNameResolution, resolution.getName());
			psUpdateResolution.setLong(numNameId, resolution.getId());
			psUpdateResolution.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isResolutionsModified = true;
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
		closeConnection(psUpdateResolution);
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
	public void insertResolution(Resolution resolution) {

		final int numId = 1;
		final int numNameResolution = 2;

		try {

			psInsertResolution.setString(numNameResolution, resolution.getName());
			psInsertResolution.setLong(numId, resolution.getId());
			psInsertResolution.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isResolutionsModified = true;
		}
	}
}

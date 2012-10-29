package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;


/**
 *
 * @author parf
 *
 */
public class TypeDatabaseDAO extends AbstractDatabaseDAO implements ITypeDAO {

	private static final String ID = "id";
	private static final String NAME = "name";

	private static Connection connection;
	private static PreparedStatement psInserType;
	private static PreparedStatement psRemoveType;
	private static PreparedStatement psSelecTypes;
	private static boolean isTypesModified;
	private static List<Type> types;


	/**
	 * Default constructor.
	 */
	public TypeDatabaseDAO() {

		try {
			connection = getConnection();
			initQuerys();
			updateTypeList();
			isTypesModified = false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	private void initQuerys() throws SQLException {

		psInserType = connection.prepareStatement(ConstantSqlQuerys.INSERT_TYPE);
		psRemoveType = connection.prepareStatement(ConstantSqlQuerys.DELETE_TYPE_BY_ID);
		psSelecTypes =  connection.prepareStatement(ConstantSqlQuerys.SELECT_TYPES);
	}

	private void updateTypeList() {

		ResultSet resultSet = null;

		try {

			resultSet = psSelecTypes.executeQuery();
			types = new ArrayList<Type>();

			while (resultSet.next()) {
				types.add(new Type(resultSet.getInt(ID),
								   resultSet.getString(NAME)));
			}

			isTypesModified = false;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}
	}

	@Override
	public List<Type> getListType() {

		if (isTypesModified) {
			updateTypeList();
		}

		return types;
	}

	@Override
	public Type getType(int id) {

		if (isTypesModified) {
			updateTypeList();
		}

		for (Type type: types) {
			if (type.getId() == id) {
				return type;
			}
		}

		return null;
	}
/*
	@Override
	public Type getType(String name) {

		if (isTypesModified) {
			updateTypeList();
		}

		for (Type type: types) {
			if (type.getName().equals(name)) {
				return type;
			}
		}

		return null;
	}

	@Override
	public void insertType(String nameType) {

		final int numNameType = 1;

		try {

			psInserType.setString(numNameType, nameType);
			psInserType.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isTypesModified = true;
		}
	}

	@Override
	public void removeType(int id) {

		final int numId = 1;

		try {

			psRemoveType.setInt(numId, id);
			psRemoveType.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isTypesModified = true;
		}
	}

	@Override
	public void close() {

		closeConnection(psRemoveType);
		closeConnection(psInserType);
		closeConnection(connection);
	}*/
}
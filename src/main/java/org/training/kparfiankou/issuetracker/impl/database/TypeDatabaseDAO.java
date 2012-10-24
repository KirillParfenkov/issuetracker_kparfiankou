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
	private static List<Type> types;


	/**
	 * Default constructor.
	 */
	public TypeDatabaseDAO() {

		try {
			connection = getConnection();

			PreparedStatement psSelecTypes =  connection.prepareStatement(ConstantSqlQuerys.QUERY_SELECT_TYPES);
			ResultSet resultSet = psSelecTypes.executeQuery();

			types = new ArrayList<Type>();

			while (resultSet.next()) {
				types.add(new Type(resultSet.getInt(ID),
								   resultSet.getString(NAME)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public List<Type> getListType() {

		return types;
	}

	@Override
	public Type getType(int id) {

		for (Type type: types) {
			if (type.getId() == id) {
				return type;
			}
		}

		return null;
	}
}
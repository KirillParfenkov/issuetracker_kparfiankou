package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;


/**
 *
 * @author parf
 *
 */
public class TypeDatabaseDAO extends AbstractDatabaseDAO implements ITypeDAO {

	private static Connection connection;

	/**
	 * Default constructor.
	 */
	public TypeDatabaseDAO() {
		try {
			ResultSet resultSet;
			connection = getConnection();
			PreparedStatement psSelecTypes =  connection.prepareStatement("SELECT * FROM Types");
			resultSet = psSelecTypes.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Type> getListType() {
		return null;
	}

	@Override
	public Type getType(int id) {
		return null;
	}
}

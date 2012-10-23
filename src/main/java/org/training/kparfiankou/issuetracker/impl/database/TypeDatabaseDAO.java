package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
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
		connection = getConnection();
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

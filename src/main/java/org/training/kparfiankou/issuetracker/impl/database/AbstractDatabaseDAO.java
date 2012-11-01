package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;


/**
 *
 * @author parf
 *
 */
public abstract class AbstractDatabaseDAO {

	private static final String DB_DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String PATH_DB = "jdbc:mysql://localhost/IssueTracker";
	private static final String DB_ADMIN_NAME = "root";
	private static final String DB_ADMIN_PASS = "@erbnruqp";
	private static final String ERROR_MESAGE = "Can't close connection.";

	/**
	 * @return Connection
	 */
	protected Connection getConnection() {
		
		Connection connection;
		try {

			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(PATH_DB, DB_ADMIN_NAME, DB_ADMIN_PASS);
			return connection;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *
	 * @param statement closing statement
	 */
	protected void closeConnection(PreparedStatement statement) {

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			System.err.println(ERROR_MESAGE + e);
		}
	}

	/**
	 *
	 * @param statement closing statement
	 */
	protected void closeConnection(Statement statement) {

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			System.err.println(ERROR_MESAGE + e);
		}
	}

	/**
	 *
	 * @param connection closing connection
	 */
	protected void closeConnection(Connection connection) {

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.err.println(ERROR_MESAGE + e);
		}
	}

	/**
	 *
	 * @param resultSet closing result set
	 */
	protected void closeConnection(ResultSet resultSet) {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			System.err.println(ERROR_MESAGE + e);
		}
	}
}
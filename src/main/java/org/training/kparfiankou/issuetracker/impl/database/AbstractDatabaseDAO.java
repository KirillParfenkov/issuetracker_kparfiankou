package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import org.gjt.mm.mysql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

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


	/**
	 *
	 * @return Connection
	 */
	protected Connection getConnection() {

		try {

			Class.forName(DB_DRIVER);
			return DriverManager.getConnection(PATH_DB, DB_ADMIN_NAME, DB_ADMIN_PASS);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
package org.training.kparfiankou.issuetracker;


/**
 *
 * @author parf
 *
 */
public final class ConstantSqlQuerys {

	/**
	 * Selects all types of issues.
	 */
	public static final String SELECT_TYPES = "SELECT * FROM Types;";

	/**
	 * Insert new type in table types.
	 */
	public static final String INSERT_TYPE = "INSERT INTO Types (name) VALUES (?);";

	/**
	 * Delete type by id.
	 */
	public static final String DELETE_TYPE_BY_ID = "DELETE FROM Types WHERE id = ? ;";

	/**
	 * Selects all types of issues.
	 */
	public static final String SELECT_STATUSES = "SELECT * FROM Statuses;";

	/**
	 * Insert new type in table types.
	 */
	public static final String INSERT_STATUS = "INSERT INTO Statuses (name) VALUES (?);";

	/**
	 * Delete type by id.
	 */
	public static final String DELETE_STATUS_BY_ID = "DELETE FROM Statuses WHERE id = ? ;";

	/**
	 * Selects all resolutions of issues.
	 */
	public static final String SELECT_RESOLUTIONS = "SELECT * FROM Resolutions;";

	/**
	 * Insert new type in table resolutions.
	 */
	public static final String INSERT_RESOLUTION = "INSERT INTO Resolutions (name) VALUES (?);";

	/**
	 * Delete resolution by id.
	 */
	public static final String DELETE_RESOLUTION_BY_ID = "DELETE FROM Resolutions WHERE id = ? ;";

	private ConstantSqlQuerys() {
		// Prevent instantiation
	}
}
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
	public static final String QUERY_SELECT_TYPES = "SELECT * FROM Types;";


	private ConstantSqlQuerys() {
		// Prevent instantiation
	}
}
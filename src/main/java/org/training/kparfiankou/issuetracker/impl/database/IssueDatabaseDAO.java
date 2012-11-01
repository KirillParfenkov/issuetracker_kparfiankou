package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;

public class IssueDatabaseDAO extends AbstractDatabaseDAO implements IIssueDAO{

	private static final String DB_TABLE_NAME = "Issues";

	private Connection connection;
	private PreparedStatement psSelectIssues;
	private PreparedStatement psSelectMaxId;

	public IssueDatabaseDAO(){

		try {

			connection = getConnection();
			initQuerys();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void initQuerys() throws SQLException {

		int numDbTableUsers = 1;

		psSelectIssues = connection.prepareStatement(ConstantSqlQuerys.SELECT_ISSUES);
		psSelectMaxId = connection.prepareStatement(ConstantSqlQuerys.SELECT_MAX_ID);
		psSelectMaxId.setString(numDbTableUsers, DB_TABLE_NAME);

	}

	@Override
	public List<Issue> getListIssue() {
		return null;
	}

	@Override
	public Issue getIssue(int id) {
		return null;
	}
}
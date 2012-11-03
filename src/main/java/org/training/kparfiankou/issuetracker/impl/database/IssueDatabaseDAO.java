package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.factories.StatusDAOFactory;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 *
 * @author parf
 *
 */
public class IssueDatabaseDAO extends AbstractDatabaseDAO implements IIssueDAO {

	private static final String ISSUE_ID = "Issues.id";
	private static final String STATUS_ID = "statusId";
	private static final String TYPE_ID = "typeId";
	private static final String PRIOTIRY_ID = "priorityId";
	private static final String PROJECT_ID = "projectId";
	private static final String BUILD_ID = "buildId";
	private static final String ASSIGNEE_ID = "assigneeId";
	private static final String CREATE_DATE = "createDate";
	private static final String CREATER_ID = "createrId";
	private static final String MODIFY_DATE = "modifyDate";
	private static final String LAST_MODIFIER_ID = "lastModifierId";
	private static final String RESOLUTION_ID = "resolutionId";
	private static final String SUMMARY = "summary";
	private static final String DESCRIPTION = "description";

	private static final String DB_TABLE_NAME = "Issues";

	private Connection connection;
	private PreparedStatement psSelectIssues;
	private PreparedStatement psSelectIssueById;
	private PreparedStatement psSelectMaxId;


	private IStatusDAO statusDAO;
	private ITypeDAO typeDAO;
	private IPriorityDAO priorityDAO;
	private IUserDAO userDAO;
	private IProjectDAO projectDAO;
	private IResolutionDAO resolutionDAO;

	/**
	 * Default constructor.
	 */
	public IssueDatabaseDAO() {

		try {

			connection = getConnection();
			statusDAO = StatusDAOFactory.getClassFromFactory();
			typeDAO = TypeDAOFactory.getClassFromFactory();
			priorityDAO = PriorityDAOFactory.getClassFromFactory();
			userDAO = UserDAOFactory.getClassFromFactory();
			projectDAO = ProjectDAOFactory.getClassFromFacroty();
			resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
			initQuerys();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void initQuerys() throws SQLException {

		int numDbTableUsers = 1;

		psSelectIssues = connection.prepareStatement(ConstantSqlQuerys.SELECT_ISSUES);
		psSelectIssueById = connection.prepareStatement(ConstantSqlQuerys.SELECT_ISSUE_BY_ID);
		psSelectMaxId = connection.prepareStatement(ConstantSqlQuerys.SELECT_MAX_ID);
		psSelectMaxId.setString(numDbTableUsers, DB_TABLE_NAME);

	}

	/**
	 * @param resultSet set of result which is selected by the current object of Issue.
	 * @return current object of Issue.
	 * @throws SQLException
	 */
	private Issue pickIssue(ResultSet resultSet) throws SQLException {

		Issue issue = new Issue(resultSet.getInt(ISSUE_ID));

		issue.setStatus(statusDAO.getStatus(resultSet.getInt(STATUS_ID)));
		issue.setType(typeDAO.getType(resultSet.getInt(TYPE_ID)));
		issue.setPriority(priorityDAO.getPriority(resultSet.getInt(PRIOTIRY_ID)));
		Project project = projectDAO.getProject(resultSet.getInt(PROJECT_ID));
		issue.setProject(project);
		issue.setBuild(project.getBuild(resultSet.getInt(BUILD_ID)));
		issue.setAssignee(userDAO.getUser(resultSet.getInt(ASSIGNEE_ID)));
		issue.setCreateDate(resultSet.getDate(CREATE_DATE));
		issue.setCreater(userDAO.getUser(resultSet.getInt(CREATER_ID)));
		issue.setModifyDate(resultSet.getDate(MODIFY_DATE));
		issue.setLastModifier(userDAO.getUser(resultSet.getInt(LAST_MODIFIER_ID)));
		issue.setResolution(resolutionDAO.getResolution(resultSet.getInt(RESOLUTION_ID)));
		issue.setSummary(resultSet.getString(SUMMARY));
		issue.setDescription(resultSet.getString(DESCRIPTION));

		return issue;
	}

	@Override
	public List<Issue> getListIssue() {

		ResultSet resultSet = null;
		List<Issue> issues = new ArrayList<Issue>();

		try {

			resultSet = psSelectIssues.executeQuery();

			while (resultSet.next()) {
				issues.add(pickIssue(resultSet));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}

		return issues;
	}

	@Override
	public Issue getIssue(int id) {

		final int numId = 1;
		ResultSet resultSet = null;

		try {

			psSelectIssueById.setInt(numId, id);
			resultSet = psSelectIssueById.executeQuery();

			if (resultSet.next()) {
				return pickIssue(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeConnection(resultSet);
		}

		return null;
	}

	@Override
	public void close() {

		closeConnection(psSelectIssues);
		closeConnection(psSelectIssueById);
		closeConnection(psSelectMaxId);
		closeConnection(connection);
	}
}
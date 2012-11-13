package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;
import org.training.kparfiankou.issuetracker.beans.AbstractEntity;
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

	private static final String ISSUE_ID = "id";
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
	private PreparedStatement psInsertIssue;
	private PreparedStatement psRemoveIssue;
	private PreparedStatement psCurrentDate;

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
		psInsertIssue = connection.prepareStatement(ConstantSqlQuerys.INSERT_ISSUE);
		psRemoveIssue = connection.prepareStatement(ConstantSqlQuerys.DELETE_ISSUE);
		psCurrentDate = connection.prepareStatement(ConstantSqlQuerys.SELECT_CURRENT_DATE);
		psSelectMaxId = connection.prepareStatement(ConstantSqlQuerys.SELECT_MAX_ID);
		psSelectMaxId.setString(numDbTableUsers, DB_TABLE_NAME);

	}

	@Override
	public java.util.Date getCurrentDate() {

		final String dateColum = "NOW()";
		java.util.Date date = null;
		ResultSet resultSet = null;

		try {
			resultSet = psCurrentDate.executeQuery();
			if (resultSet.next()) {
				date = resultSet.getDate(dateColum);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet);
		}

		return date;
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

	private void insertId(int num, AbstractEntity entity) throws SQLException {

		if (entity != null) {
			psInsertIssue.setLong(num, entity.getId());
		} else  {
			psInsertIssue.setNull(num, Types.BIGINT);
		}
	}

	private void insertDate(int num, Date date) throws SQLException {

		if (date != null) {
			psInsertIssue.setDate(num, date);
		} else {
			psInsertIssue.setNull(num, Types.DATE);
		}
	}

	@Override
	public void insertIssue(Issue issue) {

		final int numId = 1;
		final int numStatusId = 2;
		final int numTypeId = 3;
		final int numPriorityId = 4;
		final int numProjectId = 5;
		final int numBuildId = 6;
		final int numAssigneeId = 7;
		final int numCreateDate = 8;
		final int numCreaterId = 9;
		final int numModifyDate = 10;
		final int numLastModifyerId = 11;
		final int numResolutionId = 12;
		final int numSummary = 13;
		final int numDescription = 14;

		try {

			psInsertIssue.setLong(numId, issue.getId());
			psInsertIssue.setLong(numStatusId, issue.getStatus().getId());
			psInsertIssue.setLong(numTypeId, issue.getType().getId());
			psInsertIssue.setLong(numPriorityId, issue.getPriority().getId());
			psInsertIssue.setLong(numProjectId, issue.getProject().getId());
			psInsertIssue.setLong(numBuildId, issue.getBuild().getId());
			psInsertIssue.setLong(numAssigneeId, issue.getAssignee().getId());
			psInsertIssue.setDate(numCreateDate, new Date(issue.getCreateDate().getTime()));
			psInsertIssue.setLong(numCreaterId, issue.getCreater().getId());
			psInsertIssue.setDate(numModifyDate, new Date(issue.getModifyDate().getTime()));
			psInsertIssue.setLong(numLastModifyerId, issue.getLastModifier().getId());
			insertId(numResolutionId, issue.getResolution());
			psInsertIssue.setString(numSummary, issue.getSummary());
			psInsertIssue.setString(numDescription, issue.getDescription());
			psInsertIssue.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeIssue(int id) {

		final int numId = 1;

		try {

			psRemoveIssue.setInt(numId, id);
			psRemoveIssue.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {

		statusDAO.close();
		typeDAO.close();
		priorityDAO.close();
		userDAO.close();
		projectDAO.close();
		resolutionDAO.close();

		closeConnection(psSelectIssues);
		closeConnection(psSelectIssueById);
		closeConnection(psSelectMaxId);
		closeConnection(connection);
	}
}
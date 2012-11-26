package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;
import org.training.kparfiankou.issuetracker.beans.Build;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 *
 * @author parf
 *
 */
public class ProjectDatabaseDAO extends AbstractDatabaseDAO implements IProjectDAO {

	private static final String ID_PROJECT = "id";
	private static final String NAME_PROJECT = "name";
	private static final String MENAGER_ID = "menagerId";
	private static final String DESCRIPTION = "description";
	private static final String ID_BUILD = "id";
	private static final String NAME_BUILD = "name";

	private Connection connection;
	private PreparedStatement psSelectProjects;
	private PreparedStatement psSelectBuildsProject;
	private PreparedStatement psSelectProjectById;
	private PreparedStatement psInsertProject;
	private PreparedStatement psInsertBuildProject;
	private PreparedStatement psRemoveProject;
	private PreparedStatement psUpdateProject;

	private IUserDAO userDAO;
	private List<Project> projects;

	/**
	 * Default constructor.
	 */
	public ProjectDatabaseDAO() {

		try {

			connection = getConnection();
			psSelectProjects = connection.prepareStatement(ConstantSqlQuerys.SELECT_PROJECTS);
			psSelectBuildsProject = connection.prepareStatement(ConstantSqlQuerys.SELECT_BUILDS_PROJECT);
			psSelectProjectById = connection.prepareStatement(ConstantSqlQuerys.SELECT_PROJECT_BY_ID);
			psInsertProject = connection.prepareStatement(ConstantSqlQuerys.INSERT_PROJECT);
			psInsertBuildProject = connection.prepareStatement(ConstantSqlQuerys.INSERT_BUILD_PROJECT);
			psRemoveProject = connection.prepareStatement(ConstantSqlQuerys.DELETE_PROJECT);
			psUpdateProject = connection.prepareStatement(ConstantSqlQuerys.UPDATE_PROJECT);

			projects = new ArrayList<Project>();
			userDAO = UserDAOFactory.getClassFromFactory();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProject(Project project) {

		final int numNameProject = 1;
		final int numNameId = 2;

		/*try {

			psUpdateProject.setString(numNameProject, project.getName());
			psUpdateProject.setLong(numNameId, project.getId());
			psUpdateProject.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * @param resultSet set of result which is selected by the current object of Project.
	 * @return current object of Project.
	 * @throws SQLException
	 */
	private Project pick(ResultSet resultSet) throws SQLException {

		int numId = 1;
		Project project = null;
		ResultSet buildsResultSet = null;

		try {

			int projectId = resultSet.getInt(ID_PROJECT);
			project = new Project(projectId);

			psSelectBuildsProject.setInt(numId, projectId);
			buildsResultSet = psSelectBuildsProject.executeQuery();
			List<Build> buildList = new ArrayList<Build>();

			while (buildsResultSet.next()) {

				buildList.add(new Build(buildsResultSet.getInt(ID_BUILD),
										buildsResultSet.getString(NAME_BUILD)));
			}

			project.setBuilds(buildList);
			project.setName(resultSet.getString(NAME_PROJECT));
			project.setDescription(resultSet.getString(DESCRIPTION));
			project.setManager(userDAO.getUser(resultSet.getInt(MENAGER_ID)));

		} finally {
			closeConnection(buildsResultSet);
		}

		return project;
	}

	@Override
	public List<Project> getListProject() {

		ResultSet resultSet = null;

		try {

			resultSet = psSelectProjects.executeQuery();

			while (resultSet.next()) {
				projects.add(pick(resultSet));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeConnection(resultSet);
		}

		return projects;
	}

	@Override
	public Project getProject(int id) {

		final int numId = 1;
		ResultSet resultSet = null;

		try {

			psSelectProjectById.setInt(numId, id);
			resultSet = psSelectProjectById.executeQuery();

			if (resultSet.next()) {
				return pick(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeConnection(resultSet);
		}

		return null;
	}

	@Override
	public void insertProject(Project project) {

		final int numId = 1;
		final int numName = 2;
		final int numMenagerId = 3;
		final int numDescription = 4;
		final int numBuildId = 1;
		final int numBuildProjectId = 2;
		final int numBuildName = 3;

		try {

			psInsertProject.setLong(numId, project.getId());
			psInsertProject.setString(numName, project.getName());
			psInsertProject.setLong(numMenagerId, project.getManager().getId());
			psInsertProject.setString(numDescription, project.getDescription());
			psInsertProject.executeUpdate();

			List<Build> builds = project.getBuilds();

			for (Build build: builds) {

				psInsertBuildProject.setLong(numBuildId, build.getId());
				psInsertBuildProject.setLong(numBuildProjectId, project.getId());
				psInsertBuildProject.setString(numBuildName, build.getName());
				psInsertBuildProject.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeProject(int id) {

		final int numId = 1;

		try {

			psRemoveProject.setInt(numId, id);
			psRemoveProject.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {

		userDAO.close();

		closeConnection(psSelectProjects);
		closeConnection(psSelectProjectById);
		closeConnection(psInsertProject);
		closeConnection(psInsertBuildProject);
		closeConnection(psRemoveProject);
		closeConnection(psSelectBuildsProject);
		closeConnection(psUpdateProject);
		closeConnection(connection);
	}
}
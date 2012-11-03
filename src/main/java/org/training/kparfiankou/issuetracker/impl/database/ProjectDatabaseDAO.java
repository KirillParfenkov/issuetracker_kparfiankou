package org.training.kparfiankou.issuetracker.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.ConstantSqlQuerys;
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

	private Connection connection;
	private PreparedStatement psSelectProjects;
	private PreparedStatement psSelectProjectById;
	private PreparedStatement psInsertProject;
	private PreparedStatement psRemoveProject;

	private IUserDAO userDAO;
	private List<Project> projects;

	/**
	 * Default constructor.
	 */
	public ProjectDatabaseDAO() {

		try {

			connection = getConnection();
			psSelectProjects = connection.prepareStatement(ConstantSqlQuerys.SELECT_PROJECTS);
			psSelectProjectById = connection.prepareStatement(ConstantSqlQuerys.SELECT_PROJECT_BY_ID);
			psInsertProject = connection.prepareStatement(ConstantSqlQuerys.INSERT_PROJECT);
			psRemoveProject = connection.prepareStatement(ConstantSqlQuerys.DELETE_PROJECT);

			projects = new ArrayList<Project>();
			userDAO = UserDAOFactory.getClassFromFactory();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param resultSet set of result which is selected by the current object of Project.
	 * @return current object of Project.
	 * @throws SQLException
	 */
	private Project pick(ResultSet resultSet) throws SQLException {

		Project project = new Project(resultSet.getInt(ID_PROJECT));

		project.setName(NAME_PROJECT);
		project.setDescription(DESCRIPTION);
		project.setManager(userDAO.getUser(resultSet.getInt(MENAGER_ID)));
		project.setDescription(resultSet.getString(DESCRIPTION));

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

		return null;
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

	public void insertProject(Project project){
		
	}

	public void removeProject(int id){

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
		closeConnection(psRemoveProject);
		closeConnection(connection);
	}
}
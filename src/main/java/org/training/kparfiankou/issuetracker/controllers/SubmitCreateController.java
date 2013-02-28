package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.factories.StatusDAOFactory;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.dao.IPriorityDAO;
import org.training.kparfiankou.issuetracker.dao.IProjectDAO;
import org.training.kparfiankou.issuetracker.dao.IStatusDAO;
import org.training.kparfiankou.issuetracker.dao.ITypeDAO;
import org.training.kparfiankou.issuetracker.dao.IUserDAO;

/**
 * Servlet implementation class AddIssueController.
 */
public class SubmitCreateController extends AbstractController {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitCreateController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
		ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
		IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
		IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

		List<Status> statuses = statusDAO.getListStatus();
		List<Type> types =  typeDAO.getListType();
		List<Priority> prioritys = priorityDAO.getListPriority();
		List<Project> projects = projectDAO.getListProject();
		List<User> users = userDAO.getListUser();

		request.setAttribute(Constants.STATUSES, statuses);
		request.setAttribute(Constants.TYPES, types);
		request.setAttribute(Constants.PRIORITYS, prioritys);
		request.setAttribute(Constants.PROJECTS, projects);
		request.setAttribute(Constants.USERS, users);

		jump(Constants.SUBMIT_ISSUE_PAGE, request, response);
	}
}
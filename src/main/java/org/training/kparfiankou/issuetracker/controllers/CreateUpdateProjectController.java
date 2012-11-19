package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 * Servlet implementation class CreateUpdateProjectController.
 */
public class CreateUpdateProjectController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUpdateProjectController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty(); // after close all DAO.
		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

		int projectId = Integer.valueOf(request.getParameter(Constants.KEY_PROJECT_ID));
		Project project = projectDAO.getProject(projectId);
		List<User> managers = userDAO.getListUser();

		request.setAttribute(Constants.KEY_PROJECT, project);
		request.setAttribute(Constants.MANAGERS, managers);

		jump(Constants.UPDATE_PROJECT_PAGE, request, response);
	}
}
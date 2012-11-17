package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;

/**
 * Servlet implementation class CreateProjectsListPageController.
 */
public class CreateProjectsListPageController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProjectsListPageController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
		List<Project> list = projectDAO.getListProject();

		request.setAttribute(Constants.KEY_PROJECTS, list);

		jump(Constants.PROJECTS_LIST_PAGE, request, response);
	}
}
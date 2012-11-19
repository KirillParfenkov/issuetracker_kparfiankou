package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;

/**
 * Servlet implementation class InsortUpdateProjectController.
 */
public class InsertUpdateProjectController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUpdateProjectController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
		int projectId = Integer.valueOf(request.getParameter(Constants.KEY_PROJECT_ID));

		Project project = projectDAO.getProject(projectId);

		request.setAttribute(Constants.KEY_PROJECT, project);
		jump(Constants.CREATE_UPDATE_PROJECT_CONTROLLER, request, response);
	}
}
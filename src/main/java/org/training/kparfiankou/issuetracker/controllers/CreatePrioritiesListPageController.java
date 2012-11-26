package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;

/**
 * AbstractController implementation class CreatePrioritiesListPageController.
 */
public class CreatePrioritiesListPageController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePrioritiesListPageController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
		List<Priority> list = priorityDAO.getListPriority();

		request.setAttribute(Constants.KEY_PRIORITIES, list);

		jump(Constants.PRIORITIES_LIST_PAGE, request, response);
	}
}
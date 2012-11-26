package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;

/**
 * AbstractController implementation class CreateUpdatePriorityController.
 */
public class CreateUpdatePriorityController extends AbstractController {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUpdatePriorityController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();

		int typeId = Integer.valueOf(request.getParameter(Constants.KEY_PRIORITY_ID));
		Priority priority = priorityDAO.getPriority(typeId);

		request.setAttribute(Constants.KEY_PRIORITY, priority);
		priorityDAO.close();
		jump(Constants.UPDATE_PRIORITY_PAGE, request, response);
	}
}
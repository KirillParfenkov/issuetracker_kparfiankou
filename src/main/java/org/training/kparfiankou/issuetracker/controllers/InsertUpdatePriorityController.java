package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;

/**
 * AbstractController implementation class InsertUpdatePriorityController.
 */
public class InsertUpdatePriorityController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = null;

	private static final String INFO_UPDATE_PROJECT = "PROJECT was updated.";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUpdatePriorityController() {
        super();
    }

    @Override
    public void init() {
    	logger = Logger.getLogger(InsertUpdatePriorityController.class);
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
		int priorityId = Integer.valueOf(request.getParameter(Constants.KEY_PRIORITY_ID));
		String priorityName = request.getParameter(Constants.KEY_NAME);

		Priority priority = priorityDAO.getPriority(priorityId);
		priority.setName(priorityName);
		priorityDAO.updatePriority(priority);

		logger.info(INFO_UPDATE_PROJECT + " " + priorityName);
		request.setAttribute(Constants.KEY_PRIORITIES, priorityDAO.getListPriority());

		priorityDAO.close();
		jump(Constants.CREATE_PRIORITIES_LIST_PAGE_CONTROLLER, request, response);
	}
}
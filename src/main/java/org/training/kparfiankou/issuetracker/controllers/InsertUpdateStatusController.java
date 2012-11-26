package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.factories.StatusDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;

/**
 * AbstractController implementation class InsertUpdateStatusController.
 */
public class InsertUpdateStatusController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = null;

	private static final String INFO_UPDATE_STATUS = "Status was updated.";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUpdateStatusController() {
        super();
    }

    @Override
    public void init() {
    	logger = Logger.getLogger(InsertUpdateStatusController.class);
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
		int statusId = Integer.valueOf(request.getParameter(Constants.KEY_STATUS_ID));
		String statusName = request.getParameter(Constants.KEY_NAME);

		Status status = statusDAO.getStatus(statusId);
		status.setName(statusName);
		statusDAO.updateStatus(status);

		logger.info(INFO_UPDATE_STATUS + " " + statusName);
		request.setAttribute(Constants.KEY_STATUSES, statusDAO.getListStatus());

		statusDAO.close();
		jump(Constants.CREATE_STATUSES_LIST_PAGE_CONTROLLER, request, response);
	}
}
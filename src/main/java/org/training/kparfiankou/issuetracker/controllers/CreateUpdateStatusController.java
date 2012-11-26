package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.factories.StatusDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;

/**
 * AbstractController implementation class CreateUpdateStatusController.
 */
public class CreateUpdateStatusController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUpdateStatusController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();

		int statusId = Integer.valueOf(request.getParameter(Constants.KEY_STATUS_ID));
		Status status = statusDAO.getStatus(statusId);

		request.setAttribute(Constants.KEY_STATUS, status);
		statusDAO.close();
		jump(Constants.UPDATE_STATUS_PAGE, request, response);
	}
}

package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.factories.StatusDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;

/**
 * AbstractController implementation class CreateStatusesListPageController.
 */
public class CreateStatusesListPageController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateStatusesListPageController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
		List<Status> list = statusDAO.getListStatus();

		request.setAttribute(Constants.KEY_STATUSES, list);

		jump(Constants.STATUESES_LIST_PAGE, request, response);
	}
}
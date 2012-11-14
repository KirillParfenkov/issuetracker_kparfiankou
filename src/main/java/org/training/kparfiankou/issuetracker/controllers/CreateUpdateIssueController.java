package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.factories.IssueDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;

/**
 * Servlet implementation class CreateUpdateIssueController.
 */
public class CreateUpdateIssueController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUpdateIssueController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();

		int issueId = Integer.valueOf(request.getParameter(Constants.KEY_ISSUE_ID));
		Issue issue = issueDAO.getIssue(issueId);

		request.setAttribute(Constants.KEY_ISSUE, issue);

		jump(Constants.UPDATE_ISSUE_PAGE, request, response);
	}
}

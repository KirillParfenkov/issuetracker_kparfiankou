package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.training.kparfiankou.issuetracker.Constants;

/**
 * AbstractController implementation class InsetUpdateIssueController.
 */
public class InsetUpdateIssueController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = null;

	private static final String INFO_UPDATE_ISSUE = "Issue was updated.";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsetUpdateIssueController() {
        super();
    }

    @Override
    public void init() {
    	logger = Logger.getLogger(InsetUpdateIssueController.class);
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		jump(Constants.MAIN_PAGE, request, response);
	}
}

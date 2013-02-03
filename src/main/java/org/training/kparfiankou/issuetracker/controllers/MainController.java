package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.ConstantsJSP;
import org.training.kparfiankou.issuetracker.Converter;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.factories.IssueDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;


/**
 * Servlet implementation class MainController.
 */
public class MainController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static final int MAX_COUTN_RECORD = 10;
	private static Logger logger = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
    }

    @Override
    public void init() {
    	logger = Logger.getLogger(LoginController.class);
    	Converter.deliver();
    }

    @Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();
		List<Issue> issues = issueDAO.getListIssue(); // think

		request.setAttribute(ConstantsJSP.KEY_JSP_ISSUES, issues);
		jump(Constants.MAIN_PAGE, request, response);


		request.removeAttribute(Constants.KEY_ERROR_MESAGE);
	}
}

package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 * Servlet implementation class LoginController.
 */
public class LoginController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = null;

	private static final String INFO_USER_CONNECT = "User connection.";
	private static final String INFO_RESULT_SUCCESS = "The result is a success.";
	private static final String INFO_RESULT_FAILURE = "The result is a failure.";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

    @Override
    public void init() {
    	logger = Logger.getLogger(LoginController.class);
    }

    @Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String emailAddres = request.getParameter(Constants.KEY_INPUT_EMAIL);
		String password = request.getParameter(Constants.KEY_INPUT_PASSWORD);

		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
		User user = userDAO.authenticate(emailAddres, password);

		MDC.put(Constants.KEY_SETVER_CONTEXT, emailAddres);

		if (user == null) {

			request.setAttribute(Constants.KEY_ERROR_MESAGE, new String("Logon failure"));
			logger.info(INFO_USER_CONNECT + " " + INFO_RESULT_FAILURE);

		} else {

			session.setAttribute(Constants.KEY_USER, user);
			logger.info(INFO_USER_CONNECT + " " + INFO_RESULT_SUCCESS);
		}

		jump(Constants.MAIN_CONTROLLER, request, response);


	}
}
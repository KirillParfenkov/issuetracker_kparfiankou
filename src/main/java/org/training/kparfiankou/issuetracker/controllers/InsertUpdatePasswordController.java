package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 * AbstractController implementation class InsertUpdatePasswordController.
 */
public class InsertUpdatePasswordController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = null;

	private static final String INFO_PASSWORD_UPDATE = "Update password.";
	private static final String INFO_RESULT_SUCCESS = "The result is a success.";
	private static final String INFO_RESULT_FAILURE = "The result is a failure.";
	private static final String ERROR_MESSAGE = "Passwords do not match";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUpdatePasswordController() {
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

		User user = (User) session.getAttribute(Constants.KEY_USER);
		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

		String  newPassword = request.getParameter(Constants.KEY_INPUT_PASSWORD);
		String  conPassword = request.getParameter(Constants.KEY_INPUT_CON_PASSWORD);

		if ((newPassword != null) && (conPassword != null) && (newPassword.equals(conPassword))) {

			userDAO.newPassword(user.getId(), newPassword);
			logger.info(INFO_PASSWORD_UPDATE + " " + INFO_RESULT_SUCCESS);
			jump(Constants.CREATE_PROFILE_PAGE_CONTROLLER, request, response);

		} else {

			request.setAttribute(Constants.KEY_ERROR_MESAGE, ERROR_MESSAGE);
			logger.info(INFO_PASSWORD_UPDATE + " " + INFO_RESULT_FAILURE);
			jump(Constants.UPDATE_PASSWORD_PAGE, request, response);
		}
	}
}
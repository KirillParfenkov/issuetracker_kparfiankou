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
 * AbstractController implementation class UpdateProfileController.
 */
public class UpdateProfileController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = null;

	private static final String ERROR_NOT_FILLED = "All fields must be filled";
	private static final String INFO_USER_UPDATE = "User update.";
	private static final String INFO_RESULT_SUCCESS = "The result is a success.";
	private static final String INFO_RESULT_FAILURE = "The result is a failure.";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileController() {
        super();
    }

    @Override
    public void init() {
    	logger = Logger.getLogger(LoginController.class);
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.KEY_USER);

		String firstName = request.getParameter(Constants.KEY_INPUT_FIRST_NAME);
		String lastName = request.getParameter(Constants.KEY_INPUT_LAST_NAME);
		String email = request.getParameter(Constants.KEY_INPUT_EMAIL);

		if ((user != null) && (firstName != null) && !(firstName.trim()).isEmpty()
		   && (lastName != null) && !(lastName.trim()).isEmpty()
		   && (email != null) && !(email.trim()).isEmpty()) {

			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmailAddress(email);
			userDAO.updateUser(user);

			logger.info(INFO_USER_UPDATE + " " + INFO_RESULT_SUCCESS);
			request.removeAttribute(Constants.KEY_ERROR_MESAGE);

		} else {
			request.setAttribute(Constants.KEY_ERROR_MESAGE, ERROR_NOT_FILLED);
			logger.info(INFO_USER_UPDATE + " " + INFO_RESULT_FAILURE);
		}

		if (user != null) {
			jump(Constants.PROFILE_PAGE, request, response);
			request.removeAttribute(Constants.KEY_ERROR_MESAGE);
		} else {
			jump(Constants.MAIN_CONTROLLER, request, response);
		}
	}
}
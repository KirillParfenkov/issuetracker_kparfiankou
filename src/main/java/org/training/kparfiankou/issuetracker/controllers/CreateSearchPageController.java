package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 * AbstractController implementation class CreateSearchPageController.
 */
public class CreateSearchPageController extends AbstractController {
	private static final long serialVersionUID = 1L;
	private static final String ERROR_NOT_FILLED = "No field is not filled";
	private static final String INFO_EMPTY = "Nothing is found by satisfying the specified criteria";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSearchPageController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter(Constants.KEY_INPUT_FIRST_NAME);
		String lastName = request.getParameter(Constants.KEY_INPUT_LAST_NAME);
		String email = request.getParameter(Constants.KEY_INPUT_EMAIL);

		Map<String, String> map = new HashMap<String, String>();
		List<User> users = null;

		if ((firstName != null) && !(firstName.trim()).isEmpty()) {
			map.put(Constants.KEY_INPUT_FIRST_NAME, firstName);
		}
		if ((lastName != null) && !(lastName.trim()).isEmpty()) {
			map.put(Constants.KEY_INPUT_LAST_NAME, lastName);
		}
		if ((email != null) && !(email.trim()).isEmpty()) {
			map.put(Constants.KEY_INPUT_EMAIL, email);
		}

		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
		users = userDAO.searchUsers(map);

		if (users.isEmpty()) {
			request.setAttribute(Constants.KEY_INFO_MESAGE, INFO_EMPTY);
		} else {
			request.setAttribute(Constants.KEY_USERS, users);
			request.removeAttribute(Constants.KEY_INFO_MESAGE);
		}
		userDAO.close();
		request.removeAttribute(Constants.KEY_ERROR_MESAGE);

		jump(Constants.SEARCH_PAGE, request, response);
	}
}
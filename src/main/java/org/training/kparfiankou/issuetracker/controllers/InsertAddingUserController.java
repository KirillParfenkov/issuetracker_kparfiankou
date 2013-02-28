package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Role;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.dao.IUserDAO;

/**
 * AbstractController implementation class InsertAddingUserController.
 */
public class InsertAddingUserController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAddingUserController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

		String firstName = request.getParameter(Constants.KEY_INPUT_FIRST_NAME);
		String lastName = request.getParameter(Constants.KEY_INPUT_LAST_NAME);
		String email = request.getParameter(Constants.KEY_INPUT_EMAIL);
		Role role = Role.valueOf(request.getParameter(Constants.KEY_INPUT_ROLE));
		String password	= request.getParameter(Constants.KEY_INPUT_PASSWORD);
		String conPassword = request.getParameter(Constants.KEY_INPUT_CON_PASSWORD);
		long maxId = userDAO.getMaxIndex();

		// Some checks

		User user = new User(++maxId, firstName, lastName, email, role);
		userDAO.insertUser(user, password);

		userDAO.close();

		jump(Constants.ADMINISTRATION_PAGE, request, response);
	}
}
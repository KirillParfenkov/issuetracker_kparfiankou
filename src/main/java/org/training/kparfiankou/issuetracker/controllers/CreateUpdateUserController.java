package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.dao.IUserDAO;

/**
 * AbstractController implementation class CreateUpdateUserController.
 */
public class CreateUpdateUserController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUpdateUserController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

		int userId = Integer.valueOf(request.getParameter(Constants.KEY_USER_ID));
		User user = userDAO.getUser(userId);

		request.setAttribute(Constants.KEY_UPDATE_USER, user);

		userDAO.close();
		jump(Constants.UPDATE_USER_PAGE, request, response);
	}
}
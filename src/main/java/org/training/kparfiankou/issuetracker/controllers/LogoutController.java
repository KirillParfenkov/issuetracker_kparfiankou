package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.kparfiankou.issuetracker.Constants;

/**
 * Servlet implementation class LogoutController.
 */
public class LogoutController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();

    }

    @Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.removeAttribute(Constants.KEY_USER);

		response.sendRedirect(request.getContextPath() + Constants.MAIN_CONTROLLER);

	}
}
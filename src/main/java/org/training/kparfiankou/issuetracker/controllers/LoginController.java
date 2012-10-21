package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends AbstractController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();	
		String emailAddres = request.getParameter(Constants.KEY_INPUT_EMAIL);
		String password = request.getParameter(Constants.KEY_INPUT_PASSWORD);
		
		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
		
		User user = userDAO.authenticate(emailAddres, password);
		
		if (user == null){
			request.setAttribute(Constants.KEY_ERROR_MESAGE,new String("Logon failure"));
		}
		else{
			session.setAttribute(Constants.KEY_USER, user);
		}
		
		jump(Constants.JUMO_MAIN_CONTROLLER, request, response);
		
	}
}

package org.training.kparfiankou.issuetracker.controllers;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 10.02.13
 * Time: 3:20
 */
public class CreateAddingProjectPageController extends AbstractController {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAddingProjectPageController() {
        super();
    }

    @Override
    protected void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
        List<User> users = userDAO.getListUser();
        request.setAttribute(Constants.USERS, users);

        jump(Constants.ADDING_PROJECT_PAGE , request, response);
    }
}

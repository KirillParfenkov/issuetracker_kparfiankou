package org.training.kparfiankou.issuetracker.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/26/13
 * Time: 4:12 PM
 */
@Controller
public class AuthorizationController {

    private static Logger logger = null;

    private static final String INFO_USER_CONNECT = "User connection.";
    private static final String INFO_RESULT_SUCCESS = "The result is a success.";
    private static final String INFO_RESULT_FAILURE = "The result is a failure.";

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(LoginController.class);
    }

    @RequestMapping(value = "/LoginController.cont", method = {RequestMethod.GET, RequestMethod.POST})
    public String performLogin(HttpServletRequest request,
                               @RequestParam(Constants.KEY_INPUT_EMAIL) String emailAddress,
                               @RequestParam(Constants.KEY_INPUT_PASSWORD) String password,
                               Model uiModel) {


        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
        User user = userDAO.authenticate(emailAddress, password);

        if (user == null) {

            uiModel.addAttribute(Constants.KEY_ERROR_MESAGE, new String("Login failure"));
            logger.info(INFO_USER_CONNECT + " " + INFO_RESULT_FAILURE);

        } else {

            request.getSession().setAttribute(Constants.KEY_USER, user);
            logger.info(INFO_USER_CONNECT + " " + INFO_RESULT_SUCCESS);
        }

        userDAO.close();
        return Constants.MAIN_CONTROLLER;
    }

    @RequestMapping(value = "/LogoutController.cont", method = {RequestMethod.GET, RequestMethod.POST})
    public String performLogout(HttpServletRequest request,  Model uiModel) {

        request.getSession().removeAttribute(Constants.KEY_USER);
        return Constants.MAIN_CONTROLLER;
    }
}
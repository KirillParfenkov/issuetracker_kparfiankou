package org.training.kparfiankou.issuetracker.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Role;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.dao.IUserDAO;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 7:01 PM
 */
@Controller
public class UserPageController {

    private static Logger logger = null;

    private static final String ERROR_NOT_FILLED = "All fields must be filled";
    private static final String INFO_USER_UPDATE = "User update.";
    private static final String INFO_RESULT_SUCCESS = "The result is a success.";
    private static final String INFO_RESULT_FAILURE = "The result is a failure.";
    private static final String INFO_PASSWORD_UPDATE = "Update password.";
    private static final String ERROR_MESSAGE = "Passwords do not match";

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(AuthorizationController.class);
    }

    @RequestMapping(value = Constants.CREATE_UPDATE_USER_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createUpdateUserController(HttpServletRequest request,
                                             @RequestParam(Constants.KEY_USER_ID) int userId) {

        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

        User user = userDAO.getUser(userId);

        request.setAttribute(Constants.KEY_UPDATE_USER, user);

        userDAO.close();
        return  Constants.UPDATE_USER_PAGE;
    }

    @RequestMapping(value = Constants.INSERT_UPDATE_USER_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String insertUpdateUserController(HttpServletRequest request,
                                             @RequestParam(Constants.KEY_UPDATE_USER_ID)  int userId,
                                             @RequestParam(Constants.KEY_INPUT_FIRST_NAME)  String firstName,
                                             @RequestParam(Constants.KEY_INPUT_LAST_NAME)  String lastName,
                                             @RequestParam(Constants.KEY_INPUT_EMAIL)  String email,
                                             @RequestParam(Constants.KEY_INPUT_ROLE)  Role role) {

        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
        User user = userDAO.getUser(userId);

        if ((user != null) && (firstName != null) && !(firstName.trim()).isEmpty()
                && (lastName != null) && !(lastName.trim()).isEmpty()
                && (email != null) && !(email.trim()).isEmpty()) {

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmailAddress(email);
            user.setRole(role);
            userDAO.updateUser(user);

            logger.info(INFO_USER_UPDATE + " " + INFO_RESULT_SUCCESS);
            request.removeAttribute(Constants.KEY_ERROR_MESAGE);

        } else {
            request.setAttribute(Constants.KEY_ERROR_MESAGE, ERROR_NOT_FILLED);
            logger.info(INFO_USER_UPDATE + " " + INFO_RESULT_FAILURE);
        }

        if (user != null) {
            request.removeAttribute(Constants.KEY_ERROR_MESAGE);
            return Constants.CREATE_SEARCH_PAGE_CONTROLLER;
        } else {
            return Constants.MAIN_CONTROLLER;
        }
    }

    @RequestMapping(value = Constants.INSERT_ADDING_USER_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String insertAddingUserController(HttpServletRequest request,
                                             @RequestParam(Constants.KEY_UPDATE_USER_ID)  int userId,
                                             @RequestParam(Constants.KEY_INPUT_FIRST_NAME)  String firstName,
                                             @RequestParam(Constants.KEY_INPUT_LAST_NAME)  String lastName,
                                             @RequestParam(Constants.KEY_INPUT_EMAIL)  String email,
                                             @RequestParam(Constants.KEY_INPUT_ROLE)  Role role,
                                             @RequestParam(Constants.KEY_INPUT_PASSWORD)  String password,
                                             @RequestParam(Constants.KEY_INPUT_CON_PASSWORD)  String conPassword) {

        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
        long maxId = userDAO.getMaxIndex();

        // Some checks

        User user = new User(++maxId, firstName, lastName, email, role);
        userDAO.insertUser(user, password);

        userDAO.close();

        return Constants.ADMINISTRATION_PAGE;
    }

    @RequestMapping(value = Constants.INSERT_UPDATE_PASSWORD_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String insertUpdatePasswordController(HttpServletRequest request,
                                                 @RequestParam(Constants.KEY_INPUT_PASSWORD) String  newPassword,
                                                 @RequestParam(Constants.KEY_INPUT_CON_PASSWORD) String  conPassword){

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute(Constants.KEY_USER);
        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

        if ((newPassword != null) && (conPassword != null) && (newPassword.equals(conPassword))) {

            userDAO.newPassword(user.getId(), newPassword);
            logger.info(INFO_PASSWORD_UPDATE + " " + INFO_RESULT_SUCCESS);
            return Constants.CREATE_PROFILE_PAGE_CONTROLLER;

        } else {

            request.setAttribute(Constants.KEY_ERROR_MESAGE, ERROR_MESSAGE);
            logger.info(INFO_PASSWORD_UPDATE + " " + INFO_RESULT_FAILURE);
            return  Constants.UPDATE_PASSWORD_PAGE;
        }
    }
}

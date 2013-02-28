package org.training.kparfiankou.issuetracker.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.kparfiankou.issuetracker.Constants;
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
 * Time: 5:39 PM
 */
@Controller
public class ProfilePageController {

    private static Logger logger = null;

    private static final String ERROR_NOT_FILLED = "All fields must be filled";
    private static final String INFO_USER_UPDATE = "User update.";
    private static final String INFO_RESULT_SUCCESS = "The result is a success.";
    private static final String INFO_RESULT_FAILURE = "The result is a failure.";

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(StatusPageController.class);
    }

    @RequestMapping(value = Constants.CREATE_PROFILE_PAGE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createProfilePageController() {

        return Constants.PROFILE_PAGE;
    }

    @RequestMapping(value = Constants.UPDATE_PROFILE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String updateProfileController(HttpServletRequest request,
                                          @RequestParam(Constants.KEY_INPUT_FIRST_NAME) String firstName,
                                          @RequestParam(Constants.KEY_INPUT_LAST_NAME) String lastName,
                                          @RequestParam(Constants.KEY_INPUT_EMAIL) String email) {

        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.KEY_USER);

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
            request.removeAttribute(Constants.KEY_ERROR_MESAGE);
            return Constants.PROFILE_PAGE;
        } else {
            return Constants.MAIN_CONTROLLER;
        }
    }
}
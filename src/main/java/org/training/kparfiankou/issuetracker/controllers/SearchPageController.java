package org.training.kparfiankou.issuetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.dao.IUserDAO;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 5:45 PM
 */
@Controller
public class SearchPageController {

    private static final String ERROR_NOT_FILLED = "No field is not filled";
    private static final String INFO_EMPTY = "Nothing is found by satisfying the specified criteria";


    @RequestMapping(value = Constants.CREATE_SEARCH_PAGE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createSearchPageController(HttpServletRequest request,
                                             Model uiModel,
                                             @RequestParam(Constants.KEY_INPUT_FIRST_NAME) String firstName,
                                             @RequestParam(Constants.KEY_INPUT_LAST_NAME) String lastName,
                                             @RequestParam(Constants.KEY_INPUT_EMAIL) String email) {

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
            uiModel.addAttribute(Constants.KEY_INFO_MESAGE, INFO_EMPTY);
        } else {
            uiModel.addAttribute(Constants.KEY_USERS, users);
            request.removeAttribute(Constants.KEY_INFO_MESAGE);
        }
        userDAO.close();
        request.removeAttribute(Constants.KEY_ERROR_MESAGE);

        return Constants.MAIN_CONTROLLER;
    }
}

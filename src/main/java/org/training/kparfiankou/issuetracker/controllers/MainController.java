package org.training.kparfiankou.issuetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.ConstantsJSP;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.factories.IssueDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/26/13
 * Time: 3:56 PM
 */
@RequestMapping(Constants.MAIN_CONTROLLER)
@Controller
public class MainController {

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET} )
    public String perform(Model uiModel) {
        IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();
        List<Issue> issues = issueDAO.getListIssue(); // think


        uiModel.addAttribute(ConstantsJSP.KEY_JSP_ISSUES, issues);

        return Constants.MAIN_PAGE;
    }
}

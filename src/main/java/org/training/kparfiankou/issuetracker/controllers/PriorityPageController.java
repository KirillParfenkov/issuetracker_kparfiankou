package org.training.kparfiankou.issuetracker.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 3:36 PM
 */
@Controller
public class PriorityPageController {

    private static Logger logger = null;

    private static final String INFO_UPDATE_PROJECT = "PROJECT was updated.";

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(LoginController.class);
    }

    @RequestMapping(value = Constants.CREATE_PRIORITIES_LIST_PAGE_CONTROLLER,
            method = {RequestMethod.GET, RequestMethod.POST})
    public String createPrioritiesListPageController(Model uiModel) {

        IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
        List<Priority> list = priorityDAO.getListPriority();

        uiModel.addAttribute(Constants.KEY_PRIORITIES, list);

        return Constants.PRIORITIES_LIST_PAGE;
    }

    @RequestMapping(value = Constants.CREATE_UPDATE_PRIORITY_CONTROLLER,
            method = {RequestMethod.GET, RequestMethod.POST})
    public String createUpdatePriorityController(@RequestParam(Constants.KEY_PRIORITY_ID) int priorityId,
                                                   Model model) {

        IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
        Priority priority = priorityDAO.getPriority(priorityId);

        model.addAttribute(Constants.KEY_PRIORITY, priority);
        priorityDAO.close();

        return Constants.UPDATE_PRIORITY_PAGE;
    }

    @RequestMapping(value = Constants.INSERT_UPDATE_PRIORITY_CONTROLLER,
            method = {RequestMethod.GET, RequestMethod.POST})
    public String InsertUpdatePriorityController(@RequestParam(Constants.KEY_PRIORITY_ID) int priorityId,
                                                 @RequestParam(Constants.KEY_NAME) String priorityName,
                                                 Model model) {

        IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();

        Priority priority = priorityDAO.getPriority(priorityId);
        priority.setName(priorityName);
        priorityDAO.updatePriority(priority);

        logger.info(INFO_UPDATE_PROJECT + " " + priorityName);
        model.addAttribute(Constants.KEY_PRIORITIES, priorityDAO.getListPriority());

        priorityDAO.close();

        return Constants.CREATE_PRIORITIES_LIST_PAGE_CONTROLLER;
    }
}

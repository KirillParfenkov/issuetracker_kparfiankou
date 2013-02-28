package org.training.kparfiankou.issuetracker.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.factories.StatusDAOFactory;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.dao.IStatusDAO;
import org.training.kparfiankou.issuetracker.dao.ITypeDAO;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 4:38 PM
 */
@Controller
public class StatusPageController {

    private static Logger logger = null;

    private static final String INFO_UPDATE_STATUS = "Status was updated.";

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(StatusPageController.class);
    }

    @RequestMapping(value = Constants.CREATE_STATUSES_LIST_PAGE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createStatusesListPageController(Model uiModel) {

        ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
        List<Type> list = typeDAO.getListType();

        uiModel.addAttribute(Constants.KEY_TYPES, list);

        return Constants.TYPES_LIST_PAGE;
    }

    @RequestMapping(value = Constants.CREATE_UPDATE_STATUS_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createUpdateStatusController(@RequestParam(Constants.KEY_STATUS_ID) int statusId,
                                               Model uiModel) {

        IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
        Status status = statusDAO.getStatus(statusId);

        uiModel.addAttribute(Constants.KEY_STATUS, status);
        statusDAO.close();
        return Constants.UPDATE_STATUS_PAGE;
    }

    @RequestMapping(value = Constants.INSERT_UPDATE_STATUS_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String InsertUpdateStatusController(@RequestParam(Constants.KEY_STATUS_ID) int statusId,
                                             @RequestParam(Constants.KEY_NAME) String statusName,
                                             Model uiModel) {

        IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();

        Status status = statusDAO.getStatus(statusId);
        status.setName(statusName);
        statusDAO.updateStatus(status);

        logger.info(INFO_UPDATE_STATUS + " " + statusName);
        uiModel.addAttribute(Constants.KEY_STATUSES, statusDAO.getListStatus());

        statusDAO.close();

        return Constants.CREATE_STATUSES_LIST_PAGE_CONTROLLER;
    }
}
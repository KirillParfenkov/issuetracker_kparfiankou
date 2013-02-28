package org.training.kparfiankou.issuetracker.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 3:54 PM
 */
@Controller
public class TypePageController {

    private static Logger logger = null;

    private static final String INFO_UPDATE_TYPE = "Type was updated.";

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(TypePageController.class);
    }

    @RequestMapping(value = Constants.CREATE_TYPES_LIST_PAGE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createTypesListPageController(Model uiModel) {

        ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
        List<Type> list = typeDAO.getListType();

        uiModel.addAttribute(Constants.KEY_TYPES, list);

        return Constants.TYPES_LIST_PAGE;
    }

    @RequestMapping(value = Constants.CREATE_UPDATE_TYPE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createUpdateTypeController(@RequestParam(Constants.KEY_TYPE_ID) int typeId,
                                             Model uiModel) {

        ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();

        Type type = typeDAO.getType(typeId);

        uiModel.addAttribute(Constants.KEY_TYPE, type);
        typeDAO.close();

        return Constants.UPDATE_TYPE_PAGE;
    }

    @RequestMapping(value = Constants.INSERT_UPDATE_TYPE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String InsertUpdateTypeController(@RequestParam(Constants.KEY_TYPE_ID) int typeId,
                                             @RequestParam(Constants.KEY_NAME) String typeName,
                                             Model uiModel) {

        ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();

        Type type = typeDAO.getType(typeId);
        type.setName(typeName);
        typeDAO.updateType(type);

        logger.info(INFO_UPDATE_TYPE + " " + typeName);
        uiModel.addAttribute(Constants.KEY_TYPES, typeDAO.getListType());

        typeDAO.close();
        return Constants.CREATE_TYPES_LIST_PAGE_CONTROLLER;
    }
}
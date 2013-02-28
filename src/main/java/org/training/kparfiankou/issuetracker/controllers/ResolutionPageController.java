package org.training.kparfiankou.issuetracker.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.dao.IResolutionDAO;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 2:24 PM
 */
@Controller
public class ResolutionPageController {

    private static Logger logger = null;

    private static final String INFO_UPDATE_STATUS = "Status was updated.";

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(ResolutionPageController.class);
    }

    @RequestMapping(value = Constants.CREATE_RESOLUTIONS_LIST_PAGE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createResolutionsListPageController(Model uiModel) {

        IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
        List<Resolution> list = resolutionDAO.getListResolution();

        uiModel.addAttribute(Constants.KEY_RESOLUTIONS, list);

        return Constants.RESOLUTIONS_LIST_PAGE;
    }

    @RequestMapping(value = Constants.CREATE_UPDATE_RESOLUTION_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createUpdateResolutionController(@RequestParam(Constants.KEY_RESOLUTION_ID) int resolutionId,
                                                   Model model) {

        IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
        Resolution resolution = resolutionDAO.getResolution(resolutionId);

        model.addAttribute(Constants.KEY_RESOLUTION, resolution);
        resolutionDAO.close();

        return Constants.UPDATE_RESOLUTION_PAGE;
    }

    @RequestMapping(value = Constants.INSERT_UPDATE_RESOLUTION_CONTROLLER,
            method = {RequestMethod.GET, RequestMethod.POST})
    public String insertUpdateResolutionController(@RequestParam(Constants.KEY_RESOLUTION_ID) int resolutionId,
                                                   @RequestParam(Constants.KEY_NAME) String resolutionName,
                                                   Model model) {

        IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
        Resolution resolution = resolutionDAO.getResolution(resolutionId);
        resolution.setName(resolutionName);
        resolutionDAO.updateResolution(resolution);

        logger.info(INFO_UPDATE_STATUS + " " + resolutionName);

        model.addAttribute(Constants.KEY_RESOLUTIONS, resolutionDAO.getListResolution());

        resolutionDAO.close();

        return Constants.CREATE_RESOLUTIONS_LIST_PAGE_CONTROLLER;
    }
}
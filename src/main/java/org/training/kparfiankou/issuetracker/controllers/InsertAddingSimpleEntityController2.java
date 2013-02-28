package org.training.kparfiankou.issuetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.kparfiankou.issuetracker.ClassEntity;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 4:08 PM
 */
@Controller
public class InsertAddingSimpleEntityController2 {

    @RequestMapping(value = Constants.INSERT_ADDING_SIMPLE_ENTITY_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String insertAddingSimpleEntity(@RequestParam(Constants.KEY_TYPE_ENTITY) ClassEntity entity,
                                           @RequestParam(Constants.KEY_NAME) String name,
                                           Model uiModel) {

        ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
        IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
        IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
        long maxId;

        if (ClassEntity.TYPE.equals(entity)) {
            maxId = typeDAO.getMaxIndex();
            typeDAO.insertType(new Type(++maxId, name));
        }

        if (ClassEntity.PRIORITY.equals(entity)) {
            maxId = priorityDAO.getMaxIndex();
            priorityDAO.insertPriority(new Priority(++maxId, name));
        }

        if (ClassEntity.RESOLUTION.equals(entity)) {
            maxId = resolutionDAO.getMaxIndex();
            resolutionDAO.insertResolution(new Resolution(++maxId, name));
        }

        typeDAO.close();
        resolutionDAO.close();
        priorityDAO.close();

        return Constants.ADMINISTRATION_PAGE;
    }
}

package org.training.kparfiankou.issuetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Build;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.dao.IProjectDAO;
import org.training.kparfiankou.issuetracker.dao.IUserDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 2:01 PM
 */
@Controller
public class ProjectPageController {

    @RequestMapping(value = Constants.CREATE_PROJECTS_LIST_PAGE_CONTROLLER, method = {RequestMethod.GET, RequestMethod.POST})
    public String createProjectListPageController(Model uiModel) {
        IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
        List<Project> list = projectDAO.getListProject();

        uiModel.addAttribute(Constants.KEY_PROJECTS, list);
        return Constants.PROJECTS_LIST_PAGE;
    }

    @RequestMapping(value = Constants.CREATE_ADDING_PROJECT_PAGE_CONTROLLER, method = {RequestMethod.GET, RequestMethod.POST})
    public String createAddingProjectPageController(Model uiModel) {

        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
        List<User> users = userDAO.getListUser();
        uiModel.addAttribute(Constants.USERS, users);

        return Constants.ADDING_PROJECT_PAGE;
    }

    @RequestMapping(value = Constants.INSERT_ADDING_PROJECT_CONTROLLER, method = {RequestMethod.GET, RequestMethod.POST})
    public String insertAddingProjectController(@RequestParam(Constants.KEY_NAME) String name,
                                                @RequestParam(Constants.KEY_DESCRIPTION) String description,
                                                @RequestParam(Constants.KEY_BUILD) String nameBuild,
                                                @RequestParam(Constants.KEY_MANAGER) long managerId) {

        IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

        User manager = userDAO.getUser(managerId);

        Build build = new Build();
        build.setName(nameBuild);
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        project.addBuild(build);
        project.setManager(manager);

        projectDAO.insertProject(project);

        return Constants.ADMINISTRATION_PAGE;
    }
}
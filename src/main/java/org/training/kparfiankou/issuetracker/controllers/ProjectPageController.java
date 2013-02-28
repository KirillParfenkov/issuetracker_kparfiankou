package org.training.kparfiankou.issuetracker.controllers;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 2:01 PM
 */
@Controller
public class ProjectPageController {

    private static Logger logger = null;
    private static long NEW_BUILD = 0;

    private static final String INFO_UPDATE_PROJECT = "PROJECT was updated.";

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(StatusPageController.class);
    }

    @RequestMapping(value = Constants.CREATE_PROJECTS_LIST_PAGE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createProjectListPageController(Model uiModel) {
        IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
        List<Project> list = projectDAO.getListProject();

        uiModel.addAttribute(Constants.KEY_PROJECTS, list);
        return Constants.PROJECTS_LIST_PAGE;
    }

    @RequestMapping(value = Constants.CREATE_ADDING_PROJECT_PAGE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createAddingProjectPageController(Model uiModel) {

        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
        List<User> users = userDAO.getListUser();
        uiModel.addAttribute(Constants.USERS, users);

        return Constants.ADDING_PROJECT_PAGE;
    }

    @RequestMapping(value = Constants.INSERT_ADDING_PROJECT_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
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

    @RequestMapping(value = Constants.INSERT_UPDATE_PROJECT_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String insertUpdateProjectController(@RequestParam(Constants.KEY_PROJECT_ID) int projectId,
                                                @RequestParam(Constants.KEY_BUILDS) int strBuilds) {

        IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();

        List<Build> builds = new ArrayList<Build>();
        JSONArray jsonBuilds = null;

        try {
            jsonBuilds = new JSONArray(strBuilds);
            int size = jsonBuilds.length();
            JSONObject jsonBuild = null;

            for (int i = 0; i < size; i++) {
                jsonBuild = jsonBuilds.getJSONObject(i);
                String text = jsonBuild.getString("text");
                long value = Integer.valueOf(jsonBuild.getString("value"));
                builds.add(new Build(value, text));
            }

        } catch (JSONException e) {
        }

        Project project = projectDAO.getProject(projectId);

        for (Build build: builds) {
            if (build.getId() == NEW_BUILD) {
                projectDAO.insertBuild(build);
            }
        }
        project.setBuilds(builds);
        projectDAO.updateProject(project);

        return Constants.ADMINISTRATION_PAGE;
    }

    @RequestMapping(value = Constants.CREATE_UPDATE_PROJECT_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String CreateUpdateProjectController(Model uiModel,
                                                @RequestParam(Constants.KEY_PROJECT_ID) int projectId) {

        IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty(); // after close all DAO.
        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

        Project project = projectDAO.getProject(projectId);
        List<Build> builds = project.getBuilds();
        List<User> managers = userDAO.getListUser();

        uiModel.addAttribute(Constants.KEY_PROJECT, project);
        uiModel.addAttribute(Constants.MANAGERS, managers);
        uiModel.addAttribute(Constants.KEY_BUILDS, builds);

        projectDAO.close();
        userDAO.close();

        return Constants.UPDATE_PROJECT_PAGE;
    }
}
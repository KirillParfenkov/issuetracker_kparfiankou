package org.training.kparfiankou.issuetracker.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.*;
import org.training.kparfiankou.issuetracker.dao.*;
import org.training.kparfiankou.issuetracker.factories.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl_Parfiankou
 * Date: 2/28/13
 * Time: 6:12 PM
 */
@Controller
@SessionAttributes(Constants.KEY_USER)
public class IssuePageController {

    private static Logger logger = null;

    private static final String INFO_UPDATE_ISSUE = "Issue was updated.";
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(StatusPageController.class);
    }

    @RequestMapping(value = Constants.CREATE_UPDATE_ISSUE_CONTROLLER ,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createUpdateIssueController(Model uiModel,
                                              @RequestParam(Constants.KEY_ISSUE_ID) int issueId) {

        IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();
        IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
        ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
        IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
        IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
        IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();

        List<Status> statuses = statusDAO.getListStatus();
        List<Type> types =  typeDAO.getListType();
        List<Priority> prioritys = priorityDAO.getListPriority();
        List<Project> projects = projectDAO.getListProject();
        List<User> users = userDAO.getListUser();
        List<Resolution> resolutions = resolutionDAO.getListResolution();
        List<Comment> comments = issueDAO.getCommentList(issueId);
        Issue issue = issueDAO.getIssue(issueId);

        uiModel.addAttribute(Constants.STATUSES, statuses);
        uiModel.addAttribute(Constants.TYPES, types);
        uiModel.addAttribute(Constants.PRIORITYS, prioritys);
        uiModel.addAttribute(Constants.PROJECTS, projects);
        uiModel.addAttribute(Constants.USERS, users);
        uiModel.addAttribute(Constants.KEY_ISSUE, issue);
        uiModel.addAttribute(Constants.RESOLUTIONS, resolutions);
        uiModel.addAttribute(Constants.KEY_COMMENTS, comments);

        return Constants.UPDATE_ISSUE_PAGE;
    }

    @RequestMapping(value = Constants.INSERT_UPDATE_ISSUE_CONTROLLER ,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String InsertUpdateIssueController(Model uiModel,
                                              @RequestParam(Constants.KEY_CREATE_DATE) String createDate,
                                              @RequestParam(Constants.KEY_CREATER_ID) int createrId,
                                              @RequestParam(Constants.KEY_MODIFY_DATE) String modifyDate,
                                              @RequestParam(Constants.KEY_MODIFIER_ID) int modifierId,
                                              @RequestParam(Constants.KEY_SUMMARY) String summary,
                                              @RequestParam(Constants.KEY_DESCRIPTION) String description,
                                              @RequestParam(Constants.KEY_STATUS) int statusId,
                                              @RequestParam(Constants.KEY_TYPE) int typeId,
                                              @RequestParam(Constants.KEY_PRIORITY) int priorityId,
                                              @RequestParam(Constants.KEY_SUMMARY) int projectId,
                                              @RequestParam(Constants.KEY_BUILD) int buildId,
                                              @RequestParam(Constants.KEY_ASSIGNEE) int assigneeId,
                                              @RequestParam(Constants.KEY_RESOLUTION) int resolutionId,
                                              @RequestParam(Constants.KEY_ISSUE_ID) int issueId){

        IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();
        IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
        ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
        IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
        IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
        IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
        DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

        try {

            Issue issue = new Issue(issueId);
            issue.setSummary(summary);
            issue.setDescription(description);
            issue.setCreateDate(dateFormat.parse(createDate));
            issue.setCreater(userDAO.getUser(createrId));
            issue.setModifyDate(dateFormat.parse(modifyDate));
            issue.setLastModifier(userDAO.getUser(modifierId));
            issue.setStatus(statusDAO.getStatus(statusId));
            issue.setType(typeDAO.getType(typeId));
            issue.setPriority(priorityDAO.getPriority(priorityId));
            Project project = projectDAO.getProject(projectId);
            issue.setProject(project);
            issue.setBuild(project.getBuild(buildId));
            issue.setResolution(resolutionDAO.getResolution(resolutionId));
            issue.setAssignee(userDAO.getUser(assigneeId));

            issueDAO.updateIssue(issue);

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            issueDAO.close();
            statusDAO.close();
            typeDAO.close();
            priorityDAO.close();
            userDAO.close();
            projectDAO.close();
            resolutionDAO.close();
        }

        return Constants.CREATE_UPDATE_ISSUE_CONTROLLER;
    }

    @RequestMapping(value = Constants.SUBMIT_CREATE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String createSubmitIssueController(Model uiModel) {

        IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
        ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
        IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
        IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

        List<Status> statuses = statusDAO.getListStatus();
        List<Type> types =  typeDAO.getListType();
        List<Priority> prioritys = priorityDAO.getListPriority();
        List<Project> projects = projectDAO.getListProject();
        List<User> users = userDAO.getListUser();

        uiModel.addAttribute(Constants.STATUSES, statuses);
        uiModel.addAttribute(Constants.TYPES, types);
        uiModel.addAttribute(Constants.PRIORITYS, prioritys);
        uiModel.addAttribute(Constants.PROJECTS, projects);
        uiModel.addAttribute(Constants.USERS, users);

        return Constants.SUBMIT_ISSUE_PAGE;
    }


    @RequestMapping(value = Constants.SUBMIT_ISSUE_CONTROLLER,
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String insertSubmitIssueController(HttpServletRequest request,
                                              @ModelAttribute(Constants.KEY_USER) User user,
                                              @RequestParam(Constants.KEY_SUMMARY) String summary,
                                              @RequestParam(Constants.KEY_DESCRIPTION) String description,
                                              @RequestParam(Constants.KEY_STATUS) int statusId,
                                              @RequestParam(Constants.KEY_TYPE) int typeId,
                                              @RequestParam(Constants.KEY_PRIORITY) int priorityId,
                                              @RequestParam(Constants.KEY_SUMMARY) int projectId,
                                              @RequestParam(Constants.KEY_BUILD) int buildId,
                                              @RequestParam(Constants.KEY_ASSIGNEE) int assigneeId) {

        HttpSession session = request.getSession();
        IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();
        IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
        ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
        IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
        IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
        Issue issue = new Issue(issueDAO.getListIssue().size()); //Temporary solution.

        issue.setSummary(summary);
        issue.setDescription(description);
        issue.setStatus(statusDAO.getStatus(statusId));
        issue.setType(typeDAO.getType(typeId));
        issue.setPriority(priorityDAO.getPriority(priorityId));
        Project project = projectDAO.getProject(projectId);
        issue.setProject(project);
        issue.setBuild(project.getBuild(buildId));
        issue.setAssignee(userDAO.getUser(assigneeId));
        issue.setCreateDate(issueDAO.getCurrentDate());
        issue.setCreater(user);
        issue.setModifyDate(issueDAO.getCurrentDate());
        issue.setLastModifier(user);
        issue.setResolution(null);

        issueDAO.insertIssue(issue);

        return Constants.MAIN_CONTROLLER;
    }
}

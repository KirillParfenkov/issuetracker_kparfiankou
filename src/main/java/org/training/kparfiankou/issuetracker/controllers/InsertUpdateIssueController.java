package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.factories.IssueDAOFactory;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.factories.StatusDAOFactory;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.dao.IIssueDAO;
import org.training.kparfiankou.issuetracker.dao.IPriorityDAO;
import org.training.kparfiankou.issuetracker.dao.IProjectDAO;
import org.training.kparfiankou.issuetracker.dao.IResolutionDAO;
import org.training.kparfiankou.issuetracker.dao.IStatusDAO;
import org.training.kparfiankou.issuetracker.dao.ITypeDAO;
import org.training.kparfiankou.issuetracker.dao.IUserDAO;

/**
 * AbstractController implementation class InsetUpdateIssueController.
 */
public class InsertUpdateIssueController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = null;

	private static final String INFO_UPDATE_ISSUE = "Issue was updated.";
	private static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUpdateIssueController() {
        super();
    }

    @Override
    public void init() {
    	logger = Logger.getLogger(InsertUpdateIssueController.class);
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();
		IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
		ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
		IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
		IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
		IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
		DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

		String createDate = request.getParameter(Constants.KEY_CREATE_DATE);
		int createrId = Integer.valueOf(request.getParameter(Constants.KEY_CREATER_ID));
		String modifyDate = request.getParameter(Constants.KEY_MODIFY_DATE);
		int modifierId = Integer.valueOf(request.getParameter(Constants.KEY_MODIFIER_ID));
		String summary = request.getParameter(Constants.KEY_SUMMARY);
		String description = request.getParameter(Constants.KEY_DESCRIPTION);
		int statusId = Integer.valueOf(request.getParameter(Constants.KEY_STATUS));
		int typeId = Integer.valueOf(request.getParameter(Constants.KEY_TYPE));
		int priorityId = Integer.valueOf(request.getParameter(Constants.KEY_PRIORITY));
		int projectId = Integer.valueOf(request.getParameter(Constants.KEY_PROJECT));
		int buildId = 0; // tmp
		int assigneeId = Integer.valueOf(request.getParameter(Constants.KEY_ASSIGNEE));
		int resolutionId = Integer.valueOf(request.getParameter(Constants.KEY_RESOLUTION));
		int issueId = Integer.valueOf(request.getParameter(Constants.KEY_ISSUE_ID));

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

		jump(Constants.CREATE_UPDATE_ISSUE_CONTROLLER, request, response);
	}
}
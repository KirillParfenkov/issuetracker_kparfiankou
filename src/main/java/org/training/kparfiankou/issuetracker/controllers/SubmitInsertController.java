package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.IssueDAOFactory;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.factories.StatusDAOFactory;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 * Servlet implementation class SubmitInsertController.
 */
public class SubmitInsertController extends AbstractController {

	private static final long serialVersionUID = 1L;

    public SubmitInsertController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			                   HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();
		IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
		ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
		IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
		IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
		Issue issue = new Issue(issueDAO.getListIssue().size()); //Temporary solution.

		String summary = request.getParameter(Constants.KEY_SUMMARY);
		String description = request.getParameter(Constants.KEY_DESCRIPTION);
		int statusId = Integer.valueOf(request.getParameter(Constants.KEY_STATUS));
		int typeId = Integer.valueOf(request.getParameter(Constants.KEY_TYPE));
		int priorityId = Integer.valueOf(request.getParameter(Constants.KEY_PRIORITY));
		int projectId = Integer.valueOf(request.getParameter(Constants.KEY_PROJECT));
		int buildId = Integer.valueOf(request.getParameter(Constants.KEY_BUILD));
		int assigneeId = Integer.valueOf(request.getParameter(Constants.KEY_ASSIGNEE));
		User user = (User) session.getAttribute(Constants.KEY_USER);

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

		jump(Constants.MAIN_CONTROLLER , request, response);
	}
}